package br.org.carameloCode.erp.modulo.projeto.api.model.solicitacaocadastro;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.solicitacaoCandidado.SolicitacaoCadastro;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = SolicitacaoCadastro.class)
public enum CPSolicitacaoCadastro {
	_ID, _NOME, _EMAIL, _TELEFONE, _USUARIOGIT, _USUARIOCONVITE, _USUARIOGERADO;

	public static final String id = "id";
	public static final String nome = "nome";
	public static final String email = "email";
	public static final String telefone = "telefone";
	public static final String usuariogit = "usuarioGit";
	public static final String usuarioconvite = "usuarioConvite";
	public static final String usuariogerado = "usuarioGerado";
}