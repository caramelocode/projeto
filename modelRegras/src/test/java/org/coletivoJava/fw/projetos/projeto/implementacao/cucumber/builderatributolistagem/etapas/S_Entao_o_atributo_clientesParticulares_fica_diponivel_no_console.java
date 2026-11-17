package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributolistagem.EtapasbuilderAtributoListagem;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.FluxoBuilderAtributoListagem;

public class S_Entao_o_atributo_clientesParticulares_fica_diponivel_no_console {

    @Entao(EtapasbuilderAtributoListagem.ENTAO_O_ATRIBUTO_CLIENTESPARTICULARES_FICA_DIPONIVEL_NO_CONSOLE)
    public void implementacaoEtapa() {
        FluxoBuilderAtributoListagem.verificarDisponivelNoConsole(FluxoBuilderAtributoListagem.NOME_CLIENTES_PARTICULARES);
    }
}
