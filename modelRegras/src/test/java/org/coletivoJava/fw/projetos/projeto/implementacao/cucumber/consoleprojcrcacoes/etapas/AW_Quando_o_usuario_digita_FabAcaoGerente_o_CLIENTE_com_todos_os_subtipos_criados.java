package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;
import org.junit.Assert;

public class AW_Quando_o_usuario_digita_FabAcaoGerente_o_CLIENTE_com_todos_os_subtipos_criados {

    @Quando(EtapasconsoleProjCRCAcoes.QUANDO_O_USUARIO_DIGITA_FABACAOGERENTE_O_CLIENTE_COM_TODOS_OS_SUBTIPOS_CRIADOS)
    public void implementacaoEtapa() {
        String textoDigitado = FluxoConsoleAcoes.getTextoFabricaAcao(FluxoConsoleAcoes.FABRICA_GERENTE, FluxoConsoleAcoes.ENTIDADE_ACAO_CLIENTE);
        FluxoConsoleAcoes.sugestoesAutocompletar = FluxoConsoleAcoes.CONSOLE.autocompletProjeto(textoDigitado);
        Assert.assertNotNull("O autocompletar não retornou sugestões", FluxoConsoleAcoes.sugestoesAutocompletar);
        Assert.assertEquals("Texto definido incorreto", textoDigitado, FluxoConsoleAcoes.CONSOLE.getTextoDefinido());
    }
}
