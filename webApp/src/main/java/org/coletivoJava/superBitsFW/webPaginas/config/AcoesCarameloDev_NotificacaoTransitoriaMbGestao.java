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
public class AcoesCarameloDev_NotificacaoTransitoriaMbGestao
		implements
			Serializable {

	public ItfAcaoFormulario getNotificacaoTransitoriaMbGestao() {
		return (ItfAcaoFormulario) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCComponenteNativo.NOTIFICACAO_TRANSITORIA_MB_GESTAO");
	}

	public ItfAcaoFormularioEntidade getNotificacaoTransitoriaFrmEnviarMenuSistemaUsr() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCComponenteNativo.NOTIFICACAO_TRANSITORIA_FRM_ENVIAR_MENU_SISTEMA_USR");
	}

	public ItfAcaoFormularioEntidade getNotificacaoTransitoriaFrmEnviarMenuUsrToUsr() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCComponenteNativo.NOTIFICACAO_TRANSITORIA_FRM_ENVIAR_MENU_USR_TO_USR");
	}

	public ComoAcaoControllerEntidade getNotificacaoTransitoriaCtrEnviar() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCComponenteNativo.NOTIFICACAO_TRANSITORIA_CTR_ENVIAR");
	}
}