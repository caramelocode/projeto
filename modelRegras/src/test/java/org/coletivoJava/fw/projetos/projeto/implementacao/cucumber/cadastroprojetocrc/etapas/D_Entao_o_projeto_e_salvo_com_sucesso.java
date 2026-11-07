package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.cadastroprojetocrc.etapas;

import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.cadastroprojetocrc.EtapasCadastroProjetoCRC;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.cadastroprojetocrc.FluxoCadastroProjeto;
import org.junit.Assert;

public class D_Entao_o_projeto_e_salvo_com_sucesso {

	@Entao(EtapasCadastroProjetoCRC.ENTAO_O_PROJETO_E_SALVO_COM_SUCESSO)
	public void implementacaoEtapa() {
		FluxoCadastroProjeto.renovarConexaoEntityManagerEscopoTeste();
		FluxoCadastroProjeto.atualizarEntidadesDeclaradas();

		Assert.assertNotNull("Projeto não encontrado após salvar", FluxoCadastroProjeto.projeto);
		Assert.assertNotNull("Projeto salvo sem id", FluxoCadastroProjeto.projeto.getId());
		Assert.assertEquals("Nome do projeto incorreto", FluxoCadastroProjeto.NOME_PROJETO, FluxoCadastroProjeto.projeto.getNome());
		Assert.assertEquals("Descrição do projeto incorreta", FluxoCadastroProjeto.DESCRICAO_PROJETO, FluxoCadastroProjeto.projeto.getDescricao());
	}
}
