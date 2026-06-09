/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.acoes.projetoCarameloBuilder.requisito;

import br.org.carameloCode.erp.modulo.projeto.FabModulosProjetoCaramelo;
import br.org.carameloCode.erp.modulo.projeto.InfoModuloProjetoCaraelo;
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
public enum FabAcaoProjetoCRCRequisito implements ComoFabricaDeAcoesPersistencia {

    @InfoTipoAcaoGestaoEntidade(entidade = ProjetoCRC.class, icone = "fa fa-tasks")
    REQUISITO_MB_GESTAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-plus")
    REQUISITO_FRM_NOVO,
    @InfoTipoAcaoFormulario(icone = "fa fa-pencil")
    REQUISITO_FRM_EDITAR,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o")
    REQUISITO_CTR_SALVAR;

}
