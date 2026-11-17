package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import cucumber.api.java.pt.Entao;
import java.util.List;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcfabentidadeestatica.EtapasconsoleProjCRCFabEntidadeEstatica;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.FluxoConsoleFabEntidadeEstatica;
import org.junit.Assert;

public class D_Entao_o_console_identifica_o_texto_como_fabrica_de_entidade_generica {

    @Entao(EtapasconsoleProjCRCFabEntidadeEstatica.ENTAO_O_CONSOLE_IDENTIFICA_O_TEXTO_COMO_FABRICA_DE_ENTIDADE_GENERICA)
    public void implementacaoEtapa() {
        FabTipoItemProjeto tipoIdentificado = FluxoConsoleFabEntidadeEstatica.CONSOLE.getTipoPesquisa();
        Assert.assertEquals("Tipo de pesquisa identificado incorreto", FluxoConsoleFabEntidadeEstatica.TIPO_FABRICA, tipoIdentificado);

        // Fábrica inexistente: o autocompletar sugere o próprio nome digitado
        List<String> sugestoes = FluxoConsoleFabEntidadeEstatica.sugestoesAutocompletar;
        String textoDigitado = FluxoConsoleFabEntidadeEstatica.TEXTO_FABRICA_TIPO_CLIENTE;
        Assert.assertTrue("O autocompletar deveria sugerir " + textoDigitado + ", sugeriu " + sugestoes,
                sugestoes.contains(textoDigitado));
    }
}
