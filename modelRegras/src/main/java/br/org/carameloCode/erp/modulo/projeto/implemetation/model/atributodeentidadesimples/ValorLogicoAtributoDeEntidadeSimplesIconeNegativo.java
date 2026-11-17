package br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadesimples;

import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadesimples.ValorLogicoAtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadesimples.ValoresLogicosAtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.REG_ATIVO_INATIVO;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.VERDADEIRO_FALSO;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoAtributoDeEntidadeSimples(calculo = ValoresLogicosAtributoDeEntidadeSimples.ICONENEGATIVO)
public class ValorLogicoAtributoDeEntidadeSimplesIconeNegativo
        extends
        ValorLogicoCalculoGenerico {

    public ValorLogicoAtributoDeEntidadeSimplesIconeNegativo(
            ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    public AtributoDeEntidadeSimples getAtributoDeEntidadeSimples() {
        return (AtributoDeEntidadeSimples) getCampoInst()
                .getObjetoRaizDoAtributo();
    }

    @Override
    public Object getValor(Object... pEntidade) {
        return getAtributoDeEntidadeSimples().getIconeNegativo();
    }

    @Override
    public Boolean isVisivel() {
        if (getAtributoDeEntidadeSimples().getTipo() == null) {
            return false;
        }

        switch (getAtributoDeEntidadeSimples().getTipo()) {

            case REG_ATIVO_INATIVO:
            case VERDADEIRO_FALSO:
                return true;

            default:
                return false;
        }

    }
}
