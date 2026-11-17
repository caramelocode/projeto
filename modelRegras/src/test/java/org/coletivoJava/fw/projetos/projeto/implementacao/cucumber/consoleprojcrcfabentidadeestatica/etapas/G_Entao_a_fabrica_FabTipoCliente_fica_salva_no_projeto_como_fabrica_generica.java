package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaEntidadeProjCRC;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcfabentidadeestatica.EtapasconsoleProjCRCFabEntidadeEstatica;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.FluxoConsoleFabEntidadeEstatica;
import org.junit.Assert;

public class G_Entao_a_fabrica_FabTipoCliente_fica_salva_no_projeto_como_fabrica_generica {

    @Entao(EtapasconsoleProjCRCFabEntidadeEstatica.ENTAO_A_FABRICA_FABTIPOCLIENTE_FICA_SALVA_NO_PROJETO_COMO_FABRICA_GENERICA)
    public void implementacaoEtapa() {
        // Recarrega do banco e confere persistência e tipo genérico
        FabricaEntidadeProjCRC fabricaSalva = FluxoConsoleFabEntidadeEstatica.verificarFabricaSalva();

        Assert.assertEquals("Nome da fábrica salva incorreto",
                FluxoConsoleFabEntidadeEstatica.NOME_FABRICA_TIPO_CLIENTE, fabricaSalva.getNomeFabrica());

        boolean semItens = fabricaSalva.getItens() == null || fabricaSalva.getItens().isEmpty();
        Assert.assertTrue("A fábrica recém-criada não deveria possuir itens", semItens);
    }
}
