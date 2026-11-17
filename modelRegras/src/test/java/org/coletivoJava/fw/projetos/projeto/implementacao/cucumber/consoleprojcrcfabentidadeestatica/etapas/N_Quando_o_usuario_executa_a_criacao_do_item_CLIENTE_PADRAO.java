package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaEntidadeProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.ItemFabrica;
import cucumber.api.java.pt.Quando;
import java.util.Optional;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcfabentidadeestatica.EtapasconsoleProjCRCFabEntidadeEstatica;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.FluxoConsoleFabEntidadeEstatica;
import org.junit.Assert;

public class N_Quando_o_usuario_executa_a_criacao_do_item_CLIENTE_PADRAO {

    @Quando(EtapasconsoleProjCRCFabEntidadeEstatica.QUANDO_O_USUARIO_EXECUTA_A_CRIACAO_DO_ITEM_CLIENTE_PADRAO)
    public void implementacaoEtapa() {
        String nomeEnum = FluxoConsoleFabEntidadeEstatica.NOME_ENUM_CLIENTE_PADRAO;

        FluxoConsoleFabEntidadeEstatica.executarOpcaoSelecionada(FluxoConsoleFabEntidadeEstatica.ACAO_SALVAR_ITEM);

        // Após o sucesso o console recarrega o repositório
        FabricaEntidadeProjCRC fabrica = FluxoConsoleFabEntidadeEstatica.getFabricaDoRepositorio();
        Assert.assertNotNull("Itens da fábrica " + fabrica.getNomeFabrica() + " não carregados no repositório", fabrica.getItens());

        Optional<ItemFabrica> itemCriado = fabrica.getItens().stream()
                .filter(item -> nomeEnum.equals(item.getNomeEnum()))
                .findFirst();
        Assert.assertTrue("Falha executando a criação: o item " + nomeEnum + " não está no repositório do console", itemCriado.isPresent());
        Assert.assertNotNull("Falha executando a criação: o item " + nomeEnum + " não foi persistido", itemCriado.get().getId());
    }
}
