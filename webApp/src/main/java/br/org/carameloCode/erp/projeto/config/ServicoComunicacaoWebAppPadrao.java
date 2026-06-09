/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.projeto.config;

import br.org.carameloCode.erp.modulo.notificacao.controller.ServicoNotificacaoComPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ERPTipoCanalComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.FabTipoRespostaComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfTipoCanalComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItffabricaCanalComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ComoServicoComunicacao;
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
    public FabTipoRespostaComunicacao aguardarRespostaComunicacao(ItfTipoCanalComunicacao pCanal, ItfDialogo pComunicacao, int pTempoAguardar, FabTipoRespostaComunicacao pTipoRespostaTempoFinal) {

        if (SBCore.isEmModoDesenvolvimento()) {
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
            notificadorJsf.notificarViaBloqueioTEla(pComunicacao);
            throw new UnsupportedOperationException("MEtodo aguardar resposta moodo web não implementado ainda");

        }

    }

    @Override
    public boolean notificarViaMenu(ItfDialogo pDialogo) {
        return notificadorJsf.notificarViaMenu(pDialogo);
    }

    @Override
    public boolean notificarViaBloqueioTEla(ItfDialogo pDialogo) {
        return notificadorJsf.notificarViaBloqueioTEla(pDialogo);
    }

    @Override
    public String getTokenDispositivoNotificacao(ComoUsuario pUsuario) {
        return null;
    }

}
