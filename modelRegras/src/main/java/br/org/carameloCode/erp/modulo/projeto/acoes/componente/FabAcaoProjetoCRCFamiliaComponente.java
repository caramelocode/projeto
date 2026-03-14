/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.acoes.componente;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.familia.FamiliaComponenteProjetoCaramelo;
import com.super_bits.modulos.SBAcessosModel.fabricas.ComoFabricaDeAcoesPersistencia;
import com.super_bits.modulosSB.Persistencia.fabrica.ComoFabricaComPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoGestaoEntidade;
import com.super_bits.modulosSB.SBCore.modulos.fabrica.ComoFabricaAcoes;

/**
 *
 * @author salvio
 */
public enum FabAcaoProjetoCRCFamiliaComponente implements ComoFabricaDeAcoesPersistencia {

    @InfoTipoAcaoGestaoEntidade(entidade = FamiliaComponenteProjetoCaramelo.class)
    FAMILIA_COMPONENTE_GESTAO_MB,
    @InfoTipoAcaoFormulario(campos = {"id", "nome"})
    FAMILIA_COMPONENTE_FRM_LISTAR,

}
