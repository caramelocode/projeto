package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributolistagem.EtapasbuilderAtributoListagem;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.FluxoBuilderAtributoListagem;
import org.junit.Assert;
import java.util.List;

public class I_o_autocomplete_apresenta_a_sugestao_com_colchete_ao_digitar_somente_o_nome_do_atributo {

    @E(EtapasbuilderAtributoListagem.E_O_AUTOCOMPLETE_APRESENTA_A_SUGESTAO_COM_COLCHETE_AO_DIGITAR_SOMENTE_O_NOME_DO_ATRIBUTO)
    public void implementacaoEtapa() {
        // O usuário digita só o nome do atributo, sem os colchetes
        List<String> sugestoes = FluxoBuilderAtributoListagem.CONSOLE.autocompletProjeto(FluxoBuilderAtributoListagem.getTextoSemSufixo(FluxoBuilderAtributoListagem.NOME_CLIENTES_RELACIONADOS));
        Assert.assertTrue("O autocompletar deveria sugerir " + FluxoBuilderAtributoListagem.getTextoDigitado(FluxoBuilderAtributoListagem.NOME_CLIENTES_RELACIONADOS) + " ao digitar "
                + FluxoBuilderAtributoListagem.getTextoSemSufixo(FluxoBuilderAtributoListagem.NOME_CLIENTES_RELACIONADOS) + ", sugeriu " + sugestoes, sugestoes.contains(FluxoBuilderAtributoListagem.getTextoDigitado(FluxoBuilderAtributoListagem.NOME_CLIENTES_RELACIONADOS)));
        Assert.assertFalse("O autocompletar não deveria sugerir o atributo de listagem sem os colchetes",
                sugestoes.contains(FluxoBuilderAtributoListagem.getTextoSemSufixo(FluxoBuilderAtributoListagem.NOME_CLIENTES_RELACIONADOS)));
    }
}
