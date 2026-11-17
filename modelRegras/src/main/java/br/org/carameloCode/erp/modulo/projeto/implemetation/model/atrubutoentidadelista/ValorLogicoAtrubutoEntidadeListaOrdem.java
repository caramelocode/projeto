package br.org.carameloCode.erp.modulo.projeto.implemetation.model.atrubutoentidadelista;

import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import br.org.carameloCode.erp.modulo.projeto.api.model.atrubutoentidadelista.ValorLogicoAtrubutoEntidadeLista;
import br.org.carameloCode.erp.modulo.projeto.api.model.atrubutoentidadelista.ValoresLogicosAtrubutoEntidadeLista;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeLista;
import br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadesimples.ValorLogicoAtributoDeEntidadeSimplesOrdem;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoAtrubutoEntidadeLista(calculo = ValoresLogicosAtrubutoEntidadeLista.ORDEM)
public class ValorLogicoAtrubutoEntidadeListaOrdem
        extends
        ValorLogicoAtributoDeEntidadeSimplesOrdem {

    public ValorLogicoAtrubutoEntidadeListaOrdem(ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    public AtributoEntidadeLista getAtrubutoEntidadeLista() {
        return (AtributoEntidadeLista) getCampoInst().getObjetoRaizDoAtributo();
    }
}
