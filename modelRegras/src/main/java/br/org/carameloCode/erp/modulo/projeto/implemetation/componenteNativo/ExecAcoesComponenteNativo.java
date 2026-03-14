/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.implemetation.componenteNativo;

import br.org.carameloCode.erp.modulo.projeto.acoes.componente.nativo.FabAcaoProjetoCRCComponenteNativo;
import br.org.carameloCode.erp.modulo.projeto.acoes.componente.nativo.InfoAcaoProjetoCRCComponenteNativo;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.ExemploComponente;
import com.super_bits.modulos.SBAcessosModel.controller.resposta.RespostaComGestaoEMRegraDeNegocioPadrao;
import com.super_bits.modulosSB.Persistencia.dao.ControllerAbstratoSBPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfRespostaAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.TratamentoDeErros.ErroRegraDeNegocio;

/**
 *
 * @author salvio
 */
public class ExecAcoesComponenteNativo extends ControllerAbstratoSBPersistencia {

    @InfoAcaoProjetoCRCComponenteNativo(acao = FabAcaoProjetoCRCComponenteNativo.COMPONENTE_NATIVO_CTR_COMPILAR_TAG_LIB_PADRAO)
    public static ItfRespostaAcaoDoSistema compilarTagLib(ExemploComponente pExemplo) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaResposta(ExemploComponente.class), null) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                // copiar pasta meta-inf
                //copiar pasta SBComp
                //compiar faces config
            }
        }.getResposta();

    }

}
