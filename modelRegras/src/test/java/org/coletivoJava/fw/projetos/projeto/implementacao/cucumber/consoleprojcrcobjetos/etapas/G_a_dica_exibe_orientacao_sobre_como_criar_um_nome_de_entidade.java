package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetos.EtapasconsoleProjCRCObjetos;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;

public class G_a_dica_exibe_orientacao_sobre_como_criar_um_nome_de_entidade {

    @E(EtapasconsoleProjCRCObjetos.E_A_DICA_EXIBE_ORIENTACAO_SOBRE_COMO_CRIAR_UM_NOME_DE_ENTIDADE)
    public void implementacaoEtapa() {
        String dica = FluxoConsoleObjetos.CONSOLE.getTextoDica();
        Assert.assertNotNull("Nenhuma dica exibida", dica);
        Assert.assertTrue("A dica não orienta sobre nome de entidade: " + dica, dica.contains(FluxoConsoleObjetos.TRECHO_DICA_NOME_ENTIDADE));
    }
}
