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
public class AcoesCarameloDev_CrudExemploMbGestao implements Serializable {

	public ItfAcaoFormulario getCrudExemploMbGestao() {
		return (ItfAcaoFormulario) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCCarameloFormulario.CRUD_EXEMPLO_MB_GESTAO");
	}

	public ItfAcaoFormularioEntidade getCrudExemploFrmListar() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCCarameloFormulario.CRUD_EXEMPLO_FRM_LISTAR");
	}

	public ItfAcaoFormularioEntidade getCrudExemploFrmListarModelo2() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCCarameloFormulario.CRUD_EXEMPLO_FRM_LISTAR_MODELO2");
	}

	public ItfAcaoFormularioEntidade getCrudExemploFrmNovo() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCCarameloFormulario.CRUD_EXEMPLO_FRM_NOVO");
	}

	public ItfAcaoFormularioEntidade getCrudExemploFrmEditar() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCCarameloFormulario.CRUD_EXEMPLO_FRM_EDITAR");
	}

	public ItfAcaoFormularioEntidade getCrudExemploFrmVisualizar() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCCarameloFormulario.CRUD_EXEMPLO_FRM_VISUALIZAR");
	}

	public ComoAcaoControllerEntidade getCrudExemploCtrAtivarDesativar() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCCarameloFormulario.CRUD_EXEMPLO_CTR_ATIVAR_DESATIVAR");
	}

	public ComoAcaoControllerEntidade getCrudExemploCtrSalvarMerge() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCCarameloFormulario.CRUD_EXEMPLO_CTR_SALVAR_MERGE");
	}

	public ComoAcaoControllerEntidade getCrudExemploCtrRemover() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCCarameloFormulario.CRUD_EXEMPLO_CTR_REMOVER");
	}
}