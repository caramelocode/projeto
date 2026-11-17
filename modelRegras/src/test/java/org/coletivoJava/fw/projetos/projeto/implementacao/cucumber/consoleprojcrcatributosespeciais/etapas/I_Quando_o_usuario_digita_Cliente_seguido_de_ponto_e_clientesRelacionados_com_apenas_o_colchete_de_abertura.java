package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.etapas;

import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcatributosespeciais.EtapasconsoleProjCRCAtributosEspeciais;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.FluxoConsoleAtributosEspeciais;

public class I_Quando_o_usuario_digita_Cliente_seguido_de_ponto_e_clientesRelacionados_com_apenas_o_colchete_de_abertura {

    @Quando(EtapasconsoleProjCRCAtributosEspeciais.QUANDO_O_USUARIO_DIGITA_CLIENTE_SEGUIDO_DE_PONTO_E_CLIENTESRELACIONADOS_COM_APENAS_O_COLCHETE_DE_ABERTURA)
    public void implementacaoEtapa() {
        FluxoConsoleAtributosEspeciais.digitarNoConsole(FluxoConsoleAtributosEspeciais.TEXTO_ATRIBUTO_LISTA_SEM_FECHAR_COLCHETE);
    }
}
