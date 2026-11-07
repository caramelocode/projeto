package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;
import org.junit.Assert;

public class R_Quando_o_usuario_digita_FabAcaoGerenteCliente_o_CLIENTE_FRM_LISTAR_antes_de_criar_a_gestao {

    @Quando(EtapasconsoleProjCRCAcoes.QUANDO_O_USUARIO_DIGITA_FABACAOGERENTECLIENTE_O_CLIENTE_FRM_LISTAR_ANTES_DE_CRIAR_A_GESTAO)
    public void implementacaoEtapa() {
        String textoDigitado = FluxoConsoleAcoes.getTextoFabricaAcao(FluxoConsoleAcoes.FABRICA_GERENTE_CLIENTE, FluxoConsoleAcoes.ACAO_CLIENTE_FRM_LISTAR);
        FluxoConsoleAcoes.sugestoesAutocompletar = FluxoConsoleAcoes.CONSOLE.autocompletProjeto(textoDigitado);
        Assert.assertNotNull("O autocompletar não retornou sugestões", FluxoConsoleAcoes.sugestoesAutocompletar);
        Assert.assertEquals("Texto definido incorreto", textoDigitado, FluxoConsoleAcoes.CONSOLE.getTextoDefinido());
    }
}
