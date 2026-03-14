/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes;

import com.super_bits.modulosSB.Persistencia.registro.persistidos.modulos.dinamico.DadoDinamico;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = "Exemplo Input Simples", plural = "Componentes Input simples", icone = "a fa-pencil-square-o")
public class ExemploComponenteInput extends ExemploComponente {

    @Transient
    private DadoDinamico dadoDinamico;

    public ItfCampoInstanciado getComoCampoInstanciado() {
        if (dadoDinamico == null) {
            dadoDinamico = new DadoDinamico();
            dadoDinamico.setTipoDadoDinamico(this);
        }
        return dadoDinamico.getCampoInstanciado();
    }

}
