package br.org.carameloCode.erp.modulo.projeto.api.model.requisitodeprojeto;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.requisito.RequisitoDeProjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = RequisitoDeProjeto.class)
public enum CPRequisitoDeProjeto {
	_ID, _NOME, _SOLICITANTE, _PROJETO, _TEMPOESTIMADOARQUITETO, _TEMPOESTIMADODEV, _REVISOR;

	public static final String id = "id";
	public static final String nome = "nome";
	public static final String solicitante = "solicitante";
	public static final String projeto = "projeto";
	public static final String tempoestimadoarquiteto = "tempoEstimadoArquiteto";
	public static final String tempoestimadodev = "tempoEStimadoDev";
	public static final String revisor = "revisor";
}