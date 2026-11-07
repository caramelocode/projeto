package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcobjetos.EtapasconsoleProjCRCObjetos;
import cucumber.api.java.pt.Entao;
import java.util.List;
import java.util.Optional;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcobjetos.FluxoConsoleObjetos;
import org.junit.Assert;

public class I_Entao_a_entidade_Cliente_passa_a_ser_listada_no_projeto {

    @Entao(EtapasconsoleProjCRCObjetos.ENTAO_A_ENTIDADE_CLIENTE_PASSA_A_SER_LISTADA_NO_PROJETO)
    public void implementacaoEtapa() {
        FluxoConsoleObjetos.renovarConexaoEntityManagerEscopoTeste();
        ProjetoCRC projeto = UtilSBPersistencia.loadEntidade(FluxoConsoleObjetos.CONSOLE.getProjetoSelecionado(), FluxoConsoleObjetos.getEM());
        Assert.assertNotNull("Projeto não encontrado", projeto);
        Assert.assertNotNull("Lista de entidades do projeto não carregada", projeto.getObjetos());
        Optional<ObjetoProjCRC> entidade = projeto.getObjetos().stream()
                .filter(obj -> FluxoConsoleObjetos.NOME_ENTIDADE_CLIENTE.equals(obj.getNomeEntidade()))
                .findFirst();
        Assert.assertTrue("Entidade " + FluxoConsoleObjetos.NOME_ENTIDADE_CLIENTE + " não encontrada no projeto", entidade.isPresent());

        List<AtributoDeEntidadeSimples> atributos = entidade.get().getAtributos();
        Assert.assertNotNull("Atributos da entidade não carregados", atributos);
        Assert.assertTrue("Atributo padrão " + FluxoConsoleObjetos.NOME_ATRIBUTO_ID + " não foi salvo com a entidade",
                atributos.stream().anyMatch(at -> FluxoConsoleObjetos.NOME_ATRIBUTO_ID.equals(at.getNomeDeclarado())
                && FabTipoAtributoObjeto.ID.equals(at.getTipo())));
        Assert.assertTrue("Atributo padrão " + FluxoConsoleObjetos.NOME_ATRIBUTO_NOME + " não foi salvo com a entidade",
                atributos.stream().anyMatch(at -> FluxoConsoleObjetos.NOME_ATRIBUTO_NOME.equals(at.getNomeDeclarado())
                && FabTipoAtributoObjeto.NOME.equals(at.getTipo())));
    }
}
