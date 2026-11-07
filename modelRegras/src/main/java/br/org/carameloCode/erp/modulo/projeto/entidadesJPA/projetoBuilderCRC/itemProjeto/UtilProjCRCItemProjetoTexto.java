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
        return Character.toUpperCase(semEspacos.charAt(0)) + semEspacos.substring(1);
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
