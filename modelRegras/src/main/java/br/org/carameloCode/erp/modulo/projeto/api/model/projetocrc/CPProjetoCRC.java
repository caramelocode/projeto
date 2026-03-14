package br.org.carameloCode.erp.modulo.projeto.api.model.projetocrc;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projeto.ProjetoCRC;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = ProjetoCRC.class)
public enum CPProjetoCRC {
	_ID, _NOME, _REPOSITORIOGIT, _ORGANIZACAO, _OBJETOS, _MODULOS, _MODULOSIMPORTADOS, _TIPOIMPLANTACAO;

	public static final String id = "id";
	public static final String nome = "nome";
	public static final String repositoriogit = "repositorioGit";
	public static final String organizacao = "organizacao";
	public static final String objetos = "objetos";
	public static final String modulos = "modulos";
	public static final String modulosimportados = "modulosImportados";
	public static final String tipoimplantacao = "tipoImplantacao";
}