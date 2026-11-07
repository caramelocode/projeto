package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetos.EtapasconsoleProjCRCObjetos;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;

public class C_Entao_o_texto_definido_fica_sem_espacos_e_com_a_primeira_letra_maiuscula {

    @Entao(EtapasconsoleProjCRCObjetos.ENTAO_O_TEXTO_DEFINIDO_FICA_SEM_ESPACOS_E_COM_A_PRIMEIRA_LETRA_MAIUSCULA)
    public void implementacaoEtapa() {
        Assert.assertEquals("Texto não foi normatizado", FluxoConsoleObjetos.NOME_ENTIDADE_CLIENTE, FluxoConsoleObjetos.CONSOLE.getTextoDefinido());
    }
}
