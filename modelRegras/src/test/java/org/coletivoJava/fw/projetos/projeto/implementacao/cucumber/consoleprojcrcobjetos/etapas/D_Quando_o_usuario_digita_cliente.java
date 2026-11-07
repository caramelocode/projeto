package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetos.EtapasconsoleProjCRCObjetos;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;

public class D_Quando_o_usuario_digita_cliente {

    @Quando(EtapasconsoleProjCRCObjetos.QUANDO_O_USUARIO_DIGITA_CLIENTE)
    public void implementacaoEtapa() {
        FluxoConsoleObjetos.sugestoesAutocompletar = FluxoConsoleObjetos.CONSOLE.autocompletProjeto(FluxoConsoleObjetos.TEXTO_DIGITADO_CLIENTE);
        Assert.assertNotNull("O autocompletar não retornou sugestões", FluxoConsoleObjetos.sugestoesAutocompletar);
    }
}
