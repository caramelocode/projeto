package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import cucumber.api.java.pt.Entao;
import java.util.Set;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;
import org.junit.Assert;

public class AS_Entao_as_nove_acoes_de_Cliente_sao_sugeridas_como_ItemOpcaoConsole_de_edicao {

    @Entao(EtapasconsoleProjCRCAcoes.ENTAO_AS_NOVE_ACOES_DE_CLIENTE_SAO_SUGERIDAS_COMO_ITEMOPCAOCONSOLE_DE_EDICAO)
    public void implementacaoEtapa() {
        Set<String> esperadas = FluxoConsoleAcoes.getNomesUnicos(FluxoConsoleAcoes.FABRICA_GERENTE, FluxoConsoleAcoes.ACOES_CLIENTE);
        Assert.assertEquals("Quantidade de opções disponíveis incorreta", esperadas.size(), FluxoConsoleAcoes.CONSOLE.getOpcoesDisponiveis().size());
        Assert.assertEquals("As ações sugeridas para edição deveriam ser as nove ações de Cliente",
                esperadas, FluxoConsoleAcoes.getNomesUnicosDasOpcoesDeEdicao());
    }
}
