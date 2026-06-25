package br.org.carameloCode.erp.projeto.servicoPush;

import br.org.carameloCode.erp.modulo.notificacao.api.FabAcaoNotificacaoPadraoSB;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.transporte.LogDisparoNotificacao;
import br.org.coletivoJava.fw.erp.implementacao.erpintegracao.MapaTokensGerenciadosConcessaoOauth;
import br.org.coletivoJava.fw.erp.implementacao.erpintegracao.model.token.TokenAcessoOauthServer;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCDataHora;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCJson;
import com.super_bits.modulosSB.SBCore.UtilGeral.json.ErroProcessandoJson;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.RespostaWebServiceAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ComoDialogo;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ERPTipoCanalComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.erp.ErroJsonInterpredador;
import com.super_bits.modulosSB.SBCore.modulos.erpCore.ErpCarameloCore;
import com.super_bits.modulosSB.SBCore.modulos.objetos.dialogo.resposta.RespostaComunicacao;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.interfaces.ItfPaginaAtual;
import jakarta.json.JsonObjectBuilder;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author salvio
 */
@WebServlet("/notificacoes/dialogo/resposta")
public class ServletResposta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        String codigoDialogo = req.getParameter("dialogoId");
        String respostaJson = req.getParameter("resposta");
        String paginaInstanciaID = req.getParameter("paginaInstanciaID"); // ← getParameter, não getAttribute

        try {
            RespostaComunicacao resposta = ErpCarameloCore.CORE_PADRAO
                    .getDTO(respostaJson, RespostaComunicacao.class);
            req.setAttribute("respostaObj", resposta);
            if (resposta == null) {

                throw new ServletException("Resposta não detectada");
            }

            // se tem paginaInstanciaID → despacha para o xhtml renderizar o recibo
            if (paginaInstanciaID != null && !paginaInstanciaID.isEmpty()) {
                req.getRequestDispatcher("/resources/SBComp/modal/respostaTransient.xhtml")
                        .forward(req, resp); // ← caminho absoluto
                return;
            }

            // sem paginaInstanciaID → resposta JSON simples
            escreverJson(resp, "{\n"
                    + "    \"formulario\": \"não informado\",\n"
                    + "    \"respostaRegistrada\": \"" + resposta.getTipoResposta().getNome() + "\"\n"
                    + "}");

        } catch (ErroJsonInterpredador | ServletException | IOException ex) {
            Logger.getLogger(ServletResposta.class.getName()).log(Level.SEVERE, null, ex);
            try {
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                escreverJson(resp, "{\"erro\": \"Erro interno ao processar resposta\"}");
            } catch (IOException ignore) {
            }
        }
    }

    private void escreverJson(HttpServletResponse resp, String json) throws IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getOutputStream().print(json);
        resp.flushBuffer();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TokenAcessoOauthServer dadosToken = null;
        String autorizacaoWrap = resp.getHeader("Authorization");
        if (autorizacaoWrap != null) {
            String autorizacao = autorizacaoWrap.replace("Bearer ", "");
            dadosToken = MapaTokensGerenciadosConcessaoOauth.getTokenExistente(autorizacao);

        }

        RespostaWebServiceAcaoDoSistema novaresposta = new RespostaWebServiceAcaoDoSistema(LogDisparoNotificacao.class,
                FabAcaoNotificacaoPadraoSB.DISPAROS_FRM_LISTAR_POR_TIPO_CANAL.getRegistro());

        JsonObjectBuilder disparosAguardando = null;
        try {
            disparosAguardando = UtilCRCJson.getJsonBuilderBySequenciaChaveValor("dataResposta", UtilCRCDataHora.getAgoraString(UtilCRCDataHora.FORMATO_TEMPO.DATA_HORA_SISTEMA));
        } catch (ErroProcessandoJson ex) {
            novaresposta.addErro("falha gerando Jsonbuilder definindo cabeçalho do jsonbuilder com dataREsposta");
        }
        if (dadosToken != null) {
            if (dadosToken.isTokenValido()) {
                //String RESPOSTA = erpIntegracao.getRespostaJsonString(novaresposta);
            }
        }
        //String tokenAcesso=Util
    }

}
