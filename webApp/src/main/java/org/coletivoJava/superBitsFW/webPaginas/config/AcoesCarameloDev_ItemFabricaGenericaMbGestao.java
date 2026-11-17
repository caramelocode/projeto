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
public class AcoesCarameloDev_ItemFabricaGenericaMbGestao
		implements
			Serializable {

	public ItfAcaoFormulario getItemFabricaGenericaMbGestao() {
		return (ItfAcaoFormulario) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevComoItemProjeto.ITEM_FABRICA_GENERICA_MB_GESTAO");
	}

	public ItfAcaoFormularioEntidade getItemFabricaGenericaFrmNovo() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevComoItemProjeto.ITEM_FABRICA_GENERICA_FRM_NOVO");
	}

	public ItfAcaoFormularioEntidade getItemFabricaGenericaFrmEditar() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevComoItemProjeto.ITEM_FABRICA_GENERICA_FRM_EDITAR");
	}

	public ComoAcaoControllerEntidade getItemFabricaGenericaCtrSalvarNovo() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevComoItemProjeto.ITEM_FABRICA_GENERICA_CTR_SALVAR_NOVO");
	}

	public ComoAcaoControllerEntidade getItemFabricaGenericaCtrSalvarMerge() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevComoItemProjeto.ITEM_FABRICA_GENERICA_CTR_SALVAR_MERGE");
	}

	public ComoAcaoControllerEntidade getItemFabricaGenericaCtrValidar() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevComoItemProjeto.ITEM_FABRICA_GENERICA_CTR_VALIDAR");
	}

	public ComoAcaoControllerEntidade getItemFabricaGenericaCtrRemover() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevComoItemProjeto.ITEM_FABRICA_GENERICA_CTR_REMOVER");
	}
}