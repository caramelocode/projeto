package br.org.carameloCode.erp.projeto.config;

import javax.enterprise.context.SessionScoped;
import com.super_bits.modulosSB.SBCore.modulos.view.telas.ItfDefinicaoUrlHostDeSessao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoSessao;
import com.super_bits.modulosSB.webPaginas.ConfigGeral.FabConfigModuloWebAppGenerico;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<String> getListaURlsPermitidas() {
        return new ArrayList<>();
    }

}
