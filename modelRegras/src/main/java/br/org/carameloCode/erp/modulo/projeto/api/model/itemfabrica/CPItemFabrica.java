package br.org.carameloCode.erp.modulo.projeto.api.model.itemfabrica;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.ItemFabrica;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = ItemFabrica.class)
public enum CPItemFabrica {
	_ID, _FABRICA, _NOMEENUM, _IDOBJETO, _NOMEOBJETO, _TIPOOBJETO, _PACOTEIMPLANTACAO, _ICONE, _COR, _TIPOITEMFABRICADB, _DATAHORAALTERACAO, _DATAHORAINSERSAO, _USUARIOINSERCAO, _USUARIOALTERACAO;

	public static final String id = "id";
	public static final String fabrica = "fabrica";
	public static final String nomeenum = "nomeEnum";
	public static final String idobjeto = "idObjeto";
	public static final String nomeobjeto = "nomeObjeto";
	public static final String tipoobjeto = "tipoObjeto";
	public static final String pacoteimplantacao = "pacoteImplantacao";
	public static final String icone = "icone";
	public static final String cor = "cor";
	public static final String tipoitemfabricadb = "tipoItemFabricaDB";
	public static final String datahoraalteracao = "dataHoraAlteracao";
	public static final String datahorainsersao = "dataHoraInsersao";
	public static final String usuarioinsercao = "usuarioInsercao";
	public static final String usuarioalteracao = "usuarioAlteracao";
}