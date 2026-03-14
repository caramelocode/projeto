/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.carameloCode.erp.modulo.projeto;

import com.super_bits.modulos.SBAcessosModel.model.ModuloAcaoSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.modulo.ComoFabricaModulo;
import com.super_bits.modulosSB.SBCore.modulos.fabrica.ComoFabrica;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 *
 * @author desenvolvedor
 */
@Entity
@InfoObjetoSB(tags = "Modulo do Projeto INomeDoProjetoI", plural = "modulos")
public class ModuloProjetoCaramelo extends ModuloAcaoSistema {

    @InfoCampo(tipo = FabTipoAtributoObjeto.ENUM_FABRICA)
    @Enumerated(EnumType.STRING)
    private FabModulosProjetoCaramelo fabModulo;

    @Override
    public ComoFabricaModulo getEnumVinculado() {
        return fabModulo;
    }

    @Override
    public void setEnumVinculado(ComoFabrica pFabrica) {
        fabModulo = (FabModulosProjetoCaramelo) pFabrica;
    }

}
