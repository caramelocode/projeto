package org.coletivoJava.superBitsFW.webPaginas.config;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import com.super_bits.modulosSB.SBCore.UtilGeral.MapaAcoesSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.ItfAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.ItfAcaoFormularioEntidade;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.acoes.ComoAcaoControllerEntidade;

@Named
@ApplicationScoped
public class AcoesCarameloDev_ItemFabricaStatusMbGestao implements Serializable {

	public ItfAcaoFormulario getItemFabricaStatusMbGestao() {
		return (ItfAcaoFormulario) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ITEM_FABRICA_STATUS_MB_GESTAO");
	}

	public ItfAcaoFormularioEntidade getItemFabricaStatusFrmEditar() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ITEM_FABRICA_STATUS_FRM_EDITAR");
	}

	public ComoAcaoControllerEntidade getItemFabricaStatusCtrSalvarNovo() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ITEM_FABRICA_STATUS_CTR_SALVAR_NOVO");
	}

	public ComoAcaoControllerEntidade getItemFabricaStatusCtrSalvarMerge() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ITEM_FABRICA_STATUS_CTR_SALVAR_MERGE");
	}

	public ComoAcaoControllerEntidade getItemFabricaStatusCtrValidar() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ITEM_FABRICA_STATUS_CTR_VALIDAR");
	}

	public ComoAcaoControllerEntidade getItemFabricaStatusCtrRemover() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ITEM_FABRICA_STATUS_CTR_REMOVER");
	}
}