package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.acao.FabAcaoCarameloDevAcaoProjCRC;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;
import org.junit.Assert;

public class V_Quando_o_usuario_executa_a_criacao_de_FabAcaoGerente_o_CLIENTE_MB_GESTAO {

    @Quando(EtapasconsoleProjCRCAcoes.QUANDO_O_USUARIO_EXECUTA_A_CRIACAO_DE_FABACAOGERENTE_O_CLIENTE_MB_GESTAO)
    public void implementacaoEtapa() {
        String nomeUnico = FluxoConsoleAcoes.getNomeUnico(FluxoConsoleAcoes.FABRICA_GERENTE, FluxoConsoleAcoes.ACAO_CLIENTE_MB_GESTAO);
        Assert.assertNotNull("Nenhuma opção selecionada para executar", FluxoConsoleAcoes.CONSOLE.getOpcaoSelecionada());
        Assert.assertEquals("A opção selecionada deveria ser criar a ação", FabAcaoCarameloDevAcaoProjCRC.ACOES_CTR_SALVAR,
                FluxoConsoleAcoes.CONSOLE.getOpcaoSelecionada().getFabAcaoAssociada());

        FluxoConsoleAcoes.CONSOLE.executarOpcaoSelecionada();

        FluxoConsoleAcoes.acaoGestaoCliente = FluxoConsoleAcoes.CONSOLE.getRepositorio().getAcaoExistente(nomeUnico);
        Assert.assertNotNull("Falha executando a criação: a ação " + nomeUnico + " não foi registrada no repositório do console",
                FluxoConsoleAcoes.acaoGestaoCliente);
    }
}
