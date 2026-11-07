package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetos.EtapasconsoleProjCRCObjetos;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;

public class O_Quando_o_usuario_seleciona_Cliente_seguido_de_ponto_e_digita_n {

	@Quando(EtapasconsoleProjCRCObjetos.QUANDO_O_USUARIO_SELECIONA_CLIENTE_SEGUIDO_DE_PONTO_E_DIGITA_N)
	public void implementacaoEtapa() {
		String sugestaoSelecionada = FluxoConsoleObjetos.NOME_ENTIDADE_CLIENTE + FabTipoItemProjeto.SEPARADOR_ATRIBUTO;
		Assert.assertTrue("A sugestão " + sugestaoSelecionada + " não está disponível para seleção",
				FluxoConsoleObjetos.sugestoesAutocompletar.contains(sugestaoSelecionada));

		String textoDigitado = sugestaoSelecionada + FluxoConsoleObjetos.TEXTO_PARCIAL_ATRIBUTO_N;
		FluxoConsoleObjetos.sugestoesAutocompletar = FluxoConsoleObjetos.CONSOLE.autocompletProjeto(textoDigitado);
		Assert.assertNotNull("O autocompletar não retornou sugestões", FluxoConsoleObjetos.sugestoesAutocompletar);
		Assert.assertEquals("Texto definido incorreto", textoDigitado, FluxoConsoleObjetos.CONSOLE.getTextoDefinido());
	}
}
