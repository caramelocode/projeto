/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.componenteVisual;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.requisito.RequisitoDeProjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.EntidadeSimples;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = "Componente de Projeto", plural = "Componentes de Projeto", icone = "fa fa-cube")
public class ComponenteDeProjeto extends EntidadeSimples {

    @Id
    @InfoCampo(tipo = FabTipoAtributoObjeto.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @InfoCampo(tipo = FabTipoAtributoObjeto.NOME)
    private String nomeCmponente;

    @ManyToOne(targetEntity = RequisitoDeProjeto.class)
    private RequisitoDeProjeto requisito;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCmponente() {
        return nomeCmponente;
    }

    public void setNomeCmponente(String nomeCmponente) {
        this.nomeCmponente = nomeCmponente;
    }

    public RequisitoDeProjeto getRequisito() {
        return requisito;
    }

    public void setRequisito(RequisitoDeProjeto requisito) {
        this.requisito = requisito;
    }

}
