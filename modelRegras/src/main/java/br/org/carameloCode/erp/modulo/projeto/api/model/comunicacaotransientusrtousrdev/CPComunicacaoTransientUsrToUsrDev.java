package br.org.carameloCode.erp.modulo.projeto.api.model.comunicacaotransientusrtousrdev;

import br.org.carameloCode.erp.modulo.projeto.entidadeTransient.ComunicacaoTransientUsrToUsrDev;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = ComunicacaoTransientUsrToUsrDev.class)
public enum CPComunicacaoTransientUsrToUsrDev {
	_REMETENTE, _OBSERVACAO;

	public static final String remetente = "remetente";
	public static final String observacao = "observacao";
}