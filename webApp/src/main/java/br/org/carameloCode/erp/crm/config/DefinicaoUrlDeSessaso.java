package br.org.carameloCode.erp.crm.config;

import javax.enterprise.context.SessionScoped;
import com.super_bits.modulosSB.webPaginas.controller.listenners.ItfDefinicaoUrlHostDeSessao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoSessao;
import com.super_bits.modulosSB.webPaginas.ConfigGeral.FabConfigModuloWebAppGenerico;

/**
 *
 * @author salvio
 */
@SessionScoped
public class DefinicaoUrlDeSessaso implements ItfDefinicaoUrlHostDeSessao {

    @Override
    public String gerarUrlDeAcesso(ComoSessao pAcesso) {

        return FabConfigModuloWebAppGenerico.URL_DOMINIO_APLICACAO.getValorParametroSistema();
    }

}
