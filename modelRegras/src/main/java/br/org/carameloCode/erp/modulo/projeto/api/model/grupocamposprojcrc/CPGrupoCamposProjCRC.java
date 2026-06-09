package br.org.carameloCode.erp.modulo.projeto.api.model.grupocamposprojcrc;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.GrupoCamposProjCRC;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = GrupoCamposProjCRC.class)
public enum CPGrupoCamposProjCRC {
	_ID, _NOME, _FORMULARIO, _CAMPOS;

	public static final String id = "id";
	public static final String nome = "nome";
	public static final String formulario = "formulario";
	public static final String campos = "campos";
}