package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.cadastroprojetocrc;

import br.org.carameloCode.erp.modulo.projeto.config.ConfigPersistenciaProjetoCaramelo;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.carameloCode.projeto.configAppp.ConfigCoreProjetoCRC;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.SBPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import testesFW.cucumber.CucumberSBTestes;
import testesFW.cucumber.TesteIntegracaoFuncionalidadeCucumber;

/**
 *
 * @author sfurbino
 */
@RunWith(CucumberSBTestes.class)
@CucumberOptions(features = "classpath:caracteristicas/projeto", tags = "@CadastroProjetoCRC",
        glue = "org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.cadastroprojetocrc.etapas",
        monochrome = false, dryRun = false)
public class FluxoCadastroProjeto extends TesteIntegracaoFuncionalidadeCucumber {

    public static final String EMAIL_USUARIO_ADMIN = "salvio@caramelocode.com.br";
    public static final String SENHA_ADMIN = "123";
    public static final String NOME_PROJETO = "Projeto Cadastro Teste CRC";
    public static final String DESCRICAO_PROJETO = "Projeto criado pelo teste de cadastro de projeto";
    public static ProjetoCRC projeto;

    @Override
    protected void configAmbienteDesevolvimento() {

        SBCore.configurar(new ConfigCoreProjetoCRC(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        SBPersistencia.configuraJPA(new ConfigPersistenciaProjetoCaramelo(), true, true);

    }

}
