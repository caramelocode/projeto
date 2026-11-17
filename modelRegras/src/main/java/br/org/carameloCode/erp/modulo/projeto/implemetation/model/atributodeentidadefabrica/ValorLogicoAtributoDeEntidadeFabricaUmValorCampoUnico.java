package br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadefabrica;

import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadefabrica.ValorLogicoAtributoDeEntidadeFabrica;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadefabrica.ValoresLogicosAtributoDeEntidadeFabrica;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeFabrica;
import br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadesimples.ValorLogicoAtributoDeEntidadeSimplesUmValorCampoUnico;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoAtributoDeEntidadeFabrica(calculo = ValoresLogicosAtributoDeEntidadeFabrica.UMVALORCAMPOUNICO)
public class ValorLogicoAtributoDeEntidadeFabricaUmValorCampoUnico
		extends
			ValorLogicoAtributoDeEntidadeSimplesUmValorCampoUnico {

	public ValorLogicoAtributoDeEntidadeFabricaUmValorCampoUnico(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	public AtributoDeEntidadeFabrica getAtributoDeEntidadeFabrica() {
		return (AtributoDeEntidadeFabrica) getCampoInst()
				.getObjetoRaizDoAtributo();
	}
}