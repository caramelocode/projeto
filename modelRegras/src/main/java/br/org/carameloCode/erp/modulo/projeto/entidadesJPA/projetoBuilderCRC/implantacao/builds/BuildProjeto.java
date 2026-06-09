/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.implantacao.builds;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.fabricaSoftware.usuario.ChaveAcessoRepositorio;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.fabricaSoftware.usuario.UsuarioDevProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.implantacao.repositorio.RepositorioGit;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
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
@InfoObjetoSB(tags = "Build do Projeto", plural = "Builds do Projeto", icone = "fa fa-wrench")
public class BuildProjeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = ProjetoCRC.class)
    private ProjetoCRC projeto;

    @ManyToOne(targetEntity = UsuarioDevProjCRC.class)
    private UsuarioDevProjCRC usuario;

    @ManyToOne(targetEntity = RepositorioGit.class)
    private RepositorioGit repositorio;

    @ManyToOne(targetEntity = ChaveAcessoRepositorio.class)
    @InfoCampo(caminhoParaLista = "usuario.chaves")
    private ChaveAcessoRepositorio chave;

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

    public UsuarioDevProjCRC getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDevProjCRC usuario) {
        this.usuario = usuario;
    }

    public RepositorioGit getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(RepositorioGit repositorio) {
        this.repositorio = repositorio;
    }

    public ChaveAcessoRepositorio getChave() {
        return chave;
    }

    public void setChave(ChaveAcessoRepositorio chave) {
        this.chave = chave;
    }

}
