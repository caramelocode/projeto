package br.org.carameloCode.erp.modulo.projeto.api.model.atrubutoentidadelista;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeLista;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = AtributoEntidadeLista.class)
public enum CPAtrubutoEntidadeLista {
	_ENTIDADEITEMLISTA, _CAMINHOLISTA;

	public static final String entidadeitemlista = "entidadeItemLista";
	public static final String caminholista = "caminhoLista";
}