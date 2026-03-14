/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.sistema;

import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.EntidadeSimples;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(plural = "Planos Serviço de Hospedágem", tags = "Plano de serviço de hospedagem")
public class PlanoFabricaSoftware extends EntidadeSimples {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @InfoCampo(tipo = FabTipoAtributoObjeto.NOME)
    private String nome;

    private int projetosPermitidos;
    private int implantacaoMensalPermitidos;
    private int objetosPorProjetoPermitidos;
    private int acoesPorProjetoPermitidos;
    private int repositoriosPermitidos;
    private int compilacaoPermitida;

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

    public int getProjetosPermitidos() {
        return projetosPermitidos;
    }

    public void setProjetosPermitidos(int projetosPermitidos) {
        this.projetosPermitidos = projetosPermitidos;
    }

    public int getImplantacaoMensalPermitidos() {
        return implantacaoMensalPermitidos;
    }

    public void setImplantacaoMensalPermitidos(int implantacaoMensalPermitidos) {
        this.implantacaoMensalPermitidos = implantacaoMensalPermitidos;
    }

    public int getObjetosPorProjetoPermitidos() {
        return objetosPorProjetoPermitidos;
    }

    public void setObjetosPorProjetoPermitidos(int objetosPorProjetoPermitidos) {
        this.objetosPorProjetoPermitidos = objetosPorProjetoPermitidos;
    }

    public int getAcoesPorProjetoPermitidos() {
        return acoesPorProjetoPermitidos;
    }

    public void setAcoesPorProjetoPermitidos(int acoesPorProjetoPermitidos) {
        this.acoesPorProjetoPermitidos = acoesPorProjetoPermitidos;
    }

    public int getRepositoriosPermitidos() {
        return repositoriosPermitidos;
    }

    public void setRepositoriosPermitidos(int repositoriosPermitidos) {
        this.repositoriosPermitidos = repositoriosPermitidos;
    }

    public int getCompilacaoPermitida() {
        return compilacaoPermitida;
    }

    public void setCompilacaoPermitida(int compilacaoPermitida) {
        this.compilacaoPermitida = compilacaoPermitida;
    }

}
