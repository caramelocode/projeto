package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.etapas;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.entidade.FabAcaoCarameloDevComoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeLista;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcatributosespeciais.EtapasconsoleProjCRCAtributosEspeciais;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.FluxoConsoleAtributosEspeciais;
import org.junit.Assert;

public class M_Entao_a_opcao_principal_sugerida_e_criar_o_atributo_clientesRelacionados_do_tipo_lista {

    @Entao(EtapasconsoleProjCRCAtributosEspeciais.ENTAO_A_OPCAO_PRINCIPAL_SUGERIDA_E_CRIAR_O_ATRIBUTO_CLIENTESRELACIONADOS_DO_TIPO_LISTA)
    public void implementacaoEtapa() {
        AtributoEntidadeLista atributo = FluxoConsoleAtributosEspeciais.getAtributoDaOpcaoPrincipalDeCriacao(FluxoConsoleAtributosEspeciais.NOME_ATRIBUTO_CLIENTES_RELACIONADOS, AtributoEntidadeLista.class,
                FabAcaoCarameloDevComoItemProjeto.ATRIBUTO_ENTIDADE_CTR_SALVAR_NOVO_TP_LISTA);
        Assert.assertEquals("Tipo do atributo lista incorreto", FabTipoItemProjeto.TIPO_NOVO_ATRIBUTO_LISTA, atributo.getTipo());
    }
}
