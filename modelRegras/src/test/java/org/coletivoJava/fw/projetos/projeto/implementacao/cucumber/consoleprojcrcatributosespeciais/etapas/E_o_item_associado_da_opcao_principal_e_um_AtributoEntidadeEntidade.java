package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.etapas;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.objeto.FabAcaoCarameloDevEdicaoItemProj;
import br.org.carameloCode.erp.modulo.projeto.console.ItemOpcaoConsole;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeEntidade;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcatributosespeciais.EtapasconsoleProjCRCAtributosEspeciais;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.FluxoConsoleAtributosEspeciais;
import org.junit.Assert;

public class E_o_item_associado_da_opcao_principal_e_um_AtributoEntidadeEntidade {

    @E(EtapasconsoleProjCRCAtributosEspeciais.E_O_ITEM_ASSOCIADO_DA_OPCAO_PRINCIPAL_E_UM_ATRIBUTOENTIDADEENTIDADE)
    public void implementacaoEtapa() {
        ItemOpcaoConsole opcao = FluxoConsoleAtributosEspeciais.CONSOLE.getOpcaoPrincipalSugerida();
        Assert.assertNotNull("Nenhuma opção principal sugerida", opcao);
        Assert.assertTrue("O item associado deveria ser um AtributoEntidadeEntidade", opcao.getItemAssociado() instanceof AtributoEntidadeEntidade);
        AtributoEntidadeEntidade atributo = (AtributoEntidadeEntidade) opcao.getItemAssociado();
        Assert.assertNotNull("O atributo objeto deveria ter uma entidade referenciada", atributo.getEntidadeReferenciada());
        Assert.assertNotNull("A opção deveria ter um formulário de detalhes", opcao.getAcaoFormularioEditar());
        Assert.assertEquals("Formulário de detalhes incorreto", FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_FRM_EDITAR_OBJETO.getNomeUnico(),
                opcao.getAcaoFormularioEditar().getNomeUnico());
    }
}
