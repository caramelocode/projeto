package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;
import org.junit.Assert;

public class AX_Entao_o_autocompletar_nao_lista_subtipos_pendentes_da_gestao_de_Cliente {

    @Entao(EtapasconsoleProjCRCAcoes.ENTAO_O_AUTOCOMPLETAR_NAO_LISTA_SUBTIPOS_PENDENTES_DA_GESTAO_DE_CLIENTE)
    public void implementacaoEtapa() {
        for (String acaoCliente : FluxoConsoleAcoes.ACOES_CLIENTE) {
            String sugestao = FluxoConsoleAcoes.getTextoFabricaAcao(FluxoConsoleAcoes.FABRICA_GERENTE, acaoCliente);
            Assert.assertFalse("A ação " + sugestao + " já foi criada e não deveria ser sugerida como pendente: " + FluxoConsoleAcoes.sugestoesAutocompletar,
                    FluxoConsoleAcoes.sugestoesAutocompletar.contains(sugestao));
        }
    }
}
