// ── Diálogo transitório ──────────────────────────────────────────────────────

function exibirDialogoTransitorio(dialogo) {
    preencherConteudoDialogo(dialogo);
    PF('modalNotificacaoTransitoria').show();
}

function preencherConteudoDialogo(dialogo) {
    document.getElementById('notif-assunto').textContent = dialogo.assunto || 'Notificação';
    document.getElementById('notif-meta').textContent = (dialogo.usuarioRemetente && dialogo.usuarioRemetente.nome
            ? dialogo.usuarioRemetente.nome : 'Sistema') + ' • ' + formatarDataHora(dialogo.dataHoraDisparo);
    document.getElementById('notif-mensagem').textContent = dialogo.mensagem || '';

    const footer = document.getElementById('notif-footer');

    if (!dialogo.respostasPossiveis || !dialogo.respostasPossiveis.length) {
        footer.innerHTML = '';
        return;
    }

    const paginaInstanciaID = dialogo.paginaInstanciaID || null;
    const codigoSelo = dialogo.codigoSelo || null;

    // guarda as respostas no escopo global para o botão acessar pelo índice
    window._respostasPossiveis = dialogo.respostasPossiveis;

    footer.innerHTML = dialogo.respostasPossiveis.map(function (r, index) {
        const btn = r.botaoResposta || {};
        const tipo = r.tipoResposta || {};
        const cor = tipo.cor || '#607D8B';
        const icone = tipo.icone || 'fa fa-bell';
        const label = btn.nomeDescricao || tipo.descricao || 'Responder';

        // sem paginaInstanciaID → só fecha o modal
        const acao = paginaInstanciaID
                ? 'enviarResposta(' + btn.id + ', \'' + tipo.fabricaTipoResposta + '\', window._respostasPossiveis[' + index + '], \'' + codigoSelo + '\')'
                : 'PF(\'modalNotificacaoTransitoria\').hide()';

        return '<button class="ui-button"' +
                ' style="background:' + cor + '; color:#fff; border:none; padding:10px 18px;' +
                ' border-radius:4px; cursor:pointer; min-height:44px;"' +
                ' onclick="' + acao + '">' +
                '<i class="' + icone + '" style="margin-right:6px;"></i>' + label +
                '</button>';
    }).join('');
}

function enviarResposta(idBotao, fabricaTipo, respostaObj, codigoDialogo) {
    const params = new URLSearchParams({
        'paginaInstanciaID': CarameloCode.formulario.paginaInstanciaID,
        'dialogoId': codigoDialogo,
        'resposta': JSON.stringify(respostaObj)
    });

    fetch('/notificacoes/dialogo/resposta', {
        method: 'POST',
        credentials: 'include',
        headers: {'Content-Type': 'application/x-www-form-urlencoded'},
        body: params.toString()
    })
            .then(function (res) {
                if (!res.ok)
                    throw new Error('HTTP ' + res.status);
                return res.json();
            })
            .then(function (data) {
                console.log('[CarameloPush] Resposta enviada com sucesso:', data);
                PF('modalNotificacaoTransitoria').hide();
            })
            .catch(function (err) {
                console.error('[CarameloPush] Erro ao enviar resposta:', err);
            });
}

function formatarDataHora(timestamp) {
    if (!timestamp)
        return '';
    return new Date(timestamp).toLocaleString('pt-BR', {
        day: '2-digit', month: '2-digit',
        hour: '2-digit', minute: '2-digit'
    });
}

// ── Filtro de instância ──────────────────────────────────────────────────────

function deveProcessarDialogo(dialogo) {
    if (!dialogo.paginaInstanciaID) {
        return true; // broadcast geral — todas as abas processam
    }
    if (!CarameloCode.formulario.paginaInstanciaID) {
        return false; // página atual não tem instanciaID — ignora push direcionado
    }
    return dialogo.paginaInstanciaID === CarameloCode.formulario.paginaInstanciaID;
}

// ── Handlers por tipo ────────────────────────────────────────────────────────

function executarJavascriptPush(payload) {
    // executa o script se existir
    if (payload.script) {
        try {
            // eval(payload.script); // desativado por enquanto
        } catch (e) {
            console.error('[CarameloPush] Erro ao executar script:', e.message);
        }
    }

    // exibe o diálogo se vier mensagemTransitoria junto
    if (payload.mensagemTransitoria) {
        try {
            const dialogo = JSON.parse(payload.mensagemTransitoria);
            if (!deveProcessarDialogo(dialogo)) {
                console.log('[CarameloPush] ignorado — não é a instância de origem');
                return;
            }
            exibirDialogoTransitorio(dialogo);
        } catch (e) {
            console.error('[CarameloPush] Erro ao parsear mensagemTransitoria:', e.message);
        }
    }
}

function exibirDialogoPush(payload) {
    try {
        const dialogo = JSON.parse(payload.mensagemTransitoria);
        if (!deveProcessarDialogo(dialogo)) {
            console.log('[CarameloPush] ignorado — não é a instância de origem');
            return;
        }
        exibirDialogoTransitorio(dialogo);
    } catch (e) {
        console.error('[CarameloPush] Erro ao parsear mensagemTransitoria:', e.message);
    }
}

// ── Entrada principal do push ────────────────────────────────────────────────

function notificacoesPush(notificacao) {
    try {
        const payload = (typeof notificacao === 'string')
                ? JSON.parse(notificacao)
                : notificacao;

        // ── switch NOVO — homologar um por um ───────────────
        switch (payload.tipo) {
            case 'executarJS':
                executarJavascriptPush(payload);
                break;

            case 'exibirDialogo':
                exibirDialogoPush(payload);
                break;

            case 'atualizarArea':
                tratarAtualizarArea(payload);
                break;

            case 'atualizarCampos':
                tratarAtualizarCampos(payload);
                break;

            case 'atualizarNotificacoes':
                setTimeout(function () {
                    CarameloCode.notificacoes.atualizarMenu();
                }, 3000);
                break;

            default:
                // fallback — se tiver mensagemTransitoria tenta exibir o diálogo
                if (payload.mensagemTransitoria) {
                    exibirDialogoPush(payload);
                } else {
                    console.warn('[CarameloPush] tipo desconhecido: ' + payload.tipo);
                }
        }

    } catch (e) {
        console.error('[CarameloPush] Erro ao processar push:', e.message, '\nDados recebidos:', notificacao);
    }
}

// ── switch LEGADO — referência para homologação ──────────────────────────────
// TODO: migrar cada case para o switch novo acima e remover após homologação
/*
 function notificacoesPushLegado(notificacao) {
 switch (notificacao.tipoPush) {
 case 'ATUALIZAR_AREA':
 tratarAtualizarArea(notificacao);
 break;
 case 'EXIBIR_DIALOGO':
 dialogo = notificacao.dialogo;
 break;
 case 'EXECUTAR_JAVASCRIPT':
 executarJavascriptPush(notificacao);
 break;
 case 'ATUALIZAR_CAMPOS':
 tratarAtualizarCampos(notificacao);
 break;
 case 'VALIDAR_CAMPOS':
 // TODO
 break;
 case 'ATUALIZAR_NOTIFICACOES':
 setTimeout(function () {
 CarameloCode.notificacoes.atualizarMenu();
 }, 3000);
 break;
 default:
 console.warn('[CarameloPush] tipoPush desconhecido: ' + notificacao.tipoPush);
 }
 }
 */