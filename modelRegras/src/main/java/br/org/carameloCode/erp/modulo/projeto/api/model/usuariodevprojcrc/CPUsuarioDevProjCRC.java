package br.org.carameloCode.erp.modulo.projeto.api.model.usuariodevprojcrc;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.fabricaSoftware.usuario.UsuarioDevProjCRC;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = UsuarioDevProjCRC.class)
public enum CPUsuarioDevProjCRC {
	_FABRICA, _CHAVES, _PROJETOATUAL;

	public static final String fabrica = "fabrica";
	public static final String chaves = "chaves";
	public static final String projetoatual = "projetoAtual";
}