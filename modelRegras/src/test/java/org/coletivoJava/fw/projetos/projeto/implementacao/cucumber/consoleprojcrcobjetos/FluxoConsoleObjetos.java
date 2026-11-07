package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.acao.FabAcaoCarameloDevAcaoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.config.ConfigPersistenciaProjetoCaramelo;
import br.org.carameloCode.erp.modulo.projeto.console.ConsoleCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.carameloCode.projeto.configAppp.ConfigCoreProjetoCRC;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.SBPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import cucumber.api.CucumberOptions;
import java.util.List;
import org.junit.runner.RunWith;
import testesFW.cucumber.CucumberSBTestes;
import testesFW.cucumber.TesteIntegracaoFuncionalidadeCucumber;

/**
 *
 * @author sfurbino
 */
@RunWith(CucumberSBTestes.class)
@CucumberOptions(features = "classpath:caracteristicas/console/consoleProjCRCObjetos", tags = "@consoleProjCRCObjetos",
        glue = "org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.etapas",
        monochrome = false, dryRun = false)
public class FluxoConsoleObjetos extends TesteIntegracaoFuncionalidadeCucumber {

    public static final String EMAIL_USUARIO_ADMIN = "salvio@caramelocode.com.br";
    public static final String SENHA_ADMIN = "123";
    public static ProjetoCRC projeto;
    public static final ConsoleCRCProjeto CONSOLE = new ConsoleCRCProjeto();
    public static final String TEXTO_COM_ESPACOS_MINUSCULO = "cli ente";
    public static final String TEXTO_DIGITADO_CLIENTE = "cliente";
    public static final String TRECHO_DICA_NOME_ENTIDADE = "Entidade.";
    public static final String NOME_ENTIDADE_CLIENTE = "Cliente";
    public static final String TEXTO_PARCIAL_CLI = "Cli";
    public static final String NOME_ATRIBUTO_ID = "id";
    public static final String NOME_ATRIBUTO_NOME = "nome";
    public static final String NOME_ATRIBUTO_NOME_COMPLETO = "nomeCompleto";
    public static final String TEXTO_PARCIAL_ATRIBUTO_N = "n";
    public static List<String> sugestoesAutocompletar;

    @Override
    protected void configAmbienteDesevolvimento() {

        SBCore.configurar(new ConfigCoreProjetoCRC(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        SBPersistencia.configuraJPA(new ConfigPersistenciaProjetoCaramelo(), true, true);

    }

}
