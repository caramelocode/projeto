package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributolistagem.EtapasbuilderAtributoListagem;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.FluxoBuilderAtributoListagem;

public class R_o_usuario_salva_o_atributo_clientesParticulares_com_o_console {

    @E(EtapasbuilderAtributoListagem.E_O_USUARIO_SALVA_O_ATRIBUTO_CLIENTESPARTICULARES_COM_O_CONSOLE)
    public void implementacaoEtapa() {
        FluxoBuilderAtributoListagem.salvarPeloConsole(FluxoBuilderAtributoListagem.NOME_CLIENTES_PARTICULARES);
    }
}
