/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.projeto.paginas;

import br.org.carameloCode.erp.modulo.projeto.acoes.componente.notificacoes.FabAcaoProjetoCRCNotificacoes;
import br.org.carameloCode.erp.modulo.projeto.acoes.componente.notificacoes.InfoAcaoProjetoCRCNotificacoes;
import br.org.carameloCode.erp.modulo.projeto.entidadeTransient.ComunicacaoTransientDev;
import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.MB_paginaCadastroEntidades;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.reflexao.anotacoes.InfoPagina;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author salvio
 */
@ViewScoped
@Named
@InfoPagina(nomeCurto = "NTFT", tags = "Testes notificação Transitória")
@InfoAcaoProjetoCRCNotificacoes(acao = FabAcaoProjetoCRCNotificacoes.NOTIFICACAO_TRANSITORIA_MB_GESTAO)
public class PgNotificacaoTransiente extends MB_paginaCadastroEntidades<ComunicacaoTransientDev> {

    @PostConstruct
    public void inicio() {

    }

    @Override
    protected void autoexecEntidadeNova() {

        super.autoexecEntidadeNova();
    }

}
