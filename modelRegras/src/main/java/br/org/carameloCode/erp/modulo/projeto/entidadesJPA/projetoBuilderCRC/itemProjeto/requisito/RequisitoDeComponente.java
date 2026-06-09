/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.requisito;

import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import javax.persistence.Entity;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = "Requisito de Componente", plural = "Requisitos de Componente", icone = "fa fa-puzzle-piece")
public class RequisitoDeComponente extends RequisitoDeProjeto {

    private String imagemRepresentativa;
    private String comportamentoEsperado;

    public String getImagemRepresentativa() {
        return imagemRepresentativa;
    }

    public void setImagemRepresentativa(String imagemRepresentativa) {
        this.imagemRepresentativa = imagemRepresentativa;
    }

    public String getComportamentoEsperado() {
        return comportamentoEsperado;
    }

    public void setComportamentoEsperado(String comportamentoEsperado) {
        this.comportamentoEsperado = comportamentoEsperado;
    }

}
