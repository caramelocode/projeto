/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.carameloCode.erp.projeto.config;

import br.org.carameloCode.erp.modulo.projeto.acoes.componente.formulario.FabAcaoProjetoCRCCarameloFormulario;
import br.org.carameloCode.erp.modulo.projeto.acoes.componente.nativo.FabAcaoProjetoCRCComponenteNativo;
import br.org.coletivojava.fw.utils.servico.ServicoRepositorioDeArquivos.ServicoDeArquivosWebAppS3;
import com.super_bits.modulos.SBAcessosModel.fabricas.FabAcaoProjetoSB;
import com.super_bits.modulos.SBAcessosModel.fabricas.acoesDemonstracao.FabAcaoDemonstracaoSB;
import com.super_bits.modulos.SBAcessosModel.view.FabAcaoPaginasDoSistema;

import com.super_bits.modulosSB.SBCore.ConfigGeral.ItfConfiguracaoCoreCustomizavel;
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
    public void defineClassesBasicas(ItfConfiguracaoCoreCustomizavel pConfiguracao) {
        super.defineClassesBasicas(pConfiguracao);
        pConfiguracao.setCentralComunicacao(ServicoComunicacaoWebAppPadrao.class);

    }

    @Override
    public void defineFabricasDeACao(ItfConfiguracaoCoreCustomizavel pConfig) {
        pConfig.setClasseConfigPermissao(ConfigPermissaoProjetoWeb.class);
        pConfig.setCentralDeArquivos(ServicoDeArquivosWebAppS3.class);
        pConfig.setFabricaDeAcoes(new Class[]{
            FabAcaoPaginasDoSistema.class,
            FabAcaoProjetoCRCComponenteNativo.class,
            FabAcaoProjetoCRCCarameloFormulario.class,
            FabAcaoProjetoSB.class // FabAcaoDemonstracaoSB.class
        });

    }

}
