package br.org.carameloCode.erp.modulo.projeto.api.model.servicohospedagem;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.servidor.ServicoHospedagem;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = ServicoHospedagem.class)
public enum CPServicoHospedagem {
	_ID, _NOME, _HOSTIMPLANTACAO, _VARIAVEISDEAMBIENTE, _CHAVEACESSO;

	public static final String id = "id";
	public static final String nome = "nome";
	public static final String hostimplantacao = "hostImplantacao";
	public static final String variaveisdeambiente = "variaveisDeAmbiente";
	public static final String chaveacesso = "chaveAcesso";
}