package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.cadastroprojetocrc.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import br.org.carameloCode.erp.modulo.projeto.regraDeNegocio.projeto.ExecAcoesProjetosCRC;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfRespostaAcaoDoSistema;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.cadastroprojetocrc.EtapasCadastroProjetoCRC;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.cadastroprojetocrc.FluxoCadastroProjeto;
import org.junit.Assert;

public class C_Quando_o_usuario_solicita_a_criacao_do_projeto {

	@Quando(EtapasCadastroProjetoCRC.QUANDO_O_USUARIO_SOLICITA_A_CRIACAO_DO_PROJETO)
	public void implementacaoEtapa() {
		ItfRespostaAcaoDoSistema resp = ExecAcoesProjetosCRC.salvarProjeto(FluxoCadastroProjeto.projeto);
		Assert.assertTrue("Falha salvando o projeto", resp.isSucesso());
		Assert.assertNotNull("A ação de salvar não retornou o projeto", resp.getRetorno());

		FluxoCadastroProjeto.projeto = (ProjetoCRC) resp.getRetorno();
	}
}
