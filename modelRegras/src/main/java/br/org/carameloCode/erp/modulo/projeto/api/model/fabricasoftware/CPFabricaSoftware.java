package br.org.carameloCode.erp.modulo.projeto.api.model.fabricasoftware;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.fabricaSoftware.FabricaSoftware;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = FabricaSoftware.class)
public enum CPFabricaSoftware {
	_ID, _NOME, _DOCUMENTO, _PLANO, _USUARIORESPONSAVEL, _EQUIPE, _VALORHORAARQUITETO, _VALORHORAPESQUISA, _VALORHORADEVBACKEND, _VALORHORADEVFRONTEND, _VALORENTIDADE, _VALORATRIBUTO, _VALORACAOPADRAO, _VALORACAOGESTAO, _VALORMINACAOPERSONALIZADA, _REPOSITORIOPADRAO;

	public static final String id = "id";
	public static final String nome = "nome";
	public static final String documento = "documento";
	public static final String plano = "plano";
	public static final String usuarioresponsavel = "usuarioREsponsavel";
	public static final String equipe = "equipe";
	public static final String valorhoraarquiteto = "valorHoraArquiteto";
	public static final String valorhorapesquisa = "valorHoraPesquisa";
	public static final String valorhoradevbackend = "valorHoraDevBackend";
	public static final String valorhoradevfrontend = "valorHoraDevFrontEnd";
	public static final String valorentidade = "valorEntidade";
	public static final String valoratributo = "valorAtributo";
	public static final String valoracaopadrao = "valorAcaoPadrao";
	public static final String valoracaogestao = "valorAcaoGestao";
	public static final String valorminacaopersonalizada = "valorMinAcaoPersonalizada";
	public static final String repositoriopadrao = "repositorioPadrao";
}