package br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadefabrica;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeFabrica;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = AtributoDeEntidadeFabrica.class)
public enum CPAtributoDeEntidadeFabrica {
	_FABRICAENTIDADE;

	public static final String fabricaentidade = "fabricaEntidade";
}