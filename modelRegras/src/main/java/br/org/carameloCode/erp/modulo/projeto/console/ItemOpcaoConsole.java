/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.console;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.console.FabAcaoCarameloDevConsoleCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.ComoItemProjeto;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
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

    private ComoFabricaAcoes fabAcaoCriarItem;
    private ComoFabricaAcoes fabAcaoPreview;
    private ComoItemProjeto itemAssociado;
    private ItfAcaoFormulario acaoFormularioEditar;
    private ComoAcaoDoSistema acaoAssociada;
    private String urlPreview = null;

    private int ordem;

    public ItemOpcaoConsole(String nomeDigitado, ComoFabricaAcoes pAcaoCriarItem, ComoItemProjeto itemAssociado, int ordem, ItfAcaoFormulario pAcaoEdicao, ComoFabricaAcoes pacaoPreview) {
        this.nomeDigitado = nomeDigitado;
        this.fabAcaoCriarItem = pAcaoCriarItem;
        this.itemAssociado = itemAssociado;
        this.ordem = ordem;
        this.acaoFormularioEditar = pAcaoEdicao;
        this.fabAcaoPreview = pacaoPreview;
        if (pacaoPreview != null) {

            urlPreview = CarameloCode.getServicoVisualizacao().getEndrRemotoFormulario(pacaoPreview, itemAssociado);
        }

        if (pAcaoCriarItem != null) {
            this.acaoAssociada = pAcaoCriarItem.getRegistro();
        }

    }

    public String getNomeDigitado() {
        return nomeDigitado;
    }

    public void setNomeDigitado(String nomeDigitado) {
        this.nomeDigitado = nomeDigitado;
    }

    public ComoFabricaAcoes getFabAcaoCriarItem() {
        return fabAcaoCriarItem;
    }

    public void setFabAcaoCriarItem(ComoFabricaAcoes fabAcaoCriarItem) {
        this.fabAcaoCriarItem = fabAcaoCriarItem;
    }

    public ItfAcaoFormulario getAcaoFormularioEditar() {
        return acaoFormularioEditar;
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

    public String getUrlPreview() {
        return urlPreview;
    }

}
