/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.projeto.paginas;

import br.org.carameloCode.erp.modulo.projeto.acoes.componente.nativo.FabAcaoProjetoCRCComponenteNativo;
import br.org.carameloCode.erp.modulo.projeto.acoes.componente.nativo.InfoAcaoProjetoCRCComponenteNativo;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ComunicacaoTransient;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.FabTipoComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.ItensGenericos.basico.UsuarioAplicacaoEmExecucao;
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
@InfoAcaoProjetoCRCComponenteNativo(acao = FabAcaoProjetoCRCComponenteNativo.NOTIFICACAO_TRANSITORIA_MB_GESTAO)
@InfoPagina(nomeCurto = "NTFT", tags = "Testes notificação Transitória")
public class PgNotificacaoTransiente extends MB_paginaCadastroEntidades<ComunicacaoTransient> {

    @PostConstruct
    public void inicio() {

    }

    @Override
    protected void autoexecEntidadeNova() {
        ComunicacaoTransient novacomunicacao = new ComunicacaoTransient(new UsuarioAplicacaoEmExecucao(), CarameloCode.getUsuarioLogado(), FabTipoComunicacao.OK_CANCELAR.getRegistro());
        System.out.println(novacomunicacao.getMensgem());
        System.out.println(novacomunicacao.getAssunto());
        setEntidadeSelecionada(novacomunicacao);
    }

}
