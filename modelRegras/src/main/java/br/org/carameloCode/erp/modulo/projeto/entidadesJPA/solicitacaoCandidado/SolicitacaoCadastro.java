/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.solicitacaoCandidado;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.fabricaSoftware.usuario.UsuarioDevProjCRC;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.EntidadeSimplesORM;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
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
@InfoObjetoSB(tags = "Solicitação de Cadastro", plural = "Solicitações de cadastro", icone = "fa fa-user-plus")
public class SolicitacaoCadastro extends EntidadeSimplesORM {

    @Id
    @InfoCampo(tipo = FabTipoAtributoObjeto.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @InfoCampo(tipo = FabTipoAtributoObjeto.NOME)
    private String nome;
    private String email;
    private String telefone;
    private String usuarioGit;

    @ManyToOne(targetEntity = UsuarioDevProjCRC.class)
    private UsuarioDevProjCRC usuarioConvite;

    @ManyToOne(targetEntity = UsuarioDevProjCRC.class)
    private UsuarioDevProjCRC usuarioGerado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUsuarioGit() {
        return usuarioGit;
    }

    public void setUsuarioGit(String usuarioGit) {
        this.usuarioGit = usuarioGit;
    }

    public UsuarioDevProjCRC getUsuarioConvite() {
        return usuarioConvite;
    }

    public void setUsuarioConvite(UsuarioDevProjCRC usuarioConvite) {
        this.usuarioConvite = usuarioConvite;
    }

    public UsuarioDevProjCRC getUsuarioGerado() {
        return usuarioGerado;
    }

    public void setUsuarioGerado(UsuarioDevProjCRC usuarioGerado) {
        this.usuarioGerado = usuarioGerado;
    }

}
