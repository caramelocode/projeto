package br.org.carameloCode.erp.projeto.paginas.projetoBuilder;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.projeto.FabAcaoCarameloDevProjetoCRC;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.projeto.InfoAcaoProjetoCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.requisito.RequisitoDeProjeto;
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
@InfoAcaoProjetoCRCProjeto(acao = FabAcaoCarameloDevProjetoCRC.REQUISITO_MB_GESTAO)
@ViewScoped
@Named
@InfoPagina(nomeCurto = "CRC_REQUISITO", tags = "Requisitos do Projeto")
public class PgRequisito extends MB_paginaCadastroEntidades<RequisitoDeProjeto> {

    @InfoParametroURL(nome = "prRequisito", tipoParametro = TIPO_PARTE_URL.ENTIDADE,
            tipoEntidade = RequisitoDeProjeto.class, representaEntidadePrincipalMB = true, obrigatorio = false)
    private ParametroURL prEntidadePrincipal;

}
