package br.org.carameloCode.erp.modulo.projeto.api.model.entdexemplo;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.entidadeExemplo.EntdExemplo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = EntdExemplo.class)
public enum CPEntdExemplo {
	_ID, _NOME, _DESCRICAO, _DATA, _DATAHORA, _HORA, _COR, _ICONE, _QUANTIDADE, _VALORMOEDAREAL, _VALORMOEDADOLLAR, _PORCENTAGEM, _USUARIOFORNECEDOR, _USUARIOCLIENTE, _TIPENTIDADE, _USUARIOEDICAO, _DATAHORAINSERCAO, _DATAHORAEDICAO, _HTMLMODELO, _HTMLSIMPLES, _OPCAODE2, _OPCAODE3, _OPCAODE4, _OPCAOPERSONALIZADA, _OPCAODE10, _FABRICAENUM, _LISTADEOPCOESENTIDADEPUBLICA, _LISTADEOPCOESENTIDADEPARTICULAR;

	public static final String id = "id";
	public static final String nome = "nome";
	public static final String descricao = "descricao";
	public static final String data = "data";
	public static final String datahora = "dataHora";
	public static final String hora = "hora";
	public static final String cor = "cor";
	public static final String icone = "icone";
	public static final String quantidade = "quantidade";
	public static final String valormoedareal = "valorMoedaReal";
	public static final String valormoedadollar = "valorMoedaDollar";
	public static final String porcentagem = "porcentagem";
	public static final String usuariofornecedor = "usuarioFornecedor";
	public static final String usuariocliente = "usuarioCliente";
	public static final String tipentidade = "tipEntidade";
	public static final String usuarioedicao = "usuarioEdicao";
	public static final String datahorainsercao = "dataHoraInsercao";
	public static final String datahoraedicao = "dataHoraEdicao";
	public static final String htmlmodelo = "htmlModelo";
	public static final String htmlsimples = "htmlSimples";
	public static final String opcaode2 = "opcaoDe2";
	public static final String opcaode3 = "opcaode3";
	public static final String opcaode4 = "opcaode4";
	public static final String opcaopersonalizada = "opcaoPersonalizada";
	public static final String opcaode10 = "opcaoDe10";
	public static final String fabricaenum = "fabricaEnum";
	public static final String listadeopcoesentidadepublica = "listaDeOpcoesEntidadePublica";
	public static final String listadeopcoesentidadeparticular = "listaDeOpcoesEntidadeParticular";
}