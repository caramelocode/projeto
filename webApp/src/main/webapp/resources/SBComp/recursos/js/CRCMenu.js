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
    }

    // Toggle Sidebar
    const sidebar = document.getElementById("crcSidebar");
    const toggleBtn = document.getElementById("crcSidebarToggle");

    toggleBtn.addEventListener("click", function (e) {
        e.stopPropagation();
        closeAllMenus(); // fecha outros
        sidebar.classList.toggle("crc-sidebar-open");
    });

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

    // ==================== DROPDOWN MENU SUPERIOR ====================
    document.querySelectorAll('.dropdown-toggle').forEach(dropdown => {
        dropdown.addEventListener('click', function (e) {
            e.preventDefault();
            e.stopPropagation();

            const parent = this.parentElement;
            const isOpen = parent.classList.contains('show');

            closeAllMenus(); // fecha todos primeiro

            if (!isOpen) {
                parent.classList.add('show');
            }
        });
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