/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.carameloCode.erp.projeto.config;

import br.org.carameloCode.erp.modulo.projeto.config.ConfigPersistenciaProjetoCaramelo;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.SBPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.webPaginas.ConfigGeral.SBWebPaginas;
import br.org.caramelo.web.testesFW.webApp.testes.RelatorioTesteWebPaginas;
import br.org.carameloCode.erp.modulo.notificacao.api.FabAcaoNotificacaoPadraoSB;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import com.super_bits.modulos.SBAcessosModel.view.FabAcaoPaginasDoSistema;

/**
 *
 * @author desenvolvedor
 */
public class TesteConformidadeTest extends RelatorioTesteWebPaginas {

    @Test
    public void teste() {
        try {

            System.out.println(FabAcaoPaginasDoSistema.PAGINA_NATIVA_TOKEN_DINAMICO_MB.getRegistro().getNomeUnico());
            gerarMangedBeansAcessoAcoes();
            exibirRelatorioCompleto();
            System.out.println(FabAcaoNotificacaoPadraoSB.NOTIFICACAO_FRM_NOVO.getRegistro().getComoFormulario().getXhtml());
            System.out.println(FabAcaoNotificacaoPadraoSB.TIPO_NOTIFICACAO_FRM_EDITAR.getRegistro().getComoFormulario().getXhtml());
            System.out.println(FabAcaoNotificacaoPadraoSB.TIPO_NOTIFICACAO_FRM_VISUALIZAR.getRegistro().getComoFormulario().getXhtml());
            SBCore.getServicoMensagens().enviarMsgAlertaAoDesenvolvedor("Teste");
        } catch (Throwable t) {
            lancarErroJUnit(t);
        }
    }

    @Override
    protected void configAmbienteDesevolvimento() {
        SBCore.configurar(new ConfigCoreWebAppProjetosCaramelo(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        SBPersistencia.configuraJPA(new ConfigPersistenciaProjetoCaramelo(), true, true);
        try {
            SBWebPaginas.configurar(new ConfigWP_PROJETO_CarameloCode());
        } catch (IOException ex) {
            Logger.getLogger(TesteConformidadeTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
