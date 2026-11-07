package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;
import org.junit.Assert;

public class F_Entao_o_autocompletar_sugere_FabAcaoGerenteCliente_e_FabAcaoGerente_o_CLIENTE_pela_entidade_cadastrada_mais_recentemente {

    @Entao(EtapasconsoleProjCRCAcoes.ENTAO_O_AUTOCOMPLETAR_SUGERE_FABACAOGERENTECLIENTE_E_FABACAOGERENTE_O_CLIENTE_PELA_ENTIDADE_CADASTRADA_MAIS_RECENTEMENTE)
    public void implementacaoEtapa() {
        ObjetoProjCRC maisRecente = FluxoConsoleAcoes.CONSOLE.getRepositorio().getEntidadeMaisRecente();
        Assert.assertNotNull("Nenhuma entidade no projeto", maisRecente);
        Assert.assertEquals("A entidade cadastrada mais recentemente deveria ser " + FluxoConsoleAcoes.NOME_ENTIDADE_CLIENTE,
                FluxoConsoleAcoes.NOME_ENTIDADE_CLIENTE, maisRecente.getNomeEntidade());

        Assert.assertTrue("O autocompletar não sugeriu " + FluxoConsoleAcoes.FABRICA_GERENTE_CLIENTE + ": " + FluxoConsoleAcoes.sugestoesAutocompletar,
                FluxoConsoleAcoes.sugestoesAutocompletar.contains(FluxoConsoleAcoes.FABRICA_GERENTE_CLIENTE));
        String fabricaComEntidadeNaAcao = FluxoConsoleAcoes.getTextoFabricaAcao(FluxoConsoleAcoes.FABRICA_GERENTE, FluxoConsoleAcoes.ENTIDADE_ACAO_CLIENTE);
        Assert.assertTrue("O autocompletar não sugeriu " + fabricaComEntidadeNaAcao + ": " + FluxoConsoleAcoes.sugestoesAutocompletar,
                FluxoConsoleAcoes.sugestoesAutocompletar.contains(fabricaComEntidadeNaAcao));
    }
}
