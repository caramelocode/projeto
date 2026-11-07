package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.projeto.FabAcaoCarameloDevProjetoCRC;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import cucumber.api.java.pt.Dado;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;
import testesFW.devOps.DevOpsCucumberPersistenciaMysql;

public class A_Dado_um_projeto_com_a_entidade_Cliente_criada_pelo_console_de_objetos {

    @Dado(EtapasconsoleProjCRCAcoes.DADO_UM_PROJETO_COM_A_ENTIDADE_CLIENTE_CRIADA_PELO_CONSOLE_DE_OBJETOS)
    public void implementacaoEtapa() {
        System.out.println(FabAcaoCarameloDevProjetoCRC.PROJETO_CTR_PUBLICAR.getNomeUnico());
        DevOpsCucumberPersistenciaMysql.carregarResultadoRequisito(FluxoConsoleObjetos.class);
        FluxoConsoleAcoes.renovarConexaoEntityManagerEscopoTeste();
        CarameloCode.getServicoSessao().logarEmailESenha(FluxoConsoleAcoes.EMAIL_USUARIO_ADMIN, FluxoConsoleAcoes.SENHA_ADMIN);
        Assert.assertTrue("Falha no login", CarameloCode.getServicoSessao().getSessaoAtual().isIdentificado());

        FluxoConsoleAcoes.CONSOLE.carregarProjetos();
        FluxoConsoleAcoes.projeto = FluxoConsoleAcoes.CONSOLE.getProjetoSelecionado();
        Assert.assertNotNull("Nenhum projeto selecionado no console", FluxoConsoleAcoes.projeto);
        Assert.assertTrue("A entidade " + FluxoConsoleAcoes.NOME_ENTIDADE_CLIENTE + " deveria existir no projeto (gerada pelo FluxoConsoleObjetos)",
                FluxoConsoleAcoes.CONSOLE.getRepositorio().isEntidadeExiste(FluxoConsoleAcoes.NOME_ENTIDADE_CLIENTE));
    }
}
