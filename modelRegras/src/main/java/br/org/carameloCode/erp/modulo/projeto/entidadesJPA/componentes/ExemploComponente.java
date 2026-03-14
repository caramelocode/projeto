/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes;

import com.super_bits.modulosSB.Persistencia.registro.persistidos.modulos.dinamico.TipoDadoDinamico;
import com.super_bits.modulosSB.SBCore.modulos.fabrica.ComoFabrica;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfAtributoObjetoEditavel;
import javax.persistence.Entity;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = "Exemplo Campo Instanciado", plural = "Tipos de Dado dinâmicos", icone = "a fa-pencil-square-o")
public class ExemploComponente extends TipoDadoDinamico implements ItfAtributoObjetoEditavel {

    @InfoCampo(tipo = FabTipoAtributoObjeto.ENUM_FABRICA)
    private FabExemploComponenteNativo tipoExemplo;

    @Override
    public void setEnumVinculado(ComoFabrica pFabrica) {
        tipoExemplo = (FabExemploComponenteNativo) pFabrica;
    }

    public ExemploComponenteInput getComoInput() {
        try {
            return (ExemploComponenteInput) this;
        } catch (Throwable t) {
            return null;
        }
    }

}
