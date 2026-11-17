package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributolistagem.EtapasbuilderAtributoListagem;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.FluxoBuilderAtributoListagem;
import org.junit.Assert;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;

public class P_Quando_o_usuario_define_o_tipo_LISTA_OBJETOS_PARTICULARES_no_atributo_clientesParticulares {

    @Quando(EtapasbuilderAtributoListagem.QUANDO_O_USUARIO_DEFINE_O_TIPO_LISTA_OBJETOS_PARTICULARES_NO_ATRIBUTO_CLIENTESPARTICULARES)
    public void implementacaoEtapa() {
        // O usuário altera o campo tipo do atributo novo, antes de salvar
        FluxoBuilderAtributoListagem.atributoAtual.setTipo(FabTipoAtributoObjeto.LISTA_OBJETOS_PARTICULARES);
        Assert.assertEquals("Tipo não definido no atributo " + FluxoBuilderAtributoListagem.atributoAtual.getNomeDeclarado(),
                FabTipoAtributoObjeto.LISTA_OBJETOS_PARTICULARES, FluxoBuilderAtributoListagem.atributoAtual.getTipo());
    }
}
