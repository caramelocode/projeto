/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.itensExemplo;

import com.super_bits.modulosSB.Persistencia.registro.persistidos.modulos.dinamico.OpcaoDadoDinamico;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoTemCor;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoTemIcone;
import javax.persistence.Entity;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(plural = "Objeto com ícone", tags = "Objeto com ícone")
public class ExemploOpcaoComIcone extends OpcaoDadoDinamico implements ComoTemIcone {

    @InfoCampo(tipo = FabTipoAtributoObjeto.ICONE)
    private String icone;

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

}
