/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = {"Atributo de Entidade (Referência)"}, plural = "Atributos de Entidade (Referência)")
public class AtributoEntidadeEntidade extends AtributoDeEntidadeSimples {

    @ManyToOne(targetEntity = ObjetoProjCRC.class)
    private ObjetoProjCRC entidadeReferenciada;

    public ObjetoProjCRC getEntidadeReferenciada() {
        return entidadeReferenciada;
    }

    public void setEntidadeReferenciada(ObjetoProjCRC entidadeReferenciada) {
        this.entidadeReferenciada = entidadeReferenciada;
    }

}
