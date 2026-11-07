package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;
import org.junit.Assert;

public class AR_Quando_o_usuario_digita_FabAcaoGerente_depois_de_criar_as_acoes_de_Cliente {

    @Quando(EtapasconsoleProjCRCAcoes.QUANDO_O_USUARIO_DIGITA_FABACAOGERENTE_DEPOIS_DE_CRIAR_AS_ACOES_DE_CLIENTE)
    public void implementacaoEtapa() {
        String textoDigitado = FluxoConsoleAcoes.FABRICA_GERENTE;
        FluxoConsoleAcoes.sugestoesAutocompletar = FluxoConsoleAcoes.CONSOLE.autocompletProjeto(textoDigitado);
        Assert.assertNotNull("O autocompletar não retornou sugestões", FluxoConsoleAcoes.sugestoesAutocompletar);
        Assert.assertEquals("Texto definido incorreto", textoDigitado, FluxoConsoleAcoes.CONSOLE.getTextoDefinido());
    }
}
