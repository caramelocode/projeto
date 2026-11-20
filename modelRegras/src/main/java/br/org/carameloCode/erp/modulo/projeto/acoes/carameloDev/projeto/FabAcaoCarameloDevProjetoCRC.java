/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.projeto;

import br.org.carameloCode.erp.modulo.projeto.FabModulosProjetoCaramelo;
import br.org.carameloCode.erp.modulo.projeto.InfoModuloProjetoCaraelo;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fluxoTeste.FluxodoProjetoCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.requisito.RequisitoDeProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.modulo.ModuloProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.super_bits.modulos.SBAcessosModel.fabricas.ComoFabricaDeAcoesPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoController;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoGestaoEntidade;

/**
 *
 * @author salvio
 */
@InfoModuloProjetoCaraelo(modulo = FabModulosProjetoCaramelo.CARAMELO_DEV)
public enum FabAcaoCarameloDevProjetoCRC implements ComoFabricaDeAcoesPersistencia {

    @InfoTipoAcaoGestaoEntidade(entidade = ProjetoCRC.class, icone = "fa fa-folder-open", nomeAcao = "Projetos CarameloCODE")
    PROJETO_MB_GESTAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-list")
    PROJETO_FRM_LISTAR,
    @InfoTipoAcaoFormulario(icone = "fa fa-plus")
    PROJETO_FRM_NOVO,
    @InfoTipoAcaoFormulario(icone = "fa fa-pencil")
    PROJETO_FRM_EDITAR,
    @InfoTipoAcaoController(icone = "fa fa-floppy-disk")
    PROJETO_CTR_SALVAR_MERGE,
    @InfoTipoAcaoController(icone = "fa fa-rocket")
    PROJETO_CTR_PUBLICAR,
    @InfoTipoAcaoGestaoEntidade(entidade = RequisitoDeProjeto.class, icone = "fa fa-list-check", nomeAcao = "Requisitos do Projeto")
    REQUISITO_MB_GESTAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-list")
    REQUISITO_FRM_LISTAR,
    @InfoTipoAcaoFormulario(icone = "fa fa-plus")
    REQUISITO_FRM_NOVO,
    @InfoTipoAcaoFormulario(icone = "fa fa-pencil")
    REQUISITO_FRM_EDITAR,
    @InfoTipoAcaoController(icone = "fa fa-floppy-disk")
    REQUISITO_CTR_SALVAR_MERGE,
    @InfoTipoAcaoGestaoEntidade(entidade = ModuloProjCRC.class, icone = "fa fa-cubes", nomeAcao = "Módulos do Projeto")
    MODULO_MB_GESTAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-list")
    MODULO_FRM_LISTAR,
    @InfoTipoAcaoFormulario(icone = "fa fa-plus")
    MODULO_FRM_NOVO,
    @InfoTipoAcaoFormulario(icone = "fa fa-pencil")
    MODULO_FRM_EDITAR,
    @InfoTipoAcaoController(icone = "fa fa-floppy-disk")
    MODULO_CTR_SALVAR_MERGE,
    @InfoTipoAcaoGestaoEntidade(entidade = FluxodoProjetoCRC.class, icone = "fa fa-vial-circle-check", nomeAcao = "Fluxos de Teste")
    FLUXO_TESTE_MB_GESTAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-list")
    FLUXO_TESTE_FRM_LISTAR,
    @InfoTipoAcaoFormulario(icone = "fa fa-plus")
    FLUXO_TESTE_FRM_NOVO,
    @InfoTipoAcaoFormulario(icone = "fa fa-pencil")
    FLUXO_TESTE_FRM_EDITAR,
    @InfoTipoAcaoController(icone = "fa fa-floppy-disk")
    FLUXO_TESTE_CTR_SALVAR_MERGE;
}
