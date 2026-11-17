package br.org.carameloCode.erp.modulo.projeto.api.model.fabricaentidadeprojcrc;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaEntidadeProjCRC;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = FabricaEntidadeProjCRC.class)
public enum CPFabricaEntidadeProjCRC {
	_ID, _NOMEFABRICA, _DESCRICAO, _TIPOITEMPROJETO, _TIPOOBJETOPADRAO, _MODULO, _PROJETO, _ITENS, _TIPOFABRICADB, _DATAHORAALTERACAO, _DATAHORAINSERSAO, _USUARIOINSERCAO, _USUARIOALTERACAO;

	public static final String id = "id";
	public static final String nomefabrica = "nomeFabrica";
	public static final String descricao = "descricao";
	public static final String tipoitemprojeto = "tipoItemProjeto";
	public static final String tipoobjetopadrao = "tipoObjetoPadrao";
	public static final String modulo = "modulo";
	public static final String projeto = "projeto";
	public static final String itens = "itens";
	public static final String tipofabricadb = "tipoFabricaDB";
	public static final String datahoraalteracao = "dataHoraAlteracao";
	public static final String datahorainsersao = "dataHoraInsersao";
	public static final String usuarioinsercao = "usuarioInsercao";
	public static final String usuarioalteracao = "usuarioAlteracao";
}