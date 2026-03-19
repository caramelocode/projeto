/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes;

import com.super_bits.modulosSB.Persistencia.fabrica.ComoFabricaComPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoDaFabrica;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;

/**
 *
 * @author salvio
 */
public enum FabExemploComponenteNativo
        implements ComoFabricaComPersistencia {

    @InfoObjetoDaFabrica(classeObjeto = ExemploComponenteInput.class, id = 1l, nomeObjeto = "CELULAR")
    TELEFONE_CELULAR,
    @InfoObjetoDaFabrica(classeObjeto = ExemploComponenteInput.class, id = 2l, nomeObjeto = "WHATSAPP")
    TELEFONE_WHATSAPPP,
    @InfoObjetoDaFabrica(classeObjeto = ExemploComponenteInput.class, id = 3l, nomeObjeto = "TELGENERICO")
    TELEFONE_GENERICO,
    @InfoObjetoDaFabrica(classeObjeto = ExemploComponenteInput.class, id = 4l, nomeObjeto = "CNPJ")
    CNPJ;

    public ExemploComponente getRegistro() {
        ExemploComponente novoExemplo = (ExemploComponente) ComoFabricaComPersistencia.super.getRegistro(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

        switch (this) {

            case TELEFONE_CELULAR:
                novoExemplo.setLabel("Celular");
                novoExemplo.setFabricaTipoAtributo(FabTipoAtributoObjeto.TELEFONE_CELULAR);
                break;
            case TELEFONE_WHATSAPPP:
                novoExemplo.setLabel("Whatsapp");
                novoExemplo.setFabricaTipoAtributo(FabTipoAtributoObjeto.TELEFONE_GENERICO);
                break;
            case TELEFONE_GENERICO:
                novoExemplo.setLabel("Telefone Generico");
                novoExemplo.setFabricaTipoAtributo(FabTipoAtributoObjeto.TELEFONE_GENERICO);
                break;
            case CNPJ:
                novoExemplo.setLabel("Cnpj");
                novoExemplo.setFabricaTipoAtributo(FabTipoAtributoObjeto.CNPJ);

                break;
            default:
                throw new AssertionError();
        }

        return novoExemplo;
    }

}
