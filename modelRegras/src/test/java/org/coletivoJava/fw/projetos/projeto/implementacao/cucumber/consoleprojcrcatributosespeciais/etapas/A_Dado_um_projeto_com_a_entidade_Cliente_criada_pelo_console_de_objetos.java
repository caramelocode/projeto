package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.etapas;

import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcatributosespeciais.EtapasconsoleProjCRCAtributosEspeciais;
import cucumber.api.java.pt.Dado;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.FluxoConsoleAtributosEspeciais;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;
import testesFW.devOps.DevOpsCucumberPersistenciaMysql;

public class A_Dado_um_projeto_com_a_entidade_Cliente_criada_pelo_console_de_objetos {

    @Dado(EtapasconsoleProjCRCAtributosEspeciais.DADO_UM_PROJETO_COM_A_ENTIDADE_CLIENTE_CRIADA_PELO_CONSOLE_DE_OBJETOS)
    public void implementacaoEtapa() {
        DevOpsCucumberPersistenciaMysql.carregarResultadoRequisito(FluxoConsoleObjetos.class);
        FluxoConsoleAtributosEspeciais.renovarConexaoEntityManagerEscopoTeste();
        CarameloCode.getServicoSessao().logarEmailESenha(FluxoConsoleAtributosEspeciais.EMAIL_USUARIO_ADMIN, FluxoConsoleAtributosEspeciais.SENHA_ADMIN);
        Assert.assertTrue("Falha no login", CarameloCode.getServicoSessao().getSessaoAtual().isIdentificado());

        FluxoConsoleAtributosEspeciais.CONSOLE.carregarProjetos();
        FluxoConsoleAtributosEspeciais.projeto = FluxoConsoleAtributosEspeciais.CONSOLE.getProjetoSelecionado();
        Assert.assertNotNull("Nenhum projeto selecionado no console", FluxoConsoleAtributosEspeciais.projeto);
        Assert.assertTrue("A entidade " + FluxoConsoleAtributosEspeciais.NOME_ENTIDADE_CLIENTE + " deveria existir no projeto (gerada pelo FluxoConsoleObjetos)",
                FluxoConsoleAtributosEspeciais.CONSOLE.getRepositorio().isEntidadeExiste(FluxoConsoleAtributosEspeciais.NOME_ENTIDADE_CLIENTE));
    }
}
