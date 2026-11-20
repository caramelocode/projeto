package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.objeto.FabAcaoCarameloDevEdicaoItemProj;
import br.org.carameloCode.erp.modulo.projeto.config.ConfigPersistenciaProjetoCaramelo;
import br.org.carameloCode.erp.modulo.projeto.console.ConsoleCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.console.ItemOpcaoConsole;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaEntidadeProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaStatusProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.ItemFabrica;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.ItemFabricaStatus;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.UtilProjCRCNomeFabrica;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.carameloCode.projeto.configAppp.ConfigCoreProjetoCRC;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.SBPersistencia;
import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import cucumber.api.CucumberOptions;
import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.runner.RunWith;
import testesFW.cucumber.CucumberSBTestes;
import testesFW.cucumber.TesteIntegracaoFuncionalidadeCucumber;

/**
 * Criação de uma fábrica de entidade estática (FABRICA_ENTIDADE_GENERICA) e dos
 * seus itens pelo console.
 *
 * FabTipoCliente -> salvar fábrica (FABRICA_GENERICA_CTR_SALVAR_MERGE)
 *
 * FabTipoCliente.clienteVip -> salvar item CLIENTE_VIP
 * (ITEM_FABRICA_GENERICA_CTR_SALVAR_MERGE)
 *
 * FabTipoCliente.CLIENTE_PADRAO -> salvar item CLIENTE_PADRAO
 *
 * FabTipoCliente. -> autocompletar sugere os itens criados
 *
 * Parte do resultado final do FluxoConsoleAcoes (entidade Cliente e ações).
 *
 * @author sfurbino
 */
@RunWith(CucumberSBTestes.class)
@CucumberOptions(features = "classpath:caracteristicas/console/consoleProjCRCFabEntidadeEstatica", tags = "@consoleProjCRCFabEntidadeEstatica",
        glue = "org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcfabentidadeestatica.etapas",
        monochrome = false, dryRun = false)
public class FluxoConsoleFabEntidadeEstatica extends TesteIntegracaoFuncionalidadeCucumber {

    // Sessão
    public static final String EMAIL_USUARIO_ADMIN = "salvio@caramelocode.com.br";
    public static final String SENHA_ADMIN = "123";

    // Console e entidades de controle
    public static final ConsoleCRCProjeto CONSOLE = new ConsoleCRCProjeto();
    public static ProjetoCRC projeto;
    public static List<String> sugestoesAutocompletar;

    // Entidade gerada pelos fluxos anteriores
    public static final String NOME_ENTIDADE_CLIENTE = "Cliente";

    // Fábrica e itens
    public static final String NOME_FABRICA_TIPO_CLIENTE = "FabTipoCliente";
    public static final FabTipoItemProjeto TIPO_FABRICA = FabTipoItemProjeto.FABRICA_ENTIDADE_GENERICA;

    public static final String NOME_ENUM_CLIENTE_VIP = "CLIENTE_VIP";
    public static final String NOME_ENUM_CLIENTE_PADRAO = "CLIENTE_PADRAO";
    public static final long ID_OBJETO_CLIENTE_VIP = 1L;
    public static final long ID_OBJETO_CLIENTE_PADRAO = 2L;

    // Ações esperadas nas opções do console
    public static final FabAcaoCarameloDevEdicaoItemProj ACAO_SALVAR_FABRICA = FabAcaoCarameloDevEdicaoItemProj.FABRICA_GENERICA_CTR_SALVAR_MERGE;
    public static final FabAcaoCarameloDevEdicaoItemProj ACAO_SALVAR_ITEM = FabAcaoCarameloDevEdicaoItemProj.ITEM_FABRICA_GENERICA_CTR_SALVAR_MERGE;

    // Textos digitados no console
    /**
     * FabTipoCliente
     */
    public static final String TEXTO_FABRICA_TIPO_CLIENTE = NOME_FABRICA_TIPO_CLIENTE;
    /**
     * FabTipoCliente.clienteVip (camelCase, convertido para CLIENTE_VIP)
     */
    public static final String TEXTO_ITEM_CLIENTE_VIP = getTextoItem("clienteVip");
    /**
     * FabTipoCliente.CLIENTE_PADRAO (já no formato do enum)
     */
    public static final String TEXTO_ITEM_CLIENTE_PADRAO = getTextoItem(NOME_ENUM_CLIENTE_PADRAO);
    /**
     * FabTipoCliente.
     */
    public static final String TEXTO_FABRICA_COM_PONTO = getTextoItem("");

    /**
     * Monta o texto digitado no console: nome da fábrica + ponto + nome do
     * item.
     */
    public static String getTextoItem(String pNomeItem) {
        return UtilProjCRCNomeFabrica.getTextoItem(NOME_FABRICA_TIPO_CLIENTE, pNomeItem);
    }

    /**
     * Digita o texto no console e guarda as sugestões do autocompletar.
     */
    public static void digitarNoConsole(String pTextoDigitado) {
        sugestoesAutocompletar = CONSOLE.autocompletProjeto(pTextoDigitado);
        Assert.assertNotNull("O autocompletar não retornou sugestões para " + pTextoDigitado, sugestoesAutocompletar);
    }

    /**
     * Confere que a opção principal sugerida é salvar um item novo, ainda não
     * persistido, na fábrica FabTipoCliente.
     *
     * @return o item a criar
     */
    public static ItemFabrica getItemDaOpcaoPrincipalDeCriacao(String pNomeEnum) {
        ItemOpcaoConsole opcao = CONSOLE.getOpcaoPrincipalSugerida();
        Assert.assertNotNull("Nenhuma opção principal sugerida para o item " + pNomeEnum, opcao);
        Assert.assertEquals("A opção principal deveria ser salvar o item", ACAO_SALVAR_ITEM, opcao.getFabAcaoCriarItem());
        Assert.assertTrue("O item associado deveria ser um item de fábrica",
                opcao.getItemAssociado() instanceof ItemFabrica);
        Assert.assertFalse("O item associado não deveria ser um item de status",
                opcao.getItemAssociado() instanceof ItemFabricaStatus);
        ItemFabrica item = (ItemFabrica) opcao.getItemAssociado();
        Assert.assertEquals("Nome do enum do item a criar incorreto", pNomeEnum, item.getNomeEnum());
        Assert.assertNull("O item a criar não deveria estar persistido", item.getId());
        Assert.assertNotNull("O item a criar deveria pertencer a uma fábrica", item.getFabrica());
        Assert.assertEquals("Fábrica do item incorreta", NOME_FABRICA_TIPO_CLIENTE, item.getFabrica().getNomeFabrica());
        return item;
    }

    /**
     * Confere que a opção selecionada é a ação esperada e a executa.
     */
    public static void executarOpcaoSelecionada(FabAcaoCarameloDevEdicaoItemProj pAcaoEsperada) {
        Assert.assertNotNull("Nenhuma opção selecionada para executar", CONSOLE.getOpcaoSelecionada());
        Assert.assertEquals("A opção selecionada deveria ser " + pAcaoEsperada,
                pAcaoEsperada, CONSOLE.getOpcaoSelecionada().getFabAcaoCriarItem());
        CONSOLE.executarOpcaoSelecionada();
    }

    /**
     * Fábrica FabTipoCliente no repositório do console (recarregado após a
     * execução).
     */
    public static FabricaEntidadeProjCRC getFabricaDoRepositorio() {
        FabricaEntidadeProjCRC fabrica = CONSOLE.getRepositorio().getFabricaExistente(NOME_FABRICA_TIPO_CLIENTE);
        Assert.assertNotNull("A fábrica " + NOME_FABRICA_TIPO_CLIENTE + " não está no repositório do console", fabrica);
        return fabrica;
    }

    /**
     * Fábrica do projeto com o nome informado, recarregada pelo EntityManager
     * de teste, ou vazio se não existir.
     */
    public static Optional<FabricaEntidadeProjCRC> getFabricaSalvaNoProjeto(String pNomeFabrica) {
        renovarConexaoEntityManagerEscopoTeste();
        ProjetoCRC projetoSalvo = UtilSBPersistencia.loadEntidade(projeto, getEM());
        Assert.assertNotNull("Projeto não encontrado", projetoSalvo);
        Assert.assertNotNull("Lista de fábricas do projeto não carregada", projetoSalvo.getFabricas());
        return projetoSalvo.getFabricas().stream()
                .filter(fab -> pNomeFabrica.equals(fab.getNomeFabrica()))
                .findFirst();
    }

    /**
     * Confere que a fábrica FabTipoCliente foi salva no projeto como fábrica
     * genérica.
     *
     * @return a fábrica salva
     */
    public static FabricaEntidadeProjCRC verificarFabricaSalva() {
        Optional<FabricaEntidadeProjCRC> fabrica = getFabricaSalvaNoProjeto(NOME_FABRICA_TIPO_CLIENTE);
        Assert.assertTrue("A fábrica " + NOME_FABRICA_TIPO_CLIENTE + " não foi salva no projeto", fabrica.isPresent());
        Assert.assertNotNull("A fábrica deveria estar persistida", fabrica.get().getId());
        Assert.assertFalse("A fábrica não deveria ter sido salva como fábrica de status",
                fabrica.get() instanceof FabricaStatusProjCRC);
        Assert.assertEquals("Tipo salvo da fábrica incorreto", TIPO_FABRICA, fabrica.get().getTipoItemProjeto());
        return fabrica.get();
    }

    /**
     * Confere que o item foi salvo em FabTipoCliente com o idObjeto esperado.
     *
     * @return o item salvo
     */
    public static ItemFabrica verificarItemSalvo(String pNomeEnum, long pIdObjeto) {
        FabricaEntidadeProjCRC fabrica = verificarFabricaSalva();
        Assert.assertNotNull("Itens da fábrica " + NOME_FABRICA_TIPO_CLIENTE + " não carregados", fabrica.getItens());
        Optional<ItemFabrica> item = fabrica.getItens().stream()
                .filter(it -> pNomeEnum.equals(it.getNomeEnum()))
                .findFirst();
        Assert.assertTrue("O item " + pNomeEnum + " não foi salvo em " + NOME_FABRICA_TIPO_CLIENTE, item.isPresent());
        Assert.assertNotNull("O item " + pNomeEnum + " deveria estar persistido", item.get().getId());
        Assert.assertFalse("O item " + pNomeEnum + " não deveria ser um item de status",
                item.get() instanceof ItemFabricaStatus);
        Assert.assertEquals("idObjeto do item " + pNomeEnum + " incorreto", Long.valueOf(pIdObjeto), item.get().getIdObjeto());
        Assert.assertEquals("Nome do objeto do item " + pNomeEnum + " incorreto",
                ItemFabrica.getNomeObjetoPorTexto(pNomeEnum), item.get().getNomeObjeto());
        return item.get();
    }

    @Override
    protected void configAmbienteDesevolvimento() {

        SBCore.configurar(new ConfigCoreProjetoCRC(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        SBPersistencia.configuraJPA(new ConfigPersistenciaProjetoCaramelo(), true, false);

    }

}
