package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributosimples.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributosimples.EtapasbuilderAtributoSimples;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributosimples.FluxoBuilderAtributoSimples;
import org.junit.Assert;

public class C_e_executarOpcaoSelecionada_com_a_primeira_opcao_sugerida {

    @E(EtapasbuilderAtributoSimples.E_E_EXECUTAROPCAOSELECIONADA_COM_A_PRIMEIRA_OPCAO_SUGERIDA)
    public void implementacaoEtapa() {
        for (String nomeAtributo : FluxoBuilderAtributoSimples.NOMES_ATRIBUTO_POR_TIPO.values()) {
            FluxoBuilderAtributoSimples.digitarAtributo(nomeAtributo);
            // id e nome: a opção é um formulário de edição, que o console não executa
            FluxoBuilderAtributoSimples.CONSOLE.executarOpcaoSelecionada();
            // executarOpcaoSelecionada é void: o efeito é conferido no repositório, recarregado após o sucesso
            Assert.assertTrue("O atributo " + nomeAtributo + " não aparece no repositório do console depois de executar a opção selecionada",
                    FluxoBuilderAtributoSimples.CONSOLE.getRepositorio()
                            .getEntidadeExistente(FluxoBuilderAtributoSimples.NOME_ENTIDADE_CLIENTE).getAtributos().stream()
                            .anyMatch(at -> nomeAtributo.equals(at.getNomeDeclarado())));
        }
    }
}
