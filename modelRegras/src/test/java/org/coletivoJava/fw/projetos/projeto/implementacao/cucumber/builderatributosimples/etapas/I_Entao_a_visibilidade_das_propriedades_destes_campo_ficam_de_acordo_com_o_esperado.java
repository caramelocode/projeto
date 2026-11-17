package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributosimples.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributosimples.EtapasbuilderAtributoSimples;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributosimples.FluxoBuilderAtributoSimples;
import org.junit.Assert;

public class I_Entao_a_visibilidade_das_propriedades_destes_campo_ficam_de_acordo_com_o_esperado {

    @Entao(EtapasbuilderAtributoSimples.ENTAO_A_VISIBILIDADE_DAS_PROPRIEDADES_DESTES_CAMPO_FICAM_DE_ACORDO_COM_O_ESPERADO)
    public void implementacaoEtapa() {
        // Os tipos foram definidos em memória (sem salvar): os atributos não são recarregados do banco
        Assert.assertFalse("Nenhum atributo com tipo definido pelo usuário", FluxoBuilderAtributoSimples.ATRIBUTO_TIPO_MANUAL.isEmpty());
        for (AtributoDeEntidadeSimples atributo : FluxoBuilderAtributoSimples.ATRIBUTO_TIPO_MANUAL) {
            Assert.assertEquals("Tipo do atributo " + atributo.getNomeDeclarado() + " diferente do definido pelo usuário",
                    FluxoBuilderAtributoSimples.getTipoEsperado(atributo.getNomeDeclarado()), atributo.getTipo());
            FluxoBuilderAtributoSimples.verificarVisibilidadeCampos(atributo);
        }
    }
}
