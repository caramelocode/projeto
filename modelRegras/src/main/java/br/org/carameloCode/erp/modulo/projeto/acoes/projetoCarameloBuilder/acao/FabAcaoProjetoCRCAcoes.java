/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.acoes.projetoCarameloBuilder.acao;

import br.org.carameloCode.erp.modulo.projeto.FabModulosProjetoCaramelo;
import br.org.carameloCode.erp.modulo.projeto.InfoModuloProjetoCaraelo;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRC;
import com.super_bits.modulos.SBAcessosModel.fabricas.ComoFabricaDeAcoesPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoController;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoGestaoEntidade;

/**
 *
 * @author salvio
 */
@InfoModuloProjetoCaraelo(modulo = FabModulosProjetoCaramelo.CARAMELO_DEV)
public enum FabAcaoProjetoCRCAcoes implements ComoFabricaDeAcoesPersistencia {

    @InfoTipoAcaoGestaoEntidade(entidade = AcaoProjCRC.class, icone = "fa fa-list-alt")
    ACOES_MB_GESTAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-eye")
    ACOES_FRM_VISAO_GERAL,
    @InfoTipoAcaoFormulario(icone = "fa fa-list")
    ACOES_FRM_LISTAR_GESTAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-list-ul")
    ACOES_FRM_LISTAR_SUBACAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-pencil-square-o")
    ACOES_FRM_EDITAR_ACAO_FORMULARIO,
    @InfoTipoAcaoFormulario(icone = "fa fa-cogs")
    ACOES_FRM_EDITAR_ACAO_CONTROLLER,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o")
    ACOES_CTR_SALVAR

}
