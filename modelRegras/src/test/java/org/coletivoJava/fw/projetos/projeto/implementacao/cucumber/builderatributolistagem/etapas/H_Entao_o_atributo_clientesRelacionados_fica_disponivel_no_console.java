package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributolistagem.EtapasbuilderAtributoListagem;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.FluxoBuilderAtributoListagem;

public class H_Entao_o_atributo_clientesRelacionados_fica_disponivel_no_console {

    @Entao(EtapasbuilderAtributoListagem.ENTAO_O_ATRIBUTO_CLIENTESRELACIONADOS_FICA_DISPONIVEL_NO_CONSOLE)
    public void implementacaoEtapa() {
        FluxoBuilderAtributoListagem.verificarDisponivelNoConsole(FluxoBuilderAtributoListagem.NOME_CLIENTES_RELACIONADOS);
    }
}
