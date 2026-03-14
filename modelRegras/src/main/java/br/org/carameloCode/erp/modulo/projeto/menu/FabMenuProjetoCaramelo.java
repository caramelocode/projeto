/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.menu;

import com.super_bits.modulosSB.SBCore.modulos.view.menu.ComoFabricaMenu;
import com.super_bits.modulosSB.SBCore.modulos.view.menu.ComoMenuSB;

/**
 *
 * @author salvio
 */
public enum FabMenuProjetoCaramelo implements ComoFabricaMenu {

    CARAMELO_DEV,
    CARAMELO_DEV_ADMIN,
    FABRICA_DE_SOFTWARE_ADMIN,
    PLATAFORMA_ADMIN,
    CLIENTE;

    @Override
    public ComoMenuSB getMenuPrincipal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ComoMenuSB getMenuSecundario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
