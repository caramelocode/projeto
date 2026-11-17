package br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadestatus;

import br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadesimples.ValorLogicoAtributoDeEntidadeSimplesMascaraJqueryMode;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadestatus.ValorLogicoAtributoDeEntidadeStatus;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadestatus.ValoresLogicosAtributoDeEntidadeStatus;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeStatus;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoAtributoDeEntidadeStatus(calculo = ValoresLogicosAtributoDeEntidadeStatus.MASCARAJQUERYMODE)
public class ValorLogicoAtributoDeEntidadeStatusMascaraJqueryMode
		extends
			ValorLogicoAtributoDeEntidadeSimplesMascaraJqueryMode {

	public ValorLogicoAtributoDeEntidadeStatusMascaraJqueryMode(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	public AtributoDeEntidadeStatus getAtributoDeEntidadeStatus() {
		return (AtributoDeEntidadeStatus) getCampoInst()
				.getObjetoRaizDoAtributo();
	}
}