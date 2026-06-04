package br.org.carameloCode.erp.modulo.projeto.api.model.exemploopcaocomiconecor;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.itensExemplo.ExemploOpcaoComIconeCor;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = ExemploOpcaoComIconeCor.class)
public enum CPExemploOpcaoComIconeCor {
	_ICONE, _COR;

	public static final String icone = "icone";
	public static final String cor = "cor";
}