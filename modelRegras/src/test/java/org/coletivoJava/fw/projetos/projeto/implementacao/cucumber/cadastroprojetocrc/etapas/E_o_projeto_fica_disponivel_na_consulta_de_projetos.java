package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.cadastroprojetocrc.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import cucumber.api.java.pt.E;
import java.util.List;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.cadastroprojetocrc.EtapasCadastroProjetoCRC;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.cadastroprojetocrc.FluxoCadastroProjeto;
import org.junit.Assert;

public class E_o_projeto_fica_disponivel_na_consulta_de_projetos {

	@E(EtapasCadastroProjetoCRC.E_O_PROJETO_FICA_DISPONIVEL_NA_CONSULTA_DE_PROJETOS)
	public void implementacaoEtapa() {
		List<ProjetoCRC> projetos = UtilSBPersistencia.getListaTodos(ProjetoCRC.class, FluxoCadastroProjeto.getEM());
		Assert.assertNotNull("Consulta de projetos retornou nulo", projetos);

		ProjetoCRC projetoConsultado = projetos.stream()
				.filter(p -> FluxoCadastroProjeto.projeto.getId().equals(p.getId()))
				.findFirst()
				.orElse(null);

		Assert.assertNotNull("Projeto cadastrado não aparece na consulta de projetos", projetoConsultado);
		Assert.assertEquals("Nome do projeto incorreto na consulta", FluxoCadastroProjeto.NOME_PROJETO, projetoConsultado.getNome());
		Assert.assertEquals("Descrição do projeto incorreta na consulta", FluxoCadastroProjeto.DESCRICAO_PROJETO, projetoConsultado.getDescricao());
	}
}
