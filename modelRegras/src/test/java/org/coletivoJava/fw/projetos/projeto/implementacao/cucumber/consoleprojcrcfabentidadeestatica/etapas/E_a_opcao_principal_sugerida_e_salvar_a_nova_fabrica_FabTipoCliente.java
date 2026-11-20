package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.etapas;

import br.org.carameloCode.erp.modulo.projeto.console.ItemOpcaoConsole;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaEntidadeProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaStatusProjCRC;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcfabentidadeestatica.EtapasconsoleProjCRCFabEntidadeEstatica;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.FluxoConsoleFabEntidadeEstatica;
import org.junit.Assert;

public class E_a_opcao_principal_sugerida_e_salvar_a_nova_fabrica_FabTipoCliente {

    @E(EtapasconsoleProjCRCFabEntidadeEstatica.E_A_OPCAO_PRINCIPAL_SUGERIDA_E_SALVAR_A_NOVA_FABRICA_FABTIPOCLIENTE)
    public void implementacaoEtapa() {
        // Opção principal: ação de salvar fábrica genérica
        ItemOpcaoConsole opcao = FluxoConsoleFabEntidadeEstatica.CONSOLE.getOpcaoPrincipalSugerida();
        Assert.assertNotNull("Nenhuma opção principal sugerida para a fábrica " + FluxoConsoleFabEntidadeEstatica.NOME_FABRICA_TIPO_CLIENTE, opcao);
        Assert.assertEquals("A opção principal deveria ser salvar a fábrica",
                FluxoConsoleFabEntidadeEstatica.ACAO_SALVAR_FABRICA, opcao.getFabAcaoCriarItem());

        // Item associado: fábrica genérica (não de status)
        Object itemAssociado = opcao.getItemAssociado();
        Assert.assertTrue("O item associado deveria ser uma fábrica", itemAssociado instanceof FabricaEntidadeProjCRC);
        Assert.assertFalse("O item associado não deveria ser uma fábrica de status", itemAssociado instanceof FabricaStatusProjCRC);

        // Fábrica nova, ainda não persistida
        FabricaEntidadeProjCRC fabricaACriar = (FabricaEntidadeProjCRC) itemAssociado;
        Assert.assertEquals("Nome da fábrica a criar incorreto",
                FluxoConsoleFabEntidadeEstatica.NOME_FABRICA_TIPO_CLIENTE, fabricaACriar.getNomeFabrica());
        Assert.assertEquals("Tipo da fábrica a criar incorreto",
                FluxoConsoleFabEntidadeEstatica.TIPO_FABRICA, fabricaACriar.getTipoItemProjeto());
        Assert.assertNull("A fábrica a criar não deveria estar persistida", fabricaACriar.getId());
    }
}
