/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.projeto.paginas.projetoBuilder;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.entidade.FabAcaoCarameloDevComoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.entidade.InfoAcaoEntidadeObjetoCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaStatusProjCRC;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.TIPO_PARTE_URL;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.acoes.ComoAcaoSecundaria;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.MB_paginaCadastroEntidades;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.reflexao.anotacoes.InfoPagina;
import com.super_bits.modulosSB.webPaginas.controller.servletes.urls.parametrosURL.InfoParametroURL;
import com.super_bits.modulosSB.webPaginas.controller.servletes.urls.parametrosURL.ParametroURL;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author salvio
 */
@InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevComoItemProjeto.FABRICA_STATUS_MB_GESTAO)
@ViewScoped
@Named
@InfoPagina(nomeCurto = "CRC_FAB_STATUS", tags = "Fabricas de Status")
public class PgFabricaStatusProj extends MB_paginaCadastroEntidades<FabricaStatusProjCRC> {

    @InfoParametroURL(nome = "prAtribEntidade", tipoParametro = TIPO_PARTE_URL.ENTIDADE,
            tipoEntidade = FabricaStatusProjCRC.class, representaEntidadePrincipalMB = true, obrigatorio = false)
    private ParametroURL prEntidadePrincipal;

    @PostConstruct
    public void inicio() {
        List<ComoAcaoSecundaria> acoesVinc = getAcaoVinculada().getAcoesVinculadas();
        System.out.println(acoesVinc.size());
    }
}
