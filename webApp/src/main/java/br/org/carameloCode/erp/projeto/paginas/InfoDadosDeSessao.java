package br.org.carameloCode.erp.projeto.paginas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named
@RequestScoped
public class InfoDadosDeSessao implements Serializable {

    private static final String CHAVE_VIEW_MAPS
            = "com.sun.faces.application.view.activeViewMaps";
    private static final String CHAVE_VIEW_CONTEXTS
            = "com.sun.faces.application.view.activeViewContexts";

    @Inject
    private HttpServletRequest request;

    // ── DTOs ────────────────────────────────────────────────
    public static class InfoBean implements Serializable {

        private final String nome;
        private final Object instancia;

        public InfoBean(String nome, Object instancia) {
            this.nome = nome;
            this.instancia = instancia;
        }

        public String getNome() {
            return nome;
        }

        public String getClasse() {
            return instancia.getClass().getName();
        }

        public String getClasseSimples() {
            return instancia.getClass().getSimpleName();
        }

        public Object getInstancia() {
            return instancia;
        }

        public String getPaginaInstanciaID() {
            try {
                return (String) instancia.getClass()
                        .getMethod("getPaginaInstanciaID").invoke(instancia);
            } catch (Exception e) {
                return null;
            }
        }

        public String getToString() {
            try {
                return instancia.toString();
            } catch (Exception e) {
                return "[erro ao chamar toString]";
            }
        }
    }

    public static class InfoView implements Serializable {

        private final String viewLogicalId;
        private final String origem;
        private final List<InfoBean> beans;

        public InfoView(String viewLogicalId, String origem, List<InfoBean> beans) {
            this.viewLogicalId = viewLogicalId;
            this.origem = origem;
            this.beans = beans;
        }

        public String getViewLogicalId() {
            return viewLogicalId;
        }

        public String getOrigem() {
            return origem;
        }

        public List<InfoBean> getBeans() {
            return beans;
        }

        public int getQuantidadeBeans() {
            return beans.size();
        }

        public String getResumoBeanPrincipal() {
            for (InfoBean bean : beans) {
                String vid = bean.getPaginaInstanciaID();
                if (vid != null && !vid.isEmpty()) {
                    String idCurto = vid.length() > 8 ? vid.substring(0, 8) + "..." : vid;
                    return bean.getClasseSimples() + " [" + idCurto + "]";
                }
            }
            return null;
        }
    }

    public static class InfoRequest implements Serializable {

        private final HttpServletRequest req;

        public InfoRequest(HttpServletRequest req) {
            this.req = req;
        }

        public String getMetodo() {
            return req.getMethod();
        }

        public String getUri() {
            return req.getRequestURI();
        }

        public String getQueryString() {
            return req.getQueryString();
        }

        public String getRemoteAddr() {
            return req.getRemoteAddr();
        }

        public String getRemoteHost() {
            return req.getRemoteHost();
        }

        public String getUserAgent() {
            return req.getHeader("User-Agent");
        }

        public String getReferer() {
            return req.getHeader("Referer");
        }

        public String getContentType() {
            return req.getContentType();
        }

        public String getProtocolo() {
            return req.getProtocol();
        }

        public String getServletPath() {
            return req.getServletPath();
        }

        public String getContextPath() {
            return req.getContextPath();
        }

        public boolean isSeguro() {
            return req.isSecure();
        }

        public boolean isAjax() {
            return "XMLHttpRequest".equals(req.getHeader("X-Requested-With"));
        }

        public List<String> getParametros() {
            List<String> lista = new ArrayList<>();
            req.getParameterMap().forEach((k, v)
                    -> lista.add(k + " = " + String.join(", ", v)));
            return lista;
        }

        public List<String> getCabecalhos() {
            List<String> lista = new ArrayList<>();
            Enumeration<String> nomes = req.getHeaderNames();
            if (nomes != null) {
                while (nomes.hasMoreElements()) {
                    String nome = nomes.nextElement();
                    lista.add(nome + ": " + req.getHeader(nome));
                }
            }
            return lista;
        }
    }

    // ── sessão ───────────────────────────────────────────────
    public String getIdSessao() {
        HttpSession s = sessao();
        return s != null ? s.getId() : "sem sessão";
    }

    public String getCriadaEm() {
        HttpSession s = sessao();
        return s != null ? formatar(s.getCreationTime()) : "-";
    }

    public String getUltimoAcesso() {
        HttpSession s = sessao();
        return s != null ? formatar(s.getLastAccessedTime()) : "-";
    }

    public int getMaxInactiveInterval() {
        HttpSession s = sessao();
        return s != null ? s.getMaxInactiveInterval() : -1;
    }

    public long getIdadeEmMinutos() {
        HttpSession s = sessao();
        if (s == null) {
            return -1;
        }
        return (System.currentTimeMillis() - s.getCreationTime()) / 1000 / 60;
    }

    public long getInativaHaMinutos() {
        HttpSession s = sessao();
        if (s == null) {
            return -1;
        }
        return (System.currentTimeMillis() - s.getLastAccessedTime()) / 1000 / 60;
    }

    public boolean isSessaoNova() {
        HttpSession s = sessao();
        return s != null && s.isNew();
    }

    public String getUsuarioAutenticado() {
        return request.getRemoteUser();
    }

    public boolean isAutenticado() {
        return request.getUserPrincipal() != null;
    }

    // ── atributos brutos da sessão ───────────────────────────
    public List<String> getAtributosBrutos() {
        HttpSession s = sessao();
        if (s == null) {
            return Collections.emptyList();
        }
        List<String> lista = new ArrayList<>();
        Enumeration<String> nomes = s.getAttributeNames();
        while (nomes.hasMoreElements()) {
            String nome = nomes.nextElement();
            Object valor = s.getAttribute(nome);
            lista.add(nome + " → " + valor.getClass().getName());
        }
        Collections.sort(lista);
        return lista;
    }

    // ── views e beans ────────────────────────────────────────
    public List<InfoView> getViews() {
        HttpSession s = sessao();
        if (s == null) {
            return Collections.emptyList();
        }
        return extrairViews(s);
    }

    public int getQuantidadeViews() {
        return getViews().size();
    }

    public int getQuantidadeTotalBeans() {
        return getViews().stream()
                .mapToInt(InfoView::getQuantidadeBeans)
                .sum();
    }

    // ── request ──────────────────────────────────────────────
    public InfoRequest getRequest() {
        return new InfoRequest(request);
    }

    // ── ambiente ─────────────────────────────────────────────
    public String getJavaVersao() {
        return System.getProperty("java.version");
    }

    public String getServidorInfo() {
        return request.getServletContext().getServerInfo();
    }

    public String getContextoNome() {
        return request.getServletContext().getServletContextName();
    }

    public long getMemoriaUsadaMb() {
        Runtime rt = Runtime.getRuntime();
        return (rt.totalMemory() - rt.freeMemory()) / 1024 / 1024;
    }

    public long getMemoriaTotalMb() {
        return Runtime.getRuntime().totalMemory() / 1024 / 1024;
    }

    public long getMemoriaMaxMb() {
        return Runtime.getRuntime().maxMemory() / 1024 / 1024;
    }

    public String getDataHoraServidor() {
        return formatar(System.currentTimeMillis());
    }

    // ── busca por viewId — procura nas duas fontes ───────────
    public <T> T getBeanPorViewId(String viewId, Class<T> classe) {
        HttpSession s = sessao();
        if (s == null) {
            return null;
        }

        // busca no Weld (CDI @ViewScoped)
        Map<Integer, Map<String, Object>> viewContexts = obterViewContexts(s);
        if (viewContexts != null) {
            synchronized (viewContexts) {
                for (Map<String, Object> viewBeans : viewContexts.values()) {
                    if (viewBeans == null) {
                        continue;
                    }
                    for (Object contextObj : viewBeans.values()) {
                        Object instancia = extrairInstanciaDoContextObject(contextObj);
                        if (instancia != null && classe.isInstance(instancia)) {
                            try {
                                String vid = (String) instancia.getClass()
                                        .getMethod("getPaginaInstanciaID").invoke(instancia);
                                if (viewId.equals(vid)) {
                                    return classe.cast(instancia);
                                }
                            } catch (Exception ignored) {
                            }
                        }
                    }
                }
            }
        }

        // busca no Mojarra (JSF @ViewScoped)
        Map<String, Map<String, Object>> viewMaps = obterViewMaps(s);
        if (viewMaps != null) {
            synchronized (viewMaps) {
                for (Map<String, Object> viewBeans : viewMaps.values()) {
                    if (viewBeans == null) {
                        continue;
                    }
                    for (Object bean : viewBeans.values()) {
                        if (classe.isInstance(bean)) {
                            try {
                                String vid = (String) bean.getClass()
                                        .getMethod("getPaginaInstanciaID").invoke(bean);
                                if (viewId.equals(vid)) {
                                    return classe.cast(bean);
                                }
                            } catch (Exception ignored) {
                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    // ── helpers privados ─────────────────────────────────────
    private HttpSession sessao() {
        return request.getSession(false);
    }

    @SuppressWarnings("unchecked")
    private static Map<String, Map<String, Object>> obterViewMaps(HttpSession session) {
        try {
            return (Map<String, Map<String, Object>>) session.getAttribute(CHAVE_VIEW_MAPS);
        } catch (Exception e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    private static Map<Integer, Map<String, Object>> obterViewContexts(HttpSession session) {
        try {
            return (Map<Integer, Map<String, Object>>) session.getAttribute(CHAVE_VIEW_CONTEXTS);
        } catch (Exception e) {
            return null;
        }
    }

    private static Object extrairInstanciaDoContextObject(Object contextObj) {
        if (contextObj == null) {
            return null;
        }
        try {
            java.lang.reflect.Method getInstance
                    = contextObj.getClass().getMethod("getInstance");
            return getInstance.invoke(contextObj);
        } catch (Exception e1) {
            try {
                java.lang.reflect.Method get
                        = contextObj.getClass().getMethod("get");
                return get.invoke(contextObj);
            } catch (Exception e2) {
                return null;
            }
        }
    }

    private static List<InfoView> extrairViews(HttpSession session) {
        Map<String, InfoView> resultado = new LinkedHashMap<>();

        // fonte 1 — Weld (CDI @ViewScoped)
        Map<Integer, Map<String, Object>> viewContexts = obterViewContexts(session);
        if (viewContexts != null) {
            synchronized (viewContexts) {
                for (Map.Entry<Integer, Map<String, Object>> entry
                        : viewContexts.entrySet()) {
                    if (entry.getValue() == null || entry.getValue().isEmpty()) {
                        continue;
                    }
                    List<InfoBean> beans = new ArrayList<>();
                    for (Map.Entry<String, Object> beanEntry : entry.getValue().entrySet()) {
                        Object instancia = extrairInstanciaDoContextObject(beanEntry.getValue());
                        if (instancia != null) {
                            beans.add(new InfoBean(beanEntry.getKey(), instancia));
                        } else {
                            beans.add(new InfoBean(beanEntry.getKey(), beanEntry.getValue()));
                        }
                    }
                    if (!beans.isEmpty()) {
                        String id = "weld-" + entry.getKey();
                        resultado.put(id, new InfoView(id, "CDI @ViewScoped (Weld)", beans));
                    }
                }
            }
        }

        // fonte 2 — Mojarra (JSF @ViewScoped)
        Map<String, Map<String, Object>> viewMaps = obterViewMaps(session);
        if (viewMaps != null) {
            synchronized (viewMaps) {
                for (Map.Entry<String, Map<String, Object>> entry
                        : viewMaps.entrySet()) {
                    if (entry.getValue() == null || entry.getValue().isEmpty()) {
                        continue;
                    }
                    List<InfoBean> beans = new ArrayList<>();
                    for (Map.Entry<String, Object> beanEntry : entry.getValue().entrySet()) {
                        beans.add(new InfoBean(beanEntry.getKey(), beanEntry.getValue()));
                    }
                    if (!beans.isEmpty()) {
                        String id = "jsf-" + entry.getKey();
                        resultado.put(id, new InfoView(id, "JSF @ViewScoped (Mojarra)", beans));
                    }
                }
            }
        }

        return new ArrayList<>(resultado.values());
    }

    private static String formatar(long timestamp) {
        return new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
                .format(new java.util.Date(timestamp));
    }

    // ── debug raw ────────────────────────────────────────────
    public List<String> getDebugViewMapsRaw() {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return Collections.singletonList("sem sessão");
        }

        List<String> debug = new ArrayList<>();

        Enumeration<String> nomes = session.getAttributeNames();
        while (nomes.hasMoreElements()) {
            String nome = nomes.nextElement();
            Object valor = session.getAttribute(nome);
            debug.add("CHAVE: " + nome + " | TIPO: " + valor.getClass().getName());

            if (valor instanceof Map) {
                Map<?, ?> mapa = (Map<?, ?>) valor;
                debug.add("  → tamanho do mapa: " + mapa.size());
                for (Map.Entry<?, ?> entry : mapa.entrySet()) {
                    debug.add("    → entry key: " + entry.getKey()
                            + " | value type: " + (entry.getValue() == null ? "null" : entry.getValue().getClass().getName()));

                    if (entry.getValue() instanceof Map) {
                        Map<?, ?> inner = (Map<?, ?>) entry.getValue();
                        debug.add("      → inner size: " + inner.size());
                        for (Map.Entry<?, ?> ie : inner.entrySet()) {
                            debug.add("        → bean: " + ie.getKey()
                                    + " | " + (ie.getValue() == null ? "null" : ie.getValue().getClass().getSimpleName()));
                        }
                    }
                }
            }
        }

        return debug;
    }
}
