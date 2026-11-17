package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.etapas;

import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcatributosespeciais.EtapasconsoleProjCRCAtributosEspeciais;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.FluxoConsoleAtributosEspeciais;
import org.junit.Assert;

public class C_Quando_o_usuario_digita_Cliente_seguido_de_ponto_e_clienteIndicou_terminado_em_ponto {

    @Quando(EtapasconsoleProjCRCAtributosEspeciais.QUANDO_O_USUARIO_DIGITA_CLIENTE_SEGUIDO_DE_PONTO_E_CLIENTEINDICOU_TERMINADO_EM_PONTO)
    public void implementacaoEtapa() {
        FluxoConsoleAtributosEspeciais.digitarNoConsole(FluxoConsoleAtributosEspeciais.TEXTO_ATRIBUTO_OBJETO_CLIENTE_INDICOU);
        Assert.assertEquals("Texto definido no console incorreto", FluxoConsoleAtributosEspeciais.TEXTO_ATRIBUTO_OBJETO_CLIENTE_INDICOU,
                FluxoConsoleAtributosEspeciais.CONSOLE.getTextoDefinido());
    }
}
