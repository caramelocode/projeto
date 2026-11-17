package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.etapas;

import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcatributosespeciais.EtapasconsoleProjCRCAtributosEspeciais;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.FluxoConsoleAtributosEspeciais;
import org.junit.Assert;

public class L_Quando_o_usuario_digita_Cliente_seguido_de_ponto_e_clientesRelacionados_terminado_em_colchetes {

    @Quando(EtapasconsoleProjCRCAtributosEspeciais.QUANDO_O_USUARIO_DIGITA_CLIENTE_SEGUIDO_DE_PONTO_E_CLIENTESRELACIONADOS_TERMINADO_EM_COLCHETES)
    public void implementacaoEtapa() {
        FluxoConsoleAtributosEspeciais.digitarNoConsole(FluxoConsoleAtributosEspeciais.TEXTO_ATRIBUTO_LISTA_CLIENTES_RELACIONADOS);
        Assert.assertEquals("Texto definido no console incorreto", FluxoConsoleAtributosEspeciais.TEXTO_ATRIBUTO_LISTA_CLIENTES_RELACIONADOS,
                FluxoConsoleAtributosEspeciais.CONSOLE.getTextoDefinido());
    }
}
