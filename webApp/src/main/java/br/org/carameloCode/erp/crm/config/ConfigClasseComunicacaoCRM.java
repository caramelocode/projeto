/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.crm.config;

import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfRespostaComunicacao;
import com.super_bits.modulosSB.webPaginas.centralComunicacao.CentralComunicaoWebPadrao;
import java.util.List;
import javax.persistence.EntityManager;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ComoArmazenamentoComunicacao;

/**
 *
 * @author salvio
 */
public class ConfigClasseComunicacaoCRM extends CentralComunicaoWebPadrao {

    @Override
    public List<ItfDialogo> getComunicacoesAguardandoRespostaDoDestinatario(ComoUsuario pDestinatario) {
        List<ItfDialogo> comunicacoes = super.getComunicacoesAguardandoRespostaDoDestinatario(pDestinatario);
        return comunicacoes;
    }

    @Override
    public ComoArmazenamentoComunicacao getArmazenamento() {
        return super.getArmazenamento();
    }

    @Override
    public boolean responderComunicacao(String codigoSeloComunicacao, ItfRespostaComunicacao pResposta) {

        EntityManager em = UtilSBPersistencia.getEMPadraoNovo();
        try {
            ItfDialogo pComunicacao = SBCore.getServicoComunicacao().getArmazenamento().getDialogoByCodigoSelo(codigoSeloComunicacao);

            return super.responderComunicacao(pComunicacao.getCodigoSelo(), pResposta);
        } finally {
            UtilSBPersistencia.fecharEM(em);
        }

    }

}
