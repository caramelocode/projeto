/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.implantacao.repositorio;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
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
@InfoObjetoSB(tags = "Repositório Git", plural = "Repositórios Git", icone = "fa fa-git")
public class RepositorioGit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = ProjetoCRC.class)
    private ProjetoCRC projeto;

    private String descricao;
    private String branchRepositorio;
    private String enderecoRepositorio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjetoCRC getProjeto() {
        return projeto;
    }

    public void setProjeto(ProjetoCRC projeto) {
        this.projeto = projeto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getBranchRepositorio() {
        return branchRepositorio;
    }

    public void setBranchRepositorio(String branchRepositorio) {
        this.branchRepositorio = branchRepositorio;
    }

    public String getEnderecoRepositorio() {
        return enderecoRepositorio;
    }

    public void setEnderecoRepositorio(String enderecoRepositorio) {
        this.enderecoRepositorio = enderecoRepositorio;
    }

}
