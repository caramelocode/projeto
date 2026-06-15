package br.org.coletivoJava.fw.projetos.projeto.implemetation.model.tiponotificacao;

import br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacao.ValorLogicoTipoNotificacaoAcaoAutoExecucaoEntrega;
import br.org.coletivoJava.fw.projetos.projeto.api.model.tiponotificacao.ValorLogicoTipoNotificacao;
import br.org.coletivoJava.fw.projetos.projeto.api.model.tiponotificacao.ValoresLogicosTipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoTipoNotificacao(calculo = ValoresLogicosTipoNotificacao.ACAOAUTOEXECUCAOENTREGA)
public class ValorLogicoExtErpprojeTipoNotificacaoAcaoAutoExecucaoEntrega
		extends
			ValorLogicoTipoNotificacaoAcaoAutoExecucaoEntrega {

	public ValorLogicoExtErpprojeTipoNotificacaoAcaoAutoExecucaoEntrega(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	@Override
	public Object getValor(Object... pEntidade) {
		return super.getValor(pEntidade);
	}
}