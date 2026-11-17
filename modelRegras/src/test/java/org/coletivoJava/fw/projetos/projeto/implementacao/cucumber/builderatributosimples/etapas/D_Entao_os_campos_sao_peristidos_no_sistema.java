package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributosimples.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributosimples.EtapasbuilderAtributoSimples;
import cucumber.api.java.pt.Entao;
import java.util.HashSet;
import java.util.Set;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributosimples.FluxoBuilderAtributoSimples;
import org.junit.Assert;

public class D_Entao_os_campos_sao_peristidos_no_sistema {

    @Entao(EtapasbuilderAtributoSimples.ENTAO_OS_CAMPOS_SAO_PERISTIDOS_NO_SISTEMA)
    public void implementacaoEtapa() {
        FluxoBuilderAtributoSimples.recarregarEntidadeCliente();
        int ordemAnterior = 0;
        for (String nomeAtributo : FluxoBuilderAtributoSimples.NOMES_ATRIBUTO_POR_TIPO.values()) {
            AtributoDeEntidadeSimples atributo = FluxoBuilderAtributoSimples.getAtributoSalvo(nomeAtributo);
            Assert.assertNotNull("Esperado um id no atributo " + nomeAtributo + " persistido no banco", atributo.getId());
            Assert.assertEquals("Classe do atributo " + nomeAtributo + " salvo incorreta",
                    FluxoBuilderAtributoSimples.TIPO_INSTANCIA.getClasse(), atributo.getClass());
            Assert.assertNotNull("O atributo " + nomeAtributo + " foi salvo sem tipo", atributo.getTipo());

            if (!FluxoBuilderAtributoSimples.ATRIBUTOS_DO_FLUXO_ANTERIOR.contains(nomeAtributo)) {
                // Criados na etapa C, um de cada vez, na ordem de NOMES_ATRIBUTO_POR_TIPO: cada um recebe a maior ordem + 1
                Assert.assertTrue("O atributo " + nomeAtributo + " foi salvo sem ordem (ordem começa em 1)", atributo.getOrdem() > 0);
                Assert.assertTrue("O atributo " + nomeAtributo + " (ordem " + atributo.getOrdem()
                        + ") deveria ter ordem maior que a do atributo criado antes dele (" + ordemAnterior + ")",
                        atributo.getOrdem() > ordemAnterior);
                ordemAnterior = atributo.getOrdem();
            }
        }

        // Nenhuma ordem repetida na entidade (0 = ordem ainda não definida, atributos antigos)
        Set<Integer> ordensUsadas = new HashSet<>();
        int ordemNaLista = Integer.MIN_VALUE;
        for (AtributoDeEntidadeSimples atributo : FluxoBuilderAtributoSimples.ENTIDADE_PROJ_CLIENTE.getAtributos()) {
            if (atributo.getOrdem() > 0) {
                Assert.assertTrue("A ordem " + atributo.getOrdem() + " está repetida no atributo " + atributo.getNomeDeclarado(),
                        ordensUsadas.add(atributo.getOrdem()));
            }
            // @OrderBy("ordem ASC, id ASC") em ObjetoProjCRC.atributos
            Assert.assertTrue("A lista de atributos de " + FluxoBuilderAtributoSimples.NOME_ENTIDADE_CLIENTE
                    + " não veio ordenada pela ordem (atributo " + atributo.getNomeDeclarado() + ")",
                    atributo.getOrdem() >= ordemNaLista);
            ordemNaLista = atributo.getOrdem();
        }
    }
}
