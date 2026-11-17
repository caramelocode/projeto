package br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadefabrica;

import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadefabrica.ValorLogicoAtributoDeEntidadeFabrica;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadefabrica.ValoresLogicosAtributoDeEntidadeFabrica;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeFabrica;
import br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadesimples.ValorLogicoAtributoDeEntidadeSimplesSomenteLeitura;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoAtributoDeEntidadeFabrica(calculo = ValoresLogicosAtributoDeEntidadeFabrica.SOMENTELEITURA)
public class ValorLogicoAtributoDeEntidadeFabricaSomenteLeitura
		extends
			ValorLogicoAtributoDeEntidadeSimplesSomenteLeitura {

	public ValorLogicoAtributoDeEntidadeFabricaSomenteLeitura(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	public AtributoDeEntidadeFabrica getAtributoDeEntidadeFabrica() {
		return (AtributoDeEntidadeFabrica) getCampoInst()
				.getObjetoRaizDoAtributo();
	}
}