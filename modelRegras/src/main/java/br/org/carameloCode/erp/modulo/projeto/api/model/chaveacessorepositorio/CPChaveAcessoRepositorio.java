package br.org.carameloCode.erp.modulo.projeto.api.model.chaveacessorepositorio;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.fabricaSoftware.usuario.ChaveAcessoRepositorio;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = ChaveAcessoRepositorio.class)
public enum CPChaveAcessoRepositorio {
	_ID, _CHAVEUSR, _SENHAUSR, _USUARIO;

	public static final String id = "id";
	public static final String chaveusr = "chaveUsr";
	public static final String senhausr = "senhaUsr";
	public static final String usuario = "usuario";
}