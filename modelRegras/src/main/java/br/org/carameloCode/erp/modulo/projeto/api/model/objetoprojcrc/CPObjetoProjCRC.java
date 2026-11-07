package br.org.carameloCode.erp.modulo.projeto.api.model.objetoprojcrc;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = ObjetoProjCRC.class)
public enum CPObjetoProjCRC {
	_ID, _NOME, _TIPOITEMPROJETO, _NOMEENTIDADE, _DESCRICAO, _ICONE, _PLURAL, _TAGS, _MODULO, _PROJETO, _ATRIBUTOS, _DATAHORAALTERACAO, _DATAHORAINSERSAO, _USUARIOINSERCAO, _USUARIOALTERACAO, _REQUISITO;

	public static final String id = "id";
	public static final String nome = "nome";
	public static final String tipoitemprojeto = "tipoItemProjeto";
	public static final String nomeentidade = "nomeEntidade";
	public static final String descricao = "descricao";
	public static final String icone = "icone";
	public static final String plural = "plural";
	public static final String tags = "tags";
	public static final String modulo = "modulo";
	public static final String projeto = "projeto";
	public static final String atributos = "atributos";
	public static final String datahoraalteracao = "dataHoraAlteracao";
	public static final String datahorainsersao = "dataHoraInsersao";
	public static final String usuarioinsercao = "usuarioInsercao";
	public static final String usuarioalteracao = "usuarioAlteracao";
	public static final String requisito = "requisito";
}