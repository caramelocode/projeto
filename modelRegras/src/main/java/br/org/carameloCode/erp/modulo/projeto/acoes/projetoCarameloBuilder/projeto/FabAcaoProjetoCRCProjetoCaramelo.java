/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.acoes.projetoCarameloBuilder.projeto;

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
public enum FabAcaoProjetoCRCProjetoCaramelo implements ComoFabricaDeAcoesPersistencia {

    @InfoTipoAcaoGestaoEntidade(entidade = ProjetoCRC.class, icone = "fa fa-folder-open")
    PROJETO_MB_GESTAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-list")
    PROJETO_FRM_LISTAR,
    @InfoTipoAcaoFormulario(icone = "fa fa-plus")
    PROJETO_FRM_NOVO,
    @InfoTipoAcaoFormulario(icone = "fa fa-pencil")
    PROJETO_FRM_EDITAR,
    @InfoTipoAcaoController(icone = "fa fa-floppy-o")
    PROJETO_CTR_SALVAR_MERGE,
    @InfoTipoAcaoController(icone = "fa fa-rocket")
    PROJETO_CTR_PUBLICAR,

}
