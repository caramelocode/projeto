/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.console;

import br.org.carameloCode.erp.modulo.projeto.console.texto.UtilConsoleCRCTexto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.ComoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.FabTipoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.RepositorioConsole;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.UtilProjCRCItemProjetoTexto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.super_bits.modulos.SBAcessosModel.model.ModuloAcaoSistema;
import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCListasObjeto;
import com.super_bits.modulosSB.SBCore.modulos.Controller.ErroChamadaController;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfRespostaAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.acoes.ComoAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ComoDialogo;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ERPTipoCanalComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.FabTipoComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.FabTipoRespostaComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ErroDetectandoTelaBloqueio;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.annotation.PostConstruct;
import org.coletivojava.fw.api.tratamentoErros.FabErro;

/**
 *
 * @author salvio
 */
@InfoObjetoSB(plural = "Consoles de projetos", tags = "Console de Projeto")
public class ConsoleCRCProjeto implements ComoConsoleCRCProjeto {

    private RepositorioConsole repositorio;

    private String textoDefinido;
    private String textoDica;
    private ModuloAcaoSistema modulo;
    private ProjetoCRC projetoSelecionado;
    private List<ProjetoCRC> projetos;
    private List<ItemOpcaoConsole> opcoesDisponiveis;
    private ItemOpcaoConsole opcaoSelecionada;

    private FabTipoItemProjeto tipoPesquisa = FabTipoItemProjeto.DESCONHECIDO;

    @Override
    public void carregarProjetos() {
        projetos = UtilSBPersistencia.getListaTodos(ProjetoCRC.class);
        if (projetos.size() == 1) {
            projetoSelecionado = projetos.get(0);
            carregarProjetoSelecionado();
        }
    }

    public void setTextoDefinido(String ptextoDefinido) {
        this.textoDefinido = UtilProjCRCItemProjetoTexto.getTextoNormatizado(ptextoDefinido);
        // A opção escolhida para o texto anterior não vale para o novo texto
        opcaoSelecionada = null;
        tipoPesquisa = FabTipoItemProjeto.getTipoItemPorTexto(textoDefinido);
        opcoesDisponiveis = tipoPesquisa.getOpcoesConsole(this);
    }

    @Override
    public void carregarProjetoSelecionado() {
        if (projetoSelecionado == null) {
            carregarProjetos();
        }
        repositorio = new RepositorioConsole(projetoSelecionado);
    }

    @Override
    public RepositorioConsole getRepositorio() {
        if (repositorio == null) {
            carregarProjetoSelecionado();
        }
        return repositorio;
    }

    @Override
    public String getJsonObjetoSelecionado() {
        return "";
    }

    @PostConstruct
    public void teste() {
        System.out.println("ok");

    }

    @Override
    public List<String> autocompletProjeto(String pValor) {
        textoDefinido = UtilProjCRCItemProjetoTexto.getTextoNormatizado(pValor);
        opcaoSelecionada = null;
        tipoPesquisa = FabTipoItemProjeto.getTipoItemPorTexto(textoDefinido);
        List<String> opcoesAutocomplet = tipoPesquisa.textosSugestaoAutocomplete(this, textoDefinido);
        textoDica = tipoPesquisa.getTextoDica();
        opcoesDisponiveis = tipoPesquisa.getOpcoesConsole(this);
        UtilCRCListasObjeto.ordernarPorCampo(opcoesDisponiveis, "ordem");
        UtilConsoleCRCTexto.imprimirPesquisa(this, opcoesAutocomplet);
        opcaoSelecionada = null;
        return opcoesAutocomplet;
    }

    @Override
    public String getTextoDefinido() {
        return textoDefinido;
    }

    public FabTipoItemProjeto getTipoPesquisa() {
        return tipoPesquisa;
    }

    @Override
    public String getTextoDica() {
        return textoDica;
    }

    public ItemOpcaoConsole getOpcaoSelecionada() {
        if (opcaoSelecionada == null) {
            opcaoSelecionada = getOpcaoPrincipalSugerida();
        }
        return opcaoSelecionada;
    }

    public void setOpcaoSelecionada(ItemOpcaoConsole opcaoSelecionada) {
        this.opcaoSelecionada = opcaoSelecionada;
    }

    @Override
    public ObjetoProjCRC getObjetoSelecionado() {
        if (getOpcaoSelecionada() == null) {
            return null;
        }
        if (getOpcaoSelecionada().getItemAssociado() instanceof ObjetoProjCRC) {
            return (ObjetoProjCRC) getOpcaoSelecionada().getItemAssociado();
        }
        if (getOpcaoSelecionada().getItemAssociado() instanceof AtributoDeEntidadeSimples) {
            return ((AtributoDeEntidadeSimples) getOpcaoSelecionada().getItemAssociado()).getEntidade();
        }
        if (getOpcaoSelecionada().getItemAssociado() instanceof AcaoProjCRC) {
            return ((AcaoProjCRC) getOpcaoSelecionada().getItemAssociado()).getEntidadeDominio();
        }
        return null;
    }

    /**
     * Primeira opção sugerida: a de menor ordem. Não depende da lista estar
     * ordenada (setTextoDefinido não ordena; autocompletProjeto ordena).
     *
     * @return null se não houver opções
     */
    @Override
    public ItemOpcaoConsole getOpcaoPrincipalSugerida() {
        return getOpcoesDisponiveis().stream()
                .min(Comparator.comparingInt(ItemOpcaoConsole::getOrdem))
                .orElse(null);
    }

    @Override
    public void executarOpcaoSelecionada() {
        if (opcaoSelecionada == null) {
            if (getOpcaoPrincipalSugerida() != null) {
                opcaoSelecionada = getOpcaoPrincipalSugerida();
            }
        }
        if (opcaoSelecionada == null) {
            if (false) {
                if (!getOpcoesDisponiveis().isEmpty()) {
                    if (getOpcoesDisponiveis().get(0).getAcaoAssociada() != null) {
                        ComoAcaoDoSistema acaoSugeridaConfigramcao = getOpcoesDisponiveis().get(0).getAcaoAssociada();
                        ComoItemProjeto itemSugestao = getOpcoesDisponiveis().get(0).getItemAssociado();
                        ComoDialogo exemploPergunta = CarameloCode.getServicoComunicacao().gerarComunicacaoSistema_Usuario(FabTipoComunicacao.PERGUNTAR_SIM_NAO_MAIS_TARDE,
                                CarameloCode.getUsuarioLogado(), "Quer executar a ação " + acaoSugeridaConfigramcao.getNomeAcao() + " com " + itemSugestao.getNome());
                        System.out.println(CarameloCode.getUsuarioLogado().getEmail());

                        FabTipoRespostaComunicacao resposta;
                        try {
                            resposta = CarameloCode.getServicoComunicacao()
                                    .aguardarRespostaComunicacao(ERPTipoCanalComunicacao.INTRANET_BLOQUEIO_TELA.getRegistro(), exemploPergunta, 3000, FabTipoRespostaComunicacao.NAO_AUTORIZADO);
                        } catch (ErroDetectandoTelaBloqueio ex) {
                            return;
                        }
                        if (resposta.isRespostaPositiva()) {

                            opcaoSelecionada = getOpcoesDisponiveis().get(0);

                        } else {
                            return;
                        }

                    } else {
                        return;
                    }

                }
            }
        }

        if (getOpcaoSelecionada() != null && getOpcaoSelecionada().getFabAcaoAssociada().getRegistro().isUmaAcaoController()) {
            ItfRespostaAcaoDoSistema resposta;
            try {
                if (getOpcaoSelecionada().getFabAcaoAssociada().getRegistro().isUmaAcaoController()) {
                    resposta = CarameloCode.getServicoController().getResposta(getOpcaoSelecionada().getFabAcaoAssociada(), getOpcaoSelecionada().getItemAssociado());
                    UtilConsoleCRCTexto.imprimirExecucao(getOpcaoSelecionada(), resposta, null);
                    if (!resposta.isSucesso()) {
                        resposta.dispararMensagens();

                    } else {
                        repositorio.recarregarRepositorio();
                        getOpcaoSelecionada().setItemAssociado((ComoItemProjeto) resposta.getRetorno());
                    }
                }
            } catch (ErroChamadaController ex) {
                UtilConsoleCRCTexto.imprimirExecucao(getOpcaoSelecionada(), null, "Erro chamando o controller: " + ex.getMessage());
                CarameloCode.RelatarErro(FabErro.SOLICITAR_REPARO, "Falha inicializando sistema", ex);
            }

        } else {
            UtilConsoleCRCTexto.imprimirExecucao(getOpcaoSelecionada(), null,
                    "Nada executado: o console só executa ações de controller (formulários são abertos pela view)");
        }

    }

    @Override
    public List<ItemOpcaoConsole> getOpcoesDisponiveis() {
        if (opcoesDisponiveis == null) {
            return new ArrayList<>();
        }
        return opcoesDisponiveis;

    }

    public ModuloAcaoSistema getModulo() {
        return modulo;
    }

    public void setModulo(ModuloAcaoSistema modulo) {
        this.modulo = modulo;
    }

    @Override
    public ProjetoCRC getProjetoSelecionado() {
        if (repositorio != null) {
            return repositorio.getProjeto();
        }
        return projetoSelecionado;
    }

    public void setProjetoSelecionado(ProjetoCRC projetoSelecionado) {
        if (repositorio == null) {
            repositorio = new RepositorioConsole(projetoSelecionado);
        } else {
            if (!projetoSelecionado.getId().equals(repositorio.getProjeto().getId())) {
                repositorio.fecharRepositorio();
                repositorio = new RepositorioConsole(projetoSelecionado);
            }
        }
        this.projetoSelecionado = projetoSelecionado;

    }

    public List<ProjetoCRC> getProjetos() {
        return projetos;
    }

}
