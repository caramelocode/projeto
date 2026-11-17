package br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadestatus;

import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadestatus.ValorLogicoAtributoDeEntidadeStatus;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadestatus.ValoresLogicosAtributoDeEntidadeStatus;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeStatus;
import br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadesimples.ValorLogicoAtributoDeEntidadeSimplesOrdem;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoAtributoDeEntidadeStatus(calculo = ValoresLogicosAtributoDeEntidadeStatus.ORDEM)
public class ValorLogicoAtributoDeEntidadeStatusOrdem
        extends
        ValorLogicoAtributoDeEntidadeSimplesOrdem {

    public ValorLogicoAtributoDeEntidadeStatusOrdem(ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    public AtributoDeEntidadeStatus getAtributoDeEntidadeStatus() {
        return (AtributoDeEntidadeStatus) getCampoInst()
                .getObjetoRaizDoAtributo();
    }
}
