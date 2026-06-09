package br.org.carameloCode.erp.modulo.projeto.api.model.statusprojeto;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.status.StatusProjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = StatusProjeto.class)
public enum CPStatusProjeto {
	_ID, _NOME, _ICONE, _COR;

	public static final String id = "id";
	public static final String nome = "nome";
	public static final String icone = "icone";
	public static final String cor = "cor";
}