package br.org.carameloCode.erp.modulo.projeto.api.model.moduloprojcrc;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.modulo.ModuloProjCRC;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = ModuloProjCRC.class)
public enum CPModuloProjCRC {
	_ID, _NOME, _DESCRICAO, _UMMODULONATIVO, _PROJETO, _ACOES, _ENTIDADES, _ENUMVINCULADO;

	public static final String id = "id";
	public static final String nome = "nome";
	public static final String descricao = "descricao";
	public static final String ummodulonativo = "umModuloNativo";
	public static final String projeto = "projeto";
	public static final String acoes = "acoes";
	public static final String entidades = "entidades";
	public static final String enumvinculado = "enumVinculado";
}