package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.acao.FabAcaoCarameloDevAcaoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.config.ConfigPersistenciaProjetoCaramelo;
import br.org.carameloCode.erp.modulo.projeto.console.ConsoleCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.console.ItemOpcaoConsole;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoCRCProjSecundaria;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.carameloCode.projeto.configAppp.ConfigCoreProjetoCRC;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.SBPersistencia;
import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.Controller.fabricas.FabTipoAcaoSistemaGenerica;
import cucumber.api.CucumberOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.junit.Assert;
import org.junit.runner.RunWith;
import testesFW.cucumber.CucumberSBTestes;
import testesFW.cucumber.TesteIntegracaoFuncionalidadeCucumber;

/**
 * Console de criação de ações a partir do nome da fábrica e do nome da ação.
 *
 * Formato: FabAcao[NomeModulo][NomeEntidade
 * opcional]_o_[NOME_ENTIDADE]_[TIPO_ACAO]_[DESCRICAO]
 *
 * Parte dos dados gerados pelo FluxoConsoleObjetos (entidade Cliente com seus
 * atributos).
 *
 * @author sfurbino
 */
@RunWith(CucumberSBTestes.class)
@CucumberOptions(features = "classpath:caracteristicas/console/consoleProjCRCAcoes", tags = "@consoleProjCRCAcoes",
        glue = "org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas",
        monochrome = false, dryRun = false)
public class FluxoConsoleAcoes extends TesteIntegracaoFuncionalidadeCucumber {

    // Sessão
    public static final String EMAIL_USUARIO_ADMIN = "salvio@caramelocode.com.br";
    public static final String SENHA_ADMIN = "123";

    // Console e entidades de controle
    public static final ConsoleCRCProjeto CONSOLE = new ConsoleCRCProjeto();
    public static ProjetoCRC projeto;
    public static AcaoProjCRC acaoGestaoCliente;
    public static List<AcaoProjCRC> acoesCliente = new ArrayList<>();
    public static List<String> sugestoesAutocompletar;

    // Partes do nome da fábrica
    public static final String PREFIXO_FABRICA = "FabAcao";
    public static final String NOME_MODULO_GERENTE = "Gerente";
    public static final String NOME_ENTIDADE_CLIENTE = "Cliente";
    public static final String SEPARADOR_FABRICA_ACAO = "_o_";
    public static final String SEPARADOR_PARTES_ACAO = "_";
    /**
     * Separador do nome único da ação: NomeDaFabrica.NOME_DA_ACAO
     */
    public static final String SEPARADOR_NOME_UNICO = ".";

    // Fábricas usadas no cenário
    public static final String FABRICA_GERENTE = PREFIXO_FABRICA + NOME_MODULO_GERENTE;
    public static final String FABRICA_GERENTE_CLIENTE = FABRICA_GERENTE + NOME_ENTIDADE_CLIENTE;
    public static final String FABRICA_CLIENTE = PREFIXO_FABRICA + NOME_ENTIDADE_CLIENTE;

    // Prefixo da entidade no nome da ação (NOME_ENTIDADE)
    public static final String ENTIDADE_ACAO_CLIENTE = "CLIENTE";
    public static final String ENTIDADE_ACAO_INEXISTENTE = "FORNECEDOR";

    // Tipos de ação sugeridos pelo autocompletar
    public static final String TIPO_ACAO_GESTAO = "_MB_";
    public static final String TIPO_ACAO_FORMULARIO = "_FRM_";
    public static final String TIPO_ACAO_CONTROLLER = "_CTR_";
    public static final List<String> TIPOS_ACAO = Collections.unmodifiableList(Arrays.asList(
            TIPO_ACAO_GESTAO, TIPO_ACAO_FORMULARIO, TIPO_ACAO_CONTROLLER));

    // Subtipos esperados no autocompletar
    public static final List<String> SUBTIPOS_FORMULARIO = Collections.unmodifiableList(Arrays.asList(
            "LISTAR", "EDITAR", "VISUALIZAR", "NOVO"));
    public static final List<String> SUBTIPOS_CONTROLLER = Collections.unmodifiableList(Arrays.asList(
            "SALVAR_MERGE", "ALTERAR_STATUS", "REMOVER"));

    // Ações de Cliente (parte depois do separador _o_)
    public static final String ACAO_CLIENTE_MB_GESTAO = "CLIENTE_MB_GESTAO";
    public static final String ACAO_CLIENTE_FRM_LISTAR = "CLIENTE_FRM_LISTAR";
    public static final String ACAO_CLIENTE_FRM_EDITAR = "CLIENTE_FRM_EDITAR";
    public static final String ACAO_CLIENTE_FRM_VISUALIZAR = "CLIENTE_FRM_VISUALIZAR";
    public static final String ACAO_CLIENTE_FRM_NOVO = "CLIENTE_FRM_NOVO";
    public static final String ACAO_CLIENTE_CTR_SALVAR_MERGE = "CLIENTE_CTR_SALVAR_MERGE";
    public static final String ACAO_CLIENTE_CTR_ALTERAR_STATUS = "CLIENTE_CTR_ALTERAR_STATUS";
    public static final String ACAO_CLIENTE_CTR_REMOVER = "CLIENTE_CTR_REMOVER";
    public static final String ACAO_CLIENTE_CTR_ACAO_TESTE_PERSONALIZADA = "CLIENTE_CTR_ACAO_TESTE_PERSONALIZADA";
    public static final String ACAO_FORNECEDOR_FRM_LISTAR = "FORNECEDOR_FRM_LISTAR";

    public static final List<String> ACOES_CLIENTE = Collections.unmodifiableList(Arrays.asList(
            ACAO_CLIENTE_MB_GESTAO,
            ACAO_CLIENTE_FRM_LISTAR,
            ACAO_CLIENTE_FRM_EDITAR,
            ACAO_CLIENTE_FRM_VISUALIZAR,
            ACAO_CLIENTE_FRM_NOVO,
            ACAO_CLIENTE_CTR_SALVAR_MERGE,
            ACAO_CLIENTE_CTR_ALTERAR_STATUS,
            ACAO_CLIENTE_CTR_REMOVER,
            ACAO_CLIENTE_CTR_ACAO_TESTE_PERSONALIZADA));

    public static final List<String> FORMULARIOS_CLIENTE = Collections.unmodifiableList(Arrays.asList(
            ACAO_CLIENTE_FRM_LISTAR,
            ACAO_CLIENTE_FRM_EDITAR,
            ACAO_CLIENTE_FRM_VISUALIZAR,
            ACAO_CLIENTE_FRM_NOVO));

    /**
     * Subtipos padrão que faltam depois de criar só a gestão (a ação
     * personalizada não é um subtipo padrão, por isso não é sugerida).
     */
    public static final List<String> ACOES_PENDENTES_APOS_GESTAO = Collections.unmodifiableList(Arrays.asList(
            ACAO_CLIENTE_FRM_LISTAR,
            ACAO_CLIENTE_FRM_EDITAR,
            ACAO_CLIENTE_FRM_VISUALIZAR,
            ACAO_CLIENTE_FRM_NOVO,
            ACAO_CLIENTE_CTR_SALVAR_MERGE,
            ACAO_CLIENTE_CTR_ALTERAR_STATUS,
            ACAO_CLIENTE_CTR_REMOVER));

    /**
     * Ações do console usadas para editar uma ação existente (formulário,
     * controller e gestão).
     */
    public static final List<FabAcaoCarameloDevAcaoProjCRC> ACOES_DE_EDICAO = Collections.unmodifiableList(Arrays.asList(
            FabAcaoCarameloDevAcaoProjCRC.ACOES_FRM_EDITAR_ACAO_FORMULARIO,
            FabAcaoCarameloDevAcaoProjCRC.ACOES_FRM_EDITAR_ACAO_CONTROLLER,
            FabAcaoCarameloDevAcaoProjCRC.ACOES_FRM_VISAO_GERAL));

    /**
     * Confere que todas as opções disponíveis são de edição de uma ação já
     * salva e devolve os nomes únicos dessas ações.
     */
    public static Set<String> getNomesUnicosDasOpcoesDeEdicao() {
        Set<String> nomesUnicos = new HashSet<>();
        for (ItemOpcaoConsole opcao : CONSOLE.getOpcoesDisponiveis()) {
            Assert.assertTrue("A opção " + opcao.getFabAcaoAssociada() + " não é uma opção de edição",
                    ACOES_DE_EDICAO.contains(opcao.getFabAcaoAssociada()));
            Assert.assertTrue("A opção de edição deveria estar associada a uma ação", opcao.getItemAssociado() instanceof AcaoProjCRC);
            AcaoProjCRC acao = (AcaoProjCRC) opcao.getItemAssociado();
            Assert.assertNotNull("A ação sugerida para edição deveria estar salva: " + acao.getNomeUnico(), acao.getId());
            nomesUnicos.add(acao.getNomeUnico());
        }
        return nomesUnicos;
    }

    /**
     * Nomes únicos das ações informadas na fábrica informada.
     */
    public static Set<String> getNomesUnicos(String pFabrica, List<String> pAcoes) {
        Set<String> nomesUnicos = new HashSet<>();
        pAcoes.forEach(acao -> nomesUnicos.add(getNomeUnico(pFabrica, acao)));
        return nomesUnicos;
    }

    /**
     * Confere, nas últimas sugestões do autocompletar, que todos os subtipos
     * pendentes da gestão de Cliente aparecem no formato da fábrica informada
     * e que a gestão, já criada, não aparece.
     */
    public static void verificarSubtiposPendentesDaGestaoCliente(String pFabrica) {
        for (String acaoPendente : ACOES_PENDENTES_APOS_GESTAO) {
            String sugestao = getTextoFabricaAcao(pFabrica, acaoPendente);
            Assert.assertTrue("O autocompletar não sugeriu o subtipo pendente " + sugestao + ": " + sugestoesAutocompletar,
                    sugestoesAutocompletar.contains(sugestao));
        }
        String gestao = getTextoFabricaAcao(pFabrica, ACAO_CLIENTE_MB_GESTAO);
        Assert.assertFalse("A gestão já foi criada e não deveria ser sugerida como pendente: " + gestao,
                sugestoesAutocompletar.contains(gestao));
    }

    /**
     * Monta o texto digitado no console: fábrica + separador _o_ + nome da ação (ou só
     * o prefixo da entidade).
     */
    public static String getTextoFabricaAcao(String pFabrica, String pAcao) {
        return pFabrica + SEPARADOR_FABRICA_ACAO + pAcao;
    }

    /**
     * Nome único da ação, como no framework: fábrica + ponto + nome da ação
     * (ex.: FabAcaoGerente.CLIENTE_FRM_LISTAR).
     */
    public static String getNomeUnico(String pFabrica, String pAcao) {
        return pFabrica + SEPARADOR_NOME_UNICO + pAcao;
    }

    /**
     * Digita a ação no console, confere que a opção selecionada é criá-la,
     * executa e confere que ela entrou no repositório do console.
     *
     * @return a ação registrada no repositório
     */
    public static AcaoProjCRC criarAcaoPeloConsole(String pFabrica, String pAcao) {
        String textoDigitado = getTextoFabricaAcao(pFabrica, pAcao);
        sugestoesAutocompletar = CONSOLE.autocompletProjeto(textoDigitado);
        Assert.assertNotNull("O autocompletar não retornou sugestões", sugestoesAutocompletar);
        getAcaoDaOpcaoPrincipalDeCriacao(pFabrica, pAcao);
        Assert.assertEquals("A opção selecionada deveria ser criar a ação", FabAcaoCarameloDevAcaoProjCRC.ACOES_CTR_SALVAR,
                CONSOLE.getOpcaoSelecionada().getFabAcaoAssociada());

        CONSOLE.executarOpcaoSelecionada();

        String nomeUnico = getNomeUnico(pFabrica, pAcao);
        AcaoProjCRC criada = CONSOLE.getRepositorio().getAcaoExistente(nomeUnico);
        Assert.assertNotNull("Falha executando a criação: a ação " + nomeUnico + " não foi registrada no repositório do console", criada);
        return criada;
    }

    /**
     * Recarrega o projeto pelo EntityManager de teste e devolve a ação salva
     * com o nome único informado.
     */
    public static AcaoProjCRC getAcaoSalvaNoProjeto(String pNomeUnico) {
        renovarConexaoEntityManagerEscopoTeste();
        ProjetoCRC projetoSalvo = UtilSBPersistencia.loadEntidade(projeto, getEM());
        Assert.assertNotNull("Projeto não encontrado", projetoSalvo);
        Assert.assertNotNull("Lista de ações do projeto não carregada", projetoSalvo.getAcoes());
        Optional<AcaoProjCRC> registrada = projetoSalvo.getAcoes().stream()
                .filter(acao -> pNomeUnico.equals(acao.getNomeUnico()))
                .findFirst();
        Assert.assertTrue("A ação " + pNomeUnico + " não foi salva no projeto", registrada.isPresent());
        return registrada.get();
    }

    /**
     * Confere uma ação secundária de Cliente salva no módulo Gerente: tipo da
     * entidade JPA, comportamento (ação genérica), módulo, entidade de domínio
     * e vínculo com a gestão de Cliente. Guarda a ação em acoesCliente.
     */
    public static AcaoProjCRC verificarAcaoSecundariaClienteRegistrada(String pAcao, Class<? extends AcaoCRCProjSecundaria> pTipoEsperado,
            FabTipoAcaoSistemaGenerica pComportamentoEsperado) {
        String nomeUnico = getNomeUnico(FABRICA_GERENTE, pAcao);
        AcaoProjCRC acao = getAcaoSalvaNoProjeto(nomeUnico);
        Assert.assertEquals("Tipo de ação salvo incorreto para " + nomeUnico, pTipoEsperado, acao.getClass());
        Assert.assertEquals("Comportamento (ação genérica) incorreto para " + nomeUnico, pComportamentoEsperado, acao.getTipoAcaoGenerica());
        Assert.assertNotNull("A ação deveria estar vinculada a um módulo", acao.getModulo());
        Assert.assertEquals("Nome do módulo incorreto", NOME_MODULO_GERENTE, acao.getModulo().getNome());
        Assert.assertNotNull("A ação deveria ter a entidade de domínio " + NOME_ENTIDADE_CLIENTE, acao.getEntidadeDominio());
        Assert.assertEquals("Entidade de domínio incorreta", NOME_ENTIDADE_CLIENTE, acao.getEntidadeDominio().getNomeEntidade());
        AcaoCRCProjSecundaria secundaria = (AcaoCRCProjSecundaria) acao;
        Assert.assertNotNull("A ação " + nomeUnico + " deveria estar vinculada à gestão de " + NOME_ENTIDADE_CLIENTE, secundaria.getAcaoGestao());
        Assert.assertEquals("Gestão vinculada incorreta", acaoGestaoCliente.getId(), secundaria.getAcaoGestao().getId());
        acoesCliente.removeIf(existente -> nomeUnico.equals(existente.getNomeUnico()));
        acoesCliente.add(acao);
        return acao;
    }

    /**
     * Confere que a opção principal sugerida é criar a ação digitada
     * (ACOES_CTR_SALVAR com uma AcaoProjCRC nova) e devolve essa ação.
     */
    public static AcaoProjCRC getAcaoDaOpcaoPrincipalDeCriacao(String pFabrica, String pAcao) {
        String pTextoDigitado = getTextoFabricaAcao(pFabrica, pAcao);
        ItemOpcaoConsole opcao = CONSOLE.getOpcaoPrincipalSugerida();
        Assert.assertNotNull("Nenhuma opção principal sugerida para " + pTextoDigitado, opcao);
        Assert.assertEquals("A opção principal deveria ser criar a ação", FabAcaoCarameloDevAcaoProjCRC.ACOES_CTR_SALVAR, opcao.getFabAcaoAssociada());
        Assert.assertTrue("A opção principal deveria estar associada a uma ação", opcao.getItemAssociado() instanceof AcaoProjCRC);
        AcaoProjCRC acao = (AcaoProjCRC) opcao.getItemAssociado();
        Assert.assertNull("A ação a criar não deveria estar persistida", acao.getId());
        Assert.assertEquals("Nome único da ação a criar incorreto", getNomeUnico(pFabrica, pAcao), acao.getNomeUnico());
        Assert.assertNotNull("A ação a criar deveria ter um módulo", acao.getModulo());
        return acao;
    }

    @Override
    protected void configAmbienteDesevolvimento() {

        SBCore.configurar(new ConfigCoreProjetoCRC(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        SBPersistencia.configuraJPA(new ConfigPersistenciaProjetoCaramelo(), true, true);

    }

}
