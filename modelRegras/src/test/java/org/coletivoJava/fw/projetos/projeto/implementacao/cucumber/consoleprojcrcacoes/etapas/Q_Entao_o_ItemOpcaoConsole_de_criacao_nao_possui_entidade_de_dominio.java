package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRC;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;
import org.junit.Assert;

public class Q_Entao_o_ItemOpcaoConsole_de_criacao_nao_possui_entidade_de_dominio {

    @Entao(EtapasconsoleProjCRCAcoes.ENTAO_O_ITEMOPCAOCONSOLE_DE_CRIACAO_NAO_POSSUI_ENTIDADE_DE_DOMINIO)
    public void implementacaoEtapa() {
        AcaoProjCRC acao = FluxoConsoleAcoes.getAcaoDaOpcaoPrincipalDeCriacao(FluxoConsoleAcoes.FABRICA_GERENTE, FluxoConsoleAcoes.ACAO_FORNECEDOR_FRM_LISTAR);
        Assert.assertNull("A ação não deveria ter entidade de domínio, a entidade " + FluxoConsoleAcoes.ENTIDADE_ACAO_INEXISTENTE + " não existe",
                acao.getEntidadeDominio());
        Assert.assertEquals("Nome do módulo incorreto", FluxoConsoleAcoes.NOME_MODULO_GERENTE, acao.getModulo().getNome());
    }
}
