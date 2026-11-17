/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoStatusProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoPreparacaoObjeto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import org.coletivojava.fw.api.tratamentoErros.ErroPreparandoObjeto;

/**
 * Fábrica de status do projeto gerado (enum que implementa
 * {@code ComoFabricaStatus}, ex.: FabStatusProjeto).
 *
 * Os itens ficam na lista herdada {@link #getItens()}; use
 * {@link #getItensStatus()} para obtê-los já como {@link ItemFabricaStatus}.
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = {"Fábrica de Status"}, plural = "Fábricas de Status", icone = "fa fa-traffic-light")
public class FabricaStatusProjCRC extends FabricaEntidadeProjCRC {

    /**
     * Entidade de status (ex.: StatusCliente) que gerou esta fábrica. A
     * fábrica de status é criada automaticamente ao salvar a entidade.
     */
    @OneToOne(targetEntity = ObjetoStatusProjCRC.class, mappedBy = "fabricaStatus")
    private ObjetoStatusProjCRC entidadeStatus;

    /**
     * Parâmetro principal: o projeto ({@link ProjetoCRC}). Opcional: o nome
     * da fábrica (String), ex.: FabStatusPedido.
     */
    @Override
    @InfoPreparacaoObjeto(classesPrConstructorPrincipal = ProjetoCRC.class)
    public void prepararNovoObjeto(Object... parametros) throws ErroPreparandoObjeto {
        super.prepararNovoObjeto(parametros);
        setTipoItemProjeto(FabTipoItemProjeto.FABRICA_STATUS);
    }

    public List<ItemFabricaStatus> getItensStatus() {
        List<ItemFabricaStatus> itensStatus = new ArrayList<>();
        if (getItens() == null) {
            return itensStatus;
        }
        for (ItemFabrica item : getItens()) {
            if (item instanceof ItemFabricaStatus) {
                itensStatus.add((ItemFabricaStatus) item);
            }
        }
        return itensStatus;
    }

    public ObjetoStatusProjCRC getEntidadeStatus() {
        return entidadeStatus;
    }

    public void setEntidadeStatus(ObjetoStatusProjCRC entidadeStatus) {
        this.entidadeStatus = entidadeStatus;
    }

}
