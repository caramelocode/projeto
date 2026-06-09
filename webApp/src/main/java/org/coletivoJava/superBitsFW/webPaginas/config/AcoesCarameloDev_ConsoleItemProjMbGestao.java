package org.coletivoJava.superBitsFW.webPaginas.config;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import com.super_bits.modulosSB.SBCore.UtilGeral.MapaAcoesSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.ItfAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.acoes.ComoAcaoControllerEntidade;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.ItfAcaoFormularioEntidade;

@Named
@ApplicationScoped
public class AcoesCarameloDev_ConsoleItemProjMbGestao implements Serializable {

	public ItfAcaoFormulario getConsoleItemProjMbGestao() {
		return (ItfAcaoFormulario) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCConsole.CONSOLE_ITEM_PROJ_MB_GESTAO");
	}

	public ComoAcaoControllerEntidade getConsoleItemProjCtrSalvar() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCConsole.CONSOLE_ITEM_PROJ_CTR_SALVAR");
	}

	public ItfAcaoFormularioEntidade getConsoleItemProjFrmListarAcao() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCConsole.CONSOLE_ITEM_PROJ_FRM_LISTAR_ACAO");
	}

	public ItfAcaoFormularioEntidade getConsoleItemProjFrmCriarAcao() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCConsole.CONSOLE_ITEM_PROJ_FRM_CRIAR_ACAO");
	}

	public ItfAcaoFormularioEntidade getConsoleItemProjFrmEditarAcao() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCConsole.CONSOLE_ITEM_PROJ_FRM_EDITAR_ACAO");
	}

	public ComoAcaoControllerEntidade getConsoleItemProjCtrSalvarAcao() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCConsole.CONSOLE_ITEM_PROJ_CTR_SALVAR_ACAO");
	}

	public ItfAcaoFormularioEntidade getConsoleItemProjFrmListarEntidade() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCConsole.CONSOLE_ITEM_PROJ_FRM_LISTAR_ENTIDADE");
	}

	public ItfAcaoFormularioEntidade getConsoleItemProjFrmNovoEntidade() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCConsole.CONSOLE_ITEM_PROJ_FRM_NOVO_ENTIDADE");
	}

	public ItfAcaoFormularioEntidade getConsoleItemProjFrmEditarEntidade() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCConsole.CONSOLE_ITEM_PROJ_FRM_EDITAR_ENTIDADE");
	}

	public ComoAcaoControllerEntidade getConsoleItemProjCtrSalvarEntidade() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCConsole.CONSOLE_ITEM_PROJ_CTR_SALVAR_ENTIDADE");
	}

	public ItfAcaoFormularioEntidade getConsoleItemProjFrmAtributoEntidadeNovo() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCConsole.CONSOLE_ITEM_PROJ_FRM_ATRIBUTO_ENTIDADE_NOVO");
	}

	public ItfAcaoFormularioEntidade getConsoleItemProjFrmAtributoEntidadeEditar() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCConsole.CONSOLE_ITEM_PROJ_FRM_ATRIBUTO_ENTIDADE_EDITAR");
	}

	public ComoAcaoControllerEntidade getConsoleItemProjCtrSalvarAtributoEntidade() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCConsole.CONSOLE_ITEM_PROJ_CTR_SALVAR_ATRIBUTO_ENTIDADE");
	}
}