package br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadesimples;

import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadesimples.ValorLogicoAtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadesimples.ValoresLogicosAtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoAtributoDeEntidadeSimples(calculo = ValoresLogicosAtributoDeEntidadeSimples.UMALISTAGEMDINAMICA)
public class ValorLogicoAtributoDeEntidadeSimplesUmalistagemDinamica
        extends
        ValorLogicoCalculoGenerico {

    public ValorLogicoAtributoDeEntidadeSimplesUmalistagemDinamica(
            ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    public AtributoDeEntidadeSimples getAtributoDeEntidadeSimples() {
        return (AtributoDeEntidadeSimples) getCampoInst()
                .getObjetoRaizDoAtributo();
    }

    @Override
    public Object getValor(Object... pEntidade) {
        return getAtributoDeEntidadeSimples().isUmalistagemDinamica();
    }

    @Override
    public Boolean isVisivel() {
        if (getAtributoDeEntidadeSimples().getTipo() == null) {
            return false;
        }

        switch (getAtributoDeEntidadeSimples().getTipo()) {

            case OBJETO_DE_UMA_LISTA:
            case LISTA_OBJETOS_PUBLICOS:
            case LISTA_OBJETOS_PARTICULARES:
            case ENUM_FABRICA:
            case STATUS_ENUM:
                return true;

            default:
                return false;
        }

    }
}
