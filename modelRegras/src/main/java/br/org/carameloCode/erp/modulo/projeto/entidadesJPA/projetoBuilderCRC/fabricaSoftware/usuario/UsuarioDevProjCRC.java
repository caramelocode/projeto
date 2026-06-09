/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.fabricaSoftware.usuario;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.fabricaSoftware.FabricaSoftware;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(plural = "Caramelo code Devs", tags = "Dev CRC")
public class UsuarioDevProjCRC extends UsuarioSB {

    @ManyToOne(targetEntity = FabricaSoftware.class)
    private FabricaSoftware fabrica;

    @OneToMany(mappedBy = "usuario")
    private List<ChaveAcessoRepositorio> chaves;

    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA)
    @ManyToOne()
    private ProjetoCRC projetoAtual;

    public FabricaSoftware getFabrica() {
        return fabrica;
    }

    public void setFabrica(FabricaSoftware fabrica) {
        this.fabrica = fabrica;
    }

    public List<ChaveAcessoRepositorio> getChaves() {
        return chaves;
    }

    public void setChaves(List<ChaveAcessoRepositorio> chaves) {
        this.chaves = chaves;
    }

}
