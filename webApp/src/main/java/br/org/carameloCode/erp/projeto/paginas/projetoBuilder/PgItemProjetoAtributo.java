package br.org.carameloCode.erp.projeto.paginas.projetoBuilder;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.objeto.FabAcaoCarameloDevEdicaoItemProj;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.objeto.InfoAcaoEntidadeObjetoCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.TIPO_PARTE_URL;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.MB_paginaCadastroEntidades;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.reflexao.anotacoes.InfoPagina;
import com.super_bits.modulosSB.webPaginas.controller.servletes.urls.parametrosURL.InfoParametroURL;
import com.super_bits.modulosSB.webPaginas.controller.servletes.urls.parametrosURL.ParametroURL;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author salvio
 */
@InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_MB_GESTAO)
@ViewScoped
@Named
@InfoPagina(nomeCurto = "CRC_ATRIBUTO", tags = "Atributos de Entidade")
public class PgItemProjetoAtributo extends MB_paginaCadastroEntidades<AtributoDeEntidadeSimples> {

    @InfoParametroURL(nome = "prAtribEntidade", tipoParametro = TIPO_PARTE_URL.ENTIDADE,
            tipoEntidade = AtributoDeEntidadeSimples.class, representaEntidadePrincipalMB = true, obrigatorio = false)
    private ParametroURL prEntidadePrincipal;

    @PostConstruct
    public void inicio() {
        System.out.println("PgItemProjetoAtributo @PostConstruct " + System.identityHashCode(this)
                + " postback=" + FacesContext.getCurrentInstance().isPostback()
                + " viewState=" + FacesContext.getCurrentInstance().getExternalContext()
                        .getRequestParameterMap().get("javax.faces.ViewState"));

    }

    @PreDestroy
    public void fim() {
        System.out.println("PgItemProjetoAtributo @PreDestroy " + System.identityHashCode(this));

    }

}
