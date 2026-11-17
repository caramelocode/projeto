/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.projeto.paginas.projetoBuilder;

import br.org.carameloCode.erp.modulo.projeto.console.ConsoleCRCProjeto;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author salvio
 */
@Named
@SessionScoped
public class ServicoConsoleProjeto implements Serializable {

    private ConsoleCRCProjeto console = new ConsoleCRCProjeto();

    public ConsoleCRCProjeto getConsole() {
        return console;
    }

}
