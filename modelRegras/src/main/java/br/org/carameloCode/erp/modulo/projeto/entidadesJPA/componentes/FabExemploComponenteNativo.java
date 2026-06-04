/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes;

import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import com.super_bits.modulosSB.Persistencia.fabrica.ComoFabricaComPersistencia;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.modulos.dinamico.OpcaoDadoDinamico;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoDaFabrica;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import javax.persistence.EntityManager;

/**
 *
 * @author salvio
 */
public enum FabExemploComponenteNativo
        implements ComoFabricaComPersistencia {

    @InfoObjetoDaFabrica(classeObjeto = ExemploComponenteInput.class, id = 1l, nomeObjeto = "CELULAR")
    TELEFONE_CELULAR,
    @InfoObjetoDaFabrica(classeObjeto = ExemploComponenteInput.class, id = 2l, nomeObjeto = "WHATSAPP")
    TELEFONE_WHATSAPPP,
    @InfoObjetoDaFabrica(classeObjeto = ExemploComponenteInput.class, id = 3l, nomeObjeto = "TELGENERICO")
    TELEFONE_GENERICO,
    @InfoObjetoDaFabrica(classeObjeto = ExemploComponenteInput.class, id = 4l, nomeObjeto = "CNPJ")
    CNPJ,
    @InfoObjetoDaFabrica(classeObjeto = ExemploComponenteInput.class, id = 5l, nomeObjeto = "Item Simples")
    ITEM_SIMPLES,
    @InfoObjetoDaFabrica(classeObjeto = ExemploComponenteInput.class, id = 6l, nomeObjeto = "Item  Icone e nome")
    ITEM_SIMPLES_COM_ICONE,
    @InfoObjetoDaFabrica(classeObjeto = ExemploComponenteInput.class, id = 7l, nomeObjeto = "Item Icone Nome e Cor")
    ITEM_SIMPLES_COM_ICONE_E_COR,
    @InfoObjetoDaFabrica(classeObjeto = ExemploComponenteInput.class, id = 8l, nomeObjeto = "Item com imagem")
    ITEM_SIMPLES_COM_IMAGEM,
    @InfoObjetoDaFabrica(classeObjeto = ExemploComponenteInput.class, id = 9l, nomeObjeto = "Item com STATUS")
    ITEM_COM_STATUS;

    public ExemploComponente getRegistro() {
        ExemploComponente novoExemplo = (ExemploComponente) ComoFabricaComPersistencia.super.getRegistro(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        EntityManager em = UtilSBPersistencia.getEntyManagerPadraoNovo();
        try {
            switch (this) {

                case TELEFONE_CELULAR:
                    novoExemplo.setLabel("Celular");
                    novoExemplo.setFabricaTipoAtributo(FabTipoAtributoObjeto.TELEFONE_CELULAR);
                    break;
                case TELEFONE_WHATSAPPP:
                    novoExemplo.setLabel("Whatsapp");
                    novoExemplo.setFabricaTipoAtributo(FabTipoAtributoObjeto.TELEFONE_GENERICO);
                    break;
                case TELEFONE_GENERICO:
                    novoExemplo.setLabel("Telefone Generico");
                    novoExemplo.setFabricaTipoAtributo(FabTipoAtributoObjeto.TELEFONE_GENERICO);
                    break;
                case CNPJ:
                    novoExemplo.setLabel("Cnpj");
                    novoExemplo.setFabricaTipoAtributo(FabTipoAtributoObjeto.CNPJ);

                    break;
                case ITEM_SIMPLES:
                    novoExemplo.setLabel("Item simples");
                    novoExemplo.setFabricaTipoAtributo(FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA);
                    OpcaoDadoDinamico opc = FabExemplosOpcoesItensSelecao.APENAS_NOME.getRegistro();
                    opc.setTipoDado(novoExemplo);
                    opc.getTipoDado().setNomeClasseAtributoDeclarado(OpcaoDadoDinamico.class.getSimpleName());
                    novoExemplo.getOpcoesPersonalizada().add(opc);
                    break;
                case ITEM_SIMPLES_COM_ICONE:
                    novoExemplo.setLabel("Item com ícone ");

                    OpcaoDadoDinamico opcIcone = FabExemplosOpcoesItensSelecao.ICONE.getRegistro();
                    opcIcone.setTipoDado(novoExemplo);
                    opcIcone.getTipoDado().setNomeClasseAtributoDeclarado(OpcaoDadoDinamico.class.getSimpleName());

                    novoExemplo.getOpcoesPersonalizada().add(opcIcone);
                    novoExemplo.setFabricaTipoAtributo(FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA);
                    break;
                case ITEM_SIMPLES_COM_ICONE_E_COR:
                    novoExemplo.setLabel("Icone e cor");

                    OpcaoDadoDinamico iconeCor = FabExemplosOpcoesItensSelecao.ICONE_COR.getRegistro();
                    iconeCor.setTipoDado(novoExemplo);
                    iconeCor.getTipoDado().setNomeClasseAtributoDeclarado(OpcaoDadoDinamico.class.getSimpleName());

                    novoExemplo.getOpcoesPersonalizada().add(iconeCor);
                    novoExemplo.setFabricaTipoAtributo(FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA);
                    break;
                case ITEM_SIMPLES_COM_IMAGEM:
                    novoExemplo.setLabel("Item simples com imagem");

                    OpcaoDadoDinamico comimagem = FabExemplosOpcoesItensSelecao.IMAGEM_PEQUENA.getRegistro();
                    comimagem.setTipoDado(novoExemplo);
                    comimagem.getTipoDado().setNomeClasseAtributoDeclarado(OpcaoDadoDinamico.class.getSimpleName());

                    novoExemplo.getOpcoesPersonalizada().add(comimagem);

                    novoExemplo.setFabricaTipoAtributo(FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA);
                    break;
                case ITEM_COM_STATUS:
                    novoExemplo.setLabel("Item Com Status ");
                    novoExemplo.setFabricaTipoAtributo(FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA);

                    OpcaoDadoDinamico status = FabExemplosOpcoesItensSelecao.STATUS.getRegistro();
                    status.setTipoDado(novoExemplo);
                    status.getTipoDado().setNomeClasseAtributoDeclarado(OpcaoDadoDinamico.class.getSimpleName());

                    novoExemplo.getOpcoesPersonalizada().add(status);

                    break;
                default:
                    throw new AssertionError();
            }
        } finally {

        }

        return novoExemplo;
    }

}
