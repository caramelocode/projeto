package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Interpreta o nome de uma ação digitado no console.
 *
 * Formato: FabAcao[NomeModulo][NomeEntidade
 * opcional]_o_[NOME_ENTIDADE]_[TIPO]_[DESCRICAO]
 *
 * Ex.: FabAcaoGerenteCliente_o_CLIENTE_FRM_LISTAR
 * <ul>
 * <li>fábrica: FabAcaoGerenteCliente</li>
 * <li>nome da ação: CLIENTE_FRM_LISTAR</li>
 * <li>entidade da ação: CLIENTE</li>
 * <li>sigla do tipo: FRM</li>
 * <li>descrição: LISTAR</li>
 * </ul>
 *
 * @author salvio
 */
public class UtilProjCRCNomeAcao {

    public static final String PREFIXO_FABRICA = "FabAcao";
    public static final String SEPARADOR_FABRICA_ACAO = "_o_";
    public static final String SEPARADOR_PARTES = "_";
    /**
     * Separador do nome único, como no framework: NomeDaFabrica.NOME_DA_ACAO
     */
    public static final String SEPARADOR_NOME_UNICO = ".";

    public static final String SIGLA_GESTAO = "MB";
    public static final String SIGLA_FORMULARIO = "FRM";
    public static final String SIGLA_CONTROLLER = "CTR";
    public static final List<String> SIGLAS_TIPO = Collections.unmodifiableList(Arrays.asList(
            SIGLA_GESTAO, SIGLA_FORMULARIO, SIGLA_CONTROLLER));

    /**
     * Subtipos padrão de cada tipo, seguindo a nomenclatura das ações genéricas
     * do framework (UtilFabricaDeAcoesAcessosModel.getTipoAcaoByNome)
     */
    public static final List<String> SUBTIPOS_GESTAO = Collections.unmodifiableList(Arrays.asList(
            "GESTAO"));
    public static final List<String> SUBTIPOS_FORMULARIO = Collections.unmodifiableList(Arrays.asList(
            "LISTAR", "EDITAR", "VISUALIZAR", "NOVO"));
    public static final List<String> SUBTIPOS_CONTROLLER = Collections.unmodifiableList(Arrays.asList(
            "SALVAR_MERGE", "ALTERAR_STATUS", "REMOVER"));

    private UtilProjCRCNomeAcao() {
    }

    /**
     * @param pSigla MB, FRM ou CTR
     * @return os subtipos padrão do tipo, ou lista vazia se a sigla não for
     * reconhecida
     */
    public static List<String> getSubtiposPadrao(String pSigla) {
        if (pSigla == null) {
            return Collections.emptyList();
        }
        switch (pSigla) {
            case SIGLA_GESTAO:
                return SUBTIPOS_GESTAO;
            case SIGLA_FORMULARIO:
                return SUBTIPOS_FORMULARIO;
            case SIGLA_CONTROLLER:
                return SUBTIPOS_CONTROLLER;
            default:
                return Collections.emptyList();
        }
    }

    /**
     * Marcador do tipo dentro do nome da ação, ex.: _FRM_
     */
    public static String getMarcadorTipo(String pSigla) {
        return SEPARADOR_PARTES + pSigla + SEPARADOR_PARTES;
    }

    public static boolean isTextoAcao(String pTexto) {
        return pTexto != null && pTexto.startsWith(PREFIXO_FABRICA);
    }

    public static boolean isPossuiSeparadorFabricaAcao(String pTexto) {
        return pTexto != null && pTexto.contains(SEPARADOR_FABRICA_ACAO);
    }

    /**
     * @return o nome da fábrica (tudo antes de _o_, ou o texto inteiro)
     */
    public static String getNomeFabrica(String pTexto) {
        if (pTexto == null) {
            return null;
        }
        int separador = pTexto.indexOf(SEPARADOR_FABRICA_ACAO);
        return separador >= 0 ? pTexto.substring(0, separador) : pTexto;
    }

    /**
     * @return o que vem depois do prefixo FabAcao na fábrica (ex.:
     * GerenteCliente), vazio se só o prefixo foi digitado
     */
    public static String getNomeFabricaSemPrefixo(String pTexto) {
        String fabrica = getNomeFabrica(pTexto);
        if (fabrica == null || !fabrica.startsWith(PREFIXO_FABRICA)) {
            return "";
        }
        return fabrica.substring(PREFIXO_FABRICA.length());
    }

    /**
     * @return o nome da ação (tudo depois de _o_), ou null se não houver
     * separador
     */
    public static String getNomeAcao(String pTexto) {
        if (!isPossuiSeparadorFabricaAcao(pTexto)) {
            return null;
        }
        return pTexto.substring(pTexto.indexOf(SEPARADOR_FABRICA_ACAO) + SEPARADOR_FABRICA_ACAO.length());
    }

    /**
     * Posição do primeiro marcador de tipo (_MB_, _FRM_, _CTR_) no nome da
     * ação, ou -1.
     */
    private static int getPosicaoMarcadorTipo(String pNomeAcao) {
        int posicao = -1;
        for (String sigla : SIGLAS_TIPO) {
            int encontrado = pNomeAcao.indexOf(getMarcadorTipo(sigla));
            if (encontrado >= 0 && (posicao < 0 || encontrado < posicao)) {
                posicao = encontrado;
            }
        }
        return posicao;
    }

    /**
     * @return a entidade em caixa alta (ex.: CLIENTE, PEDIDO_VENDA), ou null se
     * não houver separador
     */
    public static String getNomeEntidadeAcao(String pTexto) {
        String nomeAcao = getNomeAcao(pTexto);
        if (nomeAcao == null) {
            return null;
        }
        int posicao = getPosicaoMarcadorTipo(nomeAcao);
        return posicao >= 0 ? nomeAcao.substring(0, posicao) : nomeAcao;
    }

    /**
     * @return MB, FRM ou CTR, ou null se o tipo ainda não foi digitado
     */
    public static String getSiglaTipo(String pTexto) {
        String nomeAcao = getNomeAcao(pTexto);
        if (nomeAcao == null) {
            return null;
        }
        int posicao = getPosicaoMarcadorTipo(nomeAcao);
        if (posicao < 0) {
            return null;
        }
        String aPartirDoTipo = nomeAcao.substring(posicao + SEPARADOR_PARTES.length());
        return aPartirDoTipo.substring(0, aPartirDoTipo.indexOf(SEPARADOR_PARTES));
    }

    /**
     * @return a descrição depois do tipo (ex.: LISTAR), vazio se ainda não foi
     * digitada, ou null se não houver tipo
     */
    public static String getDescricaoAcao(String pTexto) {
        String sigla = getSiglaTipo(pTexto);
        if (sigla == null) {
            return null;
        }
        String nomeAcao = getNomeAcao(pTexto);
        String marcador = getMarcadorTipo(sigla);
        return nomeAcao.substring(nomeAcao.indexOf(marcador) + marcador.length());
    }

    public static boolean isPossuiTipo(String pTexto) {
        return getSiglaTipo(pTexto) != null;
    }

    /**
     * Uma ação só pode ser criada com tipo e descrição.
     */
    public static boolean isNomeCompleto(String pTexto) {
        String descricao = getDescricaoAcao(pTexto);
        String entidade = getNomeEntidadeAcao(pTexto);
        return descricao != null && !descricao.isEmpty()
                && entidade != null && !entidade.isEmpty()
                && !getNomeFabricaSemPrefixo(pTexto).isEmpty();
    }

    /**
     * Converte o nome da entidade para o formato usado no nome da ação.
     *
     * Ex.: Cliente → CLIENTE, PedidoVenda → PEDIDO_VENDA
     */
    public static String getNomeEntidadeCaixaAlta(String pNomeEntidade) {
        if (pNomeEntidade == null) {
            return null;
        }
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < pNomeEntidade.length(); i++) {
            char letra = pNomeEntidade.charAt(i);
            if (i > 0 && Character.isUpperCase(letra) && !Character.isUpperCase(pNomeEntidade.charAt(i - 1))) {
                resultado.append(SEPARADOR_PARTES);
            }
            resultado.append(Character.toUpperCase(letra));
        }
        return resultado.toString();
    }

    /**
     * Todos os subtipos padrão no formato SIGLA_DESCRICAO, na ordem MB, FRM,
     * CTR (ex.: MB_GESTAO, FRM_LISTAR, CTR_REMOVER).
     */
    public static List<String> getSubtiposPadraoComSigla() {
        List<String> subtipos = new ArrayList<>();
        for (String sigla : SIGLAS_TIPO) {
            for (String subtipo : getSubtiposPadrao(sigla)) {
                subtipos.add(sigla + SEPARADOR_PARTES + subtipo);
            }
        }
        return subtipos;
    }

    /**
     * @return o subtipo no formato SIGLA_DESCRICAO (ex.: FRM_LISTAR), ou null
     * se o texto não tiver tipo
     */
    public static String getSubtipoComSigla(String pTexto) {
        String sigla = getSiglaTipo(pTexto);
        if (sigla == null) {
            return null;
        }
        return sigla + SEPARADOR_PARTES + getDescricaoAcao(pTexto);
    }

    /**
     * Inverso de getNomeEntidadeCaixaAlta.
     *
     * Ex.: CLIENTE → Cliente, PEDIDO_VENDA → PedidoVenda
     */
    public static String getNomeEntidadeCamelCase(String pNomeCaixaAlta) {
        if (pNomeCaixaAlta == null) {
            return null;
        }
        StringBuilder resultado = new StringBuilder();
        for (String parte : pNomeCaixaAlta.split(SEPARADOR_PARTES)) {
            if (!parte.isEmpty()) {
                resultado.append(parte.substring(0, 1).toUpperCase()).append(parte.substring(1).toLowerCase());
            }
        }
        return resultado.toString();
    }

    /**
     * Trecho a partir do tipo (ex.: _FRM_LISTAR), usado para identificar a ação
     * genérica sem que o nome da entidade interfira nas palavras-chave.
     *
     * @return o trecho, ou null se não houver tipo
     */
    public static String getTrechoTipoEDescricao(String pTexto) {
        String sigla = getSiglaTipo(pTexto);
        if (sigla == null) {
            return null;
        }
        return getMarcadorTipo(sigla) + getDescricaoAcao(pTexto);
    }

    /**
     * Nome do módulo a partir da fábrica e da entidade da ação.
     * <ul>
     * <li>FabAcaoGerenteCliente + Cliente → Gerente</li>
     * <li>FabAcaoCliente + Cliente → Cliente</li>
     * <li>FabAcaoGerente + Cliente → Gerente</li>
     * </ul>
     */
    public static String getNomeModulo(String pTexto, String pNomeEntidade) {
        String fabricaSemPrefixo = getNomeFabricaSemPrefixo(pTexto);
        if (pNomeEntidade != null && !pNomeEntidade.isEmpty()
                && fabricaSemPrefixo.length() > pNomeEntidade.length()
                && fabricaSemPrefixo.endsWith(pNomeEntidade)) {
            return fabricaSemPrefixo.substring(0, fabricaSemPrefixo.length() - pNomeEntidade.length());
        }
        return fabricaSemPrefixo;
    }

    /**
     * Nome único da ação a partir do texto digitado:
     * FabAcaoGerente_o_CLIENTE_FRM_LISTAR → FabAcaoGerente.CLIENTE_FRM_LISTAR
     *
     * @return null se o texto não tiver o separador _o_
     *
     */
    public static String getNomeUnico(String pTexto) {
        String nomeAcao = getNomeAcao(pTexto);
        if (nomeAcao == null) {
            return null;
        }
        return getNomeFabrica(pTexto) + SEPARADOR_NOME_UNICO + nomeAcao;
    }

    /**
     * Texto do console a partir do nome único (inverso de getNomeUnico):
     * FabAcaoGerente.CLIENTE_FRM_LISTAR → FabAcaoGerente_o_CLIENTE_FRM_LISTAR
     */
    public static String getTextoConsole(String pNomeUnico) {
        if (pNomeUnico == null || !pNomeUnico.contains(SEPARADOR_NOME_UNICO)) {
            return pNomeUnico;
        }
        int separador = pNomeUnico.indexOf(SEPARADOR_NOME_UNICO);
        return getTextoFabricaAcao(pNomeUnico.substring(0, separador), pNomeUnico.substring(separador + SEPARADOR_NOME_UNICO.length()));
    }

    /**
     * Monta o texto completo: fábrica + _o_ + nome da ação
     */
    public static String getTextoFabricaAcao(String pFabrica, String pNomeAcao) {
        return pFabrica + SEPARADOR_FABRICA_ACAO + pNomeAcao;
    }

}
