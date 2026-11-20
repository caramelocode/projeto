/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.acoes.cliente;

import br.org.carameloCode.erp.modulo.projeto.FabModulosProjetoCaramelo;
import br.org.carameloCode.erp.modulo.projeto.InfoModuloProjetoCaraelo;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.requisito.RequisitoDeProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.super_bits.modulos.SBAcessosModel.fabricas.ComoFabricaDeAcoesPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoGestaoEntidade;

/**
 *
 * @author salvio
 */
@InfoModuloProjetoCaraelo(modulo = FabModulosProjetoCaramelo.CLIENTE)
public enum FabAcaoCliente implements ComoFabricaDeAcoesPersistencia {

    @InfoTipoAcaoGestaoEntidade(entidade = ProjetoCRC.class, icone = "fa fa-folder-open", nomeAcao = "Meus Projetos")
    PROJETO_CRC_MB_GESTAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-list")
    PROJETO_CRC_FRM_LISTAR_MEUS_PROJETOS,
    @InfoTipoAcaoFormulario(icone = "fa fa-eye")
    PROJETO_CRC_FRM_VISAO_GERAL,
    @InfoTipoAcaoGestaoEntidade(entidade = RequisitoDeProjeto.class, icone = "fa fa-list-check", nomeAcao = "Requisitos")
    REQUISITO_MB_GESTAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-plus")
    REQUISITO_FRM_NOVO;
}
