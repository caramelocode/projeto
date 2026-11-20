/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.ComoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoInstanciaAtributoProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.EntidadeSimplesORM;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampoValorLogico;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampoVerdadeiroOuFalso;
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
@InfoObjetoSB(tags = {"Atributo de Entidade"}, plural = "Atributos de Entidade", icone = "fa fa-tag")
public class AtributoDeEntidadeSimples extends EntidadeSimplesORM implements ComoItemProjeto {

    @Id
    @InfoCampo(tipo = FabTipoAtributoObjeto.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @InfoCampo(tipo = FabTipoAtributoObjeto.NOME)
    private String nomeDeclarado;

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES)
    private String label;

    @InfoCampo(tipo = FabTipoAtributoObjeto.DESCRITIVO)
    private String descricao;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso()
    private boolean obrigatorio;

    @Enumerated(EnumType.STRING)
    private FabTipoAtributoObjeto tipo;

    @ManyToOne(targetEntity = ObjetoProjCRC.class)
    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA, somenteLeitura = true)
    private ObjetoProjCRC entidade;

    @Column(nullable = false, updatable = false, insertable = false)
    private String tipoAtributo;

    @InfoCampo(tipo = FabTipoAtributoObjeto.QUANTIDADE)
    @InfoCampoValorLogico(nomeCalculo = "Valor Máximo", somenteLeitura = false)
    private int valorMaximo;
    @InfoCampo(tipo = FabTipoAtributoObjeto.QUANTIDADE)
    @InfoCampoValorLogico(nomeCalculo = "Valor Mínimo", somenteLeitura = false)
    private int valorMinimo;
    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES)
    @InfoCampoValorLogico(nomeCalculo = "Validação regex", somenteLeitura = false)
    private String validacaoRegex;
    @InfoCampoValorLogico(nomeCalculo = "Separador Decimal", somenteLeitura = false)
    private char separadorDecimal = ',';
    @InfoCampoValorLogico(nomeCalculo = "Separador Milhar", somenteLeitura = false)
    private char separadorMilhar = '.';
    @InfoCampo(tipo = FabTipoAtributoObjeto.QUANTIDADE)
    @InfoCampoValorLogico(nomeCalculo = "Número casas decimais", somenteLeitura = false)
    private int numeroDeCasasDecimais;
    @InfoCampo(tipo = FabTipoAtributoObjeto.QUANTIDADE)
    @InfoCampoValorLogico(nomeCalculo = "Jsquery Mascara", somenteLeitura = false)
    private String mascaraJqueryMode;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso()
    @InfoCampoValorLogico(nomeCalculo = "Veradeiro ou falso", somenteLeitura = false)
    private boolean somenteLeitura;
    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES)

    private String fraseValidacao;
    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoValorLogico(nomeCalculo = "Uma Lista dinâminca", somenteLeitura = false)
    private boolean umalistagemDinamica;
    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoValorLogico(nomeCalculo = "Valor Campo ÙNICO", somenteLeitura = false)
    private boolean umValorCampoUnico;
    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES)
    @InfoCampoValorLogico(nomeCalculo = "Icone Positivo", somenteLeitura = false)
    private String iconePositivo;
    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES)
    @InfoCampoValorLogico(nomeCalculo = "Texto Positivo", somenteLeitura = false)
    private String textoPositivo;
    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES)
    @InfoCampoValorLogico(nomeCalculo = "Icone Negativo", somenteLeitura = false)
    private String iconeNegativo;
    @InfoCampoValorLogico(nomeCalculo = "Texto Negativo", somenteLeitura = false)
    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES)
    private String textoNegativo;

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

    @InfoCampo(tipo = FabTipoAtributoObjeto.QUANTIDADE)
    @InfoCampoValorLogico(nomeCalculo = "Ordem")
    private int ordem;

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
            //   if (getTipo() == null) {
            //Define o tipo pela String
            //     FabTipoInstanciaAtributoProjeto.ATRIBUTO_SIMPLES.getTipoPeloNome(getNomeDeclarado());

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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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

    public int getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(int valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public int getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(int valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public String getValidacaoRegex() {
        return validacaoRegex;
    }

    public void setValidacaoRegex(String validacaoRegex) {
        this.validacaoRegex = validacaoRegex;
    }

    public char getSeparadorDecimal() {
        return separadorDecimal;
    }

    public void setSeparadorDecimal(char separadorDecimal) {
        this.separadorDecimal = separadorDecimal;
    }

    public char getSeparadorMilhar() {
        return separadorMilhar;
    }

    public void setSeparadorMilhar(char separadorMilhar) {
        this.separadorMilhar = separadorMilhar;
    }

    public int getNumeroDeCasasDecimais() {
        return numeroDeCasasDecimais;
    }

    public void setNumeroDeCasasDecimais(int numeroDeCasasDecimais) {
        this.numeroDeCasasDecimais = numeroDeCasasDecimais;
    }

    public String getMascaraJqueryMode() {
        return mascaraJqueryMode;
    }

    public void setMascaraJqueryMode(String mascaraJqueryMode) {
        this.mascaraJqueryMode = mascaraJqueryMode;
    }

    public boolean isSomenteLeitura() {
        return somenteLeitura;
    }

    public void setSomenteLeitura(boolean somenteLeitura) {
        this.somenteLeitura = somenteLeitura;
    }

    public String getFraseValidacao() {
        return fraseValidacao;
    }

    public void setFraseValidacao(String fraseValidacao) {
        this.fraseValidacao = fraseValidacao;
    }

    public boolean isUmalistagemDinamica() {
        return umalistagemDinamica;
    }

    public void setUmalistagemDinamica(boolean umalistagemDinamica) {
        this.umalistagemDinamica = umalistagemDinamica;
    }

    public boolean isUmValorCampoUnico() {
        return umValorCampoUnico;
    }

    public void setUmValorCampoUnico(boolean umValorCampoUnico) {
        this.umValorCampoUnico = umValorCampoUnico;
    }

    public String getIconePositivo() {
        return iconePositivo;
    }

    public void setIconePositivo(String iconePositivo) {
        this.iconePositivo = iconePositivo;
    }

    public String getTextoPositivo() {
        return textoPositivo;
    }

    public void setTextoPositivo(String textoPositivo) {
        this.textoPositivo = textoPositivo;
    }

    public String getIconeNegativo() {
        return iconeNegativo;
    }

    public void setIconeNegativo(String iconeNegativo) {
        this.iconeNegativo = iconeNegativo;
    }

    public String getTextoNegativo() {
        return textoNegativo;
    }

    public void setTextoNegativo(String textoNegativo) {
        this.textoNegativo = textoNegativo;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

}
