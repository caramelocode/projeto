package br.org.carameloCode.erp.modulo.projeto.api.model.comunicacaotransientdev;

import br.org.carameloCode.erp.modulo.projeto.entidadeTransient.ComunicacaoTransientDev;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = ComunicacaoTransientDev.class)
public enum CPComunicacaoTransientDev {
	_ID, _ASSUNTO, _MENSAGEM, _USUARIODESTINATARIO;

	public static final String id = "id";
	public static final String assunto = "assunto";
	public static final String mensagem = "mensagem";
	public static final String usuariodestinatario = "usuarioDestinatario";
}