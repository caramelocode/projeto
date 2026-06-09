/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.orcamento;

import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.acoes.ComoAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.fabrica.ComoFabricaStatus;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salvio
 */
public enum FabStatusOrcamento implements ComoFabricaStatus {

    PRE_ORCAMENTO,
    REQUISITO,
    DESENVOLVIMENTO,
    ENTREGUE,
    ATRASO;

    @Override
    public List<ComoAcaoDoSistema> opcoesPorStatus() {
        return new ArrayList<>();
    }
}
