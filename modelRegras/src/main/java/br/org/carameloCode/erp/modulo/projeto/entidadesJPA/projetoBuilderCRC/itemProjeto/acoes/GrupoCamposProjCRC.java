/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.EntidadeSimples;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = "Grupo de Campos", plural = "Grupos de Campos", icone = "fa fa-columns")
public class GrupoCamposProjCRC extends EntidadeSimples {

    @Id
    @InfoCampo(tipo = FabTipoAtributoObjeto.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @InfoCampo(tipo = FabTipoAtributoObjeto.NOME)
    private String nome;

    @ManyToOne(targetEntity = AcaoProjCRCFormulario.class)
    private AcaoProjCRCFormulario formulario;

    @OneToMany(targetEntity = AtributoDeEntidadeSimples.class)
    private List<AtributoDeEntidadeSimples> campos;

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

    public AcaoProjCRCFormulario getFormulario() {
        return formulario;
    }

    public void setFormulario(AcaoProjCRCFormulario formulario) {
        this.formulario = formulario;
    }

    public List<AtributoDeEntidadeSimples> getCampos() {
        return campos;
    }

    public void setCampos(List<AtributoDeEntidadeSimples> campos) {
        this.campos = campos;
    }

}
