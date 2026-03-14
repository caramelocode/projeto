/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.carameloCode.erp.modulo.projeto.config;

import com.super_bits.modulos.SBAcessosModel.ConfigPermissoesAcessoModelAbstrato;
import com.super_bits.modulos.SBAcessosModel.fabricas.acoesDemonstracao.FabAcaoDemonstracaoSB;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.MapaAcoesSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.ErroDadosDeContatoUsuarioNaoEncontrado;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.token.ItfTokenAcessoDinamico;
import com.super_bits.modulosSB.SBCore.modulos.erp.FabTipoAgenteOrganizacao;
import com.super_bits.modulosSB.SBCore.modulos.fabrica.ComoFabricaAcoes;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoEntidadeSimplesSomenteLeitura;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoGrupoUsuario;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.contato.ComoContatoHumano;
import com.super_bits.modulosSB.SBCore.modulos.view.menu.ComoFabricaMenu;
import com.super_bits.modulosSB.SBCore.modulos.view.menu.ComoMenusDeSessao;
import org.coletivojava.fw.api.objetoNativo.view.menu.MenusDaSessao;
import org.coletivojava.fw.api.tratamentoErros.FabErro;

/**
 *
 * @author sfurbino
 */
public class ConfigPermissaoCRMCarameloCodePadrao extends ConfigPermissoesAcessoModelAbstrato {

    public ConfigPermissaoCRMCarameloCodePadrao() {
        super(new Class[]{});
    }

    @Override
    protected boolean persistirPermissoesNoBanco() {
        super.persistirPermissoesNoBanco(); //To change body of generated methods, choose Tools | Templates.

        try {

            MapaAcoesSistema.getListaTodasAcoes().stream().filter(ac -> ac.isPrecisaPermissao()).forEach(acP -> {

                //       if (acP.getAcaoDeGestaoEntidade().getModulo().equals(FabModulosCRM.CONVIDADO.getRegistro())) {
                //       UtilSBControllerAcessosModel.adicionarPermissao(FabGruposIntranetCasaNova.CRM_CONVIDADO.getRegistro(), acP);
                //     }
            });

            //  MapaObjetosProjetoAtual.adcionarObjeto(MetadadoAtendente.class);
            return true;
        } catch (Throwable t) {
            SBCore.RelatarErro(FabErro.SOLICITAR_REPARO, "Erro configurando permissões", t);
            return false;
        }
    }

    @Override
    public ComoMenusDeSessao definirMenu(ComoGrupoUsuario pGrupo) {
        return new MenusDaSessao((ComoFabricaMenu) FabAcaoDemonstracaoSB.DEMONSTRACAO_MB_COMPONENTE.getRegistro());
    }

    @Override
    public FabTipoAgenteOrganizacao getTipoAgente(ComoUsuario pUsuario) {

        return FabTipoAgenteOrganizacao.PUBLICO;
    }

    @Override
    public ComoContatoHumano getContatoDoUsuario(ComoUsuario pUsuairo) throws ErroDadosDeContatoUsuarioNaoEncontrado {
        return (ComoContatoHumano) pUsuairo;

    }

    @Override
    public boolean isObjetoPermitidoUsuario(ComoUsuario pUsuario, ComoEntidadeSimplesSomenteLeitura pObjeto) {

        return true;
    }

    @Override
    public ItfTokenAcessoDinamico gerarTokenDinamico(ComoFabricaAcoes pAcao, ComoEntidadeSimplesSomenteLeitura pItem, String pEmail) {
        return super.gerarTokenDinamico(pAcao, pItem, pEmail);

    }

}
