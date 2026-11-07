/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.console;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.ComoItemProjeto;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.acoes.ComoAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.ItfAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.fabrica.ComoFabricaAcoes;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.EntidadeSimples;

/**
 *
 * @author salvio
 */
@InfoObjetoSB(plural = "Opções do console", tags = "Opção do console")
public class ItemOpcaoConsole extends EntidadeSimples {

    private String nomeDigitado;

    private ComoFabricaAcoes fabAcaoAssociada;
    private ComoItemProjeto itemAssociado;
    private ItfAcaoFormulario acaoFormularioDetalhes;
    private ComoAcaoDoSistema acaoAssociada;
    private String componenteIncludePreview;
    private int ordem;

    public ItemOpcaoConsole(String nomeDigitado, ComoFabricaAcoes acaoassociada, ComoItemProjeto itemAssociado, int ordem, ItfAcaoFormulario acaoFormularioDetalhes, String componenteIncludePreview) {
        this.nomeDigitado = nomeDigitado;
        this.fabAcaoAssociada = acaoassociada;
        this.itemAssociado = itemAssociado;
        this.ordem = ordem;
        this.acaoFormularioDetalhes = acaoFormularioDetalhes;
        this.componenteIncludePreview = componenteIncludePreview;
        if (acaoassociada != null) {
            this.acaoAssociada = acaoassociada.getRegistro();
        }
    }

    public String getNomeDigitado() {
        return nomeDigitado;
    }

    public void setNomeDigitado(String nomeDigitado) {
        this.nomeDigitado = nomeDigitado;
    }

    public ComoFabricaAcoes getFabAcaoAssociada() {
        return fabAcaoAssociada;
    }

    public void setFabAcaoAssociada(ComoFabricaAcoes fabAcaoAssociada) {
        this.fabAcaoAssociada = fabAcaoAssociada;
    }

    public ItfAcaoFormulario getAcaoFormularioDetalhes() {
        return acaoFormularioDetalhes;
    }

    public void setAcaoFormularioDetalhes(ItfAcaoFormulario acaoFormularioDetalhes) {
        this.acaoFormularioDetalhes = acaoFormularioDetalhes;
    }

    public String getComponenteIncludePreview() {
        return componenteIncludePreview;
    }

    public void setComponenteIncludePreview(String componenteIncludePreview) {
        this.componenteIncludePreview = componenteIncludePreview;
    }

    public ComoItemProjeto getItemAssociado() {
        return itemAssociado;
    }

    public void setItemAssociado(ComoItemProjeto itemAssociado) {
        this.itemAssociado = itemAssociado;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public ComoAcaoDoSistema getAcaoAssociada() {
        return acaoAssociada;
    }

    public void setAcaoAssociada(ComoAcaoDoSistema acaoAssociada) {
        this.acaoAssociada = acaoAssociada;
    }

}
