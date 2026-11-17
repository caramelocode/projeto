/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.console;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.RepositorioConsole;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import java.util.List;

/**
 *
 * @author salvio
 */
public interface ComoConsoleCRCProjeto {

    public String getTextoDefinido();

    public ObjetoProjCRC getObjetoSelecionado();

    public ProjetoCRC getProjetoSelecionado();

    public List<String> autocompletProjeto(String pValor);

    public void carregarProjetoSelecionado();

    public void carregarProjetos();

    public String getJsonObjetoSelecionado();

    public String getTextoDica();

    public List<ItemOpcaoConsole> getOpcoesDisponiveis();

    public ItemOpcaoConsole getOpcaoPrincipalSugerida();

    public RepositorioConsole getRepositorio();

    public void executarOpcaoSelecionada();

}
