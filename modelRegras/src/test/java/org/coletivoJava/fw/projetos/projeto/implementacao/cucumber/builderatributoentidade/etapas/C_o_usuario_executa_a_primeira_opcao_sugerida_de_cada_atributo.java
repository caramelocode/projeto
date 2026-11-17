package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoentidade.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributoentidade.EtapasbuilderAtributoEntidade;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoentidade.FluxoBuilderAtributoEntidade;
import org.junit.Assert;

public class C_o_usuario_executa_a_primeira_opcao_sugerida_de_cada_atributo {

    @E(EtapasbuilderAtributoEntidade.E_O_USUARIO_EXECUTA_A_PRIMEIRA_OPCAO_SUGERIDA_DE_CADA_ATRIBUTO)
    public void implementacaoEtapa() {
        for (String nomeAtributo : FluxoBuilderAtributoEntidade.getNomesAtributos()) {
            FluxoBuilderAtributoEntidade.digitarAtributo(nomeAtributo);
            FluxoBuilderAtributoEntidade.CONSOLE.executarOpcaoSelecionada();
            // executarOpcaoSelecionada é void: o efeito é conferido no repositório, recarregado após o sucesso
            Assert.assertTrue("O atributo " + nomeAtributo + " não aparece no repositório do console depois de executar a opção selecionada",
                    FluxoBuilderAtributoEntidade.CONSOLE.getRepositorio()
                            .getEntidadeExistente(FluxoBuilderAtributoEntidade.NOME_ENTIDADE_CLIENTE).getAtributos().stream()
                            .anyMatch(at -> nomeAtributo.equals(at.getNomeDeclarado())));
        }
    }
}
