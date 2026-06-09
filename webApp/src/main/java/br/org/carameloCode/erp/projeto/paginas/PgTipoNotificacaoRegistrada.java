/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.projeto.paginas;

import br.org.carameloCode.erp.modulo.notificacao.api.FabAcaoNotificacaoPadraoSB;
import br.org.carameloCode.erp.modulo.notificacao.api.InfoAcaoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.fabricaSoftware.usuario.UsuarioDevProjCRC;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.MB_paginaCadastroEntidades;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.reflexao.anotacoes.InfoPagina;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author salvio
 */
@Named
@SessionScoped
@InfoAcaoNotificacao(acao = FabAcaoNotificacaoPadraoSB.TIPO_NOTIFICACAO_MB_GESTAO)
@InfoPagina(nomeCurto = "TPNTR", tags = "Tipo notificação registrada")
public class PgTipoNotificacaoRegistrada extends MB_paginaCadastroEntidades<TipoNotificacao> {

}
