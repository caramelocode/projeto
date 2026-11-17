package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributolistagem.EtapasbuilderAtributoListagem;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.FluxoBuilderAtributoListagem;

public class L_Quando_o_usuario_digita_Cliente_seguido_de_ponto_e_clientesParticulares_terminado_em_colchetes_no_console {

    @Quando(EtapasbuilderAtributoListagem.QUANDO_O_USUARIO_DIGITA_CLIENTE_SEGUIDO_DE_PONTO_E_CLIENTESPARTICULARES_TERMINADO_EM_COLCHETES_NO_CONSOLE)
    public void implementacaoEtapa() {
        FluxoBuilderAtributoListagem.digitarAtributo(FluxoBuilderAtributoListagem.NOME_CLIENTES_PARTICULARES);
    }
}
