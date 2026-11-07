package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRCGestao;
import com.super_bits.modulosSB.SBCore.modulos.Controller.fabricas.FabTipoAcaoSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.fabricas.FabTipoAcaoSistemaGenerica;
import cucumber.api.java.pt.Entao;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcacoes.EtapasconsoleProjCRCAcoes;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcacoes.FluxoConsoleAcoes;
import org.junit.Assert;

public class W_Entao_FabAcaoGerente_o_CLIENTE_MB_GESTAO_fica_registrada_com_o_tipo_gerenciar_entidade {

    @Entao(EtapasconsoleProjCRCAcoes.ENTAO_FABACAOGERENTE_O_CLIENTE_MB_GESTAO_FICA_REGISTRADA_COM_O_TIPO_GERENCIAR_ENTIDADE)
    public void implementacaoEtapa() {
        AcaoProjCRC acao = FluxoConsoleAcoes.getAcaoSalvaNoProjeto(
                FluxoConsoleAcoes.getNomeUnico(FluxoConsoleAcoes.FABRICA_GERENTE, FluxoConsoleAcoes.ACAO_CLIENTE_MB_GESTAO));
        Assert.assertTrue("A ação deveria ser salva como ação de gestão", acao instanceof AcaoProjCRCGestao);
        Assert.assertEquals("Tipo de ação genérica incorreto", FabTipoAcaoSistemaGenerica.GERENCIAR_DOMINIO, acao.getTipoAcaoGenerica());
        Assert.assertEquals("Tipo de ação incorreto", FabTipoAcaoSistema.ACAO_ENTIDADE_GERENCIAR, acao.getTipoAcao());
        Assert.assertNotNull("A ação deveria estar vinculada a um módulo", acao.getModulo());
        Assert.assertNotNull("O módulo deveria ter sido salvo junto com a ação", acao.getModulo().getId());
        Assert.assertEquals("Nome do módulo incorreto", FluxoConsoleAcoes.NOME_MODULO_GERENTE, acao.getModulo().getNome());
        Assert.assertNotNull("A ação deveria ter a entidade de domínio " + FluxoConsoleAcoes.NOME_ENTIDADE_CLIENTE, acao.getEntidadeDominio());
        Assert.assertEquals("Entidade de domínio incorreta", FluxoConsoleAcoes.NOME_ENTIDADE_CLIENTE, acao.getEntidadeDominio().getNomeEntidade());
        FluxoConsoleAcoes.acaoGestaoCliente = acao;
        FluxoConsoleAcoes.acoesCliente.clear();
        FluxoConsoleAcoes.acoesCliente.add(acao);
    }
}
