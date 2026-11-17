/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.projeto.config;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author salvio
 */
@WebListener
public class ConfigLimiteViewScopedListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Mojarra javax.faces 2.4.0 só lê o limite de @ViewScoped ativos deste atributo de sessão (padrão 25)
        Object teste = se.getSession().getAttribute("com.sun.faces.application.view.activeViewMapsSize");
        se.getSession().setAttribute("com.sun.faces.application.view.activeViewMapsSize", Integer.valueOf(25));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
