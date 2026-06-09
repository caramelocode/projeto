/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.acoes.projetoCarameloBuilder.console;

import br.org.carameloCode.erp.modulo.projeto.FabModulosProjetoCaramelo;
import br.org.carameloCode.erp.modulo.projeto.InfoModuloProjetoCaraelo;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import com.super_bits.modulos.SBAcessosModel.fabricas.ComoFabricaDeAcoesPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoController;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoGestaoEntidade;

/**
 *
 * @author salvio
 */
@InfoModuloProjetoCaraelo(modulo = FabModulosProjetoCaramelo.CARAMELO_DEV)
public enum FabAcaoProjetoCRCConsole implements ComoFabricaDeAcoesPersistencia {

    @InfoTipoAcaoGestaoEntidade(entidade = ObjetoProjCRC.class, utilizarMesmoFormEdicao = false, descricao = "Console para edição de itens do projeto", icone = "fa fa-terminal")
    CONSOLE_ITEM_PROJ_MB_GESTAO,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o")
    CONSOLE_ITEM_PROJ_CTR_SALVAR,
    @InfoTipoAcaoFormulario(icone = "fa fa-list")
    CONSOLE_ITEM_PROJ_FRM_LISTAR_ACAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-plus")
    CONSOLE_ITEM_PROJ_FRM_CRIAR_ACAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-pencil")
    CONSOLE_ITEM_PROJ_FRM_EDITAR_ACAO,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o")
    CONSOLE_ITEM_PROJ_CTR_SALVAR_ACAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-list")
    CONSOLE_ITEM_PROJ_FRM_LISTAR_ENTIDADE,
    @InfoTipoAcaoFormulario(icone = "fa fa-plus")
    CONSOLE_ITEM_PROJ_FRM_NOVO_ENTIDADE,
    @InfoTipoAcaoFormulario(icone = "fa fa-pencil")
    CONSOLE_ITEM_PROJ_FRM_EDITAR_ENTIDADE,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o")
    CONSOLE_ITEM_PROJ_CTR_SALVAR_ENTIDADE,
    @InfoTipoAcaoFormulario(icone = "fa fa-plus-square-o")
    CONSOLE_ITEM_PROJ_FRM_ATRIBUTO_ENTIDADE_NOVO,
    @InfoTipoAcaoFormulario(icone = "fa fa-pencil-square-o")
    CONSOLE_ITEM_PROJ_FRM_ATRIBUTO_ENTIDADE_EDITAR,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o")
    CONSOLE_ITEM_PROJ_CTR_SALVAR_ATRIBUTO_ENTIDADE,
}
