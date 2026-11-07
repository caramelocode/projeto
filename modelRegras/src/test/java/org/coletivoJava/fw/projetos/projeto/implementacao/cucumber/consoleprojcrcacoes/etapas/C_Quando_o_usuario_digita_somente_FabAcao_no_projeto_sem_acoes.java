package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;
import org.junit.Assert;

public class C_Quando_o_usuario_digita_somente_FabAcao_no_projeto_sem_acoes {

    @Quando(EtapasconsoleProjCRCAcoes.QUANDO_O_USUARIO_DIGITA_SOMENTE_FABACAO_NO_PROJETO_SEM_ACOES)
    public void implementacaoEtapa() {
        FluxoConsoleAcoes.sugestoesAutocompletar = FluxoConsoleAcoes.CONSOLE.autocompletProjeto(FluxoConsoleAcoes.PREFIXO_FABRICA);
        Assert.assertNotNull("O autocompletar não retornou sugestões", FluxoConsoleAcoes.sugestoesAutocompletar);
        Assert.assertEquals("Texto definido incorreto", FluxoConsoleAcoes.PREFIXO_FABRICA, FluxoConsoleAcoes.CONSOLE.getTextoDefinido());
    }
}
