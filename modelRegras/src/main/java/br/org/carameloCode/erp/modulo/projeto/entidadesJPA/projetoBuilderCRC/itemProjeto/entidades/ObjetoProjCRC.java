/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.ComoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.requisito.RequisitoDeProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.modulo.ModuloProjCRC;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.EntidadeSimplesORM;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.estrutura.ComoEstruturaEntidadeSimples;
import com.super_bits.modulosSB.SBCore.modulos.objetos.estrutura.ItfEstruturaCampoEntidade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
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
@InfoObjetoSB(tags = {"Entidade do Projeto"}, plural = "Entidades do Projeto")
public class ObjetoProjCRC extends EntidadeSimplesORM implements ComoEstruturaEntidadeSimples, ComoItemProjeto {

    @Id
    @InfoCampo(tipo = FabTipoAtributoObjeto.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @InfoCampo(tipo = FabTipoAtributoObjeto.NOME)
    private String nome;

    private String nomeEntidade;

    private String descricao;

    private String icone;

    private String plural;

    @ElementCollection
    private List<String> tags;

    @ManyToOne(targetEntity = ModuloProjCRC.class)
    private ModuloProjCRC modulo;

    @OneToMany(targetEntity = AtributoDeEntidadeSimples.class)
    private List<AtributoDeEntidadeSimples> atributos;

    private RequisitoDeProjeto requisito;

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
    public String getNomeEntidade() {
        return nomeEntidade;
    }

    public void setNomeEntidade(String nomeEntidade) {
        this.nomeEntidade = nomeEntidade;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    @Override
    public String getPlural() {
        return plural;
    }

    public void setPlural(String plural) {
        this.plural = plural;
    }

    @Override
    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public ModuloProjCRC getModulo() {
        return modulo;
    }

    public void setModulo(ModuloProjCRC modulo) {
        this.modulo = modulo;
    }

    public List<AtributoDeEntidadeSimples> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<AtributoDeEntidadeSimples> atributos) {
        this.atributos = atributos;
    }

    /**
     * Os atributos deste builder são persistidos como
     * {@link AtributoDeEntidadeSimples} (entidade JPA) e não como
     * {@link ItfEstruturaCampoEntidade}. Use {@link #getAtributos()} para a
     * lista persistida.
     *
     * @return lista vazia (a estrutura de campos em tempo de execução não é
     * derivada diretamente desta entidade)
     */
    @Override
    public List<ItfEstruturaCampoEntidade> getCampos() {
        return new ArrayList<>();
    }

}
