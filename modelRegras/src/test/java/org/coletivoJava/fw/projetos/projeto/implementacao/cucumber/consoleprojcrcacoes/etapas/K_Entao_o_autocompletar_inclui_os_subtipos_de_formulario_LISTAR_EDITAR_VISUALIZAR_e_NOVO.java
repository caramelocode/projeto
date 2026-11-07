package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;
import org.junit.Assert;

public class K_Entao_o_autocompletar_inclui_os_subtipos_de_formulario_LISTAR_EDITAR_VISUALIZAR_e_NOVO {

    @Entao(EtapasconsoleProjCRCAcoes.ENTAO_O_AUTOCOMPLETAR_INCLUI_OS_SUBTIPOS_DE_FORMULARIO_LISTAR_EDITAR_VISUALIZAR_E_NOVO)
    public void implementacaoEtapa() {
        String textoDigitado = FluxoConsoleAcoes.getTextoFabricaAcao(FluxoConsoleAcoes.FABRICA_GERENTE, FluxoConsoleAcoes.ENTIDADE_ACAO_CLIENTE)
                + FluxoConsoleAcoes.TIPO_ACAO_FORMULARIO;
        for (String subtipo : FluxoConsoleAcoes.SUBTIPOS_FORMULARIO) {
            String sugestao = textoDigitado + subtipo;
            Assert.assertTrue("O autocompletar não sugeriu " + sugestao + ": " + FluxoConsoleAcoes.sugestoesAutocompletar,
                    FluxoConsoleAcoes.sugestoesAutocompletar.contains(sugestao));
        }
    }
}
