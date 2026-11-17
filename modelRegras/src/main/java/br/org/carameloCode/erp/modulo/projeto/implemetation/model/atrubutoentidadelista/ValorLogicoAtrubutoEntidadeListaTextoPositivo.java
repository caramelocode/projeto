package br.org.carameloCode.erp.modulo.projeto.implemetation.model.atrubutoentidadelista;

import br.org.carameloCode.erp.modulo.projeto.api.model.atrubutoentidadelista.ValorLogicoAtrubutoEntidadeLista;
import br.org.carameloCode.erp.modulo.projeto.api.model.atrubutoentidadelista.ValoresLogicosAtrubutoEntidadeLista;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeLista;
import br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadesimples.ValorLogicoAtributoDeEntidadeSimplesTextoPositivo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoAtrubutoEntidadeLista(calculo = ValoresLogicosAtrubutoEntidadeLista.TEXTOPOSITIVO)
public class ValorLogicoAtrubutoEntidadeListaTextoPositivo
		extends
			ValorLogicoAtributoDeEntidadeSimplesTextoPositivo {

	public ValorLogicoAtrubutoEntidadeListaTextoPositivo(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	public AtributoEntidadeLista getAtrubutoEntidadeLista() {
		return (AtributoEntidadeLista) getCampoInst().getObjetoRaizDoAtributo();
	}
}