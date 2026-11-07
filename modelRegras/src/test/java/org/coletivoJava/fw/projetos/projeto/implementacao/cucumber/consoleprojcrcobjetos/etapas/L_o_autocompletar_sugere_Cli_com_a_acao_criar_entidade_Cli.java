package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.etapas;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.entidade.FabAcaoCarameloDevComoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetos.EtapasconsoleProjCRCObjetos;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;

public class L_o_autocompletar_sugere_Cli_com_a_acao_criar_entidade_Cli {

	@E(EtapasconsoleProjCRCObjetos.E_O_AUTOCOMPLETAR_SUGERE_CLI_COM_A_ACAO_CRIAR_ENTIDADE_CLI)
	public void implementacaoEtapa() {
		Assert.assertTrue("O autocompletar não sugeriu " + FluxoConsoleObjetos.TEXTO_PARCIAL_CLI,
				FluxoConsoleObjetos.sugestoesAutocompletar.contains(FluxoConsoleObjetos.TEXTO_PARCIAL_CLI));
		boolean temOpcaoCriar = FluxoConsoleObjetos.CONSOLE.getOpcoesDisponiveis().stream()
				.filter(op -> op.getItemAssociado() instanceof ObjetoProjCRC)
				.anyMatch(op -> FabAcaoCarameloDevComoItemProjeto.ENTIDADE_CTR_SALVAR.equals(op.getFabAcaoAssociada())
				&& FluxoConsoleObjetos.TEXTO_PARCIAL_CLI.equals(((ObjetoProjCRC) op.getItemAssociado()).getNomeEntidade()));
		Assert.assertTrue("Não há opção de criar a entidade " + FluxoConsoleObjetos.TEXTO_PARCIAL_CLI, temOpcaoCriar);
	}
}
