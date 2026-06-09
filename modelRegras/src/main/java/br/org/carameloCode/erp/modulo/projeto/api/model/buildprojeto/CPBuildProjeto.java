package br.org.carameloCode.erp.modulo.projeto.api.model.buildprojeto;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.implantacao.builds.BuildProjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = BuildProjeto.class)
public enum CPBuildProjeto {
	_ID, _PROJETO, _USUARIO, _REPOSITORIO, _CHAVE;

	public static final String id = "id";
	public static final String projeto = "projeto";
	public static final String usuario = "usuario";
	public static final String repositorio = "repositorio";
	public static final String chave = "chave";
}