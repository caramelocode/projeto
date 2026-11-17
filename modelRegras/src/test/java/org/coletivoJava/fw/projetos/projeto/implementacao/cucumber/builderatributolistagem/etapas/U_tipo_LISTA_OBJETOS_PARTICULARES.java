package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.etapas;

import org.coletivoJava.fw.projetos.projeto.api.cucumber.builderatributolistagem.EtapasbuilderAtributoListagem;
import cucumber.api.java.pt.E;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.builderatributolistagem.FluxoBuilderAtributoListagem;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;

public class U_tipo_LISTA_OBJETOS_PARTICULARES {

    @E(EtapasbuilderAtributoListagem.E_TIPO_LISTA_OBJETOS_PARTICULARES)
    public void implementacaoEtapa() {
        FluxoBuilderAtributoListagem.verificarAtributoSalvo(FluxoBuilderAtributoListagem.NOME_CLIENTES_PARTICULARES, FabTipoAtributoObjeto.LISTA_OBJETOS_PARTICULARES);
    }
}
