package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoentidade.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributoentidade.EtapasbuilderAtributoEntidade;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoentidade.FluxoBuilderAtributoEntidade;

public class B_Quando_o_usuario_digita_um_nome_para_cada_tipo_de_atributo_de_entidade {

    @Quando(EtapasbuilderAtributoEntidade.QUANDO_O_USUARIO_DIGITA_UM_NOME_PARA_CADA_TIPO_DE_ATRIBUTO_DE_ENTIDADE)
    public void implementacaoEtapa() {
        // digitarAtributo confere que a opção do atributo novo é a primeira sugerida
        for (String nomeAtributo : FluxoBuilderAtributoEntidade.getNomesAtributos()) {
            FluxoBuilderAtributoEntidade.digitarAtributo(nomeAtributo);
        }
    }
}
