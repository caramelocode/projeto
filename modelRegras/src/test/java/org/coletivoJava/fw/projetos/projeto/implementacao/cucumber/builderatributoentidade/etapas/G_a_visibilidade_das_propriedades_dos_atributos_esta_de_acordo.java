package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoentidade.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributoentidade.EtapasbuilderAtributoEntidade;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoentidade.FluxoBuilderAtributoEntidade;

public class G_a_visibilidade_das_propriedades_dos_atributos_esta_de_acordo {

    @E(EtapasbuilderAtributoEntidade.E_A_VISIBILIDADE_DAS_PROPRIEDADES_DOS_ATRIBUTOS_ESTA_DE_ACORDO)
    public void implementacaoEtapa() {
        // Entidade Cliente recarregada na etapa Entao anterior: confere com o tipo com que cada atributo foi salvo
        for (String nomeAtributo : FluxoBuilderAtributoEntidade.getNomesAtributos()) {
            FluxoBuilderAtributoEntidade.verificarVisibilidadeCampos(FluxoBuilderAtributoEntidade.getAtributoEntidadeSalvo(nomeAtributo));
        }
    }
}
