/*
 * Componente janelasNotificacao — notificações de salas de chat.
 *
 * Fluxo:
 *  - Carregamento da página: componente inicia minimizado.
 *  - Push atualiza a raiz "compJanelasNotificacao" (que volta sempre como estadoMinimizado):
 *    o estado guardado em memória é reaplicado e, havendo notificações, a janela é exibida por 5 s
 *    e depois minimizada (a detecção é automática via pfAjaxComplete / jsf.ajax; também pode ser
 *    disparada manualmente com crcJanelasNotificacaoChat.notificacaoRecebida()).
 *  - Se o usuário interagir com a janela durante a exibição automática, ela permanece aberta.
 *  - O modal da sala vive num portal no body: depois de aberto, independe do componente e do push.
 */
var crcJanelasNotificacaoChat = (function ($) {

    var SELETOR_RAIZ = '.crc-comp-janela-chat-notificacoes';
    var SELETOR_AREA = '.notificacoesSalaChat';
    var TEMPO_EXIBICAO_MS = 5000;

    /* Estado mantido em memória: sobrevive às atualizações do push */
    var modo = 'minimizado';          /* minimizado | automatico | maximizado */
    var chaveSelecionada = null;      /* sala aberta na sanfona */
    var timerMinimizar = null;

    function raiz() {
        return $(SELETOR_RAIZ);
    }

    /* ---------- Estados da janela ---------- */

    function aplicarModo(novoModo) {
        modo = novoModo;
        var aberto = modo !== 'minimizado';
        raiz().toggleClass('estadoMaximizado', aberto).toggleClass('estadoMinimizado', !aberto);
    }

    function cancelarTimer() {
        if (timerMinimizar) {
            clearTimeout(timerMinimizar);
            timerMinimizar = null;
        }
    }

    function agendarMinimizar() {
        cancelarTimer();
        timerMinimizar = setTimeout(function () {
            timerMinimizar = null;
            if (modo === 'automatico') {
                aplicarModo('minimizado');
            }
        }, TEMPO_EXIBICAO_MS);
    }

    function maximizar() {
        cancelarTimer();
        aplicarModo('maximizado');
    }

    function minimizar() {
        cancelarTimer();
        aplicarModo('minimizado');
    }

    function exibirTemporariamente() {
        /* Se o usuário já deixou a janela aberta, não minimiza sozinha */
        if (modo === 'maximizado') {
            return;
        }
        aplicarModo('automatico');
        agendarMinimizar();
    }

    /* ---------- Sanfona ---------- */

    function selecionarSala($sala) {
        var $salas = raiz().find('.JanelaSala');
        $salas.removeClass('janelaSelecionada').addClass('janelaNaoSelecionada');
        if ($sala && $sala.length) {
            $sala.removeClass('janelaNaoSelecionada').addClass('janelaSelecionada');
            chaveSelecionada = $sala.attr('data-chave');
        } else {
            chaveSelecionada = null;
        }
    }

    function restaurarSelecao() {
        var $salas = raiz().find('.JanelaSala');
        var $alvo = $salas.filter(function () {
            return $(this).attr('data-chave') === chaveSelecionada;
        });
        selecionarSala($alvo.length ? $alvo.first() : $salas.first());
    }

    /* ---------- Remetente: Gravatar e WhatsApp ---------- */

    function sha256Hex(texto) {
        if (!window.crypto || !window.crypto.subtle || !window.TextEncoder) {
            return Promise.reject(new Error('SubtleCrypto indisponível'));
        }
        return window.crypto.subtle.digest('SHA-256', new TextEncoder().encode(texto)).then(function (buffer) {
            return Array.prototype.map.call(new Uint8Array(buffer), function (b) {
                return ('0' + b.toString(16)).slice(-2);
            }).join('');
        });
    }

    function carregarGravatares($area) {
        $area.find('img.imagemGravatar[data-email]').each(function () {
            var img = this;
            var email = ($(img).attr('data-email') || '').trim().toLowerCase();
            if (!email) {
                return;
            }
            sha256Hex(email).then(function (hash) {
                img.onload = function () {
                    $(img).addClass('gravatarCarregado');
                };
                /* d=404: sem Gravatar cadastrado, mantém o ícone padrão */
                img.src = 'https://www.gravatar.com/avatar/' + hash + '?s=80&d=404';
            })['catch'](function () {
                /* Mantém o ícone padrão */
            });
        });
    }

    function montarLinksWhatsapp($area) {
        $area.find('a.linkWhatsapp[data-telefone]').each(function () {
            var digitos = ($(this).attr('data-telefone') || '').replace(/\D/g, '');
            if (!digitos) {
                return;
            }
            /* Número nacional (DDD + número) sem código do país: assume Brasil */
            if (digitos.length === 10 || digitos.length === 11) {
                digitos = '55' + digitos;
            }
            $(this).attr('href', 'https://wa.me/' + digitos);
        });
    }

    /* ---------- Modal da sala ---------- */

    /*
     * Portal do modal: o modal é clonado uma única vez do <template> do componente para o body,
     * ficando independente do componente e de qualquer atualização dele.
     * Leva a classe raiz para continuar sendo encontrado por raiz() e estilizado pelo chat.css.
     * Se o componente for renderizado de novo, o portal existente é mantido (não duplica nem fecha o modal aberto).
     */
    function montarPortalModalSala() {
        if ($('body > .portalModalSalaChat').length) {
            return;
        }
        var modelo = $('template.modeloModalSalaChat').get(0);
        if (!modelo || !modelo.content) {
            return;
        }
        var $portal = $('<div class="crc-comp-janela-chat-notificacoes portalModalSalaChat"></div>');
        $portal.append(document.importNode(modelo.content, true));
        $('body').append($portal);
    }

    function modalAberto() {
        return raiz().find('.modalSalaChat').hasClass('modalSalaChatAberto');
    }

    function abrirModal(link, titulo) {
        montarPortalModalSala();
        var $modal = raiz().find('.modalSalaChat');
        $modal.find('.modalSalaChatTitulo').text(titulo || '');
        $modal.find('.modalSalaChatFrame').attr('src', link);
        $modal.addClass('modalSalaChatAberto');
        minimizar();
    }

    function fecharModal() {
        var $modal = raiz().find('.modalSalaChat');
        $modal.removeClass('modalSalaChatAberto');
        $modal.find('.modalSalaChatFrame').attr('src', 'about:blank');
    }

    /* ---------- Inicialização da área atualizada ---------- */

    /* Retorna true se a área foi (re)renderizada desde a última inicialização */
    function inicializarArea() {
        var $area = raiz().find(SELETOR_AREA);
        if (!$area.length || $area.attr('data-inicializado') === 'true') {
            return false;
        }
        $area.attr('data-inicializado', 'true');
        restaurarSelecao();
        carregarGravatares($area);
        montarLinksWhatsapp($area);
        return true;
    }

    function temNotificacoes() {
        return raiz().find(SELETOR_AREA + ' .conteudoNotificacoes').length > 0;
    }

    /* Sincroniza a janela com o conteúdo recém-renderizado pelo push */
    function sincronizarEstado() {
        if (!temNotificacoes()) {
            /* Lista vazia: zera o estado para a próxima notificação ser exibida normalmente */
            minimizar();
            return;
        }
        /* O push recria a raiz com estadoMinimizado: reaplica o modo guardado em memória */
        aplicarModo(modo);
        /* Com o modal aberto o usuário já está atendendo: não exibe a janela por cima */
        if (!modalAberto()) {
            exibirTemporariamente();
        }
    }

    function tratarAtualizacao() {
        montarPortalModalSala();
        if (inicializarArea()) {
            sincronizarEstado();
        }
    }

    /* ---------- Eventos (delegados no document: sobrevivem ao push) ---------- */

    function registrarEventos() {
        $(document)
            .on('click', SELETOR_RAIZ + ' .lancadorNotificacoes', function () {
                maximizar();
            })
            .on('click', SELETOR_RAIZ + ' .botaoMinimizarNotificacoes', function (e) {
                e.stopPropagation();
                minimizar();
            })
            .on('click', SELETOR_RAIZ + ' .janelaNotificacoesChat', function () {
                /* Interagiu durante a exibição automática: mantém aberta */
                if (modo === 'automatico') {
                    maximizar();
                }
            })
            .on('mouseenter', SELETOR_RAIZ + ' .janelaNotificacoesChat', function () {
                if (modo === 'automatico') {
                    cancelarTimer();
                }
            })
            .on('mouseleave', SELETOR_RAIZ + ' .janelaNotificacoesChat', function () {
                if (modo === 'automatico') {
                    agendarMinimizar();
                }
            })
            .on('click', SELETOR_RAIZ + ' .cabecalhoJanela', function () {
                var $sala = $(this).closest('.JanelaSala');
                selecionarSala($sala.hasClass('janelaSelecionada') ? null : $sala);
            })
            .on('click', SELETOR_RAIZ + ' .botaoAbrirModal', function () {
                var $sala = $(this).closest('.JanelaSala');
                abrirModal($sala.attr('data-link'), $sala.attr('data-titulo'));
            })
            .on('click', SELETOR_RAIZ + ' .botaoNovaJanela', function () {
                var link = $(this).closest('.JanelaSala').attr('data-link');
                if (link) {
                    window.open(link, '_blank', 'noopener');
                }
            })
            .on('click', SELETOR_RAIZ + ' .botaoFecharModalSala', fecharModal)
            .on('click', SELETOR_RAIZ + ' .modalSalaChat', function (e) {
                if (e.target === this) {
                    fecharModal();
                }
            })
            .on('keydown', function (e) {
                if (e.key === 'Escape' && modalAberto()) {
                    fecharModal();
                }
            })
            /* Atualizações via PrimeFaces (p:remoteCommand, p:ajax, PrimeFaces.ajax.Request...) */
            .on('pfAjaxComplete', tratarAtualizacao);

        /* Atualizações via f:ajax / jsf.ajax */
        if (window.jsf && jsf.ajax && jsf.ajax.addOnEvent) {
            jsf.ajax.addOnEvent(function (data) {
                if (data.status === 'success') {
                    tratarAtualizacao();
                }
            });
        }
    }

    $(function () {
        registrarEventos();
        montarPortalModalSala();
        inicializarArea();          /* carga inicial: apenas prepara, sem exibir */
        aplicarModo('minimizado');
    });

    /* ---------- API pública ---------- */
    return {
        /* Chamar após o push atualizar o componente, caso a detecção automática não seja suficiente */
        notificacaoRecebida: function () {
            montarPortalModalSala();
            inicializarArea();
            sincronizarEstado();
        },
        maximizar: maximizar,
        minimizar: minimizar,
        abrirSalaModal: abrirModal,
        fecharSalaModal: fecharModal
    };

})(jQuery);
