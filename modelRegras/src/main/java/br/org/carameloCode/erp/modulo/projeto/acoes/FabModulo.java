package br.org.carameloCode.erp.modulo.projeto.acoes;

import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfModuloAcaoSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.modulo.ComoFabricaModulo;
import com.super_bits.modulosSB.SBCore.modulos.view.menu.ComoFabricaMenu;

/**
 *
 * @author salvio
 */
public enum FabModulo implements ComoFabricaModulo {

    DEMONSTRACAO,
    PROJETO_BUILDER,
    CLIENTE,
    GESTOR_FABRICA_SOFTWARE;

    @Override
    public ItfModuloAcaoSistema getModulo() {
        return ComoFabricaModulo.super.getModulo(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public ItfModuloAcaoSistema getRegistro() {
        return ComoFabricaModulo.super.getRegistro(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public ComoFabricaMenu getMenuPadrao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
