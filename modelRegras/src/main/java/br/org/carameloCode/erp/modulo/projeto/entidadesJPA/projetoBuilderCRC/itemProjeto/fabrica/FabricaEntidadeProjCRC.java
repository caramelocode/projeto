/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.ComoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.modulo.ModuloProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.EntidadeORMNormal;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoPreparacaoObjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.coletivojava.fw.api.tratamentoErros.ErroPreparandoObjeto;

/**
 * Fábrica (enum) do projeto gerado. Cada {@link ItemFabrica} vira uma constante
 * do enum, anotada com {@code @InfoObjetoDaFabrica}.
 *
 * Exemplo gerado: {@code FabExemploComponenteNativo implements
 * ComoFabricaComPersistencia}. A subclasse {@link FabricaStatusProjCRC} gera
 * fábricas de status ({@code ComoFabricaStatus}).
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = {"Fábrica do Projeto"}, plural = "Fábricas do Projeto", icone = "fa fa-industry")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoFabricaDB")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"projeto_id", "nomeFabrica"}))
public class FabricaEntidadeProjCRC extends EntidadeORMNormal implements ComoItemProjeto {

    @Id
    @InfoCampo(tipo = FabTipoAtributoObjeto.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome do enum gerado, ex.: FabStatusProjeto. Chave usada pelo console.
     */
    @InfoCampo(tipo = FabTipoAtributoObjeto.NOME)
    private String nomeFabrica;

    @InfoCampo(tipo = FabTipoAtributoObjeto.DESCRITIVO)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @InfoCampo(tipo = FabTipoAtributoObjeto.ENUM_FABRICA)
    private FabTipoItemProjeto tipoItemProjeto;

    /**
     * Entidade padrão dos itens (classeObjeto do @InfoObjetoDaFabrica).
     */
    @ManyToOne(targetEntity = ObjetoProjCRC.class)
    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA)
    private ObjetoProjCRC tipoObjetoPadrao;

    @ManyToOne(targetEntity = ModuloProjCRC.class)
    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA)
    private ModuloProjCRC modulo;

    @ManyToOne(targetEntity = ProjetoCRC.class)
    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA)
    private ProjetoCRC projeto;

    @OneToMany(targetEntity = ItemFabrica.class, mappedBy = "fabrica", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ItemFabrica> itens;

    @Column(nullable = false, updatable = false, insertable = false)
    private String tipoFabricaDB;

    @InfoCampo(tipo = FabTipoAtributoObjeto.REG_DATAALTERACAO, label = "Data/Hora Alteração", descricao = "Data e hora de alteração")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraAlteracao;

    @InfoCampo(tipo = FabTipoAtributoObjeto.REG_DATAINSERCAO, label = "Data/Hora Inserção", descricao = "Data e hora de inserção")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraInsersao = new Date();

    @InfoCampo(tipo = FabTipoAtributoObjeto.REG_USUARIO_INSERCAO, label = "Usuário Inserção", descricao = "Usuário que fez a inserção")
    @ManyToOne(targetEntity = UsuarioSB.class)
    private UsuarioSB usuarioInsercao;

    @InfoCampo(tipo = FabTipoAtributoObjeto.REG_USUARIO_ALTERACAO, label = "Usuário Alteração", descricao = "Usuário que fez a alteração")
    @ManyToOne(targetEntity = UsuarioSB.class)
    private UsuarioSB usuarioAlteracao;

    /**
     * Parâmetro principal: o projeto ({@link ProjetoCRC}). Opcional: o nome da
     * fábrica (String), ex.: FabStatusPedido.
     */
    @Override
    @InfoPreparacaoObjeto(classesPrConstructorPrincipal = ProjetoCRC.class)
    public void prepararNovoObjeto(Object... parametros) throws ErroPreparandoObjeto {
        super.prepararNovoObjeto(parametros);
        setProjeto(getParametroInicialEnviado(ProjetoCRC.class, parametros));
        if (isTemParametroDesteTipo(String.class, parametros)) {
            setNomeFabrica(getParametroInicialEnviado(String.class, parametros));
        }
        setTipoItemProjeto(FabTipoItemProjeto.FABRICA_ENTIDADE_GENERICA);
    }

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
        return nomeFabrica;
    }

    @Override
    public void setNome(String pNome) {
        this.nomeFabrica = pNome;
    }

    public String getNomeFabrica() {
        return nomeFabrica;
    }

    public void setNomeFabrica(String nomeFabrica) {
        this.nomeFabrica = nomeFabrica;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public FabTipoItemProjeto getTipoItemProjeto() {
        return tipoItemProjeto;
    }

    public void setTipoItemProjeto(FabTipoItemProjeto tipoItemProjeto) {
        this.tipoItemProjeto = tipoItemProjeto;
    }

    public ObjetoProjCRC getTipoObjetoPadrao() {
        return tipoObjetoPadrao;
    }

    public void setTipoObjetoPadrao(ObjetoProjCRC tipoObjetoPadrao) {
        this.tipoObjetoPadrao = tipoObjetoPadrao;
    }

    public ModuloProjCRC getModulo() {
        return modulo;
    }

    public void setModulo(ModuloProjCRC modulo) {
        this.modulo = modulo;
    }

    public ProjetoCRC getProjeto() {
        return projeto;
    }

    public void setProjeto(ProjetoCRC projeto) {
        this.projeto = projeto;
    }

    public List<ItemFabrica> getItens() {
        return itens;
    }

    public void setItens(List<ItemFabrica> itens) {
        this.itens = itens;
    }

    public String getTipoFabricaDB() {
        return tipoFabricaDB;
    }

    public void setTipoFabricaDB(String tipoFabricaDB) {
        this.tipoFabricaDB = tipoFabricaDB;
    }

    public Date getDataHoraAlteracao() {
        return dataHoraAlteracao;
    }

    public void setDataHoraAlteracao(Date dataHoraAlteracao) {
        this.dataHoraAlteracao = dataHoraAlteracao;
    }

    public Date getDataHoraInsersao() {
        return dataHoraInsersao;
    }

    public void setDataHoraInsersao(Date dataHoraInsersao) {
        this.dataHoraInsersao = dataHoraInsersao;
    }

    public UsuarioSB getUsuarioInsercao() {
        return usuarioInsercao;
    }

    public void setUsuarioInsercao(UsuarioSB usuarioInsercao) {
        this.usuarioInsercao = usuarioInsercao;
    }

    public UsuarioSB getUsuarioAlteracao() {
        return usuarioAlteracao;
    }

    public void setUsuarioAlteracao(UsuarioSB usuarioAlteracao) {
        this.usuarioAlteracao = usuarioAlteracao;
    }

}
