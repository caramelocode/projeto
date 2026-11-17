package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import cucumber.api.java.pt.Dado;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcfabentidadeestatica.EtapasconsoleProjCRCFabEntidadeEstatica;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.FluxoConsoleFabEntidadeEstatica;
import org.junit.Assert;
import testesFW.devOps.DevOpsCucumberPersistenciaMysql;

public class A_Dado_um_projeto_com_a_entidade_Cliente_e_acoes_criadas_pelo_console_de_acoes {

    @Dado(EtapasconsoleProjCRCFabEntidadeEstatica.DADO_UM_PROJETO_COM_A_ENTIDADE_CLIENTE_E_ACOES_CRIADAS_PELO_CONSOLE_DE_ACOES)
    public void implementacaoEtapa() {
        // Banco no estado final do FluxoConsoleAcoes
        DevOpsCucumberPersistenciaMysql.carregarResultadoRequisito(FluxoConsoleAcoes.class);
        FluxoConsoleFabEntidadeEstatica.renovarConexaoEntityManagerEscopoTeste();

        // Login
        CarameloCode.getServicoSessao().logarEmailESenha(FluxoConsoleFabEntidadeEstatica.EMAIL_USUARIO_ADMIN, FluxoConsoleFabEntidadeEstatica.SENHA_ADMIN);
        boolean logado = CarameloCode.getServicoSessao().getSessaoAtual().isIdentificado();
        Assert.assertTrue("Falha no login", logado);

        // Projeto aberto no console
        FluxoConsoleFabEntidadeEstatica.CONSOLE.carregarProjetos();
        ProjetoCRC projetoSelecionado = FluxoConsoleFabEntidadeEstatica.CONSOLE.getProjetoSelecionado();
        Assert.assertNotNull("Nenhum projeto selecionado no console", projetoSelecionado);
        FluxoConsoleFabEntidadeEstatica.projeto = projetoSelecionado;

        // Entidade Cliente gerada pelos fluxos anteriores
        boolean clienteExiste = FluxoConsoleFabEntidadeEstatica.CONSOLE.getRepositorio()
                .isEntidadeExiste(FluxoConsoleFabEntidadeEstatica.NOME_ENTIDADE_CLIENTE);
        Assert.assertTrue("A entidade " + FluxoConsoleFabEntidadeEstatica.NOME_ENTIDADE_CLIENTE
                + " deveria existir no projeto (gerada pelos fluxos anteriores)", clienteExiste);
    }
}
