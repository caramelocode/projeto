package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRCContoller;
import com.super_bits.modulosSB.SBCore.modulos.Controller.fabricas.FabTipoAcaoSistemaGenerica;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;

public class AO_Entao_FabAcaoGerente_o_CLIENTE_CTR_REMOVER_fica_registrada_com_o_comportamento_remover {

    @Entao(EtapasconsoleProjCRCAcoes.ENTAO_FABACAOGERENTE_O_CLIENTE_CTR_REMOVER_FICA_REGISTRADA_COM_O_COMPORTAMENTO_REMOVER)
    public void implementacaoEtapa() {
        FluxoConsoleAcoes.verificarAcaoSecundariaClienteRegistrada(FluxoConsoleAcoes.ACAO_CLIENTE_CTR_REMOVER,
                AcaoProjCRCContoller.class, FabTipoAcaoSistemaGenerica.CONTROLLER_REMOVER);
    }
}
