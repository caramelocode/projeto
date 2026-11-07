package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRCFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.fabricas.FabTipoAcaoSistemaGenerica;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;

public class AI_Entao_FabAcaoGerente_o_CLIENTE_FRM_NOVO_fica_registrada_com_o_comportamento_novo_registro {

    @Entao(EtapasconsoleProjCRCAcoes.ENTAO_FABACAOGERENTE_O_CLIENTE_FRM_NOVO_FICA_REGISTRADA_COM_O_COMPORTAMENTO_NOVO_REGISTRO)
    public void implementacaoEtapa() {
        FluxoConsoleAcoes.verificarAcaoSecundariaClienteRegistrada(FluxoConsoleAcoes.ACAO_CLIENTE_FRM_NOVO,
                AcaoProjCRCFormulario.class, FabTipoAcaoSistemaGenerica.FORMULARIO_NOVO_REGISTRO);
    }
}
