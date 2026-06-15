package br.org.coletivoJava.fw.projetos.projeto.implemetation.model.tiponotificacao;

import br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacao.ValidacaoTipoNotificacaoNotificarViaWhatsapp;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import br.org.coletivoJava.fw.projetos.projeto.api.model.tiponotificacao.ValidadorTipoNotificacao;
import br.org.coletivoJava.fw.projetos.projeto.api.model.tiponotificacao.ValidadoresTipoNotificacao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import java.util.ArrayList;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;
import java.util.List;
import com.super_bits.modulosSB.SBCore.modulos.objetos.validador.ErroValidacao;

@ValidadorTipoNotificacao(validador = ValidadoresTipoNotificacao.NOTIFICARVIAWHATSAPP)
public class ValidacaoExtErpprojeTipoNotificacaoNotificarViaWhatsapp
		extends
			ValidacaoTipoNotificacaoNotificarViaWhatsapp {

	public ValidacaoExtErpprojeTipoNotificacaoNotificarViaWhatsapp(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	@Override
	public List validar(java.lang.Object o) throws ErroValidacao {
		return super.validar(o);
	}

	public TipoNotificacao getTipoNotificacao() {
		return getObjetoDoAtributo();
	}
}