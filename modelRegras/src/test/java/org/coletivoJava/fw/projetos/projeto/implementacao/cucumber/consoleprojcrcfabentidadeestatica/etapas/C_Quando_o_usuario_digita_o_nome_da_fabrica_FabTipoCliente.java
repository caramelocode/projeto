package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.etapas;

import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcfabentidadeestatica.EtapasconsoleProjCRCFabEntidadeEstatica;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.FluxoConsoleFabEntidadeEstatica;
import org.junit.Assert;

public class C_Quando_o_usuario_digita_o_nome_da_fabrica_FabTipoCliente {

    @Quando(EtapasconsoleProjCRCFabEntidadeEstatica.QUANDO_O_USUARIO_DIGITA_O_NOME_DA_FABRICA_FABTIPOCLIENTE)
    public void implementacaoEtapa() {
        String textoDigitado = FluxoConsoleFabEntidadeEstatica.TEXTO_FABRICA_TIPO_CLIENTE;

        FluxoConsoleFabEntidadeEstatica.digitarNoConsole(textoDigitado);

        String textoDefinido = FluxoConsoleFabEntidadeEstatica.CONSOLE.getTextoDefinido();
        Assert.assertEquals("Texto definido incorreto", textoDigitado, textoDefinido);
    }
}
