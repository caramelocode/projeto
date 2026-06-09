/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes;

import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = "ação de gestão de domínio", plural = "Ações de gestão de domínio", icone = "fa fa-list-alt")
public class AcaoProjCRCGestao extends AcaoProjCRC {

    @OneToMany(targetEntity = AcaoCRCProjSecundaria.class)
    private List<AcaoCRCProjSecundaria> acoesVinculadas;

    public List<AcaoCRCProjSecundaria> getAcoesVinculadas() {
        return acoesVinculadas;
    }

    public void setAcoesVinculadas(List<AcaoCRCProjSecundaria> acoesVinculadas) {
        this.acoesVinculadas = acoesVinculadas;
    }

}
