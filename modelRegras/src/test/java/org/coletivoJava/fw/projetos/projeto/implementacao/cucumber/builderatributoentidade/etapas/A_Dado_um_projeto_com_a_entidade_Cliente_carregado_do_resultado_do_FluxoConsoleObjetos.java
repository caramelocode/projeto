package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoentidade.etapas;

import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributoentidade.EtapasbuilderAtributoEntidade;
import cucumber.api.java.pt.Dado;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoentidade.FluxoBuilderAtributoEntidade;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;
import testesFW.devOps.DevOpsCucumberPersistenciaMysql;

public class A_Dado_um_projeto_com_a_entidade_Cliente_carregado_do_resultado_do_FluxoConsoleObjetos {

    @Dado(EtapasbuilderAtributoEntidade.DADO_UM_PROJETO_COM_A_ENTIDADE_CLIENTE_CARREGADO_DO_RESULTADO_DO_FLUXOCONSOLEOBJETOS)
    public void implementacaoEtapa() {
        DevOpsCucumberPersistenciaMysql.carregarResultadoRequisito(FluxoConsoleObjetos.class);
        FluxoBuilderAtributoEntidade.renovarConexaoEntityManagerEscopoTeste();

        CarameloCode.getServicoSessao().logarEmailESenha(FluxoBuilderAtributoEntidade.EMAIL_USUARIO_ADMIN, FluxoBuilderAtributoEntidade.SENHA_ADMIN);
        Assert.assertTrue("Falha no login", CarameloCode.getServicoSessao().getSessaoAtual().isIdentificado());

        FluxoBuilderAtributoEntidade.CONSOLE.carregarProjetos();
        FluxoBuilderAtributoEntidade.projeto = FluxoBuilderAtributoEntidade.CONSOLE.getProjetoSelecionado();
        Assert.assertNotNull("Nenhum projeto selecionado no console", FluxoBuilderAtributoEntidade.projeto);
        Assert.assertTrue("A entidade " + FluxoBuilderAtributoEntidade.NOME_ENTIDADE_CLIENTE + " deveria existir no projeto (gerada pelo FluxoConsoleObjetos)",
                FluxoBuilderAtributoEntidade.CONSOLE.getRepositorio().isEntidadeExiste(FluxoBuilderAtributoEntidade.NOME_ENTIDADE_CLIENTE));

        FluxoBuilderAtributoEntidade.recarregarEntidadeCliente();
        for (String nomeAtributo : FluxoBuilderAtributoEntidade.getNomesAtributos()) {
            Assert.assertFalse("O atributo " + nomeAtributo + " não deveria existir em " + FluxoBuilderAtributoEntidade.NOME_ENTIDADE_CLIENTE
                    + " antes do teste", FluxoBuilderAtributoEntidade.isAtributoSalvo(nomeAtributo));
        }
    }
}
