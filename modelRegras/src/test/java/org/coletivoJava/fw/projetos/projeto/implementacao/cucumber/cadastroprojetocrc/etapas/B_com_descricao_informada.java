package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.cadastroprojetocrc.etapas;

import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.cadastroprojetocrc.EtapasCadastroProjetoCRC;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.cadastroprojetocrc.FluxoCadastroProjeto;
import org.junit.Assert;

public class B_com_descricao_informada {

    @E(EtapasCadastroProjetoCRC.E_COM_DESCRICAO_INFORMADA)
    public void implementacaoEtapa() {
        Assert.assertNotNull("Projeto não foi preparado na etapa anterior", FluxoCadastroProjeto.projeto);
        FluxoCadastroProjeto.projeto.setDescricao(FluxoCadastroProjeto.DESCRICAO_PROJETO);

        Assert.assertEquals("Descrição do projeto não informada", FluxoCadastroProjeto.DESCRICAO_PROJETO, FluxoCadastroProjeto.projeto.getDescricao());
    }
}
