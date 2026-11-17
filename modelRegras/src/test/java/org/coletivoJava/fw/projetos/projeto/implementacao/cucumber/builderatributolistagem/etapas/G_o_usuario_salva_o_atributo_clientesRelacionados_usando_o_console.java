package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributolistagem.EtapasbuilderAtributoListagem;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.FluxoBuilderAtributoListagem;

public class G_o_usuario_salva_o_atributo_clientesRelacionados_usando_o_console {

    @E(EtapasbuilderAtributoListagem.E_O_USUARIO_SALVA_O_ATRIBUTO_CLIENTESRELACIONADOS_USANDO_O_CONSOLE)
    public void implementacaoEtapa() {
        FluxoBuilderAtributoListagem.salvarPeloConsole(FluxoBuilderAtributoListagem.NOME_CLIENTES_RELACIONADOS);
    }
}
