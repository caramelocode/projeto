/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.itensExemplo;

import com.super_bits.modulosSB.Persistencia.registro.persistidos.modulos.dinamico.OpcaoDadoDinamico;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoStatus;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoTemStatus;
import javax.persistence.Entity;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(plural = "Exemplos com imagem ", tags = "Exemplo imagem")
public class ExemploOpcaocomStatus extends OpcaoDadoDinamico implements ComoTemStatus {

    @Override
    public ComoStatus getStatusPrincipal() {
        return (ComoStatus) FabStatusTeste.STATUS_TESTE.getRegistro();
    }

}
