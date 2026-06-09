/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.cliente;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.fabricaSoftware.FabricaSoftware;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.EntidadeSimples;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = "Cliente", plural = "Clientes", icone = "fa fa-briefcase")
public class Cliente extends EntidadeSimples {

    @Id
    @InfoCampo(tipo = FabTipoAtributoObjeto.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @InfoCampo(tipo = FabTipoAtributoObjeto.NOME)
    private String nome;

    @ManyToOne(targetEntity = FabricaSoftware.class)
    private FabricaSoftware fabricaSoftware;

    @OneToMany(mappedBy = "cliente")
    private List<UsuarioCliente> usuarios;

    private double indiceCustoProjeto;

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

    public FabricaSoftware getFabricaSoftware() {
        return fabricaSoftware;
    }

    public void setFabricaSoftware(FabricaSoftware fabricaSoftware) {
        this.fabricaSoftware = fabricaSoftware;
    }

    public double getIndiceCustoProjeto() {
        return indiceCustoProjeto;
    }

    public void setIndiceCustoProjeto(double indiceCustoProjeto) {
        this.indiceCustoProjeto = indiceCustoProjeto;
    }

}
