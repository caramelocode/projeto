/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.super_bits.Casa_Nova.Intranet_Marketing_Digital.configAppp;

import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import org.coletivojava.fw.api.tratamentoErros.FabErro;
import org.junit.Test;

/**
 *
 *
 *
 * @author salvio
 */
public class TesteConformidade extends TesteProjetoCaramelo {

    @Test
    public void gerarCodigo() {
        try {

            gerarCodigoModelProjeto();
        } catch (Throwable t) {
            SBCore.RelatarErro(FabErro.SOLICITAR_REPARO, "Falha gerando Model", t);
            fail(t.getMessage());
        }
    }
}
