/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.projeto.paginas.projetoBuilder;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.objeto.FabAcaoCarameloDevEdicaoItemProj;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.objeto.InfoAcaoEntidadeObjetoCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.ItemFabrica;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.TIPO_PARTE_URL;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.MB_paginaCadastroEntidades;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.reflexao.anotacoes.InfoPagina;
import com.super_bits.modulosSB.webPaginas.controller.servletes.urls.parametrosURL.InfoParametroURL;
import com.super_bits.modulosSB.webPaginas.controller.servletes.urls.parametrosURL.ParametroURL;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author salvio
 */
@InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ITEM_FABRICA_GENERICA_MB_GESTAO)
@ViewScoped
@Named
@InfoPagina(nomeCurto = "CRC_ITEM_FAB", tags = "Item Fabricas objeto Estático")
public class PgItemFabricaProj extends MB_paginaCadastroEntidades<ItemFabrica> {

    @InfoParametroURL(nome = "prAtribEntidade", tipoParametro = TIPO_PARTE_URL.ENTIDADE,
            tipoEntidade = ItemFabrica.class, representaEntidadePrincipalMB = true, obrigatorio = false)
    private ParametroURL prEntidadePrincipal;

}
