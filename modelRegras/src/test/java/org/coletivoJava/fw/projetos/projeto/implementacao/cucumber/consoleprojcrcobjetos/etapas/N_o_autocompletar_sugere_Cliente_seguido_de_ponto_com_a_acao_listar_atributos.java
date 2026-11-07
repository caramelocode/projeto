package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.etapas;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.entidade.FabAcaoCarameloDevComoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.console.ItemOpcaoConsole;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetos.EtapasconsoleProjCRCObjetos;
import cucumber.api.java.pt.E;
import java.util.List;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;

public class N_o_autocompletar_sugere_Cliente_seguido_de_ponto_com_a_acao_listar_atributos {

	@E(EtapasconsoleProjCRCObjetos.E_O_AUTOCOMPLETAR_SUGERE_CLIENTE_SEGUIDO_DE_PONTO_COM_A_ACAO_LISTAR_ATRIBUTOS)
	public void implementacaoEtapa() {
		String sugestaoAtributos = FluxoConsoleObjetos.NOME_ENTIDADE_CLIENTE + FabTipoItemProjeto.SEPARADOR_ATRIBUTO;
		Assert.assertTrue("O autocompletar não sugeriu " + sugestaoAtributos,
				FluxoConsoleObjetos.sugestoesAutocompletar.contains(sugestaoAtributos));

		List<ItemOpcaoConsole> opcoes = FluxoConsoleObjetos.CONSOLE.getOpcoesDisponiveis();
		Assert.assertEquals("Quantidade de opções disponíveis incorreta", 3, opcoes.size());
		ItemOpcaoConsole opcaoListar = opcoes.get(2);
		Assert.assertEquals("A terceira opção deveria ser listar atributos", FabAcaoCarameloDevComoItemProjeto.ATRIBUTO_ENTIDADE_FRM_LISTAR, opcaoListar.getFabAcaoAssociada());
		Assert.assertTrue("A opção de listar atributos deveria estar associada a uma entidade", opcaoListar.getItemAssociado() instanceof ObjetoProjCRC);
		Assert.assertEquals("Entidade da opção de listar atributos incorreta", FluxoConsoleObjetos.NOME_ENTIDADE_CLIENTE,
				((ObjetoProjCRC) opcaoListar.getItemAssociado()).getNomeEntidade());
	}
}
