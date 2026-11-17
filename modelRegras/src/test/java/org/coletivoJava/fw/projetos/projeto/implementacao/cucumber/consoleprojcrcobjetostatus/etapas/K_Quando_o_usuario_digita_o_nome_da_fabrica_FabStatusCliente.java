package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.etapas;

import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetostatus.EtapasconsoleProjCRCObjetoStatus;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.FluxoConsoleObjetoStatus;
import org.junit.Assert;

public class K_Quando_o_usuario_digita_o_nome_da_fabrica_FabStatusCliente {

    @Quando(EtapasconsoleProjCRCObjetoStatus.QUANDO_O_USUARIO_DIGITA_O_NOME_DA_FABRICA_FABSTATUSCLIENTE)
    public void implementacaoEtapa() {
        String textoDigitado = FluxoConsoleObjetoStatus.TEXTO_FABRICA_STATUS_CLIENTE;

        FluxoConsoleObjetoStatus.digitarNoConsole(textoDigitado);

        String textoDefinido = FluxoConsoleObjetoStatus.CONSOLE.getTextoDefinido();
        Assert.assertEquals("Texto definido incorreto", textoDigitado, textoDefinido);
    }
}
