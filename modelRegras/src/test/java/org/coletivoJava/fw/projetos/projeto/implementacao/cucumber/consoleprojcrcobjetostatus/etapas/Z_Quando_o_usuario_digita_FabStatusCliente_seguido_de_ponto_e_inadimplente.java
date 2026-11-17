package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetostatus.EtapasconsoleProjCRCObjetoStatus;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.FluxoConsoleObjetoStatus;
import org.junit.Assert;

public class Z_Quando_o_usuario_digita_FabStatusCliente_seguido_de_ponto_e_inadimplente {

    @Quando(EtapasconsoleProjCRCObjetoStatus.QUANDO_O_USUARIO_DIGITA_FABSTATUSCLIENTE_SEGUIDO_DE_PONTO_E_INADIMPLENTE)
    public void implementacaoEtapa() {
        String textoDigitado = FluxoConsoleObjetoStatus.TEXTO_STATUS_INADIMPLENTE;

        FluxoConsoleObjetoStatus.digitarNoConsole(textoDigitado);

        String textoDefinido = FluxoConsoleObjetoStatus.CONSOLE.getTextoDefinido();
        Assert.assertEquals("Texto definido incorreto", textoDigitado, textoDefinido);
        FabTipoItemProjeto tipoIdentificado = FluxoConsoleObjetoStatus.CONSOLE.getTipoPesquisa();
        Assert.assertEquals("Tipo de pesquisa identificado incorreto", FluxoConsoleObjetoStatus.TIPO_FABRICA, tipoIdentificado);
    }
}
