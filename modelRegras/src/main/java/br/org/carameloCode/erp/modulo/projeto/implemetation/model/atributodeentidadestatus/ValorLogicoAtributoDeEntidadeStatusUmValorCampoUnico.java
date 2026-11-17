package br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadestatus;

import br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadesimples.ValorLogicoAtributoDeEntidadeSimplesUmValorCampoUnico;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadestatus.ValorLogicoAtributoDeEntidadeStatus;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadestatus.ValoresLogicosAtributoDeEntidadeStatus;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeStatus;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoAtributoDeEntidadeStatus(calculo = ValoresLogicosAtributoDeEntidadeStatus.UMVALORCAMPOUNICO)
public class ValorLogicoAtributoDeEntidadeStatusUmValorCampoUnico
		extends
			ValorLogicoAtributoDeEntidadeSimplesUmValorCampoUnico {

	public ValorLogicoAtributoDeEntidadeStatusUmValorCampoUnico(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	public AtributoDeEntidadeStatus getAtributoDeEntidadeStatus() {
		return (AtributoDeEntidadeStatus) getCampoInst()
				.getObjetoRaizDoAtributo();
	}
}