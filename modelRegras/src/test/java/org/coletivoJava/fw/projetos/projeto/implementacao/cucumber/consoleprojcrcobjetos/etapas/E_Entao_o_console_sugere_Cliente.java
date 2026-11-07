package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetos.EtapasconsoleProjCRCObjetos;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;

public class E_Entao_o_console_sugere_Cliente {

    @Entao(EtapasconsoleProjCRCObjetos.ENTAO_O_CONSOLE_SUGERE_CLIENTE)
    public void implementacaoEtapa() {
        Assert.assertTrue("Sugestão esperada não encontrada",
                FluxoConsoleObjetos.sugestoesAutocompletar.contains(FluxoConsoleObjetos.NOME_ENTIDADE_CLIENTE));
    }
}
