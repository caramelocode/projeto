package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRCFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.fabricas.FabTipoAcaoSistemaGenerica;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;

public class AE_Entao_FabAcaoGerente_o_CLIENTE_FRM_EDITAR_fica_registrada_com_o_comportamento_editar {

    @Entao(EtapasconsoleProjCRCAcoes.ENTAO_FABACAOGERENTE_O_CLIENTE_FRM_EDITAR_FICA_REGISTRADA_COM_O_COMPORTAMENTO_EDITAR)
    public void implementacaoEtapa() {
        FluxoConsoleAcoes.verificarAcaoSecundariaClienteRegistrada(FluxoConsoleAcoes.ACAO_CLIENTE_FRM_EDITAR,
                AcaoProjCRCFormulario.class, FabTipoAcaoSistemaGenerica.FORMULARIO_EDITAR);
    }
}
