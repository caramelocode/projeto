package br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadefabricastatus;

import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadefabricastatus.ValorLogicoAtributoDeEntidadeFabricaStatus;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadefabricastatus.ValoresLogicosAtributoDeEntidadeFabricaStatus;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeFabricaStatus;
import br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadesimples.ValorLogicoAtributoDeEntidadeSimplesTextoNegativo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoAtributoDeEntidadeFabricaStatus(calculo = ValoresLogicosAtributoDeEntidadeFabricaStatus.TEXTONEGATIVO)
public class ValorLogicoAtributoDeEntidadeFabricaStatusTextoNegativo
		extends
			ValorLogicoAtributoDeEntidadeSimplesTextoNegativo {

	public ValorLogicoAtributoDeEntidadeFabricaStatusTextoNegativo(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	public AtributoDeEntidadeFabricaStatus getAtributoDeEntidadeFabricaStatus() {
		return (AtributoDeEntidadeFabricaStatus) getCampoInst()
				.getObjetoRaizDoAtributo();
	}
}