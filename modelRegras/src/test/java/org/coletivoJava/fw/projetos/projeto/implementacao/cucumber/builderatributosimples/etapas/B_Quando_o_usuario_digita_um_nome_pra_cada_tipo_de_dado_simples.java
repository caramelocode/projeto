package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributosimples.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributosimples.EtapasbuilderAtributoSimples;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributosimples.FluxoBuilderAtributoSimples;

public class B_Quando_o_usuario_digita_um_nome_pra_cada_tipo_de_dado_simples {

    @Quando(EtapasbuilderAtributoSimples.QUANDO_O_USUARIO_DIGITA_UM_NOME_PRA_CADA_TIPO_DE_DADO_SIMPLES)
    public void implementacaoEtapa() {
        // digitarAtributo confere a opção oferecida: criar (nomes novos) ou editar (id e nome, do fluxo anterior)
        for (String nomeAtributo : FluxoBuilderAtributoSimples.NOMES_ATRIBUTO_POR_TIPO.values()) {
            FluxoBuilderAtributoSimples.digitarAtributo(nomeAtributo);
        }
    }
}
