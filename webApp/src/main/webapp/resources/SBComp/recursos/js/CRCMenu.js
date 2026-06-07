document.addEventListener("DOMContentLoaded", function () {

    // ==================== FECHAR TODOS OS MENUS ====================
    function closeAllMenus() {
        // Dropdowns do menu superior
        document.querySelectorAll('.dropdown').forEach(d => d.classList.remove('show'));

        // User dropdown
        const userDropdown = document.querySelector('.crc-user-dropdown');
        if (userDropdown)
            userDropdown.classList.remove('show');

        // Notificações
        const notificationDropdown = document.querySelector('.crc-notification-dropdown');
        if (notificationDropdown)
            notificationDropdown.classList.remove('show');

        // Mensagens
        const messagesDropdown = document.querySelector('.crc-messages-dropdown');
        if (messagesDropdown)
            messagesDropdown.classList.remove('show');

        // Sidebar
        const sidebar = document.getElementById("crcSidebar");
        if (sidebar)
            sidebar.classList.remove("crc-sidebar-open");

        // Hamburger volta para barras
        const hb = document.getElementById("crcSidebarToggle");
        if (hb)
            hb.classList.remove("crc-is-open");
    }

    // Toggle Sidebar (só existe quando há menu extendido)
    const sidebar = document.getElementById("crcSidebar");
    const toggleBtn = document.getElementById("crcSidebarToggle");

    if (toggleBtn && sidebar) {
        toggleBtn.addEventListener("click", function (e) {
            e.stopPropagation();
            const sidebarIsOpen = sidebar.classList.contains("crc-sidebar-open");
            closeAllMenus(); // fecha outros
            if (!sidebarIsOpen) {
                sidebar.classList.add("crc-sidebar-open");
                toggleBtn.classList.add("crc-is-open");
            }
        });
    }

    // Toggle submenus do Sidebar
    document.querySelectorAll(".crc-sidebar-parent").forEach(item => {
        item.addEventListener("click", function (e) {
            e.preventDefault();
            e.stopPropagation(); // evita fechar o sidebar ao clicar no item pai

            const parentLi = this.parentElement;
            const isExpanded = parentLi.classList.contains("crc-expanded");

            // Fecha todos os outros itens expandidos
            document.querySelectorAll(".crc-sidebar li.crc-expanded").forEach(li => {
                if (li !== parentLi)
                    li.classList.remove("crc-expanded");
            });

            // Alterna o atual
            parentLi.classList.toggle("crc-expanded", !isExpanded);
        });
    });

    // Subitens do Sidebar: stopPropagation para não fechar o sidebar ao navegar
    document.querySelectorAll(".crc-sidebar li ul a").forEach(link => {
        link.addEventListener("click", function (e) {
            e.stopPropagation();
        });
    });

    // ==================== DROPDOWN MENU SUPERIOR (hover) ====================
    document.querySelectorAll('.dropdown').forEach(function (dropdown) {
        dropdown.addEventListener('mouseenter', function () {
            closeAllMenus();
            this.classList.add('show');
        });

        dropdown.addEventListener('mouseleave', function () {
            this.classList.remove('show');
        });

        // Clique no item principal: sempre mantém aberto (não esconde).
        // Como o menu já aparece no hover, o clique instintivo do usuário não deve fechá-lo;
        // também garante a abertura em touch/mobile (onde não há hover).
        const toggle = dropdown.querySelector('.dropdown-toggle');
        if (toggle) {
            toggle.addEventListener('click', function (e) {
                e.preventDefault();
                e.stopPropagation();
                closeAllMenus();
                dropdown.classList.add('show');
            });
        }
    });

    // ==================== DROPDOWN DO USUÁRIO ====================
    const userDropdown = document.querySelector('.crc-user-dropdown');
    if (userDropdown) {
        const toggle = userDropdown.querySelector('.crc-user-toggle');

        toggle.addEventListener('click', function (e) {
            e.stopPropagation();
            const isOpen = userDropdown.classList.contains('show');
            closeAllMenus();
            if (!isOpen)
                userDropdown.classList.add('show');
        });

        userDropdown.querySelector('.crc-user-menu').addEventListener('click', e => e.stopPropagation());
    }

    // ==================== NOTIFICAÇÕES ====================
    const notificationDropdown = document.querySelector('.crc-notification-dropdown');
    if (notificationDropdown) {
        const toggle = notificationDropdown.querySelector('.crc-notification-toggle');

        toggle.addEventListener('click', function (e) {
            e.preventDefault();
            e.stopPropagation();
            const isOpen = notificationDropdown.classList.contains('show');
            closeAllMenus();
            if (!isOpen)
                notificationDropdown.classList.add('show');
        });

        notificationDropdown.querySelector('.crc-notification-menu').addEventListener('click', e => e.stopPropagation());
    }

    // ==================== MENSAGENS ====================
    const messagesDropdown = document.querySelector('.crc-messages-dropdown');
    if (messagesDropdown) {
        const toggle = messagesDropdown.querySelector('.crc-messages-toggle');

        toggle.addEventListener('click', function (e) {
            e.preventDefault();
            e.stopPropagation();
            const isOpen = messagesDropdown.classList.contains('show');
            closeAllMenus();
            if (!isOpen)
                messagesDropdown.classList.add('show');
        });

        messagesDropdown.querySelector('.crc-messages-menu').addEventListener('click', e => e.stopPropagation());
    }


    // ==================== SEÇÕES RETRÁTEIS DO MENU USUÁRIO ====================
    function isMobile() {
        return window.innerWidth <= 768;
    }

    function initCollapsibles() {
        document.querySelectorAll('.crc-collapsible-header').forEach(function (header) {
            const targetId = header.getAttribute('data-target');
            const body = document.getElementById(targetId);
            if (!body)
                return;

            // Estado inicial: expandido no mobile, retraído no desktop
            if (isMobile()) {
                body.classList.add('crc-section-open');
                header.classList.add('crc-section-open');
            } else {
                body.classList.remove('crc-section-open');
                header.classList.remove('crc-section-open');
            }

            header.addEventListener('click', function (e) {
                e.stopPropagation();
                const isOpen = body.classList.contains('crc-section-open');
                body.classList.toggle('crc-section-open', !isOpen);
                header.classList.toggle('crc-section-open', !isOpen);
            });
        });
    }

    initCollapsibles();

    // Re-inicializa ao redimensionar (troca desktop/mobile)
    let resizeTimer;
    window.addEventListener('resize', function () {
        clearTimeout(resizeTimer);
        resizeTimer = setTimeout(initCollapsibles, 200);
    });

    // Fecha tudo ao clicar fora
    document.addEventListener('click', function () {
        closeAllMenus();
    });

    // Suporte ESC
    document.addEventListener('keydown', function (e) {
        if (e.key === "Escape") {
            closeAllMenus();
        }
    });
});