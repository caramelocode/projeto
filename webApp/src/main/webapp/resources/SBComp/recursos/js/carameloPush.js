
/**
 * CarameloPush — Cliente WebSocket para o Caramelo Code Framework
 *
 * Resiliente contra:
 *   - Chamadas duplas acidentais
 *   - Múltiplas abas (todas recebem, servidor mantém Set de sessões)
 *   - Quedas de conexão (reconexão com backoff exponencial)
 *   - Registro duplo de listeners (visibilidade e fechamento)
 *   - Troca de HTTP/HTTPS automática
 *
 * Uso:
 *   CarameloPush.iniciarSessao(email, onMensagem);
 *   CarameloPush.iniciarSessao(email, onMensagem, { onConectado, onDesconectado, onFalha });
 *   CarameloPush.encerrarSessao();
 *   CarameloPush.isConectado();
 */
var CarameloPush = (function () {

    // ─── Funções utilitárias (declaradas primeiro para evitar hoisting issues) ─

    function _gerarIdAba() {
        return 'aba_' + Math.random().toString(36).substr(2, 9) + '_' + Date.now();
    }

    function _buildUrl(email) {
        var protocolo = window.location.protocol === 'https:' ? 'wss://' : 'ws://';
        return protocolo + window.location.host + '/carameloPush/' + encodeURIComponent(email);
    }

    // ─── Estado interno ────────────────────────────────────────────────────────
    var _socket = null;
    var _email = null;
    var _onMensagem = null;
    var _onConectado = null; // callback: conexão estabelecida
    var _onDesconectado = null; // callback: conexão perdida
    var _onFalha = null; // callback: esgotou tentativas
    var _tentativas = 0;
    var _maxTentativas = 5;
    var _intervaloRecon = null;
    var _encerrado = false;
    var _listenersRegistrados = false; // ← evita registro duplo
    var _idAba = _gerarIdAba();

    // ─── Log ──────────────────────────────────────────────────────────────────

    function _log(msg) {
        console.log('[CarameloPush][' + _idAba + '] ' + msg);
    }

    // ─── Estado do socket ─────────────────────────────────────────────────────

    function _isAberto() {
        return _socket !== null && _socket.readyState === WebSocket.OPEN;
    }

    function _isConectando() {
        return _socket !== null && _socket.readyState === WebSocket.CONNECTING;
    }

    // ─── Reconexão automática com backoff exponencial ─────────────────────────

    function _agendarReconexao() {
        if (_encerrado)
            return;

        if (_tentativas >= _maxTentativas) {
            _log('Número máximo de tentativas atingido (' + _maxTentativas + '). Desistindo.');
            if (typeof _onFalha === 'function') {
                _onFalha(_tentativas);
            }
            return;
        }

        // Backoff exponencial: 2s, 4s, 8s, 16s, 32s
        var delay = Math.pow(2, _tentativas + 1) * 1000;
        _tentativas++;
        _log('Reconectando em ' + (delay / 1000) + 's... (tentativa ' + _tentativas + '/' + _maxTentativas + ')');

        _intervaloRecon = setTimeout(function () {
            if (!_encerrado) {
                _conectar();
            }
        }, delay);
    }

    // ─── Conexão ──────────────────────────────────────────────────────────────

    function _conectar() {
        if (_isAberto() || _isConectando()) {
            _log('Conexão já ativa ou em andamento. Ignorando.');
            return;
        }

        var url = _buildUrl(_email);
        _log('Conectando em: ' + url);

        try {
            _socket = new WebSocket(url);
        } catch (e) {
            _log('Erro ao criar WebSocket: ' + e.message);
            _agendarReconexao();
            return;
        }

        _socket.onopen = function () {
            _log('Conectado com sucesso.');
            _tentativas = 0;
            if (typeof _onConectado === 'function') {
                _onConectado();
            }
        };

        _socket.onmessage = function (event) {
            try {
                var data = JSON.parse(event.data);
                _log('Mensagem recebida: ' + JSON.stringify(data));
                if (typeof _onMensagem === 'function') {
                    _onMensagem(data);
                }
            } catch (e) {
                _log('Erro ao processar mensagem: ' + e.message);
            }
        };

        _socket.onerror = function () {
            _log('Erro na conexão. Aguardando onclose para reconectar.');
            // onclose sempre é chamado após onerror — reconexão acontece lá
        };

        _socket.onclose = function (event) {
            _log('Conexão encerrada. Código: ' + event.code);
            _socket = null;

            if (typeof _onDesconectado === 'function') {
                _onDesconectado(event.code);
            }

            // Código 1000 = fechamento normal intencional
            if (!_encerrado && event.code !== 1000) {
                _agendarReconexao();
            }
        };
    }

    // ─── Listeners de ciclo de vida da aba ───────────────────────────────────
    // Registrados UMA única vez, independente de quantas vezes
    // iniciarSessao() for chamado

    function _registrarListeners() {
        if (_listenersRegistrados)
            return; // ← prova de registro duplo
        _listenersRegistrados = true;

        // Reconecta quando usuário volta para aba em background
        document.addEventListener('visibilitychange', function () {
            if (!document.hidden && !_encerrado && !_isAberto() && !_isConectando()) {
                _log('Aba voltou ao foco. Reconectando...');
                _tentativas = 0;
                _conectar();
            }
        });

        // Fecha limpo ao recarregar ou fechar a aba
        window.addEventListener('beforeunload', function () {
            if (_socket) {
                _socket.close(1000, 'Aba fechada');
            }
        });
    }

    // ─── API pública ──────────────────────────────────────────────────────────

    /**
     * Inicia a sessão WebSocket.
     *
     * Prova de chamada dupla: se já estiver conectado ou conectando,
     * a chamada é ignorada silenciosamente.
     *
     * @param {string}   email      - Email do usuário (identificador no servidor)
     * @param {function} onMensagem - Callback ao receber mensagem (recebe objeto JSON)
     * @param {object}   callbacks  - (opcional) { onConectado, onDesconectado, onFalha }
     *   onConectado()           → chamado quando a conexão é estabelecida
     *   onDesconectado(codigo)  → chamado quando a conexão é perdida
     *   onFalha(tentativas)     → chamado quando esgota as tentativas de reconexão
     */
    function iniciarSessao(email, onMensagem, callbacks) {
        if (!email) {
            _log('Email não informado. Sessão não iniciada.');
            return;
        }

        // ── Prova de chamada dupla ──────────────────────────────────────────
        if (_isAberto() || _isConectando()) {
            _log('Sessão já está ativa para: ' + _email + '. Ignorando nova chamada.');
            return;
        }

        _email = email;
        _onMensagem = onMensagem || null;
        _encerrado = false;
        _tentativas = 0;

        // Callbacks opcionais de status
        if (callbacks && typeof callbacks === 'object') {
            _onConectado = callbacks.onConectado || null;
            _onDesconectado = callbacks.onDesconectado || null;
            _onFalha = callbacks.onFalha || null;
        }

        _registrarListeners(); // registra apenas uma vez
        _conectar();
    }

    /**
     * Encerra a sessão WebSocket manualmente.
     * Cancela reconexões automáticas pendentes.
     */
    function encerrarSessao() {
        _encerrado = true;

        if (_intervaloRecon) {
            clearTimeout(_intervaloRecon);
            _intervaloRecon = null;
        }

        if (_socket) {
            _log('Encerrando sessão manualmente.');
            _socket.close(1000, 'Sessão encerrada pelo usuário');
            _socket = null;
        }
    }

    /**
     * Retorna true se o WebSocket está aberto e conectado.
     */
    function isConectado() {
        return _isAberto();
    }

    // ─── Expõe API ────────────────────────────────────────────────────────────
    return {
        iniciarSessao: iniciarSessao,
        encerrarSessao: encerrarSessao,
        isConectado: isConectado
    };

})();



//Funções de comunicação
function notificacoesPush(notificacao) {

    setTimeout(function () {
        CarameloCode.notificacoes.atualizarMenu();
    }, 3000); // 3 segundos

}