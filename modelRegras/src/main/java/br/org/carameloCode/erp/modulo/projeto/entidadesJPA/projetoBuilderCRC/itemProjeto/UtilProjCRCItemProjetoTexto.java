/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto;

/**
 *
 * @author salvio
 */
public class UtilProjCRCItemProjetoTexto {

    public static String getTextoNormatizado(String pTexto) {
        //Retira espaços, e deixa a primeira letra mauiscula
        String semEspacos = pTexto.replaceAll("\\s+", "");
        if (semEspacos.isEmpty()) {
            return semEspacos;
        }
        String texto = Character.toUpperCase(semEspacos.charAt(0)) + semEspacos.substring(1);
        if (texto.endsWith(ABRE_COLCHETE_LISTA)) {
            // Entidade.atributo[ → Entidade.atributo[]
            texto = texto + FECHA_COLCHETE_LISTA;
        }
        return texto;
    }

    /**
     * Sufixo do atributo do tipo objeto: Entidade.atributo.
     */
    public static final String SUFIXO_ATRIBUTO_OBJETO = ".";
    public static final String ABRE_COLCHETE_LISTA = "[";
    public static final String FECHA_COLCHETE_LISTA = "]";
    /**
     * Sufixo do atributo do tipo lista: Entidade.atributo[]
     */
    public static final String SUFIXO_ATRIBUTO_LISTA = ABRE_COLCHETE_LISTA + FECHA_COLCHETE_LISTA;

    /**
     * @param pNomeAtributo segunda parte do texto (depois do ponto separador)
     * @return true se o nome termina com ponto: atributo do tipo objeto
     */
    public static boolean isAtributoTipoObjeto(String pNomeAtributo) {
        return pNomeAtributo != null && pNomeAtributo.length() > SUFIXO_ATRIBUTO_OBJETO.length()
                && pNomeAtributo.endsWith(SUFIXO_ATRIBUTO_OBJETO);
    }

    /**
     * @param pNomeAtributo segunda parte do texto (depois do ponto separador)
     * @return true se o nome termina com []: atributo do tipo lista
     */
    public static boolean isAtributoTipoLista(String pNomeAtributo) {
        return pNomeAtributo != null && pNomeAtributo.length() > SUFIXO_ATRIBUTO_LISTA.length()
                && pNomeAtributo.endsWith(SUFIXO_ATRIBUTO_LISTA);
    }

    /**
     * Nome do atributo sem o caractere especial que define o tipo (. ou []).
     */
    public static String getNomeAtributoSemSufixo(String pNomeAtributo) {
        if (pNomeAtributo == null) {
            return null;
        }
        if (isAtributoTipoLista(pNomeAtributo)) {
            return pNomeAtributo.substring(0, pNomeAtributo.length() - SUFIXO_ATRIBUTO_LISTA.length());
        }
        if (isAtributoTipoObjeto(pNomeAtributo)) {
            return pNomeAtributo.substring(0, pNomeAtributo.length() - SUFIXO_ATRIBUTO_OBJETO.length());
        }
        return pNomeAtributo;
    }

    public static String getPrimeiraParte(String texto) {
        if (texto == null) {
            return null;
        }
        int ponto = texto.indexOf('.');
        return ponto >= 0 ? texto.substring(0, ponto) : texto;
    }

    public static String getSegundaParte(String texto) {
        if (texto == null) {
            return null;
        }
        int ponto = texto.indexOf('.');
        return ponto >= 0 ? texto.substring(ponto + 1) : null;
    }
}
