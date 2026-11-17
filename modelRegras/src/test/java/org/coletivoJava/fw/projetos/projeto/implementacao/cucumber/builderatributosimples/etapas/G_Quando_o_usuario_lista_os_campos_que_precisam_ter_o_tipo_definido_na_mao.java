package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributosimples.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributosimples.EtapasbuilderAtributoSimples;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributosimples.FluxoBuilderAtributoSimples;
import org.junit.Assert;

public class G_Quando_o_usuario_lista_os_campos_que_precisam_ter_o_tipo_definido_na_mao {

    @Quando(EtapasbuilderAtributoSimples.QUANDO_O_USUARIO_LISTA_OS_CAMPOS_QUE_PRECISAM_TER_O_TIPO_DEFINIDO_NA_MAO)
    public void implementacaoEtapa() {
        FluxoBuilderAtributoSimples.ATRIBUTO_TIPO_MANUAL.clear();
        FluxoBuilderAtributoSimples.recarregarEntidadeCliente();
        for (String nomeAtributo : FluxoBuilderAtributoSimples.NOMES_ATRIBUTO_POR_TIPO.values()) {
            if (!FluxoBuilderAtributoSimples.isTipoDefinidoAutomaticamente(nomeAtributo)) {
                FluxoBuilderAtributoSimples.ATRIBUTO_TIPO_MANUAL.add(FluxoBuilderAtributoSimples.getAtributoSalvo(nomeAtributo));
            }
        }
        Assert.assertFalse("Nenhum atributo precisa ter o tipo definido pelo usuário", FluxoBuilderAtributoSimples.ATRIBUTO_TIPO_MANUAL.isEmpty());
    }
}
