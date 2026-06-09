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
@InfoObjetoSB(tags = {"Atributo de Entidade (Lista)"}, plural = "Atributos de Entidade (Lista)")
public class AtrubutoEntidadeLista extends AtributoDeEntidadeSimples {

    @ManyToOne(targetEntity = ObjetoProjCRC.class)
    private ObjetoProjCRC entidadeItemLista;

    private String caminhoLista;

    public ObjetoProjCRC getEntidadeItemLista() {
        return entidadeItemLista;
    }

    public void setEntidadeItemLista(ObjetoProjCRC entidadeItemLista) {
        this.entidadeItemLista = entidadeItemLista;
    }

    public String getCaminhoLista() {
        return caminhoLista;
    }

    public void setCaminhoLista(String caminhoLista) {
        this.caminhoLista = caminhoLista;
    }

}
