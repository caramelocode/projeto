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
public class AcoesCarameloDev_ProjetoMbGestao implements Serializable {

	public ItfAcaoFormulario getProjetoMbGestao() {
		return (ItfAcaoFormulario) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCProjetoCaramelo.PROJETO_MB_GESTAO");
	}

	public ItfAcaoFormularioEntidade getProjetoFrmListar() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCProjetoCaramelo.PROJETO_FRM_LISTAR");
	}

	public ItfAcaoFormularioEntidade getProjetoFrmNovo() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCProjetoCaramelo.PROJETO_FRM_NOVO");
	}

	public ItfAcaoFormularioEntidade getProjetoFrmEditar() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCProjetoCaramelo.PROJETO_FRM_EDITAR");
	}

	public ComoAcaoControllerEntidade getProjetoCtrSalvarMerge() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCProjetoCaramelo.PROJETO_CTR_SALVAR_MERGE");
	}

	public ComoAcaoControllerEntidade getProjetoCtrPublicar() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCProjetoCaramelo.PROJETO_CTR_PUBLICAR");
	}
}