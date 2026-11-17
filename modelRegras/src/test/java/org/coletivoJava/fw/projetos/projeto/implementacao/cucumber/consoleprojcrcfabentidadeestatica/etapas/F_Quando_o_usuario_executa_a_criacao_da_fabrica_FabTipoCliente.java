package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaEntidadeProjCRC;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcfabentidadeestatica.EtapasconsoleProjCRCFabEntidadeEstatica;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.FluxoConsoleFabEntidadeEstatica;
import org.junit.Assert;

public class F_Quando_o_usuario_executa_a_criacao_da_fabrica_FabTipoCliente {

    @Quando(EtapasconsoleProjCRCFabEntidadeEstatica.QUANDO_O_USUARIO_EXECUTA_A_CRIACAO_DA_FABRICA_FABTIPOCLIENTE)
    public void implementacaoEtapa() {
        FluxoConsoleFabEntidadeEstatica.executarOpcaoSelecionada(FluxoConsoleFabEntidadeEstatica.ACAO_SALVAR_FABRICA);

        // Após o sucesso o console recarrega o repositório
        FabricaEntidadeProjCRC fabricaCriada = FluxoConsoleFabEntidadeEstatica.getFabricaDoRepositorio();
        Assert.assertNotNull("Falha executando a criação: a fábrica " + FluxoConsoleFabEntidadeEstatica.NOME_FABRICA_TIPO_CLIENTE
                + " não foi persistida", fabricaCriada.getId());
    }
}
