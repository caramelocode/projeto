package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;

public class AA_Entao_o_autocompletar_no_outro_formato_de_fabrica_tambem_lista_os_subtipos_ainda_nao_criados {

    @Entao(EtapasconsoleProjCRCAcoes.ENTAO_O_AUTOCOMPLETAR_NO_OUTRO_FORMATO_DE_FABRICA_TAMBEM_LISTA_OS_SUBTIPOS_AINDA_NAO_CRIADOS)
    public void implementacaoEtapa() {
        FluxoConsoleAcoes.verificarSubtiposPendentesDaGestaoCliente(FluxoConsoleAcoes.FABRICA_GERENTE_CLIENTE);
    }
}
