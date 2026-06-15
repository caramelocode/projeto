/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.entidadeExemplo;

import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.EntidadeORMNormal;
import com.super_bits.modulosSB.SBCore.modulos.erp.FabTipoAgenteOrganizacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(plural = "Entidades Exemplo", tags = "Entidade Exemplo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipEntidade")
public class EntdExemplo extends EntidadeORMNormal {

    @InfoCampo(tipo = FabTipoAtributoObjeto.ID)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @InfoCampo(tipo = FabTipoAtributoObjeto.NOME)
    private String nome;
    @InfoCampo(tipo = FabTipoAtributoObjeto.DESCRITIVO)
    private String descricao;

    @InfoCampo(tipo = FabTipoAtributoObjeto.DATA, grupoPadrao = "Campos Temporais")
    private Date data;
    @InfoCampo(tipo = FabTipoAtributoObjeto.DATAHORA, grupoPadrao = "Campos Temporais")
    private Date dataHora;
    @InfoCampo(tipo = FabTipoAtributoObjeto.HORA, grupoPadrao = "Campos Temporais")
    private Date hora;

    @InfoCampo(tipo = FabTipoAtributoObjeto.COR, grupoPadrao = "Campos Estéticos")
    private String cor;
    @InfoCampo(tipo = FabTipoAtributoObjeto.ICONE, grupoPadrao = "Campos Estéticos")
    private String icone;

    @InfoCampo(tipo = FabTipoAtributoObjeto.QUANTIDADE, grupoPadrao = "Campos Quantitativos")
    private int quantidade;
    @InfoCampo(tipo = FabTipoAtributoObjeto.MOEDA_REAL, grupoPadrao = "Campos Quantitativos")
    private double valorMoedaReal;
    @InfoCampo(tipo = FabTipoAtributoObjeto.MOEDA_DOLAR, grupoPadrao = "Campos Quantitativos")
    private double valorMoedaDollar;

    @InfoCampo(tipo = FabTipoAtributoObjeto.PERCENTUAL, grupoPadrao = "Campos Quantitativos")
    private double porcentagem;

    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA, grupoPadrao = "Agentes de organização")
    @ManyToOne()
    private UsuarioSB usuarioFornecedor;

    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA, grupoPadrao = "Agentes de organização")
    @ManyToOne()
    private UsuarioSB usuarioCliente;

    @Column(nullable = false, updatable = false, insertable = false)
    private String tipEntidade;

    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA, grupoPadrao = "Metadados Log de Manipulação")
    @ManyToOne()
    private UsuarioSB usuarioEdicao;

    @InfoCampo(tipo = FabTipoAtributoObjeto.REG_DATAINSERCAO, grupoPadrao = "Metadados Log de Manipulação")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraInsercao;

    @InfoCampo(tipo = FabTipoAtributoObjeto.REG_DATAALTERACAO, grupoPadrao = "Metadados Log de Manipulação")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraEdicao;

    @InfoCampo(tipo = FabTipoAtributoObjeto.HTML_TEMPLATE, grupoPadrao = "Campos Textuais")
    private String htmlModelo;

    @InfoCampo(tipo = FabTipoAtributoObjeto.HTML, grupoPadrao = "Campos Textuais")
    private String htmlSimples;

    @ManyToOne()
    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA, grupoPadrao = "Campo seletor Entidade")
    private EntdExemplo opcaoDe2;

    @ManyToOne()
    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA, grupoPadrao = "Campo seletor Entidade")
    private EntdExemplo opcaode3;

    @ManyToOne()
    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA, grupoPadrao = "Campo seletor Entidade")
    private EntdExemplo opcaode4;

    @ManyToOne()
    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA, grupoPadrao = "Campo seletor Entidade")
    private EntdExemplo opcaoPersonalizada;

    @ManyToOne()
    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA, grupoPadrao = "Campo seletor Entidade")
    private EntdExemplo opcaoDe10;

    @InfoCampo(tipo = FabTipoAtributoObjeto.ENUM_FABRICA, grupoPadrao = "Campo seletor Entidade", label = "Armazenamento de Enum")
    private FabTipoAgenteOrganizacao fabricaEnum;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "entidadeExemplo_listaopcoes",
            joinColumns = @JoinColumn(name = "entidadeExemplo_id"),
            inverseJoinColumns = @JoinColumn(name = "entidade_da_lista_id"))
    @InfoCampo(tipo = FabTipoAtributoObjeto.LISTA_OBJETOS_PUBLICOS, grupoPadrao = "Campo seletor Entidade Pública")
    private List<EntdExemplo> listaDeOpcoesEntidadePublica;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "entidadePai", targetEntity = EntdParticularExemplo.class)
    @InfoCampo(tipo = FabTipoAtributoObjeto.LISTA_OBJETOS_PARTICULARES, grupoPadrao = "Campo seletor Entidade Particular")
    private List<EntdParticularExemplo> listaDeOpcoesEntidadeParticular;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorMoedaReal() {
        return valorMoedaReal;
    }

    public void setValorMoedaReal(double valorMoedaReal) {
        this.valorMoedaReal = valorMoedaReal;
    }

    public double getValorMoedaDollar() {
        return valorMoedaDollar;
    }

    public void setValorMoedaDollar(double valorMoedaDollar) {
        this.valorMoedaDollar = valorMoedaDollar;
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public UsuarioSB getUsuarioFornecedor() {
        return usuarioFornecedor;
    }

    public void setUsuarioFornecedor(UsuarioSB usuarioFornecedor) {
        this.usuarioFornecedor = usuarioFornecedor;
    }

    public UsuarioSB getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(UsuarioSB usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public UsuarioSB getUsuarioEdicao() {
        return usuarioEdicao;
    }

    public void setUsuarioEdicao(UsuarioSB usuarioEdicao) {
        this.usuarioEdicao = usuarioEdicao;
    }

    public Date getDataHoraInsercao() {
        return dataHoraInsercao;
    }

    public void setDataHoraInsercao(Date dataHoraInsercao) {
        this.dataHoraInsercao = dataHoraInsercao;
    }

    public Date getDataHoraEdicao() {
        return dataHoraEdicao;
    }

    public void setDataHoraEdicao(Date dataHoraEdicao) {
        this.dataHoraEdicao = dataHoraEdicao;
    }

    public String getHtmlModelo() {
        return htmlModelo;
    }

    public void setHtmlModelo(String htmlModelo) {
        this.htmlModelo = htmlModelo;
    }

    public String getHtmlSimples() {
        return htmlSimples;
    }

    public void setHtmlSimples(String htmlSimples) {
        this.htmlSimples = htmlSimples;
    }

    public EntdExemplo getOpcaoDe2() {
        return opcaoDe2;
    }

    public void setOpcaoDe2(EntdExemplo opcaoDe2) {
        this.opcaoDe2 = opcaoDe2;
    }

    public EntdExemplo getOpcaode3() {
        return opcaode3;
    }

    public void setOpcaode3(EntdExemplo opcaode3) {
        this.opcaode3 = opcaode3;
    }

    public EntdExemplo getOpcaode4() {
        return opcaode4;
    }

    public void setOpcaode4(EntdExemplo opcaode4) {
        this.opcaode4 = opcaode4;
    }

    public EntdExemplo getOpcaoPersonalizada() {
        return opcaoPersonalizada;
    }

    public void setOpcaoPersonalizada(EntdExemplo opcaoPersonalizada) {
        this.opcaoPersonalizada = opcaoPersonalizada;
    }

    public EntdExemplo getOpcaoDe10() {
        return opcaoDe10;
    }

    public void setOpcaoDe10(EntdExemplo opcaoDe10) {
        this.opcaoDe10 = opcaoDe10;
    }

    public FabTipoAgenteOrganizacao getFabricaEnum() {
        return fabricaEnum;
    }

    public void setFabricaEnum(FabTipoAgenteOrganizacao fabricaEnum) {
        this.fabricaEnum = fabricaEnum;
    }

    public List<EntdExemplo> getListaDeOpcoesEntidadePublica() {
        return listaDeOpcoesEntidadePublica;
    }

    public void setListaDeOpcoesEntidadePublica(List<EntdExemplo> listaDeOpcoesEntidadePublica) {
        this.listaDeOpcoesEntidadePublica = listaDeOpcoesEntidadePublica;
    }

    public String getTipEntidade() {
        return tipEntidade;
    }

    public void setTipEntidade(String tipEntidade) {
        this.tipEntidade = tipEntidade;
    }

    public List<EntdParticularExemplo> getListaDeOpcoesEntidadeParticular() {
        return listaDeOpcoesEntidadeParticular;
    }

    public void setListaDeOpcoesEntidadeParticular(List<EntdParticularExemplo> listaDeOpcoesEntidadeParticular) {
        this.listaDeOpcoesEntidadeParticular = listaDeOpcoesEntidadeParticular;
    }

}
