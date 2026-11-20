package org.coletivoJava.superBitsFW.webPaginas.config;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import com.super_bits.modulosSB.SBCore.UtilGeral.MapaAcoesSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.ItfAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.ItfAcaoFormularioEntidade;

@Named
@ApplicationScoped
public class AcoesCarameloDev_PrevAcaoMbGestao implements Serializable {

	public ItfAcaoFormulario getPrevAcaoMbGestao() {
		return (ItfAcaoFormulario) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevConsoleCRCProjeto.PREV_ACAO_MB_GESTAO");
	}

	public ItfAcaoFormularioEntidade getPrevAcaoFrmAcFormulario() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevConsoleCRCProjeto.PREV_ACAO_FRM_AC_FORMULARIO");
	}

	public ItfAcaoFormularioEntidade getPrevAcaoFrmAcController() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevConsoleCRCProjeto.PREV_ACAO_FRM_AC_CONTROLLER");
	}

	public ItfAcaoFormularioEntidade getPrevAcaoFrmAcGestao() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevConsoleCRCProjeto.PREV_ACAO_FRM_AC_GESTAO");
	}
}