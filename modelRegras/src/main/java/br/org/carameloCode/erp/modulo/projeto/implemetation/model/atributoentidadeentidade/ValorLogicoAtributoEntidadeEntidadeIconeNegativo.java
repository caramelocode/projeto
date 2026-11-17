package br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributoentidadeentidade;

import br.org.carameloCode.erp.modulo.projeto.api.model.atributoentidadeentidade.ValorLogicoAtributoEntidadeEntidade;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributoentidadeentidade.ValoresLogicosAtributoEntidadeEntidade;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeEntidade;
import br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadesimples.ValorLogicoAtributoDeEntidadeSimplesIconeNegativo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoAtributoEntidadeEntidade(calculo = ValoresLogicosAtributoEntidadeEntidade.ICONENEGATIVO)
public class ValorLogicoAtributoEntidadeEntidadeIconeNegativo
		extends
			ValorLogicoAtributoDeEntidadeSimplesIconeNegativo {

	public ValorLogicoAtributoEntidadeEntidadeIconeNegativo(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	public AtributoEntidadeEntidade getAtributoEntidadeEntidade() {
		return (AtributoEntidadeEntidade) getCampoInst()
				.getObjetoRaizDoAtributo();
	}
}