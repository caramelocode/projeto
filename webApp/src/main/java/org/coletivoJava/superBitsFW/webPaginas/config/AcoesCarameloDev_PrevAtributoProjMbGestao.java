package org.coletivoJava.superBitsFW.webPaginas.config;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import com.super_bits.modulosSB.SBCore.UtilGeral.MapaAcoesSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.ItfAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.ItfAcaoFormularioEntidade;

@Named
@ApplicationScoped
public class AcoesCarameloDev_PrevAtributoProjMbGestao implements Serializable {

	public ItfAcaoFormulario getPrevAtributoProjMbGestao() {
		return (ItfAcaoFormulario) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevConsoleCRCProjeto.PREV_ATRIBUTO_PROJ_MB_GESTAO");
	}

	public ItfAcaoFormularioEntidade getPrevAtributoProjFrmVisualizarAtributo() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevConsoleCRCProjeto.PREV_ATRIBUTO_PROJ_FRM_VISUALIZAR_ATRIBUTO");
	}
}