package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.ItemFabrica;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcfabentidadeestatica.EtapasconsoleProjCRCFabEntidadeEstatica;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.FluxoConsoleFabEntidadeEstatica;
import org.junit.Assert;

public class K_Entao_o_item_CLIENTE_VIP_fica_salvo_em_FabTipoCliente_com_idObjeto_1 {

    @Entao(EtapasconsoleProjCRCFabEntidadeEstatica.ENTAO_O_ITEM_CLIENTE_VIP_FICA_SALVO_EM_FABTIPOCLIENTE_COM_IDOBJETO_1)
    public void implementacaoEtapa() {
        String nomeEnum = FluxoConsoleFabEntidadeEstatica.NOME_ENUM_CLIENTE_VIP;
        long idObjetoEsperado = FluxoConsoleFabEntidadeEstatica.ID_OBJETO_CLIENTE_VIP;

        // Recarrega do banco e confere fábrica, persistência, idObjeto e nome do objeto
        ItemFabrica itemSalvo = FluxoConsoleFabEntidadeEstatica.verificarItemSalvo(nomeEnum, idObjetoEsperado);

        Assert.assertEquals("Fábrica do item " + nomeEnum + " incorreta",
                FluxoConsoleFabEntidadeEstatica.NOME_FABRICA_TIPO_CLIENTE, itemSalvo.getFabrica().getNomeFabrica());
    }
}
