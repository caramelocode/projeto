/* ═══════════════════ CARAMELO STORE ═══════════════════
 Arquivo    : carameloStore.js (CORE)
 Git        : https://github.com/carameloCode/caramelo-store
 Versão     : 2.0.0

 Núcleo do store no lado do cliente. Todo componente vive
 em CarameloStore.componentes[nome], SEMPRE com o contrato:

 .nome        (string, obrigatório)
 .descricao   (string, obrigatório)
 .gitUrl      (string, obrigatório — de onde o componente é baixado)
 .instancias  (getter: array VIVO das instâncias renderizadas na tela)
 .api         (opcional: métodos públicos do componente)
 .init        (opcional: função idempotente, chamada pelo core
 no load e após cada ajax do PrimeFaces)

 ── Registro para componentes COM comportamento JS ──────
 CarameloStore.registrarComponente({
 nome: "meuComponente",
 descricao: "O que ele faz",
 gitUrl: "https://github.com/...",
 seletor: '[data-crc-componente="meuComponente"]', // opcional
 init: function () { ... },   // opcional, mas se existir: IDEMPOTENTE
 api:  { abrir: fn, ... }     // opcional
 });

 ── Registro para componentes SEM JavaScript ────────────
 Basta o XHTML marcar o elemento raiz com data-attributes;
 o core descobre e registra sozinho no init:

 data-crc-componente="meuComponente"
 data-crc-descricao="O que ele faz"
 data-crc-git="https://github.com/..."

 Em ambos os caminhos, registros sem os metadados
 obrigatórios são RECUSADOS com erro no console.
 ═══════════════════════════════════════════════════════ */

(function () {
    "use strict";

    // Instância única: se o core já carregou, não recria nada
    if (window.CarameloStore && window.CarameloStore.registrarComponente) {
        return;
    }

    var componentes = {};
    var domPronto = (document.readyState !== "loading");

    /* ── Contrato ───────────────────────────────────────── */

    function validar(def, origem) {
        var faltando = [];
        ["nome", "descricao", "gitUrl"].forEach(function (campo) {
            if (!def || typeof def[campo] !== "string" || def[campo].trim() === "") {
                faltando.push(campo);
            }
        });
        if (faltando.length > 0) {
            if (window.console) {
                console.error("[CarameloStore] Registro RECUSADO (" + origem + "). " +
                        "Metadados obrigatórios ausentes: " + faltando.join(", ") + ".", def);
            }
            return false;
        }
        return true;
    }

    function criarEntrada(def) {
        var entrada = {
            nome: def.nome,
            descricao: def.descricao,
            gitUrl: def.gitUrl,
            seletor: def.seletor || '[data-crc-componente="' + def.nome + '"]',
            api: def.api || null,
            init: (typeof def.init === "function") ? def.init : null
        };
        // Getter: consulta o DOM na hora, então a lista está sempre
        // atualizada mesmo após updates ajax renderizarem/removerem instâncias
        Object.defineProperty(entrada, "instancias", {
            enumerable: true,
            get: function () {
                return Array.prototype.slice.call(document.querySelectorAll(entrada.seletor));
            }
        });
        return entrada;
    }

    function initSeguro(entrada) {
        if (!entrada.init) {
            return;
        }
        try {
            entrada.init();
        } catch (e) {
            if (window.console) {
                console.error("[CarameloStore] Falha no init de '" + entrada.nome + "':", e);
            }
        }
    }

    /* ── Registro explícito (componentes com JS) ────────── */

    function registrarComponente(def) {
        if (!validar(def, "registrarComponente")) {
            return null;
        }

        if (componentes[def.nome]) {
            if (window.console) {
                console.warn("[CarameloStore] '" + def.nome + "' já estava registrado. " +
                        "Registro duplicado ignorado (reinclusão via ajax ou colisão de nomes).");
            }
            return componentes[def.nome];
        }

        var entrada = criarEntrada(def);
        componentes[def.nome] = entrada;

        // Se o DOM já está pronto, inicializa imediatamente;
        // senão, o DOMContentLoaded abaixo cuida de todos.
        if (domPronto) {
            initSeguro(entrada);
        }
        return entrada;
    }

    /* ── Auto-registro (componentes sem JS) ─────────────── */
    // Varre o DOM por raízes marcadas com data-crc-componente
    // que ainda não estejam no catálogo e as registra a partir
    // dos metadados declarados no próprio XHTML.

    function descobrirNoDom() {
        var raizes = document.querySelectorAll("[data-crc-componente]");
        for (var i = 0; i < raizes.length; i++) {
            var el = raizes[i];
            var nome = el.getAttribute("data-crc-componente");
            if (!nome || componentes[nome]) {
                continue;
            }

            var def = {
                nome: nome,
                descricao: el.getAttribute("data-crc-descricao") || "",
                gitUrl: el.getAttribute("data-crc-git") || ""
            };
            if (validar(def, "auto-registro de '" + nome + "' via data-attributes")) {
                componentes[nome] = criarEntrada(def);
            }
        }
    }

    /* ── Ciclo de vida centralizado ─────────────────────── */

    function initTodos() {
        descobrirNoDom();
        for (var nome in componentes) {
            if (Object.prototype.hasOwnProperty.call(componentes, nome)) {
                initSeguro(componentes[nome]);
            }
        }
    }

    if (!domPronto) {
        document.addEventListener("DOMContentLoaded", function () {
            domPronto = true;
            initTodos();
        });
    }

    // PrimeFaces dispara pfAjaxComplete no document (via jQuery) ao fim
    // de cada requisição ajax — momento em que componentes podem ter
    // sido re-renderizados e precisam de re-init / redescoberta.
    if (window.jQuery) {
        window.jQuery(document).on("pfAjaxComplete", function () {
            window.setTimeout(initTodos, 0);
        });
    }

    /* ── Namespace público ──────────────────────────────── */

    window.CarameloStore = {
        versao: "2.0.0",
        componentes: componentes,
        registrarComponente: registrarComponente,
        init: initTodos   // hook manual, ex.: dentro de acoesPosAjax()
    };
})();