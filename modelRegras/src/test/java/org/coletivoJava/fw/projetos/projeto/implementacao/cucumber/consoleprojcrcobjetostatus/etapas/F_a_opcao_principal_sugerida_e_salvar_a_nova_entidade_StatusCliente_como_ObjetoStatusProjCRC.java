package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.etapas;

import br.org.carameloCode.erp.modulo.projeto.console.ItemOpcaoConsole;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoStatusProjCRC;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetostatus.EtapasconsoleProjCRCObjetoStatus;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.FluxoConsoleObjetoStatus;
import org.junit.Assert;

public class F_a_opcao_principal_sugerida_e_salvar_a_nova_entidade_StatusCliente_como_ObjetoStatusProjCRC {

    @E(EtapasconsoleProjCRCObjetoStatus.E_A_OPCAO_PRINCIPAL_SUGERIDA_E_SALVAR_A_NOVA_ENTIDADE_STATUSCLIENTE_COMO_OBJETOSTATUSPROJCRC)
    public void implementacaoEtapa() {
        // Opção principal: ação de salvar entidade
        ItemOpcaoConsole opcao = FluxoConsoleObjetoStatus.CONSOLE.getOpcaoPrincipalSugerida();
        Assert.assertNotNull("Nenhuma opção principal sugerida para " + FluxoConsoleObjetoStatus.NOME_ENTIDADE_STATUS_CLIENTE, opcao);
        Assert.assertEquals("A opção principal deveria ser salvar a entidade",
                FluxoConsoleObjetoStatus.ACAO_SALVAR_ENTIDADE, opcao.getFabAcaoCriarItem());

        // Item associado: entidade de status
        Object itemAssociado = opcao.getItemAssociado();
        Assert.assertTrue("O item associado deveria ser um ObjetoStatusProjCRC", itemAssociado instanceof ObjetoStatusProjCRC);

        // Entidade nova, ainda não persistida
        ObjetoStatusProjCRC entidadeACriar = (ObjetoStatusProjCRC) itemAssociado;
        Assert.assertEquals("Nome da entidade a criar incorreto",
                FluxoConsoleObjetoStatus.NOME_ENTIDADE_STATUS_CLIENTE, entidadeACriar.getNomeEntidade());
        Assert.assertNull("A entidade a criar não deveria estar persistida", entidadeACriar.getId());
    }
}
