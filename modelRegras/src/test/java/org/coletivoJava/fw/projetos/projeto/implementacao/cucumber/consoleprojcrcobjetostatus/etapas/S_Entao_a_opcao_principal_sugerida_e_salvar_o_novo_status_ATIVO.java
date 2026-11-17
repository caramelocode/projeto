package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaStatusProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.ItemFabricaStatus;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetostatus.EtapasconsoleProjCRCObjetoStatus;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.FluxoConsoleObjetoStatus;
import org.junit.Assert;

public class S_Entao_a_opcao_principal_sugerida_e_salvar_o_novo_status_ATIVO {

    @Entao(EtapasconsoleProjCRCObjetoStatus.ENTAO_A_OPCAO_PRINCIPAL_SUGERIDA_E_SALVAR_O_NOVO_STATUS_ATIVO)
    public void implementacaoEtapa() {
        String nomeEnumEsperado = FluxoConsoleObjetoStatus.NOME_ENUM_STATUS_ATIVO;

        // ativo digitado em minúsculo deve virar ATIVO, como ItemFabricaStatus ainda não persistido
        ItemFabricaStatus statusACriar = FluxoConsoleObjetoStatus.getStatusDaOpcaoPrincipalDeCriacao(nomeEnumEsperado);

        Assert.assertTrue("O status a criar deveria pertencer a uma fábrica de status",
                statusACriar.getFabrica() instanceof FabricaStatusProjCRC);
    }
}
