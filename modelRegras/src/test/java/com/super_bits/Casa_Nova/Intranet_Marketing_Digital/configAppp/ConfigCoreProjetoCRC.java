/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.super_bits.Casa_Nova.Intranet_Marketing_Digital.configAppp;

import br.org.carameloCode.erp.modulo.notificacao.controller.ServicoNotificacaoPadraoDev;
import br.org.carameloCode.erp.modulo.projeto.UtilProjetosCRC;
import br.org.carameloCode.erp.modulo.projeto.config.ConfigPermissaoProjetoCRC;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.ConfiguradorCoreDeProjetoJarPersistenciaAbstrato;
import com.super_bits.modulosSB.SBCore.ConfigGeral.ItfConfiguracaoCoreCustomizavel;
import com.super_bits.modulosSB.webPaginas.centralComunicacao.CentralComunicaoWebPadrao;

/**
 *
 * @author salvio
 */
public class ConfigCoreProjetoCRC extends ConfiguradorCoreDeProjetoJarPersistenciaAbstrato {

    @Override
    public void defineClassesBasicas(ItfConfiguracaoCoreCustomizavel pConfiguracao) {
        super.defineClassesBasicas(pConfiguracao);
        pConfiguracao.setCentralComunicacao(ServicoNotificacaoPadraoDev.class);
        pConfiguracao.setClasseConfigPermissao(ConfigPermissaoProjetoCRC.class);
    }

    @Override
    public void defineFabricasDeACao(ItfConfiguracaoCoreCustomizavel pConfig) {
        pConfig.setFabricaDeAcoes(UtilProjetosCRC.pAcoesDoSistema());

    }

}
