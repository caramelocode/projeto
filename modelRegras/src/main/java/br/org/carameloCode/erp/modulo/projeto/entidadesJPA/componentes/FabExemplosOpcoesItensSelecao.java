/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.itensExemplo.ExemploOpcaoComIcone;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.itensExemplo.ExemploOpcaoComIconeCor;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.itensExemplo.ExemploOpcaoSimples;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.itensExemplo.ExemploOpcaocomImagem;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.itensExemplo.ExemploOpcaocomStatus;
import com.super_bits.modulosSB.Persistencia.fabrica.ComoFabricaComPersistencia;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.modulos.dinamico.OpcaoDadoDinamico;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoDaFabrica;
import javax.persistence.EntityManager;

/**
 *
 * @author salvio
 */
public enum FabExemplosOpcoesItensSelecao implements ComoFabricaComPersistencia {

    @InfoObjetoDaFabrica(classeObjeto = ExemploOpcaoSimples.class, id = 1l, nomeObjeto = "Apenas nome")
    APENAS_NOME,
    @InfoObjetoDaFabrica(classeObjeto = ExemploOpcaoComIcone.class, id = 2l, nomeObjeto = "Com ícone")
    ICONE,
    @InfoObjetoDaFabrica(classeObjeto = ExemploOpcaoComIconeCor.class, id = 3l, nomeObjeto = "cores")
    ICONE_COR,
    @InfoObjetoDaFabrica(classeObjeto = ExemploOpcaocomImagem.class, id = 4l, nomeObjeto = "imagem pequena")
    IMAGEM_PEQUENA,
    @InfoObjetoDaFabrica(classeObjeto = ExemploOpcaocomImagem.class, id = 5l, nomeObjeto = "imagem médio")
    IMAGEM_MEDIO,
    @InfoObjetoDaFabrica(classeObjeto = ExemploOpcaocomImagem.class, id = 6l, nomeObjeto = "imágem grande")
    IMAGEM_GRANDE,
    @InfoObjetoDaFabrica(classeObjeto = ExemploOpcaocomStatus.class, id = 7l, nomeObjeto = "Item com status", icone = "fa fa-dog", cor = "#5dab2cff")
    STATUS,;

    @Override
    public OpcaoDadoDinamico getRegistro() {
        OpcaoDadoDinamico opc = (OpcaoDadoDinamico) ComoFabricaComPersistencia.super.getRegistro();
        switch (this) {

            case APENAS_NOME:

                break;
            case ICONE:
                ExemploOpcaoComIcone comicon = (ExemploOpcaoComIcone) opc;
                comicon.setIcone("fa fa-superpowers");
                break;
            case ICONE_COR:
                ExemploOpcaoComIconeCor iconecor = (ExemploOpcaoComIconeCor) opc;
                iconecor.setIcone("fa fa-superpowers");
                iconecor.setCor("#238ae6");
                break;
            case IMAGEM_PEQUENA:
                //todo adicionar imagem
                break;
            case IMAGEM_MEDIO:
                break;
            case IMAGEM_GRANDE:
                break;
            case STATUS:
                break;
            default:
                throw new AssertionError();
        }
        opc.setId(null);
        return opc;

    }

    @Override
    public OpcaoDadoDinamico getRegistro(EntityManager pEm) {
        return (OpcaoDadoDinamico) ComoFabricaComPersistencia.super.getRegistro(pEm); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
