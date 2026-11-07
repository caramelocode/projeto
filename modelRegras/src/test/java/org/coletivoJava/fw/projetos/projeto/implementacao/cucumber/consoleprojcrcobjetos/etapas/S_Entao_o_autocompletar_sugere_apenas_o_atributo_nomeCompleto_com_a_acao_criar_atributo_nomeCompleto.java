package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.etapas;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.entidade.FabAcaoCarameloDevComoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.console.ItemOpcaoConsole;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetos.EtapasconsoleProjCRCObjetos;
import cucumber.api.java.pt.Entao;
import java.util.Collections;
import java.util.List;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;

public class S_Entao_o_autocompletar_sugere_apenas_o_atributo_nomeCompleto_com_a_acao_criar_atributo_nomeCompleto {

	@Entao(EtapasconsoleProjCRCObjetos.ENTAO_O_AUTOCOMPLETAR_SUGERE_APENAS_O_ATRIBUTO_NOMECOMPLETO_COM_A_ACAO_CRIAR_ATRIBUTO_NOMECOMPLETO)
	public void implementacaoEtapa() {
		String sugestao = FluxoConsoleObjetos.NOME_ENTIDADE_CLIENTE + FabTipoItemProjeto.SEPARADOR_ATRIBUTO + FluxoConsoleObjetos.NOME_ATRIBUTO_NOME_COMPLETO;
		Assert.assertEquals("O autocompletar deveria sugerir apenas " + sugestao, Collections.singletonList(sugestao), FluxoConsoleObjetos.sugestoesAutocompletar);

		List<ItemOpcaoConsole> opcoes = FluxoConsoleObjetos.CONSOLE.getOpcoesDisponiveis();
		Assert.assertEquals("Deveria haver apenas a opção de criar o atributo", 1, opcoes.size());
		ItemOpcaoConsole opcao = opcoes.get(0);
		Assert.assertEquals("Ação da opção incorreta", FabAcaoCarameloDevComoItemProjeto.ATRIBUTO_ENTIDADE_CTR_SALVAR, opcao.getFabAcaoAssociada());
		Assert.assertTrue("A opção deveria estar associada a um atributo", opcao.getItemAssociado() instanceof AtributoDeEntidadeSimples);
		AtributoDeEntidadeSimples atributo = (AtributoDeEntidadeSimples) opcao.getItemAssociado();
		Assert.assertEquals("Nome do atributo a criar incorreto", FluxoConsoleObjetos.NOME_ATRIBUTO_NOME_COMPLETO, atributo.getNomeDeclarado());
		Assert.assertNull("O atributo a criar não deveria estar persistido", atributo.getId());
		Assert.assertEquals("Entidade do atributo incorreta", FluxoConsoleObjetos.NOME_ENTIDADE_CLIENTE, atributo.getEntidade().getNomeEntidade());
	}
}
