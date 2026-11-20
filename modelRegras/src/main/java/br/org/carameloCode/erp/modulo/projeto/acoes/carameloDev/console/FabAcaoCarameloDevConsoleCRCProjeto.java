/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.console;

import br.org.carameloCode.erp.modulo.projeto.FabModulosProjetoCaramelo;
import br.org.carameloCode.erp.modulo.projeto.InfoModuloProjetoCaraelo;
import br.org.carameloCode.erp.modulo.projeto.console.ConsoleCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRCContoller;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRCFormulario;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRCGestao;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoStatusProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaEntidadeProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaStatusProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fluxoTeste.FluxodoProjetoCRC;
import com.super_bits.modulos.SBAcessosModel.fabricas.ComoFabricaDeAcoesPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoController;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoGestaoEntidade;

/**
 *
 * @author salvio
 */
@InfoModuloProjetoCaraelo(modulo = FabModulosProjetoCaramelo.CARAMELO_DEV)
public enum FabAcaoCarameloDevConsoleCRCProjeto implements ComoFabricaDeAcoesPersistencia {

    @InfoTipoAcaoGestaoEntidade(entidade = ConsoleCRCProjeto.class, utilizarMesmoFormEdicao = false, descricao = "Console para edição de itens do projeto", icone = "fa fa-terminal")
    CONSOLE_ITEM_PROJ_MB_GESTAO,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o")
    @InfoTipoAcaoFormulario(icone = "fa fa-list")
    CONSOLE_ITEM_PROJ_FRM_LISTAR,
    @InfoTipoAcaoGestaoEntidade(entidade = ConsoleCRCProjeto.class, utilizarMesmoFormEdicao = false, descricao = "Console para edição de itens do projeto", icone = "fa fa-terminal")
    DASHBOARD_PROJETO_MB_GESTAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-list")
    DASHBOARD_PROJETO_FRM_VISAO_GERAL,
    @InfoTipoAcaoFormulario(icone = "fa fa-list")
    DASHBOARD_PROJETO_FRM_ENTIDADES,
    @InfoTipoAcaoFormulario(icone = "fa fa-list")
    DASHBOARD_PROJETO_FRM_FABRICAS,
    @InfoTipoAcaoFormulario(icone = "fa fa-list")
    DASHBOARD_PROJETO_FRM_REQUISITOS,
    @InfoTipoAcaoFormulario(icone = "fa fa-list")
    DASHBOARD_PROJETO_FRM_COMPONENTES,
    @InfoTipoAcaoFormulario(icone = "fa fa-list")
    DASHBOARD_PROJETO_FRM_FLUXO_TESTES,
    @InfoTipoAcaoGestaoEntidade(entidade = AtributoDeEntidadeSimples.class, icone = "fa fa-eye")
    PREV_ATRIBUTO_PROJ_MB_GESTAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-eye", entidade = ObjetoProjCRC.class)
    PREV_ATRIBUTO_PROJ_FRM_VISUALIZAR_ATRIBUTO,
    @InfoTipoAcaoGestaoEntidade(entidade = ObjetoProjCRC.class, icone = "fa fa-eye")
    PREV_OBJETO_PROJ_MB_GESTAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-eye", entidade = ObjetoProjCRC.class)
    PREV_OBJETO_PROJ_FRM_GENERICO,
    @InfoTipoAcaoFormulario(icone = "fa fa-eye", entidade = ObjetoStatusProjCRC.class)
    PREV_OBJETO_PROJ_FRM_STATUS,
    @InfoTipoAcaoGestaoEntidade(entidade = FabricaEntidadeProjCRC.class, icone = "fa fa-eye")
    PREV_FABRICA_MB_GESTAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-eye", entidade = FabricaEntidadeProjCRC.class)
    PREV_FABRICA_FRM_FABRICA_GENERICA,
    @InfoTipoAcaoFormulario(icone = "fa fa-eye", entidade = FabricaStatusProjCRC.class)
    PREV_FABRICA_FRM_FABRICA_STATUS,
    @InfoTipoAcaoGestaoEntidade(entidade = AcaoProjCRC.class, icone = "fa fa-eye")
    PREV_ACAO_MB_GESTAO,
    @InfoTipoAcaoFormulario(entidade = AcaoProjCRCFormulario.class, icone = "fa fa-eye")
    PREV_ACAO_FRM_AC_FORMULARIO,
    @InfoTipoAcaoFormulario(entidade = AcaoProjCRCContoller.class, icone = "fa fa-eye")
    PREV_ACAO_FRM_AC_CONTROLLER,
    @InfoTipoAcaoFormulario(entidade = AcaoProjCRCGestao.class, icone = "fa fa-eye")
    PREV_ACAO_FRM_AC_GESTAO,
    @InfoTipoAcaoGestaoEntidade(entidade = FluxodoProjetoCRC.class, icone = "fa fa-eye")
    PREV_FLUXO_TESTES_MB_GESTAO,
    @InfoTipoAcaoFormulario(entidade = FluxodoProjetoCRC.class, icone = "fa fa-eye")
    PREV_FLUXO_TESTES_FRM_LISTAR,
    @InfoTipoAcaoFormulario(entidade = FluxodoProjetoCRC.class, icone = "fa fa-eye")
    PREV_FLUXO_TESTES_FRM_VER_FLUXO,

}
