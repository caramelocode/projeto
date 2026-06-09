/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.implantacao.repositorio.RepositorioGit;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.fabricaSoftware.FabricaSoftware;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.implantacao.builds.BuildProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.implantacao.implantacao.ImplantacaoProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.requisito.RequisitoDeProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.modulo.ModuloProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.servidor.ServicoHospedagem;
import com.super_bits.modulos.SBAcessosModel.model.ModuloAcaoSistemaNativo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.EntidadeSimples;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = "Projeto Caramelo Code", plural = "Projetos Caramelo Code")
public class ProjetoCRC extends EntidadeSimples {

    @Id
    @InfoCampo(tipo = FabTipoAtributoObjeto.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @InfoCampo(tipo = FabTipoAtributoObjeto.NOME)
    private String nome;

    @ManyToOne(targetEntity = RepositorioGit.class)
    private RepositorioGit repositorioGit;

    @ManyToOne(targetEntity = FabricaSoftware.class)
    private FabricaSoftware organizacao;

    @OneToMany(targetEntity = ObjetoProjCRC.class)
    private List<ObjetoProjCRC> objetos;

    @OneToMany(mappedBy = "projeto")
    private List<RequisitoDeProjeto> requisitos;

    @OneToMany(targetEntity = ModuloProjCRC.class)
    private List<ModuloProjCRC> modulos;

    @ManyToMany(targetEntity = ModuloAcaoSistemaNativo.class)
    private List<ModuloAcaoSistemaNativo> modulosImportados;

    @OneToMany(targetEntity = RepositorioGit.class)
    private List<RepositorioGit> repositoriosCodigo;

    @OneToMany(targetEntity = ImplantacaoProjeto.class)
    private List<ImplantacaoProjeto> implantacoes;

    @OneToMany(targetEntity = BuildProjeto.class)
    private List<BuildProjeto> builds;

    @ManyToOne(targetEntity = ServicoHospedagem.class)
    private ServicoHospedagem servidorPadraoProducao;

    @ManyToOne(targetEntity = ServicoHospedagem.class)
    private ServicoHospedagem servidorPadraoHomologacao;

    private double valorEstimado;
    private double valorGasto;

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

    public RepositorioGit getRepositorioGit() {
        return repositorioGit;
    }

    public void setRepositorioGit(RepositorioGit repositorioGit) {
        this.repositorioGit = repositorioGit;
    }

    public FabricaSoftware getOrganizacao() {
        return organizacao;
    }

    public void setOrganizacao(FabricaSoftware organizacao) {
        this.organizacao = organizacao;
    }

    public List<ObjetoProjCRC> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<ObjetoProjCRC> objetos) {
        this.objetos = objetos;
    }

    public List<ModuloProjCRC> getModulos() {
        return modulos;
    }

    public void setModulos(List<ModuloProjCRC> modulos) {
        this.modulos = modulos;
    }

    public List<ModuloAcaoSistemaNativo> getModulosImportados() {
        return modulosImportados;
    }

    public void setModulosImportados(List<ModuloAcaoSistemaNativo> modulosImportados) {
        this.modulosImportados = modulosImportados;
    }

    public List<RepositorioGit> getRepositoriosCodigo() {
        return repositoriosCodigo;
    }

    public void setRepositoriosCodigo(List<RepositorioGit> repositoriosCodigo) {
        this.repositoriosCodigo = repositoriosCodigo;
    }

    public List<ImplantacaoProjeto> getImplantacoes() {
        return implantacoes;
    }

    public void setImplantacoes(List<ImplantacaoProjeto> implantacoes) {
        this.implantacoes = implantacoes;
    }

    public List<BuildProjeto> getBuilds() {
        return builds;
    }

    public void setBuilds(List<BuildProjeto> builds) {
        this.builds = builds;
    }

    public ServicoHospedagem getServidorPadraoProducao() {
        return servidorPadraoProducao;
    }

    public void setServidorPadraoProducao(ServicoHospedagem servidorPadraoProducao) {
        this.servidorPadraoProducao = servidorPadraoProducao;
    }

    public ServicoHospedagem getServidorPadraoHomologacao() {
        return servidorPadraoHomologacao;
    }

    public void setServidorPadraoHomologacao(ServicoHospedagem servidorPadraoHomologacao) {
        this.servidorPadraoHomologacao = servidorPadraoHomologacao;
    }

    public double getValorEstimado() {
        return valorEstimado;
    }

    public void setValorEstimado(double valorEstimado) {
        this.valorEstimado = valorEstimado;
    }

    public double getValorGasto() {
        return valorGasto;
    }

    public void setValorGasto(double valorGasto) {
        this.valorGasto = valorGasto;
    }

}
