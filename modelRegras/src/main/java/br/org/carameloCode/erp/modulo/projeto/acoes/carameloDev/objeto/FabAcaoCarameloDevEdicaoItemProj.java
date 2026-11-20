/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.objeto;

import br.org.carameloCode.erp.modulo.projeto.FabModulosProjetoCaramelo;
import br.org.carameloCode.erp.modulo.projeto.InfoModuloProjetoCaraelo;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadesimples.CPAtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.api.model.atributoentidadeentidade.CPAtributoEntidadeEntidade;
import br.org.carameloCode.erp.modulo.projeto.api.model.atrubutoentidadelista.CPAtrubutoEntidadeLista;
import br.org.carameloCode.erp.modulo.projeto.api.model.fabricaentidadeprojcrc.CPFabricaEntidadeProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaEntidadeProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaStatusProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.ItemFabrica;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.ItemFabricaStatus;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeEntidade;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeLista;
import com.super_bits.modulos.SBAcessosModel.fabricas.ComoFabricaDeAcoesPersistencia;
import com.super_bits.modulos.SBAcessosModel.model.acoes.AcaoDoSistema;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.modulos.dinamico.TipoDadoDinamico;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoController;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoGestaoEntidade;

/**
 *
 * @author salvio
 */
@InfoModuloProjetoCaraelo(modulo = FabModulosProjetoCaramelo.CARAMELO_DEV)
public enum FabAcaoCarameloDevEdicaoItemProj implements ComoFabricaDeAcoesPersistencia {

    @InfoTipoAcaoGestaoEntidade(entidade = ObjetoProjCRC.class, icone = "fa fa-database", nomeAcao = "Gestão de entidades")
    ENTIDADE_MB_GESTAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-list")
    ENTIDADE_FRM_LISTAR,
    @InfoTipoAcaoFormulario(icone = "fa fa-pencil", campos = {"nome", "nomeEntidade", "icone", "plural", "generoFeminino", "descricao"})
    ENTIDADE_FRM_EDITAR,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o", entidade = ObjetoProjCRC.class, nomeAcao = "Nova Entidade do Projeto")
    ENTIDADE_CTR_SALVAR_NOVO,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o", entidade = ObjetoProjCRC.class, nomeAcao = "Salvar entidade")
    ENTIDADE_CTR_SALVAR_MERGE,
    @InfoTipoAcaoController(icone = "fa fa-check", entidade = ObjetoProjCRC.class, nomeAcao = "Validar entidade")
    ENTIDADE_CTR_VALIDAR,
    @InfoTipoAcaoController(icone = "fa fa-trash", entidade = ObjetoProjCRC.class, nomeAcao = "Remover entidade")
    ENTIDADE_CTR_REMOVER,
    @InfoTipoAcaoGestaoEntidade(entidade = AtributoDeEntidadeSimples.class, icone = "fa fa-list-ul", nomeAcao = "Atributos de Entidade")
    ATRIBUTO_ENTIDADE_MB_GESTAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-list")
    ATRIBUTO_ENTIDADE_FRM_LISTAR,
    @InfoTipoAcaoFormulario(icone = "fa fa-pencil", campos = {
        "[separador:Dados do ATributo]",
        CPAtributoDeEntidadeSimples.nomedeclarado,
        CPAtributoDeEntidadeSimples.obrigatorio, CPAtributoDeEntidadeSimples.tipo, CPAtributoDeEntidadeSimples.entidade, CPAtributoDeEntidadeSimples.label, CPAtributoDeEntidadeSimples.valormaximo, CPAtributoDeEntidadeSimples.valorminimo, CPAtributoDeEntidadeSimples.textopositivo})
    ATRIBUTO_ENTIDADE_FRM_EDITAR,
    @InfoTipoAcaoFormulario(icone = "fa fa-pencil", entidade = AtributoEntidadeEntidade.class, nomeAcao = "Editar atributo objeto", campos = {CPAtributoDeEntidadeSimples.nomedeclarado, CPAtributoEntidadeEntidade.entidadereferenciada,
        CPAtributoDeEntidadeSimples.obrigatorio, CPAtributoDeEntidadeSimples.tipo, CPAtributoDeEntidadeSimples.entidade})
    ATRIBUTO_ENTIDADE_FRM_EDITAR_OBJETO,
    @InfoTipoAcaoFormulario(icone = "fa fa-pencil", entidade = AtributoEntidadeLista.class, nomeAcao = "Editar atributo lista", campos = {CPAtributoDeEntidadeSimples.nomedeclarado, CPAtrubutoEntidadeLista.entidadeitemlista, CPAtrubutoEntidadeLista.caminholista,
        CPAtributoDeEntidadeSimples.obrigatorio, CPAtributoDeEntidadeSimples.tipo, CPAtributoDeEntidadeSimples.entidade})
    ATRIBUTO_ENTIDADE_FRM_EDITAR_LISTA,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o", entidade = AtributoDeEntidadeSimples.class, nomeAcao = "Novo Atributo de Entidade")
    ATRIBUTO_ENTIDADE_CTR_SALVAR_NOVO,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o", entidade = AtributoDeEntidadeSimples.class, nomeAcao = "Salvar atributo")
    ATRIBUTO_ENTIDADE_CTR_SALVAR_MERGE,
    @InfoTipoAcaoController(icone = "fa fa-check", entidade = AtributoDeEntidadeSimples.class, nomeAcao = "Validar atributo")
    ATRIBUTO_ENTIDADE_CTR_VALIDAR,
    @InfoTipoAcaoController(icone = "fa fa-trash", entidade = AtributoDeEntidadeSimples.class, nomeAcao = "Remover atributo")
    ATRIBUTO_ENTIDADE_CTR_REMOVER,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o", entidade = AtributoEntidadeEntidade.class, nomeAcao = "Novo Atributo de Entidade (Referência)")
    ATRIBUTO_ENTIDADE_CTR_SALVAR_NOVO_TP_ENTIDADE,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o", entidade = AtributoEntidadeEntidade.class, nomeAcao = "Salvar alterações do atributo objeto")
    ATRIBUTO_ENTIDADE_CTR_SALVAR_MERGE_TP_ENTIDADE,
    @InfoTipoAcaoController(icone = "fa fa-check", entidade = AtributoEntidadeEntidade.class, nomeAcao = "Validar atributo objeto")
    ATRIBUTO_ENTIDADE_CTR_VALIDAR_TP_ENTIDADE,
    @InfoTipoAcaoController(icone = "fa fa-trash", entidade = AtributoEntidadeEntidade.class, nomeAcao = "Remover atributo objeto")
    ATRIBUTO_ENTIDADE_CTR_REMOVER_TP_ENTIDADE,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o", entidade = AtributoEntidadeLista.class, nomeAcao = "Novo Atributo de Entidade (Lista)")
    ATRIBUTO_ENTIDADE_CTR_SALVAR_NOVO_TP_LISTA,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o", entidade = AtributoEntidadeLista.class, nomeAcao = "Salvar alterações do atributo lista")
    ATRIBUTO_ENTIDADE_CTR_SALVAR_MERGE_TP_LISTA,
    @InfoTipoAcaoController(icone = "fa fa-check", entidade = AtributoEntidadeLista.class, nomeAcao = "Validar atributo lista")
    ATRIBUTO_ENTIDADE_CTR_VALIDAR_TP_LISTA,
    @InfoTipoAcaoController(icone = "fa fa-trash", entidade = AtributoEntidadeLista.class, nomeAcao = "Remover atributo lista")
    ATRIBUTO_ENTIDADE_CTR_REMOVER_TP_LISTA,
    @InfoTipoAcaoFormulario(icone = "fa fa-eye", entidade = AtributoEntidadeEntidade.class)
    @InfoTipoAcaoGestaoEntidade(entidade = FabricaEntidadeProjCRC.class, icone = "fa fa-industry", nomeAcao = "Fábricas de objetos")
    FABRICA_GENERICA_MB_GESTAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-pencil", campos = {CPFabricaEntidadeProjCRC.modulo, CPFabricaEntidadeProjCRC.nomefabrica, "tipoObjetoPadrao", CPFabricaEntidadeProjCRC.descricao})
    FABRICA_GENERICA_FRM_EDITAR,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o", entidade = FabricaEntidadeProjCRC.class, nomeAcao = "Nova Fábrica do Projeto")
    FABRICA_GENERICA_CTR_SALVAR_NOVO,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o", entidade = FabricaEntidadeProjCRC.class)
    FABRICA_GENERICA_CTR_SALVAR_MERGE,
    @InfoTipoAcaoController(icone = "fa fa-check", entidade = FabricaEntidadeProjCRC.class, nomeAcao = "Validar fábrica")
    FABRICA_GENERICA_CTR_VALIDAR,
    @InfoTipoAcaoController(icone = "fa fa-trash", entidade = FabricaEntidadeProjCRC.class, nomeAcao = "Remover fábrica")
    FABRICA_GENERICA_CTR_REMOVER,
    @InfoTipoAcaoGestaoEntidade(entidade = FabricaStatusProjCRC.class,
            icone = "fa fa-traffic-light", nomeAcao = "Fábricas de status")
    FABRICA_STATUS_MB_GESTAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-pencil")
    FABRICA_STATUS_FRM_EDITAR,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o", entidade = FabricaStatusProjCRC.class, nomeAcao = "Nova Fábrica de Status")
    FABRICA_STATUS_CTR_SALVAR_NOVO,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o", entidade = FabricaStatusProjCRC.class)
    FABRICA_STATUS_CTR_SALVAR_MERGE,
    @InfoTipoAcaoController(icone = "fa fa-check", entidade = FabricaStatusProjCRC.class, nomeAcao = "Validar fábrica de status")
    FABRICA_STATUS_CTR_VALIDAR,
    @InfoTipoAcaoController(icone = "fa fa-trash", entidade = FabricaStatusProjCRC.class, nomeAcao = "Remover fábrica de status")
    FABRICA_STATUS_CTR_REMOVER,
    @InfoTipoAcaoGestaoEntidade(entidade = ItemFabrica.class, icone = "fa fa-cube", nomeAcao = "Itens de fábrica")
    ITEM_FABRICA_GENERICA_MB_GESTAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-pencil")
    ITEM_FABRICA_GENERICA_FRM_EDITAR,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o", entidade = ItemFabrica.class, nomeAcao = "Novo Item de Fábrica")
    ITEM_FABRICA_GENERICA_CTR_SALVAR_NOVO,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o", entidade = ItemFabrica.class)
    ITEM_FABRICA_GENERICA_CTR_SALVAR_MERGE,
    @InfoTipoAcaoController(icone = "fa fa-check", entidade = ItemFabrica.class, nomeAcao = "Validar item de fábrica")
    ITEM_FABRICA_GENERICA_CTR_VALIDAR,
    @InfoTipoAcaoController(icone = "fa fa-trash", entidade = ItemFabrica.class, nomeAcao = "Remover item de fábrica")
    ITEM_FABRICA_GENERICA_CTR_REMOVER,
    @InfoTipoAcaoGestaoEntidade(entidade = ItemFabricaStatus.class, icone = "fa fa-flag", nomeAcao = "Status de fábrica")
    ITEM_FABRICA_STATUS_MB_GESTAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-pencil")
    ITEM_FABRICA_STATUS_FRM_EDITAR,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o", entidade = ItemFabricaStatus.class, nomeAcao = "Novo Item de Fábrica de Status")
    ITEM_FABRICA_STATUS_CTR_SALVAR_NOVO,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o", entidade = ItemFabricaStatus.class)
    ITEM_FABRICA_STATUS_CTR_SALVAR_MERGE,
    @InfoTipoAcaoController(icone = "fa fa-check", entidade = ItemFabricaStatus.class, nomeAcao = "Validar status")
    ITEM_FABRICA_STATUS_CTR_VALIDAR,
    @InfoTipoAcaoController(icone = "fa fa-trash", entidade = ItemFabricaStatus.class, nomeAcao = "Remover status")
    ITEM_FABRICA_STATUS_CTR_REMOVER;

    /**
     * Tipo de item do projeto ao qual a ação pertence, usado para definir a
     * cor. Ações de pré-visualização não pertencem a um tipo de item.
     */
    public FabTipoItemProjeto getTipoItemProjeto() {
        String nome = name();
        if (nome.startsWith("ATRIBUTO_ENTIDADE_")) {
            return FabTipoItemProjeto.ATRIBUTO_OBJETO;
        }
        if (nome.startsWith("ENTIDADE_")) {
            return FabTipoItemProjeto.OBJETO;
        }
        if (nome.startsWith("FABRICA_STATUS_") || nome.startsWith("ITEM_FABRICA_STATUS_")) {
            return FabTipoItemProjeto.FABRICA_STATUS;
        }
        if (nome.startsWith("FABRICA_GENERICA_") || nome.startsWith("ITEM_FABRICA_GENERICA_")) {
            return FabTipoItemProjeto.FABRICA_ENTIDADE_GENERICA;
        }
        return null;
    }

    @Override

    public AcaoDoSistema getRegistro() {
        AcaoDoSistema acao = ComoFabricaDeAcoesPersistencia.super.getRegistro();
        FabTipoItemProjeto tipoItem = getTipoItemProjeto();
        if (tipoItem != null) {
            // Gestão: cor de destaque; formulários: cor padrão; controllers: cor discreta
            if (name().contains("_MB_")) {
                acao.setCor(tipoItem.getCorDestaque());
            } else if (name().contains("_FRM_")) {
                acao.setCor(tipoItem.getCorPadrao());
            } else {
                acao.setCor(tipoItem.getCorDiscreta());
            }
        }
        return acao;
    }

}
