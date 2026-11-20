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
public class AcoesCarameloDev_FluxoTesteMbGestao implements Serializable {

	public ItfAcaoFormulario getFluxoTesteMbGestao() {
		return (ItfAcaoFormulario) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevProjetoCRC.FLUXO_TESTE_MB_GESTAO");
	}

	public ItfAcaoFormularioEntidade getFluxoTesteFrmListar() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevProjetoCRC.FLUXO_TESTE_FRM_LISTAR");
	}

	public ItfAcaoFormularioEntidade getFluxoTesteFrmNovo() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevProjetoCRC.FLUXO_TESTE_FRM_NOVO");
	}

	public ItfAcaoFormularioEntidade getFluxoTesteFrmEditar() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevProjetoCRC.FLUXO_TESTE_FRM_EDITAR");
	}

	public ComoAcaoControllerEntidade getFluxoTesteCtrSalvarMerge() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevProjetoCRC.FLUXO_TESTE_CTR_SALVAR_MERGE");
	}
}