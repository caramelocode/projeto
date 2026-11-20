/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.regraDeNegocio.fabrica;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.objeto.FabAcaoCarameloDevEdicaoItemProj;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.objeto.InfoAcaoEntidadeObjetoCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaEntidadeProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaStatusProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.ItemFabrica;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.ItemFabricaStatus;
import com.super_bits.modulos.SBAcessosModel.controller.resposta.RespostaComGestaoEMRegraDeNegocioPadrao;
import com.super_bits.modulosSB.Persistencia.dao.ControllerAbstratoSBPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfRespostaAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.TratamentoDeErros.ErroRegraDeNegocio;

/**
 * Regras de negócio das fábricas do projeto (genérica e de status) e dos seus
 * itens. As ações _CTR_SALVAR_MERGE servem tanto para criar quanto para salvar
 * alterações.
 *
 * @author salvio
 */
public class ExecAcoesFabricasCRC extends ControllerAbstratoSBPersistencia {

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.FABRICA_GENERICA_CTR_SALVAR_MERGE)
    public static ItfRespostaAcaoDoSistema salvarFabrica(FabricaEntidadeProjCRC pFabrica) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pFabrica), pFabrica) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                validarFabrica(pFabrica);
                setRetorno(atualizarEntidade(pFabrica));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.FABRICA_STATUS_CTR_SALVAR_MERGE)
    public static ItfRespostaAcaoDoSistema salvarFabricaStatus(FabricaStatusProjCRC pFabrica) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pFabrica), pFabrica) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                validarFabrica(pFabrica);
                setRetorno(atualizarEntidade(pFabrica));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ITEM_FABRICA_GENERICA_CTR_SALVAR_MERGE)
    public static ItfRespostaAcaoDoSistema salvarItemFabrica(ItemFabrica pItem) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pItem), pItem) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                validarItem(pItem);
                setRetorno(atualizarEntidade(pItem));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ITEM_FABRICA_STATUS_CTR_SALVAR_MERGE)
    public static ItfRespostaAcaoDoSistema salvarItemFabricaStatus(ItemFabricaStatus pItem) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pItem), pItem) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                validarItem(pItem);
                if (!(pItem.getFabrica() instanceof FabricaStatusProjCRC)) {
                    throw new ErroRegraDeNegocio("O status " + pItem.getNomeEnum() + " precisa estar vinculado a uma fábrica de status");
                }
                setRetorno(atualizarEntidade(pItem));
            }
        }.getResposta();

    }

    private static void validarFabrica(FabricaEntidadeProjCRC pFabrica) throws ErroRegraDeNegocio {
        if (pFabrica.getProjeto() == null) {
            throw new ErroRegraDeNegocio("A fábrica precisa estar vinculada a um projeto");
        }
        if (pFabrica.getNomeFabrica() == null || pFabrica.getNomeFabrica().trim().isEmpty()) {
            throw new ErroRegraDeNegocio("Informe o nome da fábrica");
        }
    }

    private static void validarItem(ItemFabrica pItem) throws ErroRegraDeNegocio {
        if (pItem.getFabrica() == null) {
            throw new ErroRegraDeNegocio("O item precisa estar vinculado a uma fábrica");
        }
        if (pItem.getNomeEnum() == null || pItem.getNomeEnum().trim().isEmpty()) {
            throw new ErroRegraDeNegocio("Informe o nome do item da fábrica " + pItem.getFabrica().getNomeFabrica());
        }
        if (pItem.getIdObjeto() == null) {
            throw new ErroRegraDeNegocio("Informe o id do objeto do item " + pItem.getNomeEnum());
        }
    }

}
