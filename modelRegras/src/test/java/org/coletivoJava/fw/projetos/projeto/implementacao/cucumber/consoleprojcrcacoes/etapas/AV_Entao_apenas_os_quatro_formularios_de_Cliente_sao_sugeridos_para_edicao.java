package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import cucumber.api.java.pt.Entao;
import java.util.Set;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;
import org.junit.Assert;

public class AV_Entao_apenas_os_quatro_formularios_de_Cliente_sao_sugeridos_para_edicao {

    @Entao(EtapasconsoleProjCRCAcoes.ENTAO_APENAS_OS_QUATRO_FORMULARIOS_DE_CLIENTE_SAO_SUGERIDOS_PARA_EDICAO)
    public void implementacaoEtapa() {
        Set<String> esperadas = FluxoConsoleAcoes.getNomesUnicos(FluxoConsoleAcoes.FABRICA_GERENTE, FluxoConsoleAcoes.FORMULARIOS_CLIENTE);
        Assert.assertEquals("Deveria haver apenas as opções de editar os formulários de Cliente",
                esperadas.size(), FluxoConsoleAcoes.CONSOLE.getOpcoesDisponiveis().size());
        Assert.assertEquals("Os formulários sugeridos para edição estão incorretos",
                esperadas, FluxoConsoleAcoes.getNomesUnicosDasOpcoesDeEdicao());
    }
}
