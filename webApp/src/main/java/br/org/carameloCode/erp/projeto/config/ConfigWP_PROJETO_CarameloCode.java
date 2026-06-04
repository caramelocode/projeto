/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.carameloCode.erp.projeto.config;

import com.super_bits.modulos.SBAcessosModel.fabricas.FabAcaoProjetoSB;
import com.super_bits.modulos.SBAcessosModel.view.FabAcaoPaginasDoSistema;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.ItfAcaoFormulario;
import com.super_bits.modulosSB.webPaginas.ConfigGeral.ConfiguradorWPPadraoArquivoConfiguracao;
import com.super_bits.modulosSB.webPaginas.ConfigGeral.FabConfigModuloWebAppGenerico;
import com.super_bits.modulosSB.webPaginas.controller.servletes.urls.parametrosURL.ParametroURL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Salvio
 */
public class ConfigWP_PROJETO_CarameloCode extends ConfiguradorWPPadraoArquivoConfiguracao {

    public ConfigWP_PROJETO_CarameloCode() throws IOException {
        super();
    }

    private static List<String> hostAutorizados;

    @Override
    public List<String> getSitesHostsAutorizados() {
        if (hostAutorizados == null) {
            hostAutorizados = new ArrayList<>();
            hostAutorizados.add(SBCore.getConfigModulo(FabConfigModuloWebAppGenerico.class).getPropriedade(FabConfigModuloWebAppGenerico.URL_DOMINIO_APLICACAO));

        }
        return hostAutorizados;
    }

    @Override
    public Class mapaSite() {
        return SiteMap.class;
    }

    @Override
    public List<ParametroURL> parametrosDeAplicacao() {
        return new ArrayList<>();
    }

    @Override
    public ItfAcaoFormulario getAcaoPaginaInicial() {

        return FabAcaoPaginasDoSistema.PAGINA_NATIVA_HOME_MB_PADRAO.getRegistro().getComoFormulario();

    }

    @Override
    public String getPacotePaginas() {
        return "br.org.carameloCode.erp.projeto.paginas";
    }

}
