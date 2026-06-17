package br.org.coletivoJava.fw.projetos.projeto.implemetation.model.notificacaorespostaaguardada;

import br.org.carameloCode.erp.modulo.notificacao.implemetation.model.notificacaorespostaaguardada.ValorLogicoNotificacaoRespostaAguardadaConteudoHtml;
import br.org.coletivoJava.fw.projetos.projeto.api.model.notificacaorespostaaguardada.ValorLogicoNotificacaoRespostaAguardada;
import br.org.coletivoJava.fw.projetos.projeto.api.model.notificacaorespostaaguardada.ValoresLogicosNotificacaoRespostaAguardada;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoRespostaAguardada;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoNotificacaoRespostaAguardada(calculo = ValoresLogicosNotificacaoRespostaAguardada.CONTEUDOHTML)
public class ValorLogicoExtErpprojeNotificacaoRespostaAguardadaConteudoHtml
		extends
			ValorLogicoNotificacaoRespostaAguardadaConteudoHtml {

	public ValorLogicoExtErpprojeNotificacaoRespostaAguardadaConteudoHtml(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	@Override
	public Object getValor(Object... pEntidade) {
		return super.getValor(pEntidade);
	}
}