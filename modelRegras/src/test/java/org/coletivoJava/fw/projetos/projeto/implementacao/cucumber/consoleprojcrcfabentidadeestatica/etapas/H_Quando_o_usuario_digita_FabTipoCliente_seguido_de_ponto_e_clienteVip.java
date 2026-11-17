package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcfabentidadeestatica.EtapasconsoleProjCRCFabEntidadeEstatica;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.FluxoConsoleFabEntidadeEstatica;
import org.junit.Assert;

public class H_Quando_o_usuario_digita_FabTipoCliente_seguido_de_ponto_e_clienteVip {

    @Quando(EtapasconsoleProjCRCFabEntidadeEstatica.QUANDO_O_USUARIO_DIGITA_FABTIPOCLIENTE_SEGUIDO_DE_PONTO_E_CLIENTEVIP)
    public void implementacaoEtapa() {
        String textoDigitado = FluxoConsoleFabEntidadeEstatica.TEXTO_ITEM_CLIENTE_VIP;

        FluxoConsoleFabEntidadeEstatica.digitarNoConsole(textoDigitado);

        String textoDefinido = FluxoConsoleFabEntidadeEstatica.CONSOLE.getTextoDefinido();
        Assert.assertEquals("Texto definido incorreto", textoDigitado, textoDefinido);
        FabTipoItemProjeto tipoIdentificado = FluxoConsoleFabEntidadeEstatica.CONSOLE.getTipoPesquisa();
        Assert.assertEquals("Tipo de pesquisa identificado incorreto", FluxoConsoleFabEntidadeEstatica.TIPO_FABRICA, tipoIdentificado);
    }
}
