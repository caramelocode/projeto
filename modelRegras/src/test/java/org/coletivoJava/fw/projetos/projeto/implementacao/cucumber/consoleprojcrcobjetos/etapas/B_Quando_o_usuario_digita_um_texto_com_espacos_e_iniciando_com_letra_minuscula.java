package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetos.EtapasconsoleProjCRCObjetos;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;

public class B_Quando_o_usuario_digita_um_texto_com_espacos_e_iniciando_com_letra_minuscula {

    @Quando(EtapasconsoleProjCRCObjetos.QUANDO_O_USUARIO_DIGITA_UM_TEXTO_COM_ESPACOS_E_INICIANDO_COM_LETRA_MINUSCULA)
    public void implementacaoEtapa() {
        FluxoConsoleObjetos.sugestoesAutocompletar = FluxoConsoleObjetos.CONSOLE.autocompletProjeto(FluxoConsoleObjetos.TEXTO_COM_ESPACOS_MINUSCULO);
        Assert.assertNotNull("O autocompletar não retornou sugestões", FluxoConsoleObjetos.sugestoesAutocompletar);
    }
}
