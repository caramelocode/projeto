package br.org.carameloCode.erp.modulo.projeto.api.model.projetocrc;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = ProjetoCRC.class)
public enum CPProjetoCRC {
	_ID, _NOME, _REPOSITORIOGIT, _ORGANIZACAO, _OBJETOS, _REQUISITOS, _MODULOS, _MODULOSIMPORTADOS, _REPOSITORIOSCODIGO, _IMPLANTACOES, _BUILDS, _SERVIDORPADRAOPRODUCAO, _SERVIDORPADRAOHOMOLOGACAO, _VALORESTIMADO, _VALORGASTO;

	public static final String id = "id";
	public static final String nome = "nome";
	public static final String repositoriogit = "repositorioGit";
	public static final String organizacao = "organizacao";
	public static final String objetos = "objetos";
	public static final String requisitos = "requisitos";
	public static final String modulos = "modulos";
	public static final String modulosimportados = "modulosImportados";
	public static final String repositorioscodigo = "repositoriosCodigo";
	public static final String implantacoes = "implantacoes";
	public static final String builds = "builds";
	public static final String servidorpadraoproducao = "servidorPadraoProducao";
	public static final String servidorpadraohomologacao = "servidorPadraoHomologacao";
	public static final String valorestimado = "valorEstimado";
	public static final String valorgasto = "valorGasto";
}