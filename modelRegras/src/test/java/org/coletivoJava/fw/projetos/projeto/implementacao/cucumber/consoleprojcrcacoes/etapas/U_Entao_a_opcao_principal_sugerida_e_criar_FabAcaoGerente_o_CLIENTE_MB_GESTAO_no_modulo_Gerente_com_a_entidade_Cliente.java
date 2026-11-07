package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRCGestao;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;
import org.junit.Assert;

public class U_Entao_a_opcao_principal_sugerida_e_criar_FabAcaoGerente_o_CLIENTE_MB_GESTAO_no_modulo_Gerente_com_a_entidade_Cliente {

    @Entao(EtapasconsoleProjCRCAcoes.ENTAO_A_OPCAO_PRINCIPAL_SUGERIDA_E_CRIAR_FABACAOGERENTE_O_CLIENTE_MB_GESTAO_NO_MODULO_GERENTE_COM_A_ENTIDADE_CLIENTE)
    public void implementacaoEtapa() {
        AcaoProjCRC acao = FluxoConsoleAcoes.getAcaoDaOpcaoPrincipalDeCriacao(FluxoConsoleAcoes.FABRICA_GERENTE, FluxoConsoleAcoes.ACAO_CLIENTE_MB_GESTAO);
        Assert.assertTrue("A ação a criar deveria ser uma ação de gestão", acao instanceof AcaoProjCRCGestao);
        Assert.assertEquals("Nome do módulo incorreto", FluxoConsoleAcoes.NOME_MODULO_GERENTE, acao.getModulo().getNome());
        Assert.assertNotNull("A ação deveria ter a entidade de domínio " + FluxoConsoleAcoes.NOME_ENTIDADE_CLIENTE, acao.getEntidadeDominio());
        Assert.assertEquals("Entidade de domínio incorreta", FluxoConsoleAcoes.NOME_ENTIDADE_CLIENTE, acao.getEntidadeDominio().getNomeEntidade());
    }
}
