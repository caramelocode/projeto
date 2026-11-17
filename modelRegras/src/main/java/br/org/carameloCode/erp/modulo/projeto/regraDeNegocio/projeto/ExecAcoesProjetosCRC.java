/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.regraDeNegocio.projeto;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.acao.FabAcaoCarameloDevAcaoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.acao.InfoAcaoCarameloDevAcaoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.console.FabAcaoCarameloDevConsoleCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.console.InfoAcaoProjetoCRCConsole;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.projeto.FabAcaoCarameloDevProjetoCRC;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.projeto.InfoAcaoProjetoCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.ComoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import br.org.carameloCode.erp.modulo.projeto.regraDeNegocio.Entidadeobjeto.ExecAcoesObjetosEntidadeCRC;
import br.org.carameloCode.erp.modulo.projeto.regraDeNegocio.fabrica.ExecAcoesFabricasCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaEntidadeProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaStatusProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.ItemFabrica;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.ItemFabricaStatus;
import com.super_bits.modulos.SBAcessosModel.controller.resposta.RespostaComGestaoEMRegraDeNegocioPadrao;
import com.super_bits.modulosSB.Persistencia.dao.ControllerAbstratoSBPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfRespostaAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.TratamentoDeErros.ErroRegraDeNegocio;

/**
 *
 * @author salvio
 */
public class ExecAcoesProjetosCRC extends ControllerAbstratoSBPersistencia {

    @InfoAcaoProjetoCRCConsole(acao = FabAcaoCarameloDevConsoleCRCProjeto.CONSOLE_ITEM_PROJ_CTR_SALVAR)
    public static ItfRespostaAcaoDoSistema salvarItem(ComoItemProjeto pItemDeProjeto) {

        if (pItemDeProjeto instanceof ObjetoProjCRC) {
            return ExecAcoesObjetosEntidadeCRC.salvarObjetoEntidade((ObjetoProjCRC) pItemDeProjeto);
        }
        if (pItemDeProjeto instanceof AcaoProjCRC) {
            return salvarAcao((AcaoProjCRC) pItemDeProjeto);
        }
        // subclasses antes das classes base
        if (pItemDeProjeto instanceof FabricaStatusProjCRC) {
            return ExecAcoesFabricasCRC.salvarFabricaStatus((FabricaStatusProjCRC) pItemDeProjeto);
        }
        if (pItemDeProjeto instanceof FabricaEntidadeProjCRC) {
            return ExecAcoesFabricasCRC.salvarFabrica((FabricaEntidadeProjCRC) pItemDeProjeto);
        }
        if (pItemDeProjeto instanceof ItemFabricaStatus) {
            return ExecAcoesFabricasCRC.salvarItemFabricaStatus((ItemFabricaStatus) pItemDeProjeto);
        }
        if (pItemDeProjeto instanceof ItemFabrica) {
            return ExecAcoesFabricasCRC.salvarItemFabrica((ItemFabrica) pItemDeProjeto);
        }
        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pItemDeProjeto), null) {

            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                throw new ErroRegraDeNegocio("Não implementado");
            }
        }.getResposta();

    }

    /**
     * Salva uma ação do projeto criada pelo console (gestão, formulário ou
     * controller). O módulo novo é salvo em cascata junto com a ação.
     */
    @InfoAcaoCarameloDevAcaoProjCRC(acao = FabAcaoCarameloDevAcaoProjCRC.ACOES_CTR_SALVAR)
    public static ItfRespostaAcaoDoSistema salvarAcao(AcaoProjCRC pAcao) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pAcao), pAcao) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                if (pAcao.getProjeto() == null) {
                    throw new ErroRegraDeNegocio("A ação precisa estar vinculada a um projeto");
                }
                if (pAcao.getNomeUnico() == null || pAcao.getNomeUnico().isEmpty()) {
                    throw new ErroRegraDeNegocio("Informe o nome único da ação no formato FabAcao[Modulo].[ENTIDADE]_[MB|FRM|CTR]_[DESCRICAO]");
                }
                if (pAcao.getModulo() == null) {
                    throw new ErroRegraDeNegocio("A ação " + pAcao.getNomeUnico() + " precisa estar vinculada a um módulo");
                }
                setRetorno(atualizarEntidade(pAcao));
            }
        }.getResposta();

    }

    @InfoAcaoProjetoCRCProjeto(acao = FabAcaoCarameloDevProjetoCRC.PROJETO_CTR_SALVAR_MERGE)
    public static ItfRespostaAcaoDoSistema salvarProjeto(ProjetoCRC pItemDeProjeto) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pItemDeProjeto), null) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                setRetorno(atualizarEntidade(pItemDeProjeto));
            }
        }.getResposta();

    }

}
