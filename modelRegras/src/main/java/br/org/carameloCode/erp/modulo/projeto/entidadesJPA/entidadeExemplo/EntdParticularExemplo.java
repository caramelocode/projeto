/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.entidadeExemplo;

import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoPreparacaoObjeto;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.coletivojava.fw.api.tratamentoErros.ErroPreparandoObjeto;

/**
 *
 *
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(plural = "Subitens exemplo", tags = "subItem")
public class EntdParticularExemplo
        // Não precisava usar a mesma entidade, extendendo apenas para demonstrar funcionalidade, e criar uma tabela a menos no banco
        extends EntdExemplo {

    @InfoCampo(label = "Entidade pai")
    @ManyToOne(targetEntity = EntdExemplo.class)
    private EntdExemplo entidadePai;

    @Override
    @InfoPreparacaoObjeto(classesPrConstructorPrincipal = EntdExemplo.class)
    public void prepararNovoObjeto(Object... parametros) throws ErroPreparandoObjeto {
        super.prepararNovoObjeto(parametros); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
