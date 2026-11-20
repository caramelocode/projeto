/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.carameloCode.erp.projeto.config;

import br.org.carameloCode.erp.modulo.notificacao.api.FabAcaoNotificacaoPadraoSB;
import br.org.carameloCode.erp.modulo.projeto.acoes.demonstracao.formulario.FabAcaoProjetoCRCCarameloFormulario;
import br.org.carameloCode.erp.modulo.projeto.acoes.demonstracao.nativo.FabAcaoProjetoCRCComponenteNativo;
import br.org.carameloCode.erp.modulo.projeto.acoes.demonstracao.notificacoes.FabAcaoProjetoCRCNotificacoes;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.acao.FabAcaoCarameloDevAcaoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.console.FabAcaoCarameloDevConsoleCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.objeto.FabAcaoCarameloDevEdicaoItemProj;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.projeto.FabAcaoCarameloDevProjetoCRC;
import br.org.carameloCode.erp.modulo.projeto.acoes.cliente.FabAcaoCliente;

import br.org.coletivojava.fw.utils.servico.ServicoRepositorioDeArquivos.ServicoDeArquivosWebAppS3;
import com.super_bits.modulos.SBAcessosModel.fabricas.FabAcaoProjetoSB;
import com.super_bits.modulos.SBAcessosModel.view.FabAcaoPaginasDoSistema;

import com.super_bits.modulosSB.SBCore.ConfigGeral.ComoContextoExecCustomizavel;
import com.super_bits.modulosSB.webPaginas.ConfigGeral.ConfiguradorCoreDeProjetoWebWarAbstrato;
import javax.servlet.ServletContext;

/**
 *
 * @author salvioF
 */
public class ConfigCoreWebAppProjetosCaramelo extends ConfiguradorCoreDeProjetoWebWarAbstrato {

    public ConfigCoreWebAppProjetosCaramelo(ServletContext contexto) {
        super(contexto);
    }

    public ConfigCoreWebAppProjetosCaramelo() {
        super(true);
    }

    @Override
    public void defineClassesBasicas(ComoContextoExecCustomizavel pConfiguracao) {
        super.defineClassesBasicas(pConfiguracao);
        pConfiguracao.setCentralComunicacao(ServicoComunicacaoWebAppPadrao.class);

    }

    @Override
    public void defineFabricasDeACao(ComoContextoExecCustomizavel pConfig) {
        pConfig.setClasseConfigPermissao(ConfigPermissaoProjetoWeb.class);
        pConfig.setCentralDeArquivos(ServicoDeArquivosWebAppS3.class);
        pConfig.setFabricaDeAcoes(new Class[]{
            FabAcaoPaginasDoSistema.class,
            FabAcaoProjetoCRCComponenteNativo.class,
            FabAcaoProjetoSB.class,
            FabAcaoCarameloDevAcaoProjCRC.class,
            FabAcaoCarameloDevConsoleCRCProjeto.class,
            FabAcaoCarameloDevProjetoCRC.class,
            FabAcaoCliente.class,
            FabAcaoNotificacaoPadraoSB.class,
            FabAcaoProjetoCRCNotificacoes.class,
            FabAcaoProjetoCRCCarameloFormulario.class,
            FabAcaoCarameloDevEdicaoItemProj.class

        });

    }

}
