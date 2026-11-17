/* === crc-iframe-interno === */
/* Lê as variáveis CSS de largura/altura máximas definidas pela página interna
   (modeloQuadroInternoIframe.xhtml, via ui:param largura/altura) e repassa à raiz do componente.
   Só funciona com mesma origem; em outra origem o iframe mantém o tamanho padrão do CSS. */
window.crcIframeInternoAjustar = function (iframe) {
    try {
        var doc = iframe.contentDocument;
        if (!doc || !doc.documentElement) {
            return;
        }
        var estilo = iframe.contentWindow.getComputedStyle(doc.documentElement);
        var largura = estilo.getPropertyValue('--crc-embed-largura-maxima').trim();
        var altura = estilo.getPropertyValue('--crc-embed-altura-maxima').trim();
        var raiz = iframe.parentNode;
        if (/^\d/.test(largura)) {
            raiz.style.setProperty('--crc-iframe-interno-largura', largura);
        }
        if (/^\d/.test(altura)) {
            raiz.style.setProperty('--crc-iframe-interno-altura', altura);
        }
    } catch (e) {
        /* Origem diferente: mantém o tamanho padrão */
    }
};

/* Recebe mensagens da página interna e chama o método JSF (metodoInteracaoIframe) do componente.
   Na página interna:  parent.postMessage({ crcIframeInterno: { dados: 'qualquer valor' } }, '*');
   No Java, o dado chega no parâmetro de requisição "crcIframeDados" (objetos viram JSON). */
if (!window.crcIframeInternoOuvindo) {
    window.crcIframeInternoOuvindo = true;
    window.addEventListener('message', function (evento) {
        var mensagem = evento.data;
        if (!mensagem || typeof mensagem !== 'object' || !mensagem.crcIframeInterno) {
            return;
        }
        var iframes = document.querySelectorAll('iframe.crc-iframe-interno__frame');
        for (var i = 0; i < iframes.length; i++) {
            var iframe = iframes[i];
            if (iframe.contentWindow !== evento.source) {
                continue;
            }
            /* Só aceita mensagens vindas da origem do src do próprio iframe */
            var origemIframe = new URL(iframe.src, window.location.href).origin;
            if (evento.origin !== origemIframe) {
                console.warn('crcIframeInterno: origem da mensagem (' + evento.origin + ') diferente da origem do iframe (' + origemIframe + ').');
                return;
            }
            var nomeFuncao = iframe.getAttribute('data-crc-interacao') || '';
            var funcao = window[nomeFuncao];
            if (typeof funcao !== 'function') {
                console.warn('crcIframeInterno: função "' + nomeFuncao + '" não encontrada; o p:remoteCommand está dentro de um h:form?');
                return;
            }
            var dados = mensagem.crcIframeInterno.dados;
            if (dados === undefined || dados === null) {
                dados = '';
            } else if (typeof dados !== 'string') {
                dados = JSON.stringify(dados);
            }
            funcao([{name: 'crcIframeDados', value: dados}]);
            return;
        }
        console.warn('crcIframeInterno: mensagem recebida de um iframe que não é um crc-iframe-interno.');
    });
}

/* Chamado no onsuccess do p:remoteCommand de interação, antes do PrimeFaces aplicar a resposta.
   Remove da resposta os <update> cujo alvo contém o próprio iframe (ex.: idSBLayotAreaAcaoSelecionada,
   adicionado pelo framework), evitando que o iframe seja substituído e recarregado.
   Os demais updates (growl, ViewState, atualizarAoInteragir) seguem normalmente. */
window.crcIframeInternoFiltrarResposta = function (respostaXml, idIframe) {
    var iframe = document.getElementById(idIframe);
    if (!respostaXml || !iframe) {
        return;
    }
    var updates = respostaXml.getElementsByTagName('update');
    for (var i = updates.length - 1; i >= 0; i--) {
        var alvo = document.getElementById(updates[i].getAttribute('id'));
        if (alvo && (alvo === iframe || alvo.contains(iframe))) {
            updates[i].parentNode.removeChild(updates[i]);
        }
    }
};
