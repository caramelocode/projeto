package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributosimples.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributosimples.EtapasbuilderAtributoSimples;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributosimples.FluxoBuilderAtributoSimples;

public class F_a_visibilidade_das_propriedades_do_atributos_estao_de_acordo {

    @E(EtapasbuilderAtributoSimples.E_A_VISIBILIDADE_DAS_PROPRIEDADES_DO_ATRIBUTOS_ESTAO_DE_ACORDO)
    public void implementacaoEtapa() {
        // Confere cada atributo salvo com o tipo com que ele foi persistido
        FluxoBuilderAtributoSimples.recarregarEntidadeCliente();
        for (String nomeAtributo : FluxoBuilderAtributoSimples.NOMES_ATRIBUTO_POR_TIPO.values()) {
            FluxoBuilderAtributoSimples.verificarVisibilidadeCampos(FluxoBuilderAtributoSimples.getAtributoSalvo(nomeAtributo));
        }
    }
}
