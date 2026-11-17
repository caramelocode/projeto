/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.projeto.paginas.demonstracao;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.console.FabAcaoCarameloDevConsoleCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.console.InfoAcaoProjetoCRCConsole;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
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
@InfoAcaoProjetoCRCConsole(acao = FabAcaoCarameloDevConsoleCRCProjeto.CONSOLE_ITEM_PROJ_MB_GESTAO)
@InfoPagina(nomeCurto = "CRC_CONSOLE", tags = "Console de Projeto CarameloCODE")
public class PgConsoleProjetoCRC extends MB_paginaCadastroEntidades<ObjetoProjCRC> {

}
