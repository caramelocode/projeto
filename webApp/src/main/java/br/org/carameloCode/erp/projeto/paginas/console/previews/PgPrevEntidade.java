/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.projeto.paginas.console.previews;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.console.FabAcaoCarameloDevConsoleCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.console.InfoAcaoProjetoCRCConsole;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoStatusProjCRC;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.TIPO_PARTE_URL;

import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.MB_paginaCadastroEntidades;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.reflexao.anotacoes.InfoPagina;
import com.super_bits.modulosSB.webPaginas.controller.servletes.urls.parametrosURL.InfoParametroURL;
import com.super_bits.modulosSB.webPaginas.controller.servletes.urls.parametrosURL.ParametroURL;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author salvio
 */
@Named
@ViewScoped
@InfoAcaoProjetoCRCConsole(acao = FabAcaoCarameloDevConsoleCRCProjeto.PREV_OBJETO_PROJ_MB_GESTAO)
@InfoPagina(nomeCurto = "prevOBJ", tags = "Previsualizacao Objeto Projeto CRC")
public class PgPrevEntidade extends MB_paginaCadastroEntidades<ObjetoProjCRC> {

    @InfoParametroURL(nome = "Atributo", tipoParametro = TIPO_PARTE_URL.ENTIDADE, tipoEntidade = ObjetoProjCRC.class, obrigatorio = false)
    private ParametroURL prObjeto;

    @PostConstruct
    public void inicio() {

        if (getParametroInstanciado(prObjeto).isValorDoParametroFoiConfigurado()) {
            if (getParametroInstanciado(prObjeto).getValor() instanceof ObjetoStatusProjCRC) {
                executaAcaoSelecionadaPorEnum(FabAcaoCarameloDevConsoleCRCProjeto.PREV_OBJETO_PROJ_FRM_STATUS);
            } else {
                executaAcaoSelecionadaPorEnum(FabAcaoCarameloDevConsoleCRCProjeto.PREV_OBJETO_PROJ_FRM_GENERICO);

            }
        }

    }

}
