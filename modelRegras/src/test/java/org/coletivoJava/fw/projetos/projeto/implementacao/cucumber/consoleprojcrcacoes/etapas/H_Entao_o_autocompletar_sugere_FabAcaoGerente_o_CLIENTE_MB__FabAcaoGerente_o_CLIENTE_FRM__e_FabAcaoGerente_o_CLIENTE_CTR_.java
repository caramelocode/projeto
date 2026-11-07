package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;
import org.junit.Assert;

public class H_Entao_o_autocompletar_sugere_FabAcaoGerente_o_CLIENTE_MB__FabAcaoGerente_o_CLIENTE_FRM__e_FabAcaoGerente_o_CLIENTE_CTR_ {

    @Entao(EtapasconsoleProjCRCAcoes.ENTAO_O_AUTOCOMPLETAR_SUGERE_FABACAOGERENTE_O_CLIENTE_MB_FABACAOGERENTE_O_CLIENTE_FRM_E_FABACAOGERENTE_O_CLIENTE_CTR_)
    public void implementacaoEtapa() {
        String textoDigitado = FluxoConsoleAcoes.getTextoFabricaAcao(FluxoConsoleAcoes.FABRICA_GERENTE, FluxoConsoleAcoes.ENTIDADE_ACAO_CLIENTE);
        for (String tipo : FluxoConsoleAcoes.TIPOS_ACAO) {
            String sugestao = textoDigitado + tipo;
            Assert.assertTrue("O autocompletar não sugeriu " + sugestao + ": " + FluxoConsoleAcoes.sugestoesAutocompletar,
                    FluxoConsoleAcoes.sugestoesAutocompletar.contains(sugestao));
        }
    }
}
