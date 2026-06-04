/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.itensExemplo;

import com.google.j2objc.annotations.ObjectiveCName;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.modulos.dinamico.OpcaoDadoDinamico;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoTemImagemGrande;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoTemImagemMedio;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoTemImagemPequena;
import javax.persistence.Entity;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(plural = "Exemplos com imagem ", tags = "Exemplo imagem")
public class ExemploOpcaocomImagem extends OpcaoDadoDinamico implements ComoTemImagemPequena, ComoTemImagemMedio, ComoTemImagemGrande {

    private String imgPequena;
    private String imgMedia;
    private String imgGrande;

    public String getImgPequena() {
        return imgPequena;
    }

    public void setImgPequena(String imgPequena) {
        this.imgPequena = imgPequena;
    }

    public String getImgMedia() {
        return imgMedia;
    }

    public void setImgMedia(String imgMedia) {
        this.imgMedia = imgMedia;
    }

    public String getImgGrande() {
        return imgGrande;
    }

    public void setImgGrande(String imgGrande) {
        this.imgGrande = imgGrande;
    }

    @Override
    public boolean isTemImagemMedioAdicionada() {
        return SBCore.getServicoArquivosDeEntidade().isTemImagem(this, FabTipoAtributoObjeto.IMG_MEDIA);
    }

    @Override
    public boolean isTemImagemGrandeAdicionada() {
        return SBCore.getServicoArquivosDeEntidade().isTemImagem(this, FabTipoAtributoObjeto.IMG_GRANDE);
    }

}
