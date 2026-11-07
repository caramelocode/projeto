package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;
import org.junit.Assert;

public class G_Quando_o_usuario_digita_FabAcaoGerente_o_CLIENTE_sem_o_tipo_da_acao {

    @Quando(EtapasconsoleProjCRCAcoes.QUANDO_O_USUARIO_DIGITA_FABACAOGERENTE_O_CLIENTE_SEM_O_TIPO_DA_ACAO)
    public void implementacaoEtapa() {
        String textoDigitado = FluxoConsoleAcoes.getTextoFabricaAcao(FluxoConsoleAcoes.FABRICA_GERENTE, FluxoConsoleAcoes.ENTIDADE_ACAO_CLIENTE);
        FluxoConsoleAcoes.sugestoesAutocompletar = FluxoConsoleAcoes.CONSOLE.autocompletProjeto(textoDigitado);
        Assert.assertNotNull("O autocompletar não retornou sugestões", FluxoConsoleAcoes.sugestoesAutocompletar);
        Assert.assertEquals("Texto definido incorreto", textoDigitado, FluxoConsoleAcoes.CONSOLE.getTextoDefinido());
    }
}
