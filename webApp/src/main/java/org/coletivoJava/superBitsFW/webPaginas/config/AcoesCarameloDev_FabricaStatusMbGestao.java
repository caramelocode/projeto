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
public class AcoesCarameloDev_FabricaStatusMbGestao implements Serializable {

	public ItfAcaoFormulario getFabricaStatusMbGestao() {
		return (ItfAcaoFormulario) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.FABRICA_STATUS_MB_GESTAO");
	}

	public ItfAcaoFormularioEntidade getFabricaStatusFrmEditar() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.FABRICA_STATUS_FRM_EDITAR");
	}

	public ComoAcaoControllerEntidade getFabricaStatusCtrSalvarNovo() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.FABRICA_STATUS_CTR_SALVAR_NOVO");
	}

	public ComoAcaoControllerEntidade getFabricaStatusCtrSalvarMerge() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.FABRICA_STATUS_CTR_SALVAR_MERGE");
	}

	public ComoAcaoControllerEntidade getFabricaStatusCtrValidar() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.FABRICA_STATUS_CTR_VALIDAR");
	}

	public ComoAcaoControllerEntidade getFabricaStatusCtrRemover() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.FABRICA_STATUS_CTR_REMOVER");
	}
}