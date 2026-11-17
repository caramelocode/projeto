package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.ItemFabricaStatus;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetostatus.EtapasconsoleProjCRCObjetoStatus;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.FluxoConsoleObjetoStatus;
import org.junit.Assert;

public class AB_Quando_o_usuario_executa_a_criacao_do_status_INADIMPLENTE {

    @Quando(EtapasconsoleProjCRCObjetoStatus.QUANDO_O_USUARIO_EXECUTA_A_CRIACAO_DO_STATUS_INADIMPLENTE)
    public void implementacaoEtapa() {
        String nomeEnum = FluxoConsoleObjetoStatus.NOME_ENUM_STATUS_INADIMPLENTE;

        FluxoConsoleObjetoStatus.executarOpcaoSelecionada(FluxoConsoleObjetoStatus.ACAO_SALVAR_STATUS);

        // Após o sucesso o console recarrega o repositório
        ItemFabricaStatus statusCriado = FluxoConsoleObjetoStatus.getStatusDoRepositorio(nomeEnum);
        Assert.assertEquals("Nome do enum do status criado incorreto", nomeEnum, statusCriado.getNomeEnum());
    }
}
