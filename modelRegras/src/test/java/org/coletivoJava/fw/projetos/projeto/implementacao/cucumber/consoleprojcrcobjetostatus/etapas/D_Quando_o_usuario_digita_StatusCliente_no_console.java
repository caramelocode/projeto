package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.etapas;

import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetostatus.EtapasconsoleProjCRCObjetoStatus;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.FluxoConsoleObjetoStatus;
import org.junit.Assert;

public class D_Quando_o_usuario_digita_StatusCliente_no_console {

    @Quando(EtapasconsoleProjCRCObjetoStatus.QUANDO_O_USUARIO_DIGITA_STATUSCLIENTE_NO_CONSOLE)
    public void implementacaoEtapa() {
        String textoDigitado = FluxoConsoleObjetoStatus.TEXTO_ENTIDADE_STATUS_CLIENTE;

        FluxoConsoleObjetoStatus.digitarNoConsole(textoDigitado);

        String textoDefinido = FluxoConsoleObjetoStatus.CONSOLE.getTextoDefinido();
        Assert.assertEquals("Texto definido incorreto", textoDigitado, textoDefinido);
    }
}
