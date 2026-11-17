package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.etapas;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.entidade.FabAcaoCarameloDevComoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.console.ItemOpcaoConsole;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeLista;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcatributosespeciais.EtapasconsoleProjCRCAtributosEspeciais;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.FluxoConsoleAtributosEspeciais;
import org.junit.Assert;

public class N_o_item_associado_da_opcao_principal_e_um_AtrubutoEntidadeLista {

    @E(EtapasconsoleProjCRCAtributosEspeciais.E_O_ITEM_ASSOCIADO_DA_OPCAO_PRINCIPAL_E_UM_ATRUBUTOENTIDADELISTA)
    public void implementacaoEtapa() {
        ItemOpcaoConsole opcao = FluxoConsoleAtributosEspeciais.CONSOLE.getOpcaoPrincipalSugerida();
        Assert.assertNotNull("Nenhuma opção principal sugerida", opcao);
        Assert.assertTrue("O item associado deveria ser um AtrubutoEntidadeLista", opcao.getItemAssociado() instanceof AtributoEntidadeLista);
        AtributoEntidadeLista atributo = (AtributoEntidadeLista) opcao.getItemAssociado();
        Assert.assertNotNull("O atributo lista deveria ter a entidade dos itens", atributo.getEntidadeItemLista());
        Assert.assertNotNull("A opção deveria ter um formulário de detalhes", opcao.getAcaoFormularioDetalhes());
        Assert.assertEquals("Formulário de detalhes incorreto", FabAcaoCarameloDevComoItemProjeto.ATRIBUTO_ENTIDADE_FRM_EDITAR_LISTA.getNomeUnico(),
                opcao.getAcaoFormularioDetalhes().getNomeUnico());
    }
}
