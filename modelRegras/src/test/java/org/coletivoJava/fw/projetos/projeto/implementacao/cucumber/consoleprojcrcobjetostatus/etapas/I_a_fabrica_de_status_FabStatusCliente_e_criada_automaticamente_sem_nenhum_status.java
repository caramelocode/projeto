package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaStatusProjCRC;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetostatus.EtapasconsoleProjCRCObjetoStatus;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.FluxoConsoleObjetoStatus;
import org.junit.Assert;

public class I_a_fabrica_de_status_FabStatusCliente_e_criada_automaticamente_sem_nenhum_status {

    @E(EtapasconsoleProjCRCObjetoStatus.E_A_FABRICA_DE_STATUS_FABSTATUSCLIENTE_E_CRIADA_AUTOMATICAMENTE_SEM_NENHUM_STATUS)
    public void implementacaoEtapa() {
        // Recarrega do banco e confere persistência e tipo FABRICA_STATUS
        FabricaStatusProjCRC fabricaSalva = FluxoConsoleObjetoStatus.verificarFabricaStatusSalva();

        Assert.assertEquals("Nome da fábrica criada incorreto",
                FluxoConsoleObjetoStatus.NOME_FABRICA_STATUS_CLIENTE, fabricaSalva.getNomeFabrica());
        boolean semItens = fabricaSalva.getItens() == null || fabricaSalva.getItens().isEmpty();
        Assert.assertTrue("A fábrica de status recém-criada não deveria possuir status", semItens);

        // O console também enxerga a fábrica criada
        FabricaStatusProjCRC fabricaNoRepositorio = FluxoConsoleObjetoStatus.getFabricaStatusDoRepositorio();
        Assert.assertEquals("A fábrica do repositório deveria ser a fábrica salva", fabricaSalva.getId(), fabricaNoRepositorio.getId());
    }
}
