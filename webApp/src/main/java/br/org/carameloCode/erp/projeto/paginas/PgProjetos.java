/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.projeto.paginas;

import br.org.carameloCode.erp.modulo.projeto.acoes.projetoCarameloBuilder.projeto.FabAcaoProjetoCRCProjetoCaramelo;
import br.org.carameloCode.erp.modulo.projeto.acoes.projetoCarameloBuilder.projeto.InfoAcaoProjetoCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.MB_paginaCadastroEntidades;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.reflexao.anotacoes.InfoPagina;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author salvio
 */
@InfoAcaoProjetoCRCProjeto(acao = FabAcaoProjetoCRCProjetoCaramelo.PROJETO_MB_GESTAO)
@ViewScoped
@Named
@InfoPagina(nomeCurto = "Projeto Caramelo Code", tags = "Projetos crc")
public class PgProjetos extends MB_paginaCadastroEntidades<ProjetoCRC> {

}
