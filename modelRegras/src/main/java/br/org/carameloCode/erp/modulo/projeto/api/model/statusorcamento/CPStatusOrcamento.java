package br.org.carameloCode.erp.modulo.projeto.api.model.statusorcamento;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.orcamento.StatusOrcamento;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = StatusOrcamento.class)
public enum CPStatusOrcamento {
	_ID, _NOME, _ICONE, _COR, _STATUSENUM;

	public static final String id = "id";
	public static final String nome = "nome";
	public static final String icone = "icone";
	public static final String cor = "cor";
	public static final String statusenum = "statusEnum";
}