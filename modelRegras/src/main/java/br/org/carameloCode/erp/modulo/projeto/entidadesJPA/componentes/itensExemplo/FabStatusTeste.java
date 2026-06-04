/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.itensExemplo;

import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.acoes.ComoAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.fabrica.ComoFabricaStatus;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoDaFabrica;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salvio
 */
public enum FabStatusTeste implements ComoFabricaStatus {

    @InfoObjetoDaFabrica(classeObjeto = StatusTeste.class)
    STATUS_TESTE;

    @Override
    public List<ComoAcaoDoSistema> opcoesPorStatus() {
        return new ArrayList<>();
    }
}
