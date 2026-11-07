package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;

public class AP_Quando_o_usuario_cria_FabAcaoGerente_o_CLIENTE_CTR_ACAO_TESTE_PERSONALIZADA {

    @Quando(EtapasconsoleProjCRCAcoes.QUANDO_O_USUARIO_CRIA_FABACAOGERENTE_O_CLIENTE_CTR_ACAO_TESTE_PERSONALIZADA)
    public void implementacaoEtapa() {
        FluxoConsoleAcoes.criarAcaoPeloConsole(FluxoConsoleAcoes.FABRICA_GERENTE, FluxoConsoleAcoes.ACAO_CLIENTE_CTR_ACAO_TESTE_PERSONALIZADA);
    }
}
