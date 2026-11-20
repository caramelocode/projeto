package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.etapas;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.objeto.FabAcaoCarameloDevEdicaoItemProj;
import br.org.carameloCode.erp.modulo.projeto.console.ItemOpcaoConsole;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetos.EtapasconsoleProjCRCObjetos;
import cucumber.api.java.pt.Entao;
import java.util.List;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;

public class K_Entao_as_opcoes_disponiveis_sao_criar_entidade_Cli_e_editar_entidade_Cliente {

    @Entao(EtapasconsoleProjCRCObjetos.ENTAO_AS_OPCOES_DISPONIVEIS_SAO_CRIAR_ENTIDADE_CLI_E_EDITAR_ENTIDADE_CLIENTE)
    public void implementacaoEtapa() {
        List<ItemOpcaoConsole> opcoes = FluxoConsoleObjetos.CONSOLE.getOpcoesDisponiveis();
        // criar Cli, editar Cliente e listar atributos de Cliente (verificado na etapa N)
        Assert.assertEquals("Quantidade de opções disponíveis incorreta", 3, opcoes.size());

        ItemOpcaoConsole opcaoCriar = opcoes.get(0);
        Assert.assertEquals("A primeira opção deveria ser criar entidade", FabAcaoCarameloDevEdicaoItemProj.ENTIDADE_CTR_SALVAR_NOVO, opcaoCriar.getFabAcaoCriarItem());
        Assert.assertTrue("A opção de criar deveria estar associada a uma entidade", opcaoCriar.getItemAssociado() instanceof ObjetoProjCRC);
        Assert.assertEquals("Nome da entidade a criar incorreto", FluxoConsoleObjetos.TEXTO_PARCIAL_CLI, ((ObjetoProjCRC) opcaoCriar.getItemAssociado()).getNomeEntidade());

        ItemOpcaoConsole opcaoEditar = opcoes.get(1);
        Assert.assertEquals("A segunda opção deveria ser editar entidade", FabAcaoCarameloDevEdicaoItemProj.ENTIDADE_FRM_EDITAR, opcaoEditar.getFabAcaoCriarItem());
        Assert.assertTrue("A opção de editar deveria estar associada a uma entidade", opcaoEditar.getItemAssociado() instanceof ObjetoProjCRC);
        Assert.assertEquals("Nome da entidade a editar incorreto", FluxoConsoleObjetos.NOME_ENTIDADE_CLIENTE, ((ObjetoProjCRC) opcaoEditar.getItemAssociado()).getNomeEntidade());
    }
}
