package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaEntidadeProjCRC;
import cucumber.api.java.pt.E;
import java.util.Optional;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcfabentidadeestatica.EtapasconsoleProjCRCFabEntidadeEstatica;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.FluxoConsoleFabEntidadeEstatica;
import org.junit.Assert;

public class B_o_projeto_ainda_nao_possui_a_fabrica_FabTipoCliente {

    @E(EtapasconsoleProjCRCFabEntidadeEstatica.E_O_PROJETO_AINDA_NAO_POSSUI_A_FABRICA_FABTIPOCLIENTE)
    public void implementacaoEtapa() {
        String nomeFabrica = FluxoConsoleFabEntidadeEstatica.NOME_FABRICA_TIPO_CLIENTE;

        Optional<FabricaEntidadeProjCRC> fabricaNoBanco = FluxoConsoleFabEntidadeEstatica.getFabricaSalvaNoProjeto(nomeFabrica);
        Assert.assertFalse("O projeto não deveria possuir a fábrica " + nomeFabrica, fabricaNoBanco.isPresent());

        FabricaEntidadeProjCRC fabricaNoRepositorio = FluxoConsoleFabEntidadeEstatica.CONSOLE.getRepositorio().getFabricaExistente(nomeFabrica);
        Assert.assertNull("O repositório do console não deveria conter a fábrica " + nomeFabrica, fabricaNoRepositorio);
    }
}
