/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoStatusProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaStatusProjCRC;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Atributo de status de uma entidade (ex.: Cliente.status), do tipo
 * OBJETO_DE_UMA_LISTA. Referencia a entidade de status (ex.: StatusCliente),
 * encontrada pelo console a partir do nome da entidade dona do atributo.
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = {"Atributo de Entidade (Status)"}, plural = "Atributos de Entidade (Status)", icone = "fa fa-traffic-light")
public class AtributoDeEntidadeStatus extends AtributoDeEntidadeSimples {

    @ManyToOne(targetEntity = ObjetoStatusProjCRC.class)
    private ObjetoStatusProjCRC entidadeStatus;

    public ObjetoStatusProjCRC getEntidadeStatus() {
        return entidadeStatus;
    }

    public void setEntidadeStatus(ObjetoStatusProjCRC entidadeStatus) {
        this.entidadeStatus = entidadeStatus;
    }

    /**
     * Fábrica de status da entidade de status referenciada, ou null se ainda
     * não houver entidade ou fábrica.
     */
    public FabricaStatusProjCRC getFabricaStatus() {
        if (entidadeStatus == null) {
            return null;
        }
        return entidadeStatus.getFabricaStatus();
    }

}
