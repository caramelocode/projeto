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
public class AcoesCarameloDev_AtributoEntidadeMbGestao implements Serializable {

	public ItfAcaoFormulario getAtributoEntidadeMbGestao() {
		return (ItfAcaoFormulario) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_MB_GESTAO");
	}

	public ItfAcaoFormularioEntidade getAtributoEntidadeFrmListar() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_FRM_LISTAR");
	}

	public ItfAcaoFormularioEntidade getAtributoEntidadeFrmEditar() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_FRM_EDITAR");
	}

	public ItfAcaoFormularioEntidade getAtributoEntidadeFrmEditarObjeto() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_FRM_EDITAR_OBJETO");
	}

	public ItfAcaoFormularioEntidade getAtributoEntidadeFrmEditarLista() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_FRM_EDITAR_LISTA");
	}

	public ComoAcaoControllerEntidade getAtributoEntidadeCtrSalvarNovo() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_SALVAR_NOVO");
	}

	public ComoAcaoControllerEntidade getAtributoEntidadeCtrSalvarMerge() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_SALVAR_MERGE");
	}

	public ComoAcaoControllerEntidade getAtributoEntidadeCtrValidar() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_VALIDAR");
	}

	public ComoAcaoControllerEntidade getAtributoEntidadeCtrRemover() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_REMOVER");
	}

	public ComoAcaoControllerEntidade getAtributoEntidadeCtrSalvarNovoTpEntidade() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_SALVAR_NOVO_TP_ENTIDADE");
	}

	public ComoAcaoControllerEntidade getAtributoEntidadeCtrSalvarMergeTpEntidade() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_SALVAR_MERGE_TP_ENTIDADE");
	}

	public ComoAcaoControllerEntidade getAtributoEntidadeCtrValidarTpEntidade() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_VALIDAR_TP_ENTIDADE");
	}

	public ComoAcaoControllerEntidade getAtributoEntidadeCtrRemoverTpEntidade() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_REMOVER_TP_ENTIDADE");
	}

	public ComoAcaoControllerEntidade getAtributoEntidadeCtrSalvarNovoTpLista() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_SALVAR_NOVO_TP_LISTA");
	}

	public ComoAcaoControllerEntidade getAtributoEntidadeCtrSalvarMergeTpLista() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_SALVAR_MERGE_TP_LISTA");
	}

	public ComoAcaoControllerEntidade getAtributoEntidadeCtrValidarTpLista() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_VALIDAR_TP_LISTA");
	}

	public ComoAcaoControllerEntidade getAtributoEntidadeCtrRemoverTpLista() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_REMOVER_TP_LISTA");
	}
}