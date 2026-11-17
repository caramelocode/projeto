package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.etapas;

import cucumber.api.java.pt.E;
import java.util.List;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetostatus.EtapasconsoleProjCRCObjetoStatus;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.FluxoConsoleObjetoStatus;
import org.junit.Assert;

public class Q_o_autocompletar_nao_sugere_o_texto_FabStatusPedido {

    @E(EtapasconsoleProjCRCObjetoStatus.E_O_AUTOCOMPLETAR_NAO_SUGERE_O_TEXTO_FABSTATUSPEDIDO)
    public void implementacaoEtapa() {
        List<String> sugestoes = FluxoConsoleObjetoStatus.sugestoesAutocompletar;
        String textoInexistente = FluxoConsoleObjetoStatus.TEXTO_FABRICA_STATUS_INEXISTENTE;
        Assert.assertFalse("O autocompletar não deveria sugerir " + textoInexistente + ", sugeriu " + sugestoes,
                sugestoes.contains(textoInexistente));
    }
}
