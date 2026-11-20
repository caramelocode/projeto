package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.etapas;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.objeto.FabAcaoCarameloDevEdicaoItemProj;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetos.EtapasconsoleProjCRCObjetos;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;

public class Q_o_autocompletar_sugere_o_atributo_n_de_Cliente_com_a_acao_criar_atributo_n {

	@E(EtapasconsoleProjCRCObjetos.E_O_AUTOCOMPLETAR_SUGERE_O_ATRIBUTO_N_DE_CLIENTE_COM_A_ACAO_CRIAR_ATRIBUTO_N)
	public void implementacaoEtapa() {
		String sugestao = FluxoConsoleObjetos.NOME_ENTIDADE_CLIENTE + FabTipoItemProjeto.SEPARADOR_ATRIBUTO + FluxoConsoleObjetos.TEXTO_PARCIAL_ATRIBUTO_N;
		Assert.assertTrue("O autocompletar não sugeriu " + sugestao, FluxoConsoleObjetos.sugestoesAutocompletar.contains(sugestao));

		boolean temOpcaoCriar = FluxoConsoleObjetos.CONSOLE.getOpcoesDisponiveis().stream()
				.filter(op -> op.getItemAssociado() instanceof AtributoDeEntidadeSimples)
				.anyMatch(op -> {
					AtributoDeEntidadeSimples atributo = (AtributoDeEntidadeSimples) op.getItemAssociado();
					return FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_SALVAR_NOVO.equals(op.getFabAcaoCriarItem())
							&& FluxoConsoleObjetos.TEXTO_PARCIAL_ATRIBUTO_N.equals(atributo.getNomeDeclarado())
							&& atributo.getId() == null
							&& FluxoConsoleObjetos.NOME_ENTIDADE_CLIENTE.equals(atributo.getEntidade().getNomeEntidade());
				});
		Assert.assertTrue("Não há opção de criar o atributo " + sugestao, temOpcaoCriar);
	}
}
