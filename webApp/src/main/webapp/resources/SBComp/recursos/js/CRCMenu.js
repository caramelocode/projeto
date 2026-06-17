document.addEventListener("DOMContentLoaded", function () {

    // ==================== FECHAR TODOS OS MENUS ====================
    function closeAllMenus() {
        document.querySelectorAll('.dropdown').forEach(d => d.classList.remove('show'));

        const userDropdown = document.querySelector('.crc-user-dropdown');
        if (userDropdown)
            userDropdown.classList.remove('show');

        const notificationDropdown = document.querySelector('.crc-notification-dropdown');
        if (notificationDropdown)
            notificationDropdown.classList.remove('show');

        const messagesDropdown = document.querySelector('.crc-messages-dropdown');
        if (messagesDropdown)
            messagesDropdown.classList.remove('show');

        const sidebar = document.getElementById("crcSidebar");
        if (sidebar)
            sidebar.classList.remove("crc-sidebar-open");

        const hb = document.getElementById("crcSidebarToggle");
        if (hb)
            hb.classList.remove("crc-is-open");
    }

    // ==================== DROPDOWN MENU SUPERIOR (hover delegado) ====================
    document.addEventListener('mouseover', function (e) {
        var dropdown = e.target.closest('.dropdown');
        if (dropdown) {
            closeAllMenus();
            dropdown.classList.add('show');
        }
    });

    document.addEventListener('mouseout', function (e) {
        var dropdown = e.target.closest('.dropdown');
        if (dropdown) {
            var related = e.relatedTarget;
            if (!dropdown.contains(related)) {
                dropdown.classList.remove('show');
            }
        }
    });

    // ==================== SEÇÕES RETRÁTEIS ====================
    function isMobile() {
        return window.innerWidth <= 768;
    }

    // Helper: busca o body do collapsible pelo data-target
    // Aceita id literal OU id composto JSF (procura por "termina com :id")
    function findCollapsibleBody(targetId) {
        // tenta id literal primeiro
        var body = document.getElementById(targetId);
        if (body)
            return body;
        // procura por id que termina com :targetId (caso JSF)
        var candidatos = document.querySelectorAll('[id$="' + targetId + '"]');
        for (var i = 0; i < candidatos.length; i++) {
            if (candidatos[i].id === targetId || candidatos[i].id.endsWith(':' + targetId)) {
                return candidatos[i];
            }
        }
        return null;
    }

    // Aplica estado inicial dos collapsibles (não registra listener — é via delegação)
    function aplicarEstadoCollapsibles() {
        document.querySelectorAll('.crc-collapsible-header').forEach(function (header) {
            var targetId = header.getAttribute('data-target');
            var body = findCollapsibleBody(targetId);
            if (!body)
                return;
            if (isMobile()) {
                body.classList.add('crc-section-open');
                header.classList.add('crc-section-open');
            } else {
                body.classList.remove('crc-section-open');
                header.classList.remove('crc-section-open');
            }
        });
    }

    aplicarEstadoCollapsibles();

    // Re-aplica em resize e após AJAX
    let resizeTimer;
    window.addEventListener('resize', function () {
        clearTimeout(resizeTimer);
        resizeTimer = setTimeout(aplicarEstadoCollapsibles, 200);
    });

    // Hook AJAX do PrimeFaces: re-aplica estado após qualquer update
    if (window.jQuery) {
        $(document).on('pfAjaxComplete.collapsibles', function () {
            aplicarEstadoCollapsibles();
        });
    }

    // ==================== LISTENER ÚNICO NO DOCUMENT ====================
    document.addEventListener('click', function (e) {

        // --- Sidebar toggle (hamburger) ---
        if (e.target.closest('#crcSidebarToggle')) {
            e.stopPropagation();
            var sb = document.getElementById("crcSidebar");
            var hb = document.getElementById("crcSidebarToggle");
            if (sb && hb) {
                var isOpen = sb.classList.contains("crc-sidebar-open");
                closeAllMenus();
                if (!isOpen) {
                    sb.classList.add("crc-sidebar-open");
                    hb.classList.add("crc-is-open");
                }
            }
            return;
        }

        // --- Submenus do sidebar (item pai com filhos) ---
        var sidebarParent = e.target.closest('.crc-sidebar-parent');
        if (sidebarParent) {
            e.preventDefault();
            e.stopPropagation();
            var parentLi = sidebarParent.parentElement;
            var isExpanded = parentLi.classList.contains("crc-expanded");
            document.querySelectorAll(".crc-sidebar li.crc-expanded").forEach(function (li) {
                if (li !== parentLi)
                    li.classList.remove("crc-expanded");
            });
            parentLi.classList.toggle("crc-expanded", !isExpanded);
            return;
        }

        // --- Clique dentro do sidebar: não fecha ---
        if (e.target.closest('#crcSidebar')) {
            e.stopPropagation();
            return;
        }

        // --- Collapsible header (mensagens/notificações mobile) ---
        var collapsibleHeader = e.target.closest('.crc-collapsible-header');
        if (collapsibleHeader) {
            e.stopPropagation();
            var targetId = collapsibleHeader.getAttribute('data-target');
            var body = findCollapsibleBody(targetId);
            if (body) {
                var isOpen = body.classList.contains('crc-section-open');
                body.classList.toggle('crc-section-open', !isOpen);
                collapsibleHeader.classList.toggle('crc-section-open', !isOpen);
            }
            return;
        }

        // --- Clique dentro do collapsible body: não fecha ---
        if (e.target.closest('.crc-collapsible-body')) {
            e.stopPropagation();
            return;
        }

        // --- User toggle ---
        if (e.target.closest('.crc-user-toggle')) {
            e.stopPropagation();
            var ud = document.querySelector('.crc-user-dropdown');
            if (ud) {
                var isOpen = ud.classList.contains('show');
                closeAllMenus();
                if (!isOpen)
                    ud.classList.add('show');
            }
            return;
        }

        // --- Clique dentro do user menu: não fecha ---
        if (e.target.closest('.crc-user-menu')) {
            e.stopPropagation();
            return;
        }

        // --- Dropdown menu superior (clique no toggle) ---
        var dropdownToggle = e.target.closest('.dropdown-toggle');
        if (dropdownToggle) {
            e.preventDefault();
            e.stopPropagation();
            var dd = dropdownToggle.closest('.dropdown');
            if (dd) {
                closeAllMenus();
                dd.classList.add('show');
            }
            return;
        }

        // --- Notificações toggle ---
        var notifToggle = e.target.closest('.crc-notification-toggle');
        if (notifToggle) {
            e.preventDefault();
            e.stopPropagation();
            var notifDropdown = notifToggle.closest('.crc-notification-dropdown');
            if (notifDropdown) {
                var isOpen = notifDropdown.classList.contains('show');
                closeAllMenus();
                if (!isOpen)
                    notifDropdown.classList.add('show');
            }
            return;
        }

        // --- Clique dentro do menu de notificações: não fecha ---
        if (e.target.closest('.crc-notification-menu')) {
            e.stopPropagation();
            return;
        }

        // --- Mensagens toggle ---
        var msgToggle = e.target.closest('.crc-messages-toggle');
        if (msgToggle) {
            e.preventDefault();
            e.stopPropagation();
            var msgDropdown = msgToggle.closest('.crc-messages-dropdown');
            if (msgDropdown) {
                var isOpen = msgDropdown.classList.contains('show');
                closeAllMenus();
                if (!isOpen)
                    msgDropdown.classList.add('show');
            }
            return;
        }

        // --- Clique dentro do menu de mensagens: não fecha ---
        if (e.target.closest('.crc-messages-menu')) {
            e.stopPropagation();
            return;
        }

        // --- Clique fora de tudo: fecha todos ---
        closeAllMenus();
    });

    // ESC fecha tudo
    document.addEventListener('keydown', function (e) {
        if (e.key === "Escape")
            closeAllMenus();
    });
});