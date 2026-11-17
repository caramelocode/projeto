package br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributoentidadeentidade;

import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributoentidadeentidade.ValorLogicoAtributoEntidadeEntidade;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributoentidadeentidade.ValoresLogicosAtributoEntidadeEntidade;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeEntidade;
import br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadesimples.ValorLogicoAtributoDeEntidadeSimplesOrdem;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoAtributoEntidadeEntidade(calculo = ValoresLogicosAtributoEntidadeEntidade.ORDEM)
public class ValorLogicoAtributoEntidadeEntidadeOrdem
        extends
        ValorLogicoAtributoDeEntidadeSimplesOrdem {

    public ValorLogicoAtributoEntidadeEntidadeOrdem(ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    public AtributoEntidadeEntidade getAtributoEntidadeEntidade() {
        return (AtributoEntidadeEntidade) getCampoInst()
                .getObjetoRaizDoAtributo();
    }
}
