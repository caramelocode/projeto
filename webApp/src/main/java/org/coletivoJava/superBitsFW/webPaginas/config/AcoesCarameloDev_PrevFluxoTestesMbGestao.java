package org.coletivoJava.superBitsFW.webPaginas.config;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import com.super_bits.modulosSB.SBCore.UtilGeral.MapaAcoesSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.ItfAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.ItfAcaoFormularioEntidade;

@Named
@ApplicationScoped
public class AcoesCarameloDev_PrevFluxoTestesMbGestao implements Serializable {

	public ItfAcaoFormulario getPrevFluxoTestesMbGestao() {
		return (ItfAcaoFormulario) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevConsoleCRCProjeto.PREV_FLUXO_TESTES_MB_GESTAO");
	}

	public ItfAcaoFormularioEntidade getPrevFluxoTestesFrmListar() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevConsoleCRCProjeto.PREV_FLUXO_TESTES_FRM_LISTAR");
	}

	public ItfAcaoFormularioEntidade getPrevFluxoTestesFrmVerFluxo() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevConsoleCRCProjeto.PREV_FLUXO_TESTES_FRM_VER_FLUXO");
	}
}