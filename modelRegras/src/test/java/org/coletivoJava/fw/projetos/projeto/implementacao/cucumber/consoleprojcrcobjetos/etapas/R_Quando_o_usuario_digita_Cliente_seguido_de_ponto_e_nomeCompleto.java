package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetos.EtapasconsoleProjCRCObjetos;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;

public class R_Quando_o_usuario_digita_Cliente_seguido_de_ponto_e_nomeCompleto {

	@Quando(EtapasconsoleProjCRCObjetos.QUANDO_O_USUARIO_DIGITA_CLIENTE_SEGUIDO_DE_PONTO_E_NOMECOMPLETO)
	public void implementacaoEtapa() {
		String textoDigitado = FluxoConsoleObjetos.NOME_ENTIDADE_CLIENTE + FabTipoItemProjeto.SEPARADOR_ATRIBUTO + FluxoConsoleObjetos.NOME_ATRIBUTO_NOME_COMPLETO;
		FluxoConsoleObjetos.sugestoesAutocompletar = FluxoConsoleObjetos.CONSOLE.autocompletProjeto(textoDigitado);
		Assert.assertNotNull("O autocompletar não retornou sugestões", FluxoConsoleObjetos.sugestoesAutocompletar);
		Assert.assertEquals("Texto definido incorreto", textoDigitado, FluxoConsoleObjetos.CONSOLE.getTextoDefinido());
	}
}
