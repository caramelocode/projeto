/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.fabrica_software;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.implantacao.TipoRepositorio;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.sistema.PlanoFabricaSoftware;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.usuario.UsuarioDevProjCRC;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.EntidadeSimplesORM;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = "Fábrica de Software", plural = "Fábricas de software")
public class FabricaSoftware extends EntidadeSimplesORM {

    @Id
    @InfoCampo(tipo = FabTipoAtributoObjeto.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @InfoCampo(tipo = FabTipoAtributoObjeto.NOME)
    private String nome;

    private String documento;

    @ManyToOne(targetEntity = PlanoFabricaSoftware.class)
    private PlanoFabricaSoftware plano;

    @ManyToOne(targetEntity = UsuarioDevProjCRC.class)
    private UsuarioDevProjCRC usuarioREsponsavel;

    @OneToMany(mappedBy = "fabrica")
    private List<UsuarioDevProjCRC> equipe;

    @Transient
    private TipoRepositorio repositorioPadrao;

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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public PlanoFabricaSoftware getPlano() {
        return plano;
    }

    public void setPlano(PlanoFabricaSoftware plano) {
        this.plano = plano;
    }

    public UsuarioDevProjCRC getUsuarioREsponsavel() {
        return usuarioREsponsavel;
    }

    public void setUsuarioREsponsavel(UsuarioDevProjCRC usuarioREsponsavel) {
        this.usuarioREsponsavel = usuarioREsponsavel;
    }

    public List<UsuarioDevProjCRC> getEquipe() {
        return equipe;
    }

    public void setEquipe(List<UsuarioDevProjCRC> equipe) {
        this.equipe = equipe;
    }

    public TipoRepositorio getRepositorioPadrao() {
        return repositorioPadrao;
    }

    public void setRepositorioPadrao(TipoRepositorio repositorioPadrao) {
        this.repositorioPadrao = repositorioPadrao;
    }

}
