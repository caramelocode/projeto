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
public class AcoesCarameloDev_FabricaGenericaMbGestao implements Serializable {

	public ItfAcaoFormulario getFabricaGenericaMbGestao() {
		return (ItfAcaoFormulario) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.FABRICA_GENERICA_MB_GESTAO");
	}

	public ItfAcaoFormularioEntidade getFabricaGenericaFrmEditar() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.FABRICA_GENERICA_FRM_EDITAR");
	}

	public ComoAcaoControllerEntidade getFabricaGenericaCtrSalvarNovo() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.FABRICA_GENERICA_CTR_SALVAR_NOVO");
	}

	public ComoAcaoControllerEntidade getFabricaGenericaCtrSalvarMerge() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.FABRICA_GENERICA_CTR_SALVAR_MERGE");
	}

	public ComoAcaoControllerEntidade getFabricaGenericaCtrValidar() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.FABRICA_GENERICA_CTR_VALIDAR");
	}

	public ComoAcaoControllerEntidade getFabricaGenericaCtrRemover() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.FABRICA_GENERICA_CTR_REMOVER");
	}
}