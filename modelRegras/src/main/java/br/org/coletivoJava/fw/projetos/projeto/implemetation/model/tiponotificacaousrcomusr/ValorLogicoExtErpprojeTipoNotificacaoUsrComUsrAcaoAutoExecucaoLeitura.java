package br.org.coletivoJava.fw.projetos.projeto.implemetation.model.tiponotificacaousrcomusr;

import br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacaousrcomusr.ValorLogicoTipoNotificacaoUsrComUsrAcaoAutoExecucaoLeitura;
import br.org.coletivoJava.fw.projetos.projeto.api.model.tiponotificacaousrcomusr.ValorLogicoTipoNotificacaoUsrComUsr;
import br.org.coletivoJava.fw.projetos.projeto.api.model.tiponotificacaousrcomusr.ValoresLogicosTipoNotificacaoUsrComUsr;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacaoUsrComUsr;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoTipoNotificacaoUsrComUsr(calculo = ValoresLogicosTipoNotificacaoUsrComUsr.ACAOAUTOEXECUCAOLEITURA)
public class ValorLogicoExtErpprojeTipoNotificacaoUsrComUsrAcaoAutoExecucaoLeitura
		extends
			ValorLogicoTipoNotificacaoUsrComUsrAcaoAutoExecucaoLeitura {

	public ValorLogicoExtErpprojeTipoNotificacaoUsrComUsrAcaoAutoExecucaoLeitura(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	@Override
	public Object getValor(Object... pEntidade) {
		return super.getValor(pEntidade);
	}
}