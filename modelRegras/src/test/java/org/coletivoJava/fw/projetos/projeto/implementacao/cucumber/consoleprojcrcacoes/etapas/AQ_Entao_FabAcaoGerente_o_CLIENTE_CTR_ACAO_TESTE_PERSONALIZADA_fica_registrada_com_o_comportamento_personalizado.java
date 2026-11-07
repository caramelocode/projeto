package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRCContoller;
import com.super_bits.modulosSB.SBCore.modulos.Controller.fabricas.FabTipoAcaoSistemaGenerica;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;

public class AQ_Entao_FabAcaoGerente_o_CLIENTE_CTR_ACAO_TESTE_PERSONALIZADA_fica_registrada_com_o_comportamento_personalizado {

    @Entao(EtapasconsoleProjCRCAcoes.ENTAO_FABACAOGERENTE_O_CLIENTE_CTR_ACAO_TESTE_PERSONALIZADA_FICA_REGISTRADA_COM_O_COMPORTAMENTO_PERSONALIZADO)
    public void implementacaoEtapa() {
        FluxoConsoleAcoes.verificarAcaoSecundariaClienteRegistrada(FluxoConsoleAcoes.ACAO_CLIENTE_CTR_ACAO_TESTE_PERSONALIZADA,
                AcaoProjCRCContoller.class, FabTipoAcaoSistemaGenerica.CONTROLLER_PERSONALIZADO);
    }
}
