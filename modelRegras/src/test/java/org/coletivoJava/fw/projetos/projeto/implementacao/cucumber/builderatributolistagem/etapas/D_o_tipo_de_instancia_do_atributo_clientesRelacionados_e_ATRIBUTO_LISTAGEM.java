package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributolistagem.EtapasbuilderAtributoListagem;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.FluxoBuilderAtributoListagem;
import org.junit.Assert;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoInstanciaAtributoProjeto;

public class D_o_tipo_de_instancia_do_atributo_clientesRelacionados_e_ATRIBUTO_LISTAGEM {

    @E(EtapasbuilderAtributoListagem.E_O_TIPO_DE_INSTANCIA_DO_ATRIBUTO_CLIENTESRELACIONADOS_E_ATRIBUTO_LISTAGEM)
    public void implementacaoEtapa() {
        Assert.assertEquals("Tipo de instância incorreto para o tipo " + FluxoBuilderAtributoListagem.atributoAtual.getTipo() + " do atributo " + FluxoBuilderAtributoListagem.atributoAtual.getNomeDeclarado(),
                FluxoBuilderAtributoListagem.TIPO_INSTANCIA, FabTipoInstanciaAtributoProjeto.getTipoAtributo(FluxoBuilderAtributoListagem.atributoAtual.getTipo()));
    }
}
