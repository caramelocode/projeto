package org.coletivoJava.superBitsFW.webPaginas.config;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import com.super_bits.modulosSB.SBCore.UtilGeral.MapaAcoesSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.ItfAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.ItfAcaoFormularioEntidade;

@Named
@ApplicationScoped
public class AcoesCarameloDev_PrevisualizacaoItemProjMbGestao
		implements
			Serializable {

	public ItfAcaoFormulario getPrevisualizacaoItemProjMbGestao() {
		return (ItfAcaoFormulario) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevComoItemProjeto.PREVISUALIZACAO_ITEM_PROJ_MB_GESTAO");
	}

	public ItfAcaoFormularioEntidade getPrevisualizacaoItemProjFrmVisualizarAtributo() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevComoItemProjeto.PREVISUALIZACAO_ITEM_PROJ_FRM_VISUALIZAR_ATRIBUTO");
	}

	public ItfAcaoFormularioEntidade getPrevisualizacaoItemProjFrmVisualizarEntidade() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevComoItemProjeto.PREVISUALIZACAO_ITEM_PROJ_FRM_VISUALIZAR_ENTIDADE");
	}

	public ItfAcaoFormularioEntidade getPrevisualizacaoItemProjFrmVisualizarAcaoGestao() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevComoItemProjeto.PREVISUALIZACAO_ITEM_PROJ_FRM_VISUALIZAR_ACAO_GESTAO");
	}

	public ItfAcaoFormularioEntidade getPrevisualizacaoItemProjFrmVisualizarAcaoController() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevComoItemProjeto.PREVISUALIZACAO_ITEM_PROJ_FRM_VISUALIZAR_ACAO_CONTROLLER");
	}
}