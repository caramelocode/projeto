package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.etapas;

import br.org.carameloCode.erp.modulo.projeto.console.ItemOpcaoConsole;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.ItemFabricaStatus;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetostatus.EtapasconsoleProjCRCObjetoStatus;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.FluxoConsoleObjetoStatus;
import org.junit.Assert;

public class AF_a_opcao_principal_sugerida_e_editar_o_status_INADIMPLENTE {

    @E(EtapasconsoleProjCRCObjetoStatus.E_A_OPCAO_PRINCIPAL_SUGERIDA_E_EDITAR_O_STATUS_INADIMPLENTE)
    public void implementacaoEtapa() {
        String nomeEnum = FluxoConsoleObjetoStatus.NOME_ENUM_STATUS_INADIMPLENTE;

        // Opção principal: ação de editar o status
        ItemOpcaoConsole opcao = FluxoConsoleObjetoStatus.CONSOLE.getOpcaoPrincipalSugerida();
        Assert.assertNotNull("Nenhuma opção principal sugerida para o status " + nomeEnum, opcao);
        Assert.assertEquals("A opção principal deveria ser editar o status",
                FluxoConsoleObjetoStatus.ACAO_EDITAR_STATUS, opcao.getFabAcaoAssociada());

        // Item associado: o status já persistido
        Object itemAssociado = opcao.getItemAssociado();
        Assert.assertTrue("O item associado deveria ser um item de status", itemAssociado instanceof ItemFabricaStatus);
        ItemFabricaStatus statusAEditar = (ItemFabricaStatus) itemAssociado;
        Assert.assertEquals("Nome do enum do status a editar incorreto", nomeEnum, statusAEditar.getNomeEnum());
        Assert.assertNotNull("O status a editar deveria estar persistido", statusAEditar.getId());
        Assert.assertEquals("idObjeto do status a editar incorreto",
                Long.valueOf(FluxoConsoleObjetoStatus.ID_OBJETO_STATUS_INADIMPLENTE), statusAEditar.getIdObjeto());
    }
}
