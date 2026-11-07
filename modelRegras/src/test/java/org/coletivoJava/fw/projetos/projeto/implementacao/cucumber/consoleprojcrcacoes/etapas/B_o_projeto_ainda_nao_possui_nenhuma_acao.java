package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import cucumber.api.java.pt.E;
import java.util.stream.Collectors;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;
import org.junit.Assert;

public class B_o_projeto_ainda_nao_possui_nenhuma_acao {

    @E(EtapasconsoleProjCRCAcoes.E_O_PROJETO_AINDA_NAO_POSSUI_NENHUMA_ACAO)
    public void implementacaoEtapa() {
        ProjetoCRC projeto = UtilSBPersistencia.loadEntidade(FluxoConsoleAcoes.projeto, FluxoConsoleAcoes.getEM());
        Assert.assertNotNull("Projeto não encontrado", projeto);
        Assert.assertTrue("O projeto não deveria possuir ações, encontradas: "
                + (projeto.getAcoes() == null ? "" : projeto.getAcoes().stream().map(AcaoProjCRC::getNomeUnico).collect(Collectors.toList())),
                projeto.getAcoes() == null || projeto.getAcoes().isEmpty());
        Assert.assertTrue("O repositório do console não deveria conter ações",
                FluxoConsoleAcoes.CONSOLE.getRepositorio().getLista3AcoesMaisParecidos(FluxoConsoleAcoes.PREFIXO_FABRICA).isEmpty());
    }
}
