package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetos.EtapasconsoleProjCRCObjetos;
import cucumber.api.java.pt.Quando;
import java.lang.UnsupportedOperationException;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;

public class J_Quando_o_usuario_digita_apenas_Cli {

    @Quando(EtapasconsoleProjCRCObjetos.QUANDO_O_USUARIO_DIGITA_APENAS_CLI)
    public void implementacaoEtapa() {
        FluxoConsoleObjetos.sugestoesAutocompletar = FluxoConsoleObjetos.CONSOLE.autocompletProjeto(FluxoConsoleObjetos.TEXTO_PARCIAL_CLI);
        Assert.assertNotNull("O autocompletar não retornou sugestões", FluxoConsoleObjetos.sugestoesAutocompletar);
        Assert.assertEquals("Texto definido incorreto", FluxoConsoleObjetos.TEXTO_PARCIAL_CLI, FluxoConsoleObjetos.CONSOLE.getTextoDefinido());
    }
}
