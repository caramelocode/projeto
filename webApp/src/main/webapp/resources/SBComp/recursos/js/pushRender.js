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

function enviarResposta(idBotao, fabricaTipo, respostaObj, codigoSelo) {
    const params = new URLSearchParams({
        'paginaInstanciaID': CarameloCode.formulario.paginaInstanciaID,
        'codigoSelo': codigoSelo,
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

// ── Diálogo de alerta do push (não depende do PrimeFaces) ───────────────────
// Genérico: título, descrição, nome do botão e ação do botão (string executável).
// Usado, por exemplo, quando a validação de instância falha e a sessão precisa
// ser encerrada com uma tela de bloqueio que funcione mesmo se o PrimeFaces
// já não tiver mais um form/viewState válido para reagir.

function exibirDialogoAlertaPush(titulo, descricao, nomeBotao, acaoBotao) {
    if (document.getElementById('modal-alerta-push'))
        return; // evita duplicar se já estiver visível

    const overlay = document.createElement('div');
    overlay.id = 'modal-alerta-push';
    overlay.style.cssText = 'position:fixed;inset:0;background:rgba(0,0,0,.6);' +
            'z-index:2147483647;display:flex;align-items:center;justify-content:center;' +
            'font-family:Arial,Helvetica,sans-serif;';

    overlay.innerHTML =
            '<div style="background:#fff;max-width:420px;width:90%;border-radius:8px;' +
            'padding:28px;text-align:center;box-shadow:0 10px 40px rgba(0,0,0,.3);">' +
            '<div style="font-size:40px;color:#e53935;margin-bottom:12px;">&#9888;</div>' +
            '<h2 id="modal-alerta-push-titulo" style="margin:0 0 10px;font-size:18px;color:#333;"></h2>' +
            '<p id="modal-alerta-push-descricao" style="margin:0 0 20px;font-size:14px;color:#666;line-height:1.5;white-space:pre-line;"></p>' +
            '<button id="modal-alerta-push-botao" style="background:#607D8B;color:#fff;' +
            'border:none;padding:10px 18px;border-radius:4px;cursor:pointer;min-height:44px;' +
            'font-size:14px;"></button></div>';

    document.body.appendChild(overlay);

    // textContent (em vez de concatenar no innerHTML) evita problemas com
    // aspas/HTML dentro do título e da descrição
    document.getElementById('modal-alerta-push-titulo').textContent = titulo || 'Aviso';
    document.getElementById('modal-alerta-push-descricao').textContent = descricao || '';

    const botao = document.getElementById('modal-alerta-push-botao');
    botao.textContent = nomeBotao || 'OK';
    botao.addEventListener('click', function () {
        try {
            // acaoBotao chega como string (ex.: "location.reload();")
            new Function(acaoBotao)();
        } catch (e) {
            console.error('[CarameloPush] Erro ao executar ação do botão de alerta:', e.message);
        }
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

async function notificacoesPush(pPayloadTexto) {
    try {
        const payload = (typeof pPayloadTexto === 'string')
                ? JSON.parse(pPayloadTexto)
                : pPayloadTexto;

        // ── validação única de instância — antes de processar qualquer tipo ──
        // validarInstancia() já resolve 'true' de imediato (sem chamar o
        // servidor) quando a aba atual não tem paginaInstanciaID, então isso
        // não afeta pushes de broadcast (ex.: ATUALIZAR_NOTIFICACOES).
        if (!await CarameloCode.formulario.validarInstancia()) {
            console.warn('[CarameloPush] instância de formulário expirada — encerrando push');

            if (typeof CarameloPush !== 'undefined' && CarameloPush.isConectado()) {
                CarameloPush.encerrarSessao();
            }

            exibirDialogoAlertaPush(
                    'Sua sessão foi desconectada',
                    'Isso pode acontecer por 3 motivos: 1 -> Sessão expirou, 2 Você fez logoff, 3 abriu muitas abas',
                    'Clique aqui para reiniciar',
                    'location.reload();'
                    );
            return;
        }

        // ── switch NOVO — homologar um por um ───────────────
        switch (payload.tipo) {
            case 'EXECUTAR_JAVASCRIPT':
                executarJavascriptPush(payload);
                break;

            case 'EXIBIR_DIALOGO_TRANSITORIO':
                exibirDialogoPush(payload);
                break;

            case 'ATUALIZAR_AREA':
                try {
                    const areas = JSON.parse(payload.areas || '[]');
                    areas.forEach(function (areaID) {
                        CarameloCode.areaTrabalho.atualizarAreaByID(areaID);
                    });
                } catch (e) {
                    console.error('[CarameloPush] Erro ao processar ATUALIZAR_AREA:', e.message);
                }
                break;

            case 'VALIDAR_CAMPOS':
                try {
                    const campos = JSON.parse(payload.campos || '[]');
                    campos.forEach(function (campo) {
                        CarameloCode.formulario.validarCampo(campo);
                    });
                } catch (e) {
                    console.error('[CarameloPush] Erro ao processar VALIDAR_CAMPOS:', e.message);
                }
                break;

            case 'ATUALIZAR_CAMPOS':
                try {
                    const campos = JSON.parse(payload.campos || '[]');
                    campos.forEach(function (campo) {
                        CarameloCode.formulario.atualizarCampo(campo);
                    });
                } catch (e) {
                    console.error('[CarameloPush] Erro ao processar ATUALIZAR_CAMPOS:', e.message);
                }
                break;

            case 'ATUALIZAR_NOTIFICACOES':
                setTimeout(function () {
                    CarameloCode.notificacoes.atualizarMenu();
                }, 1000);
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
        console.error('[CarameloPush] Erro ao processar push:', e.message, '\nDados recebidos:', pPayloadTexto);
    }
}

