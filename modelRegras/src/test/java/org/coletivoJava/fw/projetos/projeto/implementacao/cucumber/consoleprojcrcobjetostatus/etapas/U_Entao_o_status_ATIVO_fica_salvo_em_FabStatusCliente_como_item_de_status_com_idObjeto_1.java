package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.ItemFabricaStatus;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetostatus.EtapasconsoleProjCRCObjetoStatus;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.FluxoConsoleObjetoStatus;
import org.junit.Assert;

public class U_Entao_o_status_ATIVO_fica_salvo_em_FabStatusCliente_como_item_de_status_com_idObjeto_1 {

    @Entao(EtapasconsoleProjCRCObjetoStatus.ENTAO_O_STATUS_ATIVO_FICA_SALVO_EM_FABSTATUSCLIENTE_COMO_ITEM_DE_STATUS_COM_IDOBJETO_1)
    public void implementacaoEtapa() {
        String nomeEnum = FluxoConsoleObjetoStatus.NOME_ENUM_STATUS_ATIVO;
        long idObjetoEsperado = FluxoConsoleObjetoStatus.ID_OBJETO_STATUS_ATIVO;

        // Recarrega do banco e confere fábrica, persistência, tipo ItemFabricaStatus e idObjeto
        ItemFabricaStatus statusSalvo = FluxoConsoleObjetoStatus.verificarStatusSalvo(nomeEnum, idObjetoEsperado);

        Assert.assertEquals("Fábrica do status " + nomeEnum + " incorreta",
                FluxoConsoleObjetoStatus.NOME_FABRICA_STATUS_CLIENTE, statusSalvo.getFabrica().getNomeFabrica());
    }
}
