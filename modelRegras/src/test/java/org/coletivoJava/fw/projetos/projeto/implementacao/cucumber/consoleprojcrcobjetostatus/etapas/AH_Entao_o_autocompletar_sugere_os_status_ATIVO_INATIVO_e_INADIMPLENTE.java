package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.etapas;

import cucumber.api.java.pt.Entao;
import java.util.Arrays;
import java.util.List;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetostatus.EtapasconsoleProjCRCObjetoStatus;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetostatus.FluxoConsoleObjetoStatus;
import org.junit.Assert;

public class AH_Entao_o_autocompletar_sugere_os_status_ATIVO_INATIVO_e_INADIMPLENTE {

    @Entao(EtapasconsoleProjCRCObjetoStatus.ENTAO_O_AUTOCOMPLETAR_SUGERE_OS_STATUS_ATIVO_INATIVO_E_INADIMPLENTE)
    public void implementacaoEtapa() {
        String sugestaoAtivo = FluxoConsoleObjetoStatus.getTextoStatus(FluxoConsoleObjetoStatus.NOME_ENUM_STATUS_ATIVO);
        String sugestaoInativo = FluxoConsoleObjetoStatus.getTextoStatus(FluxoConsoleObjetoStatus.NOME_ENUM_STATUS_INATIVO);
        String sugestaoInadimplente = FluxoConsoleObjetoStatus.getTextoStatus(FluxoConsoleObjetoStatus.NOME_ENUM_STATUS_INADIMPLENTE);

        // Somente os status existentes, na ordem do idObjeto
        List<String> sugestoesEsperadas = Arrays.asList(sugestaoAtivo, sugestaoInativo, sugestaoInadimplente);
        List<String> sugestoesRecebidas = FluxoConsoleObjetoStatus.sugestoesAutocompletar;

        Assert.assertEquals("Sugestões do autocompletar incorretas", sugestoesEsperadas, sugestoesRecebidas);
    }
}
