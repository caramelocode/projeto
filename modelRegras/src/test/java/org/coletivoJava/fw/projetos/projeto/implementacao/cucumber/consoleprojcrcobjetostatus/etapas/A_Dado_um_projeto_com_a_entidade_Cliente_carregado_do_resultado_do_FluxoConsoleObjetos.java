package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import cucumber.api.java.pt.Dado;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetostatus.EtapasconsoleProjCRCObjetoStatus;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.FluxoConsoleObjetoStatus;
import org.junit.Assert;
import testesFW.devOps.DevOpsCucumberPersistenciaMysql;

public class A_Dado_um_projeto_com_a_entidade_Cliente_carregado_do_resultado_do_FluxoConsoleObjetos {

    @Dado(EtapasconsoleProjCRCObjetoStatus.DADO_UM_PROJETO_COM_A_ENTIDADE_CLIENTE_CARREGADO_DO_RESULTADO_DO_FLUXOCONSOLEOBJETOS)
    public void implementacaoEtapa() {
        // Banco no estado final do FluxoConsoleObjetos
        DevOpsCucumberPersistenciaMysql.carregarResultadoRequisito(FluxoConsoleObjetos.class);
        FluxoConsoleObjetoStatus.renovarConexaoEntityManagerEscopoTeste();

        // Login
        CarameloCode.getServicoSessao().logarEmailESenha(FluxoConsoleObjetoStatus.EMAIL_USUARIO_ADMIN, FluxoConsoleObjetoStatus.SENHA_ADMIN);
        boolean logado = CarameloCode.getServicoSessao().getSessaoAtual().isIdentificado();
        Assert.assertTrue("Falha no login", logado);

        // Projeto aberto no console
        FluxoConsoleObjetoStatus.CONSOLE.carregarProjetos();
        ProjetoCRC projetoSelecionado = FluxoConsoleObjetoStatus.CONSOLE.getProjetoSelecionado();
        Assert.assertNotNull("Nenhum projeto selecionado no console", projetoSelecionado);
        FluxoConsoleObjetoStatus.projeto = projetoSelecionado;

        // Entidade Cliente gerada pelo FluxoConsoleObjetos
        boolean clienteExiste = FluxoConsoleObjetoStatus.CONSOLE.getRepositorio()
                .isEntidadeExiste(FluxoConsoleObjetoStatus.NOME_ENTIDADE_CLIENTE);
        Assert.assertTrue("A entidade " + FluxoConsoleObjetoStatus.NOME_ENTIDADE_CLIENTE
                + " deveria existir no projeto (gerada pelo FluxoConsoleObjetos)", clienteExiste);
    }
}
