package br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadestatus;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeStatus;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = AtributoDeEntidadeStatus.class)
public enum CPAtributoDeEntidadeStatus {
	_ENTIDADESTATUS;

	public static final String entidadestatus = "entidadeStatus";
}