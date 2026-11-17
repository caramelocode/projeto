package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributolistagem.EtapasbuilderAtributoListagem;
import cucumber.api.java.pt.Dado;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.FluxoBuilderAtributoListagem;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;
import testesFW.devOps.DevOpsCucumberPersistenciaMysql;

public class A_Dado_um_projeto_com_a_entidade_Cliente_carregado_do_resultado_do_FluxoConsoleObjetos {

    @Dado(EtapasbuilderAtributoListagem.DADO_UM_PROJETO_COM_A_ENTIDADE_CLIENTE_CARREGADO_DO_RESULTADO_DO_FLUXOCONSOLEOBJETOS)
    public void implementacaoEtapa() {
        DevOpsCucumberPersistenciaMysql.carregarResultadoRequisito(FluxoConsoleObjetos.class);
        FluxoBuilderAtributoListagem.renovarConexaoEntityManagerEscopoTeste();
        CarameloCode.getServicoSessao().logarEmailESenha(FluxoBuilderAtributoListagem.EMAIL_USUARIO_ADMIN, FluxoBuilderAtributoListagem.SENHA_ADMIN);
        Assert.assertTrue("Falha no login", CarameloCode.getServicoSessao().getSessaoAtual().isIdentificado());

        FluxoBuilderAtributoListagem.CONSOLE.carregarProjetos();
        FluxoBuilderAtributoListagem.projeto = FluxoBuilderAtributoListagem.CONSOLE.getProjetoSelecionado();
        Assert.assertNotNull("Nenhum projeto selecionado no console", FluxoBuilderAtributoListagem.projeto);
        Assert.assertTrue("A entidade " + FluxoBuilderAtributoListagem.NOME_ENTIDADE_CLIENTE + " deveria existir no projeto (gerada pelo FluxoConsoleObjetos)",
                FluxoBuilderAtributoListagem.CONSOLE.getRepositorio().isEntidadeExiste(FluxoBuilderAtributoListagem.NOME_ENTIDADE_CLIENTE));

        FluxoBuilderAtributoListagem.recarregarEntidadeCliente();
        Assert.assertFalse("O atributo " + FluxoBuilderAtributoListagem.NOME_CLIENTES_RELACIONADOS + " não deveria existir antes do teste", FluxoBuilderAtributoListagem.isAtributoSalvo(FluxoBuilderAtributoListagem.NOME_CLIENTES_RELACIONADOS));
        Assert.assertFalse("O atributo " + FluxoBuilderAtributoListagem.NOME_CLIENTES_PARTICULARES + " não deveria existir antes do teste", FluxoBuilderAtributoListagem.isAtributoSalvo(FluxoBuilderAtributoListagem.NOME_CLIENTES_PARTICULARES));
    }
}
