/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.carameloCode.erp.modulo.projeto;

import br.org.carameloCode.erp.modulo.projeto.menu.FabMenuProjetoCaramelo;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.modulo.ComoFabricaModulo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoDaFabrica;
import com.super_bits.modulosSB.SBCore.modulos.view.menu.ComoFabricaMenu;

/**
 *
 *
 *
 *
 *
 * @author Salvio Furbino
 */
public enum FabModulosProjetoCaramelo implements ComoFabricaModulo {

    @InfoObjetoDaFabrica(nomeObjeto = "Anônimo", classeObjeto = ModuloProjetoCaramelo.class)
    ANONIMO,
    @InfoObjetoDaFabrica(nomeObjeto = "Caramelo Code Projeto Dev", classeObjeto = ModuloProjetoCaramelo.class)
    CARAMELO_DEV,
    @InfoObjetoDaFabrica(nomeObjeto = "Caramelo Code Projeto Dev Admin", classeObjeto = ModuloProjetoCaramelo.class)
    CARAMELO_DEV_ADMIN,
    @InfoObjetoDaFabrica(nomeObjeto = "Caramelo Code Projeto PLataforma Admin", classeObjeto = ModuloProjetoCaramelo.class)
    PLATAFORMA_ADMIN,
    @InfoObjetoDaFabrica(nomeObjeto = "Caramelo Code Projeto Cliente", classeObjeto = ModuloProjetoCaramelo.class)
    CLIENTE;

    @Override
    public ComoFabricaMenu getMenuPadrao() {
        return FabMenuProjetoCaramelo.CARAMELO_DEV_ADMIN;
    }
}
