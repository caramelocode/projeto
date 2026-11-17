package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoentidade.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeEntidade;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributoentidade.EtapasbuilderAtributoEntidade;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoentidade.FluxoBuilderAtributoEntidade;
import org.junit.Assert;

public class K_a_visibilidade_das_propriedades_destes_atributos_fica_de_acordo_com_o_esperado {

    @E(EtapasbuilderAtributoEntidade.E_A_VISIBILIDADE_DAS_PROPRIEDADES_DESTES_ATRIBUTOS_FICA_DE_ACORDO_COM_O_ESPERADO)
    public void implementacaoEtapa() {
        // Os tipos foram definidos em memória (sem salvar): os atributos não são recarregados do banco
        Assert.assertFalse("Nenhum atributo com tipo definido pelo usuário", FluxoBuilderAtributoEntidade.ATRIBUTO_TIPO_MANUAL.isEmpty());
        for (AtributoEntidadeEntidade atributo : FluxoBuilderAtributoEntidade.ATRIBUTO_TIPO_MANUAL) {
            Assert.assertEquals("Tipo do atributo " + atributo.getNomeDeclarado() + " diferente do definido pelo usuário",
                    FluxoBuilderAtributoEntidade.getTipoEsperado(atributo.getNomeDeclarado()), atributo.getTipo());
            FluxoBuilderAtributoEntidade.verificarVisibilidadeCampos(atributo);
        }
    }
}
