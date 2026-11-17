package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.etapas;

import br.org.carameloCode.erp.modulo.projeto.console.ItemOpcaoConsole;
import cucumber.api.java.pt.Entao;
import java.util.List;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetostatus.EtapasconsoleProjCRCObjetoStatus;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.FluxoConsoleObjetoStatus;
import org.junit.Assert;

public class AE_Entao_o_console_nao_oferece_a_opcao_de_salvar_o_status_INADIMPLENTE_de_novo {

    @Entao(EtapasconsoleProjCRCObjetoStatus.ENTAO_O_CONSOLE_NAO_OFERECE_A_OPCAO_DE_SALVAR_O_STATUS_INADIMPLENTE_DE_NOVO)
    public void implementacaoEtapa() {
        // INADIMPLENTE já existe: nenhuma opção de salvar status
        List<ItemOpcaoConsole> opcoesSalvarStatus = FluxoConsoleObjetoStatus.getOpcoesComAcao(FluxoConsoleObjetoStatus.ACAO_SALVAR_STATUS);
        Assert.assertTrue("O console não deveria oferecer salvar o status " + FluxoConsoleObjetoStatus.NOME_ENUM_STATUS_INADIMPLENTE + " de novo",
                opcoesSalvarStatus.isEmpty());
    }
}
