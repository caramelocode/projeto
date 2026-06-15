/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.menu;

import br.org.carameloCode.erp.modulo.notificacao.api.FabAcaoNotificacaoPadraoSB;
import br.org.carameloCode.erp.modulo.projeto.acoes.componente.formulario.FabAcaoProjetoCRCCarameloFormulario;
import br.org.carameloCode.erp.modulo.projeto.acoes.componente.nativo.FabAcaoProjetoCRCComponenteNativo;
import br.org.carameloCode.erp.modulo.projeto.acoes.componente.notificacoes.FabAcaoProjetoCRCNotificacoes;
import com.super_bits.modulos.SBAcessosModel.controller.FabMenuAdmin;
import com.super_bits.modulos.SBAcessosModel.fabricas.FabAcaoProjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.view.menu.ComoFabricaMenu;
import com.super_bits.modulosSB.SBCore.modulos.view.menu.ComoMenuSB;
import org.coletivojava.fw.api.objetoNativo.view.menu.MenuSBFW;

/**
 *
 * @author salvio
 */
public enum FabMenuProjetoCaramelo implements ComoFabricaMenu {

    CARAMELO_DEV,
    CARAMELO_DEV_ADMIN,
    FABRICA_DE_SOFTWARE_ADMIN,
    PLATAFORMA_ADMIN,
    CLIENTE;

    @Override
    public ComoMenuSB getMenuPrincipal() {
        MenuSBFW menuPrincipal = FabMenuAdmin.ROOT.getMenuPrincipal();
        menuPrincipal.addSessao(FabAcaoProjetoSB.PROJETO_MB_GERENCIAR).addAcao(FabAcaoProjetoSB.PROJETO_FRM_VISAO_GERAL);
        //    menuPrincipal.addSessao(FabAcaoProjetoCRCAcoes.ACOES_MB_GESTAO).addAcao(FabAcaoProjetoCRCAcoes.ACOES_MB_GESTAO);
        //    menuPrincipal.addSessao(FabAcaoProjetoCRCEntidade.).addAcao(FabAcaoProjetoCRCAcoes.ACOES_MB_GESTAO);

        switch (this) {

            case CARAMELO_DEV:
                return menuPrincipal;

            case CARAMELO_DEV_ADMIN:
                break;
            case FABRICA_DE_SOFTWARE_ADMIN:
                break;
            case PLATAFORMA_ADMIN:
                break;
            case CLIENTE:
                break;
            default:
                throw new AssertionError();
        }
        return menuPrincipal;
    }

    @Override
    public ComoMenuSB getMenuSecundario() {
        MenuSBFW menusec = FabMenuAdmin.ROOT.getMenuSecundario();
        menusec.addSessao(FabAcaoProjetoCRCComponenteNativo.COMPONENTE_NATIVO_MB_GESTAO).addAcao(FabAcaoProjetoCRCComponenteNativo.COMPONENTE_NATIVO_FRM_LISTAR);
        menusec.addSessao(FabAcaoProjetoSB.PROJETO_MB_GERENCIAR).addAcao(FabAcaoProjetoSB.PROJETO_FRM_VISAO_GERAL);
        menusec.addSessao(FabAcaoProjetoCRCNotificacoes.NOTIFICACAO_TRANSITORIA_MB_GESTAO)
                .addAcao(FabAcaoProjetoCRCNotificacoes.NOTIFICACAO_TRANSITORIA_FRM_ENVIAR_MENU_USR_TO_USR)
                .addAcao(FabAcaoProjetoCRCNotificacoes.NOTIFICACAO_TRANSITORIA_FRM_ENVIAR_MENU_SISTEMA_USR);
        menusec.addSessao(FabAcaoNotificacaoPadraoSB.NOTIFICACAO_MB_GESTAO)
                .addAcao(FabAcaoNotificacaoPadraoSB.TIPO_NOTIFICACAO_MB_GESTAO)
                .addAcao(FabAcaoNotificacaoPadraoSB.NOTIFICACAO_FRM_NOVO)
                .addAcao(FabAcaoNotificacaoPadraoSB.NOTIFICACAO_FRM_LISTAR)
                .setNome("Notificações Registradas");
        menusec.addSessao(FabAcaoProjetoCRCCarameloFormulario.CRUD_EXEMPLO_MB_GESTAO)
                .addAcao(FabAcaoProjetoCRCCarameloFormulario.CRUD_EXEMPLO_MB_GESTAO)
                .addAcao(FabAcaoProjetoCRCCarameloFormulario.FORMMULARIO_PERSONALIZADO_MB_GESTAO).setNome("Modelos de Páginas");
        ;

        //    menuPrincipal.addSessao(FabAcaoProjetoCRCAcoes.ACOES_MB_GESTAO).addAcao(FabAcaoProjetoCRCAcoes.ACOES_MB_GESTAO);
        //    menuPrincipal.addSessao(FabAcaoProjetoCRCEntidade.).addAcao(FabAcaoProjetoCRCAcoes.ACOES_MB_GESTAO);
        switch (this) {

            case CARAMELO_DEV:
                return menusec;

            case CARAMELO_DEV_ADMIN:
                return menusec;

            case FABRICA_DE_SOFTWARE_ADMIN:
                return menusec;

            case PLATAFORMA_ADMIN:
                return menusec;

            case CLIENTE:
                return new MenuSBFW();

            default:
                throw new AssertionError();
        }

    }

}
