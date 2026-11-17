package br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributoentidadeentidade;

import br.org.carameloCode.erp.modulo.projeto.api.model.atributoentidadeentidade.ValorLogicoAtributoEntidadeEntidade;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributoentidadeentidade.ValoresLogicosAtributoEntidadeEntidade;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeEntidade;
import br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadesimples.ValorLogicoAtributoDeEntidadeSimplesTextoPositivo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoAtributoEntidadeEntidade(calculo = ValoresLogicosAtributoEntidadeEntidade.TEXTOPOSITIVO)
public class ValorLogicoAtributoEntidadeEntidadeTextoPositivo
		extends
			ValorLogicoAtributoDeEntidadeSimplesTextoPositivo {

	public ValorLogicoAtributoEntidadeEntidadeTextoPositivo(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	public AtributoEntidadeEntidade getAtributoEntidadeEntidade() {
		return (AtributoEntidadeEntidade) getCampoInst()
				.getObjetoRaizDoAtributo();
	}
}