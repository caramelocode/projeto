/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.ComoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.EntidadeSimplesORM;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoPreparacaoObjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.coletivojava.fw.api.tratamentoErros.ErroPreparandoObjeto;

/**
 *
 * @author salvio
 */
@Entity
@DiscriminatorColumn(name = "tipoAtributo")
@InfoObjetoSB(tags = {"Atributo de Entidade"}, plural = "Atributos de Entidade")
public class AtributoDeEntidadeSimples extends EntidadeSimplesORM implements ComoItemProjeto {

    @Id
    @InfoCampo(tipo = FabTipoAtributoObjeto.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @InfoCampo(tipo = FabTipoAtributoObjeto.NOME)
    private String nomeDeclarado;

    private String descricao;

    private boolean obrigatorio;

    @Enumerated(EnumType.STRING)
    private FabTipoAtributoObjeto tipo;

    @ManyToOne(targetEntity = ObjetoProjCRC.class)
    private ObjetoProjCRC entidade;

    @Column(nullable = false, updatable = false, insertable = false)
    private String tipoAtributo;

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
     * Parâmetro principal: a entidade ({@link ObjetoProjCRC}) dona do atributo.
     * Opcionais: o tipo ({@link FabTipoAtributoObjeto}) e o nome declarado
     * (String).
     */
    @Override
    @InfoPreparacaoObjeto(classesPrConstructorPrincipal = ObjetoProjCRC.class)
    public void prepararNovoObjeto(Object... parametros) throws ErroPreparandoObjeto {
        super.prepararNovoObjeto(parametros);
        setEntidade(getParametroInicialEnviado(ObjetoProjCRC.class, parametros));
        if (isTemParametroDesteTipo(FabTipoAtributoObjeto.class, parametros)) {
            setTipo(getParametroInicialEnviado(FabTipoAtributoObjeto.class, parametros));
        }
        if (isTemParametroDesteTipo(String.class, parametros)) {
            setNomeDeclarado(getParametroInicialEnviado(String.class, parametros));
        }
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDeclarado() {
        return nomeDeclarado;
    }

    public void setNomeDeclarado(String nomeDeclarado) {
        this.nomeDeclarado = nomeDeclarado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isObrigatorio() {
        return obrigatorio;
    }

    public void setObrigatorio(boolean obrigatorio) {
        this.obrigatorio = obrigatorio;
    }

    public FabTipoAtributoObjeto getTipo() {
        return tipo;
    }

    public void setTipo(FabTipoAtributoObjeto tipo) {
        this.tipo = tipo;
    }

    public ObjetoProjCRC getEntidade() {
        return entidade;
    }

    public void setEntidade(ObjetoProjCRC entidade) {
        this.entidade = entidade;
    }

    @Override
    public FabTipoItemProjeto getTipoItemProjeto() {
        return FabTipoItemProjeto.ATRIBUTO_OBJETO;
    }

    public String getTipoAtributo() {
        return tipoAtributo;
    }

    public void setTipoAtributo(String tipoAtributo) {
        this.tipoAtributo = tipoAtributo;
    }

}
