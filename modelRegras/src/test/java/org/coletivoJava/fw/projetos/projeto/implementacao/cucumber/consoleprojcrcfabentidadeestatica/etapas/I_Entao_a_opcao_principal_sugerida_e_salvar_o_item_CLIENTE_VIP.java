package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.ItemFabrica;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcfabentidadeestatica.EtapasconsoleProjCRCFabEntidadeEstatica;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.FluxoConsoleFabEntidadeEstatica;
import org.junit.Assert;

public class I_Entao_a_opcao_principal_sugerida_e_salvar_o_item_CLIENTE_VIP {

    @Entao(EtapasconsoleProjCRCFabEntidadeEstatica.ENTAO_A_OPCAO_PRINCIPAL_SUGERIDA_E_SALVAR_O_ITEM_CLIENTE_VIP)
    public void implementacaoEtapa() {
        String nomeEnumEsperado = FluxoConsoleFabEntidadeEstatica.NOME_ENUM_CLIENTE_VIP;

        // clienteVip digitado em camelCase deve virar CLIENTE_VIP
        ItemFabrica itemACriar = FluxoConsoleFabEntidadeEstatica.getItemDaOpcaoPrincipalDeCriacao(nomeEnumEsperado);

        Assert.assertEquals("Nome do enum do item a criar incorreto", nomeEnumEsperado, itemACriar.getNomeEnum());
    }
}
