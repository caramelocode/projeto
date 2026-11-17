package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributosimples.etapas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributosimples.EtapasbuilderAtributoSimples;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributosimples.FluxoBuilderAtributoSimples;
import org.junit.Assert;

public class H_e_o_usuario_define_os_tipos {

    @E(EtapasbuilderAtributoSimples.E_E_O_USUARIO_DEFINE_OS_TIPOS)
    public void implementacaoEtapa() {
        Assert.assertFalse("Nenhum atributo listado para definir o tipo", FluxoBuilderAtributoSimples.ATRIBUTO_TIPO_MANUAL.isEmpty());
        // O usuário altera o campo tipo no formulário, sem salvar: a visibilidade dos demais campos depende só do tipo
        for (AtributoDeEntidadeSimples atributo : FluxoBuilderAtributoSimples.ATRIBUTO_TIPO_MANUAL) {
            FabTipoAtributoObjeto tipoEsperado = FluxoBuilderAtributoSimples.getTipoEsperado(atributo.getNomeDeclarado());
            atributo.setTipo(tipoEsperado);
            Assert.assertEquals("Tipo não definido no atributo " + atributo.getNomeDeclarado(), tipoEsperado, atributo.getTipo());
        }
    }
}
