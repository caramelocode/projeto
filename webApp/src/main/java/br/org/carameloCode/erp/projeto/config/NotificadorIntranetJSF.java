/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.projeto.config;

import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ComoServicoComunicacaoUI;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.declarados.webSite.InfoWebApp;
import com.super_bits.modulosSB.webPaginas.util.UtilSBWPServletTools;
import com.super_bits.modulosSB.webPaginas.util.UtilSBWP_JSFTools;

/**
 *
 * @author salvio
 */
public class NotificadorIntranetJSF implements ComoServicoComunicacaoUI {

    @Override
    public boolean notificarViaMenu(ItfDialogo pDialogo) {
        InfoWebApp aplicacao = (InfoWebApp) UtilSBWPServletTools.getBeanByNamed("infoWebApp", InfoWebApp.class);
        return aplicacao.publicar(pDialogo);

    }

    @Override
    public boolean notificarViaBloqueioTEla(ItfDialogo pDialogo) {
        InfoWebApp aplicacao = (InfoWebApp) UtilSBWPServletTools.getBeanByNamed("infoWebApp", InfoWebApp.class);
        return aplicacao.publicar(pDialogo);
    }

}
