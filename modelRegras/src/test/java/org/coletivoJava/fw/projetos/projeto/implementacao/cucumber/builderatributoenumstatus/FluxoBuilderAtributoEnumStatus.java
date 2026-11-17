package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoenumstatus;

import br.org.carameloCode.erp.modulo.projeto.builder.UtilProjetoCRCBuliderAtributo;
import br.org.carameloCode.erp.modulo.projeto.config.ConfigPersistenciaProjetoCaramelo;
import br.org.carameloCode.erp.modulo.projeto.console.ConsoleCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.ComoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoInstanciaAtributoProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.carameloCode.projeto.configAppp.ConfigCoreProjetoCRC;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.SBPersistencia;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.modulos.dinamico.DadoDinamico;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import cucumber.api.CucumberOptions;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.runner.RunWith;
import testesFW.cucumber.CucumberSBTestes;
import testesFW.cucumber.TesteIntegracaoFuncionalidadeCucumber;

/**
 * Instanciação pelo console e geração de DadoDinamico de atributos do tipo de
 * instância ATRIBUTO_ENUM_STATUS (AtributoDeEntidadeFabricaStatus).
 *
 * Slug determinante: StatusCliente.fabStatus (atributo iniciando com
 * fabStatus na entidade de status StatusCliente; a entidade Cliente só possui
 * Cliente.status, testado no FluxoBuilderAtributoEntidadeStatus). Ao digitar o
 * texto, o console deve instanciar um AtributoDeEntidadeFabricaStatus; o teste
 * confere a classe instanciada, salva o atributo pela opção principal e
 * confere o DadoDinamico gerado pelo UtilProjetoCRCBuliderAtributo.
 *
 * Parte dos dados gerados pelo FluxoConsoleObjetoStatus (entidade de status
 * StatusCliente com a fábrica FabStatusCliente). O atributo deve vir vinculado
 * à fábrica FabStatusCliente.
 *
 * <h3>Notas para a implementação das etapas</h3>
 * <ul>
 * <li>As etapas e o enum Etapas são gerados a partir do feature; este fluxo só
 * tem as constantes e os métodos de apoio.</li>
 * <li>O console AINDA NÃO implementa a escolha da classe do atributo pelo
 * texto digitado (slugs . [] fab fabStatus status e nomes reservados). As
 * regras estão em instrucoesIA/console/CLAUDE.md, seção Regras planejadas. Até
 * lá as etapas de classe instanciada vão falhar: isso é esperado.</li>
 * <li>verificarClasseInstanciada compara a classe EXATA (getClass), não
 * instanceof: AtributoDeEntidadeFabricaStatus estende
 * AtributoDeEntidadeFabrica e todas estendem AtributoDeEntidadeSimples.</li>
 * <li>Primeira etapa (Dado):
 * DevOpsCucumberPersistenciaMysql.carregarResultadoRequisito do fluxo citado
 * no feature, renovar o EntityManager, login com EMAIL_USUARIO_ADMIN e
 * CONSOLE.carregarProjetos(); preencher projeto e as entidades de controle e
 * conferir com assert o que vem do fluxo anterior.</li>
 * <li>Depois de executar a opção principal, use atualizarEntidadesDeclaradas()
 * (herdado de TesteIntegracaoFuncionalidadeCucumber) ou renove o EntityManager
 * para conferir o que foi salvo. Compare registros pelo id, não pela
 * instância.</li>
 * <li>ObjetoProjCRC passou a usar herança SINGLE_TABLE (discriminador
 * tipoObjetoDB) com a criação de ObjetoStatusProjCRC: os bancos salvos dos
 * fluxos anteriores precisam ser gerados de novo antes de rodar.</li>
 * <li>Depende do FluxoConsoleObjetoStatus. O atributo fica em StatusCliente
 * (não em Cliente): o texto é StatusCliente.fabStatus.</li>
 * <li>ENTIDADE_PROJ_STATUS_CLIENTE deve ser carregada na primeira etapa;
 * ENTIDADE_PROJ_CLIENTE pode ficar sem uso.</li>
 * <li>Com ponto, StatusCliente.fabStatus é ATRIBUTO_OBJETO (a regra de
 * entidade de status vale só para texto sem ponto). O console deve testar
 * fabStatus ANTES de fab.</li>
 * <li>A etapa ja vem vinculado a fabrica FabStatusCliente confere
 * AtributoDeEntidadeFabricaStatus.getFabricaStatus().getNomeFabrica() igual a
 * NOME_FABRICA_STATUS_CLIENTE.</li>
 * </ul>
 *
 * @author sfurbino
 */
@RunWith(CucumberSBTestes.class)
@CucumberOptions(features = "classpath:caracteristicas/atributo/builderAtributoEnumStatus", tags = "@builderAtributoEnumStatus",
        glue = "org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoenumstatus.etapas",
        monochrome = false, dryRun = false)
public class FluxoBuilderAtributoEnumStatus extends TesteIntegracaoFuncionalidadeCucumber {

    // Sessão
    public static final String EMAIL_USUARIO_ADMIN = "salvio@caramelocode.com.br";
    public static final String SENHA_ADMIN = "123";

    // Console e entidades de controle
    public static final ConsoleCRCProjeto CONSOLE = new ConsoleCRCProjeto();
    public static ProjetoCRC projeto;
    public static ObjetoProjCRC ENTIDADE_PROJ_CLIENTE;
    public static ObjetoProjCRC ENTIDADE_PROJ_STATUS_CLIENTE;

    // Estado do par Quando / Entao em execução
    public static ComoItemProjeto atributoAtual;
    public static DadoDinamico dadoDinamicoGerado;

    public static final String NOME_ENTIDADE_CLIENTE = "Cliente";
    public static final String NOME_ENTIDADE_STATUS_CLIENTE = "StatusCliente";
    public static final String NOME_FABRICA_STATUS_CLIENTE = "FabStatusCliente";
    public static final String SEPARADOR_ATRIBUTO = ".";

    /**
     * Marcação no fim do texto digitado que determina o tipo de instância
     * (vazio quando o tipo é determinado pelo nome do atributo).
     */
    public static final String SUFIXO_SLUG = "";

    public static final FabTipoInstanciaAtributoProjeto TIPO_INSTANCIA = FabTipoInstanciaAtributoProjeto.ATRIBUTO_ENUM_STATUS;

    /**
     * Atributos testados: tipo do atributo e nome usado no feature, na ordem
     * do feature.
     */
    public static final Map<FabTipoAtributoObjeto, String> NOMES_ATRIBUTO_POR_TIPO;

    static {
        Map<FabTipoAtributoObjeto, String> NOMES = new LinkedHashMap<>();
        NOMES.put(FabTipoAtributoObjeto.STATUS_ENUM, "fabStatus");
        NOMES_ATRIBUTO_POR_TIPO = Collections.unmodifiableMap(NOMES);
    }

    public static String getNomeAtributo(FabTipoAtributoObjeto pTipo) {
        Assert.assertTrue("O tipo " + pTipo + " não é testado neste fluxo", NOMES_ATRIBUTO_POR_TIPO.containsKey(pTipo));
        return NOMES_ATRIBUTO_POR_TIPO.get(pTipo);
    }

    /**
     * Texto digitado no console para o atributo: StatusCliente.nomeAtributo seguido
     * do sufixo do slug.
     */
    public static String getTextoDigitado(String pNomeAtributo) {
        return NOME_ENTIDADE_STATUS_CLIENTE + SEPARADOR_ATRIBUTO + pNomeAtributo + SUFIXO_SLUG;
    }

    /**
     * Digita o texto do atributo no console, seleciona a opção principal e
     * guarda o item associado em atributoAtual.
     */
    public static ComoItemProjeto digitarAtributo(String pNomeAtributo) {
        Assert.assertNotNull("A entidade " + NOME_ENTIDADE_STATUS_CLIENTE + " deveria estar carregada", ENTIDADE_PROJ_STATUS_CLIENTE);
        String texto = getTextoDigitado(pNomeAtributo);
        CONSOLE.autocompletProjeto(texto);
        Assert.assertNotNull("Nenhuma opção principal sugerida para " + texto, CONSOLE.getOpcaoPrincipalSugerida());
        CONSOLE.setOpcaoSelecionada(CONSOLE.getOpcaoPrincipalSugerida());
        atributoAtual = CONSOLE.getOpcaoSelecionada().getItemAssociado();
        Assert.assertNotNull("A opção principal de " + texto + " não possui item associado", atributoAtual);
        return atributoAtual;
    }

    /**
     * Confere que o console instanciou exatamente a classe do tipo de
     * instância deste fluxo.
     */
    public static void verificarClasseInstanciada(String pNomeAtributo) {
        Assert.assertNotNull("Nenhum atributo instanciado para " + pNomeAtributo, atributoAtual);
        Assert.assertEquals("O console instanciou a classe errada para " + getTextoDigitado(pNomeAtributo),
                TIPO_INSTANCIA.getClasse(), atributoAtual.getClass());
    }

    public static AtributoDeEntidadeSimples getAtributoAtualComoSimples() {
        Assert.assertTrue("O atributo instanciado (" + atributoAtual.getClass().getSimpleName()
                + ") não estende AtributoDeEntidadeSimples", atributoAtual instanceof AtributoDeEntidadeSimples);
        return (AtributoDeEntidadeSimples) atributoAtual;
    }

    /**
     * Gera o DadoDinamico do atributo atual pelo UtilProjetoCRCBuliderAtributo
     * e confere que o tipo gerado é o esperado.
     */
    public static DadoDinamico verificarDadoDinamicoGerado(FabTipoAtributoObjeto pTipoEsperado) {
        AtributoDeEntidadeSimples atributo = getAtributoAtualComoSimples();
        dadoDinamicoGerado = UtilProjetoCRCBuliderAtributo.gerarDadoDinamico(atributo);
        Assert.assertNotNull("O builder não gerou o DadoDinamico do atributo " + atributo.getNomeDeclarado(), dadoDinamicoGerado);
        Assert.assertNotNull("O DadoDinamico do atributo " + atributo.getNomeDeclarado() + " não possui TipoDadoDinamico",
                dadoDinamicoGerado.getTipoDadoDinamico());
        Assert.assertEquals("Tipo do DadoDinamico incorreto para o atributo " + atributo.getNomeDeclarado(),
                pTipoEsperado, dadoDinamicoGerado.getTipoDadoDinamico().getFabricaTipoAtributo());
        return dadoDinamicoGerado;
    }

    @Override
    protected void configAmbienteDesevolvimento() {

        SBCore.configurar(new ConfigCoreProjetoCRC(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        SBPersistencia.configuraJPA(new ConfigPersistenciaProjetoCaramelo(), true, true);

    }

}
