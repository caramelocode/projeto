package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;

public class AF_Quando_o_usuario_cria_FabAcaoGerente_o_CLIENTE_FRM_VISUALIZAR {

    @Quando(EtapasconsoleProjCRCAcoes.QUANDO_O_USUARIO_CRIA_FABACAOGERENTE_O_CLIENTE_FRM_VISUALIZAR)
    public void implementacaoEtapa() {
        FluxoConsoleAcoes.criarAcaoPeloConsole(FluxoConsoleAcoes.FABRICA_GERENTE, FluxoConsoleAcoes.ACAO_CLIENTE_FRM_VISUALIZAR);
    }
}
