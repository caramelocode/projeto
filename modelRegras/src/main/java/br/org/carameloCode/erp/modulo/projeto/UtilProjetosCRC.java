/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto;

import br.org.carameloCode.erp.modulo.notificacao.api.FabAcaoNotificacaoPadraoSB;
import br.org.carameloCode.erp.modulo.projeto.acoes.componente.formulario.FabAcaoProjetoCRCCarameloFormulario;
import br.org.carameloCode.erp.modulo.projeto.acoes.componente.nativo.FabAcaoProjetoCRCComponenteNativo;
import br.org.carameloCode.erp.modulo.projeto.acoes.projetoCarameloBuilder.acao.FabAcaoProjetoCRCAcoes;
import br.org.carameloCode.erp.modulo.projeto.acoes.projetoCarameloBuilder.console.FabAcaoProjetoCRCConsole;
import br.org.carameloCode.erp.modulo.projeto.acoes.projetoCarameloBuilder.entidade.FabAcaoProjetoCRCEntidade;
import br.org.carameloCode.erp.modulo.projeto.acoes.projetoCarameloBuilder.projeto.FabAcaoProjetoCRCProjetoCaramelo;
import br.org.carameloCode.erp.modulo.projeto.acoes.projetoCarameloBuilder.requisito.FabAcaoProjetoCRCRequisito;
import com.super_bits.modulos.SBAcessosModel.fabricas.FabAcaoProjetoSB;
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
            FabAcaoProjetoCRCAcoes.class,
            FabAcaoProjetoCRCConsole.class,
            FabAcaoProjetoCRCProjetoCaramelo.class,
            FabAcaoProjetoCRCRequisito.class,
            FabAcaoProjetoCRCEntidade.class,};
    }

}
