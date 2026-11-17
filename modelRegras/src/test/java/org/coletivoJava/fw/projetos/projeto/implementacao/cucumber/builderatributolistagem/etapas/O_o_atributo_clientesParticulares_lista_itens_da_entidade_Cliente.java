package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributolistagem.EtapasbuilderAtributoListagem;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.FluxoBuilderAtributoListagem;
import org.junit.Assert;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;

public class O_o_atributo_clientesParticulares_lista_itens_da_entidade_Cliente {

    @E(EtapasbuilderAtributoListagem.E_O_ATRIBUTO_CLIENTESPARTICULARES_LISTA_ITENS_DA_ENTIDADE_CLIENTE)
    public void implementacaoEtapa() {
        // Entidade dos itens deduzida pelo nome (clientesParticulares → Cliente)
        ObjetoProjCRC cliente = FluxoBuilderAtributoListagem.CONSOLE.getRepositorio().getEntidadeExistente(FluxoBuilderAtributoListagem.NOME_ENTIDADE_CLIENTE);
        Assert.assertNotNull("O atributo " + FluxoBuilderAtributoListagem.NOME_CLIENTES_PARTICULARES + " deveria vir com a entidade dos itens",
                FluxoBuilderAtributoListagem.atributoAtual.getEntidadeItemLista());
        Assert.assertEquals("Entidade dos itens deduzida incorreta no atributo " + FluxoBuilderAtributoListagem.NOME_CLIENTES_PARTICULARES,
                cliente.getId(), FluxoBuilderAtributoListagem.atributoAtual.getEntidadeItemLista().getId());
    }
}
