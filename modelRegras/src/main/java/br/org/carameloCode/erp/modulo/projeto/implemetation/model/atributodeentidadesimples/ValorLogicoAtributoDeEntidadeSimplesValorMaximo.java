package br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadesimples;

import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadesimples.ValorLogicoAtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadesimples.ValoresLogicosAtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoAtributoDeEntidadeSimples(calculo = ValoresLogicosAtributoDeEntidadeSimples.VALORMAXIMO)
public class ValorLogicoAtributoDeEntidadeSimplesValorMaximo
        extends
        ValorLogicoCalculoGenerico {

    public ValorLogicoAtributoDeEntidadeSimplesValorMaximo(
            ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    public AtributoDeEntidadeSimples getAtributoDeEntidadeSimples() {
        return (AtributoDeEntidadeSimples) getCampoInst()
                .getObjetoRaizDoAtributo();
    }

    @Override
    public Object getValor(Object... pEntidade) {
        return getAtributoDeEntidadeSimples().getValorMaximo();
    }

    @Override
    public Boolean isVisivel() {
        if (getAtributoDeEntidadeSimples().getTipo() == null) {
            return false;
        }

        switch (getAtributoDeEntidadeSimples().getTipo()) {

            case QUANTIDADE:
            case MOEDA_REAL:
            case MOEDA_DOLAR:
            case PERCENTUAL:
            case TEXTO_SIMPLES:
            case NOME:
            case NOME_COMPLETO:
            case NOME_LONGO:
            case DESCRITIVO:
            case EMAIL:
            case URL:
            case SITE:
            case SENHA:
            case SENHA_SEGURANCA_MAXIMA:
                return true;

            default:
                return false;
        }

    }
}
