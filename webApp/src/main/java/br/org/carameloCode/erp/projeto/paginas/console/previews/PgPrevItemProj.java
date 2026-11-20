/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.projeto.paginas.console.previews;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.console.FabAcaoCarameloDevConsoleCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.console.InfoAcaoProjetoCRCConsole;
import br.org.carameloCode.erp.modulo.projeto.builder.UtilProjetoCRCBuliderAtributo;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.modulos.dinamico.DadoDinamico;
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
@InfoAcaoProjetoCRCConsole(acao = FabAcaoCarameloDevConsoleCRCProjeto.PREV_ATRIBUTO_PROJ_MB_GESTAO)
@InfoPagina(nomeCurto = "prevAtrib", tags = "Previsualizacao Atrubuti Projeto CRC")
public class PgPrevItemProj extends MB_paginaCadastroEntidades<DadoDinamico> {

    @InfoParametroURL(nome = "Atributo", tipoParametro = TIPO_PARTE_URL.ENTIDADE, tipoEntidade = AtributoDeEntidadeSimples.class, obrigatorio = false)
    private ParametroURL prAtributo;

    @PostConstruct()
    public void inicio() {
        if (getParametroInstanciado(prAtributo).isValorDoParametroFoiConfigurado()) {
            setEntidadeSelecionada(new DadoDinamico());

            AtributoDeEntidadeSimples atributo = (AtributoDeEntidadeSimples) getParametroInstanciado(prAtributo).getValor();
            DadoDinamico dado = UtilProjetoCRCBuliderAtributo.gerarDadoDinamico(atributo);
            setEntidadeSelecionada(dado);

            //TipoDadoDinamico tipoDAd=
            //    getEntidadeSelecionada().setTipoDadoDinamico(tipoDadoDinamico);
        }
    }

}
