/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.carameloCode.erp.projeto.config;

import br.org.carameloCode.erp.crm.config.ConfigCoreWebAppProjetosCaramelo;
import br.org.carameloCode.erp.crm.config.ConfigWP_CRM_CarameloCode;
import br.org.carameloCode.erp.modulo.projeto.config.ConfigPersistenciaProjetoCaramelo;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.SBPersistencia;

import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.webPaginas.ConfigGeral.SBWebPaginas;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import testesFW.TesteJunitSBPersistencia;

/**
 *
 * @author desenvolvedor
 */
public class TesteWPProjetoCarameloCode extends TesteJunitSBPersistencia {

    @Override
    protected void configAmbienteDesevolvimento() {
        SBCore.configurar(new ConfigCoreWebAppProjetosCaramelo(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        SBPersistencia.configuraJPA(new ConfigPersistenciaProjetoCaramelo(), true, false);
        try {
            SBWebPaginas.configurar(new ConfigWP_CRM_CarameloCode());
        } catch (IOException ex) {
            Logger.getLogger(TesteWPProjetoCarameloCode.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
