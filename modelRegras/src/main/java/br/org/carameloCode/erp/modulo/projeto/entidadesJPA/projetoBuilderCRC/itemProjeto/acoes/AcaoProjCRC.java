/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.ComoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.requisito.RequisitoDeProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.modulo.ModuloProjCRC;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.acoes.ComoEstruturaAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.fabricas.FabTipoAcaoSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.fabricas.FabTipoAcaoSistemaGenerica;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.EntidadeSimples;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author salvio
 */
@Entity
@DiscriminatorColumn(name = "tipoAcaoDB")
@InfoObjetoSB(tags = {"Ação do Sistema"}, plural = "Ações do sistema")
public class AcaoProjCRC extends EntidadeSimples implements ComoEstruturaAcaoDoSistema, ComoItemProjeto {

    @Id
    @InfoCampo(tipo = FabTipoAtributoObjeto.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Enumerated(EnumType.STRING)
    private FabTipoAcaoSistema tipoAcao;
    @Enumerated(EnumType.STRING)
    protected FabTipoAcaoSistemaGenerica tipoAcaoGenerica;

    @InfoCampo(tipo = FabTipoAtributoObjeto.NOME)
    protected String nomeAcao;
    private String iconeAcao;
    private String cor;
    private String descricao;
    private boolean precisaPermissao;
    @ManyToOne(targetEntity = ModuloProjCRC.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private ModuloProjCRC modulo;

    private String idDescritivoJira;
    @Column(nullable = false, updatable = false, insertable = false)
    private String tipoAcaoDB;
    private String nomeUnico;
    private String nomeDominio;
    private FabTipoAcaoSistema tipoAcaoSistema;

    private RequisitoDeProjeto requisito;

    public FabTipoAcaoSistema getTipoAcao() {
        return tipoAcao;
    }

    public void setTipoAcao(FabTipoAcaoSistema tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public FabTipoAcaoSistemaGenerica getTipoAcaoGenerica() {
        return tipoAcaoGenerica;
    }

    public void setTipoAcaoGenerica(FabTipoAcaoSistemaGenerica tipoAcaoGenerica) {
        this.tipoAcaoGenerica = tipoAcaoGenerica;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAcao() {
        return nomeAcao;
    }

    public void setNomeAcao(String nomeAcao) {
        this.nomeAcao = nomeAcao;
    }

    public String getIconeAcao() {
        return iconeAcao;
    }

    public void setIconeAcao(String iconeAcao) {
        this.iconeAcao = iconeAcao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isPrecisaPermissao() {
        return precisaPermissao;
    }

    public void setPrecisaPermissao(boolean precisaPermissao) {
        this.precisaPermissao = precisaPermissao;
    }

    public ModuloProjCRC getModulo() {
        return modulo;
    }

    public void setModulo(ModuloProjCRC modulo) {
        this.modulo = modulo;
    }

    public String getIdDescritivoJira() {
        return idDescritivoJira;
    }

    public void setIdDescritivoJira(String idDescritivoJira) {
        this.idDescritivoJira = idDescritivoJira;
    }

    public String getTipoAcaoDB() {
        return tipoAcaoDB;
    }

    public void setTipoAcaoDB(String tipoAcaoDB) {
        this.tipoAcaoDB = tipoAcaoDB;
    }

    public String getNomeUnico() {
        return nomeUnico;
    }

    public void setNomeUnico(String nomeUnico) {
        this.nomeUnico = nomeUnico;
    }

    public String getNomeDominio() {
        return nomeDominio;
    }

    public void setNomeDominio(String nomeDominio) {
        this.nomeDominio = nomeDominio;
    }

    public FabTipoAcaoSistema getTipoAcaoSistema() {
        return tipoAcaoSistema;
    }

    public void setTipoAcaoSistema(FabTipoAcaoSistema tipoAcaoSistema) {
        this.tipoAcaoSistema = tipoAcaoSistema;
    }

    @Override
    public boolean isUmaAcaoFormulario() {
        return this instanceof AcaoProjCRCFormulario;
    }

    @Override
    public boolean isTemAcaoPrincipal() {
        return false;
    }

    @Override
    public boolean isUmaAcaoGenerica() {
        return tipoAcaoGenerica != null;
    }

    @Override
    public boolean isUmaAcaoGestaoDominio() {
        return this instanceof AcaoProjCRCGestao;
    }

    @Override
    public boolean isUmaAcaoDeEntidade() {
        return false;
    }

    @Override
    public boolean isUmaAcaoController() {
        return this instanceof AcaoProjCRCContoller;
    }

}
