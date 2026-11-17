package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.etapas;

import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcatributosespeciais.EtapasconsoleProjCRCAtributosEspeciais;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.FluxoConsoleAtributosEspeciais;
import org.junit.Assert;

public class K_o_texto_definido_fica_normatizado_com_os_colchetes_de_abertura_e_fechamento {

    @E(EtapasconsoleProjCRCAtributosEspeciais.E_O_TEXTO_DEFINIDO_FICA_NORMATIZADO_COM_OS_COLCHETES_DE_ABERTURA_E_FECHAMENTO)
    public void implementacaoEtapa() {
        Assert.assertEquals("Texto definido não normatizado com os colchetes", FluxoConsoleAtributosEspeciais.TEXTO_ATRIBUTO_LISTA_CLIENTES_RELACIONADOS,
                FluxoConsoleAtributosEspeciais.CONSOLE.getTextoDefinido());
    }
}
