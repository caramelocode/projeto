/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto;

import br.org.carameloCode.erp.modulo.notificacao.api.FabAcaoNotificacaoPadraoSB;
import br.org.carameloCode.erp.modulo.projeto.acoes.demonstracao.formulario.FabAcaoProjetoCRCCarameloFormulario;
import br.org.carameloCode.erp.modulo.projeto.acoes.demonstracao.nativo.FabAcaoProjetoCRCComponenteNativo;
import br.org.carameloCode.erp.modulo.projeto.acoes.demonstracao.notificacoes.FabAcaoProjetoCRCNotificacoes;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.acao.FabAcaoCarameloDevAcaoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.console.FabAcaoCarameloDevConsoleCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.objeto.FabAcaoCarameloDevEdicaoItemProj;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.projeto.FabAcaoCarameloDevProjetoCRC;
import br.org.carameloCode.erp.modulo.projeto.acoes.cliente.FabAcaoCliente;

import com.super_bits.modulos.SBAcessosModel.view.FabAcaoPaginasDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.fabrica.ComoFabricaAcoes;

/**
 *
 * @author salvio
 */
public class UtilProjetosCRC {

    public static Class<? extends ComoFabricaAcoes>[] pAcoesDoSistema() {
        return new Class[]{
            FabAcaoPaginasDoSistema.class,
            FabAcaoProjetoCRCComponenteNativo.class,
            FabAcaoProjetoCRCCarameloFormulario.class,
            FabAcaoCarameloDevAcaoProjCRC.class,
            FabAcaoCarameloDevConsoleCRCProjeto.class,
            FabAcaoCarameloDevProjetoCRC.class,
            FabAcaoCliente.class,
            FabAcaoCarameloDevEdicaoItemProj.class,
            FabAcaoProjetoCRCCarameloFormulario.class,
            FabAcaoProjetoCRCNotificacoes.class,
            FabAcaoNotificacaoPadraoSB.class
        };
    }

}
