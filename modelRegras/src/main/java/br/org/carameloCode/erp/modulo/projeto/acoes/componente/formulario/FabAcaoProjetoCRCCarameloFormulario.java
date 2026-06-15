/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.acoes.componente.formulario;

import br.org.carameloCode.erp.modulo.projeto.FabModulosProjetoCaramelo;
import br.org.carameloCode.erp.modulo.projeto.InfoModuloProjetoCaraelo;
import br.org.carameloCode.erp.modulo.projeto.api.model.entdexemplo.CPEntdExemplo;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.entidadeExemplo.EntdExemplo;
import com.super_bits.modulos.SBAcessosModel.fabricas.ComoFabricaDeAcoesPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoController;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoGestaoEntidade;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.FabTipoComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.view.modeloFormulario.ModeloPagina;

/**
 *
 * @author salvio
 */
@InfoModuloProjetoCaraelo(modulo = FabModulosProjetoCaramelo.CARAMELO_DEV)
public enum FabAcaoProjetoCRCCarameloFormulario implements ComoFabricaDeAcoesPersistencia {

    @InfoTipoAcaoGestaoEntidade(entidade = EntdExemplo.class, icone = "fa fa-wpforms ", nomeAcao = "Formulários Crud")
    CRUD_EXEMPLO_MB_GESTAO,
    @InfoTipoAcaoFormulario()
    CRUD_EXEMPLO_FRM_LISTAR,
    @InfoTipoAcaoFormulario()
    CRUD_EXEMPLO_FRM_LISTAR_MODELO2,
    @InfoTipoAcaoFormulario(campos = {"[separador: Campos Básicos]", CPEntdExemplo.nome, CPEntdExemplo.descricao,
        "[separador: Temporas]", CPEntdExemplo.data, CPEntdExemplo.datahora, CPEntdExemplo.hora})
    CRUD_EXEMPLO_FRM_NOVO,
    @InfoTipoAcaoFormulario(campos = {"[separador: Campos Básicos]", CPEntdExemplo.nome, CPEntdExemplo.descricao, CPEntdExemplo.usuariocliente,
        "[separador: Temporas]", CPEntdExemplo.data, CPEntdExemplo.datahora, CPEntdExemplo.hora})
    CRUD_EXEMPLO_FRM_EDITAR,
    @InfoTipoAcaoFormulario()
    CRUD_EXEMPLO_FRM_VISUALIZAR,
    @InfoTipoAcaoController(precisaPermissao = true, precisaJustificativa = true, comunicacao = FabTipoComunicacao.OK_CANCELAR)
    CRUD_EXEMPLO_CTR_ATIVAR_DESATIVAR,
    @InfoTipoAcaoController()
    CRUD_EXEMPLO_CTR_SALVAR_MERGE,
    @InfoTipoAcaoController()
    CRUD_EXEMPLO_CTR_SALVAR_REMOVER,
    @InfoTipoAcaoGestaoEntidade(entidade = ModeloPagina.class)
    FORMMULARIO_PERSONALIZADO_MB_GESTAO,
    @InfoTipoAcaoFormulario()
    FORMMULARIO_PERSONALIZADO_FRM_LISTAR,
    @InfoTipoAcaoFormulario()
    FORMMULARIO_PERSONALIZADO_FRM_VISUALIZAR;

}
