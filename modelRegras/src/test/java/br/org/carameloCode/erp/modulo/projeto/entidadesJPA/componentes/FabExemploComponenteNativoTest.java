/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes;

import com.super_bits.Casa_Nova.Intranet_Marketing_Digital.configAppp.TesteProjetoCaramelo;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;
import org.coletivojava.fw.api.tratamentoErros.FabErro;
import org.junit.Test;

/**
 *
 * @author salvio
 */
public class FabExemploComponenteNativoTest extends TesteProjetoCaramelo {

    public FabExemploComponenteNativoTest() {
    }

    /**
     * Test of values method, of class FabExemploComponenteNativo.
     */
    @Test
    public void testValues() {
        try {
            ExemploComponenteInput exemplo = (ExemploComponenteInput) FabExemploComponenteNativo.TELEFONE_CELULAR.getRegistro();
            printDadosCampoInstanciado(exemplo.getComoCampoInstanciado());
            printDadosCampoInstanciado(exemplo.getCPinst("nome"));

        } catch (Throwable t) {
            SBCore.RelatarErro(FabErro.SOLICITAR_REPARO, "Falha criando whatsapp", t);
        }
    }

    public void printDadosCampoInstanciado(ItfCampoInstanciado pCampoInstanciado) {
        System.out.println("##############################");
        System.out.println(pCampoInstanciado.getLabel());
        System.out.println(pCampoInstanciado.getFabricaTipoAtributo());
        System.out.println(pCampoInstanciado.getNomeCompostoIdentificador());
        System.out.println(pCampoInstanciado.getNomeClasseAtributoDeclarado());
        System.out.println(pCampoInstanciado.getNome());
        System.out.println(pCampoInstanciado);
        System.out.println("##############################");
    }

}
