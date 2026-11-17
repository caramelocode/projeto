package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoentidade.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeEntidade;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributoentidade.EtapasbuilderAtributoEntidade;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributoentidade.FluxoBuilderAtributoEntidade;
import org.junit.Assert;

public class I_o_usuario_define_os_tipos {

    @E(EtapasbuilderAtributoEntidade.E_O_USUARIO_DEFINE_OS_TIPOS)
    public void implementacaoEtapa() {
        Assert.assertFalse("Nenhum atributo listado para definir o tipo", FluxoBuilderAtributoEntidade.ATRIBUTO_TIPO_MANUAL.isEmpty());
        // O usuário altera o campo tipo no formulário, sem salvar: a visibilidade dos demais campos depende só do tipo
        for (AtributoEntidadeEntidade atributo : FluxoBuilderAtributoEntidade.ATRIBUTO_TIPO_MANUAL) {
            FabTipoAtributoObjeto tipoEsperado = FluxoBuilderAtributoEntidade.getTipoEsperado(atributo.getNomeDeclarado());
            atributo.setTipo(tipoEsperado);
            Assert.assertEquals("Tipo não definido no atributo " + atributo.getNomeDeclarado(), tipoEsperado, atributo.getTipo());
        }
    }
}
