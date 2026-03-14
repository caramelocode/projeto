package br.org.carameloCode.erp.crm.paginas;

import br.org.carameloCode.erp.modulo.projeto.acoes.componente.nativo.FabAcaoProjetoCRCComponenteNativo;
import br.org.carameloCode.erp.modulo.projeto.acoes.componente.nativo.InfoAcaoProjetoCRCComponenteNativo;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.ExemploComponente;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.ExemploComponenteInput;
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
@ViewScoped
@Named
@InfoAcaoProjetoCRCComponenteNativo(acao = FabAcaoProjetoCRCComponenteNativo.COMPONENTE_NATIVO_MB_GESTAO)
@InfoPagina(nomeCurto = "CARAMELO_COMP", tags = "Componente Nativo Caramelo Code")
public class PgComponentesJsf extends MB_paginaCadastroEntidades<ExemploComponente> {

    @InfoParametroURL(nome = "PrExemplo", tipoParametro = TIPO_PARTE_URL.ENTIDADE, tipoEntidade = ExemploComponenteInput.class, representaEntidadePrincipalMB = true, obrigatorio = false)
    private ParametroURL pr;

    @PostConstruct
    public void inicio() {

    }

    @Override
    public void setEntidadeSelecionada(ExemploComponente entidadeSelecionada) {
        super.setEntidadeSelecionada(entidadeSelecionada); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
