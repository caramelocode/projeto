(function () {
    if (window.crcConsoleProjetoAtalhos) {
        return;
    }
    window.crcConsoleProjetoAtalhos = true;

    function obterWidget(idInput) {
        var idComponente = idInput.replace(/_input$/, '');
        if (PrimeFaces.getWidgetById) {
            return PrimeFaces.getWidgetById(idComponente);
        }
        for (var nome in PrimeFaces.widgets) {
            var w = PrimeFaces.widgets[nome];
            if (w && w.id === idComponente) {
                return w;
            }
        }
        return null;
    }

    function obterNumero(evento) {
        var m = /^(Digit|Numpad)([1-9])$/.exec(evento.code || '');
        return m ? m[2] : null;
    }

    document.addEventListener('keydown', function (evento) {
        /* CTRL + SHIFT + n: aciona a opção de ordem n */
        if (evento.ctrlKey && evento.shiftKey && !evento.altKey) {
            var numero = obterNumero(evento);
            if (numero) {
                var botoes = document.querySelectorAll('.crc-console-projeto-crc__opcao-botao[data-crc-ordem="' + numero + '"]');
                var alvo = null;
                for (var i = 0; i < botoes.length; i++) {
                    if (botoes[i].offsetParent !== null) {
                        alvo = botoes[i];
                        break;
                    }
                }
                alvo = alvo || botoes[0];
                if (alvo) {
                    evento.preventDefault();
                    evento.stopPropagation();
                    alvo.click();
                }
            }
            return;
        }

        /* TAB com item destacado: seleciona, mantém o foco e reabre o painel com as opções */
        if (evento.key === 'Tab' && !evento.shiftKey) {
            var entrada = evento.target;
            if (!entrada || !entrada.id || !$(entrada).closest('.crc-console-projeto-crc__entrada').length) {
                return;
            }
            var widget = obterWidget(entrada.id);
            if (!widget || !widget.panel || !widget.panel.is(':visible')
                    || !widget.panel.find('.ui-autocomplete-item.ui-state-highlight').length) {
                return;
            }
            evento.preventDefault();
            setTimeout(function () {
                widget.input.trigger('focus');
                widget.search(widget.input.val());
            }, 50);
        }
    }, true);
})();