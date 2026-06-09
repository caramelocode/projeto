/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.modulo;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.EntidadeSimplesORM;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfModuloAcaoSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.acoes.ComoAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.modulo.ComoFabricaModulo;
import com.super_bits.modulosSB.SBCore.modulos.fabrica.ComoFabrica;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import java.util.ArrayList;
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
@InfoObjetoSB(tags = {"Modulo do Projeto"}, plural = "Modulos do Projeto")
public class ModuloProjCRC extends EntidadeSimplesORM implements ItfModuloAcaoSistema {

    @Id
    @InfoCampo(tipo = FabTipoAtributoObjeto.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @InfoCampo(tipo = FabTipoAtributoObjeto.NOME)
    private String nome;

    @InfoCampo(tipo = FabTipoAtributoObjeto.DESCRITIVO)
    private String descricao;

    private boolean umModuloNativo = false;

    @ManyToOne(targetEntity = ProjetoCRC.class)
    private ProjetoCRC projeto;

    @OneToMany(targetEntity = AcaoProjCRC.class)
    private List<AcaoProjCRC> acoes;

    @OneToMany(targetEntity = ObjetoProjCRC.class)
    private List<ObjetoProjCRC> entidades;

    @Transient
    private ComoFabricaModulo enumVinculado;

    @Override
    public Long getId() {
        return id;
    }

    @Override
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

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ProjetoCRC getProjeto() {
        return projeto;
    }

    public void setProjeto(ProjetoCRC projeto) {
        this.projeto = projeto;
    }

    public List<AcaoProjCRC> getAcoesProjeto() {
        return acoes;
    }

    public void setAcoesProjeto(List<AcaoProjCRC> acoes) {
        this.acoes = acoes;
    }

    public List<ObjetoProjCRC> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<ObjetoProjCRC> entidades) {
        this.entidades = entidades;
    }

    @Override
    public List<ComoAcaoDoSistema> getAcoes() {
        return new ArrayList<>();
    }

    @Override
    public List<ComoAcaoDoSistema> getAcoesGestaoMB() {
        List<ComoAcaoDoSistema> listaAcaoGestao = new ArrayList<>();
        for (ComoAcaoDoSistema acao : getAcoes()) {
            if (acao.isUmaAcaoGestaoDominio()) {
                listaAcaoGestao.add(acao);
            }
        }
        return listaAcaoGestao;
    }

    @Override
    public boolean isUmModuloNativo() {
        return umModuloNativo;
    }

    public void setUmModuloNativo(boolean umModuloNativo) {
        this.umModuloNativo = umModuloNativo;
    }

    @Override
    public void setEnumVinculado(ComoFabrica pFabrica) {
        this.enumVinculado = (ComoFabricaModulo) pFabrica;
    }

    @Override
    public ComoFabricaModulo getEnumVinculado() {
        return enumVinculado;
    }

}
