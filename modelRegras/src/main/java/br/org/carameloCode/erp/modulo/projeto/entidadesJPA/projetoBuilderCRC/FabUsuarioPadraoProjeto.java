/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.cliente.UsuarioCliente;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.fabricaSoftware.usuario.UsuarioDevProjCRC;
import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.Persistencia.fabrica.ComoFabricaComPersistencia;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCStringGerador;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoDaFabrica;

/**
 *
 * @author salvio
 */
public enum FabUsuarioPadraoProjeto implements ComoFabricaComPersistencia {

    @InfoObjetoDaFabrica(id = 1l, nomeObjeto = "Admin de Projetos", classeObjeto = UsuarioDevProjCRC.class)
    USUARIO_ADMIN,
    @InfoObjetoDaFabrica(id = 2l, nomeObjeto = "Desenvolvedor", classeObjeto = UsuarioDevProjCRC.class)
    USUARIO_DEV,
    @InfoObjetoDaFabrica(id = 3l, nomeObjeto = "Cliente", classeObjeto = UsuarioCliente.class)
    USUARIO_CLIENTE,
    @InfoObjetoDaFabrica(id = 4l, nomeObjeto = "Admin Plataforma", classeObjeto = UsuarioSB.class)
    USUARIO_ADMIN_PLATAFORMA;

    @Override
    public Object getRegistro() {
        UsuarioSB usuario = (UsuarioSB) ComoFabricaComPersistencia.super.getRegistro();
        usuario.setSenha(UtilCRCStringGerador.getStringRandomicaUUID());
        switch (this) {

            case USUARIO_ADMIN:
                usuario.setGrupo(FabGrupoUsrProjeto.ADMIN_FABRICA.getRegistro());
                usuario.setEmail("salvio@superbits.com.br");
                break;
            case USUARIO_DEV:
                usuario.setGrupo(FabGrupoUsrProjeto.DEV.getRegistro());
                usuario.setEmail("salvio@caramelocode.com.br");
                usuario.setSenha("123");
                break;
            case USUARIO_CLIENTE:
                usuario.setGrupo(FabGrupoUsrProjeto.CLIENTE.getRegistro());
                usuario.setEmail("plataforma@casanovadigital.com.br");
                break;
            case USUARIO_ADMIN_PLATAFORMA:
                usuario.setGrupo(FabGrupoUsrProjeto.ADMIN_PLATAFORMA.getRegistro());
                usuario.setEmail("plataforma@caramelocode.com.br");
                break;
            default:
                throw new AssertionError();
        }
        return usuario;

    }

}
