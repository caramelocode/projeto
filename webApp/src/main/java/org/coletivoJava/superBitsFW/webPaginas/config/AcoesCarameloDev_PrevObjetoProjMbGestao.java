package org.coletivoJava.superBitsFW.webPaginas.config;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import com.super_bits.modulosSB.SBCore.UtilGeral.MapaAcoesSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.ItfAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.ItfAcaoFormularioEntidade;

@Named
@ApplicationScoped
public class AcoesCarameloDev_PrevObjetoProjMbGestao implements Serializable {

	public ItfAcaoFormulario getPrevObjetoProjMbGestao() {
		return (ItfAcaoFormulario) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevConsoleCRCProjeto.PREV_OBJETO_PROJ_MB_GESTAO");
	}

	public ItfAcaoFormularioEntidade getPrevObjetoProjFrmGenerico() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevConsoleCRCProjeto.PREV_OBJETO_PROJ_FRM_GENERICO");
	}

	public ItfAcaoFormularioEntidade getPrevObjetoProjFrmStatus() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevConsoleCRCProjeto.PREV_OBJETO_PROJ_FRM_STATUS");
	}
}