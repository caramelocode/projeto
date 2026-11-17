package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeEntidade;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcatributosespeciais.EtapasconsoleProjCRCAtributosEspeciais;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.FluxoConsoleAtributosEspeciais;
import org.junit.Assert;

public class H_a_entidade_referenciada_por_clienteIndicou_e_Cliente {

    @E(EtapasconsoleProjCRCAtributosEspeciais.E_A_ENTIDADE_REFERENCIADA_POR_CLIENTEINDICOU_E_CLIENTE)
    public void implementacaoEtapa() {
        AtributoEntidadeEntidade atributo = FluxoConsoleAtributosEspeciais.verificarAtributoSalvoEmCliente(
                FluxoConsoleAtributosEspeciais.NOME_ATRIBUTO_CLIENTE_INDICOU, AtributoEntidadeEntidade.class);
        Assert.assertNotNull("Entidade referenciada não salva", atributo.getEntidadeReferenciada());
        Assert.assertEquals("Entidade referenciada por " + FluxoConsoleAtributosEspeciais.NOME_ATRIBUTO_CLIENTE_INDICOU + " incorreta",
                FluxoConsoleAtributosEspeciais.NOME_ENTIDADE_CLIENTE, atributo.getEntidadeReferenciada().getNomeEntidade());
    }
}
