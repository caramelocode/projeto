/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.requisito;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.EntidadeSimplesORM;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.ListenerEntidadePadrao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.EntidadeSimples;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = "Requisito de Projeto", plural = "Requisitos de Projeto", icone = "fa fa-list-check")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoEntidade")
@EntityListeners(ListenerEntidadePadrao.class)
public class RequisitoDeProjeto extends EntidadeSimplesORM {

    @Id
    @InfoCampo(tipo = FabTipoAtributoObjeto.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @InfoCampo(tipo = FabTipoAtributoObjeto.NOME)
    private String nome;

    @ManyToOne(targetEntity = UsuarioSB.class)
    private UsuarioSB solicitante;

    @Column(nullable = false, updatable = false, insertable = false)
    private String tipoEntidade;

    @ManyToOne
    private ProjetoCRC projeto;

    private double tempoEstimadoArquiteto;
    private double tempoEStimadoDev;

    @ManyToOne(targetEntity = UsuarioSB.class)
    private UsuarioSB revisor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UsuarioSB getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(UsuarioSB solicitante) {
        this.solicitante = solicitante;
    }

    public ProjetoCRC getProjeto() {
        return projeto;
    }

    public void setProjeto(ProjetoCRC projeto) {
        this.projeto = projeto;
    }

    public double getTempoEstimadoArquiteto() {
        return tempoEstimadoArquiteto;
    }

    public void setTempoEstimadoArquiteto(double tempoEstimadoArquiteto) {
        this.tempoEstimadoArquiteto = tempoEstimadoArquiteto;
    }

    public double getTempoEStimadoDev() {
        return tempoEStimadoDev;
    }

    public void setTempoEStimadoDev(double tempoEStimadoDev) {
        this.tempoEStimadoDev = tempoEStimadoDev;
    }

    public UsuarioSB getRevisor() {
        return revisor;
    }

    public void setRevisor(UsuarioSB revisor) {
        this.revisor = revisor;
    }

}
