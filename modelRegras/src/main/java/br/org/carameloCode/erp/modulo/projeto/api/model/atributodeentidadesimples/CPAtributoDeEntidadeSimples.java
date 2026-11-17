package br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadesimples;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = AtributoDeEntidadeSimples.class)
public enum CPAtributoDeEntidadeSimples {
	_ID, _NOMEDECLARADO, _LABEL, _DESCRICAO, _OBRIGATORIO, _TIPO, _ENTIDADE, _TIPOATRIBUTO, _VALORMAXIMO, _VALORMINIMO, _VALIDACAOREGEX, _SEPARADORDECIMAL, _SEPARADORMILHAR, _NUMERODECASASDECIMAIS, _MASCARAJQUERYMODE, _SOMENTELEITURA, _FRASEVALIDACAO, _UMALISTAGEMDINAMICA, _UMVALORCAMPOUNICO, _ICONEPOSITIVO, _TEXTOPOSITIVO, _ICONENEGATIVO, _TEXTONEGATIVO, _DATAHORAALTERACAO, _DATAHORAINSERSAO, _USUARIOINSERCAO, _USUARIOALTERACAO, _ORDEM;

	public static final String id = "id";
	public static final String nomedeclarado = "nomeDeclarado";
	public static final String label = "label";
	public static final String descricao = "descricao";
	public static final String obrigatorio = "obrigatorio";
	public static final String tipo = "tipo";
	public static final String entidade = "entidade";
	public static final String tipoatributo = "tipoAtributo";
	public static final String valormaximo = "valorMaximo";
	public static final String valorminimo = "valorMinimo";
	public static final String validacaoregex = "validacaoRegex";
	public static final String separadordecimal = "separadorDecimal";
	public static final String separadormilhar = "separadorMilhar";
	public static final String numerodecasasdecimais = "numeroDeCasasDecimais";
	public static final String mascarajquerymode = "mascaraJqueryMode";
	public static final String somenteleitura = "somenteLeitura";
	public static final String frasevalidacao = "fraseValidacao";
	public static final String umalistagemdinamica = "umalistagemDinamica";
	public static final String umvalorcampounico = "umValorCampoUnico";
	public static final String iconepositivo = "iconePositivo";
	public static final String textopositivo = "textoPositivo";
	public static final String iconenegativo = "iconeNegativo";
	public static final String textonegativo = "textoNegativo";
	public static final String datahoraalteracao = "dataHoraAlteracao";
	public static final String datahorainsersao = "dataHoraInsersao";
	public static final String usuarioinsercao = "usuarioInsercao";
	public static final String usuarioalteracao = "usuarioAlteracao";
	public static final String ordem = "ordem";
}