package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributosimples.etapas;

import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributosimples.EtapasbuilderAtributoSimples;
import cucumber.api.java.pt.Dado;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributosimples.FluxoBuilderAtributoSimples;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;
import testesFW.devOps.DevOpsCucumberPersistenciaMysql;

public class A_Dado_um_projeto_com_a_entidade_Cliente_carregado_do_resultado_do_FluxoConsoleObjetos {

    @Dado(EtapasbuilderAtributoSimples.DADO_UM_PROJETO_COM_A_ENTIDADE_CLIENTE_CARREGADO_DO_RESULTADO_DO_FLUXOCONSOLEOBJETOS)
    public void implementacaoEtapa() {

        DevOpsCucumberPersistenciaMysql.carregarResultadoRequisito(FluxoConsoleObjetos.class);
        FluxoBuilderAtributoSimples.renovarConexaoEntityManagerEscopoTeste();
        CarameloCode.getServicoSessao().logarEmailESenha(FluxoBuilderAtributoSimples.EMAIL_USUARIO_ADMIN, FluxoBuilderAtributoSimples.SENHA_ADMIN);
        Assert.assertTrue("Falha no login", CarameloCode.getServicoSessao().getSessaoAtual().isIdentificado());

        FluxoBuilderAtributoSimples.CONSOLE.carregarProjetos();
        FluxoBuilderAtributoSimples.projeto = FluxoBuilderAtributoSimples.CONSOLE.getProjetoSelecionado();
        Assert.assertNotNull("Nenhum projeto selecionado no console", FluxoBuilderAtributoSimples.projeto);
        Assert.assertTrue("A entidade " + FluxoBuilderAtributoSimples.NOME_ENTIDADE_CLIENTE + " deveria existir no projeto (gerada pelo FluxoConsoleObjetos)",
                FluxoBuilderAtributoSimples.CONSOLE.getRepositorio().isEntidadeExiste(FluxoBuilderAtributoSimples.NOME_ENTIDADE_CLIENTE));

        FluxoBuilderAtributoSimples.recarregarEntidadeCliente();
        for (String nomeAtributo : FluxoBuilderAtributoSimples.NOMES_ATRIBUTO_POR_TIPO.values()) {
            if (FluxoBuilderAtributoSimples.ATRIBUTOS_DO_FLUXO_ANTERIOR.contains(nomeAtributo)) {
                Assert.assertTrue("O atributo " + nomeAtributo + " deveria existir no " + FluxoBuilderAtributoSimples.NOME_ENTIDADE_CLIENTE
                        + " gerado pelo FluxoConsoleObjetos", FluxoBuilderAtributoSimples.isAtributoSalvo(nomeAtributo));
            } else {
                Assert.assertFalse("O atributo " + nomeAtributo + " não deveria existir em " + FluxoBuilderAtributoSimples.NOME_ENTIDADE_CLIENTE
                        + " antes do teste", FluxoBuilderAtributoSimples.isAtributoSalvo(nomeAtributo));
            }
        }
    }
}
