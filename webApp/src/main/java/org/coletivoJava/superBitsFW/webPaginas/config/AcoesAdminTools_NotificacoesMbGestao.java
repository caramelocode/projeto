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
public class AcoesAdminTools_NotificacoesMbGestao implements Serializable {

	public ItfAcaoFormulario getNotificacoesMbGestao() {
		return (ItfAcaoFormulario) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoNotificacaoWebView.NOTIFICACOES_MB_GESTAO");
	}

	public ItfAcaoFormularioEntidade getNotificacoesFrmDashboard() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoNotificacaoWebView.NOTIFICACOES_FRM_DASHBOARD");
	}

	public ItfAcaoFormularioEntidade getNotificacoesFrmMensagemSistema() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoNotificacaoWebView.NOTIFICACOES_FRM_MENSAGEM_SISTEMA");
	}

	public ItfAcaoFormularioEntidade getNotificacoesFrmMensagemUsuario() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoNotificacaoWebView.NOTIFICACOES_FRM_MENSAGEM_USUARIO");
	}

	public ComoAcaoControllerEntidade getNotificacoesCtrEnviarNotificacao() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoNotificacaoWebView.NOTIFICACOES_CTR_ENVIAR_NOTIFICACAO");
	}

	public ComoAcaoControllerEntidade getNotificacoesCtrResponder() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoNotificacaoWebView.NOTIFICACOES_CTR_RESPONDER");
	}

	public ComoAcaoControllerEntidade getNotificacoesCtrLogarUsuario1() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoNotificacaoWebView.NOTIFICACOES_CTR_LOGAR_USUARIO1");
	}

	public ComoAcaoControllerEntidade getNotificacoesCtrLogarUsuario2() {
		return (ComoAcaoControllerEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoNotificacaoWebView.NOTIFICACOES_CTR_LOGAR_USUARIO2");
	}
}