package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.etapas;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.entidade.FabAcaoCarameloDevComoItemProjeto;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetos.EtapasconsoleProjCRCObjetos;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;

public class H_Quando_o_usuario_executa_a_sugestao_principal {

    @Quando(EtapasconsoleProjCRCObjetos.QUANDO_O_USUARIO_EXECUTA_A_SUGESTAO_PRINCIPAL)
    public void implementacaoEtapa() {
        Assert.assertNotNull("Nenhuma opção selecionada para executar", FluxoConsoleObjetos.CONSOLE.getOpcaoSelecionada());
        Assert.assertEquals("A opção selecionada deveria ser a sugestão principal (criar entidade)",
                FabAcaoCarameloDevComoItemProjeto.ENTIDADE_CTR_SALVAR_NOVO, FluxoConsoleObjetos.CONSOLE.getOpcaoSelecionada().getFabAcaoAssociada());

        FluxoConsoleObjetos.CONSOLE.executarOpcaoSelecionada();

        Assert.assertTrue("Falha executando a sugestão principal: a entidade não foi registrada no repositório do console",
                FluxoConsoleObjetos.CONSOLE.getRepositorio().isEntidadeExiste(FluxoConsoleObjetos.NOME_ENTIDADE_CLIENTE));
    }
}
