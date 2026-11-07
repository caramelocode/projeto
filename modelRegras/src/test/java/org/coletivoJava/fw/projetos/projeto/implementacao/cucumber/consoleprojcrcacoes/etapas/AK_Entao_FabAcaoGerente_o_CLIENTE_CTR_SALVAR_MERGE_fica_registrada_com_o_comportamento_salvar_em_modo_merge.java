package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRCContoller;
import com.super_bits.modulosSB.SBCore.modulos.Controller.fabricas.FabTipoAcaoSistemaGenerica;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;

public class AK_Entao_FabAcaoGerente_o_CLIENTE_CTR_SALVAR_MERGE_fica_registrada_com_o_comportamento_salvar_em_modo_merge {

    @Entao(EtapasconsoleProjCRCAcoes.ENTAO_FABACAOGERENTE_O_CLIENTE_CTR_SALVAR_MERGE_FICA_REGISTRADA_COM_O_COMPORTAMENTO_SALVAR_EM_MODO_MERGE)
    public void implementacaoEtapa() {
        FluxoConsoleAcoes.verificarAcaoSecundariaClienteRegistrada(FluxoConsoleAcoes.ACAO_CLIENTE_CTR_SALVAR_MERGE,
                AcaoProjCRCContoller.class, FabTipoAcaoSistemaGenerica.CONTROLLER_SALVAR_MODO_MERGE);
    }
}
