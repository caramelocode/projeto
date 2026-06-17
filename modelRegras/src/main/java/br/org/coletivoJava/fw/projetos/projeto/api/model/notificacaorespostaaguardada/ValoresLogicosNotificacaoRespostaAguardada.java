package br.org.coletivoJava.fw.projetos.projeto.api.model.notificacaorespostaaguardada;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoRespostaAguardada;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = NotificacaoRespostaAguardada.class)
public enum ValoresLogicosNotificacaoRespostaAguardada {
	ASSUNTO, CONTEUDOHTML
}