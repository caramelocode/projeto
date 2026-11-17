package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetostatus.EtapasconsoleProjCRCObjetoStatus;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.FluxoConsoleObjetoStatus;
import org.junit.Assert;

public class G_Quando_o_usuario_executa_a_criacao_da_entidade_StatusCliente {

    @Quando(EtapasconsoleProjCRCObjetoStatus.QUANDO_O_USUARIO_EXECUTA_A_CRIACAO_DA_ENTIDADE_STATUSCLIENTE)
    public void implementacaoEtapa() {
        String nomeEntidade = FluxoConsoleObjetoStatus.NOME_ENTIDADE_STATUS_CLIENTE;

        FluxoConsoleObjetoStatus.executarOpcaoSelecionada(FluxoConsoleObjetoStatus.ACAO_SALVAR_ENTIDADE);

        // Após o sucesso o console recarrega o repositório
        ObjetoProjCRC entidadeCriada = FluxoConsoleObjetoStatus.CONSOLE.getRepositorio().getEntidadeExistente(nomeEntidade);
        Assert.assertNotNull("Falha executando a criação: a entidade " + nomeEntidade + " não está no repositório do console", entidadeCriada);
        Assert.assertNotNull("Falha executando a criação: a entidade " + nomeEntidade + " não foi persistida", entidadeCriada.getId());
    }
}
