package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoStatusProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaStatusProjCRC;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetostatus.EtapasconsoleProjCRCObjetoStatus;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.FluxoConsoleObjetoStatus;
import org.junit.Assert;

public class J_a_entidade_StatusCliente_e_a_fabrica_FabStatusCliente_ficam_vinculadas_nos_dois_sentidos {

    @E(EtapasconsoleProjCRCObjetoStatus.E_A_ENTIDADE_STATUSCLIENTE_E_A_FABRICA_FABSTATUSCLIENTE_FICAM_VINCULADAS_NOS_DOIS_SENTIDOS)
    public void implementacaoEtapa() {
        ObjetoStatusProjCRC entidadeSalva = FluxoConsoleObjetoStatus.verificarEntidadeStatusSalva();
        FabricaStatusProjCRC fabricaSalva = FluxoConsoleObjetoStatus.verificarFabricaStatusSalva();

        // Entidade -> fábrica (lado dono do @OneToOne)
        Assert.assertNotNull("A entidade " + FluxoConsoleObjetoStatus.NOME_ENTIDADE_STATUS_CLIENTE
                + " deveria apontar para a fábrica de status", entidadeSalva.getFabricaStatus());
        Assert.assertEquals("A entidade aponta para a fábrica errada",
                fabricaSalva.getId(), entidadeSalva.getFabricaStatus().getId());
        Assert.assertEquals("Nome padrão da fábrica de status incorreto",
                FluxoConsoleObjetoStatus.NOME_FABRICA_STATUS_CLIENTE, entidadeSalva.getNomeFabricaStatusPadrao());

        // Fábrica -> entidade (mappedBy)
        Assert.assertNotNull("A fábrica " + FluxoConsoleObjetoStatus.NOME_FABRICA_STATUS_CLIENTE
                + " deveria apontar para a entidade de status", fabricaSalva.getEntidadeStatus());
        Assert.assertEquals("A fábrica aponta para a entidade errada",
                entidadeSalva.getId(), fabricaSalva.getEntidadeStatus().getId());
    }
}
