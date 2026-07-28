package br.org.coletivoJava.fw.projetos.projeto.implemetation.model.tiponotificacao;

import br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacao.ValorLogicoTipoNotificacaoAcaoRespostaPersonalizada;
import br.org.coletivoJava.fw.projetos.projeto.api.model.tiponotificacao.ValorLogicoTipoNotificacao;
import br.org.coletivoJava.fw.projetos.projeto.api.model.tiponotificacao.ValoresLogicosTipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoTipoNotificacao(calculo = ValoresLogicosTipoNotificacao.ACAORESPOSTAPERSONALIZADA)
public class ValorLogicoExtErpprojeTipoNotificacaoAcaoRespostaPersonalizada
		extends
			ValorLogicoTipoNotificacaoAcaoRespostaPersonalizada {

	public ValorLogicoExtErpprojeTipoNotificacaoAcaoRespostaPersonalizada(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	@Override
	public Object getValor(Object... pEntidade) {
		return super.getValor(pEntidade);
	}
}