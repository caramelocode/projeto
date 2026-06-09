/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes;

import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = "ação secundária", plural = "Ações secundárias", icone = "fa fa-share-square-o")
public class AcaoCRCProjSecundaria extends AcaoProjCRC {

    @ManyToOne(targetEntity = AcaoProjCRCGestao.class)
    private AcaoProjCRCGestao acaoGestao;

    public AcaoProjCRCGestao getAcaoGestao() {
        return acaoGestao;
    }

    public void setAcaoGestao(AcaoProjCRCGestao acaoGestao) {
        this.acaoGestao = acaoGestao;
    }

}
