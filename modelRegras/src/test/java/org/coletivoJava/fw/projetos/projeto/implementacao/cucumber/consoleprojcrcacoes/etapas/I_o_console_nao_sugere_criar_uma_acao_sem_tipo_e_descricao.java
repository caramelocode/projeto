package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.acao.FabAcaoCarameloDevAcaoProjCRC;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;
import org.junit.Assert;

public class I_o_console_nao_sugere_criar_uma_acao_sem_tipo_e_descricao {

    @E(EtapasconsoleProjCRCAcoes.E_O_CONSOLE_NAO_SUGERE_CRIAR_UMA_ACAO_SEM_TIPO_E_DESCRICAO)
    public void implementacaoEtapa() {
        Assert.assertTrue("O console não deveria sugerir criar uma ação sem tipo e descrição",
                FluxoConsoleAcoes.CONSOLE.getOpcoesDisponiveis().stream()
                        .noneMatch(op -> FabAcaoCarameloDevAcaoProjCRC.ACOES_CTR_SALVAR.equals(op.getFabAcaoAssociada())));
        // O projeto ainda não tem ações: também não há nada para editar
        Assert.assertTrue("O console não deveria sugerir nenhuma opção, sugeriu " + FluxoConsoleAcoes.CONSOLE.getOpcoesDisponiveis().size(),
                FluxoConsoleAcoes.CONSOLE.getOpcoesDisponiveis().isEmpty());
    }
}
