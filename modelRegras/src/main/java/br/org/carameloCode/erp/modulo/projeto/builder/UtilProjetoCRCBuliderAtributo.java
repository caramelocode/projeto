/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.builder;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeEntidade;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeLista;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.modulos.dinamico.DadoDinamico;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.modulos.dinamico.TipoDadoDinamico;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;

/**
 *
 * @author salvio
 */
public class UtilProjetoCRCBuliderAtributo {

    private static void aplicarDadosSimples(TipoDadoDinamico pTipo, AtributoDeEntidadeSimples pAtributo) {
        pTipo.setFabricaTipoAtributo(pAtributo.getTipo());
        pTipo.setLabel(pAtributo.getLabel());
        pTipo.setValorMaximo(pAtributo.getValorMaximo());
        pTipo.setValorMinimo(pAtributo.getValorMinimo());
    }

    private static void aplicarDadosEntidade(TipoDadoDinamico pTipo, AtributoDeEntidadeSimples pAtributo) {
        pTipo.setFabricaTipoAtributo(pAtributo.getTipo());
        pTipo.setLabel(pAtributo.getLabel());

    }

    private static void aplicarDadosAtributoEntidadeDeUmaListaPublica(TipoDadoDinamico pTipo, AtributoEntidadeLista pAtributo) {
        pTipo.setFabricaTipoAtributo(FabTipoAtributoObjeto.LISTA_OBJETOS_PARTICULARES);
    }

    private static void aplicarDadosAtributoEntidadeDeUmaListaParticular(TipoDadoDinamico pTipo, AtributoEntidadeLista pAtributo) {
        pTipo.setFabricaTipoAtributo(FabTipoAtributoObjeto.LISTA_OBJETOS_PARTICULARES);
    }

    public static TipoDadoDinamico gerarTipoDAdoAtributo(AtributoDeEntidadeSimples pAtributo) {
        TipoDadoDinamico tipo = new TipoDadoDinamico();
        aplicarDadosSimples(tipo, pAtributo);
        if (tipo.isUmValorMultiploComLista()) {

            if (FabTipoAtributoObjeto.LISTA_OBJETOS_PARTICULARES.equals(pAtributo.getTipo())) {
                aplicarDadosAtributoEntidadeDeUmaListaPublica(tipo, (AtributoEntidadeLista) pAtributo);
            }

            if (FabTipoAtributoObjeto.LISTA_OBJETOS_PUBLICOS.equals(pAtributo.getTipo())) {
                aplicarDadosAtributoEntidadeDeUmaListaParticular(tipo, (AtributoEntidadeLista) pAtributo);
            }

        } else {
            switch (tipo.getTipoPrimitivoDoValor()) {

                case INTEIRO:
                    break;
                case NUMERO_LONGO:
                    break;
                case LETRAS:
                    break;
                case DATAS:
                    break;
                case BOOLEAN:
                    break;
                case DECIMAL:
                    break;
                case ENTIDADE:
                    aplicarDadosEntidade(tipo, pAtributo);
                    break;
                case OUTROS_OBJETOS:
                    break;
                default:
                    throw new AssertionError();
            }

            return tipo;
        }
        return tipo;
    }

    public static DadoDinamico gerarDadoDinamico(AtributoDeEntidadeSimples pAtributo) {
        DadoDinamico dado = new DadoDinamico();
        dado.setTipoDadoDinamico(gerarTipoDAdoAtributo(pAtributo));
        return dado;
    }

}
