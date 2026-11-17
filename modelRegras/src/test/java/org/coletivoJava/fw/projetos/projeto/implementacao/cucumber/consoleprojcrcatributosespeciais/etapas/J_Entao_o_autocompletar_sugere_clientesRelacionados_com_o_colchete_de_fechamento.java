package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.etapas;

import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcatributosespeciais.EtapasconsoleProjCRCAtributosEspeciais;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.FluxoConsoleAtributosEspeciais;
import org.junit.Assert;

public class J_Entao_o_autocompletar_sugere_clientesRelacionados_com_o_colchete_de_fechamento {

    @Entao(EtapasconsoleProjCRCAtributosEspeciais.ENTAO_O_AUTOCOMPLETAR_SUGERE_CLIENTESRELACIONADOS_COM_O_COLCHETE_DE_FECHAMENTO)
    public void implementacaoEtapa() {
        Assert.assertTrue("O autocompletar deveria sugerir " + FluxoConsoleAtributosEspeciais.TEXTO_ATRIBUTO_LISTA_CLIENTES_RELACIONADOS
                + ", sugestões: " + FluxoConsoleAtributosEspeciais.sugestoesAutocompletar,
                FluxoConsoleAtributosEspeciais.sugestoesAutocompletar.contains(FluxoConsoleAtributosEspeciais.TEXTO_ATRIBUTO_LISTA_CLIENTES_RELACIONADOS));
        Assert.assertFalse("O autocompletar não deveria sugerir o texto sem o colchete de fechamento",
                FluxoConsoleAtributosEspeciais.sugestoesAutocompletar.contains(FluxoConsoleAtributosEspeciais.TEXTO_ATRIBUTO_LISTA_SEM_FECHAR_COLCHETE));
    }
}
