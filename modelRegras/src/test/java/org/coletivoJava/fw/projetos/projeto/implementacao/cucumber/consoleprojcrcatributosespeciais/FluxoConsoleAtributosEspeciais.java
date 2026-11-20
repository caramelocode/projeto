package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.objeto.FabAcaoCarameloDevEdicaoItemProj;
import br.org.carameloCode.erp.modulo.projeto.config.ConfigPersistenciaProjetoCaramelo;
import br.org.carameloCode.erp.modulo.projeto.console.ConsoleCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.console.ItemOpcaoConsole;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
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
 * Criação de atributos especiais pelo console.
 *
 * O tipo do atributo é determinado pelo caractere especial no final do texto
 * digitado:
 *
 * Entidade.atributo. -> objeto (AtributoEntidadeEntidade)
 *
 * Entidade.atributo[] -> lista (AtrubutoEntidadeLista)
 *
 * Ao digitar apenas o colchete de abertura, o autocompletar sugere o texto com
 * o colchete de fechamento e o texto definido é normatizado com os dois
 * colchetes.
 *
 * Parte do resultado final do FluxoConsoleObjetos (entidade Cliente com seus
 * atributos).
 *
 * @author sfurbino
 */
@RunWith(CucumberSBTestes.class)
@CucumberOptions(features = "classpath:caracteristicas/console/consoleProjCRCAtributosEspeciais", tags = "@consoleProjCRCAtributosEspeciais",
        glue = "org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.etapas",
        monochrome = false, dryRun = false)
public class FluxoConsoleAtributosEspeciais extends TesteIntegracaoFuncionalidadeCucumber {

    // Sessão
    public static final String EMAIL_USUARIO_ADMIN = "salvio@caramelocode.com.br";
    public static final String SENHA_ADMIN = "123";

    // Console e entidades de controle
    public static final ConsoleCRCProjeto CONSOLE = new ConsoleCRCProjeto();
    public static ProjetoCRC projeto;
    public static List<String> sugestoesAutocompletar;

    // Entidade e atributos
    public static final String NOME_ENTIDADE_CLIENTE = "Cliente";
    public static final String NOME_ATRIBUTO_CLIENTE_INDICOU = "clienteIndicou";
    public static final String NOME_ATRIBUTO_CLIENTES_RELACIONADOS = "clientesRelacionados";

    // Caracteres especiais que determinam o tipo do atributo
    /**
     * Ponto no final do nome do atributo: atributo do tipo objeto.
     */
    public static final String SUFIXO_ATRIBUTO_OBJETO = ".";
    /**
     * Colchetes no final do nome do atributo: atributo do tipo lista.
     */
    public static final String SUFIXO_ATRIBUTO_LISTA = "[]";
    /**
     * Apenas o colchete de abertura, completado pelo autocompletar.
     */
    public static final String ABRE_COLCHETE_LISTA = "[";

    // Textos digitados no console
    /**
     * Cliente.clienteIndicou.
     */
    public static final String TEXTO_ATRIBUTO_OBJETO_CLIENTE_INDICOU
            = getTextoAtributoCliente(NOME_ATRIBUTO_CLIENTE_INDICOU, SUFIXO_ATRIBUTO_OBJETO);
    /**
     * Cliente.clientesRelacionados[
     */
    public static final String TEXTO_ATRIBUTO_LISTA_SEM_FECHAR_COLCHETE
            = getTextoAtributoCliente(NOME_ATRIBUTO_CLIENTES_RELACIONADOS, ABRE_COLCHETE_LISTA);
    /**
     * Cliente.clientesRelacionados[]
     */
    public static final String TEXTO_ATRIBUTO_LISTA_CLIENTES_RELACIONADOS
            = getTextoAtributoCliente(NOME_ATRIBUTO_CLIENTES_RELACIONADOS, SUFIXO_ATRIBUTO_LISTA);

    /**
     * Monta o texto digitado no console: Cliente + ponto separador + nome do
     * atributo + caractere especial do tipo.
     */
    public static String getTextoAtributoCliente(String pNomeAtributo, String pSufixoTipo) {
        return NOME_ENTIDADE_CLIENTE + FabTipoItemProjeto.SEPARADOR_ATRIBUTO + pNomeAtributo + pSufixoTipo;
    }

    /**
     * Digita o texto no console e guarda as sugestões do autocompletar.
     */
    public static void digitarNoConsole(String pTextoDigitado) {
        sugestoesAutocompletar = CONSOLE.autocompletProjeto(pTextoDigitado);
        Assert.assertNotNull("O autocompletar não retornou sugestões para " + pTextoDigitado, sugestoesAutocompletar);
    }

    /**
     * Entidade Cliente criada no FluxoConsoleObjetos, acessível pelo console.
     */
    public static ObjetoProjCRC getEntidadeClienteDoConsole() {
        ObjetoProjCRC entidade = CONSOLE.getObjetoSelecionado();
        Assert.assertNotNull("Nenhuma entidade selecionada no console", entidade);
        Assert.assertEquals("A entidade selecionada no console deveria ser " + NOME_ENTIDADE_CLIENTE,
                NOME_ENTIDADE_CLIENTE, entidade.getNomeEntidade());
        Assert.assertNotNull("A entidade " + NOME_ENTIDADE_CLIENTE + " deveria estar salva", entidade.getId());
        return entidade;
    }

    /**
     * Confere que a opção principal sugerida é criar o atributo com a ação de
     * salvar esperada, que o item associado é do tipo especial esperado, ainda
     * não persistido e pertencente a Cliente.
     *
     * @return o atributo a criar
     */
    public static <T extends AtributoDeEntidadeSimples> T getAtributoDaOpcaoPrincipalDeCriacao(String pNomeAtributo, Class<T> pTipoEsperado,
            FabAcaoCarameloDevEdicaoItemProj pAcaoSalvarEsperada) {
        ItemOpcaoConsole opcao = CONSOLE.getOpcaoPrincipalSugerida();
        Assert.assertNotNull("Nenhuma opção principal sugerida para o atributo " + pNomeAtributo, opcao);
        Assert.assertEquals("A opção principal deveria ser criar atributo", pAcaoSalvarEsperada,
                opcao.getFabAcaoCriarItem());
        Assert.assertNotNull("A opção principal deveria ter um item associado", opcao.getItemAssociado());
        Assert.assertEquals("Tipo do item associado incorreto para o atributo " + pNomeAtributo,
                pTipoEsperado, opcao.getItemAssociado().getClass());
        T atributo = pTipoEsperado.cast(opcao.getItemAssociado());
        Assert.assertEquals("Nome do atributo a criar incorreto", pNomeAtributo, atributo.getNomeDeclarado());
        Assert.assertNull("O atributo a criar não deveria estar persistido", atributo.getId());
        Assert.assertNotNull("O atributo a criar deveria pertencer a uma entidade", atributo.getEntidade());
        Assert.assertEquals("Entidade do atributo incorreta", NOME_ENTIDADE_CLIENTE, atributo.getEntidade().getNomeEntidade());
        return atributo;
    }

    /**
     * Executa a opção selecionada, que deve ser criar atributo com a ação de
     * salvar esperada, e confere que o atributo retornado foi persistido.
     */
    public static void executarCriacaoDoAtributo(String pNomeAtributo, FabAcaoCarameloDevEdicaoItemProj pAcaoSalvarEsperada) {
        Assert.assertNotNull("Nenhuma opção selecionada para executar", CONSOLE.getOpcaoSelecionada());
        Assert.assertEquals("A opção selecionada deveria ser criar o atributo " + pNomeAtributo,
                pAcaoSalvarEsperada, CONSOLE.getOpcaoSelecionada().getFabAcaoCriarItem());
        CONSOLE.executarOpcaoSelecionada();
        Assert.assertTrue("O item da opção executada deveria ser um atributo",
                CONSOLE.getOpcaoSelecionada().getItemAssociado() instanceof AtributoDeEntidadeSimples);
        AtributoDeEntidadeSimples atributo = (AtributoDeEntidadeSimples) CONSOLE.getOpcaoSelecionada().getItemAssociado();
        Assert.assertNotNull("O atributo " + pNomeAtributo + " não foi salvo pela execução da opção", atributo.getId());
        Assert.assertEquals("Nome do atributo salvo incorreto", pNomeAtributo, atributo.getNomeDeclarado());
    }

    /**
     * Recarrega o projeto pelo EntityManager de teste e devolve a entidade
     * Cliente salva.
     */
    public static ObjetoProjCRC getEntidadeClienteSalva() {
        renovarConexaoEntityManagerEscopoTeste();
        ProjetoCRC projetoSalvo = UtilSBPersistencia.loadEntidade(projeto, getEM());
        Assert.assertNotNull("Projeto não encontrado", projetoSalvo);
        Assert.assertNotNull("Lista de entidades do projeto não carregada", projetoSalvo.getObjetos());
        Optional<ObjetoProjCRC> entidade = projetoSalvo.getObjetos().stream()
                .filter(obj -> NOME_ENTIDADE_CLIENTE.equals(obj.getNomeEntidade()))
                .findFirst();
        Assert.assertTrue("Entidade " + NOME_ENTIDADE_CLIENTE + " não encontrada no projeto", entidade.isPresent());
        return entidade.get();
    }

    /**
     * Atributo de Cliente salvo com o nome informado, ou vazio se não existir.
     */
    public static Optional<AtributoDeEntidadeSimples> getAtributoSalvoEmCliente(String pNomeAtributo) {
        List<AtributoDeEntidadeSimples> atributos = getEntidadeClienteSalva().getAtributos();
        Assert.assertNotNull("Atributos da entidade " + NOME_ENTIDADE_CLIENTE + " não carregados", atributos);
        return atributos.stream()
                .filter(at -> pNomeAtributo.equals(at.getNomeDeclarado()))
                .findFirst();
    }

    /**
     * Confere que o atributo foi salvo em Cliente com o tipo especial esperado.
     *
     * @return o atributo salvo
     */
    public static <T extends AtributoDeEntidadeSimples> T verificarAtributoSalvoEmCliente(String pNomeAtributo, Class<T> pTipoEsperado) {
        Optional<AtributoDeEntidadeSimples> atributo = getAtributoSalvoEmCliente(pNomeAtributo);
        Assert.assertTrue("O atributo " + pNomeAtributo + " não foi salvo em " + NOME_ENTIDADE_CLIENTE, atributo.isPresent());
        Assert.assertNotNull("O atributo " + pNomeAtributo + " deveria estar persistido", atributo.get().getId());
        Assert.assertEquals("Tipo salvo incorreto para o atributo " + pNomeAtributo, pTipoEsperado, atributo.get().getClass());
        return pTipoEsperado.cast(atributo.get());
    }

    @Override
    protected void configAmbienteDesevolvimento() {

        SBCore.configurar(new ConfigCoreProjetoCRC(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        SBPersistencia.configuraJPA(new ConfigPersistenciaProjetoCaramelo(), true, true);

    }

}
