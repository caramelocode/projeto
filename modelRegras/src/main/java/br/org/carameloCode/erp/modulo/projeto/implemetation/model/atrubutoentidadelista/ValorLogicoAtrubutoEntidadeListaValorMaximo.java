package br.org.carameloCode.erp.modulo.projeto.implemetation.model.atrubutoentidadelista;

import br.org.carameloCode.erp.modulo.projeto.api.model.atrubutoentidadelista.ValorLogicoAtrubutoEntidadeLista;
import br.org.carameloCode.erp.modulo.projeto.api.model.atrubutoentidadelista.ValoresLogicosAtrubutoEntidadeLista;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeLista;
import br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadesimples.ValorLogicoAtributoDeEntidadeSimplesValorMaximo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoAtrubutoEntidadeLista(calculo = ValoresLogicosAtrubutoEntidadeLista.VALORMAXIMO)
public class ValorLogicoAtrubutoEntidadeListaValorMaximo
		extends
			ValorLogicoAtributoDeEntidadeSimplesValorMaximo {

	public ValorLogicoAtrubutoEntidadeListaValorMaximo(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	public AtributoEntidadeLista getAtrubutoEntidadeLista() {
		return (AtributoEntidadeLista) getCampoInst().getObjetoRaizDoAtributo();
	}
}