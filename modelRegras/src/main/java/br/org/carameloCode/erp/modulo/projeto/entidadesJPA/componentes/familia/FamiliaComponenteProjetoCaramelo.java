/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.familia;

import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.view.fabricasCompVisual.FabFamiliaCompVisual;
import javax.persistence.Entity;
import org.coletivojava.fw.api.objetoNativo.view.componente.FamiliaComponente;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = {"Família do Componente"}, plural = "Famílias de componente", fabricaVinculada = FabFamiliaCompVisual.class)
public class FamiliaComponenteProjetoCaramelo extends FamiliaComponente {

}
