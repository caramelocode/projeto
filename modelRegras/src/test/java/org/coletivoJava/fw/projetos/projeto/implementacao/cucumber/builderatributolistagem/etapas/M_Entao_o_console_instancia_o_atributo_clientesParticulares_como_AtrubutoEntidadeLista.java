package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributolistagem.EtapasbuilderAtributoListagem;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.FluxoBuilderAtributoListagem;

public class M_Entao_o_console_instancia_o_atributo_clientesParticulares_como_AtrubutoEntidadeLista {

    @Entao(EtapasbuilderAtributoListagem.ENTAO_O_CONSOLE_INSTANCIA_O_ATRIBUTO_CLIENTESPARTICULARES_COMO_ATRUBUTOENTIDADELISTA)
    public void implementacaoEtapa() {
        FluxoBuilderAtributoListagem.verificarOpcaoCriarAtributoLista(FluxoBuilderAtributoListagem.NOME_CLIENTES_PARTICULARES);
    }
}
