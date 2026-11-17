package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.UtilProjCRCItemProjetoTexto;

/**
 * Interpretação do texto digitado no console para fábricas:
 *
 * <ul>
 * <li>FabStatusPedido → fábrica de status;</li>
 * <li>FabStatusPedido.emAndamento → item (status) da fábrica;</li>
 * <li>FabTipoPagamento → fábrica genérica;</li>
 * <li>FabTipoPagamento.cartao → item da fábrica genérica.</li>
 * </ul>
 *
 * O prefixo precisa ser seguido de letra maiúscula (ou do fim do texto, no
 * caso de FabStatus), para que entidades como Fabrica não mudem de tipo.
 *
 * @author salvio
 */
public final class UtilProjCRCNomeFabrica {

    public static final String PREFIXO_FABRICA_STATUS = "FabStatus";
    public static final String PREFIXO_FABRICA = "Fab";
    public static final String SEPARADOR_ITEM = ".";

    private UtilProjCRCNomeFabrica() {
    }

    /**
     * FabStatus, FabStatusPedido, FabStatusPedido.ativo.
     */
    public static boolean isTextoFabricaStatus(String pTexto) {
        if (pTexto == null || !pTexto.startsWith(PREFIXO_FABRICA_STATUS)) {
            return false;
        }
        if (pTexto.length() == PREFIXO_FABRICA_STATUS.length()) {
            return true;
        }
        char proximo = pTexto.charAt(PREFIXO_FABRICA_STATUS.length());
        return Character.isUpperCase(proximo) || SEPARADOR_ITEM.charAt(0) == proximo;
    }

    /**
     * Fab seguido de letra maiúscula (FabTipoPagamento). Não considera
     * FabAcao, que é verificado antes pelo console.
     */
    public static boolean isTextoFabrica(String pTexto) {
        return pTexto != null
                && pTexto.length() > PREFIXO_FABRICA.length()
                && pTexto.startsWith(PREFIXO_FABRICA)
                && Character.isUpperCase(pTexto.charAt(PREFIXO_FABRICA.length()));
    }

    /**
     * FabStatusPedido.ativo → FabStatusPedido.
     */
    public static String getNomeFabrica(String pTexto) {
        return UtilProjCRCItemProjetoTexto.getPrimeiraParte(pTexto);
    }

    public static boolean isPossuiItem(String pTexto) {
        return pTexto != null && pTexto.contains(SEPARADOR_ITEM);
    }

    /**
     * FabStatusPedido.ativo → ativo; sem ponto ou sem nome → vazio.
     */
    public static String getNomeItem(String pTexto) {
        String nomeItem = UtilProjCRCItemProjetoTexto.getSegundaParte(pTexto);
        return nomeItem == null ? "" : nomeItem;
    }

    /**
     * O nome tem algo além do prefixo (FabStatusPedido, e não só FabStatus).
     */
    public static boolean isNomeFabricaCompleto(String pNomeFabrica, boolean pFabricaStatus) {
        String prefixo = pFabricaStatus ? PREFIXO_FABRICA_STATUS : PREFIXO_FABRICA;
        return pNomeFabrica != null && pNomeFabrica.length() > prefixo.length() && pNomeFabrica.startsWith(prefixo);
    }

    /**
     * Texto do item no console: FabStatusPedido.EM_ANDAMENTO.
     */
    public static String getTextoItem(String pNomeFabrica, String pNomeEnum) {
        return pNomeFabrica + SEPARADOR_ITEM + pNomeEnum;
    }

}
