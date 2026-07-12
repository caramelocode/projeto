/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.entidadeExemplo;

import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import javax.persistence.Entity;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(plural = "Subitens exemplo", tags = "subItem")
public class EntdExtendidaExemplo extends EntdExemplo {

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES)
    private String exemploCpEntdExetendida;

    public String getExemploCpEntdExetendida() {
        return exemploCpEntdExetendida;
    }

    public void setExemploCpEntdExetendida(String exemploCpEntdExetendida) {
        this.exemploCpEntdExetendida = exemploCpEntdExetendida;
    }

}
