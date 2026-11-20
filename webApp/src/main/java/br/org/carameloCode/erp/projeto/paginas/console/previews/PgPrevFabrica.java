/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.projeto.paginas.console.previews;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.console.FabAcaoCarameloDevConsoleCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.console.InfoAcaoProjetoCRCConsole;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaEntidadeProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fluxoTeste.FluxodoProjetoCRC;
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
@Named
@ViewScoped
@InfoAcaoProjetoCRCConsole(acao = FabAcaoCarameloDevConsoleCRCProjeto.PREV_FABRICA_MB_GESTAO)
@InfoPagina(nomeCurto = "prevFAB", tags = "Previsualizacao Fábricas Projeto CRC")
public class PgPrevFabrica extends MB_paginaCadastroEntidades<FabricaEntidadeProjCRC> {

    @InfoParametroURL(nome = "FLuxo", tipoParametro = TIPO_PARTE_URL.ENTIDADE, tipoEntidade = FabricaEntidadeProjCRC.class, obrigatorio = false)
    private ParametroURL prObjeto;

}
