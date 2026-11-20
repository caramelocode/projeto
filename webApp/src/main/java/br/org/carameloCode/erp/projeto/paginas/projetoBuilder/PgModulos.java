package br.org.carameloCode.erp.projeto.paginas.projetoBuilder;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.projeto.FabAcaoCarameloDevProjetoCRC;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.projeto.InfoAcaoProjetoCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.modulo.ModuloProjCRC;
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
@InfoAcaoProjetoCRCProjeto(acao = FabAcaoCarameloDevProjetoCRC.MODULO_MB_GESTAO)
@ViewScoped
@Named
@InfoPagina(nomeCurto = "CRC_MODULO", tags = "Módulos do Projeto")
public class PgModulos extends MB_paginaCadastroEntidades<ModuloProjCRC> {

    @InfoParametroURL(nome = "prModulo", tipoParametro = TIPO_PARTE_URL.ENTIDADE,
            tipoEntidade = ModuloProjCRC.class, representaEntidadePrincipalMB = true, obrigatorio = false)
    private ParametroURL prEntidadePrincipal;

}
