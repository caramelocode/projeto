package br.org.carameloCode.erp.projeto.config;

import com.super_bits.modulosSB.webPaginas.push.NotificadorIntranetJSF;
import br.org.carameloCode.erp.modulo.notificacao.controller.ServicoNotificacaoComPersistencia;
import br.org.coletivoJava.fw.erp.implementacao.chat.atendente.EscutaAtendenteMatrixAbst;
import br.org.coletivoJava.fw.erp.implementacao.chat.atendente.RepositorioJanelasChatAtendimento;
import br.org.coletivoJava.fw.erp.implementacao.chat.atendente.janelaChat.GestaoNotificacaoJanelaChat;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.FabTipoRespostaComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ComoDialogo;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfTipoCanalComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.chat.NotificacaoUsuarioJanelaChat;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ComoServicoComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ErroDetectandoTelaBloqueio;
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

            return notificadorJsf.aguardarRespostaComunicacaoModalTransitorio(pCanal, pComunicacao, pTempoAguardar, pTipoRespostaTempoFinal);
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

    @Override
    public NotificacaoUsuarioJanelaChat gerarGestaoNotificacaoChat(String pEmailAtendimento) {
        if (CarameloCode.getServicoSessao().getSessaoAtual().isIdentificado()) {
            return new GestaoNotificacaoJanelaChat((ComoUsuario) CarameloCode.getServicoSessao().getSessaoAtual().getUsuario(),
                    RepositorioJanelasChatAtendimento.getServico().getServicoUrlCliente().getUrlChatBaseUsuario(CarameloCode.getServicoPermissao().getUsuarioByEmail(pEmailAtendimento)));

        } else {
            return null;
        }
    }

}
