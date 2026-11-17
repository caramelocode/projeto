package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import cucumber.api.java.pt.Entao;
import java.util.List;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetostatus.EtapasconsoleProjCRCObjetoStatus;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.FluxoConsoleObjetoStatus;
import org.junit.Assert;

public class L_Entao_o_console_identifica_o_texto_como_fabrica_de_status {

    @Entao(EtapasconsoleProjCRCObjetoStatus.ENTAO_O_CONSOLE_IDENTIFICA_O_TEXTO_COMO_FABRICA_DE_STATUS)
    public void implementacaoEtapa() {
        FabTipoItemProjeto tipoIdentificado = FluxoConsoleObjetoStatus.CONSOLE.getTipoPesquisa();
        Assert.assertEquals("Tipo de pesquisa identificado incorreto", FluxoConsoleObjetoStatus.TIPO_FABRICA, tipoIdentificado);

        // Fábrica existente: o autocompletar sugere o nome da fábrica
        List<String> sugestoes = FluxoConsoleObjetoStatus.sugestoesAutocompletar;
        String nomeFabrica = FluxoConsoleObjetoStatus.NOME_FABRICA_STATUS_CLIENTE;
        Assert.assertTrue("O autocompletar deveria sugerir " + nomeFabrica + ", sugeriu " + sugestoes,
                sugestoes.contains(nomeFabrica));
    }
}
