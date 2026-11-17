package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoentidade.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeEntidade;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributoentidade.EtapasbuilderAtributoEntidade;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoentidade.FluxoBuilderAtributoEntidade;
import org.junit.Assert;

public class F_o_atributo_clienteIndicou_referencia_a_entidade_Cliente {

    @E(EtapasbuilderAtributoEntidade.E_O_ATRIBUTO_CLIENTEINDICOU_REFERENCIA_A_ENTIDADE_CLIENTE)
    public void implementacaoEtapa() {
        // Entidade Cliente recarregada na etapa Entao anterior
        AtributoEntidadeEntidade clienteIndicou = FluxoBuilderAtributoEntidade
                .getAtributoEntidadeSalvo(FluxoBuilderAtributoEntidade.NOME_ATRIBUTO_CLIENTE_INDICOU);
        Assert.assertNotNull("O atributo " + FluxoBuilderAtributoEntidade.NOME_ATRIBUTO_CLIENTE_INDICOU
                + " foi salvo sem entidade referenciada", clienteIndicou.getEntidadeReferenciada());
        Assert.assertEquals("Entidade referenciada incorreta no atributo " + FluxoBuilderAtributoEntidade.NOME_ATRIBUTO_CLIENTE_INDICOU,
                FluxoBuilderAtributoEntidade.ENTIDADE_PROJ_CLIENTE.getId(), clienteIndicou.getEntidadeReferenciada().getId());
    }
}
