/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.acoes.componente.nativo;

import br.org.carameloCode.erp.modulo.projeto.FabModulosProjetoCaramelo;
import br.org.carameloCode.erp.modulo.projeto.InfoModuloProjetoCaraelo;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.ExemploComponente;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.ExemploComponenteInput;
import com.super_bits.modulos.SBAcessosModel.fabricas.ComoFabricaDeAcoesPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoController;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoGestaoEntidade;

/**
 *
 * @author salvio
 */
@InfoModuloProjetoCaraelo(modulo = FabModulosProjetoCaramelo.CARAMELO_DEV)
public enum FabAcaoProjetoCRCComponenteNativo implements ComoFabricaDeAcoesPersistencia {

    @InfoTipoAcaoGestaoEntidade(entidade = ExemploComponente.class, icone = "fa fa-object-group ")
    COMPONENTE_NATIVO_MB_GESTAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-object-group ")
    COMPONENTE_NATIVO_FRM_LISTAR,
    @InfoTipoAcaoFormulario(icone = "fa fa-th-large", entidade = ExemploComponenteInput.class)
    COMPONENTE_NATIVO_FRM_VER_COMPONENTE_INPUT,
    @InfoTipoAcaoController(nomeAcao = "Compilar taglib padrão", icone = "fa fa-cogs")
    COMPONENTE_NATIVO_CTR_COMPILAR_TAG_LIB_PADRAO;

}
