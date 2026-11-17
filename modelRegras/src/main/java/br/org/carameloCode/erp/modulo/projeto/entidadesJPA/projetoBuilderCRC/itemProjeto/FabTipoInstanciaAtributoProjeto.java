/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto;

import br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadesimples.CPAtributoDeEntidadeSimples;
import static br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.FabTiposEntidade.TIPO_PADRAO_ATRIBUTO_SIMPLES;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeFabrica;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeFabricaStatus;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeStatus;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeEntidade;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeLista;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCStringsCammelCase;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.ARQUIVO_DE_ENTIDADE;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.CALENDARIO;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.CAMPO_SEPARADOR;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.CHART_CATEGORIA;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.CHART_LABEL;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.CHART_VALOR;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.CNPJ;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.CODIGO_DE_BARRAS;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.COR;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.CPF;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.DATA;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.DATAHORA;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.EMAIL;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.GRUPOS_DE_CAMPO;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.GRUPO_CAMPO;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.HORA;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.HTML;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.HTML_TEMPLATE;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.ICONE;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.INSCRIACAO_MUNICIPAL;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.INSCRICAO_ESTADUAL;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.LCCEP;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.LC_BAIRRO;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.LC_CAMPO_ABERTO;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.LC_CIDADE;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.LC_COMPLEMENTO;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.LC_COMPLEMENTO_E_NUMERO;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.LC_LOCALIDADE;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.LC_LOCALIZACAO;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.LC_LOGRADOURO;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.LC_UNIDADE_FEDERATIVA;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.MOEDA_DOLAR;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.MOEDA_REAL;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.NOME_COMPLETO;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.PERCENTUAL;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.REG_ATIVO_INATIVO;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.REG_DATAALTERACAO;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.REG_DATAINSERCAO;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.REG_USUARIO_ALTERACAO;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.REG_USUARIO_INSERCAO;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.RESPONSAVEL;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.SEGURANCA_ATIVA;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.SENHA;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.SENHA_SEGURANCA_MAXIMA;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.SITE;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.STATUS_ENUM;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.TELEFONE_CELULAR;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.TELEFONE_FIXO_INTERNACIONAL;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.TELEFONE_FIXO_NACIONAL;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.TELEFONE_GENERICO;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.TEXTO_SIMPLES;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.URL;
import static com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto.VERDADEIRO_FALSO;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author salvio
 */
public enum FabTipoInstanciaAtributoProjeto {

    ATRIBUTO_SIMPLES,
    ATRIBUTO_ENTIDADE,
    ATRIBUTO_ENTIDADE_STATUS,
    ATRIBUTO_LISTAGEM,
    ATRIBUTO_ENUM_FABRICA_GENERICA,
    ATRIBUTO_ENUM_STATUS,
    ATRIBUTO_DESCONHECIDO;

    private static Map<FabTipoInstanciaAtributoProjeto, List<FabTipoAtributoObjeto>> TIPOS_ATRIBUTO_POR_INSTANCIA = new HashMap<>();

    /**
     * Nomes (em minúsculas) com tipo definido de atributos simples. Os nomes
     * reservados (dataCriacao, dataEdicao) também ficam aqui e são verificados
     * antes das regras por trecho do nome.
     */
    private static final Map<String, FabTipoAtributoObjeto> TIPOS_POR_NOME_EXATO_ATRIBUTOSIMPLES;
    /**
     * Nomes reservados (em minúsculas) de atributos que referenciam outra
     * entidade: o nome define a instância (ATRIBUTO_ENTIDADE) e o tipo.
     */
    private static final Map<String, FabTipoAtributoObjeto> TIPOS_POR_NOME_EXATO_ATRIBUTOS_ENTIDADE;

    static {
        Map<String, FabTipoAtributoObjeto> tipos = new HashMap<>();

        tipos.put("datacriacao", FabTipoAtributoObjeto.REG_DATAINSERCAO);
        tipos.put("dataedicao", FabTipoAtributoObjeto.REG_DATAALTERACAO);
        tipos.put("nome", FabTipoAtributoObjeto.NOME);
        tipos.put("logo", FabTipoAtributoObjeto.IMG_PEQUENA);
        tipos.put("logohorizontal", FabTipoAtributoObjeto.IMG_MEDIA);
        tipos.put("descricao", FabTipoAtributoObjeto.DESCRITIVO);
        tipos.put("id", FabTipoAtributoObjeto.ID);
        tipos.put("latitude", FabTipoAtributoObjeto.LATITUDE);
        tipos.put("longitude", FabTipoAtributoObjeto.LONGITUDE);
        tipos.put("cep", FabTipoAtributoObjeto.LCCEP);
        tipos.put("senha", FabTipoAtributoObjeto.SENHA);
        tipos.put("complemento", FabTipoAtributoObjeto.LC_COMPLEMENTO_E_NUMERO);
        tipos.put("telefone", FabTipoAtributoObjeto.TELEFONE_GENERICO);
        tipos.put("cor", FabTipoAtributoObjeto.COR);
        tipos.put("email", FabTipoAtributoObjeto.EMAIL);
        tipos.put("icone", FabTipoAtributoObjeto.ICONE);
        tipos.put("cpf", FabTipoAtributoObjeto.CPF);
        tipos.put("cnpj", FabTipoAtributoObjeto.CNPJ);
        TIPOS_POR_NOME_EXATO_ATRIBUTOSIMPLES = Collections.unmodifiableMap(tipos);

        Map<String, FabTipoAtributoObjeto> tiposDeEntidade = new HashMap<>();
        tiposDeEntidade.put("bairro", FabTipoAtributoObjeto.LC_BAIRRO);
        tiposDeEntidade.put("cidade", FabTipoAtributoObjeto.LC_CIDADE);
        tiposDeEntidade.put("uf", FabTipoAtributoObjeto.LC_UNIDADE_FEDERATIVA);
        tiposDeEntidade.put("unidadefederativa", FabTipoAtributoObjeto.LC_UNIDADE_FEDERATIVA);
        tiposDeEntidade.put("localizacao", FabTipoAtributoObjeto.LC_LOCALIZACAO);
        tiposDeEntidade.put("usuariocriacao", FabTipoAtributoObjeto.REG_USUARIO_INSERCAO);
        tiposDeEntidade.put("usuarioedicao", FabTipoAtributoObjeto.REG_USUARIO_ALTERACAO);
        TIPOS_POR_NOME_EXATO_ATRIBUTOS_ENTIDADE = Collections.unmodifiableMap(tiposDeEntidade);
    }

    /**
     * Instância de um atributo digitado sem sufixo (sem . nem []), pelo nome:
     * nomes reservados de TIPOS_POR_NOME_EXATO_ATRIBUTOS_ENTIDADE (bairro, uf,
     * usuarioCriacao...) são ATRIBUTO_ENTIDADE; os demais, ATRIBUTO_SIMPLES.
     * Não diferencia maiúsculas de minúsculas.
     */
    public static FabTipoInstanciaAtributoProjeto getTipoInstanciaPeloNome(String pNomeAtributo) {
        if (pNomeAtributo != null && TIPOS_POR_NOME_EXATO_ATRIBUTOS_ENTIDADE.containsKey(pNomeAtributo.toLowerCase())) {
            return ATRIBUTO_ENTIDADE;
        }
        return ATRIBUTO_SIMPLES;
    }

    /**
     * Tipo usado quando o nome do atributo não indica nenhum tipo desta
     * instância.
     */
    public FabTipoAtributoObjeto getTipoPadrao() {
        switch (this) {
            case ATRIBUTO_SIMPLES:
                return TIPO_PADRAO_ATRIBUTO_SIMPLES;
            case ATRIBUTO_ENTIDADE:
            case ATRIBUTO_ENTIDADE_STATUS:
                return FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA;
            case ATRIBUTO_LISTAGEM:
                return FabTipoAtributoObjeto.LISTA_OBJETOS_PUBLICOS;
            case ATRIBUTO_ENUM_FABRICA_GENERICA:
                return FabTipoAtributoObjeto.ENUM_FABRICA;
            case ATRIBUTO_ENUM_STATUS:
                return FabTipoAtributoObjeto.STATUS_ENUM;
            case ATRIBUTO_DESCONHECIDO:
                return null;
            default:
                throw new AssertionError();
        }
    }

    /**
     * Nome padrão do atributo criado automaticamente com o tipo informado (ex.:
     * atributos padrão de uma entidade nova, FabTiposEntidade.aplicarAtributo).
     */
    public String getNomePadraoATributo(ObjetoProjCRC pObjeto, FabTipoAtributoObjeto pTipoAtributo) {
        switch (pTipoAtributo) {
            case ID:
                return "id";
            case NOME:
                return "nome";
            case NOME_LONGO:
            case NOME_COMPLETO:
                return "nomeCompleto";
            case DESCRITIVO:
                return "descricao";
            case REG_DATAALTERACAO:
                return "dataHoraAlteracao";
            case REG_DATAINSERCAO:
                return "dataHoraInsercao";
            case REG_USUARIO_ALTERACAO:
                return "usuarioAlteracao";
            case REG_USUARIO_INSERCAO:
                return "usuarioInsercao";
            case REG_ATIVO_INATIVO:
                return "ativo";
            default:
                return getNomeCamelCase(pTipoAtributo);
        }
    }

    /**
     * Nome padrão para tipos sem nome definido: o nome do enum em camelCase
     * (ex.: LC_CIDADE → lcCidade).
     */
    private static String getNomeCamelCase(FabTipoAtributoObjeto pTipoAtributo) {
        return UtilCRCStringsCammelCase.getCamelByTextoPrimeiraLetraMaiuscula(pTipoAtributo.name());
    }

    /**
     * Tipo de um atributo novo desta instância deduzido pelo nome declarado,
     * sem diferenciar maiúsculas de minúsculas.
     * <ul>
     * <li>ATRIBUTO_SIMPLES, na ordem: nome exato
     * (TIPOS_POR_NOME_EXATO_ATRIBUTOSIMPLES, incluindo dataCriacao e
     * dataEdicao); começa com qtd → QUANTIDADE; contém modelo → HTML_TEMPLATE;
     * contém dataHora → DATAHORA; senão contém data → DATA; senão contém hora →
     * HORA (dataHora contém data e hora, por isso vem antes).</li>
     * <li>ATRIBUTO_ENTIDADE: nome exato
     * (TIPOS_POR_NOME_EXATO_ATRIBUTOS_ENTIDADE).</li>
     * </ul>
     * Sem correspondência: getTipoPadrao().
     */
    public FabTipoAtributoObjeto getTipoPeloNome(String pNomeAtributo) {
        if (pNomeAtributo == null || pNomeAtributo.isEmpty()) {
            return getTipoPadrao();
        }
        String nome = pNomeAtributo.toLowerCase();
        switch (this) {
            case ATRIBUTO_SIMPLES: {
                FabTipoAtributoObjeto tipoExato = TIPOS_POR_NOME_EXATO_ATRIBUTOSIMPLES.get(nome);
                if (tipoExato != null) {
                    return tipoExato;
                }
                if (nome.startsWith("qtd")) {
                    return FabTipoAtributoObjeto.QUANTIDADE;
                }
                if (nome.contains("modelo")) {
                    return FabTipoAtributoObjeto.HTML_TEMPLATE;
                }
                if (nome.contains("datahora")) {
                    return FabTipoAtributoObjeto.DATAHORA;
                }
                if (nome.contains("data")) {
                    return FabTipoAtributoObjeto.DATA;
                }
                if (nome.contains("hora")) {
                    return FabTipoAtributoObjeto.HORA;
                }
                return FabTipoAtributoObjeto.TEXTO_SIMPLES;

            }
            case ATRIBUTO_ENTIDADE: {
                FabTipoAtributoObjeto tipoExato = TIPOS_POR_NOME_EXATO_ATRIBUTOS_ENTIDADE.get(nome);
                if (tipoExato != null) {
                    return tipoExato;
                }
                break;
            }
            case ATRIBUTO_ENTIDADE_STATUS:
            case ATRIBUTO_LISTAGEM:
                // Sem regra por nome: tipo padrão da instância
                break;
            case ATRIBUTO_ENUM_FABRICA_GENERICA:
                if (nome.contains("status")) {
                    return FabTipoAtributoObjeto.STATUS_ENUM;
                }
                return FabTipoAtributoObjeto.ENUM_FABRICA;
            case ATRIBUTO_ENUM_STATUS:
                return FabTipoAtributoObjeto.STATUS_ENUM;
            case ATRIBUTO_DESCONHECIDO:
                break;
            default:
                throw new AssertionError();
        }
        return getTipoPadrao();
    }

    public List<FabTipoAtributoObjeto> getListaAtributosDisponiveis() {
        if (!TIPOS_ATRIBUTO_POR_INSTANCIA.containsKey(this)) {
            List<FabTipoAtributoObjeto> tpAtributosDestaInstancia = new ArrayList<>();
            for (FabTipoAtributoObjeto tipo : FabTipoAtributoObjeto.values()) {
                if (FabTipoInstanciaAtributoProjeto.getTipoAtributo(tipo).equals(this)) {
                    tpAtributosDestaInstancia.add(tipo);
                }
            }
            TIPOS_ATRIBUTO_POR_INSTANCIA.put(this, tpAtributosDestaInstancia);
        }
        return TIPOS_ATRIBUTO_POR_INSTANCIA.get(this);
    }

    public Class getClasse() {
        switch (this) {

            case ATRIBUTO_SIMPLES:
                return AtributoDeEntidadeSimples.class;

            case ATRIBUTO_ENTIDADE:
                return AtributoEntidadeEntidade.class;

            case ATRIBUTO_LISTAGEM:
                return AtributoEntidadeLista.class;

            case ATRIBUTO_ENUM_FABRICA_GENERICA:
                return AtributoDeEntidadeFabrica.class;

            case ATRIBUTO_ENUM_STATUS:
                return AtributoDeEntidadeFabricaStatus.class;
            case ATRIBUTO_DESCONHECIDO:
                return null;
            case ATRIBUTO_ENTIDADE_STATUS:
                return AtributoDeEntidadeStatus.class;

            default:
                throw new AssertionError();
        }
    }

    public static FabTipoInstanciaAtributoProjeto getTipoAtributo(FabTipoAtributoObjeto pTipo) {
        switch (pTipo) {

            case NOME:
            case NOME_LONGO:
            case IMG_PEQUENA:
            case IMG_MEDIA:
            case IMG_GRANDE:
            case DESCRITIVO:
            case ID:
            case QUANTIDADE:
            case HTML:
            case HTML_TEMPLATE:
            case CHART_VALOR:
            case CHART_LABEL:
            case CHART_CATEGORIA:
            case DATAHORA:
            case DATA:
            case HORA:
            case TELEFONE_FIXO_NACIONAL:
            case TELEFONE_FIXO_INTERNACIONAL:
            case TELEFONE_CELULAR:
            case TELEFONE_GENERICO:
            case MOEDA_REAL:
            case MOEDA_DOLAR:
            case PERCENTUAL:
            case LATITUDE:
            case LCCEP:
            case SENHA:
            case LONGITUDE:

            case LC_COMPLEMENTO_E_NUMERO:
            case LC_COMPLEMENTO:
            case LC_LOGRADOURO:
            case TEXTO_SIMPLES:
            case VERDADEIRO_FALSO:
            case COR:
            case EMAIL:
            case SITE:
            case URL:
            case NOME_COMPLETO:
            case CNPJ:
            case CPF:
            case INSCRICAO_ESTADUAL:
            case INSCRIACAO_MUNICIPAL:
            case REG_DATAALTERACAO:
            case REG_DATAINSERCAO:
            case CODIGO_DE_BARRAS:
            case ICONE:
            case ARQUIVO_DE_ENTIDADE:
            case SENHA_SEGURANCA_MAXIMA:
            case REG_ATIVO_INATIVO:
                return FabTipoInstanciaAtributoProjeto.ATRIBUTO_SIMPLES;
            case ENUM_FABRICA:
                return FabTipoInstanciaAtributoProjeto.ATRIBUTO_ENUM_FABRICA_GENERICA;
            case LISTA_OBJETOS_PUBLICOS:
            case LISTA_OBJETOS_PARTICULARES:
                return FabTipoInstanciaAtributoProjeto.ATRIBUTO_LISTAGEM;

            case STATUS_ENUM:
                return FabTipoInstanciaAtributoProjeto.ATRIBUTO_ENUM_STATUS;
            case LC_BAIRRO:
            case LC_CIDADE:
            case LC_LOCALIDADE:
            case LC_UNIDADE_FEDERATIVA:
            case LC_LOCALIZACAO:
            case OBJETO_DE_UMA_LISTA:
            case REG_USUARIO_ALTERACAO:
            case REG_USUARIO_INSERCAO:

                return FabTipoInstanciaAtributoProjeto.ATRIBUTO_ENTIDADE;

            case FORMULARIO_DE_ACAO:
            case TIPO_PADRAO_POR_DECLARACAO:
            case CAMPO_SEPARADOR:
            case GRUPO_CAMPO:
            case GRUPOS_DE_CAMPO:
            case LC_CAMPO_ABERTO:
            case CALENDARIO:
            case RESPONSAVEL:

            case SEGURANCA_ATIVA:

                return FabTipoInstanciaAtributoProjeto.ATRIBUTO_DESCONHECIDO;
            default:
                throw new AssertionError();
        }
    }

}
