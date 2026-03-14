/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.usuario;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.fabrica_software.FabricaSoftware;
import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(plural = "Caramelo code Devs", tags = "Dev CRC")
public class UsuarioDevProjCRC extends UsuarioSB {

    @ManyToOne(targetEntity = FabricaSoftware.class)
    private FabricaSoftware fabrica;

}
