package org.coletivoJava.superBitsFW.webPaginas.config;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import com.super_bits.modulosSB.SBCore.UtilGeral.MapaAcoesSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.ItfAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.ItfAcaoFormularioEntidade;

@Named
@ApplicationScoped
public class AcoesCarameloDev_DashboardProjetoMbGestao implements Serializable {

	public ItfAcaoFormulario getDashboardProjetoMbGestao() {
		return (ItfAcaoFormulario) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevConsoleCRCProjeto.DASHBOARD_PROJETO_MB_GESTAO");
	}

	public ItfAcaoFormularioEntidade getDashboardProjetoFrmVisaoGeral() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevConsoleCRCProjeto.DASHBOARD_PROJETO_FRM_VISAO_GERAL");
	}

	public ItfAcaoFormularioEntidade getDashboardProjetoFrmEntidades() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevConsoleCRCProjeto.DASHBOARD_PROJETO_FRM_ENTIDADES");
	}

	public ItfAcaoFormularioEntidade getDashboardProjetoFrmFabricas() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevConsoleCRCProjeto.DASHBOARD_PROJETO_FRM_FABRICAS");
	}

	public ItfAcaoFormularioEntidade getDashboardProjetoFrmRequisitos() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevConsoleCRCProjeto.DASHBOARD_PROJETO_FRM_REQUISITOS");
	}

	public ItfAcaoFormularioEntidade getDashboardProjetoFrmComponentes() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevConsoleCRCProjeto.DASHBOARD_PROJETO_FRM_COMPONENTES");
	}

	public ItfAcaoFormularioEntidade getDashboardProjetoFrmFluxoTestes() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevConsoleCRCProjeto.DASHBOARD_PROJETO_FRM_FLUXO_TESTES");
	}
}