package br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadesimples;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = AtributoDeEntidadeSimples.class)
public enum CPAtributoDeEntidadeSimples {
	_ID, _NOMEDECLARADO, _DESCRICAO, _OBRIGATORIO, _TIPO, _ENTIDADE, _TIPOATRIBUTO;

	public static final String id = "id";
	public static final String nomedeclarado = "nomeDeclarado";
	public static final String descricao = "descricao";
	public static final String obrigatorio = "obrigatorio";
	public static final String tipo = "tipo";
	public static final String entidade = "entidade";
	public static final String tipoatributo = "tipoAtributo";
}