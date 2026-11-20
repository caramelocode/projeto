package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.etapas;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.objeto.FabAcaoCarameloDevEdicaoItemProj;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetos.EtapasconsoleProjCRCObjetos;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;

public class M_o_autocompletar_sugere_Cliente_com_a_acao_editar_entidade_Cliente {

	@E(EtapasconsoleProjCRCObjetos.E_O_AUTOCOMPLETAR_SUGERE_CLIENTE_COM_A_ACAO_EDITAR_ENTIDADE_CLIENTE)
	public void implementacaoEtapa() {
		Assert.assertTrue("O autocompletar não sugeriu " + FluxoConsoleObjetos.NOME_ENTIDADE_CLIENTE,
				FluxoConsoleObjetos.sugestoesAutocompletar.contains(FluxoConsoleObjetos.NOME_ENTIDADE_CLIENTE));
		boolean temOpcaoEditar = FluxoConsoleObjetos.CONSOLE.getOpcoesDisponiveis().stream()
				.filter(op -> op.getItemAssociado() instanceof ObjetoProjCRC)
				.anyMatch(op -> FabAcaoCarameloDevEdicaoItemProj.ENTIDADE_FRM_EDITAR.equals(op.getFabAcaoCriarItem())
				&& FluxoConsoleObjetos.NOME_ENTIDADE_CLIENTE.equals(((ObjetoProjCRC) op.getItemAssociado()).getNomeEntidade()));
		Assert.assertTrue("Não há opção de editar a entidade " + FluxoConsoleObjetos.NOME_ENTIDADE_CLIENTE, temOpcaoEditar);
	}
}
