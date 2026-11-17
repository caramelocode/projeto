package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.etapas;

import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcatributosespeciais.EtapasconsoleProjCRCAtributosEspeciais;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.FluxoConsoleAtributosEspeciais;
import org.junit.Assert;

public class B_a_entidade_Cliente_ainda_nao_possui_os_atributos_clienteIndicou_e_clientesRelacionados {

    @E(EtapasconsoleProjCRCAtributosEspeciais.E_A_ENTIDADE_CLIENTE_AINDA_NAO_POSSUI_OS_ATRIBUTOS_CLIENTEINDICOU_E_CLIENTESRELACIONADOS)
    public void implementacaoEtapa() {
        Assert.assertFalse("A entidade " + FluxoConsoleAtributosEspeciais.NOME_ENTIDADE_CLIENTE + " já possui o atributo "
                + FluxoConsoleAtributosEspeciais.NOME_ATRIBUTO_CLIENTE_INDICOU,
                FluxoConsoleAtributosEspeciais.getAtributoSalvoEmCliente(FluxoConsoleAtributosEspeciais.NOME_ATRIBUTO_CLIENTE_INDICOU).isPresent());
        Assert.assertFalse("A entidade " + FluxoConsoleAtributosEspeciais.NOME_ENTIDADE_CLIENTE + " já possui o atributo "
                + FluxoConsoleAtributosEspeciais.NOME_ATRIBUTO_CLIENTES_RELACIONADOS,
                FluxoConsoleAtributosEspeciais.getAtributoSalvoEmCliente(FluxoConsoleAtributosEspeciais.NOME_ATRIBUTO_CLIENTES_RELACIONADOS).isPresent());
    }
}
