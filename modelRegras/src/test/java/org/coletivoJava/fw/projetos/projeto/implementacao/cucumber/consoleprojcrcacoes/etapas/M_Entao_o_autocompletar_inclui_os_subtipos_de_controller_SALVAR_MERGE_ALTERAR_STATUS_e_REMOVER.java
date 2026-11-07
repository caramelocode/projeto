package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;
import org.junit.Assert;

public class M_Entao_o_autocompletar_inclui_os_subtipos_de_controller_SALVAR_MERGE_ALTERAR_STATUS_e_REMOVER {

    @Entao(EtapasconsoleProjCRCAcoes.ENTAO_O_AUTOCOMPLETAR_INCLUI_OS_SUBTIPOS_DE_CONTROLLER_SALVAR_MERGE_ALTERAR_STATUS_E_REMOVER)
    public void implementacaoEtapa() {
        String textoDigitado = FluxoConsoleAcoes.getTextoFabricaAcao(FluxoConsoleAcoes.FABRICA_GERENTE, FluxoConsoleAcoes.ENTIDADE_ACAO_CLIENTE)
                + FluxoConsoleAcoes.TIPO_ACAO_CONTROLLER;
        for (String subtipo : FluxoConsoleAcoes.SUBTIPOS_CONTROLLER) {
            String sugestao = textoDigitado + subtipo;
            Assert.assertTrue("O autocompletar não sugeriu " + sugestao + ": " + FluxoConsoleAcoes.sugestoesAutocompletar,
                    FluxoConsoleAcoes.sugestoesAutocompletar.contains(sugestao));
        }
    }
}
