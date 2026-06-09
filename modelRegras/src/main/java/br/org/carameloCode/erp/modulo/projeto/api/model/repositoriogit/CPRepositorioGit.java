package br.org.carameloCode.erp.modulo.projeto.api.model.repositoriogit;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.implantacao.repositorio.RepositorioGit;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = RepositorioGit.class)
public enum CPRepositorioGit {
	_ID, _PROJETO, _DESCRICAO, _BRANCHREPOSITORIO, _ENDERECOREPOSITORIO;

	public static final String id = "id";
	public static final String projeto = "projeto";
	public static final String descricao = "descricao";
	public static final String branchrepositorio = "branchRepositorio";
	public static final String enderecorepositorio = "enderecoRepositorio";
}