/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.fabricaSoftware.usuario;

import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
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
@InfoObjetoSB(tags = "Chave de Acesso ao Repositório", plural = "Chaves de Acesso ao Repositório", icone = "fa fa-key")
public class ChaveAcessoRepositorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String chaveUsr;
    private String senhaUsr;

    @ManyToOne(targetEntity = UsuarioDevProjCRC.class)
    private UsuarioDevProjCRC usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChaveUsr() {
        return chaveUsr;
    }

    public void setChaveUsr(String chaveUsr) {
        this.chaveUsr = chaveUsr;
    }

    public String getSenhaUsr() {
        return senhaUsr;
    }

    public void setSenhaUsr(String senhaUsr) {
        this.senhaUsr = senhaUsr;
    }

    public UsuarioDevProjCRC getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDevProjCRC usuario) {
        this.usuario = usuario;
    }

}
