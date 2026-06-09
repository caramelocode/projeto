/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.acoes.projetoCarameloBuilder;

import com.super_bits.modulosSB.SBCore.UtilGeral.MapaAcoesSistema;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCStringValidador;

/**
 *
 * @author salvio
 */
public enum CRC_CONSOLE_TIPO_COMANDO {
    ACAO,
    ENTIDADE,
    INTEDERMINADO,
    REQUISITO,
    MODULO;

    public static CRC_CONSOLE_TIPO_COMANDO getTipoComando(String pesquisa) {
        if (pesquisa == null || pesquisa.length() < 3) {
            return INTEDERMINADO;
        }

        if (pesquisa.startsWith("Fab")) {
            return ACAO;
        }
        if (UtilCRCStringValidador.isPrimeiraLetraMaiusculaSegundaMinuscula(pesquisa)) {
            return ENTIDADE;
        }
        return INTEDERMINADO;

    }

    public CRC_CONSOLE_TIPO_ACESSO getTipoAcesso(String pComando) {
        switch (this) {

            case ACAO:
                if (MapaAcoesSistema.getAcaoDoSistemaByNomeUnico(pComando) == null) {
                    return CRC_CONSOLE_TIPO_ACESSO.EDITAR;
                } else {
                    return CRC_CONSOLE_TIPO_ACESSO.INDETERMINADO;
                }

            case ENTIDADE:

                break;
            case INTEDERMINADO:
                break;
            case REQUISITO:
                break;
            case MODULO:
                break;
            default:

                return CRC_CONSOLE_TIPO_ACESSO.INDETERMINADO;
        }
        return CRC_CONSOLE_TIPO_ACESSO.INDETERMINADO;
    }
}
