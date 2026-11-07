package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.etapas;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.entidade.FabAcaoCarameloDevComoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.console.ItemOpcaoConsole;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetos.EtapasconsoleProjCRCObjetos;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;

public class F_a_opcao_principal_sugerida_e_criar_entidade_Cliente {

    @E(EtapasconsoleProjCRCObjetos.E_A_OPCAO_PRINCIPAL_SUGERIDA_E_CRIAR_ENTIDADE_CLIENTE)
    public void implementacaoEtapa() {
        ItemOpcaoConsole opcao = FluxoConsoleObjetos.CONSOLE.getOpcaoPrincipalSugerida();
        Assert.assertNotNull("Nenhuma opção principal sugerida", opcao);
        Assert.assertEquals("Ação sugerida diferente da esperada", FabAcaoCarameloDevComoItemProjeto.ENTIDADE_CTR_SALVAR, opcao.getFabAcaoAssociada());
        Assert.assertTrue("A opção principal deveria estar associada a uma entidade", opcao.getItemAssociado() instanceof ObjetoProjCRC);
        Assert.assertEquals("Nome da entidade a criar incorreto", FluxoConsoleObjetos.NOME_ENTIDADE_CLIENTE,
                ((ObjetoProjCRC) opcao.getItemAssociado()).getNomeEntidade());
    }
}
