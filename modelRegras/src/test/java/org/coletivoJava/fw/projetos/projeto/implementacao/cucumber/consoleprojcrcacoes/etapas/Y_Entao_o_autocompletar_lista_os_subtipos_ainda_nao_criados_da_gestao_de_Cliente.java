package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;

public class Y_Entao_o_autocompletar_lista_os_subtipos_ainda_nao_criados_da_gestao_de_Cliente {

    @Entao(EtapasconsoleProjCRCAcoes.ENTAO_O_AUTOCOMPLETAR_LISTA_OS_SUBTIPOS_AINDA_NAO_CRIADOS_DA_GESTAO_DE_CLIENTE)
    public void implementacaoEtapa() {
        FluxoConsoleAcoes.verificarSubtiposPendentesDaGestaoCliente(FluxoConsoleAcoes.FABRICA_GERENTE);
    }
}
