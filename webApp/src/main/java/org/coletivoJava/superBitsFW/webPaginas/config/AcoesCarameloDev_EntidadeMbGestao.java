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
public class AcoesCarameloDev_EntidadeMbGestao implements Serializable {

	public ItfAcaoFormulario getEntidadeMbGestao() {
		return (ItfAcaoFormulario) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ENTIDADE_MB_GESTAO");
	}

	public ItfAcaoFormularioEntidade getEntidadeFrmListar() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ENTIDADE_FRM_LISTAR");
	}

	public ItfAcaoFormularioEntidade getEntidadeFrmEditar() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ENTIDADE_FRM_EDITAR");
	}

	public ComoAcaoControllerEntidade getEntidadeCtrSalvarNovo() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ENTIDADE_CTR_SALVAR_NOVO");
	}

	public ComoAcaoControllerEntidade getEntidadeCtrSalvarMerge() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ENTIDADE_CTR_SALVAR_MERGE");
	}

	public ComoAcaoControllerEntidade getEntidadeCtrValidar() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ENTIDADE_CTR_VALIDAR");
	}

	public ComoAcaoControllerEntidade getEntidadeCtrRemover() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ENTIDADE_CTR_REMOVER");
	}
}