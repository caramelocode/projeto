/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.projeto.paginas;

import br.org.carameloCode.erp.modulo.projeto.acoes.componente.formulario.FabAcaoProjetoCRCCarameloFormulario;
import br.org.carameloCode.erp.modulo.projeto.acoes.componente.formulario.InfoAcaoProjetoCRCFormularios;
import com.super_bits.modulosSB.SBCore.modulos.view.modeloFormulario.ModeloPagina;
import com.super_bits.modulosSB.webPaginas.JSFBeans.SBBeanModel.modelosPagina.FabModelosPagina;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.MB_paginaCadastroEntidades;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.reflexao.anotacoes.InfoPagina;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author salvio
 */
@Named
@ViewScoped
@InfoAcaoProjetoCRCFormularios(acao = FabAcaoProjetoCRCCarameloFormulario.FORMMULARIO_PERSONALIZADO_MB_GESTAO)
@InfoPagina(nomeCurto = "MODPAGE", tags = "Modelos de Páginas")
public class PgModelosPagina extends MB_paginaCadastroEntidades<ModeloPagina> {

    @Override
    protected void listarDados(boolean mostrarInativos) {
        List<ModeloPagina> modelos = new ArrayList<>();
        for (FabModelosPagina mod : FabModelosPagina.values()) {
            modelos.add(mod.getRegistro());
        }
        setEntidadesListadas(modelos);
    }

}
