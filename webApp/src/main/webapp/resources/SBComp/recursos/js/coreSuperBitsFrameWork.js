/**
 * CarameloCode — Núcleo JS do Caramelo Code Framework
 *
 * Namespace organizado por área de responsabilidade.
 * Em código novo, use sempre CarameloCode.<area>.<funcao>(...).
 * As funções globais antigas continuam existindo (ver bloco
 * "FUNÇÕES LEGADAS" no final do arquivo) apenas por compatibilidade.
 */
var CarameloCode = {

    /**
     * Encerra a sessão do usuário.
     * TODO: implementar (redirecionamento / remoteCommand de logoff).
     */
    logoff: function () {
        alert("todo logoff");
    },
    // ─── Notificações de sistema/menu ───────────────────────────────────────
    notificacoes: {
        /**
         * Atualiza as notificações de sistema e de mensagens do usuário no menu.
         * TODO: implementar.
         */
        atualizarMenu: function () {
            CarameloCode.areaTrabalho.atualizarAreaByID('menuNotificacoesTopo');
            setTimeout(function () {
                CarameloCode.areaTrabalho.atualizarAreaByID('areaNotificacaoBloqueio');
            }, 300); // 3 segundos

            setTimeout(function () {
                try {
                    CarameloCode.areaTrabalho.atualizarAreaByID('menuMobile');
                } catch {

                }
            }, 300);


        },
        push: function (notificacao) {
            console.log(notificacao);
        },
        _filaSom: Promise.resolve(),
        tocarSom: function () {
            CarameloCode.notificacoes._filaSom =
                    CarameloCode.notificacoes._filaSom.then(function () {
                        return new Promise(function (resolve) {
                            try {
                                var audio = new Audio('https://cdn.freesound.org/previews/411/411642_5121236-lq.mp3');
                                audio.volume = 0.5;
                                audio.onended = resolve;
                                audio.onerror = resolve;
                                var promise = audio.play();
                                if (promise !== undefined) {
                                    promise.catch(function () {
                                        document.addEventListener('click', function handler() {
                                            audio.play();
                                            document.removeEventListener('click', handler);
                                        }, {once: true});
                                        resolve();
                                    });
                                }
                            } catch (t) {
                                console.log("Erro ao tocar som de notificação: " + t);
                                resolve();
                            }
                        });
                    });
        }
    },

    // ─── Comunicação / conversas ─────────────────────────────────────────────
    comunicacao: {
        responderConversa: function (codigoSelo) {
            (document.getElementById('formularioComunicacao:codigoComunicacao')).value = codigoSelo;
            PF('botaoAbrirModalConversa').jq.click();
        },
        responderConversaRespostaRapida: function (codigoSelo, codigoResposta) {
            (document.getElementById('formularioComunicacaoRespostaRapida:codigoSeloCMRespostaRapida')).value = codigoSelo;
            (document.getElementById('formularioComunicacaoRespostaRapida:codigoRespostaRapida')).value = codigoResposta;
            PF('respostaRapidaAct').jq.click();
        }
    },
    // ─── Formulário ──────────────────────────────────────────────────────────
    formulario: {
        /**
         * Atualiza a área do campo instanciado informado, se visível.
         * @param {string} pAreaCampo Ex.: "Cliente.nome"
         */
        atualizarCampo: function (pAreaCampo) {
            try {
                var nodePesquisa = document.querySelectorAll("[campoinstanciado='" + pAreaCampo + "']");
                var qtdElementosEncontrados = nodePesquisa.length;
                if (qtdElementosEncontrados > 0) {
                    nodePesquisa.forEach(function (elemento) {
                        if (elemento.parentElement.id.length > 0) {
                            // mantém comportamento original
                        } else {
                            if (elemento.id.length > 0) {
                                CarameloCode.areaTrabalho.atualizarAreaByID(elemento.id);
                            } else {
                                var idMaisProximo = CarameloCode.areaTrabalho.getIdSuperiorMaisProximo(elemento);
                                if (idMaisProximo.length > 0) {
                                    CarameloCode.areaTrabalho.atualizarAreaByID(idMaisProximo);
                                }
                            }
                        }
                        CarameloCode.areaTrabalho.atualizarAreaByID(elemento.parentElement.id);
                    });
                }
                if (qtdElementosEncontrados > 1) {
                    console.log("Atenção: a atualização da area do campo se visivel ainda não suporta atualização de multiplos elementos");
                }
            } catch (t) {
                console.log("Erro buscando area de visão do campo " + pAreaCampo);
            }
        },
        validarCampo: function (pNomeCampoInstanciado) {
            try {
                var nodePesquisa = document.querySelectorAll("[campoinstanciado='" + pNomeCampoInstanciado + "']");
                var qtdElementosEncontrados = nodePesquisa.length;
                if (qtdElementosEncontrados === 0) {
                    console.log("validarCampo: nenhum elemento encontrado para " + pNomeCampoInstanciado);
                    return;
                }

                if (qtdElementosEncontrados > 1) {
                    console.log("Atenção: validarCampo ainda não suporta múltiplos elementos para " + pNomeCampoInstanciado);
                }

                var elemento = nodePesquisa[0];
                var elementoId = elemento.id;
                if (!elementoId || elementoId.length === 0) {
                    console.log("validarCampo: elemento sem ID, não é possível submeter via PrimeFaces AJAX");
                    return;
                }

                // Determina o formulário pai para usar como source do submit
                var formPai = elemento.closest('form');
                var formId = formPai ? formPai.id : null;
                // Determina a área de update — mesmo padrão do atualizarCampo
                var areaUpdate = '';
                if (elemento.parentElement && elemento.parentElement.id && elemento.parentElement.id.length > 0) {
                    areaUpdate = elemento.parentElement.id;
                } else {
                    var idMaisProximo = CarameloCode.areaTrabalho.getIdSuperiorMaisProximo(elemento);
                    if (idMaisProximo.length > 0) {
                        areaUpdate = idMaisProximo;
                    }
                }

                // Dispara o submit parcial via PrimeFaces AJAX
                PrimeFaces.ab({
                    s: elementoId, // source: o próprio campo
                    e: 'valueChange', // evento (mesmo padrão do seu onchange)
                    f: formId, // form pai
                    p: elementoId, // process: somente este campo
                    u: areaUpdate, // update: área de retorno
                    onst: function (cfg) {
                        if (areaUpdate)
                            bloquearArea(areaUpdate);
                    },
                    onco: function (xhr, status, args, data) {
                        if (areaUpdate)
                            desbloquearArea(areaUpdate);
                    }
                });
            } catch (t) {
                console.log("Erro ao validar campo " + pNomeCampoInstanciado + ": " + t);
            }
        },
        /**
         * Atualiza, via PrimeFaces, todos os campos que possuem a classe CSS informada.
         * @returns {Promise}
         */
        atualizarCampoPorClasse: async function (pClasse) {
            var delay = function (t) {
                return new Promise(function (resolve) {
                    setTimeout(resolve, t);
                });
            };
            var promessaAtualizacaoCamposSecundarios = new Promise(function (resolve, reject) {
                try {
                    $('.' + pClasse).each(function (i, obj) {
                        CarameloCode.areaTrabalho.bloquearArea(CarameloCode.areaTrabalho.getIdSuperiorMaisProximo(obj));
                    });
                } catch (r) {
                    console.log("Erro bloqueando campos com a classe " + pClasse);
                }

                try {
                    window.PrimeFaces.ab({s: "", f: "formAjaxUpdateClientSide", u: "@(." + pClasse + ")", fp: ""});
                } catch (t) {
                    reject(new Error('Falha executando update primefaces'));
                }

                delay(3000).then(function () {
                    $('.' + pClasse).each(function (i, obj) {
                        CarameloCode.areaTrabalho.desbloquearArea(CarameloCode.areaTrabalho.getIdSuperiorMaisProximo(obj));
                    });
                });
            });
            return promessaAtualizacaoCamposSecundarios;
        },
        scrollEmCampoNaoValidado: function () {
            try {
                var elementoErro = $("input.ui-state-error:first");
                if (elementoErro.length > 0) {
                    $('html, body').animate({
                        scrollTop: elementoErro.offset().top - 200
                    });
                    return true;
                }
                return false;
            } catch (err) {
            }
            return false;
        },
        modificarInputEClicar: function (idBotao, idInputEnvio, valor) {
            try {
                var elementos = idInputEnvio.split(" ");
                var elementoCodigo = document.getElementById(elementos[0]);
                if (elementoCodigo === null) {
                    elementoCodigo = document.getElementById(elementos[1]);
                }

                elementoCodigo.value = valor;
                var botoes = idBotao.split(" ");
                var botao = document.getElementById(botoes[0]);
                if (botao === null) {
                    botao = document.getElementById(botoes[1]);
                }
                botao.click();
            } catch (t) {
                console.log(t);
            }
        },
        copiarValoresInput: function (idOrigem, idDestino) {
            document.getElementById(idDestino).value = document.getElementById(idOrigem).value;
        },
        pesquisaDataSetComDelay: function (idElementoDigitacao, idDataSetPrime) {
            // Contribuição: https://schier.co/blog/2014/12/08/wait-for-user-to-stop-typing-using-javascript.html
            var elemento = document.getElementById(idElementoDigitacao);
            var timeout = null;
            elemento.onkeyup = function (e) {
                clearTimeout(timeout);
                timeout = setTimeout(function () {
                    PF(idDataSetPrime).filter();
                }, 800);
            };
        }
    },
    // ─── Componentes ─────────────────────────────────────────────────────────
    componente: {
        mesclarOnChangeComDelay: function (idElementoDigitacao) {
            try {
                var elemento = document.getElementById(idElementoDigitacao);
                var idelementoJquery = PrimeFaces.escapeClientId(elemento.id);
                $(idelementoJquery).putCursorAtEnd();
                var timeout = null;
                if (elemento.onchange) {
                    elemento.metodoOnchangeComDelay = elemento.onchange;
                    elemento.ultimapesquisa = elemento.value;
                    elemento.onkeyup = function (e) {
                        try {
                            if (elemento.value === elemento.ultimapesquisa) {
                                // sem alteração
                            } else {
                                clearTimeout(timeout);
                                elemento.ultimapesquisa = elemento.value;
                                timeout = setTimeout(function () {
                                    try {
                                        idelementoJquery = PrimeFaces.escapeClientId(elemento.id);
                                        $(idelementoJquery).disabled = true;
                                        CarameloCode.areaTrabalho.bloquearArea(elemento.id);
                                        elemento.metodoOnchangeComDelay();
                                        CarameloCode.areaTrabalho.desbloquearArea(elemento.id);
                                        $(idelementoJquery).disabled = false;
                                    } catch (t) {
                                    }
                                }, 1200);
                            }
                        } catch (t) {
                        }
                    };
                }
            } catch (t) {
            }
        },
        copiarTexto: function (btn) {
            try {
                var cell = btn.closest('.ui-panelgrid-cell');
                var texto = cell.previousElementSibling.innerText.trim();
                if (navigator.clipboard) {
                    navigator.clipboard.writeText(texto);
                }
            } catch (t) {
            }
        },
        ckEditor: {
            copiarValoresCKEditor: function (idOrigem, idDestino) {
                try {
                    var conteudo = CKEDITOR.instances[idOrigem].getData();
                    if (conteudo !== null) {
                        document.getElementById(idDestino).value = conteudo;
                    }
                } catch (erro) {
                    alert(idOrigem + ' destino:' + idDestino + erro);
                }
            },
            copiarValoresCKEditorByClasseEstilo: function (idOrigem, classeDestino) {
                try {
                    var conteudo = CKEDITOR.instances[idOrigem].getData();
                    if (conteudo !== null) {
                        document.getElementsByClassName(classeDestino)[0].value = conteudo;
                    }
                } catch (erro) {
                    alert(idOrigem + ' destino:' + classeDestino + erro);
                }
            },
            mesclarOnChangeComDelay: function (idElementoDigitacao, idElementoPersistente) {
                try {
                    var elemento = document.getElementById(idElementoPersistente);
                    var editorCK;
                    CarameloCode.componente.mesclarOnChangeComDelay(idElementoPersistente);
                    editorCK = CKEDITOR.instances[idElementoDigitacao];
                    editorCK.elemento = elemento;
                    editorCK.setData(elemento.value);
                    if (elemento.onchange) {
                        editorCK.elemento.metodoOnchangeComDelay = elemento.onchange;
                        editorCK.elemento.ultimapesquisa = editorCK.getData();
                    }
                    if (elemento.onchange) {
                        editorCK.on('key', function (e) {
                            try {
                                if (editorCK.getData() === this.elemento.ultimapesquisa) {
                                    if (this.elemento.idTimeout) {
                                        // timeout em execução
                                    }
                                } else {
                                    if (editorCK.elemento.idTimeout) {
                                        clearTimeout(this.elemento.idTimeout);
                                    }
                                    editorCK.elemento.ultimapesquisa = editorCK.getData();
                                    this.elemento.idTimeout = setTimeout(function () {
                                        try {
                                            setTimeout(function () {
                                                editorCK.elemento.metodoOnchangeComDelay();
                                            }, 1000);
                                        } catch (t) {
                                        }
                                    }, 800);
                                }
                            } catch (t) {
                            }
                        });
                        elemento.onchange = null;
                    }
                } catch (t) {
                }
            }
        },
        arquivos: {
            baixarArquivo: function (fileURL, fileName) {
                // navegadores não-IE
                if (!window.ActiveXObject) {
                    var save = document.createElement('a');
                    save.href = fileURL;
                    save.target = '_blank';
                    save.download = fileName || 'unknown';
                    var event = document.createEvent('Event');
                    event.initEvent('click', true, true);
                    save.dispatchEvent(event);
                    (window.URL || window.webkitURL).revokeObjectURL(save.href);
                }
                // IE
                else if (!!window.ActiveXObject && document.execCommand) {
                    var _window = window.open(fileURL, '_blank');
                    _window.document.close();
                    _window.document.execCommand('SaveAs', true, fileName || fileURL);
                    _window.close();
                }
            }
        },
        linkify: {
            aplicarLinkify: function (nodes) {
                nodes.forEach(function (node) {
                    if (node.dataset.linkified === "true")
                        return;
                    node.innerHTML = node.innerHTML.replace(
                            /(https?:\/\/[^\s<]+)/g,
                            '<a href="$1" target="_blank">$1</a>'
                            );
                    node.dataset.linkified = "true";
                });
            },
            registrarLinkifyAjax: function () {
                // garante que jQuery e PrimeFaces já carregaram
                if (!window.jQuery || !window.PrimeFaces) {
                    console.warn("[Linkify] jQuery/PrimeFaces ainda não disponíveis");
                    return;
                }

                // evita múltiplos binds
                if (window._linkifyAjaxHookInstalled) {
                    return;
                }

                window._linkifyAjaxHookInstalled = true;
                $(document).on('pfAjaxComplete.linkify', function (e, xhr, settings) {
                    var mensagens = document.querySelectorAll('.ui-message-error-detail');
                    CarameloCode.componente.linkify.aplicarLinkify(mensagens);
                });
            },
            initLinkifyQuandoPronto: function () {
                if (!window.jQuery || !window.PrimeFaces) {
                    setTimeout(CarameloCode.componente.linkify.initLinkifyQuandoPronto, 500);
                    return;
                }
                CarameloCode.componente.linkify.registrarLinkifyAjax();
            }
        },
        menuHorizontal: {
            init: function (menuhorizontalresponsivo) {
                var itemSize = $(menuhorizontalresponsivo).parent().find('.item-menu-horizontal-responsivo').outerWidth(true);
                var itensQtd = $(menuhorizontalresponsivo).parent().find('.item-menu-horizontal-responsivo').length;
                var scrollMaximo = (itensQtd * itemSize);
                var tamanhoVisivel = $(menuhorizontalresponsivo).parent().width();
                var pd = (itensQtd * 22);
                if (scrollMaximo <= tamanhoVisivel) {
                    var botaoScrollEsquerda = $(menuhorizontalresponsivo).parent().find('.botao-lateral-esquerda-menu-horizontal-responsivo');
                    var botaoScrollDireita = $(menuhorizontalresponsivo).parent().find('.botao-lateral-direita-menu-horizontal-responsivo');
                    $(botaoScrollDireita).addClass('hidden-botao-lateral');
                    $(botaoScrollEsquerda).addClass('hidden-botao-lateral');
                } else {
                    $(menuhorizontalresponsivo).css({
                        "padding-left": pd + "px"
                    });
                    $(menuhorizontalresponsivo).mousewheel(function (e, delta) {
                        e.preventDefault();
                        if (delta < 0) {
                            CarameloCode.componente.menuHorizontal.acoes(menuhorizontalresponsivo, true, true);
                        } else {
                            CarameloCode.componente.menuHorizontal.acoes(menuhorizontalresponsivo, false, true);
                        }
                    });
                }
                var pixelScrolAtual = $(menuhorizontalresponsivo).scrollLeft();
                $(menuhorizontalresponsivo).parent().data("posicaoInicial", pixelScrolAtual);
            },
            acoes: function (menuhorizontalresponsivo, parafrente, semefeito) {
                var etapaPosicaoScroolAtual = $(menuhorizontalresponsivo).parent().data("posicao");
                if (etapaPosicaoScroolAtual == null) {
                    etapaPosicaoScroolAtual = 1;
                    $(menuhorizontalresponsivo).parent().data("posicao", etapaPosicaoScroolAtual);
                } else {
                    if (parafrente) {
                        etapaPosicaoScroolAtual = etapaPosicaoScroolAtual + 1;
                        $(menuhorizontalresponsivo).parent().data("posicao", etapaPosicaoScroolAtual);
                    } else {
                        etapaPosicaoScroolAtual = etapaPosicaoScroolAtual - 1;
                        if (etapaPosicaoScroolAtual < 1) {
                            etapaPosicaoScroolAtual = 1;
                        }
                        $(menuhorizontalresponsivo).parent().data("posicao", etapaPosicaoScroolAtual);
                    }
                }
                var pixelScrolAtual = $(menuhorizontalresponsivo).scrollLeft();
                var tamanhoVisivel = $(menuhorizontalresponsivo).parent().width();
                var itensQtd = $(menuhorizontalresponsivo).parent().find('.item-menu-horizontal-responsivo').length;
                var itemSize = $(menuhorizontalresponsivo).parent().find('.item-menu-horizontal-responsivo').outerWidth(true);
                var pd = (itensQtd * 22);
                var scrollMaximoVisivel = $(menuhorizontalresponsivo).outerWidth(true);
                var scrollMaximo = (itensQtd * itemSize);
                var intervaloScroll = tamanhoVisivel - itemSize;
                var novoScroll = intervaloScroll + pixelScrolAtual;
                if (parafrente) {
                    novoScroll = pixelScrolAtual + (intervaloScroll * 0.45);
                } else {
                    novoScroll = pixelScrolAtual - (intervaloScroll * 0.6);
                    if (novoScroll < pd) {
                        if (novoScroll < 0) {
                            novoScroll = 0;
                        }
                    }
                }
                var botaoScrollEsquerda = $(menuhorizontalresponsivo).parent().find('.botao-lateral-esquerda-menu-horizontal-responsivo');
                var botaoScrollDireita = $(menuhorizontalresponsivo).parent().find('.botao-lateral-direita-menu-horizontal-responsivo');
                if (tamanhoVisivel >= scrollMaximo + pd) {
                    $(botaoScrollDireita).addClass('hidden-botao-lateral');
                    $(botaoScrollEsquerda).addClass('hidden-botao-lateral');
                } else {
                    if (novoScroll >= scrollMaximoVisivel) {
                        $(botaoScrollDireita).addClass('hidden-botao-lateral');
                        $(botaoScrollEsquerda).removeClass('hidden-botao-lateral');
                    } else {
                        if (novoScroll <= 0) {
                            $(botaoScrollDireita).removeClass('hidden-botao-lateral');
                            $(botaoScrollEsquerda).addClass('hidden-botao-lateral');
                        } else {
                            $(botaoScrollDireita).removeClass('hidden-botao-lateral');
                            $(botaoScrollEsquerda).removeClass('hidden-botao-lateral');
                        }
                    }
                }
                var segundosefeitos = 900;
                if (semefeito) {
                    segundosefeitos = 0;
                }
                if (parafrente) {
                    if (novoScroll >= scrollMaximoVisivel - intervaloScroll) {
                        $(menuhorizontalresponsivo).css({
                            "padding-left": "0px"
                        });
                    }
                    $(menuhorizontalresponsivo).animate({scrollLeft: novoScroll}, segundosefeitos);
                } else {
                    $(menuhorizontalresponsivo).css({
                        "padding-left": pd + "px"
                    });
                    $(menuhorizontalresponsivo).animate({scrollLeft: novoScroll}, segundosefeitos);
                }
            }
        }
    },
    // ─── Tela / cliente ──────────────────────────────────────────────────────
    tela: {
        /**
         * Atualiza o campo contactfrm:clientinfo com a resolução atual da tela.
         */
        getClientInfo: function () {
            var clientinfo = "";
            clientinfo += "aplicativo:" + navigator.appName + "||";
            clientinfo += "versaoAplicativo:" + navigator.appVersion + "||";
            clientinfo += "tamanhoX:" + window.innerWidth + "||";
            clientinfo += "tamanhoY:" + window.innerHeight;
            (document.getElementById('contactfrm:clientinfo')).value = clientinfo;
        },
        atualizarResolucaoDaTela: function () {
            CarameloCode.tela.getClientInfo();
            enviarInfoTela();
        },
        irParaTopo: function () {
            $("html, body").animate({scrollTop: 0}, "slow");
        }
    },
    // ─── Área de trabalho (bloqueios, atualizações de área) ──────────────────
    areaTrabalho: {
        bloquearArea: function (idArea) {
            try {
                var areas = idArea.split(" ");
                for (var i = 0; i < areas.length; i++) {
                    try {
                        $(PrimeFaces.escapeClientId(areas[i])).block({message: '<table style="min-height: 50px;"><tbody ><tr><td ><img src="/javax.faces.resource/recursos/img/preloader.gif.xhtml?ln=SBComp" alt="" style="margin-right: 12px;vertical-align: middle;"></td><td><span style="white-space: nowrap; font-size:16px; color: #546E7A">Processando...</span></td></tr></tbody></table>', css: {border: '0px'}});
                    } catch (t) {
                        console.log("Erro bloqueando area");
                        console.log(t);
                    }
                }
            } catch (t) {
                console.log("Erro bloqueando area");
                console.log(t);
            }
        },
        desbloquearArea: function (idArea) {
            try {
                var areas = idArea.split(" ");
                for (var i = 0; i < areas.length; i++) {
                    try {
                        if (areas[i].length > 0) {
                            $(PrimeFaces.escapeClientId(areas[i])).unblock();
                        }
                    } catch (t) {
                        console.log("Erro desbloqueando area [" + areas[i] + " ");
                        console.log(t);
                    }
                }
            } catch (t) {
                console.log("Erro desbloqueando area");
                console.log(t);
            }
        },
        bloquearAreaPorSegundos: function (idArea, segundos) {
            try {
                CarameloCode.areaTrabalho.bloquearArea(idArea);
                setTimeout(function () {
                    CarameloCode.areaTrabalho.desbloquearArea(idArea);
                }, segundos * 1000);
            } catch (t) {
                console.log("Erro bloqueando area");
                console.log(t);
            }
        },
        atualizarAreaByID: function (idAreaAtualizada) {
            CarameloCode.areaTrabalho.bloquearArea(idAreaAtualizada);
            (document.getElementById('formAtualizacao:prAtualizarAreaID')).value = idAreaAtualizada;
            atualizarAreaByIDRC();
            CarameloCode.areaTrabalho.desbloquearArea(idAreaAtualizada);
        },
        getIdSuperiorMaisProximo: function (pElemento) {
            if (pElemento === null) {
                return null;
            }
            if (pElemento.id.length > 0) {
                return pElemento.id;
            }
            if (pElemento.parentElement === null) {
                return null;
            }
            return CarameloCode.areaTrabalho.getIdSuperiorMaisProximo(pElemento.parentElement);
        },
        liberarBloqueios: function () {
            var i;
            try {
                for (i in PrimeFaces.widgets) {
                    if (PrimeFaces.widgets[i].show && PrimeFaces.widgets[i].blocker) {
                        PrimeFaces.widgets[i].hide();
                    }
                }
            } catch (erro) {
            }
        },
        esconderTooltips: function () {
            try {
                $(".ui-tooltip").hide();
            } catch (erro) {
            }
        },
        bloquearTodosBotoes: function () {
            $('.ui-button').prop("disabled", true);
        },
        desbloquearTodosBotoes: function () {
            $('.ui-button').prop("disabled", false);
        },
        bloquearTodosCommandLinks: function () {
            $(".ui-commandlink").each(function (index) {
                $(this).hide();
            });
        },
        desbloquearTodosCommandLinks: function () {
            $(".ui-commandlink").each(function (index) {
                $(this).show();
            });
        }
    },
    // ─── Ajax ────────────────────────────────────────────────────────────────
    ajax: {
        acoesPosAjax: function () {
            try {
                CarameloCode.areaTrabalho.esconderTooltips();
                CarameloCode.areaTrabalho.liberarBloqueios();
                if (!CarameloCode.formulario.scrollEmCampoNaoValidado()) {
                    CarameloCode.tela.irParaTopo();
                }
            } catch (err) {
            }
        },
        focarComSelacaoAposAjax: function () {
            try {
                var contemClientID = false;
                for (var i = 0; i < arguments.length; i++) {
                    if (document.activeElement.id.includes(arguments[i])) {
                        contemClientID = true;
                    }
                }
                if (!contemClientID) {
                    if ($(PrimeFaces.escapeClientId(document.activeElement.id)).attr('data-p-hl') === "inputnumber") {
                        $(PrimeFaces.escapeClientId(document.activeElement.id)).select();
                    }
                }
            } catch (o) {
            }
        }
    }
};
/**
 * Plugin jQuery: posiciona o cursor no fim de um input/textarea.
 * Usado por CarameloCode.componente.mesclarOnChangeComDelay.
 */
try {
    jQuery.fn.putCursorAtEnd = function () {

        return this.each(function () {

            // Cache references
            var $el = $(this),
                    el = this;
            // Only focus if input isn't already
            if (!$el.is(":focus")) {
                $el.focus();
            }

            // If this function exists... (IE 9+)
            if (el.setSelectionRange) {

                // Double the length because Opera is inconsistent about whether a carriage return is one character or two.
                var len = $el.val().length * 2;
                // Timeout seems to be required for Blink
                setTimeout(function () {
                    el.setSelectionRange(len, len);
                }, 1);
            } else {

                // As a fallback, replace the contents with itself
                // Doesn't work in Chrome, but Chrome supports setSelectionRange
                $el.val($el.val());
            }

            // Scroll to the bottom, in case we're in a tall textarea
            // (Necessary for Firefox and Chrome)
            this.scrollTop = 999999;
        });
    };
} catch (erroPosicionandoCursor) {
//  console.log(erroPosicionandoCursor);
}


// Inicialização automática
CarameloCode.componente.linkify.initLinkifyQuandoPronto();
/* ============================================================================
 * FUNÇÕES LEGADAS
 * ----------------------------------------------------------------------------
 * Mantidas apenas por compatibilidade com XHTML/código que ainda chama os
 * nomes globais antigos. Cada função abaixo apenas delega para o namespace
 * CarameloCode definido acima. NÃO adicione novas funções aqui — em código
 * novo use diretamente CarameloCode.<area>.<funcao>(...).
 * ============================================================================ */

function esconderTooltips() {
    return CarameloCode.areaTrabalho.esconderTooltips();
}
function liberarBloqueios() {
    return CarameloCode.areaTrabalho.liberarBloqueios();
}
function bloquearTodosBotoes() {
    return CarameloCode.areaTrabalho.bloquearTodosBotoes();
}
function desbloquearTodosBotoes() {
    return CarameloCode.areaTrabalho.desbloquearTodosBotoes();
}
function bloquearTodosCommandLinks() {
    return CarameloCode.areaTrabalho.bloquearTodosCommandLinks();
}
function desbloquearTodosCommandLinks() {
    return CarameloCode.areaTrabalho.desbloquearTodosCommandLinks();
}
function scrollEmCampoNaoValidado() {
    return CarameloCode.formulario.scrollEmCampoNaoValidado();
}
function irParaTopo() {
    return CarameloCode.tela.irParaTopo();
}
function irParTopo() {
    return CarameloCode.tela.irParaTopo();
}
function acoesPosAjax() {
    return CarameloCode.ajax.acoesPosAjax();
}
function atualizarResolucaoDaTela() {
    return CarameloCode.tela.atualizarResolucaoDaTela();
}
function getClientInfo() {
    return CarameloCode.tela.getClientInfo();
}
function baixarArquivo(fileURL, fileName) {
    return CarameloCode.componente.arquivos.baixarArquivo(fileURL, fileName);
}
function modificarIntputEclicar(idBotao, idInputEnvio, valor) {
    return CarameloCode.formulario.modificarInputEClicar(idBotao, idInputEnvio, valor);
}
function copiarValoresCKEditorByClasseEstilo(idOrigem, classeDestino) {
    return CarameloCode.componente.ckEditor.copiarValoresCKEditorByClasseEstilo(idOrigem, classeDestino);
}
function copiarValoresCKEditor(idOrigem, idDestino) {
    return CarameloCode.componente.ckEditor.copiarValoresCKEditor(idOrigem, idDestino);
}
function copiarValoresInput(idOrigem, idDestino) {
    return CarameloCode.formulario.copiarValoresInput(idOrigem, idDestino);
}
function mesclarOnChangeComDelayCkEditor(idElementoDigitacao, idElementoPersistente) {
    return CarameloCode.componente.ckEditor.mesclarOnChangeComDelay(idElementoDigitacao, idElementoPersistente);
}
function mesclarOnChangeComDelay(idElementoDigitacao) {
    return CarameloCode.componente.mesclarOnChangeComDelay(idElementoDigitacao);
}
function focarComSelacaoAposAjax() {
    return CarameloCode.ajax.focarComSelacaoAposAjax.apply(null, arguments);
}
function pesquisaDataSetComDelay(idElementoDigitacao, idDataSetPrime) {
    return CarameloCode.formulario.pesquisaDataSetComDelay(idElementoDigitacao, idDataSetPrime);
}
function notificacoesPush(notificacao) {
    return CarameloCode.notificacoes.push(notificacao);
}
function responderConversa(codigoSelo) {
    return CarameloCode.comunicacao.responderConversa(codigoSelo);
}
function responderConversaRespostaRapida(codigoSelo, codigoResposta) {
    return CarameloCode.comunicacao.responderConversaRespostaRapida(codigoSelo, codigoResposta);
}
function initBotaoMenuHorizontal(menuhorizontalresponsivo) {
    return CarameloCode.componente.menuHorizontal.init(menuhorizontalresponsivo);
}
function acoesBotaoMenuHorizontal(menuhorizontalresponsivo, parafrente, semefeito) {
    return CarameloCode.componente.menuHorizontal.acoes(menuhorizontalresponsivo, parafrente, semefeito);
}
function bloquearArea(idArea) {
    return CarameloCode.areaTrabalho.bloquearArea(idArea);
}
function desbloquearArea(idArea) {
    return CarameloCode.areaTrabalho.desbloquearArea(idArea);
}
function atualizarAreaByID(idAreaAtualizada) {
    return CarameloCode.areaTrabalho.atualizarAreaByID(idAreaAtualizada);
}
function getIdSuperiorMaisProximo(pElemento) {
    return CarameloCode.areaTrabalho.getIdSuperiorMaisProximo(pElemento);
}
function atualizarAreaCampoByCssEstilo(pClasse) {
    return CarameloCode.formulario.atualizarCampoPorClasse(pClasse);
}
function atualizarAreaCampoSeVisivel(pAreaCampo) {
    return CarameloCode.formulario.atualizarCampo(pAreaCampo);
}
function bloquearAreaOitoSegundos(idArea) {
    return CarameloCode.areaTrabalho.bloquearAreaPorSegundos(idArea, 8);
}
function copiarTexto(btn) {
    return CarameloCode.componente.copiarTexto(btn);
}
function aplicarLinkify(nodes) {
    return CarameloCode.componente.linkify.aplicarLinkify(nodes);
}
function registrarLinkifyAjax() {
    return CarameloCode.componente.linkify.registrarLinkifyAjax();
}
function initLinkifyQuandoPronto() {
    return CarameloCode.componente.linkify.initLinkifyQuandoPronto();
}
