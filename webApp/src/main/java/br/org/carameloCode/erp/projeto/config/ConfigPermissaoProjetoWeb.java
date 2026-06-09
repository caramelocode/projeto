/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.carameloCode.erp.projeto.config;

import br.org.carameloCode.erp.modulo.projeto.acoes.componente.nativo.FabAcaoProjetoCRCComponenteNativo;
import br.org.carameloCode.erp.modulo.projeto.acoes.componente.notificacoes.FabAcaoProjetoCRCNotificacoes;
import br.org.carameloCode.erp.modulo.projeto.implemetation.componenteNativo.ExecAcoesComponenteNativo;
import com.super_bits.modulos.SBAcessosModel.controller.FabMenuAdmin;
import com.super_bits.modulos.SBAcessosModel.fabricas.FabAcaoProjetoSB;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.ItensGenericos.basico.UsuarioSistemaRoot;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoGrupoUsuario;
import com.super_bits.modulosSB.SBCore.modulos.view.menu.ComoMenusDeSessao;
import config.ConfigPermissoesAcessosModel;
import org.coletivojava.fw.api.objetoNativo.view.menu.MenuSBFW;
import org.coletivojava.fw.api.objetoNativo.view.menu.MenusDaSessao;

/**
 *
 * @author sfurbino
 */
public class ConfigPermissaoProjetoWeb extends ConfigPermissoesAcessosModel {

    public ConfigPermissaoProjetoWeb() {
        super(new Class[]{ExecAcoesComponenteNativo.class});

    }

    @Override
    public ComoMenusDeSessao definirMenu(ComoGrupoUsuario pGrupo) {
        if (CarameloCode.getUsuarioLogado() instanceof UsuarioSistemaRoot) {
            MenuSBFW menuPrincipal = FabMenuAdmin.ROOT.getMenuPrincipal();
            menuPrincipal.addSessao(FabAcaoProjetoSB.PROJETO_MB_GERENCIAR).addAcao(FabAcaoProjetoSB.PROJETO_FRM_VISAO_GERAL);
            //    menuPrincipal.addSessao(FabAcaoProjetoCRCAcoes.ACOES_MB_GESTAO).addAcao(FabAcaoProjetoCRCAcoes.ACOES_MB_GESTAO);
            //    menuPrincipal.addSessao(FabAcaoProjetoCRCEntidade.).addAcao(FabAcaoProjetoCRCAcoes.ACOES_MB_GESTAO);
            MenuSBFW menusec = FabMenuAdmin.ROOT.getMenuSecundario();
            menusec.addSessao(FabAcaoProjetoCRCComponenteNativo.COMPONENTE_NATIVO_MB_GESTAO).addAcao(FabAcaoProjetoCRCComponenteNativo.COMPONENTE_NATIVO_FRM_LISTAR);
            menusec.addSessao(FabAcaoProjetoSB.PROJETO_MB_GERENCIAR).addAcao(FabAcaoProjetoSB.PROJETO_FRM_VISAO_GERAL);
            menusec.addSessao(FabAcaoProjetoCRCNotificacoes.NOTIFICACAO_TRANSITORIA_MB_GESTAO)
                    .addAcao(FabAcaoProjetoCRCNotificacoes.NOTIFICACAO_TRANSITORIA_FRM_ENVIAR_MENU_USR_TO_USR)
                    .addAcao(FabAcaoProjetoCRCNotificacoes.NOTIFICACAO_TRANSITORIA_FRM_ENVIAR_MENU_SISTEMA_USR);

            return new MenusDaSessao(menuPrincipal, menusec);

        }
        return super.definirMenu(pGrupo); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
