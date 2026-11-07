package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;
import org.junit.Assert;

public class D_Entao_o_console_nao_sugere_nenhum_ItemOpcaoConsole {

    @Entao(EtapasconsoleProjCRCAcoes.ENTAO_O_CONSOLE_NAO_SUGERE_NENHUM_ITEMOPCAOCONSOLE)
    public void implementacaoEtapa() {
        Assert.assertTrue("O console não deveria sugerir nenhuma opção, sugeriu " + FluxoConsoleAcoes.CONSOLE.getOpcoesDisponiveis().size(),
                FluxoConsoleAcoes.CONSOLE.getOpcoesDisponiveis().isEmpty());
        Assert.assertNull("Não deveria haver opção principal sugerida", FluxoConsoleAcoes.CONSOLE.getOpcaoPrincipalSugerida());
    }
}
