package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoentidade.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeEntidade;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributoentidade.EtapasbuilderAtributoEntidade;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoentidade.FluxoBuilderAtributoEntidade;
import org.junit.Assert;

public class H_Quando_o_usuario_lista_os_atributos_que_precisam_ter_o_tipo_definido_na_mao {

    @Quando(EtapasbuilderAtributoEntidade.QUANDO_O_USUARIO_LISTA_OS_ATRIBUTOS_QUE_PRECISAM_TER_O_TIPO_DEFINIDO_NA_MAO)
    public void implementacaoEtapa() {
        FluxoBuilderAtributoEntidade.ATRIBUTO_TIPO_MANUAL.clear();
        FluxoBuilderAtributoEntidade.recarregarEntidadeCliente();
        // Atributos digitados com ponto cujo tipo salvo (OBJETO_DE_UMA_LISTA) não é o esperado
        for (String nomeAtributo : FluxoBuilderAtributoEntidade.ATRIBUTOS_DEFINIDOS_PELO_USUARIO.keySet()) {
            AtributoEntidadeEntidade atributo = FluxoBuilderAtributoEntidade.getAtributoEntidadeSalvo(nomeAtributo);
            if (atributo.getTipo() != FluxoBuilderAtributoEntidade.getTipoEsperado(nomeAtributo)) {
                FluxoBuilderAtributoEntidade.ATRIBUTO_TIPO_MANUAL.add(atributo);
            }
        }
        Assert.assertFalse("Nenhum atributo precisa ter o tipo definido pelo usuário", FluxoBuilderAtributoEntidade.ATRIBUTO_TIPO_MANUAL.isEmpty());
    }
}
