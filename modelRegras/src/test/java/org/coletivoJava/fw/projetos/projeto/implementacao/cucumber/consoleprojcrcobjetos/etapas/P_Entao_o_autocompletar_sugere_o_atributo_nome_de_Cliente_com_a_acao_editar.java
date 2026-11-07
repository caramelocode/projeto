package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.etapas;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.entidade.FabAcaoCarameloDevComoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetos.EtapasconsoleProjCRCObjetos;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;

public class P_Entao_o_autocompletar_sugere_o_atributo_nome_de_Cliente_com_a_acao_editar {

	@Entao(EtapasconsoleProjCRCObjetos.ENTAO_O_AUTOCOMPLETAR_SUGERE_O_ATRIBUTO_NOME_DE_CLIENTE_COM_A_ACAO_EDITAR)
	public void implementacaoEtapa() {
		String sugestao = FluxoConsoleObjetos.NOME_ENTIDADE_CLIENTE + FabTipoItemProjeto.SEPARADOR_ATRIBUTO + FluxoConsoleObjetos.NOME_ATRIBUTO_NOME;
		Assert.assertTrue("O autocompletar não sugeriu " + sugestao, FluxoConsoleObjetos.sugestoesAutocompletar.contains(sugestao));

		boolean temOpcaoEditar = FluxoConsoleObjetos.CONSOLE.getOpcoesDisponiveis().stream()
				.filter(op -> op.getItemAssociado() instanceof AtributoDeEntidadeSimples)
				.anyMatch(op -> {
					AtributoDeEntidadeSimples atributo = (AtributoDeEntidadeSimples) op.getItemAssociado();
					return FabAcaoCarameloDevComoItemProjeto.ATRIBUTO_ENTIDADE_FRM_EDITAR.equals(op.getFabAcaoAssociada())
							&& FluxoConsoleObjetos.NOME_ATRIBUTO_NOME.equals(atributo.getNomeDeclarado())
							&& atributo.getId() != null
							&& FluxoConsoleObjetos.NOME_ENTIDADE_CLIENTE.equals(atributo.getEntidade().getNomeEntidade());
				});
		Assert.assertTrue("Não há opção de editar o atributo " + sugestao, temOpcaoEditar);
	}
}
