/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRC;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.coletivojava.fw.api.tratamentoErros.ErroPreparandoObjeto;

/**
 * Status de uma {@link FabricaStatusProjCRC}. As ações do status geram o
 * {@code opcoesPorStatus()} do {@code ComoFabricaStatus}.
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = {"Item de Fábrica de Status"}, plural = "Itens de Fábrica de Status")
public class ItemFabricaStatus extends ItemFabrica {

    @Override
    public void prepararNovoObjeto(Object... parametros) throws ErroPreparandoObjeto {
        super.prepararNovoObjeto(parametros); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @ManyToMany(targetEntity = AcaoProjCRC.class, fetch = FetchType.LAZY)
    @JoinTable(name = "itemFabricaStatus_acoes",
            joinColumns = @JoinColumn(name = "itemFabricaStatus_id"),
            inverseJoinColumns = @JoinColumn(name = "acao_id"))
    @InfoCampo(tipo = FabTipoAtributoObjeto.LISTA_OBJETOS_PUBLICOS)
    private List<AcaoProjCRC> acoesDoStatus;

    public List<AcaoProjCRC> getAcoesDoStatus() {
        return acoesDoStatus;
    }

    public void setAcoesDoStatus(List<AcaoProjCRC> acoesDoStatus) {
        this.acoesDoStatus = acoesDoStatus;
    }

}
