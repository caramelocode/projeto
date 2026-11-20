/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC;

import br.org.carameloCode.erp.modulo.projeto.FabModulosProjetoCaramelo;
import br.org.carameloCode.erp.modulo.projeto.acoes.demonstracao.nativo.FabAcaoProjetoCRCComponenteNativo;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.projeto.FabAcaoCarameloDevProjetoCRC;
import br.org.carameloCode.erp.modulo.projeto.acoes.cliente.FabAcaoCliente;
import com.super_bits.modulos.SBAcessosModel.model.GrupoUsuarioSB;
import com.super_bits.modulosSB.Persistencia.fabrica.ComoFabricaComPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoDaFabrica;

/**
 *
 * @author salvio
 */
public enum FabGrupoUsrProjeto implements ComoFabricaComPersistencia {

    @InfoObjetoDaFabrica(classeObjeto = GrupoUsuarioSB.class, id = 1L)
    ADMIN_FABRICA,
    @InfoObjetoDaFabrica(classeObjeto = GrupoUsuarioSB.class, id = 2L)
    DEV,
    @InfoObjetoDaFabrica(classeObjeto = GrupoUsuarioSB.class, id = 3L)
    CLIENTE,
    @InfoObjetoDaFabrica(classeObjeto = GrupoUsuarioSB.class, id = 4L)
    ADMIN_PLATAFORMA;

    @Override
    public GrupoUsuarioSB getRegistro() {

        GrupoUsuarioSB grupo = (GrupoUsuarioSB) ComoFabricaComPersistencia.super.getRegistro();
        switch (this) {

            case DEV:
                grupo.setPaginaInicial(FabAcaoProjetoCRCComponenteNativo.COMPONENTE_NATIVO_MB_GESTAO);
                grupo.setModuloPrincipal(FabModulosProjetoCaramelo.CARAMELO_DEV.getRegistro());
                break;
            case CLIENTE:
                grupo.setPaginaInicial(FabAcaoCliente.REQUISITO_MB_GESTAO);
                grupo.setModuloPrincipal(FabModulosProjetoCaramelo.CLIENTE.getRegistro());
                break;
            case ADMIN_FABRICA:
                grupo.setPaginaInicial(FabAcaoCarameloDevProjetoCRC.PROJETO_MB_GESTAO);
                grupo.setModuloPrincipal(FabModulosProjetoCaramelo.CARAMELO_DEV_ADMIN.getRegistro());
                break;
            case ADMIN_PLATAFORMA:
                grupo.setPaginaInicial(FabAcaoCarameloDevProjetoCRC.PROJETO_MB_GESTAO);
                grupo.setModuloPrincipal(FabModulosProjetoCaramelo.PLATAFORMA_ADMIN.getRegistro());
                break;
            default:
                throw new AssertionError();
        }
        return grupo;
    }

}
