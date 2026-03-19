package br.org.carameloCode.erp.crm.paginas;

import br.org.carameloCode.erp.modulo.projeto.acoes.componente.nativo.FabAcaoProjetoCRCComponenteNativo;
import br.org.carameloCode.erp.modulo.projeto.acoes.componente.nativo.InfoAcaoProjetoCRCComponenteNativo;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.ExemploComponente;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.ExemploComponenteInput;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCStringFiltros;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCStringSlugs;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.TIPO_PARTE_URL;
import com.super_bits.modulosSB.SBCore.modulos.view.fabricasCompVisual.ComoComponenteVisualSB;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.declarados.ConstAppFormEComponente.contantesView.LayoutInputCampo;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.MB_paginaCadastroEntidades;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.reflexao.anotacoes.InfoPagina;
import com.super_bits.modulosSB.webPaginas.controller.servletes.urls.parametrosURL.InfoParametroURL;
import com.super_bits.modulosSB.webPaginas.controller.servletes.urls.parametrosURL.ParametroURL;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author salvio
 */
@ViewScoped
@Named
@InfoAcaoProjetoCRCComponenteNativo(acao = FabAcaoProjetoCRCComponenteNativo.COMPONENTE_NATIVO_MB_GESTAO)
@InfoPagina(nomeCurto = "CARAMELO_COMP", tags = "Componente Nativo Caramelo Code")
public class PgComponentesJsf extends MB_paginaCadastroEntidades<ExemploComponente> {

    private List<ComoComponenteVisualSB> tiposVisualizacaoDisponivel = new ArrayList<>();
    private ComoComponenteVisualSB tipoVisualizacaoSelecionada;
    private boolean atualizarIdVisualizacao = true;

    @InfoParametroURL(nome = "PrExemplo", tipoParametro = TIPO_PARTE_URL.ENTIDADE, tipoEntidade = ExemploComponenteInput.class, representaEntidadePrincipalMB = true, obrigatorio = false)
    private ParametroURL pr;

    @PostConstruct
    public void inicio() {
        LayoutInputCampo input = new LayoutInputCampo();
        tiposVisualizacaoDisponivel.add(input.getEsquerda());
        tiposVisualizacaoDisponivel.add(input.getResumido());
        tiposVisualizacaoDisponivel.add(input.getSemLabel());
        tiposVisualizacaoDisponivel.add(input.getSuperior());
        tipoVisualizacaoSelecionada = input.getEsquerda();
    }

    public ComoComponenteVisualSB getTipoVisualizacaoSelecionada() {
        return tipoVisualizacaoSelecionada;
    }

    public void setTipoVisualizacaoSelecionada(ComoComponenteVisualSB tipoVisualizacaoSelecionada) {
        this.tipoVisualizacaoSelecionada = tipoVisualizacaoSelecionada;
    }

    @Override
    public void setEntidadeSelecionada(ExemploComponente entidadeSelecionada) {
        super.setEntidadeSelecionada(entidadeSelecionada);
    }

    public String getCodigoExemplo() {
        return "<ui:composition\n"
                + "    xmlns=\"http://www.w3.org/1999/xhtml\"\n"
                + "    xmlns:h=\"http://xmlns.jcp.org/jsf/html\"\n"
                + "    xmlns:CRCCpInst=\"http://xmlns.jcp.org/jsf/composite/SBComp/composite/atributoEntidade\"\n"
                + "    xmlns:CRCInput=\"http://xmlns.jcp.org/jsf/composite/SBComp/composite/input\"\n"
                + "    xmlns:ui=\"http://xmlns.jcp.org/jsf/facelets\"\n"
                + "    xmlns:pe=\"http://primefaces.org/ui/extensions\"\n"
                + "    template=\"#{layoutsPaginas.conteudoEmBranco.xhtmlVinculado}\"\n"
                + "    xmlns:p=\"http://primefaces.org/ui\"\n"
                + "    xmlns:f=\"http://xmlns.jcp.org/jsf/core\"> \n\n"
                + ""
                + "<CRCInput:input campoInstanciado=\"#{pgComponentesJsf.entidadeSelecionada.getCampoInstanciadoByNomeOuAnotacao(\"" + UtilCRCStringFiltros.filtrarApenasLetraSemEspacos(getEntidadeSelecionada().getNome()) + "\"')}\"\n"
                + "                                    layout=\"#{layoutsComponenteSB.layoutCampo." + tipoVisualizacaoSelecionada.getNomeComponente().toLowerCase() + "}\"\n"
                + "                                    idAtualizarOnChange=\"exibicaoValor\"\n"
                + "                                    /> \n\n"
                + "  <h:painelGroup id=\"exibicaoValor\"  layout=block> \n"
                + "   <CRCInput:input campoInstanciado=\"#{pgComponentesJsf.entidadeSelecionada.getCampoInstanciadoByNomeOuAnotacao(\"" + UtilCRCStringFiltros.filtrarApenasLetraSemEspacos(getEntidadeSelecionada().getNome()) + "\"')}\"\n"
                + "   desabilitarEdicao=\"true\"  /> \n "
                + "  </h:painelGroup> "
                + ""
                + ""
                + ""
                + "";

    }

    public List<ComoComponenteVisualSB> getTiposVisualizacaoDisponivel() {
        return tiposVisualizacaoDisponivel;
    }

}
