package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.cadastroprojetocrc.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import cucumber.api.java.pt.Dado;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.cadastroprojetocrc.EtapasCadastroProjetoCRC;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.cadastroprojetocrc.FluxoCadastroProjeto;
import org.coletivojava.fw.api.tratamentoErros.ErroPreparandoObjeto;
import org.junit.Assert;

public class A_Dado_um_novo_projeto_com_nome_informado {

	@Dado(EtapasCadastroProjetoCRC.DADO_UM_NOVO_PROJETO_COM_NOME_INFORMADO)
	public void implementacaoEtapa() {
		CarameloCode.getServicoSessao().logarEmailESenha(FluxoCadastroProjeto.EMAIL_USUARIO_ADMIN, FluxoCadastroProjeto.SENHA_ADMIN);
		Assert.assertTrue("Falha no login", CarameloCode.getServicoSessao().getSessaoAtual().isIdentificado());

		ProjetoCRC novoProjeto = new ProjetoCRC();
		try {
			novoProjeto.prepararNovoObjeto(CarameloCode.getUsuarioLogado());
		} catch (ErroPreparandoObjeto erro) {
			Assert.fail("Falha preparando novo projeto: " + erro.getMessage());
		}
		novoProjeto.setNome(FluxoCadastroProjeto.NOME_PROJETO);
		FluxoCadastroProjeto.projeto = novoProjeto;

		Assert.assertEquals("Nome do projeto não informado", FluxoCadastroProjeto.NOME_PROJETO, FluxoCadastroProjeto.projeto.getNome());
	}
}
