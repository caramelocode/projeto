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
public class AcoesCarameloDev_AcoesMbGestao implements Serializable {

	public ItfAcaoFormulario getAcoesMbGestao() {
		return (ItfAcaoFormulario) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCAcoes.ACOES_MB_GESTAO");
	}

	public ItfAcaoFormularioEntidade getAcoesFrmVisaoGeral() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCAcoes.ACOES_FRM_VISAO_GERAL");
	}

	public ItfAcaoFormularioEntidade getAcoesFrmListarGestao() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCAcoes.ACOES_FRM_LISTAR_GESTAO");
	}

	public ItfAcaoFormularioEntidade getAcoesFrmListarSubacao() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCAcoes.ACOES_FRM_LISTAR_SUBACAO");
	}

	public ItfAcaoFormularioEntidade getAcoesFrmEditarAcaoFormulario() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCAcoes.ACOES_FRM_EDITAR_ACAO_FORMULARIO");
	}

	public ItfAcaoFormularioEntidade getAcoesFrmEditarAcaoController() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCAcoes.ACOES_FRM_EDITAR_ACAO_CONTROLLER");
	}

	public ComoAcaoControllerEntidade getAcoesCtrSalvar() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCAcoes.ACOES_CTR_SALVAR");
	}
}