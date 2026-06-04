package br.org.carameloCode.erp.modulo.projeto.api.model.exemploopcaocomimagem;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.itensExemplo.ExemploOpcaocomImagem;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = ExemploOpcaocomImagem.class)
public enum CPExemploOpcaocomImagem {
	_IMGPEQUENA, _IMGMEDIA, _IMGGRANDE;

	public static final String imgpequena = "imgPequena";
	public static final String imgmedia = "imgMedia";
	public static final String imggrande = "imgGrande";
}