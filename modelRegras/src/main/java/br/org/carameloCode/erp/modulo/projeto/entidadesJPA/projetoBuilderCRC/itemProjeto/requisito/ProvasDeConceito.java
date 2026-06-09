/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.requisito;

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
@InfoObjetoSB(tags = "Prova de Conceito", plural = "Provas de Conceito", icone = "fa fa-flask")
public class ProvasDeConceito extends EntidadeSimples {

    @Id
    @InfoCampo(tipo = FabTipoAtributoObjeto.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @InfoCampo(tipo = FabTipoAtributoObjeto.HTML)
    private String performance;
    @InfoCampo(tipo = FabTipoAtributoObjeto.HTML)
    private String curvaDeAprendizagem;
    @InfoCampo(tipo = FabTipoAtributoObjeto.HTML)
    private String maturidadeTcnologia;
    @InfoCampo(tipo = FabTipoAtributoObjeto.HTML)
    private String custoLicenca;
    @InfoCampo(tipo = FabTipoAtributoObjeto.HTML)
    private String integracaoStackAtual;
    private double custoProvaConceito;
    private int horasEstimadasProvaConveito;
    private String retatorioFinalProvaConceito;

    @ManyToOne(targetEntity = RequisitosDeProvaDeConceito.class)
    private RequisitosDeProvaDeConceito requisito;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public String getCurvaDeAprendizagem() {
        return curvaDeAprendizagem;
    }

    public void setCurvaDeAprendizagem(String curvaDeAprendizagem) {
        this.curvaDeAprendizagem = curvaDeAprendizagem;
    }

    public String getMaturidadeTcnologia() {
        return maturidadeTcnologia;
    }

    public void setMaturidadeTcnologia(String maturidadeTcnologia) {
        this.maturidadeTcnologia = maturidadeTcnologia;
    }

    public String getCustoLicenca() {
        return custoLicenca;
    }

    public void setCustoLicenca(String custoLicenca) {
        this.custoLicenca = custoLicenca;
    }

    public String getIntegracaoStackAtual() {
        return integracaoStackAtual;
    }

    public void setIntegracaoStackAtual(String integracaoStackAtual) {
        this.integracaoStackAtual = integracaoStackAtual;
    }

    public double getCustoProvaConceito() {
        return custoProvaConceito;
    }

    public void setCustoProvaConceito(double custoProvaConceito) {
        this.custoProvaConceito = custoProvaConceito;
    }

    public int getHorasEstimadasProvaConveito() {
        return horasEstimadasProvaConveito;
    }

    public void setHorasEstimadasProvaConveito(int horasEstimadasProvaConveito) {
        this.horasEstimadasProvaConveito = horasEstimadasProvaConveito;
    }

    public String getRetatorioFinalProvaConceito() {
        return retatorioFinalProvaConceito;
    }

    public void setRetatorioFinalProvaConceito(String retatorioFinalProvaConceito) {
        this.retatorioFinalProvaConceito = retatorioFinalProvaConceito;
    }

    public RequisitosDeProvaDeConceito getRequisito() {
        return requisito;
    }

    public void setRequisito(RequisitosDeProvaDeConceito requisito) {
        this.requisito = requisito;
    }

}
