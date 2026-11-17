package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaEntidadeProjCRC;
import cucumber.api.java.pt.E;
import java.util.Optional;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetostatus.EtapasconsoleProjCRCObjetoStatus;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.FluxoConsoleObjetoStatus;
import org.junit.Assert;

public class C_o_projeto_ainda_nao_possui_a_fabrica_FabStatusCliente {

    @E(EtapasconsoleProjCRCObjetoStatus.E_O_PROJETO_AINDA_NAO_POSSUI_A_FABRICA_FABSTATUSCLIENTE)
    public void implementacaoEtapa() {
        String nomeFabrica = FluxoConsoleObjetoStatus.NOME_FABRICA_STATUS_CLIENTE;

        Optional<FabricaEntidadeProjCRC> fabricaNoBanco = FluxoConsoleObjetoStatus.getFabricaSalvaNoProjeto(nomeFabrica);
        Assert.assertFalse("O projeto não deveria possuir a fábrica " + nomeFabrica, fabricaNoBanco.isPresent());

        FabricaEntidadeProjCRC fabricaNoRepositorio = FluxoConsoleObjetoStatus.CONSOLE.getRepositorio().getFabricaExistente(nomeFabrica);
        Assert.assertNull("O repositório do console não deveria conter a fábrica " + nomeFabrica, fabricaNoRepositorio);
    }
}
