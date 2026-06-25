/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.projeto.config;

import br.org.carameloCode.erp.modulo.notificacao.controller.ServicoNotificacaoComPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ERPTipoCanalComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.FabTipoRespostaComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ComoDialogo;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfTipoCanalComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItffabricaCanalComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.dialogo.resposta.RespostaComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ComoServicoComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ErroDetectandoTelaBloqueio;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.B_Pagina;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.interfaces.ItfB_Pagina;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.interfaces.ItfPaginaAtual;
import com.super_bits.modulosSB.webPaginas.util.UtilSBWPServletTools;
import java.util.Optional;
import javax.swing.JOptionPane;
import org.coletivojava.fw.api.tratamentoErros.FabErro;

/**
 *
 * @author salvio
 */
public class ServicoComunicacaoWebAppPadrao extends
        ServicoNotificacaoComPersistencia implements ComoServicoComunicacao {

    private NotificadorIntranetJSF notificadorJsf = new NotificadorIntranetJSF();

    @Override
    public ItffabricaCanalComunicacao getCanalPadrao() {
        return ERPTipoCanalComunicacao.INTRANET_MENU;
    }

    @Override
    public FabTipoRespostaComunicacao aguardarRespostaComunicacao(ItfTipoCanalComunicacao pCanal, ComoDialogo pComunicacao, int pTempoAguardar, FabTipoRespostaComunicacao pTipoRespostaTempoFinal) throws ErroDetectandoTelaBloqueio {

        if (SBCore.isEmModoDesenvolvimento()) {
            // má prática, em ambiente teste, ServicoComunicacaoWebAppPadrao não deveria ser uasada, deixamos aqui somente para testes de ontras funções testaveis de ServicoComunicacaoWebAppPadrao
            try {
                int dialogResult
                        = JOptionPane.showConfirmDialog(null, pComunicacao.getMensagem(),
                                "Deseja continuar?", JOptionPane.YES_OPTION);
                if (dialogResult
                        == JOptionPane.YES_OPTION) {
                    return FabTipoRespostaComunicacao.SIM;
                } else {
                    System.out.println("não");
                    return FabTipoRespostaComunicacao.NAO;
                }

            } catch (Throwable t) {
                SBCore.RelatarErro(FabErro.SOLICITAR_REPARO, "Erro gerando comunicação entre usuários", t);
                return null;
            }
        } else {
            ItfPaginaAtual paginaAtual = null;
            try {
                paginaAtual = (ItfPaginaAtual) UtilSBWPServletTools.getBeanByNamed("paginaAtual", ItfPaginaAtual.class);
                //paginaAtual.getInfoPagina().getComoFormularioWeb().adicionarCodigoCoversa(pComunicacao.getCodigoSelo());
                if (paginaAtual == null) {
                    throw new ErroDetectandoTelaBloqueio("Falha pesquisando pagina atual");
                }
            } catch (Throwable t) {
                throw new ErroDetectandoTelaBloqueio("Falha pesquisando pagina atual" + t.getMessage());
            }
            //TODO Implementar capacidade de enviar apenas na aba do disparo
            String codigoInstancia = ((B_Pagina) paginaAtual.getInfoPagina()).getPaginaInstanciaID();
            pComunicacao.getCPinst("paginaInstanciaID").setValor(codigoInstancia);
            ((ItfB_Pagina) paginaAtual.getInfoPagina()).registrarDialogoTransitorio(pComunicacao);

            notificadorJsf.notificarViaBloqueioTEla(pComunicacao);
            long deadline = System.currentTimeMillis() + (pTempoAguardar * 1000);
            boolean respondeu = false;
            FabTipoRespostaComunicacao resposta = null;
            while (System.currentTimeMillis() < deadline && !respondeu) {

                try {
                    if (paginaAtual.getInfoPagina().getComoFormularioWeb().getRespostaAcaoAtual() != null) {
                        Optional<RespostaComunicacao> presquisaREsposata = ((ItfB_Pagina) paginaAtual.getInfoPagina()).getRespostasDialogosTransitorios().values().stream().filter(resp -> resp.getComunicacao().getCodigoSelo().equals(pComunicacao.getCodigoSelo()))
                                .findFirst();
                        if (presquisaREsposata.isPresent()) {
                            respondeu = true;
                            resposta = presquisaREsposata.get().getTipoResposta().getFabricaTipoResposta();
                        }

                    }
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();

                }
            }
            if (resposta == null) {
                resposta = pTipoRespostaTempoFinal;
            }
            return resposta;

        }

    }

    @Override
    public boolean notificarViaMenu(ComoDialogo pDialogo) {
        return notificadorJsf.notificarViaMenu(pDialogo);
    }

    @Override
    public boolean notificarViaBloqueioTEla(ComoDialogo pDialogo) {
        return notificadorJsf.notificarViaBloqueioTEla(pDialogo);
    }

    @Override
    public String getTokenDispositivoNotificacao(ComoUsuario pUsuario) {
        return null;
    }

}
