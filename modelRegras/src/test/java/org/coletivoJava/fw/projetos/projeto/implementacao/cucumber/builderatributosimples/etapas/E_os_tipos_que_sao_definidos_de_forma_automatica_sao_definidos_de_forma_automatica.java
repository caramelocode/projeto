package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributosimples.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributosimples.EtapasbuilderAtributoSimples;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributosimples.FluxoBuilderAtributoSimples;
import org.junit.Assert;

public class E_os_tipos_que_sao_definidos_de_forma_automatica_sao_definidos_de_forma_automatica {

    @E(EtapasbuilderAtributoSimples.E_OS_TIPOS_QUE_SAO_DEFINIDOS_DE_FORMA_AUTOMATICA_SAO_DEFINIDOS_DE_FORMA_AUTOMATICA)
    public void implementacaoEtapa() {
        // Entidade Cliente recarregada na etapa Entao anterior
        for (String nomeAtributo : FluxoBuilderAtributoSimples.NOMES_ATRIBUTO_POR_TIPO.values()) {
            if (FluxoBuilderAtributoSimples.isTipoDefinidoAutomaticamente(nomeAtributo)) {
                Assert.assertEquals("O tipo do atributo " + nomeAtributo + " deveria ser definido automaticamente pelo nome",
                        FluxoBuilderAtributoSimples.getTipoDefinidoAutomaticamente(nomeAtributo),
                        FluxoBuilderAtributoSimples.getAtributoSalvo(nomeAtributo).getTipo());
            }
        }
    }
}
