/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.carameloCode.erp.modulo.projeto.config;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.DialogoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.statusNotificacao.FabStatusNotificacao;
import br.org.carameloCode.erp.modulo.projeto.FabModulosProjetoCaramelo;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.FabExemploComponenteNativo;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.FabExemplosOpcoesItensSelecao;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.FabGrupoUsrProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.FabTipoNotificacaoProjetoCRCTeste;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.FabUsuarioPadraoProjeto;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.ItfConfigSBPersistencia;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCDataHora;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ComunicacaoAcaoSistema;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ComunicacaoTransient;
import com.super_bits.modulosSB.SBCore.modulos.fabrica.ComoFabrica;
import com.super_bits.modulosSB.SBCore.modulos.geradorCodigo.model.EstruturaDeEntidade;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.ItensGenericos.basico.UsuarioSistemaRoot;
import com.super_bits.modulosSB.SBCore.modulos.objetos.MapaObjetosProjetoAtual;
import com.super_bits.modulosSB.SBCore.modulos.objetos.dialogo.resposta.BotaoResposta;
import com.super_bits.modulosSB.SBCore.modulos.objetos.dialogo.resposta.RespostaComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.dialogo.tipoResposta.TipoRespostaComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.view.modeloFormulario.ModeloPagina;

/**
 *
 * @author Salvio
 */
public class ConfigPersistenciaProjetoCaramelo implements ItfConfigSBPersistencia {

    @Override
    public String bancoPrincipal() {
        return "projetoCaramelo";
    }

    @Override
    public String[] bancosExtra() {
        return new String[0];
    }

    @Override
    public String formatoDataBanco() {
        return UtilCRCDataHora.datahoraSistemaFr.toString();
    }

    @Override
    public String formatoDataUsuario() {
        return UtilCRCDataHora.horaUsuarioFr.toString();
    }

    @Override
    public String pastaImagensJPA() {
        return "/img";
    }

    @Override
    public void criarBancoInicial() {

    }

    @Override
    public Class<? extends ComoFabrica>[] fabricasRegistrosIniciais() {
        MapaObjetosProjetoAtual.adcionarObjeto(UsuarioSistemaRoot.class);
        MapaObjetosProjetoAtual.adcionarObjeto(ComunicacaoTransient.class);
        MapaObjetosProjetoAtual.adcionarObjeto(ComunicacaoAcaoSistema.class);
        MapaObjetosProjetoAtual.adcionarObjeto(EstruturaDeEntidade.class);
        MapaObjetosProjetoAtual.adcionarObjeto(ModeloPagina.class);
        MapaObjetosProjetoAtual.adcionarObjeto(DialogoNotificacao.class);
        MapaObjetosProjetoAtual.adcionarObjeto(RespostaComunicacao.class);
        MapaObjetosProjetoAtual.adcionarObjeto(TipoRespostaComunicacao.class);
        MapaObjetosProjetoAtual.adcionarObjeto(BotaoResposta.class);
        return new Class[]{ //    FabAtividadeCRMAutoexecucao.class
            FabExemplosOpcoesItensSelecao.class,
            FabExemploComponenteNativo.class,
            FabModulosProjetoCaramelo.class,
            FabStatusNotificacao.class,
            FabGrupoUsrProjeto.class,
            FabUsuarioPadraoProjeto.class,
            FabTipoNotificacaoProjetoCRCTeste.class

        };

    }

}
