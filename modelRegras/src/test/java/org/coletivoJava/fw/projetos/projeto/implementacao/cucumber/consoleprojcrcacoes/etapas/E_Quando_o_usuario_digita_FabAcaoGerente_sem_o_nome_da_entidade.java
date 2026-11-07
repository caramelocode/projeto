package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;
import org.junit.Assert;

public class E_Quando_o_usuario_digita_FabAcaoGerente_sem_o_nome_da_entidade {

    @Quando(EtapasconsoleProjCRCAcoes.QUANDO_O_USUARIO_DIGITA_FABACAOGERENTE_SEM_O_NOME_DA_ENTIDADE)
    public void implementacaoEtapa() {
        FluxoConsoleAcoes.sugestoesAutocompletar = FluxoConsoleAcoes.CONSOLE.autocompletProjeto(FluxoConsoleAcoes.FABRICA_GERENTE);
        Assert.assertNotNull("O autocompletar não retornou sugestões", FluxoConsoleAcoes.sugestoesAutocompletar);
        Assert.assertEquals("Texto definido incorreto", FluxoConsoleAcoes.FABRICA_GERENTE, FluxoConsoleAcoes.CONSOLE.getTextoDefinido());
    }
}
