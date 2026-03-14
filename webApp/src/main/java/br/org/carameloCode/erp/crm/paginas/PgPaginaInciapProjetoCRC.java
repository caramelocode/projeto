/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.crm.paginas;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.usuario.UsuarioDevProjCRC;
import com.super_bits.modulos.SBAcessosModel.view.FabAcaoPaginasDoSistema;
import com.super_bits.modulos.SBAcessosModel.view.InfoAcaoPaginaDoSistema;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.MB_paginaCadastroEntidades;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.reflexao.anotacoes.InfoPagina;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author salvio
 */
@Named
@SessionScoped
@InfoAcaoPaginaDoSistema(acao = FabAcaoPaginasDoSistema.PAGINA_NATIVA_HOME_MB_PADRAO)
@InfoPagina(nomeCurto = "Home", tags = "Projeto Caramelo Code")
public class PgPaginaInciapProjetoCRC extends MB_paginaCadastroEntidades<UsuarioDevProjCRC> {

    @PostConstruct
    public void inicio() {
        executaAcaoSelecionadaPorEnum(FabAcaoPaginasDoSistema.PAGINA_NATIVA_HOME_FRM_LOGIN_PADRAO);
    }

}
