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
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfRespostaAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.TratamentoDeErros.ErroRegraDeNegocio;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ComunicacaoTransient;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ERPTipoCanalComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ErroAcessandoCanalComunicacao;
import org.coletivojava.fw.api.tratamentoErros.FabErro;

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

    @InfoAcaoProjetoCRCComponenteNativo(acao = FabAcaoProjetoCRCComponenteNativo.NOTIFICACAO_TRANSITORIA_CTR_ENVIAR)
    public static ItfRespostaAcaoDoSistema notificacaoTransitoria(ComunicacaoTransient pExemplo) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaResposta(ExemploComponente.class), null) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                try {
                    String registroDeNotiicacao = CarameloCode.getServicoComunicacao().dispararComunicacao(pExemplo, ERPTipoCanalComunicacao.INTRANET_MENU);
                    if (registroDeNotiicacao == null) {
                        throw new ErroRegraDeNegocio("Falha registrando comunicação");
                    }

                } catch (ErroAcessandoCanalComunicacao ex) {
                    SBCore.RelatarErro(FabErro.SOLICITAR_REPARO, "Falha registrando comunicação ", ex);
                }
            }
        }.getResposta();

    }

}
