/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projeto;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.implantacao.TipoRepositorio;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.fabrica_software.FabricaSoftware;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projeto.entidades.EntidadeProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projeto.modulo.ModuloProjCRC;
import com.super_bits.modulos.SBAcessosModel.model.ModuloAcaoSistemaNativo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.EntidadeSimples;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = "Projeto Caramelo Code", plural = "Projetos Caramelo Code")
public class ProjetoCRC extends EntidadeSimples {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String repositorioGit;

    @ManyToOne(targetEntity = FabricaSoftware.class)
    private FabricaSoftware organizacao;

    @Transient
    private List<EntidadeProjCRC> objetos;

    @Transient
    private List<ModuloProjCRC> modulos;

    @Transient
    private List<ModuloAcaoSistemaNativo> modulosImportados;

    @Transient
    private List<TipoRepositorio> tipoImplantacao;
}
