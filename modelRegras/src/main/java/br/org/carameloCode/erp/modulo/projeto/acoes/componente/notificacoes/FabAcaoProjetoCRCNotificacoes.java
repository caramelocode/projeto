package br.org.carameloCode.erp.modulo.projeto.acoes.componente.notificacoes;

import br.org.carameloCode.erp.modulo.projeto.FabModulosProjetoCaramelo;
import br.org.carameloCode.erp.modulo.projeto.InfoModuloProjetoCaraelo;
import br.org.carameloCode.erp.modulo.projeto.entidadeTransient.ComunicacaoTransientDev;
import br.org.carameloCode.erp.modulo.projeto.entidadeTransient.ComunicacaoTransientUsrToUsrDev;
import com.super_bits.modulos.SBAcessosModel.fabricas.ComoFabricaDeAcoesPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.acoes.estadoFormulario.FabEstadoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoController;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoGestaoEntidade;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.FabTipoComunicacao;

/**
 *
 * @author salvio
 */
@InfoModuloProjetoCaraelo(modulo = FabModulosProjetoCaramelo.CARAMELO_DEV)
public enum FabAcaoProjetoCRCNotificacoes implements ComoFabricaDeAcoesPersistencia {

    @InfoTipoAcaoGestaoEntidade(entidade = ComunicacaoTransientDev.class, icone = "fa fa-bell-o ", nomeAcao = "Notificações")
    NOTIFICACAO_TRANSITORIA_MB_GESTAO,
    @InfoTipoAcaoFormulario(icone = "fa fa-exclamation-triangle", entidade = ComunicacaoTransientDev.class,
            estadoFormulario = FabEstadoFormulario.NOVO, nomeAcao = "Execução Ação")
    NOTIFICACAO_TRANSITORIA_FRM_REL_ACAO_DO_SISTEMA,
    @InfoTipoAcaoController(comunicacao = FabTipoComunicacao.PERGUNTAR_SIM_NAO_IGNORAR, descricao = "Confirma o envio de : [assunto]")
    NOTIFICACAO_TRANSITORIA_CTR_REL_ACAO_DO_SISTEMA,
    @InfoTipoAcaoFormulario(icone = "fa fa-bell-o", estadoFormulario = FabEstadoFormulario.NOVO, nomeAcao = "Sistema para Usuário", entidade = ComunicacaoTransientDev.class)
    NOTIFICACAO_TRANSITORIA_FRM_ENVIAR_MENU_SISTEMA_USR,
    @InfoTipoAcaoFormulario(icone = "fa fa-comments-o", estadoFormulario = FabEstadoFormulario.NOVO, nomeAcao = "Usuario para Usuário", entidade = ComunicacaoTransientUsrToUsrDev.class)
    NOTIFICACAO_TRANSITORIA_FRM_ENVIAR_MENU_USR_TO_USR,
    @InfoTipoAcaoController(icone = "fa fa-paper-plane-o", entidade = ComunicacaoTransientDev.class)
    NOTIFICACAO_TRANSITORIA_CTR_ENVIAR;

}
