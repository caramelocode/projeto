package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.etapas;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.objeto.FabAcaoCarameloDevEdicaoItemProj;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeEntidade;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcatributosespeciais.EtapasconsoleProjCRCAtributosEspeciais;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.FluxoConsoleAtributosEspeciais;
import org.junit.Assert;

public class D_Entao_a_opcao_principal_sugerida_e_criar_o_atributo_clienteIndicou_do_tipo_objeto {

    @Entao(EtapasconsoleProjCRCAtributosEspeciais.ENTAO_A_OPCAO_PRINCIPAL_SUGERIDA_E_CRIAR_O_ATRIBUTO_CLIENTEINDICOU_DO_TIPO_OBJETO)
    public void implementacaoEtapa() {
        AtributoEntidadeEntidade atributo = FluxoConsoleAtributosEspeciais.getAtributoDaOpcaoPrincipalDeCriacao(FluxoConsoleAtributosEspeciais.NOME_ATRIBUTO_CLIENTE_INDICOU, AtributoEntidadeEntidade.class,
                FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_SALVAR_NOVO_TP_ENTIDADE);
        Assert.assertEquals("Tipo do atributo objeto incorreto", FabTipoItemProjeto.TIPO_NOVO_ATRIBUTO_OBJETO, atributo.getTipo());
    }
}
