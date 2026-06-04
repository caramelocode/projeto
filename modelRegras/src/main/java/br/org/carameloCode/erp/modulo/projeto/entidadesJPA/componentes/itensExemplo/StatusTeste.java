/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.itensExemplo;

import com.super_bits.modulosSB.SBCore.modulos.fabrica.ComoFabricaStatus;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoStatus;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.EntidadeSimples;

/**
 *
 * @author salvio
 */
@InfoObjetoSB(tags = "Stauts teste", plural = "Status de testes")
public class StatusTeste extends EntidadeSimples implements ComoStatus {

    @InfoCampo(tipo = FabTipoAtributoObjeto.ID)
    private Long id;
    @InfoCampo(tipo = FabTipoAtributoObjeto.NOME)
    private String descricao;
    @InfoCampo(tipo = FabTipoAtributoObjeto.ICONE)
    private String icone;
    @InfoCampo(tipo = FabTipoAtributoObjeto.COR)
    private String cor;

    @InfoCampo(tipo = FabTipoAtributoObjeto.STATUS_ENUM)
    private FabStatusTeste statusEnum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public FabStatusTeste getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(ComoFabricaStatus statusEnum) {
        this.statusEnum = (FabStatusTeste) statusEnum;
    }

}
