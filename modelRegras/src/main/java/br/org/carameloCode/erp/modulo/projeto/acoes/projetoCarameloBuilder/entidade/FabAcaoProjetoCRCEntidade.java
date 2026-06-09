/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.acoes.projetoCarameloBuilder.entidade;

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
public enum FabAcaoProjetoCRCEntidade implements ComoFabricaDeAcoesPersistencia {

    @InfoTipoAcaoGestaoEntidade(entidade = ObjetoProjCRC.class, icone = "fa fa-database")
    ENTIDADE_MB_GESTAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-list")
    ENTIDADE_FRM_LISTAR,
    @InfoTipoAcaoFormulario(icone = "fa fa-pencil")
    ENTIDADE_FRM_EDITAR,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o")
    ENTIDADE_CTR_SALVAR
}
