package br.org.coletivoJava.fw.projetos.projeto.implemetation.model.notificacaosb;

import br.org.carameloCode.erp.modulo.notificacao.implemetation.model.notificacaosb.ValorLogicoNotificacaoSBConteudoHtml;
import br.org.coletivoJava.fw.projetos.projeto.api.model.notificacaosb.ValorLogicoNotificacaoSB;
import br.org.coletivoJava.fw.projetos.projeto.api.model.notificacaosb.ValoresLogicosNotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoNotificacaoSB(calculo = ValoresLogicosNotificacaoSB.CONTEUDOHTML)
public class ValorLogicoExtErpprojeNotificacaoSBConteudoHtml
		extends
			ValorLogicoNotificacaoSBConteudoHtml {

	public ValorLogicoExtErpprojeNotificacaoSBConteudoHtml(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	@Override
	public Object getValor(Object... pEntidade) {
		return super.getValor(pEntidade);
	}
}