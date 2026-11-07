/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.regraDeNegocio.Entidadeobjeto;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.entidade.FabAcaoCarameloDevComoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.entidade.InfoAcaoEntidadeObjetoCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import com.super_bits.modulos.SBAcessosModel.controller.resposta.RespostaComGestaoEMRegraDeNegocioPadrao;
import com.super_bits.modulosSB.Persistencia.dao.ControllerAbstratoSBPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfRespostaAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.TratamentoDeErros.ErroRegraDeNegocio;

/**
 *
 * @author salvio
 */
public class ExecAcoesObjetosEntidadeCRC extends ControllerAbstratoSBPersistencia {

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevComoItemProjeto.ENTIDADE_CTR_SALVAR)
    public static ItfRespostaAcaoDoSistema salvarObjetoEntidade(ObjetoProjCRC pItemDeProjeto) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pItemDeProjeto), pItemDeProjeto) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                setRetorno(atualizarEntidade(pItemDeProjeto));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevComoItemProjeto.ATRIBUTO_ENTIDADE_CTR_SALVAR)
    public static ItfRespostaAcaoDoSistema salvarAtributoEntidade(AtributoDeEntidadeSimples pAtributo) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pAtributo), pAtributo) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                if (pAtributo.getEntidade() == null) {
                    throw new ErroRegraDeNegocio("O atributo precisa estar vinculado a uma entidade");
                }
                setRetorno(atualizarEntidade(pAtributo));
            }
        }.getResposta();

    }

}
