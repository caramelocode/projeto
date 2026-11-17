package br.org.carameloCode.erp.projeto.paginas.projetoBuilder;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.entidade.FabAcaoCarameloDevComoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.entidade.InfoAcaoEntidadeObjetoCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
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
@InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevComoItemProjeto.ENTIDADE_MB_GESTAO)
@ViewScoped
@Named
@InfoPagina(nomeCurto = "CRC_ENTIDADE", tags = "Entidades do Projeto")
public class PgItemProjetoEntidade extends MB_paginaCadastroEntidades<ObjetoProjCRC> {

    @InfoParametroURL(nome = "PrEntidade", tipoParametro = TIPO_PARTE_URL.ENTIDADE, tipoEntidade = ObjetoProjCRC.class, representaEntidadePrincipalMB = true, obrigatorio = false)
    private ParametroURL prEntidadePrincipal;

}
