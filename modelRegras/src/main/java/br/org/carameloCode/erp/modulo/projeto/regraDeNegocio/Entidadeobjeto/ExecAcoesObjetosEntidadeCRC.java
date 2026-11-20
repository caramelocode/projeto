/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.regraDeNegocio.Entidadeobjeto;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.objeto.FabAcaoCarameloDevEdicaoItemProj;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.objeto.InfoAcaoEntidadeObjetoCRCProjeto;
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

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ENTIDADE_CTR_SALVAR_NOVO)
    public static ItfRespostaAcaoDoSistema salvarObjetoEntidade(ObjetoProjCRC pItemDeProjeto) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pItemDeProjeto), pItemDeProjeto) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                setRetorno(atualizarEntidade(pItemDeProjeto));
            }
        }.getResposta();

    }

}
