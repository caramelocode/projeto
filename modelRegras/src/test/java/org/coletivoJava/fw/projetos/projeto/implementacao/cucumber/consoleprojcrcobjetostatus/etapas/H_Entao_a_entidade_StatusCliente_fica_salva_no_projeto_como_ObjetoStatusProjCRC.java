package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoStatusProjCRC;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetostatus.EtapasconsoleProjCRCObjetoStatus;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.FluxoConsoleObjetoStatus;
import org.junit.Assert;

public class H_Entao_a_entidade_StatusCliente_fica_salva_no_projeto_como_ObjetoStatusProjCRC {

    @Entao(EtapasconsoleProjCRCObjetoStatus.ENTAO_A_ENTIDADE_STATUSCLIENTE_FICA_SALVA_NO_PROJETO_COMO_OBJETOSTATUSPROJCRC)
    public void implementacaoEtapa() {
        // Recarrega do banco e confere persistência e classe ObjetoStatusProjCRC
        ObjetoStatusProjCRC entidadeSalva = FluxoConsoleObjetoStatus.verificarEntidadeStatusSalva();

        Assert.assertEquals("Nome da entidade salva incorreto",
                FluxoConsoleObjetoStatus.NOME_ENTIDADE_STATUS_CLIENTE, entidadeSalva.getNomeEntidade());
        Assert.assertNotNull("A entidade salva deveria estar vinculada a um projeto", entidadeSalva.getProjeto());
        Assert.assertEquals("Projeto da entidade salva incorreto",
                FluxoConsoleObjetoStatus.projeto.getId(), entidadeSalva.getProjeto().getId());
    }
}
