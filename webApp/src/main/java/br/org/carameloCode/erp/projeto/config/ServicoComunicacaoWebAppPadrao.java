/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.projeto.config;

import br.org.carameloCode.erp.modulo.notificacao.controller.ServicoNotificacaoComPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ERPTipoCanalComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.FabTipoRespostaComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfTipoCanalComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItffabricaCanalComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ComoServicoComunicacao;

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
        throw new UnsupportedOperationException("Not supported yet.");
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
