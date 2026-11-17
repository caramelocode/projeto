package br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadesimples;

import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadesimples.ValorLogicoAtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadesimples.ValoresLogicosAtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoAtributoDeEntidadeSimples(calculo = ValoresLogicosAtributoDeEntidadeSimples.VALIDACAOREGEX)
public class ValorLogicoAtributoDeEntidadeSimplesValidacaoRegex
        extends
        ValorLogicoCalculoGenerico {

    public ValorLogicoAtributoDeEntidadeSimplesValidacaoRegex(
            ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    public AtributoDeEntidadeSimples getAtributoDeEntidadeSimples() {
        return (AtributoDeEntidadeSimples) getCampoInst()
                .getObjetoRaizDoAtributo();
    }

    @Override
    public Object getValor(Object... pEntidade) {
        return getAtributoDeEntidadeSimples().getValidacaoRegex();
    }

    @Override
    public Boolean isVisivel() {
        if (getAtributoDeEntidadeSimples().getTipo() == null) {
            return false;
        }

        switch (getAtributoDeEntidadeSimples().getTipo()) {

            case TEXTO_SIMPLES:
            case NOME:
            case NOME_COMPLETO:
            case NOME_LONGO:
            case EMAIL:
            case URL:
            case SITE:
            case SENHA:
            case SENHA_SEGURANCA_MAXIMA:
            case CPF:
            case CNPJ:
            case INSCRICAO_ESTADUAL:
            case INSCRIACAO_MUNICIPAL:
            case CODIGO_DE_BARRAS:
            case LCCEP:
            case TELEFONE_GENERICO:
            case TELEFONE_CELULAR:
            case TELEFONE_FIXO_NACIONAL:
            case TELEFONE_FIXO_INTERNACIONAL:
                return true;

            default:
                return false;
        }

    }
}
