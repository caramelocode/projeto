package br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadefabricastatus;

import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadefabricastatus.ValorLogicoAtributoDeEntidadeFabricaStatus;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadefabricastatus.ValoresLogicosAtributoDeEntidadeFabricaStatus;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeFabricaStatus;
import br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadesimples.ValorLogicoAtributoDeEntidadeSimplesTextoPositivo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoAtributoDeEntidadeFabricaStatus(calculo = ValoresLogicosAtributoDeEntidadeFabricaStatus.TEXTOPOSITIVO)
public class ValorLogicoAtributoDeEntidadeFabricaStatusTextoPositivo
		extends
			ValorLogicoAtributoDeEntidadeSimplesTextoPositivo {

	public ValorLogicoAtributoDeEntidadeFabricaStatusTextoPositivo(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	public AtributoDeEntidadeFabricaStatus getAtributoDeEntidadeFabricaStatus() {
		return (AtributoDeEntidadeFabricaStatus) getCampoInst()
				.getObjetoRaizDoAtributo();
	}
}