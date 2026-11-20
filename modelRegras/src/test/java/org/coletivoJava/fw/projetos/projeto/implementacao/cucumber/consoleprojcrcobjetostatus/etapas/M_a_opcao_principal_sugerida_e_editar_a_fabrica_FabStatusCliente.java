package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.etapas;

import br.org.carameloCode.erp.modulo.projeto.console.ItemOpcaoConsole;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaStatusProjCRC;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetostatus.EtapasconsoleProjCRCObjetoStatus;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.FluxoConsoleObjetoStatus;
import org.junit.Assert;

public class M_a_opcao_principal_sugerida_e_editar_a_fabrica_FabStatusCliente {

    @E(EtapasconsoleProjCRCObjetoStatus.E_A_OPCAO_PRINCIPAL_SUGERIDA_E_EDITAR_A_FABRICA_FABSTATUSCLIENTE)
    public void implementacaoEtapa() {
        // Opção principal: ação de editar fábrica de status
        ItemOpcaoConsole opcao = FluxoConsoleObjetoStatus.CONSOLE.getOpcaoPrincipalSugerida();
        Assert.assertNotNull("Nenhuma opção principal sugerida para a fábrica " + FluxoConsoleObjetoStatus.NOME_FABRICA_STATUS_CLIENTE, opcao);
        Assert.assertEquals("A opção principal deveria ser editar a fábrica",
                FluxoConsoleObjetoStatus.ACAO_EDITAR_FABRICA, opcao.getFabAcaoCriarItem());

        // Item associado: a fábrica de status já persistida
        Object itemAssociado = opcao.getItemAssociado();
        Assert.assertTrue("O item associado deveria ser uma fábrica de status", itemAssociado instanceof FabricaStatusProjCRC);
        FabricaStatusProjCRC fabricaAEditar = (FabricaStatusProjCRC) itemAssociado;
        Assert.assertEquals("Nome da fábrica a editar incorreto",
                FluxoConsoleObjetoStatus.NOME_FABRICA_STATUS_CLIENTE, fabricaAEditar.getNomeFabrica());
        Assert.assertNotNull("A fábrica a editar deveria estar persistida", fabricaAEditar.getId());
    }
}
