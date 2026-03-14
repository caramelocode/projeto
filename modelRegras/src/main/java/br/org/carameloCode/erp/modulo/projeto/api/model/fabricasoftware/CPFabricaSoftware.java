package br.org.carameloCode.erp.modulo.projeto.api.model.fabricasoftware;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.fabrica_software.FabricaSoftware;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = FabricaSoftware.class)
public enum CPFabricaSoftware {
	_ID, _NOME, _DOCUMENTO, _PLANO, _USUARIORESPONSAVEL, _EQUIPE, _REPOSITORIOPADRAO;

	public static final String id = "id";
	public static final String nome = "nome";
	public static final String documento = "documento";
	public static final String plano = "plano";
	public static final String usuarioresponsavel = "usuarioREsponsavel";
	public static final String equipe = "equipe";
	public static final String repositoriopadrao = "repositorioPadrao";
}