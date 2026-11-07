/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.ComoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.requisito.RequisitoDeProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.modulo.ModuloProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.acoes.ComoEstruturaAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.fabricas.FabTipoAcaoSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.fabricas.FabTipoAcaoSistemaGenerica;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoPreparacaoObjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.EntidadeSimples;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.coletivojava.fw.api.tratamentoErros.ErroPreparandoObjeto;

/**
 *
 * @author salvio
 */
@Entity
@DiscriminatorColumn(name = "tipoAcaoDB")
@InfoObjetoSB(tags = {"Ação do Sistema"}, plural = "Ações do sistema")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"projeto_id", "nomeUnico"}))
public class AcaoProjCRC extends EntidadeSimples implements ComoEstruturaAcaoDoSistema, ComoItemProjeto {

    @Id
    @InfoCampo(tipo = FabTipoAtributoObjeto.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Enumerated(EnumType.STRING)
    private FabTipoAcaoSistema tipoAcao;
    @Enumerated(EnumType.STRING)
    protected FabTipoAcaoSistemaGenerica tipoAcaoGenerica;

    @InfoCampo(tipo = FabTipoAtributoObjeto.ENUM_FABRICA)
    private FabTipoItemProjeto tipoItemProjeto;

    @InfoCampo(tipo = FabTipoAtributoObjeto.NOME)
    protected String nomeAcao;
    private String iconeAcao;
    private String cor;
    private String descricao;
    private boolean precisaPermissao;
    @ManyToOne(targetEntity = ModuloProjCRC.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private ModuloProjCRC modulo;

    private String idDescritivoJira;
    @Column(nullable = false, updatable = false, insertable = false)
    private String tipoAcaoDB;

    private String nomeUnico;
    private String nomeDominio;
    private FabTipoAcaoSistema tipoAcaoSistema;

    @ManyToOne(targetEntity = ObjetoProjCRC.class)
    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA)
    private ObjetoProjCRC entidadeDominio;

    @ManyToOne(targetEntity = ProjetoCRC.class)
    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA)
    private ProjetoCRC projeto;

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
     * Prepara a ação a partir do texto digitado no console.
     *
     * Uso: acao.prepararNovoObjeto(projeto,
     * "FabAcaoGerente_o_CLIENTE_FRM_LISTAR")
     *
     * A subclasse (gestão, formulário ou controller) é escolhida por quem
     * instancia, ver FabTipoItemProjeto.ACAO.getItemByTexto.
     */
    @Override
    @InfoPreparacaoObjeto(classesPrConstructorPrincipal = ProjetoCRC.class)
    public void prepararNovoObjeto(Object... parametros) throws ErroPreparandoObjeto {
        super.prepararNovoObjeto(parametros);
        setTipoItemProjeto(FabTipoItemProjeto.ACAO);
        setProjeto(getParametroInicialEnviado(ProjetoCRC.class, parametros));
        if (isTemParametroDesteTipo(String.class, parametros)) {
            aplicarNomeDigitado(getParametroInicialEnviado(String.class, parametros));
        }
    }

    /**
     * Preenche nome, domínio, entidade de domínio, módulo e tipo a partir de
     * FabAcao[Modulo][Entidade]_o_[ENTIDADE]_[MB|FRM|CTR]_[DESCRICAO]
     */
    private void aplicarNomeDigitado(String pTexto) {
        setNomeUnico(UtilProjCRCNomeAcao.getNomeUnico(pTexto));
        setNomeAcao(UtilProjCRCNomeAcao.getNomeAcao(pTexto));
        String entidadeCaixaAlta = UtilProjCRCNomeAcao.getNomeEntidadeAcao(pTexto);
        setNomeDominio(entidadeCaixaAlta);

        ObjetoProjCRC entidade = getEntidadeDoProjetoPorNomeAcao(entidadeCaixaAlta);
        setEntidadeDominio(entidade);
        String nomeEntidade = entidade != null ? entidade.getNomeEntidade() : UtilProjCRCNomeAcao.getNomeEntidadeCamelCase(entidadeCaixaAlta);
        setModulo(getModuloDoProjeto(UtilProjCRCNomeAcao.getNomeModulo(pTexto, nomeEntidade)));

        String trechoTipo = UtilProjCRCNomeAcao.getTrechoTipoEDescricao(pTexto);
        if (trechoTipo != null) {
            setTipoAcaoGenerica(FabTipoAcaoSistemaGenerica.getAcaoGenericaByNome(trechoTipo));
            setTipoAcao(getTipoAcaoPorSigla(UtilProjCRCNomeAcao.getSiglaTipo(pTexto), entidade != null));
        }
        aplicarVinculosDoNomeDigitado();
    }

    /**
     * Executado depois de interpretar o nome digitado, para as subclasses
     * completarem seus vínculos (ex.: ação secundária → gestão).
     */
    protected void aplicarVinculosDoNomeDigitado() {

    }

    private static FabTipoAcaoSistema getTipoAcaoPorSigla(String pSigla, boolean pPossuiEntidade) {
        switch (pSigla) {
            case UtilProjCRCNomeAcao.SIGLA_GESTAO:
                return FabTipoAcaoSistema.ACAO_ENTIDADE_GERENCIAR;
            case UtilProjCRCNomeAcao.SIGLA_FORMULARIO:
                return pPossuiEntidade ? FabTipoAcaoSistema.ACAO_ENTIDADE_FORMULARIO : FabTipoAcaoSistema.ACAO_FORMULARIO;
            case UtilProjCRCNomeAcao.SIGLA_CONTROLLER:
                return pPossuiEntidade ? FabTipoAcaoSistema.ACAO_ENTIDADE_CONTROLLER : FabTipoAcaoSistema.ACAO_CONTROLLER;
            default:
                return null;
        }
    }

    private ObjetoProjCRC getEntidadeDoProjetoPorNomeAcao(String pEntidadeCaixaAlta) {
        if (projeto == null || projeto.getObjetos() == null || pEntidadeCaixaAlta == null) {
            return null;
        }
        return projeto.getObjetos().stream()
                .filter(obj -> pEntidadeCaixaAlta.equals(UtilProjCRCNomeAcao.getNomeEntidadeCaixaAlta(obj.getNomeEntidade())))
                .findFirst().orElse(null);
    }

    /**
     * Módulo existente do projeto com o nome informado (procurado nos módulos
     * do projeto e nos módulos das ações já salvas), ou um módulo novo, salvo
     * em cascata junto com a ação.
     */
    private ModuloProjCRC getModuloDoProjeto(String pNomeModulo) {
        if (projeto != null) {
            List<ModuloProjCRC> modulosExistentes = new ArrayList<>();
            if (projeto.getModulos() != null) {
                modulosExistentes.addAll(projeto.getModulos());
            }
            if (projeto.getAcoes() != null) {
                projeto.getAcoes().stream()
                        .map(AcaoProjCRC::getModulo)
                        .filter(Objects::nonNull)
                        .forEach(modulosExistentes::add);
            }
            Optional<ModuloProjCRC> existente = modulosExistentes.stream()
                    .filter(mod -> pNomeModulo.equals(mod.getNome()))
                    .findFirst();
            if (existente.isPresent()) {
                return existente.get();
            }
        }
        ModuloProjCRC novoModulo = new ModuloProjCRC();
        novoModulo.setNome(pNomeModulo);
        novoModulo.setProjeto(projeto);
        return novoModulo;
    }

    private RequisitoDeProjeto requisito;

    public FabTipoAcaoSistema getTipoAcao() {
        return tipoAcao;
    }

    public void setTipoAcao(FabTipoAcaoSistema tipoAcao) {
        this.tipoAcao = tipoAcao;
    }

    public FabTipoAcaoSistemaGenerica getTipoAcaoGenerica() {
        return tipoAcaoGenerica;
    }

    public void setTipoAcaoGenerica(FabTipoAcaoSistemaGenerica tipoAcaoGenerica) {
        this.tipoAcaoGenerica = tipoAcaoGenerica;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAcao() {
        return nomeAcao;
    }

    public void setNomeAcao(String nomeAcao) {
        this.nomeAcao = nomeAcao;
    }

    public String getIconeAcao() {
        return iconeAcao;
    }

    public void setIconeAcao(String iconeAcao) {
        this.iconeAcao = iconeAcao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isPrecisaPermissao() {
        return precisaPermissao;
    }

    public void setPrecisaPermissao(boolean precisaPermissao) {
        this.precisaPermissao = precisaPermissao;
    }

    public ModuloProjCRC getModulo() {
        return modulo;
    }

    public void setModulo(ModuloProjCRC modulo) {
        this.modulo = modulo;
    }

    public String getIdDescritivoJira() {
        return idDescritivoJira;
    }

    public void setIdDescritivoJira(String idDescritivoJira) {
        this.idDescritivoJira = idDescritivoJira;
    }

    public String getTipoAcaoDB() {
        return tipoAcaoDB;
    }

    public void setTipoAcaoDB(String tipoAcaoDB) {
        this.tipoAcaoDB = tipoAcaoDB;
    }

    public String getNomeUnico() {
        return nomeUnico;
    }

    public void setNomeUnico(String nomeUnico) {
        this.nomeUnico = nomeUnico;
    }

    public String getNomeDominio() {
        return nomeDominio;
    }

    public void setNomeDominio(String nomeDominio) {
        this.nomeDominio = nomeDominio;
    }

    public FabTipoAcaoSistema getTipoAcaoSistema() {
        return tipoAcaoSistema;
    }

    public void setTipoAcaoSistema(FabTipoAcaoSistema tipoAcaoSistema) {
        this.tipoAcaoSistema = tipoAcaoSistema;
    }

    @Override
    public boolean isUmaAcaoFormulario() {
        return this instanceof AcaoProjCRCFormulario;
    }

    @Override
    public boolean isTemAcaoPrincipal() {
        return false;
    }

    @Override
    public boolean isUmaAcaoGenerica() {
        return tipoAcaoGenerica != null;
    }

    @Override
    public boolean isUmaAcaoGestaoDominio() {
        return this instanceof AcaoProjCRCGestao;
    }

    @Override
    public boolean isUmaAcaoDeEntidade() {
        return false;
    }

    @Override
    public boolean isUmaAcaoController() {
        return this instanceof AcaoProjCRCContoller;
    }

    public RequisitoDeProjeto getRequisito() {
        return requisito;
    }

    public void setRequisito(RequisitoDeProjeto requisito) {
        this.requisito = requisito;
    }

    public FabTipoItemProjeto getTipoItemProjeto() {
        return tipoItemProjeto;
    }

    public void setTipoItemProjeto(FabTipoItemProjeto tipoItemProjeto) {
        this.tipoItemProjeto = tipoItemProjeto;
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

    public ObjetoProjCRC getEntidadeDominio() {
        return entidadeDominio;
    }

    public void setEntidadeDominio(ObjetoProjCRC entidadeDominio) {
        this.entidadeDominio = entidadeDominio;
    }

    public ProjetoCRC getProjeto() {
        return projeto;
    }

    public void setProjeto(ProjetoCRC projeto) {
        this.projeto = projeto;
    }

}
