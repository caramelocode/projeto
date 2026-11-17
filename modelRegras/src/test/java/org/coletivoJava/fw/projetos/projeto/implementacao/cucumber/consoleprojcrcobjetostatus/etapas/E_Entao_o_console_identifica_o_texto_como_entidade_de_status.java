package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoStatusProjCRC;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetostatus.EtapasconsoleProjCRCObjetoStatus;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.FluxoConsoleObjetoStatus;
import org.junit.Assert;

public class E_Entao_o_console_identifica_o_texto_como_entidade_de_status {

    @Entao(EtapasconsoleProjCRCObjetoStatus.ENTAO_O_CONSOLE_IDENTIFICA_O_TEXTO_COMO_ENTIDADE_DE_STATUS)
    public void implementacaoEtapa() {
        String textoDefinido = FluxoConsoleObjetoStatus.CONSOLE.getTextoDefinido();
        Assert.assertTrue("O texto " + textoDefinido + " deveria ser reconhecido como nome de entidade de status",
                ObjetoStatusProjCRC.isNomeEntidadeStatus(textoDefinido));

        // Entidade de status é pesquisada como OBJETO (não como fábrica de status)
        FabTipoItemProjeto tipoIdentificado = FluxoConsoleObjetoStatus.CONSOLE.getTipoPesquisa();
        Assert.assertEquals("Tipo de pesquisa identificado incorreto",
                FluxoConsoleObjetoStatus.TIPO_PESQUISA_ENTIDADE_STATUS, tipoIdentificado);

        // O console trata o texto como entidade de status
        boolean ofereceEntidadeStatus = FluxoConsoleObjetoStatus.CONSOLE.getOpcoesDisponiveis().stream()
                .anyMatch(opcao -> opcao.getItemAssociado() instanceof ObjetoStatusProjCRC);
        Assert.assertTrue("Nenhuma opção do console trata " + textoDefinido + " como entidade de status (ObjetoStatusProjCRC)",
                ofereceEntidadeStatus);
    }
}
