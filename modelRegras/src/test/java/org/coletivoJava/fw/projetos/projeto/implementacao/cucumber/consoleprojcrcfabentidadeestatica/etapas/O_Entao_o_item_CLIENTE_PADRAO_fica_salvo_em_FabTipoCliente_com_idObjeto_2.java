package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.ItemFabrica;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcfabentidadeestatica.EtapasconsoleProjCRCFabEntidadeEstatica;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.FluxoConsoleFabEntidadeEstatica;
import org.junit.Assert;

public class O_Entao_o_item_CLIENTE_PADRAO_fica_salvo_em_FabTipoCliente_com_idObjeto_2 {

    @Entao(EtapasconsoleProjCRCFabEntidadeEstatica.ENTAO_O_ITEM_CLIENTE_PADRAO_FICA_SALVO_EM_FABTIPOCLIENTE_COM_IDOBJETO_2)
    public void implementacaoEtapa() {
        String nomeEnum = FluxoConsoleFabEntidadeEstatica.NOME_ENUM_CLIENTE_PADRAO;
        long idObjetoEsperado = FluxoConsoleFabEntidadeEstatica.ID_OBJETO_CLIENTE_PADRAO;

        // Recarrega do banco e confere fábrica, persistência, idObjeto e nome do objeto
        ItemFabrica itemSalvo = FluxoConsoleFabEntidadeEstatica.verificarItemSalvo(nomeEnum, idObjetoEsperado);

        Assert.assertEquals("Fábrica do item " + nomeEnum + " incorreta",
                FluxoConsoleFabEntidadeEstatica.NOME_FABRICA_TIPO_CLIENTE, itemSalvo.getFabrica().getNomeFabrica());
    }
}
