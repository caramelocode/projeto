/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes;

import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = "ação de formulário", plural = "Ações de formulários", icone = "fa fa-pencil-square-o")
public class AcaoProjCRCFormulario extends AcaoCRCProjSecundaria {

    @OneToMany(targetEntity = GrupoCamposProjCRC.class)
    private List<GrupoCamposProjCRC> grupoCampos;

    public List<GrupoCamposProjCRC> getGrupoCampos() {
        return grupoCampos;
    }

    public void setGrupoCampos(List<GrupoCamposProjCRC> grupoCampos) {
        this.grupoCampos = grupoCampos;
    }

}
