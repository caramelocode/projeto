package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeLista;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcatributosespeciais.EtapasconsoleProjCRCAtributosEspeciais;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.FluxoConsoleAtributosEspeciais;
import org.junit.Assert;

public class Q_a_entidade_dos_itens_da_lista_clientesRelacionados_e_Cliente {

    @E(EtapasconsoleProjCRCAtributosEspeciais.E_A_ENTIDADE_DOS_ITENS_DA_LISTA_CLIENTESRELACIONADOS_E_CLIENTE)
    public void implementacaoEtapa() {
        AtributoEntidadeLista atributo = FluxoConsoleAtributosEspeciais.verificarAtributoSalvoEmCliente(FluxoConsoleAtributosEspeciais.NOME_ATRIBUTO_CLIENTES_RELACIONADOS, AtributoEntidadeLista.class);
        Assert.assertNotNull("Entidade dos itens da lista não salva", atributo.getEntidadeItemLista());
        Assert.assertEquals("Entidade dos itens da lista " + FluxoConsoleAtributosEspeciais.NOME_ATRIBUTO_CLIENTES_RELACIONADOS + " incorreta",
                FluxoConsoleAtributosEspeciais.NOME_ENTIDADE_CLIENTE, atributo.getEntidadeItemLista().getNomeEntidade());
    }
}
