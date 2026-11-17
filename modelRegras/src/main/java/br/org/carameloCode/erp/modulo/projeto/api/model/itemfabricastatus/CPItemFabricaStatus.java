package br.org.carameloCode.erp.modulo.projeto.api.model.itemfabricastatus;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.ItemFabricaStatus;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = ItemFabricaStatus.class)
public enum CPItemFabricaStatus {
	_ACOESDOSTATUS;

	public static final String acoesdostatus = "acoesDoStatus";
}