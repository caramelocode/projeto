package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoentidade.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoInstanciaAtributoProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeEntidade;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributoentidade.EtapasbuilderAtributoEntidade;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoentidade.FluxoBuilderAtributoEntidade;
import org.junit.Assert;

public class J_Entao_o_campo_tipo_exibe_apenas_os_tipos_compativeis_com_AtributoEntidadeEntidade {

    @Entao(EtapasbuilderAtributoEntidade.ENTAO_O_CAMPO_TIPO_EXIBE_APENAS_OS_TIPOS_COMPATIVEIS_COM_ATRIBUTOENTIDADEENTIDADE)
    public void implementacaoEtapa() {
        // Cliente recarregado na etapa Quando anterior; os atributos de ATRIBUTO_TIPO_MANUAL são as mesmas instâncias,
        // com o tipo definido em memória pelo usuário
        for (String nomeAtributo : FluxoBuilderAtributoEntidade.getNomesAtributos()) {
            AtributoEntidadeEntidade atributo = FluxoBuilderAtributoEntidade.getAtributoEntidadeSalvo(nomeAtributo);
            Assert.assertTrue("O tipo " + atributo.getTipo() + " do atributo " + nomeAtributo
                    + " não é compatível com AtributoEntidadeEntidade (FabTipoInstanciaAtributoProjeto.ATRIBUTO_ENTIDADE)",
                    FluxoBuilderAtributoEntidade.getTiposCompativeis().contains(atributo.getTipo()));
            Assert.assertEquals("Tipo de instância incorreto para o tipo do atributo " + nomeAtributo,
                    FabTipoInstanciaAtributoProjeto.ATRIBUTO_ENTIDADE, FabTipoInstanciaAtributoProjeto.getTipoAtributo(atributo.getTipo()));
            Assert.assertEquals("Tipo incorreto no atributo " + nomeAtributo,
                    FluxoBuilderAtributoEntidade.getTipoEsperado(nomeAtributo), atributo.getTipo());
        }
    }
}
