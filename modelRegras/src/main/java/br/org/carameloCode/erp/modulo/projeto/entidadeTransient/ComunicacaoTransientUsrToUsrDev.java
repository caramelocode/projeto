/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadeTransient;

import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import org.coletivojava.fw.api.tratamentoErros.ErroPreparandoObjeto;

/**
 *
 * @author salvio
 */
@InfoObjetoSB(tags = "Comunicação Transitória entre usuários", plural = "Comunicações de usuários Transitorias")
public class ComunicacaoTransientUsrToUsrDev extends ComunicacaoTransientDev {

    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA, entidadeOpcoesDisponiveis = UsuarioSB.class)
    private UsuarioSB remetente;
    private String observacao;

    @Override
    public void prepararNovoObjeto(Object... parametros) throws ErroPreparandoObjeto {
        super.prepararNovoObjeto(parametros); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        remetente = (UsuarioSB) CarameloCode.getUsuarioLogado();
    }

    public UsuarioSB getRemetente() {
        return remetente;
    }

    public void setRemetente(UsuarioSB remetente) {
        this.remetente = remetente;
    }

}
