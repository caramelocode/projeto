package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRC;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;
import org.junit.Assert;

public class O_Entao_o_ItemOpcaoConsole_de_criacao_usa_Cliente_como_nome_do_modulo_e_como_entidade_de_dominio {

    @Entao(EtapasconsoleProjCRCAcoes.ENTAO_O_ITEMOPCAOCONSOLE_DE_CRIACAO_USA_CLIENTE_COMO_NOME_DO_MODULO_E_COMO_ENTIDADE_DE_DOMINIO)
    public void implementacaoEtapa() {
        AcaoProjCRC acao = FluxoConsoleAcoes.getAcaoDaOpcaoPrincipalDeCriacao(FluxoConsoleAcoes.FABRICA_CLIENTE, FluxoConsoleAcoes.ACAO_CLIENTE_FRM_LISTAR);
        Assert.assertEquals("Nome do módulo incorreto", FluxoConsoleAcoes.NOME_ENTIDADE_CLIENTE, acao.getModulo().getNome());
        Assert.assertNotNull("A ação deveria ter a entidade de domínio " + FluxoConsoleAcoes.NOME_ENTIDADE_CLIENTE, acao.getEntidadeDominio());
        Assert.assertEquals("Entidade de domínio incorreta", FluxoConsoleAcoes.NOME_ENTIDADE_CLIENTE, acao.getEntidadeDominio().getNomeEntidade());
    }
}
