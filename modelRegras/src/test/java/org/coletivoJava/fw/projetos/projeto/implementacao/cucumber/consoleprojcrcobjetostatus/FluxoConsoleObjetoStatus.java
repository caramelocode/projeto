package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.objeto.FabAcaoCarameloDevEdicaoItemProj;
import br.org.carameloCode.erp.modulo.projeto.config.ConfigPersistenciaProjetoCaramelo;
import br.org.carameloCode.erp.modulo.projeto.console.ConsoleCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.console.ItemOpcaoConsole;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoStatusProjCRC;
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
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.runner.RunWith;
import testesFW.cucumber.CucumberSBTestes;
import testesFW.cucumber.TesteIntegracaoFuncionalidadeCucumber;

/**
 * Criação pelo console de uma entidade de status (ObjetoStatusProjCRC) e dos
 * itens da sua fábrica de status.
 *
 * <ul>
 * <li>StatusCliente → salvar entidade (ENTIDADE_CTR_SALVAR com um
 * ObjetoStatusProjCRC); o controller cria a FabStatusCliente sem itens e liga
 * entidade e fábrica nos dois sentidos.</li>
 * <li>FabStatusCliente → só editar (FABRICA_STATUS_FRM_EDITAR): fábrica de
 * status nasce da entidade, nunca pelo console. FabStatusPedido (sem entidade)
 * não oferece salvar nem é sugerida no autocompletar.</li>
 * <li>FabStatusCliente.ativo / .inativo / .inadimplente → salvar item
 * (ITEM_FABRICA_STATUS_CTR_SALVAR_MERGE) como ItemFabricaStatus, idObjeto 1, 2
 * e 3. Item já salvo só pode ser editado.</li>
 * <li>FabStatusCliente. → autocompletar sugere os status na ordem do
 * idObjeto.</li>
 * </ul>
 *
 * Diferenças em relação à fábrica genérica (FluxoConsoleFabEntidadeEstatica): a
 * fábrica é FabricaStatusProjCRC (tipo FABRICA_STATUS), os itens são
 * ItemFabricaStatus e a fábrica existe só vinculada à entidade de status.
 *
 * Parte do resultado do FluxoConsoleObjetos (entidade Cliente). O
 * FluxoBuilderAtributoEntidadeStatus e o FluxoBuilderAtributoEnumStatus partem
 * do resultado deste fluxo.
 *
 * <h3>Regras de negócio ainda pendentes</h3>
 * <ul>
 * <li>FabTipoItemProjeto não tem tipo para entidade de status: StatusCliente é
 * identificado como OBJETO e o console oferece um ObjetoProjCRC comum.</li>
 * <li>O controller não cria a FabStatusCliente ao salvar a entidade de
 * status.</li>
 * <li>O console ainda oferece FABRICA_STATUS_CTR_SALVAR_MERGE para fábricas de
 * status inexistentes (FabStatusPedido).</li>
 * </ul>
 *
 * Fábrica e entidade ficam ligadas por ObjetoStatusProjCRC.fabricaStatus
 * (@OneToOne, dono) e FabricaStatusProjCRC.entidadeStatus (mappedBy).
 *
 * @author sfurbino
 */
@RunWith(CucumberSBTestes.class)
@CucumberOptions(features = "classpath:caracteristicas/console/consoleProjCRCObjetoStatus", tags = "@consoleProjCRCObjetoStatus",
        glue = "org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.etapas",
        monochrome = false, dryRun = false)
public class FluxoConsoleObjetoStatus extends TesteIntegracaoFuncionalidadeCucumber {

    // Sessão
    public static final String EMAIL_USUARIO_ADMIN = "salvio@caramelocode.com.br";
    public static final String SENHA_ADMIN = "123";

    // Console e entidades de controle
    public static final ConsoleCRCProjeto CONSOLE = new ConsoleCRCProjeto();
    public static ProjetoCRC projeto;
    public static List<String> sugestoesAutocompletar;

    // Entidades
    public static final String NOME_ENTIDADE_CLIENTE = "Cliente";
    public static final String NOME_ENTIDADE_STATUS_CLIENTE = "StatusCliente";
    /**
     * FabTipoItemProjeto não tem tipo próprio para entidade de status:
     * StatusCliente é pesquisado como OBJETO e diferenciado pela classe do item
     * (ObjetoStatusProjCRC).
     */
    public static final FabTipoItemProjeto TIPO_PESQUISA_ENTIDADE_STATUS = FabTipoItemProjeto.OBJETO;

    // Fábricas
    public static final String NOME_FABRICA_STATUS_CLIENTE = "FabStatusCliente";
    public static final String NOME_FABRICA_STATUS_INEXISTENTE = "FabStatusPedido";
    public static final FabTipoItemProjeto TIPO_FABRICA = FabTipoItemProjeto.FABRICA_STATUS;

    // Status: nome digitado, nomeEnum esperado e idObjeto esperado
    public static final String NOME_STATUS_ATIVO = "ativo";
    public static final String NOME_STATUS_INATIVO = "inativo";
    public static final String NOME_STATUS_INADIMPLENTE = "inadimplente";
    public static final String NOME_ENUM_STATUS_ATIVO = "ATIVO";
    public static final String NOME_ENUM_STATUS_INATIVO = "INATIVO";
    public static final String NOME_ENUM_STATUS_INADIMPLENTE = "INADIMPLENTE";
    public static final long ID_OBJETO_STATUS_ATIVO = 1L;
    public static final long ID_OBJETO_STATUS_INATIVO = 2L;
    public static final long ID_OBJETO_STATUS_INADIMPLENTE = 3L;

    // Ações esperadas nas opções do console
    public static final FabAcaoCarameloDevEdicaoItemProj ACAO_SALVAR_ENTIDADE = FabAcaoCarameloDevEdicaoItemProj.ENTIDADE_CTR_SALVAR_NOVO;
    public static final FabAcaoCarameloDevEdicaoItemProj ACAO_SALVAR_FABRICA = FabAcaoCarameloDevEdicaoItemProj.FABRICA_STATUS_CTR_SALVAR_MERGE;
    public static final FabAcaoCarameloDevEdicaoItemProj ACAO_EDITAR_FABRICA = FabAcaoCarameloDevEdicaoItemProj.FABRICA_STATUS_FRM_EDITAR;
    public static final FabAcaoCarameloDevEdicaoItemProj ACAO_SALVAR_STATUS = FabAcaoCarameloDevEdicaoItemProj.ITEM_FABRICA_STATUS_CTR_SALVAR_MERGE;
    public static final FabAcaoCarameloDevEdicaoItemProj ACAO_EDITAR_STATUS = FabAcaoCarameloDevEdicaoItemProj.ITEM_FABRICA_STATUS_FRM_EDITAR;

    // Textos digitados no console
    public static final String TEXTO_ENTIDADE_STATUS_CLIENTE = NOME_ENTIDADE_STATUS_CLIENTE;
    public static final String TEXTO_FABRICA_STATUS_CLIENTE = NOME_FABRICA_STATUS_CLIENTE;
    public static final String TEXTO_FABRICA_STATUS_INEXISTENTE = NOME_FABRICA_STATUS_INEXISTENTE;
    /**
     * FabStatusCliente.ativo (minúsculo, convertido para ATIVO)
     */
    public static final String TEXTO_STATUS_ATIVO = getTextoStatus(NOME_STATUS_ATIVO);
    public static final String TEXTO_STATUS_INATIVO = getTextoStatus(NOME_STATUS_INATIVO);
    public static final String TEXTO_STATUS_INADIMPLENTE = getTextoStatus(NOME_STATUS_INADIMPLENTE);
    /**
     * FabStatusCliente.
     */
    public static final String TEXTO_FABRICA_COM_PONTO = getTextoStatus("");

    /**
     * Monta o texto digitado no console: FabStatusCliente + ponto + nome do
     * status.
     */
    public static String getTextoStatus(String pNomeStatus) {
        return UtilProjCRCNomeFabrica.getTextoItem(NOME_FABRICA_STATUS_CLIENTE, pNomeStatus);
    }

    /**
     * Digita o texto no console e guarda as sugestões do autocompletar.
     */
    public static void digitarNoConsole(String pTextoDigitado) {
        sugestoesAutocompletar = CONSOLE.autocompletProjeto(pTextoDigitado);
        Assert.assertNotNull("O autocompletar não retornou sugestões para " + pTextoDigitado, sugestoesAutocompletar);
    }

    /**
     * Opções disponíveis no console com a ação informada.
     */
    public static List<ItemOpcaoConsole> getOpcoesComAcao(FabAcaoCarameloDevEdicaoItemProj pAcao) {
        return CONSOLE.getOpcoesDisponiveis().stream()
                .filter(opcao -> pAcao.equals(opcao.getFabAcaoCriarItem()))
                .collect(Collectors.toList());
    }

    /**
     * Confere que a opção principal sugerida é salvar um status novo, ainda não
     * persistido, como ItemFabricaStatus da FabStatusCliente.
     *
     * @return o status a criar
     */
    public static ItemFabricaStatus getStatusDaOpcaoPrincipalDeCriacao(String pNomeEnum) {
        ItemOpcaoConsole opcao = CONSOLE.getOpcaoPrincipalSugerida();
        Assert.assertNotNull("Nenhuma opção principal sugerida para o status " + pNomeEnum, opcao);
        Assert.assertEquals("A opção principal deveria ser salvar o status", ACAO_SALVAR_STATUS, opcao.getFabAcaoCriarItem());
        Assert.assertTrue("O item associado deveria ser um item de status",
                opcao.getItemAssociado() instanceof ItemFabricaStatus);
        ItemFabricaStatus status = (ItemFabricaStatus) opcao.getItemAssociado();
        Assert.assertEquals("Nome do enum do status a criar incorreto", pNomeEnum, status.getNomeEnum());
        Assert.assertNull("O status a criar não deveria estar persistido", status.getId());
        Assert.assertNotNull("O status a criar deveria pertencer a uma fábrica", status.getFabrica());
        Assert.assertEquals("Fábrica do status incorreta", NOME_FABRICA_STATUS_CLIENTE, status.getFabrica().getNomeFabrica());
        return status;
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
     * FabStatusCliente no repositório do console (recarregado após a execução).
     */
    public static FabricaStatusProjCRC getFabricaStatusDoRepositorio() {
        FabricaEntidadeProjCRC fabrica = CONSOLE.getRepositorio().getFabricaExistente(NOME_FABRICA_STATUS_CLIENTE);
        Assert.assertNotNull("A fábrica " + NOME_FABRICA_STATUS_CLIENTE + " não está no repositório do console", fabrica);
        Assert.assertTrue("A fábrica " + NOME_FABRICA_STATUS_CLIENTE + " do repositório deveria ser uma fábrica de status",
                fabrica instanceof FabricaStatusProjCRC);
        return (FabricaStatusProjCRC) fabrica;
    }

    /**
     * Confere que o status está persistido na FabStatusCliente do repositório
     * do console (recarregado após a execução).
     *
     * @return o status do repositório
     */
    public static ItemFabricaStatus getStatusDoRepositorio(String pNomeEnum) {
        FabricaStatusProjCRC fabrica = getFabricaStatusDoRepositorio();
        Optional<ItemFabricaStatus> status = fabrica.getItensStatus().stream()
                .filter(it -> pNomeEnum.equals(it.getNomeEnum()))
                .findFirst();
        Assert.assertTrue("Falha executando a criação: o status " + pNomeEnum + " não está no repositório do console", status.isPresent());
        Assert.assertNotNull("Falha executando a criação: o status " + pNomeEnum + " não foi persistido", status.get().getId());
        return status.get();
    }

    /**
     * Projeto recarregado pelo EntityManager de teste.
     */
    private static ProjetoCRC recarregarProjeto() {
        renovarConexaoEntityManagerEscopoTeste();
        ProjetoCRC projetoSalvo = UtilSBPersistencia.loadEntidade(projeto, getEM());
        Assert.assertNotNull("Projeto não encontrado", projetoSalvo);
        return projetoSalvo;
    }

    /**
     * Entidade do projeto com o nome informado, recarregada do banco, ou vazio
     * se não existir.
     */
    public static Optional<ObjetoProjCRC> getEntidadeSalvaNoProjeto(String pNomeEntidade) {
        ProjetoCRC projetoSalvo = recarregarProjeto();
        Assert.assertNotNull("Lista de entidades do projeto não carregada", projetoSalvo.getObjetos());
        return projetoSalvo.getObjetos().stream()
                .filter(obj -> pNomeEntidade.equals(obj.getNomeEntidade()))
                .findFirst();
    }

    /**
     * Fábrica do projeto com o nome informado, recarregada do banco, ou vazio
     * se não existir.
     */
    public static Optional<FabricaEntidadeProjCRC> getFabricaSalvaNoProjeto(String pNomeFabrica) {
        ProjetoCRC projetoSalvo = recarregarProjeto();
        Assert.assertNotNull("Lista de fábricas do projeto não carregada", projetoSalvo.getFabricas());
        return projetoSalvo.getFabricas().stream()
                .filter(fab -> pNomeFabrica.equals(fab.getNomeFabrica()))
                .findFirst();
    }

    /**
     * Confere que StatusCliente foi salva no projeto como ObjetoStatusProjCRC.
     *
     * @return a entidade de status salva
     */
    public static ObjetoStatusProjCRC verificarEntidadeStatusSalva() {
        Optional<ObjetoProjCRC> entidade = getEntidadeSalvaNoProjeto(NOME_ENTIDADE_STATUS_CLIENTE);
        Assert.assertTrue("A entidade " + NOME_ENTIDADE_STATUS_CLIENTE + " não foi salva no projeto", entidade.isPresent());
        Assert.assertNotNull("A entidade " + NOME_ENTIDADE_STATUS_CLIENTE + " deveria estar persistida", entidade.get().getId());
        Assert.assertTrue("A entidade " + NOME_ENTIDADE_STATUS_CLIENTE + " deveria ter sido salva como ObjetoStatusProjCRC",
                entidade.get() instanceof ObjetoStatusProjCRC);
        return (ObjetoStatusProjCRC) entidade.get();
    }

    /**
     * Confere que FabStatusCliente foi salva no projeto como fábrica de status.
     *
     * @return a fábrica de status salva
     */
    public static FabricaStatusProjCRC verificarFabricaStatusSalva() {
        Optional<FabricaEntidadeProjCRC> fabrica = getFabricaSalvaNoProjeto(NOME_FABRICA_STATUS_CLIENTE);
        Assert.assertTrue("A fábrica " + NOME_FABRICA_STATUS_CLIENTE + " não foi salva no projeto", fabrica.isPresent());
        Assert.assertNotNull("A fábrica deveria estar persistida", fabrica.get().getId());
        Assert.assertTrue("A fábrica deveria ter sido salva como FabricaStatusProjCRC",
                fabrica.get() instanceof FabricaStatusProjCRC);
        Assert.assertEquals("Tipo salvo da fábrica incorreto", TIPO_FABRICA, fabrica.get().getTipoItemProjeto());
        return (FabricaStatusProjCRC) fabrica.get();
    }

    /**
     * Confere que o status foi salvo em FabStatusCliente, como
     * ItemFabricaStatus, com o idObjeto esperado.
     *
     * @return o status salvo
     */
    public static ItemFabricaStatus verificarStatusSalvo(String pNomeEnum, long pIdObjeto) {
        FabricaStatusProjCRC fabrica = verificarFabricaStatusSalva();
        Assert.assertNotNull("Itens da fábrica " + NOME_FABRICA_STATUS_CLIENTE + " não carregados", fabrica.getItens());
        Optional<ItemFabrica> item = fabrica.getItens().stream()
                .filter(it -> pNomeEnum.equals(it.getNomeEnum()))
                .findFirst();
        Assert.assertTrue("O status " + pNomeEnum + " não foi salvo em " + NOME_FABRICA_STATUS_CLIENTE, item.isPresent());
        Assert.assertNotNull("O status " + pNomeEnum + " deveria estar persistido", item.get().getId());
        Assert.assertTrue("O status " + pNomeEnum + " deveria ter sido salvo como ItemFabricaStatus",
                item.get() instanceof ItemFabricaStatus);
        Assert.assertEquals("idObjeto do status " + pNomeEnum + " incorreto", Long.valueOf(pIdObjeto), item.get().getIdObjeto());
        return (ItemFabricaStatus) item.get();
    }

    @Override
    protected void configAmbienteDesevolvimento() {

        SBCore.configurar(new ConfigCoreProjetoCRC(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        SBPersistencia.configuraJPA(new ConfigPersistenciaProjetoCaramelo(), true, true);

    }

}
