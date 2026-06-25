/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.implemetation.componenteNativo;

import br.org.carameloCode.erp.modulo.notificacao.api.ERPNotificacoes;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.DialogoNotificacaoUsrToUsr;
import br.org.carameloCode.erp.modulo.projeto.acoes.componente.formulario.FabAcaoProjetoCRCCarameloFormulario;
import br.org.carameloCode.erp.modulo.projeto.acoes.componente.formulario.InfoAcaoProjetoCRCFormularios;
import br.org.carameloCode.erp.modulo.projeto.acoes.componente.nativo.FabAcaoProjetoCRCComponenteNativo;
import br.org.carameloCode.erp.modulo.projeto.acoes.componente.nativo.InfoAcaoProjetoCRCComponenteNativo;
import br.org.carameloCode.erp.modulo.projeto.acoes.componente.notificacoes.FabAcaoProjetoCRCNotificacoes;
import br.org.carameloCode.erp.modulo.projeto.acoes.componente.notificacoes.InfoAcaoProjetoCRCNotificacoes;
import br.org.carameloCode.erp.modulo.projeto.entidadeTransient.ComunicacaoTransientDev;
import br.org.carameloCode.erp.modulo.projeto.entidadeTransient.ComunicacaoTransientUsrToUsrDev;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.ExemploComponente;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.entidadeExemplo.EntdExemplo;
import com.super_bits.modulos.SBAcessosModel.controller.resposta.RespostaComGestaoEMRegraDeNegocioPadrao;
import com.super_bits.modulosSB.Persistencia.dao.ControllerAbstratoSBPersistencia;
import com.super_bits.modulosSB.Persistencia.dao.ErroEmBancoDeDados;
import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfRespostaAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.TratamentoDeErros.ErroRegraDeNegocio;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ComunicacaoTransient;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ComunicacaoTransientUsrToUsr;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ERPTipoCanalComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.FabTipoComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.FabTipoRespostaComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ComoDialogo;
import com.super_bits.modulosSB.SBCore.modulos.erp.FabTipoCanalChat;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.ItensGenericos.basico.UsuarioAplicacaoEmExecucao;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ErroAcessandoCanalComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ErroDetectandoTelaBloqueio;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ErroRegistrandoDialogo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.coletivojava.fw.api.tratamentoErros.FabErro;

/**
 *
 * @author salvio
 */
public class ExecAcoesComponenteNativo extends ControllerAbstratoSBPersistencia {

    @InfoAcaoProjetoCRCComponenteNativo(acao = FabAcaoProjetoCRCComponenteNativo.COMPONENTE_NATIVO_CTR_COMPILAR_TAG_LIB_PADRAO)
    public static ItfRespostaAcaoDoSistema compilarTagLib(ExemploComponente pExemplo) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaResposta(ExemploComponente.class), null) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                // copiar pasta meta-inf
                //copiar pasta SBComp
                //compiar faces config
            }
        }.getResposta();

    }

    @InfoAcaoProjetoCRCNotificacoes(acao = FabAcaoProjetoCRCNotificacoes.NOTIFICACAO_TRANSITORIA_CTR_ENVIAR)
    public static ItfRespostaAcaoDoSistema notificacaoTransitoria(ComunicacaoTransientDev pExemplo) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaResposta(ExemploComponente.class), null) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                try {
                    ComoDialogo novacomunicacao = null;
                    if (pExemplo instanceof ComunicacaoTransientUsrToUsrDev) {
                        novacomunicacao = new ComunicacaoTransientUsrToUsr(((ComunicacaoTransientUsrToUsrDev) pExemplo).getRemetente(), pExemplo.getUsuarioDestinatario(), FabTipoComunicacao.OK_CANCELAR.getRegistro());
                    } else {
                        novacomunicacao = new ComunicacaoTransient(new UsuarioAplicacaoEmExecucao(), pExemplo.getUsuarioDestinatario(), FabTipoComunicacao.OK_CANCELAR.getRegistro());
                    }
                    novacomunicacao.setAssunto(pExemplo.getAssunto());
                    novacomunicacao.setMensagem(pExemplo.getMensagem());
                    String registroDeNotiicacao = CarameloCode.getServicoComunicacao().dispararComunicacao(novacomunicacao, ERPTipoCanalComunicacao.INTRANET_MENU);
                    if (registroDeNotiicacao == null) {
                        throw new ErroRegraDeNegocio("Falha registrando comunicação");
                    }

                } catch (ErroAcessandoCanalComunicacao ex) {
                    SBCore.RelatarErro(FabErro.SOLICITAR_REPARO, "Falha registrando comunicação ", ex);
                }
            }
        }.getResposta();

    }

    @InfoAcaoProjetoCRCFormularios(acao = FabAcaoProjetoCRCCarameloFormulario.CRUD_EXEMPLO_CTR_REMOVER)
    public static ItfRespostaAcaoDoSistema crudRemover(EntdExemplo pExemplo) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaResposta(EntdExemplo.class), null) {
            @Override
            public void executarAcoesFinais() throws ErroEmBancoDeDados {
                super.executarAcoesFinais();
            }

            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                System.out.println(pExemplo.getJustificativa(FabAcaoProjetoCRCCarameloFormulario.CRUD_EXEMPLO_CTR_REMOVER.getRegistro()));

                ComoDialogo exemploPergunta = CarameloCode.getServicoComunicacao().gerarComunicacaoSistema_Usuario(FabTipoComunicacao.PERGUNTAR_SIM_NAO_MAIS_TARDE,
                        CarameloCode.getUsuarioLogado(), "Exemplo mensagem codigo condicional com Notificações push");
                System.out.println(CarameloCode.getUsuarioLogado().getEmail());
                try {
                    CarameloCode.getServicoComunicacao().getArmazenamento().registrarDialogoAtivo(exemploPergunta);
                } catch (ErroRegistrandoDialogo ex) {
                    CarameloCode.RelatarErro(FabErro.SOLICITAR_REPARO, "Falha registrando comunicação", ex);
                }

                FabTipoRespostaComunicacao resposta;
                try {
                    resposta = CarameloCode.getServicoComunicacao()
                            .aguardarRespostaComunicacao(ERPTipoCanalComunicacao.INTRANET_BLOQUEIO_TELA.getRegistro(), exemploPergunta, 3000, FabTipoRespostaComunicacao.NAO_AUTORIZADO);
                } catch (ErroDetectandoTelaBloqueio ex) {
                    throw new ErroRegraDeNegocio("Falha Identicando tela de interfenção do usuário");
                }
                if (resposta.isRespostaPositiva()) {
                    removerEntidade(pExemplo);
                    addAlerta("Mensagem condicional positiva!");
                } else {
                    throw new ErroRegraDeNegocio("O Usuário desistiu, diante do exemplo de pergunta, olha que legal, posso criar regras de negócio que são executadas com interefência do usuário");
                }
            }
        }.getResposta();

    }

    @InfoAcaoProjetoCRCFormularios(acao = FabAcaoProjetoCRCCarameloFormulario.CRUD_EXEMPLO_CTR_SALVAR_MERGE)
    public static ItfRespostaAcaoDoSistema crudSalvar(EntdExemplo pExemplo) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaResposta(EntdExemplo.class), null) {
            @Override
            public void executarAcoesFinais() throws ErroEmBancoDeDados {
                super.executarAcoesFinais(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }

            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                setRetorno(pExemplo);
                List<EntdExemplo> exemplos = UtilSBPersistencia.getListaTodos(EntdExemplo.class, getEm());
                if (pExemplo.getId() == null) {
                    if (exemplos.size() < 10) {
                        setRetorno(atualizarEntidade(pExemplo));
                    } else {
                        addAlerta("Passou com sucesso, para fins de teste, mas sõ são permitidos 10 objetos de demonstração");
                    }
                } else {
                    if (UtilSBPersistencia.getRegistroByID(EntdExemplo.class, pExemplo.getId()) == null) {
                        //proteção contra tentativa de burlar o limite de entidades permitidas
                        throw new ErroRegraDeNegocio("Exemplo não encontrado");
                    }
                    setRetorno(atualizarEntidade(pExemplo));

                }

            }
        }.getResposta();

    }

}
