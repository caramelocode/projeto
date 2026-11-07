package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoCRCProjSecundaria;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRC;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;
import org.junit.Assert;

public class AT_todas_as_acoes_de_Cliente_pertencem_a_FabAcaoGerente_o_CLIENTE_MB_GESTAO {

    @E(EtapasconsoleProjCRCAcoes.E_TODAS_AS_ACOES_DE_CLIENTE_PERTENCEM_A_FABACAOGERENTE_O_CLIENTE_MB_GESTAO)
    public void implementacaoEtapa() {
        Long idGestao = FluxoConsoleAcoes.acaoGestaoCliente.getId();
        for (String acaoCliente : FluxoConsoleAcoes.ACOES_CLIENTE) {
            String nomeUnico = FluxoConsoleAcoes.getNomeUnico(FluxoConsoleAcoes.FABRICA_GERENTE, acaoCliente);
            AcaoProjCRC acao = FluxoConsoleAcoes.getAcaoSalvaNoProjeto(nomeUnico);
            if (acao.getId().equals(idGestao)) {
                continue;
            }
            Assert.assertTrue("A ação " + nomeUnico + " deveria ser uma ação secundária", acao instanceof AcaoCRCProjSecundaria);
            AcaoCRCProjSecundaria secundaria = (AcaoCRCProjSecundaria) acao;
            Assert.assertNotNull("A ação " + nomeUnico + " não está vinculada a uma gestão", secundaria.getAcaoGestao());
            Assert.assertEquals("A ação " + nomeUnico + " pertence a outra gestão", idGestao, secundaria.getAcaoGestao().getId());
            Assert.assertEquals("A ação " + nomeUnico + " está em outro módulo",
                    FluxoConsoleAcoes.acaoGestaoCliente.getModulo().getId(), acao.getModulo().getId());
        }
    }
}
