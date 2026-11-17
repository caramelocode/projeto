/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.status;

import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.acoes.ComoAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.fabrica.ComoFabricaStatus;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoDaFabrica;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salvio
 */
public enum FabStatusProjeto implements ComoFabricaStatus {
    @InfoObjetoDaFabrica(id = 1l, nomeObjeto = "Desenvolvimento", cor = "#F39C12", icone = "fa fa-code", classeObjeto = StatusProjeto.class)
    DESENVOLVIMENTO,
    @InfoObjetoDaFabrica(id = 2l, nomeObjeto = "Build realizado", cor = "#3498DB", icone = "fa fa-cogs", classeObjeto = StatusProjeto.class)
    BUILD_REALIZADO,
    @InfoObjetoDaFabrica(id = 3l, nomeObjeto = "Publicado", cor = "#27AE60", icone = "fa fa-rocket", classeObjeto = StatusProjeto.class)
    PUBLICADO,
    @InfoObjetoDaFabrica(id = 4l, nomeObjeto = "Em atualização", cor = "#8E44AD", icone = "fa fa-sync-alt", classeObjeto = StatusProjeto.class)
    EM_ATUALIZACAO;

    @Override
    public List<ComoAcaoDoSistema> opcoesPorStatus() {
        return new ArrayList<>();
    }
}
