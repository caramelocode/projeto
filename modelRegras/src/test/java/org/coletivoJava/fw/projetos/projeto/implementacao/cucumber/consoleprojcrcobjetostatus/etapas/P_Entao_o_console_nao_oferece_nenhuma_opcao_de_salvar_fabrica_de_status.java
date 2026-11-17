package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.etapas;

import br.org.carameloCode.erp.modulo.projeto.console.ItemOpcaoConsole;
import cucumber.api.java.pt.Entao;
import java.util.List;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetostatus.EtapasconsoleProjCRCObjetoStatus;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.FluxoConsoleObjetoStatus;
import org.junit.Assert;

public class P_Entao_o_console_nao_oferece_nenhuma_opcao_de_salvar_fabrica_de_status {

    @Entao(EtapasconsoleProjCRCObjetoStatus.ENTAO_O_CONSOLE_NAO_OFERECE_NENHUMA_OPCAO_DE_SALVAR_FABRICA_DE_STATUS)
    public void implementacaoEtapa() {
        // Sem entidade de status, a fábrica não pode ser criada pelo console
        List<ItemOpcaoConsole> opcoesSalvarFabrica = FluxoConsoleObjetoStatus.getOpcoesComAcao(FluxoConsoleObjetoStatus.ACAO_SALVAR_FABRICA);
        Assert.assertTrue("O console não deveria oferecer salvar a fábrica de status " + FluxoConsoleObjetoStatus.NOME_FABRICA_STATUS_INEXISTENTE,
                opcoesSalvarFabrica.isEmpty());
    }
}
