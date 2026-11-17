package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributolistagem.EtapasbuilderAtributoListagem;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.FluxoBuilderAtributoListagem;
import org.junit.Assert;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;

public class F_define_a_entidadeItemLista_como_Cliente {

    @E(EtapasbuilderAtributoListagem.E_DEFINE_A_ENTIDADEITEMLISTA_COMO_CLIENTE)
    public void implementacaoEtapa() {
        // Entidade do repositório do console: o atributo novo será salvo por ele
        ObjetoProjCRC cliente = FluxoBuilderAtributoListagem.CONSOLE.getRepositorio().getEntidadeExistente(FluxoBuilderAtributoListagem.NOME_ENTIDADE_CLIENTE);
        Assert.assertNotNull("A entidade " + FluxoBuilderAtributoListagem.NOME_ENTIDADE_CLIENTE + " não está no repositório do console", cliente);
        FluxoBuilderAtributoListagem.atributoAtual.setEntidadeItemLista(cliente);
        Assert.assertEquals("Entidade dos itens não definida no atributo " + FluxoBuilderAtributoListagem.atributoAtual.getNomeDeclarado(),
                cliente.getId(), FluxoBuilderAtributoListagem.atributoAtual.getEntidadeItemLista().getId());
    }
}
