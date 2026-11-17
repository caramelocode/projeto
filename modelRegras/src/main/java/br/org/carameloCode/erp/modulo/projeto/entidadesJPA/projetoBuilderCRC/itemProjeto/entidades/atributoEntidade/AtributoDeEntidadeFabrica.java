/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaEntidadeProjCRC;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Atributo de entidade do tipo ENUM_FABRICA (ex.: Cliente.fabTipoCliente).
 * Referencia a fábrica genérica cujos itens são os valores possíveis.
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = {"Atributo de Entidade (Fábrica)"}, plural = "Atributos de Entidade (Fábrica)", icone = "fa fa-industry")
public class AtributoDeEntidadeFabrica extends AtributoDeEntidadeSimples {

    @ManyToOne(targetEntity = FabricaEntidadeProjCRC.class)
    private FabricaEntidadeProjCRC fabricaEntidade;

    public FabricaEntidadeProjCRC getFabricaEntidade() {
        return fabricaEntidade;
    }

    public void setFabricaEntidade(FabricaEntidadeProjCRC fabricaEntidade) {
        this.fabricaEntidade = fabricaEntidade;
    }

}
