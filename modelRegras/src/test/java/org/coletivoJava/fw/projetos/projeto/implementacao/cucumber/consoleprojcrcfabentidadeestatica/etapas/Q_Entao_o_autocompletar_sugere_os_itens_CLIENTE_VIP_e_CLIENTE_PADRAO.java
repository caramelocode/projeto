package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.etapas;

import cucumber.api.java.pt.Entao;
import java.util.Arrays;
import java.util.List;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcfabentidadeestatica.EtapasconsoleProjCRCFabEntidadeEstatica;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.FluxoConsoleFabEntidadeEstatica;
import org.junit.Assert;

public class Q_Entao_o_autocompletar_sugere_os_itens_CLIENTE_VIP_e_CLIENTE_PADRAO {

    @Entao(EtapasconsoleProjCRCFabEntidadeEstatica.ENTAO_O_AUTOCOMPLETAR_SUGERE_OS_ITENS_CLIENTE_VIP_E_CLIENTE_PADRAO)
    public void implementacaoEtapa() {
        String sugestaoClienteVip = FluxoConsoleFabEntidadeEstatica.getTextoItem(FluxoConsoleFabEntidadeEstatica.NOME_ENUM_CLIENTE_VIP);
        String sugestaoClientePadrao = FluxoConsoleFabEntidadeEstatica.getTextoItem(FluxoConsoleFabEntidadeEstatica.NOME_ENUM_CLIENTE_PADRAO);

        // Somente os itens existentes, na ordem do idObjeto
        List<String> sugestoesEsperadas = Arrays.asList(sugestaoClienteVip, sugestaoClientePadrao);
        List<String> sugestoesRecebidas = FluxoConsoleFabEntidadeEstatica.sugestoesAutocompletar;

        Assert.assertEquals("Sugestões do autocompletar incorretas", sugestoesEsperadas, sugestoesRecebidas);
    }
}
