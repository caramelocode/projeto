package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeEntidade;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcatributosespeciais.EtapasconsoleProjCRCAtributosEspeciais;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.FluxoConsoleAtributosEspeciais;
import org.junit.Assert;

public class G_Entao_o_atributo_clienteIndicou_fica_salvo_em_Cliente_como_AtributoEntidadeEntidade {

    @Entao(EtapasconsoleProjCRCAtributosEspeciais.ENTAO_O_ATRIBUTO_CLIENTEINDICOU_FICA_SALVO_EM_CLIENTE_COMO_ATRIBUTOENTIDADEENTIDADE)
    public void implementacaoEtapa() {
        AtributoEntidadeEntidade atributo = FluxoConsoleAtributosEspeciais.verificarAtributoSalvoEmCliente(
                FluxoConsoleAtributosEspeciais.NOME_ATRIBUTO_CLIENTE_INDICOU, AtributoEntidadeEntidade.class);
        Assert.assertEquals("Tipo salvo do atributo objeto incorreto", FabTipoItemProjeto.TIPO_NOVO_ATRIBUTO_OBJETO, atributo.getTipo());
    }
}
