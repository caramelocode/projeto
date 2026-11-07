/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes;

import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import java.util.Objects;
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

    /**
     * Vincula a ação à gestão já salva do mesmo módulo e domínio, se existir.
     * A gestão é procurada por módulo + domínio, então FabAcaoGerente e
     * FabAcaoGerenteCliente usam a mesma gestão.
     */
    @Override
    protected void aplicarVinculosDoNomeDigitado() {
        if (getProjeto() == null || getProjeto().getAcoes() == null || getModulo() == null) {
            return;
        }
        setAcaoGestao(getProjeto().getAcoes().stream()
                .filter(AcaoProjCRCGestao.class::isInstance)
                .map(AcaoProjCRCGestao.class::cast)
                .filter(gestao -> gestao.getModulo() != null && Objects.equals(getModulo().getNome(), gestao.getModulo().getNome()))
                .filter(gestao -> Objects.equals(getNomeDominio(), gestao.getNomeDominio()))
                .findFirst().orElse(null));
    }

    public AcaoProjCRCGestao getAcaoGestao() {

        return acaoGestao;

    }

    public void setAcaoGestao(AcaoProjCRCGestao acaoGestao) {
        this.acaoGestao = acaoGestao;
    }

}
