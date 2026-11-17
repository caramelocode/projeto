package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoentidade;

import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadesimples.CPAtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.config.ConfigPersistenciaProjetoCaramelo;
import br.org.carameloCode.erp.modulo.projeto.console.ConsoleCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.console.ItemOpcaoConsole;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoInstanciaAtributoProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeEntidade;
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
import org.junit.Assert;
import org.junit.runner.RunWith;
import testesFW.cucumber.CucumberSBTestes;
import testesFW.cucumber.TesteIntegracaoFuncionalidadeCucumber;

/**
 * Instanciação pelo console de atributos do tipo de instância
 * ATRIBUTO_ENTIDADE (AtributoEntidadeEntidade), tipo definido pelo nome
 * reservado e visibilidade dos campos de acordo com o tipo.
 *
 * Dois caminhos de instanciação (getTextoDigitado):
 * <ul>
 * <li>nomes reservados (ATRIBUTOS_DETECTADOS_PELO_NOME), digitados sem ponto
 * no final: Cliente.bairro, Cliente.uf...; o console define a classe e o tipo
 * pelo nome;</li>
 * <li>demais nomes (ATRIBUTOS_DEFINIDOS_PELO_USUARIO), digitados com ponto no
 * final: Cliente.clienteIndicou.; o console instancia com OBJETO_DE_UMA_LISTA e
 * a entidade referenciada deduzida pelo nome.</li>
 * </ul>
 *
 * Parte dos dados gerados pelo FluxoConsoleObjetos: entidade Cliente com os
 * atributos id, nome e nomeCompleto.
 *
 * <h3>Etapas</h3>
 * <ul>
 * <li>Dado: carrega o resultado do FluxoConsoleObjetos, faz login, carrega o
 * console, preenche projeto e ENTIDADE_PROJ_CLIENTE e confere que nenhum
 * atributo do fluxo existe no Cliente.</li>
 * <li>Quando / E: digita cada atributo (digitarAtributo) e executa a primeira
 * opção sugerida, conferindo o repositório do console.</li>
 * <li>Entao / E: recarrega o Cliente (recarregarEntidadeCliente) e confere a
 * classe salva (getAtributoEntidadeSalvo), o tipo dos nomes reservados, a
 * entidade referenciada de clienteIndicou e a visibilidade dos campos
 * (verificarVisibilidadeCampos).</li>
 * <li>Quando / E: preenche ATRIBUTO_TIPO_MANUAL com os atributos cujo tipo
 * esperado é diferente do tipo salvo e define em memória, sem salvar, o tipo
 * esperado (getTipoEsperado).</li>
 * <li>Entao / E: o tipo de cada atributo é o esperado e compatível com
 * AtributoEntidadeEntidade (getTiposCompativeis, ou seja,
 * FabTipoInstanciaAtributoProjeto.getTipoAtributo do tipo = ATRIBUTO_ENTIDADE),
 * e a visibilidade dos campos dos atributos de ATRIBUTO_TIPO_MANUAL.</li>
 * </ul>
 *
 * <h3>Notas</h3>
 * <ul>
 * <li>A classe e o tipo pelo nome reservado vêm de
 * FabTipoInstanciaAtributoProjeto (getTipoInstanciaPeloNome e
 * ATRIBUTO_ENTIDADE.getTipoPeloNome): ATRIBUTOS_DETECTADOS_PELO_NOME precisa
 * acompanhar TIPOS_POR_NOME_EXATO_ATRIBUTOS_ENTIDADE.</li>
 * <li>fraseValidacao e somenteLeitura ficam visíveis em todos os tipos
 * (CAMPOS_VISIVEIS_ATRIBUTO_ENTIDADE).</li>
 * </ul>
 *
 * @author sfurbino
 */
@RunWith(CucumberSBTestes.class)
@CucumberOptions(features = "classpath:caracteristicas/atributo/builderAtributoEntidade", tags = "@builderAtributoEntidade",
        glue = "org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoentidade.etapas",
        monochrome = false, dryRun = false)
public class FluxoBuilderAtributoEntidade extends TesteIntegracaoFuncionalidadeCucumber {

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
     * Marcação no fim do texto digitado que indica um AtributoEntidadeEntidade
     * cujo tipo não é detectado pelo nome (ex.: Cliente.clienteIndicou.).
     */
    public static final String SUFIXO_SLUG = ".";

    public static final FabTipoInstanciaAtributoProjeto TIPO_INSTANCIA = FabTipoInstanciaAtributoProjeto.ATRIBUTO_ENTIDADE;

    /**
     * Atributo que referencia a própria entidade Cliente (deduzida pelo nome).
     */
    public static final String NOME_ATRIBUTO_CLIENTE_INDICOU = "clienteIndicou";

    /**
     * Nomes reservados: o console define a classe e o tipo pelo nome. Digitados
     * sem o sufixo.
     */
    public static final Map<String, FabTipoAtributoObjeto> ATRIBUTOS_DETECTADOS_PELO_NOME;

    /**
     * Atributos digitados com o sufixo: o console instancia com
     * OBJETO_DE_UMA_LISTA e o usuário define o tipo esperado.
     */
    public static final Map<String, FabTipoAtributoObjeto> ATRIBUTOS_DEFINIDOS_PELO_USUARIO;

    static {
        Map<String, FabTipoAtributoObjeto> detectados = new LinkedHashMap<>();
        detectados.put("bairro", FabTipoAtributoObjeto.LC_BAIRRO);
        detectados.put("cidade", FabTipoAtributoObjeto.LC_CIDADE);
        detectados.put("uf", FabTipoAtributoObjeto.LC_UNIDADE_FEDERATIVA);
        detectados.put("unidadeFederativa", FabTipoAtributoObjeto.LC_UNIDADE_FEDERATIVA);
        detectados.put("localizacao", FabTipoAtributoObjeto.LC_LOCALIZACAO);
        detectados.put("usuarioEdicao", FabTipoAtributoObjeto.REG_USUARIO_ALTERACAO);
        detectados.put("usuarioCriacao", FabTipoAtributoObjeto.REG_USUARIO_INSERCAO);
        ATRIBUTOS_DETECTADOS_PELO_NOME = Collections.unmodifiableMap(detectados);

        Map<String, FabTipoAtributoObjeto> definidos = new LinkedHashMap<>();
        definidos.put(NOME_ATRIBUTO_CLIENTE_INDICOU, FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA);
        definidos.put("localidade", FabTipoAtributoObjeto.LC_LOCALIDADE);
        ATRIBUTOS_DEFINIDOS_PELO_USUARIO = Collections.unmodifiableMap(definidos);
    }

    /**
     * Atributos salvos cujo tipo o usuário precisa alterar (preenchido na
     * etapa Quando que lista os atributos).
     */
    public static final List<AtributoEntidadeEntidade> ATRIBUTO_TIPO_MANUAL = new ArrayList<>();

    /**
     * Campos de AtributoDeEntidadeSimples que não se aplicam a um
     * AtributoEntidadeEntidade: invisíveis em todos os tipos de
     * ATRIBUTO_ENTIDADE.
     */
    public static final List<String> CAMPOS_INVISIVEIS_ATRIBUTO_ENTIDADE = Collections.unmodifiableList(Arrays.asList(
            CPAtributoDeEntidadeSimples.valormaximo, CPAtributoDeEntidadeSimples.valorminimo,
            CPAtributoDeEntidadeSimples.validacaoregex, CPAtributoDeEntidadeSimples.numerodecasasdecimais,
            CPAtributoDeEntidadeSimples.mascarajquerymode, CPAtributoDeEntidadeSimples.iconepositivo,
            CPAtributoDeEntidadeSimples.textopositivo, CPAtributoDeEntidadeSimples.iconenegativo,
            CPAtributoDeEntidadeSimples.textonegativo));

    /**
     * Campos visíveis em todos os tipos de ATRIBUTO_ENTIDADE.
     */
    public static final List<String> CAMPOS_VISIVEIS_ATRIBUTO_ENTIDADE = Collections.unmodifiableList(Arrays.asList(
            CPAtributoDeEntidadeSimples.frasevalidacao, CPAtributoDeEntidadeSimples.somenteleitura));

    /**
     * Todos os atributos do fluxo, na ordem em que são digitados.
     */
    public static List<String> getNomesAtributos() {
        List<String> nomes = new ArrayList<>(ATRIBUTOS_DETECTADOS_PELO_NOME.keySet());
        nomes.addAll(ATRIBUTOS_DEFINIDOS_PELO_USUARIO.keySet());
        return nomes;
    }

    /**
     * Texto digitado no console: nomes reservados sem o sufixo, os demais com
     * o sufixo (Cliente.clienteIndicou.).
     */
    public static String getTextoDigitado(String pNomeAtributo) {
        String texto = NOME_ENTIDADE_CLIENTE + SEPARADOR_ATRIBUTO + pNomeAtributo;
        return ATRIBUTOS_DETECTADOS_PELO_NOME.containsKey(pNomeAtributo) ? texto : texto + SUFIXO_SLUG;
    }

    /**
     * Tipo esperado do atributo, detectado pelo nome ou definido pelo usuário.
     */
    public static FabTipoAtributoObjeto getTipoEsperado(String pNomeAtributo) {
        if (ATRIBUTOS_DETECTADOS_PELO_NOME.containsKey(pNomeAtributo)) {
            return ATRIBUTOS_DETECTADOS_PELO_NOME.get(pNomeAtributo);
        }
        Assert.assertTrue("O atributo " + pNomeAtributo + " não é testado neste fluxo",
                ATRIBUTOS_DEFINIDOS_PELO_USUARIO.containsKey(pNomeAtributo));
        return ATRIBUTOS_DEFINIDOS_PELO_USUARIO.get(pNomeAtributo);
    }

    /**
     * Tipos compatíveis com AtributoEntidadeEntidade: os tipos cuja instância
     * em FabTipoInstanciaAtributoProjeto é ATRIBUTO_ENTIDADE.
     */
    public static List<FabTipoAtributoObjeto> getTiposCompativeis() {
        return TIPO_INSTANCIA.getListaAtributosDisponiveis();
    }

    /**
     * Digita o atributo no console e seleciona a opção cujo item é o atributo
     * com esse nome; confere que é a primeira opção sugerida e que o atributo
     * ainda não está salvo. A classe instanciada é conferida depois de salvar.
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
        Assert.assertSame("A opção de criar " + textoDigitado + " deveria ser a primeira opção sugerida",
                CONSOLE.getOpcoesDisponiveis().get(0), opcao);
        AtributoDeEntidadeSimples atributo = (AtributoDeEntidadeSimples) opcao.getItemAssociado();
        Assert.assertNull("O atributo " + pNomeAtributo + " ainda não deveria estar salvo", atributo.getId());
        CONSOLE.setOpcaoSelecionada(opcao);
        return atributo;
    }

    /**
     * Renova o EntityManager do teste, recarrega o projeto e a entidade
     * Cliente do banco (ENTIDADE_PROJ_CLIENTE).
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
     * recarregarEntidadeCliente, conferindo que foi salvo como
     * AtributoEntidadeEntidade.
     */
    public static AtributoEntidadeEntidade getAtributoEntidadeSalvo(String pNomeAtributo) {
        Assert.assertNotNull("A entidade " + NOME_ENTIDADE_CLIENTE + " deveria estar carregada", ENTIDADE_PROJ_CLIENTE);
        Optional<AtributoDeEntidadeSimples> atributo = ENTIDADE_PROJ_CLIENTE.getAtributos().stream()
                .filter(at -> pNomeAtributo.equals(at.getNomeDeclarado()))
                .findFirst();
        Assert.assertTrue("O atributo " + pNomeAtributo + " não foi salvo na entidade " + NOME_ENTIDADE_CLIENTE, atributo.isPresent());
        Assert.assertEquals("Classe do atributo " + pNomeAtributo + " salvo incorreta",
                TIPO_INSTANCIA.getClasse(), atributo.get().getClass());
        return (AtributoEntidadeEntidade) atributo.get();
    }

    /**
     * Confere a visibilidade dos campos do atributo de acordo com o tipo atual:
     * CAMPOS_INVISIVEIS_ATRIBUTO_ENTIDADE invisíveis,
     * CAMPOS_VISIVEIS_ATRIBUTO_ENTIDADE visíveis.
     */
    public static void verificarVisibilidadeCampos(AtributoEntidadeEntidade pAtributo) {
        FabTipoAtributoObjeto tipo = pAtributo.getTipo();
        Assert.assertNotNull("O atributo " + pAtributo.getNomeDeclarado() + " está sem tipo", tipo);
        for (String campo : CAMPOS_INVISIVEIS_ATRIBUTO_ENTIDADE) {
            Assert.assertFalse("O campo " + campo + " deveria estar invisível no atributo "
                    + pAtributo.getNomeDeclarado() + " do tipo " + tipo, pAtributo.getCPinst(campo).isVisivel());
        }
        for (String campo : CAMPOS_VISIVEIS_ATRIBUTO_ENTIDADE) {
            Assert.assertTrue("O campo " + campo + " deveria estar visível no atributo "
                    + pAtributo.getNomeDeclarado() + " do tipo " + tipo, pAtributo.getCPinst(campo).isVisivel());
        }
    }

    @Override
    protected void configAmbienteDesevolvimento() {

        SBCore.configurar(new ConfigCoreProjetoCRC(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        SBPersistencia.configuraJPA(new ConfigPersistenciaProjetoCaramelo(), true, true);

    }

}
