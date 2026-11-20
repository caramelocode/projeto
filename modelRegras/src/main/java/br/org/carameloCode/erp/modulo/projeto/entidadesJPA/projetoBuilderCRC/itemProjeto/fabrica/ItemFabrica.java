/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.ComoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.EntidadeORMNormal;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoPreparacaoObjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.coletivojava.fw.api.tratamentoErros.ErroPreparandoObjeto;

/**
 * Constante de uma fábrica do projeto gerado. Corresponde a:
 *
 * <pre>
 * &#64;InfoObjetoDaFabrica(id = [idObjeto], nomeObjeto = "[nomeObjeto]", cor = "[cor]", icone = "[icone]", classeObjeto = [tipoObjeto].class)
 * [nomeEnum],
 * </pre>
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = {"Item de Fábrica"}, plural = "Itens de Fábrica", icone = "fa fa-hashtag")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoItemFabricaDB")
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"fabrica_id", "nomeEnum"}),
    @UniqueConstraint(columnNames = {"fabrica_id", "idObjeto"})})
public class ItemFabrica extends EntidadeORMNormal implements ComoItemProjeto {

    @Id
    @InfoCampo(tipo = FabTipoAtributoObjeto.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = FabricaEntidadeProjCRC.class)
    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA, somenteLeitura = true)
    private FabricaEntidadeProjCRC fabrica;

    /**
     * Nome da constante do enum, ex.: EM_ATUALIZACAO.
     */
    @InfoCampo(tipo = FabTipoAtributoObjeto.NOME)
    private String nomeEnum;

    /**
     * id fixo do objeto gerado (id do @InfoObjetoDaFabrica), sequencial dentro
     * da fábrica. Não é o id JPA deste registro.
     */
    @InfoCampo(tipo = FabTipoAtributoObjeto.QUANTIDADE)
    private Long idObjeto;

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES)
    private String nomeObjeto;

    /**
     * classeObjeto do @InfoObjetoDaFabrica.
     */
    @ManyToOne(targetEntity = ObjetoProjCRC.class)
    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA)
    private ObjetoProjCRC tipoObjeto;

    private String pacoteImplantacao;

    @InfoCampo(tipo = FabTipoAtributoObjeto.ICONE)
    private String icone;

    @InfoCampo(tipo = FabTipoAtributoObjeto.COR)
    private String cor;

    @Column(nullable = false, updatable = false, insertable = false)
    private String tipoItemFabricaDB;

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
     * Parâmetro principal: a fábrica ({@link FabricaEntidadeProjCRC}).Opcionais: o
 nome digitado (String, ex.: emAtualizacao ou EM_ATUALIZACAO) e o tipo do
 objeto ({@link ObjetoProjCRC}); sem ele, usa o tipo padrão da fábrica. O item não é adicionado em fabrica.getItens().
     */
    @Override
    @InfoPreparacaoObjeto(classesPrConstructorPrincipal = FabricaEntidadeProjCRC.class)
    public void prepararNovoObjeto(Object... parametros) throws ErroPreparandoObjeto {
        super.prepararNovoObjeto(parametros);
        setFabrica(getParametroInicialEnviado(FabricaEntidadeProjCRC.class, parametros));
        if (isTemParametroDesteTipo(ObjetoProjCRC.class, parametros)) {
            setTipoObjeto(getParametroInicialEnviado(ObjetoProjCRC.class, parametros));
        } else if (getFabrica() != null) {
            setTipoObjeto(getFabrica().getTipoObjetoPadrao());
        }
        if (isTemParametroDesteTipo(String.class, parametros)) {
            String texto = getParametroInicialEnviado(String.class, parametros);
            setNomeEnum(getNomeEnumPorTexto(texto));
            setNomeObjeto(getNomeObjetoPorTexto(texto));
        }
        setIdObjeto(getProximoIdObjeto(getFabrica()));
    }

    /**
     * emAtualizacao, EmAtualizacao ou EM_ATUALIZACAO → EM_ATUALIZACAO.
     */
    public static String getNomeEnumPorTexto(String pTexto) {
        if (pTexto == null) {
            return null;
        }
        String texto = pTexto.trim();
        if (texto.contains("_") || texto.equals(texto.toUpperCase())) {
            return texto.toUpperCase();
        }
        return texto.replaceAll("([a-z0-9])([A-Z])", "$1_$2").toUpperCase();
    }

    /**
     * emAtualizacao ou EM_ATUALIZACAO → Em atualizacao.
     */
    public static String getNomeObjetoPorTexto(String pTexto) {
        String nomeEnum = getNomeEnumPorTexto(pTexto);
        if (nomeEnum == null || nomeEnum.isEmpty()) {
            return nomeEnum;
        }
        String nome = nomeEnum.replace("_", " ").toLowerCase();
        return nome.substring(0, 1).toUpperCase() + nome.substring(1);
    }

    /**
     * Maior idObjeto entre os itens da fábrica, mais 1.
     */
    public static Long getProximoIdObjeto(FabricaEntidadeProjCRC pFabrica) {
        long maior = 0;
        if (pFabrica != null && pFabrica.getItens() != null) {
            for (ItemFabrica item : pFabrica.getItens()) {
                if (item.getIdObjeto() != null && item.getIdObjeto() > maior) {
                    maior = item.getIdObjeto();
                }
            }
        }
        return maior + 1;
    }

    @Override
    public FabTipoItemProjeto getTipoItemProjeto() {
        if (fabrica == null) {
            return null;
        }
        return fabrica.getTipoItemProjeto();
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
        return nomeEnum;
    }

    @Override
    public void setNome(String pNome) {
        this.nomeEnum = pNome;
    }

    public FabricaEntidadeProjCRC getFabrica() {
        return fabrica;
    }

    public void setFabrica(FabricaEntidadeProjCRC fabrica) {
        this.fabrica = fabrica;
    }

    public String getNomeEnum() {
        return nomeEnum;
    }

    public void setNomeEnum(String nomeEnum) {
        this.nomeEnum = nomeEnum;
    }

    public Long getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(Long idObjeto) {
        this.idObjeto = idObjeto;
    }

    public String getNomeObjeto() {
        return nomeObjeto;
    }

    public void setNomeObjeto(String nomeObjeto) {
        this.nomeObjeto = nomeObjeto;
    }

    public ObjetoProjCRC getTipoObjeto() {
        return tipoObjeto;
    }

    public void setTipoObjeto(ObjetoProjCRC tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }

    public String getPacoteImplantacao() {
        return pacoteImplantacao;
    }

    public void setPacoteImplantacao(String pacoteImplantacao) {
        this.pacoteImplantacao = pacoteImplantacao;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipoItemFabricaDB() {
        return tipoItemFabricaDB;
    }

    public void setTipoItemFabricaDB(String tipoItemFabricaDB) {
        this.tipoItemFabricaDB = tipoItemFabricaDB;
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
