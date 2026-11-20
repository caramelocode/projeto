package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.objeto.FabAcaoCarameloDevEdicaoItemProj;
import br.org.carameloCode.erp.modulo.projeto.config.ConfigPersistenciaProjetoCaramelo;
import br.org.carameloCode.erp.modulo.projeto.console.ConsoleCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.console.ItemOpcaoConsole;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoInstanciaAtributoProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeLista;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.carameloCode.projeto.configAppp.ConfigCoreProjetoCRC;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.SBPersistencia;
import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import cucumber.api.CucumberOptions;
import java.util.Optional;
import org.junit.Assert;
import org.junit.runner.RunWith;
import testesFW.cucumber.CucumberSBTestes;
import testesFW.cucumber.TesteIntegracaoFuncionalidadeCucumber;

/**
 * Criação pelo console de atributos do tipo de instância ATRIBUTO_LISTAGEM
 * (AtrubutoEntidadeLista), nos dois tipos de listagem: pública
 * (clientesRelacionados) e particular (clientesParticulares).
 *
 * Slug determinante: o texto Entidade ponto nomeAtributo terminado em
 * colchetes (Cliente.clientesRelacionados[]). O console instancia um
 * AtrubutoEntidadeLista com o tipo padrão LISTA_OBJETOS_PUBLICOS e a entidade
 * dos itens deduzida pelo nome.
 *
 * Parte dos dados gerados pelo FluxoConsoleObjetos: entidade Cliente com os
 * atributos id, nome e nomeCompleto.
 *
 * <h3>Etapas, para cada atributo</h3>
 * <ul>
 * <li>Quando: digita o texto com colchetes (digitarAtributo), que seleciona a
 * opção de criar e guarda o item em atributoAtual.</li>
 * <li>Entao: a classe instanciada, a ação da opção, o tipo de instância e a
 * entidade dos itens de atributoAtual.</li>
 * <li>Quando / E: define o tipo e a entidade dos itens em atributoAtual e
 * executa a opção selecionada no console.</li>
 * <li>Entao: o atributo fica disponível no console (verificarDisponivelNoConsole),
 * o autocompletar sugere o nome com colchetes ao digitar o nome sem eles, e o
 * atributo salvo (getAtributoListaSalvo) tem id, tipo e entidade dos itens.</li>
 * </ul>
 *
 * <h3>Notas</h3>
 * <ul>
 * <li>As etapas E e as etapas Entao que vêm depois de E operam sobre o atributo
 * da etapa Quando anterior (atributoAtual / atributoSalvo).</li>
 * <li>O autocompletar sugere atributos de listagem com o sufixo []
 * (FabTipoItemProjeto.textosSugestaoAutocomplete).</li>
 * </ul>
 *
 * @author sfurbino
 */
@RunWith(CucumberSBTestes.class)
@CucumberOptions(features = "classpath:caracteristicas/atributo/builderAtributoListagem", tags = "@builderAtributoListagem",
        glue = "org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.etapas",
        monochrome = false, dryRun = false)
public class FluxoBuilderAtributoListagem extends TesteIntegracaoFuncionalidadeCucumber {

    // Sessão
    public static final String EMAIL_USUARIO_ADMIN = "salvio@caramelocode.com.br";
    public static final String SENHA_ADMIN = "123";

    // Console e entidades de controle
    public static final ConsoleCRCProjeto CONSOLE = new ConsoleCRCProjeto();
    public static ProjetoCRC projeto;
    public static ObjetoProjCRC ENTIDADE_PROJ_CLIENTE;

    // Estado do atributo em teste
    /**
     * Atributo novo da opção selecionada no console (antes de salvar).
     */
    public static AtributoEntidadeLista atributoAtual;
    /**
     * Atributo salvo, recarregado do banco.
     */
    public static AtributoEntidadeLista atributoSalvo;

    public static final String NOME_ENTIDADE_CLIENTE = "Cliente";
    public static final String SEPARADOR_ATRIBUTO = ".";

    /**
     * Marcação no fim do texto digitado que determina o tipo de instância.
     */
    public static final String SUFIXO_SLUG = "[]";

    public static final FabTipoInstanciaAtributoProjeto TIPO_INSTANCIA = FabTipoInstanciaAtributoProjeto.ATRIBUTO_LISTAGEM;

    public static final String NOME_CLIENTES_RELACIONADOS = "clientesRelacionados";
    public static final String NOME_CLIENTES_PARTICULARES = "clientesParticulares";

    /**
     * Texto digitado no console: Cliente.nomeAtributo[].
     */
    public static String getTextoDigitado(String pNomeAtributo) {
        return getTextoSemSufixo(pNomeAtributo) + SUFIXO_SLUG;
    }

    /**
     * Texto do atributo sem os colchetes: Cliente.nomeAtributo.
     */
    public static String getTextoSemSufixo(String pNomeAtributo) {
        return NOME_ENTIDADE_CLIENTE + SEPARADOR_ATRIBUTO + pNomeAtributo;
    }

    /**
     * Digita Cliente.nomeAtributo[] no console, seleciona a opção cujo item é
     * o atributo com esse nome, confere que é a primeira opção sugerida e que o
     * atributo ainda não está salvo, e guarda o item em atributoAtual.
     */
    public static ItemOpcaoConsole digitarAtributo(String pNomeAtributo) {
        String textoDigitado = getTextoDigitado(pNomeAtributo);
        CONSOLE.setTextoDefinido(textoDigitado);
        ItemOpcaoConsole opcao = getOpcaoDoAtributo(pNomeAtributo);
        Assert.assertSame("A opção de criar " + textoDigitado + " deveria ser a primeira opção sugerida",
                CONSOLE.getOpcoesDisponiveis().get(0), opcao);
        Assert.assertNull("O atributo " + pNomeAtributo + " ainda não deveria estar salvo", opcao.getItemAssociado().getId());
        Assert.assertEquals("O console instanciou a classe errada para " + textoDigitado,
                TIPO_INSTANCIA.getClasse(), opcao.getItemAssociado().getClass());
        CONSOLE.setOpcaoSelecionada(opcao);
        atributoAtual = (AtributoEntidadeLista) opcao.getItemAssociado();
        return opcao;
    }

    /**
     * Opção do console (última pesquisa) cujo item é o atributo com o nome
     * informado.
     */
    public static ItemOpcaoConsole getOpcaoDoAtributo(String pNomeAtributo) {
        Optional<ItemOpcaoConsole> opcao = CONSOLE.getOpcoesDisponiveis().stream()
                .filter(op -> op.getItemAssociado() instanceof AtributoDeEntidadeSimples
                && pNomeAtributo.equals(((AtributoDeEntidadeSimples) op.getItemAssociado()).getNomeDeclarado()))
                .findFirst();
        Assert.assertTrue("Nenhuma opção do console para o atributo " + pNomeAtributo
                + " ao digitar " + CONSOLE.getTextoDefinido(), opcao.isPresent());
        return opcao.get();
    }

    /**
     * Confere que a opção selecionada é criar o atributo de listagem.
     */
    public static void verificarOpcaoCriarAtributoLista(String pNomeAtributo) {
        Assert.assertNotNull("Nenhum atributo selecionado no console", atributoAtual);
        Assert.assertEquals("Atributo selecionado incorreto", pNomeAtributo, atributoAtual.getNomeDeclarado());
        Assert.assertEquals("A opção de " + getTextoDigitado(pNomeAtributo) + " deveria ser salvar um atributo de listagem",
                FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_SALVAR_NOVO_TP_LISTA,
                CONSOLE.getOpcaoSelecionada().getFabAcaoCriarItem());
    }

    /**
     * Executa a opção selecionada (criar o atributo) e confere o atributo no
     * repositório do console.
     */
    public static void salvarPeloConsole(String pNomeAtributo) {
        Assert.assertSame("A opção selecionada deveria ser a do atributo " + pNomeAtributo,
                atributoAtual, CONSOLE.getOpcaoSelecionada().getItemAssociado());
        CONSOLE.executarOpcaoSelecionada();
        // executarOpcaoSelecionada é void: o efeito é conferido no repositório, recarregado após o sucesso
        Assert.assertTrue("O atributo " + pNomeAtributo + " não aparece no repositório do console depois de salvar",
                CONSOLE.getRepositorio().getEntidadeExistente(NOME_ENTIDADE_CLIENTE).getAtributos().stream()
                        .anyMatch(at -> pNomeAtributo.equals(at.getNomeDeclarado())));
    }

    /**
     * Ao digitar Cliente.nomeAtributo[] de novo, o console oferece o atributo
     * salvo (editar) e não oferece mais criar.
     */
    public static void verificarDisponivelNoConsole(String pNomeAtributo) {
        String textoDigitado = getTextoDigitado(pNomeAtributo);
        CONSOLE.setTextoDefinido(textoDigitado);
        ItemOpcaoConsole opcao = getOpcaoDoAtributo(pNomeAtributo);
        Assert.assertNotNull("O console deveria oferecer o atributo " + pNomeAtributo + " já salvo ao digitar " + textoDigitado,
                opcao.getItemAssociado().getId());
        Assert.assertEquals("O atributo " + pNomeAtributo + " disponível no console não é um atributo de listagem",
                TIPO_INSTANCIA.getClasse(), opcao.getItemAssociado().getClass());
        Assert.assertFalse("O console não deveria oferecer criar o atributo " + pNomeAtributo + " de novo",
                CONSOLE.getOpcoesDisponiveis().stream()
                        .anyMatch(op -> op.getFabAcaoCriarItem() == FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_SALVAR_NOVO_TP_LISTA));
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
     * Recarrega o Cliente do banco e devolve o atributo salvo, conferindo que
 é um AtributoEntidadeLista; guarda em atributoSalvo.
     */
    public static AtributoEntidadeLista getAtributoListaSalvo(String pNomeAtributo) {
        recarregarEntidadeCliente();
        Optional<AtributoDeEntidadeSimples> atributo = ENTIDADE_PROJ_CLIENTE.getAtributos().stream()
                .filter(at -> pNomeAtributo.equals(at.getNomeDeclarado()))
                .findFirst();
        Assert.assertTrue("O atributo " + pNomeAtributo + " não foi salvo na entidade " + NOME_ENTIDADE_CLIENTE, atributo.isPresent());
        Assert.assertEquals("Classe do atributo " + pNomeAtributo + " salvo incorreta",
                TIPO_INSTANCIA.getClasse(), atributo.get().getClass());
        atributoSalvo = (AtributoEntidadeLista) atributo.get();
        return atributoSalvo;
    }

    /**
     * Confere o tipo de listagem e a entidade dos itens do atributo salvo.
     */
    public static void verificarAtributoSalvo(String pNomeAtributo, FabTipoAtributoObjeto pTipoEsperado) {
        Assert.assertNotNull("Nenhum atributo salvo carregado", atributoSalvo);
        Assert.assertEquals("Atributo salvo incorreto", pNomeAtributo, atributoSalvo.getNomeDeclarado());
        Assert.assertEquals("Tipo de listagem salvo incorreto no atributo " + pNomeAtributo, pTipoEsperado, atributoSalvo.getTipo());
        Assert.assertNotNull("O atributo " + pNomeAtributo + " foi salvo sem a entidade dos itens", atributoSalvo.getEntidadeItemLista());
        Assert.assertEquals("Entidade dos itens salva incorreta no atributo " + pNomeAtributo,
                ENTIDADE_PROJ_CLIENTE.getId(), atributoSalvo.getEntidadeItemLista().getId());
    }

    @Override
    protected void configAmbienteDesevolvimento() {

        SBCore.configurar(new ConfigCoreProjetoCRC(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        SBPersistencia.configuraJPA(new ConfigPersistenciaProjetoCaramelo(), true, true);

    }

}
