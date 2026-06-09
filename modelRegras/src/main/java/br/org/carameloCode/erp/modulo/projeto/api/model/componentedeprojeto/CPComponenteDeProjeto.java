package br.org.carameloCode.erp.modulo.projeto.api.model.componentedeprojeto;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.componenteVisual.ComponenteDeProjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = ComponenteDeProjeto.class)
public enum CPComponenteDeProjeto {
	_ID, _NOMECMPONENTE, _REQUISITO;

	public static final String id = "id";
	public static final String nomecmponente = "nomeCmponente";
	public static final String requisito = "requisito";
}