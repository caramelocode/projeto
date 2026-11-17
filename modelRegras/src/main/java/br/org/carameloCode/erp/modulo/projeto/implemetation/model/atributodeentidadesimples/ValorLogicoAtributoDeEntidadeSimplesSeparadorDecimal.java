package br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadesimples;

import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadesimples.ValorLogicoAtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadesimples.ValoresLogicosAtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoAtributoDeEntidadeSimples(calculo = ValoresLogicosAtributoDeEntidadeSimples.SEPARADORDECIMAL)
public class ValorLogicoAtributoDeEntidadeSimplesSeparadorDecimal
        extends
        ValorLogicoCalculoGenerico {

    public ValorLogicoAtributoDeEntidadeSimplesSeparadorDecimal(
            ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    public AtributoDeEntidadeSimples getAtributoDeEntidadeSimples() {
        return (AtributoDeEntidadeSimples) getCampoInst()
                .getObjetoRaizDoAtributo();
    }

    @Override
    public Object getValor(Object... pEntidade) {
        return getAtributoDeEntidadeSimples().getSeparadorDecimal();
    }

    @Override
    public Boolean isVisivel() {
        if (getAtributoDeEntidadeSimples().getTipo() == null) {
            return false;
        }

        switch (getAtributoDeEntidadeSimples().getTipo()) {

            case MOEDA_REAL:
            case MOEDA_DOLAR:
            case PERCENTUAL:
                return true;

            default:
                return false;
        }

    }
}
