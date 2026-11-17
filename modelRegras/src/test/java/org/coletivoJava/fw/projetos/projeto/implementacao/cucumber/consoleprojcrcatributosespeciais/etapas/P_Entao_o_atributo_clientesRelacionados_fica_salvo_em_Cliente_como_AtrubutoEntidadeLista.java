package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeLista;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcatributosespeciais.EtapasconsoleProjCRCAtributosEspeciais;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.FluxoConsoleAtributosEspeciais;
import org.junit.Assert;

public class P_Entao_o_atributo_clientesRelacionados_fica_salvo_em_Cliente_como_AtrubutoEntidadeLista {

    @Entao(EtapasconsoleProjCRCAtributosEspeciais.ENTAO_O_ATRIBUTO_CLIENTESRELACIONADOS_FICA_SALVO_EM_CLIENTE_COMO_ATRUBUTOENTIDADELISTA)
    public void implementacaoEtapa() {
        AtributoEntidadeLista atributo = FluxoConsoleAtributosEspeciais.verificarAtributoSalvoEmCliente(FluxoConsoleAtributosEspeciais.NOME_ATRIBUTO_CLIENTES_RELACIONADOS, AtributoEntidadeLista.class);
        Assert.assertEquals("Tipo salvo do atributo lista incorreto", FabTipoItemProjeto.TIPO_NOVO_ATRIBUTO_LISTA, atributo.getTipo());
    }
}
