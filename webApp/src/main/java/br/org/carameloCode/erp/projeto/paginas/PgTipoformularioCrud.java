/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.projeto.paginas;

import br.org.carameloCode.erp.modulo.projeto.acoes.componente.formulario.FabAcaoProjetoCRCCarameloFormulario;
import br.org.carameloCode.erp.modulo.projeto.acoes.componente.formulario.InfoAcaoProjetoCRCFormularios;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.entidadeExemplo.EntdExemplo;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.acoes.ComoAcaoDoSistema;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.MB_paginaCadastroEntidades;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.reflexao.anotacoes.InfoPagina;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author salvio
 */
@Named
@ViewScoped
@InfoAcaoProjetoCRCFormularios(acao = FabAcaoProjetoCRCCarameloFormulario.CRUD_EXEMPLO_MB_GESTAO)
@InfoPagina(nomeCurto = "CRUD", tags = "Formulários crud")
public class PgTipoformularioCrud extends MB_paginaCadastroEntidades<EntdExemplo> {

    @Override
    public EntdExemplo getEntidadeSelecionada() {
        return super.getEntidadeSelecionada(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setAcaoSelecionada(ComoAcaoDoSistema acaoSelecionada) {
        super.setAcaoSelecionada(acaoSelecionada); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setEntidadeSelecionada(EntdExemplo entidadeSelecionada) {
        super.setEntidadeSelecionada(entidadeSelecionada); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void executarAcao(EntdExemplo pEntidadeSelecionada) {
        super.executarAcao(pEntidadeSelecionada); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void executarAcaoSelecionada() {
        super.executarAcaoSelecionada(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
