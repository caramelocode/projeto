package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoentidade.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeEntidade;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributoentidade.EtapasbuilderAtributoEntidade;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoentidade.FluxoBuilderAtributoEntidade;
import org.junit.Assert;

public class D_Entao_os_atributos_sao_persistidos_como_AtributoEntidadeEntidade {

    @Entao(EtapasbuilderAtributoEntidade.ENTAO_OS_ATRIBUTOS_SAO_PERSISTIDOS_COMO_ATRIBUTOENTIDADEENTIDADE)
    public void implementacaoEtapa() {
        FluxoBuilderAtributoEntidade.recarregarEntidadeCliente();
        for (String nomeAtributo : FluxoBuilderAtributoEntidade.getNomesAtributos()) {
            // getAtributoEntidadeSalvo confere a classe exata (AtributoEntidadeEntidade)
            AtributoEntidadeEntidade atributo = FluxoBuilderAtributoEntidade.getAtributoEntidadeSalvo(nomeAtributo);
            Assert.assertNotNull("Esperado um id no atributo " + nomeAtributo + " persistido no banco", atributo.getId());
            Assert.assertNotNull("O atributo " + nomeAtributo + " foi salvo sem tipo", atributo.getTipo());
        }
    }
}
