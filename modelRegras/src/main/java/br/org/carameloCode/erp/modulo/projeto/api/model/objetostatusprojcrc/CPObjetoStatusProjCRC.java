package br.org.carameloCode.erp.modulo.projeto.api.model.objetostatusprojcrc;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoStatusProjCRC;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = ObjetoStatusProjCRC.class)
public enum CPObjetoStatusProjCRC {
	_PREFIXO_ENTIDADE_STATUS, _PREFIXO_FABRICA, _FABRICASTATUS;

	public static final String prefixo_entidade_status = "PREFIXO_ENTIDADE_STATUS";
	public static final String prefixo_fabrica = "PREFIXO_FABRICA";
	public static final String fabricastatus = "fabricaStatus";
}