/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.carameloCode.erp.crm.config;

import br.org.carameloCode.erp.modulo.projeto.config.ConfigPersistenciaProjetoCaramelo;

import com.super_bits.modulosSB.Persistencia.ConfigGeral.SBPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.webPaginas.ConfigGeral.ConfiguradorCoreDeProjetoWebWarAbstrato;
import com.super_bits.modulosSB.webPaginas.ConfigGeral.ItfInicioFimAppWP;
import com.super_bits.modulosSB.webPaginas.ConfigGeral.SBWebPaginas;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.coletivojava.fw.api.tratamentoErros.FabErro;
import javax.servlet.SessionCookieConfig;

/**
 *
 * @author Salvio
 */
public class InicioFimContextoWebPagina implements ItfInicioFimAppWP {

    private static Thread acoesInicioSistema;

    @Override
    public void inicio() {

        try {
            System.out.println("ConfigSBPaginas");
            SBCore.configurar(
                    new ConfigCoreWebAppProjetosCaramelo(ConfiguradorCoreDeProjetoWebWarAbstrato.contextoDoServlet),
                    SBCore.ESTADO_APP.HOMOLOGACAO
            );
            System.out.println("############### FIM CONFIG core");
            try {

                SBPersistencia.configuraJPA(new ConfigPersistenciaProjetoCaramelo());
                SBPersistencia.criarRegistrosIniciais();
            } catch (Throwable t) {
                System.out.println("FALHA CRIANDO JPA");
                SBCore.RelatarErro(FabErro.SOLICITAR_REPARO, "Erro configurando JPA", t);
            }

            System.out.println("############### FIM CONFIG JPA");
            SBWebPaginas.configurar(new ConfigWP_CRM_CarameloCode());
            System.out.println("############### FIM CONFIG WEBPAGINAS");
            System.out.println(SBWebPaginas.isAmbienteConfigurado());

            SBCore.getServicoPermissao().persitirMergePermissoes();
            if (!SBWebPaginas.isAmbienteConfigurado()) {
                throw new UnsupportedOperationException("Falha configurando webpagina");
            }
        } catch (Throwable t) {
            SBCore.RelatarErro(FabErro.PARA_TUDO, "Impossível acessar o arquivo de configuração básico da  aplicação" + t.getMessage(), t);
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(InicioFimContextoWebPagina.class.getName()).log(Level.SEVERE, null, ex);
        }

        //  SBCore.getServicoPermissao().persitirMergePermissoes();
    }

    @Override
    public void fim() {
        System.out.println("FIm do contexto de ->" + SBCore.getNomeProjeto());
    }

    @Override
    public void definirConfiguracoesDeCookie(SessionCookieConfig pSEssao) {
        // nada aqui, site não gerencia mais de um domínio
    }

}
