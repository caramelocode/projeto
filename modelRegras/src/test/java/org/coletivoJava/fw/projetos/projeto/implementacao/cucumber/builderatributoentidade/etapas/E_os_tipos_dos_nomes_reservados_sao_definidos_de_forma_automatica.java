package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoentidade.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributoentidade.EtapasbuilderAtributoEntidade;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoentidade.FluxoBuilderAtributoEntidade;
import org.junit.Assert;

public class E_os_tipos_dos_nomes_reservados_sao_definidos_de_forma_automatica {

    @E(EtapasbuilderAtributoEntidade.E_OS_TIPOS_DOS_NOMES_RESERVADOS_SAO_DEFINIDOS_DE_FORMA_AUTOMATICA)
    public void implementacaoEtapa() {
        // Entidade Cliente recarregada na etapa Entao anterior
        for (String nomeAtributo : FluxoBuilderAtributoEntidade.ATRIBUTOS_DETECTADOS_PELO_NOME.keySet()) {
            Assert.assertEquals("O tipo do atributo " + nomeAtributo + " deveria ser definido automaticamente pelo nome",
                    FluxoBuilderAtributoEntidade.ATRIBUTOS_DETECTADOS_PELO_NOME.get(nomeAtributo),
                    FluxoBuilderAtributoEntidade.getAtributoEntidadeSalvo(nomeAtributo).getTipo());
        }
    }
}
