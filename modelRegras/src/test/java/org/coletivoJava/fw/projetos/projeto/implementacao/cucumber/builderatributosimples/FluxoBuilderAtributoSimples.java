package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributosimples;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.entidade.FabAcaoCarameloDevComoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadesimples.CPAtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.config.ConfigPersistenciaProjetoCaramelo;
import br.org.carameloCode.erp.modulo.projeto.console.ConsoleCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.console.ItemOpcaoConsole;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoInstanciaAtributoProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.carameloCode.projeto.configAppp.ConfigCoreProjetoCRC;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.SBPersistencia;
import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import cucumber.api.CucumberOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;
import org.junit.runner.RunWith;
import testesFW.cucumber.CucumberSBTestes;
import testesFW.cucumber.TesteIntegracaoFuncionalidadeCucumber;

/**
 * Instanciação pelo console de atributos do tipo de instância ATRIBUTO_SIMPLES
 * (AtributoDeEntidadeSimples), definição automática do tipo pelo nome e
 * visibilidade dos campos do atributo de acordo com o tipo.
 *
 * Slug determinante: o texto Entidade ponto nomeAtributo sem nenhuma marcação
 * especial (getTextoDigitado).
 *
 * Parte dos dados gerados pelo FluxoConsoleObjetos: entidade Cliente com os
 * atributos id, nome e nomeCompleto.
 *
 * <h3>Etapas</h3>
 * <ul>
 * <li>A (Dado): carrega o resultado do FluxoConsoleObjetos, faz login, carrega
 * o console e preenche projeto e ENTIDADE_PROJ_CLIENTE. Confere que id e nome
 * já existem no Cliente (ATRIBUTOS_DO_FLUXO_ANTERIOR) e que os demais nomes de
 * NOMES_ATRIBUTO_POR_TIPO ainda não existem.</li>
 * <li>B (Quando): digita cada nome de NOMES_ATRIBUTO_POR_TIPO
 * (digitarAtributo). Nomes novos: a opção principal é criar um
 * AtributoDeEntidadeSimples. id e nome: a opção é editar o atributo
 * existente.</li>
 * <li>C (E): digita de novo cada nome, executa a opção selecionada e confere o
 * atributo no repositório do console. Para id e nome a opção é de formulário e
 * o console não executa nada.</li>
 * <li>D (Entao): recarrega o Cliente do banco (recarregarEntidadeCliente) e
 * confere id, classe e tipo de cada atributo salvo (getAtributoSalvo).</li>
 * <li>E: os nomes com tipo automático (getTipoDefinidoAutomaticamente:
 * ATRIBUTOS_DETECTADOS_PELO_NOME e TIPOS_AUTODETECTAVEIS) foram salvos com o
 * tipo esperado.</li>
 * <li>F: a visibilidade dos campos de cada atributo salvo confere com o tipo
 * dele (verificarVisibilidadeCampos).</li>
 * <li>G (Quando): recarrega o Cliente e preenche ATRIBUTO_TIPO_MANUAL com os
 * atributos sem tipo automático.</li>
 * <li>H (E): define em memória, sem salvar, o tipo de NOMES_ATRIBUTO_POR_TIPO
 * (getTipoEsperado) em cada atributo de ATRIBUTO_TIPO_MANUAL, como o usuário
 * faz no formulário.</li>
 * <li>I (Entao): confere o tipo e a visibilidade dos campos dos atributos de
 * ATRIBUTO_TIPO_MANUAL.</li>
 * </ul>
 *
 * <h3>Notas</h3>
 * <ul>
 * <li>O console define o tipo do atributo novo pelo nome
 * (FabTipoInstanciaAtributoProjeto.ATRIBUTO_SIMPLES.getTipoPeloNome, sem diferenciar maiúsculas); sem
 * correspondência o tipo é TEXTO_SIMPLES. TIPOS_AUTODETECTAVEIS e
 * ATRIBUTOS_DETECTADOS_PELO_NOME precisam estar de acordo com essa regra.</li>
 * <li>Ao digitar, a opção é escolhida pelo nome declarado do item associado, e
 * não pela posição: com nomes que começam igual (data, dataHora, dataCriacao) o
 * console também oferece editar os demais.</li>
 * <li>TIPOS_COM_CAMPO_VISIVEL reproduz as regras das classes
 * ValorLogicoAtributoDeEntidadeSimples*. fraseValidacao não tem regra de
 * visibilidade e deve ficar visível em todos os tipos
 * (CAMPOS_VISIVEIS_COM_TIPO_DEFINIDO).</li>
 * <li>ObjetoProjCRC usa herança SINGLE_TABLE (discriminador tipoObjetoDB):
 * bancos salvos antes da criação de ObjetoStatusProjCRC precisam ser gerados de
 * novo.</li>
 * </ul>
 *
 * @author sfurbino
 */
@RunWith(CucumberSBTestes.class)
@CucumberOptions(features = "classpath:caracteristicas/atributo/builderAtributoSimples", tags = "@builderAtributoSimples",
        glue = "org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributosimples.etapas",
        monochrome = false, dryRun = false)
public class FluxoBuilderAtributoSimples extends TesteIntegracaoFuncionalidadeCucumber {

    // Sessão
    public static final String EMAIL_USUARIO_ADMIN = "salvio@caramelocode.com.br";
    public static final String SENHA_ADMIN = "123";

    // Console e entidades de controle
    public static final ConsoleCRCProjeto CONSOLE = new ConsoleCRCProjeto();
    public static ProjetoCRC projeto;
    public static ObjetoProjCRC ENTIDADE_PROJ_CLIENTE;

    public static final String NOME_ENTIDADE_CLIENTE = "Cliente";
    public static final String SEPARADOR_ATRIBUTO = ".";

    /**
     * Marcação no fim do texto digitado que determina o tipo de instância
     * (vazio quando o tipo é determinado pelo nome do atributo).
     */
    public static final String SUFIXO_SLUG = "";

    public static final FabTipoInstanciaAtributoProjeto TIPO_INSTANCIA = FabTipoInstanciaAtributoProjeto.ATRIBUTO_SIMPLES;

    /**
     * Atributos de NOMES_ATRIBUTO_POR_TIPO que já existem no Cliente gerado
     * pelo FluxoConsoleObjetos: o console oferece editar em vez de criar.
     */
    public static final List<String> ATRIBUTOS_DO_FLUXO_ANTERIOR = Collections.unmodifiableList(Arrays.asList(
            FluxoConsoleObjetos.NOME_ATRIBUTO_ID, FluxoConsoleObjetos.NOME_ATRIBUTO_NOME));

    /**
     * Atributos testados: tipo do atributo e nome usado no feature, na ordem do
     * feature.
     */
    public static final Map<FabTipoAtributoObjeto, String> NOMES_ATRIBUTO_POR_TIPO;

    /**
     * Nomes cujo tipo o console deve detectar sozinho.
     */
    public static final Map<String, FabTipoAtributoObjeto> TIPOS_AUTODETECTAVEIS;

    /**
     * Atributos salvos que precisam ter o tipo definido pelo usuário
     * (preenchido na etapa G).
     */
    public static final List<AtributoDeEntidadeSimples> ATRIBUTO_TIPO_MANUAL = new ArrayList<>();

    static {
        Map<FabTipoAtributoObjeto, String> NOMES = new LinkedHashMap<>();
        NOMES.put(FabTipoAtributoObjeto.NOME, "nome");
        NOMES.put(FabTipoAtributoObjeto.NOME_LONGO, "razaoSocial");
        NOMES.put(FabTipoAtributoObjeto.IMG_PEQUENA, "logo");
        NOMES.put(FabTipoAtributoObjeto.IMG_MEDIA, "logoHorizontal");
        NOMES.put(FabTipoAtributoObjeto.IMG_GRANDE, "banner");
        NOMES.put(FabTipoAtributoObjeto.DESCRITIVO, "descricao");
        NOMES.put(FabTipoAtributoObjeto.ID, "id");
        NOMES.put(FabTipoAtributoObjeto.QUANTIDADE, "qtdPedidos");
        NOMES.put(FabTipoAtributoObjeto.LATITUDE, "latitude");
        NOMES.put(FabTipoAtributoObjeto.LONGITUDE, "longitude");
        NOMES.put(FabTipoAtributoObjeto.LC_LOGRADOURO, "logradouro");
        NOMES.put(FabTipoAtributoObjeto.LCCEP, "cep");
        NOMES.put(FabTipoAtributoObjeto.SENHA, "senha");
        NOMES.put(FabTipoAtributoObjeto.SENHA_SEGURANCA_MAXIMA, "senhaMAx");
        NOMES.put(FabTipoAtributoObjeto.LC_COMPLEMENTO_E_NUMERO, "complementoNum");
        NOMES.put(FabTipoAtributoObjeto.LC_COMPLEMENTO, "complemento");
        NOMES.put(FabTipoAtributoObjeto.HTML, "apresentacaoCliente");
        NOMES.put(FabTipoAtributoObjeto.HTML_TEMPLATE, "modeloDocumento");
        NOMES.put(FabTipoAtributoObjeto.CHART_VALOR, "mediaPedidoMensal");
        NOMES.put(FabTipoAtributoObjeto.CHART_LABEL, "tituloGrafico");
        NOMES.put(FabTipoAtributoObjeto.CHART_CATEGORIA, "tituloLinhaGrafico");
        NOMES.put(FabTipoAtributoObjeto.DATAHORA, "dataHora");
        NOMES.put(FabTipoAtributoObjeto.DATA, "data");
        NOMES.put(FabTipoAtributoObjeto.HORA, "hora");
        NOMES.put(FabTipoAtributoObjeto.TELEFONE_FIXO_NACIONAL, "telefoneFixo");
        NOMES.put(FabTipoAtributoObjeto.TELEFONE_FIXO_INTERNACIONAL, "telefoneInternacional");
        NOMES.put(FabTipoAtributoObjeto.TELEFONE_CELULAR, "celular");
        NOMES.put(FabTipoAtributoObjeto.TELEFONE_GENERICO, "telefone");
        NOMES.put(FabTipoAtributoObjeto.MOEDA_REAL, "totalPedido");
        NOMES.put(FabTipoAtributoObjeto.MOEDA_DOLAR, "totalPedidoDollar");
        NOMES.put(FabTipoAtributoObjeto.PERCENTUAL, "percentualComissao");
        NOMES.put(FabTipoAtributoObjeto.TEXTO_SIMPLES, "campoTextoSimples");
        NOMES.put(FabTipoAtributoObjeto.VERDADEIRO_FALSO, "campoVerdadeiroFalso");
        NOMES.put(FabTipoAtributoObjeto.COR, "cor");
        NOMES.put(FabTipoAtributoObjeto.EMAIL, "campoEmail");
        NOMES.put(FabTipoAtributoObjeto.SITE, "campoSite");
        NOMES.put(FabTipoAtributoObjeto.URL, "campoUrl");
        NOMES.put(FabTipoAtributoObjeto.NOME_COMPLETO, "nomeResposavel");
        NOMES.put(FabTipoAtributoObjeto.CNPJ, "cnpj");
        NOMES.put(FabTipoAtributoObjeto.CPF, "cpf");
        NOMES.put(FabTipoAtributoObjeto.INSCRICAO_ESTADUAL, "inscricaoEstadual");
        NOMES.put(FabTipoAtributoObjeto.INSCRIACAO_MUNICIPAL, "inscricaoMunicipal");
        NOMES.put(FabTipoAtributoObjeto.REG_DATAALTERACAO, "dataEdicao");
        NOMES.put(FabTipoAtributoObjeto.REG_DATAINSERCAO, "dataCriacao");
        NOMES.put(FabTipoAtributoObjeto.REG_ATIVO_INATIVO, "ativo");
        NOMES.put(FabTipoAtributoObjeto.CODIGO_DE_BARRAS, "codigoDeBarras");
        NOMES.put(FabTipoAtributoObjeto.ICONE, "icone");
        NOMES.put(FabTipoAtributoObjeto.ARQUIVO_DE_ENTIDADE, "contrato");
        NOMES_ATRIBUTO_POR_TIPO = Collections.unmodifiableMap(NOMES);
        Map<String, FabTipoAtributoObjeto> tpauto = new LinkedHashMap<>();
        tpauto.put("nome", FabTipoAtributoObjeto.NOME);
        tpauto.put("logo", FabTipoAtributoObjeto.IMG_PEQUENA);
        tpauto.put("logoHorizontal", FabTipoAtributoObjeto.IMG_MEDIA);
        tpauto.put("descricao", FabTipoAtributoObjeto.DESCRITIVO);
        tpauto.put("id", FabTipoAtributoObjeto.ID);
        tpauto.put("qtdPedidos", FabTipoAtributoObjeto.QUANTIDADE);//porque começa com qtd
        tpauto.put("latitude", FabTipoAtributoObjeto.LATITUDE);
        tpauto.put("longitude", FabTipoAtributoObjeto.LONGITUDE);
        tpauto.put("cep", FabTipoAtributoObjeto.LCCEP);
        tpauto.put("senha", FabTipoAtributoObjeto.SENHA);
        tpauto.put("complemento", FabTipoAtributoObjeto.LC_COMPLEMENTO_E_NUMERO);
        tpauto.put("modeloDocumento", FabTipoAtributoObjeto.HTML_TEMPLATE);//porque tem a palavra modelo
        tpauto.put("dataHora", FabTipoAtributoObjeto.DATAHORA);//poque contem dataHora
        tpauto.put("data", FabTipoAtributoObjeto.DATA);// poruq contem data
        tpauto.put("hora", FabTipoAtributoObjeto.HORA);//porque contem hora
        tpauto.put("telefone", FabTipoAtributoObjeto.TELEFONE_GENERICO);
        tpauto.put("cor", FabTipoAtributoObjeto.COR);
        tpauto.put("email", FabTipoAtributoObjeto.EMAIL);
        tpauto.put("icone", FabTipoAtributoObjeto.ICONE);
        tpauto.put("nome", FabTipoAtributoObjeto.NOME);
        TIPOS_AUTODETECTAVEIS = Collections.unmodifiableMap(tpauto);
    }

    /**
     * Nomes reservados: o console detecta o tipo pelo nome e o atributo já vem
     * com o tipo definido.
     */
    public static final Map<String, FabTipoAtributoObjeto> ATRIBUTOS_DETECTADOS_PELO_NOME;

    static {
        Map<String, FabTipoAtributoObjeto> detectados = new LinkedHashMap<>();
        detectados.put("dataEdicao", FabTipoAtributoObjeto.REG_DATAALTERACAO);
        detectados.put("dataCriacao", FabTipoAtributoObjeto.REG_DATAINSERCAO);
        ATRIBUTOS_DETECTADOS_PELO_NOME = Collections.unmodifiableMap(detectados);
    }

    /**
     * Campos de AtributoDeEntidadeSimples cuja visibilidade depende do tipo,
     * com os tipos em que cada campo deve ficar visível. Em qualquer outro tipo
     * o campo deve ficar invisível.
     */
    public static final Map<String, List<FabTipoAtributoObjeto>> TIPOS_COM_CAMPO_VISIVEL;

    /**
     * Campos visíveis em qualquer tipo, desde que o tipo esteja definido.
     * fraseValidacao não tem regra de visibilidade: fica visível em todos.
     */
    public static final List<String> CAMPOS_VISIVEIS_COM_TIPO_DEFINIDO
            = Collections.unmodifiableList(Arrays.asList(CPAtributoDeEntidadeSimples.somenteleitura,
                    CPAtributoDeEntidadeSimples.frasevalidacao));

    static {
        List<FabTipoAtributoObjeto> verdadeiroFalso = Arrays.asList(
                FabTipoAtributoObjeto.REG_ATIVO_INATIVO, FabTipoAtributoObjeto.VERDADEIRO_FALSO);
        List<FabTipoAtributoObjeto> decimais = Arrays.asList(
                FabTipoAtributoObjeto.MOEDA_REAL, FabTipoAtributoObjeto.MOEDA_DOLAR, FabTipoAtributoObjeto.PERCENTUAL);
        List<FabTipoAtributoObjeto> valorMinimoMaximo = Arrays.asList(
                FabTipoAtributoObjeto.QUANTIDADE, FabTipoAtributoObjeto.MOEDA_REAL, FabTipoAtributoObjeto.MOEDA_DOLAR,
                FabTipoAtributoObjeto.PERCENTUAL, FabTipoAtributoObjeto.TEXTO_SIMPLES, FabTipoAtributoObjeto.NOME,
                FabTipoAtributoObjeto.NOME_COMPLETO, FabTipoAtributoObjeto.NOME_LONGO, FabTipoAtributoObjeto.DESCRITIVO,
                FabTipoAtributoObjeto.EMAIL, FabTipoAtributoObjeto.URL, FabTipoAtributoObjeto.SITE,
                FabTipoAtributoObjeto.SENHA, FabTipoAtributoObjeto.SENHA_SEGURANCA_MAXIMA);

        Map<String, List<FabTipoAtributoObjeto>> visiveis = new LinkedHashMap<>();
        visiveis.put(CPAtributoDeEntidadeSimples.textopositivo, verdadeiroFalso);
        visiveis.put(CPAtributoDeEntidadeSimples.textonegativo, verdadeiroFalso);
        visiveis.put(CPAtributoDeEntidadeSimples.iconepositivo, verdadeiroFalso);
        visiveis.put(CPAtributoDeEntidadeSimples.iconenegativo, verdadeiroFalso);
        visiveis.put(CPAtributoDeEntidadeSimples.numerodecasasdecimais, decimais);
        visiveis.put(CPAtributoDeEntidadeSimples.separadordecimal, decimais);
        visiveis.put(CPAtributoDeEntidadeSimples.separadormilhar, Arrays.asList(
                FabTipoAtributoObjeto.QUANTIDADE, FabTipoAtributoObjeto.MOEDA_REAL, FabTipoAtributoObjeto.MOEDA_DOLAR));
        visiveis.put(CPAtributoDeEntidadeSimples.valormaximo, valorMinimoMaximo);
        visiveis.put(CPAtributoDeEntidadeSimples.valorminimo, valorMinimoMaximo);
        visiveis.put(CPAtributoDeEntidadeSimples.mascarajquerymode, Arrays.asList(
                FabTipoAtributoObjeto.TEXTO_SIMPLES, FabTipoAtributoObjeto.CPF, FabTipoAtributoObjeto.CNPJ,
                FabTipoAtributoObjeto.INSCRICAO_ESTADUAL, FabTipoAtributoObjeto.INSCRIACAO_MUNICIPAL,
                FabTipoAtributoObjeto.CODIGO_DE_BARRAS, FabTipoAtributoObjeto.LCCEP,
                FabTipoAtributoObjeto.TELEFONE_GENERICO, FabTipoAtributoObjeto.TELEFONE_CELULAR,
                FabTipoAtributoObjeto.TELEFONE_FIXO_NACIONAL, FabTipoAtributoObjeto.TELEFONE_FIXO_INTERNACIONAL));
        visiveis.put(CPAtributoDeEntidadeSimples.validacaoregex, Arrays.asList(
                FabTipoAtributoObjeto.TEXTO_SIMPLES, FabTipoAtributoObjeto.NOME, FabTipoAtributoObjeto.NOME_COMPLETO,
                FabTipoAtributoObjeto.NOME_LONGO, FabTipoAtributoObjeto.EMAIL, FabTipoAtributoObjeto.URL,
                FabTipoAtributoObjeto.SITE, FabTipoAtributoObjeto.SENHA, FabTipoAtributoObjeto.SENHA_SEGURANCA_MAXIMA,
                FabTipoAtributoObjeto.CPF, FabTipoAtributoObjeto.CNPJ, FabTipoAtributoObjeto.INSCRICAO_ESTADUAL,
                FabTipoAtributoObjeto.INSCRIACAO_MUNICIPAL, FabTipoAtributoObjeto.CODIGO_DE_BARRAS,
                FabTipoAtributoObjeto.LCCEP, FabTipoAtributoObjeto.TELEFONE_GENERICO,
                FabTipoAtributoObjeto.TELEFONE_CELULAR, FabTipoAtributoObjeto.TELEFONE_FIXO_NACIONAL,
                FabTipoAtributoObjeto.TELEFONE_FIXO_INTERNACIONAL));
        visiveis.put(CPAtributoDeEntidadeSimples.umvalorcampounico, Arrays.asList(
                FabTipoAtributoObjeto.TEXTO_SIMPLES, FabTipoAtributoObjeto.NOME, FabTipoAtributoObjeto.NOME_COMPLETO,
                FabTipoAtributoObjeto.EMAIL, FabTipoAtributoObjeto.URL, FabTipoAtributoObjeto.SITE,
                FabTipoAtributoObjeto.CPF, FabTipoAtributoObjeto.CNPJ, FabTipoAtributoObjeto.INSCRICAO_ESTADUAL,
                FabTipoAtributoObjeto.INSCRIACAO_MUNICIPAL, FabTipoAtributoObjeto.CODIGO_DE_BARRAS,
                FabTipoAtributoObjeto.TELEFONE_GENERICO, FabTipoAtributoObjeto.TELEFONE_CELULAR,
                FabTipoAtributoObjeto.TELEFONE_FIXO_NACIONAL, FabTipoAtributoObjeto.TELEFONE_FIXO_INTERNACIONAL));
        visiveis.put(CPAtributoDeEntidadeSimples.umalistagemdinamica, Arrays.asList(
                FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA, FabTipoAtributoObjeto.LISTA_OBJETOS_PUBLICOS,
                FabTipoAtributoObjeto.LISTA_OBJETOS_PARTICULARES, FabTipoAtributoObjeto.ENUM_FABRICA,
                FabTipoAtributoObjeto.STATUS_ENUM));
        TIPOS_COM_CAMPO_VISIVEL = Collections.unmodifiableMap(visiveis);
    }

    /**
     * Texto digitado no console para o atributo: Cliente.nomeAtributo seguido
     * do sufixo do slug.
     */
    public static String getTextoDigitado(String pNomeAtributo) {
        return NOME_ENTIDADE_CLIENTE + SEPARADOR_ATRIBUTO + pNomeAtributo + SUFIXO_SLUG;
    }

    /**
     * Tipo esperado para o atributo, pelo nome usado no feature
     * (NOMES_ATRIBUTO_POR_TIPO).
     */
    public static FabTipoAtributoObjeto getTipoEsperado(String pNomeAtributo) {
        for (Map.Entry<FabTipoAtributoObjeto, String> nomePorTipo : NOMES_ATRIBUTO_POR_TIPO.entrySet()) {
            if (nomePorTipo.getValue().equals(pNomeAtributo)) {
                return nomePorTipo.getKey();
            }
        }
        Assert.fail("O atributo " + pNomeAtributo + " não é testado neste fluxo");
        return null;
    }

    /**
     * Tipo que o console deve definir sozinho a partir do nome: nomes
     * reservados (ATRIBUTOS_DETECTADOS_PELO_NOME) ou detectáveis
     * (TIPOS_AUTODETECTAVEIS). Null quando o tipo é definido pelo usuário.
     */
    public static FabTipoAtributoObjeto getTipoDefinidoAutomaticamente(String pNomeAtributo) {
        if (ATRIBUTOS_DETECTADOS_PELO_NOME.containsKey(pNomeAtributo)) {
            return ATRIBUTOS_DETECTADOS_PELO_NOME.get(pNomeAtributo);
        }
        return TIPOS_AUTODETECTAVEIS.get(pNomeAtributo);
    }

    public static boolean isTipoDefinidoAutomaticamente(String pNomeAtributo) {
        return getTipoDefinidoAutomaticamente(pNomeAtributo) != null;
    }

    /**
     * Digita Cliente.nomeAtributo no console e seleciona a opção cujo item é o
     * atributo com esse nome. Para atributos novos confere que é a opção
     * principal de criar um AtributoDeEntidadeSimples ainda não salvo; para os
     * de ATRIBUTOS_DO_FLUXO_ANTERIOR, que é a opção de editar o atributo salvo.
     */
    public static AtributoDeEntidadeSimples digitarAtributo(String pNomeAtributo) {
        String textoDigitado = getTextoDigitado(pNomeAtributo);
        CONSOLE.setTextoDefinido(textoDigitado);
        Optional<ItemOpcaoConsole> opcaoDoAtributo = CONSOLE.getOpcoesDisponiveis().stream()
                .filter(opcao -> opcao.getItemAssociado() instanceof AtributoDeEntidadeSimples
                && pNomeAtributo.equals(((AtributoDeEntidadeSimples) opcao.getItemAssociado()).getNomeDeclarado()))
                .findFirst();
        Assert.assertTrue("Nenhuma opção do console para o atributo " + textoDigitado, opcaoDoAtributo.isPresent());
        ItemOpcaoConsole opcao = opcaoDoAtributo.get();
        AtributoDeEntidadeSimples atributo = (AtributoDeEntidadeSimples) opcao.getItemAssociado();
        Assert.assertEquals("O console instanciou a classe errada para " + textoDigitado,
                TIPO_INSTANCIA.getClasse(), atributo.getClass());

        if (ATRIBUTOS_DO_FLUXO_ANTERIOR.contains(pNomeAtributo)) {
            Assert.assertEquals("Para o atributo existente " + textoDigitado + " a opção deveria ser editar",
                    FabAcaoCarameloDevComoItemProjeto.ATRIBUTO_ENTIDADE_FRM_EDITAR, opcao.getFabAcaoAssociada());
            Assert.assertNotNull("O atributo existente " + pNomeAtributo + " deveria ter id", atributo.getId());
        } else {
            Assert.assertSame("A opção de criar " + textoDigitado + " deveria ser a primeira opção sugerida",
                    CONSOLE.getOpcoesDisponiveis().get(0), opcao);
            Assert.assertEquals("A opção principal de " + textoDigitado + " deveria ser criar o atributo",
                    FabAcaoCarameloDevComoItemProjeto.ATRIBUTO_ENTIDADE_CTR_SALVAR_NOVO, opcao.getFabAcaoAssociada());
            Assert.assertNull("O atributo " + pNomeAtributo + " ainda não deveria estar salvo", atributo.getId());
        }
        CONSOLE.setOpcaoSelecionada(opcao);
        return atributo;
    }

    /**
     * Renova o EntityManager do teste, recarrega o projeto e a entidade Cliente
     * do banco (ENTIDADE_PROJ_CLIENTE).
     */
    public static ObjetoProjCRC recarregarEntidadeCliente() {
        renovarConexaoEntityManagerEscopoTeste();
        projeto = UtilSBPersistencia.loadEntidade(projeto, getEM());
        Assert.assertNotNull("Projeto não encontrado no banco", projeto);
        Assert.assertNotNull("Lista de entidades do projeto não carregada", projeto.getObjetos());
        Optional<ObjetoProjCRC> cliente = projeto.getObjetos().stream()
                .filter(obj -> NOME_ENTIDADE_CLIENTE.equals(obj.getNomeEntidade()))
                .findFirst();
        Assert.assertTrue("A entidade " + NOME_ENTIDADE_CLIENTE + " não existe no projeto", cliente.isPresent());
        ENTIDADE_PROJ_CLIENTE = cliente.get();
        Assert.assertNotNull("Lista de atributos de " + NOME_ENTIDADE_CLIENTE + " não carregada", ENTIDADE_PROJ_CLIENTE.getAtributos());
        return ENTIDADE_PROJ_CLIENTE;
    }

    public static boolean isAtributoSalvo(String pNomeAtributo) {
        return ENTIDADE_PROJ_CLIENTE.getAtributos().stream()
                .anyMatch(at -> pNomeAtributo.equals(at.getNomeDeclarado()));
    }

    /**
     * Atributo salvo na entidade Cliente carregada por
     * recarregarEntidadeCliente.
     */
    public static AtributoDeEntidadeSimples getAtributoSalvo(String pNomeAtributo) {
        Assert.assertNotNull("A entidade " + NOME_ENTIDADE_CLIENTE + " deveria estar carregada", ENTIDADE_PROJ_CLIENTE);
        Optional<AtributoDeEntidadeSimples> atributo = ENTIDADE_PROJ_CLIENTE.getAtributos().stream()
                .filter(at -> pNomeAtributo.equals(at.getNomeDeclarado()))
                .findFirst();
        Assert.assertTrue("O atributo " + pNomeAtributo + " não foi salvo na entidade " + NOME_ENTIDADE_CLIENTE, atributo.isPresent());
        return atributo.get();
    }

    /**
     * Confere a visibilidade de cada campo instanciado do atributo de acordo
     * com o tipo atual (TIPOS_COM_CAMPO_VISIVEL e
     * CAMPOS_VISIVEIS_COM_TIPO_DEFINIDO).
     */
    public static void verificarVisibilidadeCampos(AtributoDeEntidadeSimples pAtributo) {
        FabTipoAtributoObjeto tipo = pAtributo.getTipo();
        Assert.assertNotNull("O atributo " + pAtributo.getNomeDeclarado() + " está sem tipo", tipo);
        for (Map.Entry<String, List<FabTipoAtributoObjeto>> campo : TIPOS_COM_CAMPO_VISIVEL.entrySet()) {
            Assert.assertEquals("Visibilidade do campo " + campo.getKey() + " incorreta no atributo "
                    + pAtributo.getNomeDeclarado() + " do tipo " + tipo,
                    campo.getValue().contains(tipo), pAtributo.getCPinst(campo.getKey()).isVisivel());
        }
        for (String campo : CAMPOS_VISIVEIS_COM_TIPO_DEFINIDO) {
            Assert.assertTrue("O campo " + campo + " deveria estar visível no atributo "
                    + pAtributo.getNomeDeclarado() + " do tipo " + tipo,
                    pAtributo.getCPinst(campo).isVisivel());
        }
    }

    @Override
    protected void configAmbienteDesevolvimento() {

        SBCore.configurar(new ConfigCoreProjetoCRC(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        SBPersistencia.configuraJPA(new ConfigPersistenciaProjetoCaramelo(), true, true);

    }

}
