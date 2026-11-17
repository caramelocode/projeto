package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import cucumber.api.java.pt.E;
import java.util.Optional;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetostatus.EtapasconsoleProjCRCObjetoStatus;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.FluxoConsoleObjetoStatus;
import org.junit.Assert;

public class B_o_projeto_ainda_nao_possui_a_entidade_StatusCliente {

    @E(EtapasconsoleProjCRCObjetoStatus.E_O_PROJETO_AINDA_NAO_POSSUI_A_ENTIDADE_STATUSCLIENTE)
    public void implementacaoEtapa() {
        String nomeEntidade = FluxoConsoleObjetoStatus.NOME_ENTIDADE_STATUS_CLIENTE;

        Optional<ObjetoProjCRC> entidadeNoBanco = FluxoConsoleObjetoStatus.getEntidadeSalvaNoProjeto(nomeEntidade);
        Assert.assertFalse("O projeto não deveria possuir a entidade " + nomeEntidade, entidadeNoBanco.isPresent());

        boolean entidadeNoRepositorio = FluxoConsoleObjetoStatus.CONSOLE.getRepositorio().isEntidadeExiste(nomeEntidade);
        Assert.assertFalse("O repositório do console não deveria conter a entidade " + nomeEntidade, entidadeNoRepositorio);
    }
}
