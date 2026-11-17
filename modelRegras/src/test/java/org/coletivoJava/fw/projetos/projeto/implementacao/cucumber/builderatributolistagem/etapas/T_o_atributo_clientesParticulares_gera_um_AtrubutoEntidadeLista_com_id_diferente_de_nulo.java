package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributolistagem.EtapasbuilderAtributoListagem;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.FluxoBuilderAtributoListagem;
import org.junit.Assert;

public class T_o_atributo_clientesParticulares_gera_um_AtrubutoEntidadeLista_com_id_diferente_de_nulo {

    @E(EtapasbuilderAtributoListagem.E_O_ATRIBUTO_CLIENTESPARTICULARES_GERA_UM_ATRUBUTOENTIDADELISTA_COM_ID_DIFERENTE_DE_NULO)
    public void implementacaoEtapa() {
        Assert.assertNotNull("Esperado um id no atributo " + FluxoBuilderAtributoListagem.NOME_CLIENTES_PARTICULARES + " persistido no banco",
                FluxoBuilderAtributoListagem.getAtributoListaSalvo(FluxoBuilderAtributoListagem.NOME_CLIENTES_PARTICULARES).getId());
    }
}
