/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaStatusProjCRC;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import javax.persistence.Entity;

/**
 * Atributo de entidade do tipo STATUS_ENUM (ex.: StatusCliente.fabStatus).
 * Referencia, pela fábrica herdada de {@link AtributoDeEntidadeFabrica}, uma
 * fábrica de status.
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = {"Atributo de Entidade (Fábrica de Status)"}, plural = "Atributos de Entidade (Fábrica de Status)", icone = "fa fa-traffic-light")
public class AtributoDeEntidadeFabricaStatus extends AtributoDeEntidadeFabrica {

    /**
     * Fábrica referenciada como fábrica de status, ou null se não houver
     * fábrica ou se ela não for de status.
     */
    public FabricaStatusProjCRC getFabricaStatus() {
        if (getFabricaEntidade() instanceof FabricaStatusProjCRC) {
            return (FabricaStatusProjCRC) getFabricaEntidade();
        }
        return null;
    }

    public void setFabricaStatus(FabricaStatusProjCRC pFabricaStatus) {
        setFabricaEntidade(pFabricaStatus);
    }

}
