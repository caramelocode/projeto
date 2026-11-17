package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.etapas;

import br.org.carameloCode.erp.modulo.projeto.console.ItemOpcaoConsole;
import cucumber.api.java.pt.E;
import java.util.List;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetostatus.EtapasconsoleProjCRCObjetoStatus;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.FluxoConsoleObjetoStatus;
import org.junit.Assert;

public class N_o_console_nao_oferece_a_opcao_de_salvar_a_fabrica_FabStatusCliente {

    @E(EtapasconsoleProjCRCObjetoStatus.E_O_CONSOLE_NAO_OFERECE_A_OPCAO_DE_SALVAR_A_FABRICA_FABSTATUSCLIENTE)
    public void implementacaoEtapa() {
        // Fábrica de status nasce da entidade: o console nunca oferece salvá-la
        List<ItemOpcaoConsole> opcoesSalvarFabrica = FluxoConsoleObjetoStatus.getOpcoesComAcao(FluxoConsoleObjetoStatus.ACAO_SALVAR_FABRICA);
        Assert.assertTrue("O console não deveria oferecer salvar a fábrica " + FluxoConsoleObjetoStatus.NOME_FABRICA_STATUS_CLIENTE,
                opcoesSalvarFabrica.isEmpty());
    }
}
