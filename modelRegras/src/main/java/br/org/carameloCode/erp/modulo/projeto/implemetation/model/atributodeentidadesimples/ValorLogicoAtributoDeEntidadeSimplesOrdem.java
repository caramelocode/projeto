package br.org.carameloCode.erp.modulo.projeto.implemetation.model.atributodeentidadesimples;

import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadesimples.ValorLogicoAtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadesimples.ValoresLogicosAtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@ValorLogicoAtributoDeEntidadeSimples(calculo = ValoresLogicosAtributoDeEntidadeSimples.ORDEM)
public class ValorLogicoAtributoDeEntidadeSimplesOrdem
        extends
        ValorLogicoCalculoGenerico {

    public ValorLogicoAtributoDeEntidadeSimplesOrdem(ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    /**
     * Ordem do atributo na entidade. Se ainda não foi definida (0), recebe a
     * maior ordem dos outros atributos salvos da mesma entidade + 1, o que
     * evita ordem repetida. A entidade sem atributos salvos começa em 1.
     */
    @Override
    public Object getValor(Object... pEntidade) {
        AtributoDeEntidadeSimples atributo = getAtributoDeEntidadeSimples();
        if (atributo.getOrdem() == 0 && atributo.getEntidade() != null) {
            int maiorOrdem = 0;
            if (atributo.getEntidade().getId() != null) {
                EntityManager em = UtilSBPersistencia.getEntyManagerPadraoNovo();
                try {
                    maiorOrdem = getMaiorOrdemDosOutrosAtributos(em, atributo);
                } finally {
                    UtilSBPersistencia.fecharEM(em);
                }
            }
            atributo.setOrdem(maiorOrdem + 1);
        }

        return atributo.getOrdem();
    }

    /**
     * Maior ordem entre os atributos salvos da entidade, sem contar o próprio
     * atributo (quando ele já está salvo). 0 se não houver nenhum.
     */
    private static int getMaiorOrdemDosOutrosAtributos(EntityManager pEm, AtributoDeEntidadeSimples pAtributo) {
        String jpql = "select max(at.ordem) from AtributoDeEntidadeSimples at where at.entidade.id = :idEntidade";
        if (pAtributo.getId() != null) {
            jpql += " and at.id <> :idAtributo";
        }
        TypedQuery<Integer> consulta = pEm.createQuery(jpql, Integer.class)
                .setParameter("idEntidade", pAtributo.getEntidade().getId());
        if (pAtributo.getId() != null) {
            consulta.setParameter("idAtributo", pAtributo.getId());
        }
        Integer maiorOrdem = consulta.getSingleResult();
        return maiorOrdem == null ? 0 : maiorOrdem;
    }

    public AtributoDeEntidadeSimples getAtributoDeEntidadeSimples() {
        return (AtributoDeEntidadeSimples) getCampoInst()
                .getObjetoRaizDoAtributo();
    }
}
