package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.etapas;

import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetos.EtapasconsoleProjCRCObjetos;
import cucumber.api.java.pt.Dado;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.cadastroprojetocrc.FluxoCadastroProjeto;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;
import testesFW.devOps.DevOpsCucumberPersistenciaMysql;

public class A_Dado_um_projeto_aberto_no_console_sem_a_entidade_Cliente {

    @Dado(EtapasconsoleProjCRCObjetos.DADO_UM_PROJETO_ABERTO_NO_CONSOLE_SEM_A_ENTIDADE_CLIENTE)
    public void implementacaoEtapa() {
        DevOpsCucumberPersistenciaMysql.carregarResultadoRequisito(FluxoCadastroProjeto.class);
        FluxoConsoleObjetos.renovarConexaoEntityManagerEscopoTeste();
        CarameloCode.getServicoSessao().logarEmailESenha(FluxoConsoleObjetos.EMAIL_USUARIO_ADMIN, FluxoConsoleObjetos.SENHA_ADMIN);
        Assert.assertTrue("Falha no login", CarameloCode.getServicoSessao().getSessaoAtual().isIdentificado());

        FluxoConsoleObjetos.CONSOLE.carregarProjetos();
        Assert.assertNotNull("Nenhum projeto selecionado no console", FluxoConsoleObjetos.CONSOLE.getProjetoSelecionado());
        Assert.assertFalse("O projeto não deveria ter a entidade " + FluxoConsoleObjetos.NOME_ENTIDADE_CLIENTE,
                FluxoConsoleObjetos.CONSOLE.getRepositorio().isEntidadeExiste(FluxoConsoleObjetos.NOME_ENTIDADE_CLIENTE));
    }
}
