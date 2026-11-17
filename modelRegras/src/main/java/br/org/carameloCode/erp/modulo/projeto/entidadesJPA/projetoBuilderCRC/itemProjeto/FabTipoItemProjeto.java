/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.acao.FabAcaoCarameloDevAcaoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.entidade.FabAcaoCarameloDevComoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.console.ConsoleCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.console.ItemOpcaoConsole;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRCContoller;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRCFormulario;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRCGestao;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.UtilProjCRCNomeAcao;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.FabTiposEntidade;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeEntidade;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeLista;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaEntidadeProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaStatusProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.ItemFabrica;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.ItemFabricaStatus;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.UtilProjCRCNomeFabrica;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.super_bits.modulosSB.SBCore.modulos.fabrica.ComoFabrica;
import jakarta.json.JsonObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Optional;
import java.util.stream.Collectors;

import org.coletivojava.fw.api.tratamentoErros.ErroPreparandoObjeto;

/**
 *
 * @author salvio
 */
public enum FabTipoItemProjeto implements ComoFabrica {

    OBJETO,
    ATRIBUTO_OBJETO,
    ACAO,
    REQUISITO,
    COMPONENTE_VISUAL,
    FABRICA_STATUS,
    FABRICA_GRUPO_USUARIOS,
    FABRICA_ENTIDADE_GENERICA,
    FABRICA_MODULOS,
    FLUXO_TESTES,
    DESCONHECIDO;

    public static final String SEPARADOR_ATRIBUTO = ".";

    /**
     * Tipo do atributo criado com Entidade.atributo. (objeto).
     */
    public static final FabTipoAtributoObjeto TIPO_NOVO_ATRIBUTO_OBJETO = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA;
    /**
     * Tipo do atributo criado com Entidade.atributo[] (lista).
     */
    public static final FabTipoAtributoObjeto TIPO_NOVO_ATRIBUTO_LISTA = FabTipoAtributoObjeto.LISTA_OBJETOS_PUBLICOS;

    /**
     * Cores do tipo de item: {padrão, discreta, destaque}. Todas as fábricas
     * usam a mesma cor.
     */
    private String[] getCores() {
        switch (this) {
            case OBJETO:
                return new String[]{"#2563EB", "#60A5FA", "#1E3A8A"}; // azul
            case ATRIBUTO_OBJETO:
                return new String[]{"#0891B2", "#22D3EE", "#164E63"}; // ciano
            case ACAO:
                return new String[]{"#7C3AED", "#A78BFA", "#4C1D95"}; // violeta
            case REQUISITO:
                return new String[]{"#16A34A", "#4ADE80", "#14532D"}; // verde
            case COMPONENTE_VISUAL:
                return new String[]{"#DB2777", "#F472B6", "#831843"}; // rosa
            case FABRICA_STATUS:
            case FABRICA_GRUPO_USUARIOS:
            case FABRICA_MODULOS:
            case FABRICA_ENTIDADE_GENERICA:
                return new String[]{"#D97706", "#FBBF24", "#78350F"}; // âmbar
            case FLUXO_TESTES:
                return new String[]{"#DC2626", "#F87171", "#7F1D1D"}; // vermelho
            case DESCONHECIDO:
                return new String[]{"#4B5563", "#9CA3AF", "#1F2937"}; // cinza
            default:
                throw new AssertionError(this);
        }
    }

    public String getCorPadrao() {
        return getCores()[0];
    }

    public String getCorDiscreta() {
        return getCores()[1];
    }

    public String getCorDestaque() {
        return getCores()[2];
    }

    public String getTextoDica() {

        switch (this) {

            case OBJETO:
                return "Escreva o nome de um Entidade existente, ou o nome de uma nova Entidade, para editar ou Criar um novo atributo, escreva Entidade.nomeAtributo";

            case ATRIBUTO_OBJETO:
                return "Escreva o nome de um Atributo de Entidade existente, ou um novo nome, para criar um novo atributo";

            case ACAO:
                return "Escreva FabAcao[Modulo][Entidade opcional]_o_[ENTIDADE]_[MB, FRM ou CTR]_[DESCRICAO], ex.: FabAcaoGerente_o_CLIENTE_FRM_LISTAR";
            case REQUISITO:
                break;
            case COMPONENTE_VISUAL:
                break;
            case FABRICA_STATUS:
                return "Escreva FabStatus[Nome] para criar ou editar uma fábrica de status, ou FabStatus[Nome].nomeStatus para criar ou editar um status, ex.: FabStatusPedido.emAndamento";
            case FABRICA_GRUPO_USUARIOS:
                break;
            case FABRICA_MODULOS:
                break;
            case FLUXO_TESTES:
                break;
            case FABRICA_ENTIDADE_GENERICA:
                return "Escreva Fab[Nome] para criar ou editar uma fábrica de objetos estáticos, ou Fab[Nome].nomeItem para criar ou editar um item, ex.: FabTipoPagamento.cartao";
            case DESCONHECIDO:
                return "Para Editar e criar ações, digite FabAcaoNomeAcao, para Criar e editar entidades digite, NomeEntidade, e Para criar dados estáticos, como Status, e Tipo digite FabTipoXNomeTipo";

            default:
                throw new AssertionError();
        }
        return "Para Editar e criar ações, digite FabAcaoNomeAcao, para Criar e editar entidades digite, NomeEntidade, e Para criar dados estáticos, como Status, e Tipo digite FabTipoXNomeTipo";
    }

    public String getComponentePreview() {
        return null;
    }

    public List<String> textosSugestaoAutocomplete(ConsoleCRCProjeto pConsole, String pTextoDefinidoNomrmatizado) {
        List<String> opcoesAutocomplet = new ArrayList<>();
        switch (this) {

            case ACAO: {
                String texto = pTextoDefinidoNomrmatizado;
                if (UtilProjCRCNomeAcao.getNomeFabricaSemPrefixo(texto).isEmpty()) {
                    // Só o prefixo FabAcao: sem o nome do módulo não há o que sugerir
                    return opcoesAutocomplet;
                }
                String fabrica = UtilProjCRCNomeAcao.getNomeFabrica(texto);
                ObjetoProjCRC entidadeMaisRecente = pConsole.getRepositorio().getEntidadeMaisRecente();
                if (!UtilProjCRCNomeAcao.isPossuiSeparadorFabricaAcao(texto)) {
                    // FabAcaoGerente: sugere a fábrica com a entidade mais recente, nos dois formatos
                    if (entidadeMaisRecente != null) {
                        if (!fabrica.endsWith(entidadeMaisRecente.getNomeEntidade())) {
                            opcoesAutocomplet.add(fabrica + entidadeMaisRecente.getNomeEntidade());
                        }
                        opcoesAutocomplet.add(UtilProjCRCNomeAcao.getTextoFabricaAcao(fabrica,
                                UtilProjCRCNomeAcao.getNomeEntidadeCaixaAlta(entidadeMaisRecente.getNomeEntidade())));
                    }
                    return opcoesAutocomplet;
                }
                String entidadeAcao = UtilProjCRCNomeAcao.getNomeEntidadeAcao(texto).replaceAll("_+$", "");
                if (entidadeAcao.isEmpty()) {
                    // FabAcaoGerente_o_: falta a entidade
                    if (entidadeMaisRecente != null) {
                        opcoesAutocomplet.add(UtilProjCRCNomeAcao.getTextoFabricaAcao(fabrica,
                                UtilProjCRCNomeAcao.getNomeEntidadeCaixaAlta(entidadeMaisRecente.getNomeEntidade())));
                    }
                    return opcoesAutocomplet;
                }
                if (!UtilProjCRCNomeAcao.isPossuiTipo(texto)) {
                    // FabAcaoGerente_o_CLIENTE: sugere os tipos _MB_, _FRM_ e _CTR_
                    String base = UtilProjCRCNomeAcao.getTextoFabricaAcao(fabrica, entidadeAcao);
                    for (String sigla : UtilProjCRCNomeAcao.SIGLAS_TIPO) {
                        opcoesAutocomplet.add(base + UtilProjCRCNomeAcao.getMarcadorTipo(sigla));
                    }
                    // Com a gestão criada, sugere também os subtipos que ainda faltam (ex.: ..._FRM_LISTAR)
                    for (String pendente : getSubtiposPendentesDaGestao(pConsole.getRepositorio(), texto, entidadeAcao)) {
                        opcoesAutocomplet.add(base + UtilProjCRCNomeAcao.SEPARADOR_PARTES + pendente);
                    }
                    return opcoesAutocomplet;
                }
                // FabAcaoGerente_o_CLIENTE_FRM_: sugere os subtipos padrão que começam com a descrição digitada
                String sigla = UtilProjCRCNomeAcao.getSiglaTipo(texto);
                String descricao = UtilProjCRCNomeAcao.getDescricaoAcao(texto);
                String baseComTipo = UtilProjCRCNomeAcao.getTextoFabricaAcao(fabrica, entidadeAcao) + UtilProjCRCNomeAcao.getMarcadorTipo(sigla);
                List<String> subtipos = UtilProjCRCNomeAcao.getSubtiposPadrao(sigla);
                if (!descricao.isEmpty() && !subtipos.contains(descricao)) {
                    // descrição personalizada
                    opcoesAutocomplet.add(texto);
                }
                subtipos.stream()
                        .filter(subtipo -> subtipo.startsWith(descricao))
                        .map(subtipo -> baseComTipo + subtipo)
                        .forEach(opcoesAutocomplet::add);
                return opcoesAutocomplet;
            }
            case OBJETO:
                opcoesAutocomplet.add(pTextoDefinidoNomrmatizado);
                for (ObjetoProjCRC existente : pConsole.getRepositorio().getLista3ObjetosMaisParecidos(pTextoDefinidoNomrmatizado)) {
                    if (!opcoesAutocomplet.contains(existente.getNomeEntidade())) {
                        opcoesAutocomplet.add(existente.getNomeEntidade());
                    }
                    opcoesAutocomplet.add(existente.getNomeEntidade() + SEPARADOR_ATRIBUTO);
                }
                return opcoesAutocomplet;

            case REQUISITO:
                break;

            case ATRIBUTO_OBJETO: {
                ObjetoProjCRC entidade = pConsole.getRepositorio().getEntidadeExistente(UtilProjCRCItemProjetoTexto.getPrimeiraParte(pTextoDefinidoNomrmatizado));
                if (entidade == null) {
                    return opcoesAutocomplet;
                }
                String nomeAtributo = UtilProjCRCItemProjetoTexto.getNomeAtributoSemSufixo(
                        UtilProjCRCItemProjetoTexto.getSegundaParte(pTextoDefinidoNomrmatizado));
                if (!nomeAtributo.isEmpty() && getAtributoExistente(entidade, nomeAtributo) == null) {
                    opcoesAutocomplet.add(pTextoDefinidoNomrmatizado);
                }
                // Atributo de listagem é sugerido com o sufixo [] (Cliente.clientesRelacionados[])
                getAtributosIniciandoCom(entidade, nomeAtributo).stream()
                        .map(at -> entidade.getNomeEntidade() + SEPARADOR_ATRIBUTO + at.getNomeDeclarado()
                        + (at instanceof AtributoEntidadeLista ? UtilProjCRCItemProjetoTexto.SUFIXO_ATRIBUTO_LISTA : ""))
                        .forEach(opcoesAutocomplet::add);
                return opcoesAutocomplet;
            }
            case COMPONENTE_VISUAL:
                break;
            case FABRICA_STATUS:
            case FABRICA_ENTIDADE_GENERICA:
                return getSugestoesFabrica(pConsole.getRepositorio(), pTextoDefinidoNomrmatizado);
            case FABRICA_GRUPO_USUARIOS:
                break;
            case FABRICA_MODULOS:
                break;
            case FLUXO_TESTES:
                break;
            case DESCONHECIDO:

                break;
            default:
                throw new AssertionError();
        }
        return opcoesAutocomplet;

    }

    public List<ItemOpcaoConsole> getOpcoesConsole(ConsoleCRCProjeto console) {
        List<ItemOpcaoConsole> opcoesConsole = new ArrayList<>();

        switch (this) {

            case OBJETO:
                if (console.getRepositorio().isEntidadeExiste(console.getTextoDefinido())) {
                    adicionarOpcoesEntidadeExistente(opcoesConsole, console.getTextoDefinido(),
                            console.getRepositorio().getEntidadeExistente(console.getTextoDefinido()), 1, this.getComponentePreview());
                    return opcoesConsole;
                } else {
                    List<ObjetoProjCRC> sugestoes = console.getRepositorio().getLista3ObjetosMaisParecidos(console.getTextoDefinido());
                    ObjetoProjCRC novoItem;
                    int i = 1;
                    try {

                        novoItem = (ObjetoProjCRC) this.getItemByTexto(console.getProjetoSelecionado(), console.getTextoDefinido());
                        opcoesConsole.add(new ItemOpcaoConsole(console.getTextoDefinido(), FabAcaoCarameloDevComoItemProjeto.ENTIDADE_CTR_SALVAR_NOVO, novoItem, i,
                                FabAcaoCarameloDevComoItemProjeto.ENTIDADE_FRM_EDITAR.getRegistro().getComoFormulario(), this.getComponentePreview()));
                        i++;
                    } catch (ErroPreparandoObjeto ex) {
                        //valor incompativel
                    }

                    for (ObjetoProjCRC item : sugestoes) {
                        i = adicionarOpcoesEntidadeExistente(opcoesConsole, console.getTextoDefinido(), item, i, "");
                    }
                    return opcoesConsole;
                }

            case ATRIBUTO_OBJETO: {
                ObjetoProjCRC entidade = console.getRepositorio().getEntidadeExistente(UtilProjCRCItemProjetoTexto.getPrimeiraParte(console.getTextoDefinido()));
                if (entidade == null) {
                    return opcoesConsole;
                }
                String nomeDigitado = UtilProjCRCItemProjetoTexto.getSegundaParte(console.getTextoDefinido());
                String nomeAtributo = UtilProjCRCItemProjetoTexto.getNomeAtributoSemSufixo(nomeDigitado);
                int i = 1;
                if (!nomeAtributo.isEmpty() && getAtributoExistente(entidade, nomeAtributo) == null) {
                    try {
                        if (UtilProjCRCItemProjetoTexto.isAtributoTipoLista(nomeDigitado)) {
                            // Entidade.atributo[] → atributo do tipo lista
                            AtributoEntidadeLista novoAtributo = new AtributoEntidadeLista();
                            novoAtributo.prepararNovoObjeto(entidade, FabTipoInstanciaAtributoProjeto.ATRIBUTO_LISTAGEM.getTipoPeloNome(nomeAtributo), nomeAtributo);
                            novoAtributo.setEntidadeItemLista(getEntidadeReferenciadaPeloNome(console.getRepositorio(), entidade, nomeAtributo));
                            opcoesConsole.add(new ItemOpcaoConsole(console.getTextoDefinido(), FabAcaoCarameloDevComoItemProjeto.ATRIBUTO_ENTIDADE_CTR_SALVAR_NOVO_TP_LISTA, novoAtributo, i,
                                    FabAcaoCarameloDevComoItemProjeto.ATRIBUTO_ENTIDADE_FRM_EDITAR_LISTA.getRegistro().getComoFormulario(), this.getComponentePreview()));
                        } else if (UtilProjCRCItemProjetoTexto.isAtributoTipoObjeto(nomeDigitado)
                                || FabTipoInstanciaAtributoProjeto.getTipoInstanciaPeloNome(nomeAtributo) == FabTipoInstanciaAtributoProjeto.ATRIBUTO_ENTIDADE) {
                            // Entidade.atributo. ou nome reservado (bairro, uf, usuarioCriacao...) → atributo que referencia outra entidade
                            FabTipoAtributoObjeto tipo = FabTipoInstanciaAtributoProjeto.ATRIBUTO_ENTIDADE.getTipoPeloNome(nomeAtributo);
                            AtributoEntidadeEntidade novoAtributo = new AtributoEntidadeEntidade();
                            novoAtributo.prepararNovoObjeto(entidade, tipo, nomeAtributo);
                            if (tipo == FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA) {
                                // Nos tipos de localidade e de usuário a entidade é fixa
                                novoAtributo.setEntidadeReferenciada(getEntidadeReferenciadaPeloNome(console.getRepositorio(), entidade, nomeAtributo));
                            }
                            opcoesConsole.add(new ItemOpcaoConsole(console.getTextoDefinido(), FabAcaoCarameloDevComoItemProjeto.ATRIBUTO_ENTIDADE_CTR_SALVAR_NOVO_TP_ENTIDADE, novoAtributo, i,
                                    FabAcaoCarameloDevComoItemProjeto.ATRIBUTO_ENTIDADE_FRM_EDITAR_OBJETO.getRegistro().getComoFormulario(), this.getComponentePreview()));
                        } else {
                            // Tipo deduzido pelo nome (logo → IMG_PEQUENA); sem correspondência, TEXTO_SIMPLES
                            AtributoDeEntidadeSimples novoAtributo = FabTiposEntidade.getAtributo(entidade,
                                    FabTipoInstanciaAtributoProjeto.ATRIBUTO_SIMPLES.getTipoPeloNome(nomeAtributo), nomeAtributo);
                            opcoesConsole.add(new ItemOpcaoConsole(console.getTextoDefinido(), FabAcaoCarameloDevComoItemProjeto.ATRIBUTO_ENTIDADE_CTR_SALVAR_NOVO, novoAtributo, i,
                                    FabAcaoCarameloDevComoItemProjeto.ATRIBUTO_ENTIDADE_FRM_EDITAR.getRegistro().getComoFormulario(), this.getComponentePreview()));
                        }
                        i++;
                    } catch (ErroPreparandoObjeto ex) {
                        //valor incompativel
                    }
                }
                for (AtributoDeEntidadeSimples atributo : getAtributosIniciandoCom(entidade, nomeAtributo)) {
                    opcoesConsole.add(new ItemOpcaoConsole(console.getTextoDefinido(), FabAcaoCarameloDevComoItemProjeto.ATRIBUTO_ENTIDADE_FRM_EDITAR, atributo, i,
                            FabAcaoCarameloDevComoItemProjeto.ATRIBUTO_ENTIDADE_FRM_EDITAR.getRegistro().getComoFormulario(), this.getComponentePreview()));
                    i++;
                }
                return opcoesConsole;
            }
            case ACAO: {
                String texto = console.getTextoDefinido();
                int i = 1;
                // Criar: só com tipo e descrição, e se a ação ainda não existir
                if (UtilProjCRCNomeAcao.isNomeCompleto(texto)
                        && console.getRepositorio().getAcaoExistente(UtilProjCRCNomeAcao.getNomeUnico(texto)) == null) {
                    try {
                        AcaoProjCRC novaAcao = (AcaoProjCRC) this.getItemByTexto(console.getProjetoSelecionado(), texto);
                        if (novaAcao != null) {
                            opcoesConsole.add(new ItemOpcaoConsole(texto, FabAcaoCarameloDevAcaoProjCRC.ACOES_CTR_SALVAR, novaAcao, i,
                                    getFormularioDetalhesAcao(novaAcao).getRegistro().getComoFormulario(), this.getComponentePreview()));
                            i++;
                        }
                    } catch (ErroPreparandoObjeto ex) {
                        //valor incompativel
                    }
                }
                // Editar: ações existentes que começam com o texto digitado, as editadas mais recentemente primeiro
                for (AcaoProjCRC existente : console.getRepositorio().getAcoesIniciandoCom(texto)) {
                    FabAcaoCarameloDevAcaoProjCRC acaoEdicao = getFormularioDetalhesAcao(existente);
                    opcoesConsole.add(new ItemOpcaoConsole(texto, acaoEdicao, existente, i,
                            acaoEdicao.getRegistro().getComoFormulario(), this.getComponentePreview()));
                    i++;
                }
                return opcoesConsole;
            }
            case REQUISITO:
                break;
            case COMPONENTE_VISUAL:
                break;
            case FABRICA_STATUS:
            case FABRICA_ENTIDADE_GENERICA:
                return getOpcoesConsoleFabrica(console);
            case FABRICA_GRUPO_USUARIOS:
                break;
            case FABRICA_MODULOS:
                break;
            case FLUXO_TESTES:
                break;
            case DESCONHECIDO:
                return new ArrayList<>();

            default:
                throw new AssertionError();
        }
        return opcoesConsole;
    }

    /**
     * Adiciona as opções de uma entidade já existente: editar a entidade e
     * listar seus atributos (Entidade.).
     *
     * @return a próxima ordem disponível
     */
    private static int adicionarOpcoesEntidadeExistente(List<ItemOpcaoConsole> pOpcoes, String pTextoDigitado, ObjetoProjCRC pEntidade, int pOrdem, String pComponentePreview) {
        int ordem = pOrdem;
        pOpcoes.add(new ItemOpcaoConsole(pTextoDigitado, FabAcaoCarameloDevComoItemProjeto.ENTIDADE_FRM_EDITAR, pEntidade, ordem,
                FabAcaoCarameloDevComoItemProjeto.ENTIDADE_FRM_EDITAR.getRegistro().getComoFormulario(), pComponentePreview));
        ordem++;
        pOpcoes.add(new ItemOpcaoConsole(pTextoDigitado, FabAcaoCarameloDevComoItemProjeto.ATRIBUTO_ENTIDADE_FRM_LISTAR, pEntidade, ordem,
                FabAcaoCarameloDevComoItemProjeto.ATRIBUTO_ENTIDADE_FRM_LISTAR.getRegistro().getComoFormulario(), pComponentePreview));
        ordem++;
        return ordem;
    }

    /**
     * Atributos da entidade cujo nome começa com o texto digitado depois do
     * ponto (texto vazio retorna todos).
     */
    private static List<AtributoDeEntidadeSimples> getAtributosIniciandoCom(ObjetoProjCRC pEntidade, String pInicioNome) {
        if (pEntidade.getAtributos() == null) {
            return new ArrayList<>();
        }
        return pEntidade.getAtributos().stream()
                .filter(at -> at.getNomeDeclarado() != null && at.getNomeDeclarado().startsWith(pInicioNome))
                .collect(Collectors.toList());
    }

    /**
     * Subtipos padrão (SIGLA_DESCRICAO) que ainda não foram criados na gestão
     * do módulo e entidade digitados. A gestão é identificada por módulo +
     * domínio, então FabAcaoGerente_o_CLIENTE e FabAcaoGerenteCliente_o_CLIENTE
     * chegam à mesma gestão.
     *
     * @return lista vazia se a gestão ainda não existir
     */
    private static List<String> getSubtiposPendentesDaGestao(RepositorioConsole pRepositorio, String pTexto, String pEntidadeAcao) {
        ObjetoProjCRC entidade = pRepositorio.getEntidadePorNomeAcao(pEntidadeAcao);
        String nomeEntidade = entidade != null ? entidade.getNomeEntidade() : UtilProjCRCNomeAcao.getNomeEntidadeCamelCase(pEntidadeAcao);
        String nomeModulo = UtilProjCRCNomeAcao.getNomeModulo(pTexto, nomeEntidade);
        if (pRepositorio.getAcaoGestao(nomeModulo, pEntidadeAcao) == null) {
            return new ArrayList<>();
        }
        Set<String> criados = pRepositorio.getAcoesDoModuloEDominio(nomeModulo, pEntidadeAcao).stream()
                .map(acao -> UtilProjCRCNomeAcao.getSubtipoComSigla(UtilProjCRCNomeAcao.getTextoConsole(acao.getNomeUnico())))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
        return UtilProjCRCNomeAcao.getSubtiposPadraoComSigla().stream()
                .filter(subtipo -> !criados.contains(subtipo))
                .collect(Collectors.toList());
    }

    /**
     * Instancia a subclasse da ação de acordo com o tipo digitado: MB → gestão,
     * FRM → formulário, CTR → controller.
     */
    private static AcaoProjCRC getNovaAcaoPorSigla(String pSigla) {
        if (pSigla == null) {
            return null;
        }
        switch (pSigla) {
            case UtilProjCRCNomeAcao.SIGLA_GESTAO:
                return new AcaoProjCRCGestao();
            case UtilProjCRCNomeAcao.SIGLA_FORMULARIO:
                return new AcaoProjCRCFormulario();
            case UtilProjCRCNomeAcao.SIGLA_CONTROLLER:
                return new AcaoProjCRCContoller();
            default:
                return null;
        }
    }

    /**
     * Formulário de edição da ação, usado como detalhe da opção de criar e como
     * ação da opção de editar: formulário → EDITAR_ACAO_FORMULARIO, controller
     * → EDITAR_ACAO_CONTROLLER, gestão → VISAO_GERAL.
     */
    private static FabAcaoCarameloDevAcaoProjCRC getFormularioDetalhesAcao(AcaoProjCRC pAcao) {
        if (pAcao.isUmaAcaoFormulario()) {
            return FabAcaoCarameloDevAcaoProjCRC.ACOES_FRM_EDITAR_ACAO_FORMULARIO;
        }
        if (pAcao.isUmaAcaoController()) {
            return FabAcaoCarameloDevAcaoProjCRC.ACOES_FRM_EDITAR_ACAO_CONTROLLER;
        }
        return FabAcaoCarameloDevAcaoProjCRC.ACOES_FRM_VISAO_GERAL;
    }

    /**
     * Entidade do projeto deduzida pelo nome do atributo: a de nome mais longo
     * que seja prefixo do nome do atributo com a primeira letra maiúscula
     * (clientesRelacionados → Cliente). Sem correspondência, a própria entidade
     * dona do atributo.
     */
    private static ObjetoProjCRC getEntidadeReferenciadaPeloNome(RepositorioConsole pRepositorio, ObjetoProjCRC pEntidadeDona, String pNomeAtributo) {
        if (pRepositorio.getProjeto() == null || pRepositorio.getProjeto().getObjetos() == null) {
            return pEntidadeDona;
        }
        String nomeComMaiuscula = UtilProjCRCItemProjetoTexto.getTextoNormatizado(pNomeAtributo);
        return pRepositorio.getProjeto().getObjetos().stream()
                .filter(obj -> obj.getNomeEntidade() != null && nomeComMaiuscula.startsWith(obj.getNomeEntidade()))
                .max((a, b) -> Integer.compare(a.getNomeEntidade().length(), b.getNomeEntidade().length()))
                .orElse(pEntidadeDona);
    }

    private static AtributoDeEntidadeSimples getAtributoExistente(ObjetoProjCRC pEntidade, String pNomeAtributo) {
        if (pEntidade.getAtributos() == null) {
            return null;
        }
        return pEntidade.getAtributos().stream()
                .filter(at -> pNomeAtributo.equals(at.getNomeDeclarado()))
                .findFirst().orElse(null);
    }

    /**
     * Opções de FABRICA_STATUS e FABRICA_ENTIDADE_GENERICA.
     *
     * Sem ponto (FabStatusPedido): criar a fábrica (se não existir) ou editar a
     * fábrica e criar um item nela (se existir), e editar as fábricas do mesmo
     * tipo que começam com o texto.
     *
     * Com ponto (FabStatusPedido.emAnd): criar o item (se não existir) e editar
     * os itens cujo nomeEnum começa com o nome digitado (EM_AND).
     */
    private List<ItemOpcaoConsole> getOpcoesConsoleFabrica(ConsoleCRCProjeto console) {
        List<ItemOpcaoConsole> opcoes = new ArrayList<>();
        boolean status = this == FABRICA_STATUS;
        FabAcaoCarameloDevComoItemProjeto salvarFabrica = status
                ? FabAcaoCarameloDevComoItemProjeto.FABRICA_STATUS_CTR_SALVAR_MERGE : FabAcaoCarameloDevComoItemProjeto.FABRICA_GENERICA_CTR_SALVAR_MERGE;
        FabAcaoCarameloDevComoItemProjeto editarFabrica = status
                ? FabAcaoCarameloDevComoItemProjeto.FABRICA_STATUS_FRM_EDITAR : FabAcaoCarameloDevComoItemProjeto.FABRICA_GENERICA_FRM_EDITAR;
        FabAcaoCarameloDevComoItemProjeto salvarItem = status
                ? FabAcaoCarameloDevComoItemProjeto.ITEM_FABRICA_STATUS_CTR_SALVAR_MERGE : FabAcaoCarameloDevComoItemProjeto.ITEM_FABRICA_GENERICA_CTR_SALVAR_MERGE;
        FabAcaoCarameloDevComoItemProjeto novoItemFrm = status
                ? FabAcaoCarameloDevComoItemProjeto.ITEM_FABRICA_STATUS_FRM_EDITAR : FabAcaoCarameloDevComoItemProjeto.ITEM_FABRICA_GENERICA_FRM_EDITAR;
        FabAcaoCarameloDevComoItemProjeto editarItem = status
                ? FabAcaoCarameloDevComoItemProjeto.ITEM_FABRICA_STATUS_FRM_EDITAR : FabAcaoCarameloDevComoItemProjeto.ITEM_FABRICA_GENERICA_FRM_EDITAR;

        String texto = console.getTextoDefinido();
        String nomeFabrica = UtilProjCRCNomeFabrica.getNomeFabrica(texto);
        FabricaEntidadeProjCRC fabrica = console.getRepositorio().getFabricaExistente(nomeFabrica);
        int i = 1;

        if (!UtilProjCRCNomeFabrica.isPossuiItem(texto)) {
            if (fabrica == null) {
                if (UtilProjCRCNomeFabrica.isNomeFabricaCompleto(nomeFabrica, status)) {
                    try {
                        FabricaEntidadeProjCRC novaFabrica = getNovaFabrica(console.getProjetoSelecionado(), nomeFabrica);
                        opcoes.add(new ItemOpcaoConsole(texto, salvarFabrica, novaFabrica, i,
                                editarFabrica.getRegistro().getComoFormulario(), this.getComponentePreview()));
                        i++;
                    } catch (ErroPreparandoObjeto ex) {
                        //valor incompativel
                    }
                }
            } else if (fabrica.getTipoItemProjeto() == this) {
                opcoes.add(new ItemOpcaoConsole(texto, editarFabrica, fabrica, i,
                        editarFabrica.getRegistro().getComoFormulario(), this.getComponentePreview()));
                i++;
                try {
                    ItemFabrica novoItem = getNovoItemFabrica(fabrica, null);
                    opcoes.add(new ItemOpcaoConsole(texto, novoItemFrm, novoItem, i,
                            novoItemFrm.getRegistro().getComoFormulario(), this.getComponentePreview()));
                    i++;
                } catch (ErroPreparandoObjeto ex) {
                    //valor incompativel
                }
            }
            for (FabricaEntidadeProjCRC existente : console.getRepositorio().getFabricasIniciandoCom(nomeFabrica, this)) {
                if (existente != fabrica) {
                    opcoes.add(new ItemOpcaoConsole(texto, editarFabrica, existente, i,
                            editarFabrica.getRegistro().getComoFormulario(), this.getComponentePreview()));
                    i++;
                }
            }
            return opcoes;
        }

        if (fabrica == null || fabrica.getTipoItemProjeto() != this) {
            return opcoes;
        }
        String nomeItem = UtilProjCRCNomeFabrica.getNomeItem(texto);
        String nomeEnum = ItemFabrica.getNomeEnumPorTexto(nomeItem);
        if (!nomeItem.isEmpty() && getItemFabricaExistente(fabrica, nomeEnum) == null) {
            try {
                ItemFabrica novoItem = getNovoItemFabrica(fabrica, nomeItem);
                opcoes.add(new ItemOpcaoConsole(texto, salvarItem, novoItem, i,
                        novoItemFrm.getRegistro().getComoFormulario(), this.getComponentePreview()));
                i++;
            } catch (ErroPreparandoObjeto ex) {
                //valor incompativel
            }
        }
        for (ItemFabrica existente : getItensFabricaIniciandoCom(fabrica, nomeEnum)) {
            opcoes.add(new ItemOpcaoConsole(texto, editarItem, existente, i,
                    editarItem.getRegistro().getComoFormulario(), this.getComponentePreview()));
            i++;
        }
        return opcoes;
    }

    /**
     * Sugestões de FABRICA_STATUS e FABRICA_ENTIDADE_GENERICA.
     *
     * Sem ponto: o próprio texto (se a fábrica não existir) e, para cada
     * fábrica do tipo que começa com o texto, o nome e o nome seguido de ponto.
     * Com ponto: o próprio texto (se o item não existir) e Fabrica.NOME_ENUM de
     * cada item que começa com o nome digitado.
     */
    private List<String> getSugestoesFabrica(RepositorioConsole pRepositorio, String pTexto) {
        List<String> sugestoes = new ArrayList<>();
        boolean status = this == FABRICA_STATUS;
        String nomeFabrica = UtilProjCRCNomeFabrica.getNomeFabrica(pTexto);
        FabricaEntidadeProjCRC fabrica = pRepositorio.getFabricaExistente(nomeFabrica);
        if (!UtilProjCRCNomeFabrica.isPossuiItem(pTexto)) {
            if (fabrica == null && UtilProjCRCNomeFabrica.isNomeFabricaCompleto(nomeFabrica, status)) {
                sugestoes.add(pTexto);
            }
            for (FabricaEntidadeProjCRC existente : pRepositorio.getFabricasIniciandoCom(nomeFabrica, this)) {
                sugestoes.add(existente.getNomeFabrica());
                sugestoes.add(existente.getNomeFabrica() + UtilProjCRCNomeFabrica.SEPARADOR_ITEM);
            }
            return sugestoes;
        }
        if (fabrica == null || fabrica.getTipoItemProjeto() != this) {
            return sugestoes;
        }
        String nomeItem = UtilProjCRCNomeFabrica.getNomeItem(pTexto);
        String nomeEnum = ItemFabrica.getNomeEnumPorTexto(nomeItem);
        if (!nomeItem.isEmpty() && getItemFabricaExistente(fabrica, nomeEnum) == null) {
            sugestoes.add(pTexto);
        }
        getItensFabricaIniciandoCom(fabrica, nomeEnum).stream()
                .map(item -> UtilProjCRCNomeFabrica.getTextoItem(fabrica.getNomeFabrica(), item.getNomeEnum()))
                .forEach(sugestoes::add);
        return sugestoes;
    }

    /**
     * Nova fábrica do tipo (FabricaStatusProjCRC ou FabricaEntidadeProjCRC),
     * sem adicioná-la à lista do projeto.
     */
    private FabricaEntidadeProjCRC getNovaFabrica(ProjetoCRC pProjeto, String pNomeFabrica) throws ErroPreparandoObjeto {
        FabricaEntidadeProjCRC nova = this == FABRICA_STATUS ? new FabricaStatusProjCRC() : new FabricaEntidadeProjCRC();
        nova.prepararNovoObjeto(pProjeto, pNomeFabrica);
        return nova;
    }

    /**
     * Novo item da fábrica (ItemFabricaStatus para fábrica de status), sem
     * adicioná-lo em fabrica.getItens(). Nome nulo: item sem nome, para o
     * formulário de novo item.
     */
    private static ItemFabrica getNovoItemFabrica(FabricaEntidadeProjCRC pFabrica, String pNomeItem) throws ErroPreparandoObjeto {
        ItemFabrica novo = pFabrica instanceof FabricaStatusProjCRC ? new ItemFabricaStatus() : new ItemFabrica();
        if (pNomeItem == null) {
            novo.prepararNovoObjeto(pFabrica);
        } else {
            novo.prepararNovoObjeto(pFabrica, pNomeItem);
        }
        return novo;
    }

    private static FabricaEntidadeProjCRC getFabricaDoProjeto(ProjetoCRC pProjeto, String pNomeFabrica) {
        if (pProjeto == null || pProjeto.getFabricas() == null) {
            return null;
        }
        return pProjeto.getFabricas().stream()
                .filter(fab -> pNomeFabrica.equals(fab.getNomeFabrica()))
                .findFirst().orElse(null);
    }

    private static ItemFabrica getItemFabricaExistente(FabricaEntidadeProjCRC pFabrica, String pNomeEnum) {
        if (pFabrica.getItens() == null || pNomeEnum == null) {
            return null;
        }
        return pFabrica.getItens().stream()
                .filter(item -> pNomeEnum.equals(item.getNomeEnum()))
                .findFirst().orElse(null);
    }

    /**
     * Itens da fábrica cujo nomeEnum começa com o texto (vazio retorna todos),
     * na ordem do idObjeto.
     */
    private static List<ItemFabrica> getItensFabricaIniciandoCom(FabricaEntidadeProjCRC pFabrica, String pInicioNomeEnum) {
        if (pFabrica.getItens() == null) {
            return new ArrayList<>();
        }
        String inicio = pInicioNomeEnum == null ? "" : pInicioNomeEnum;
        return pFabrica.getItens().stream()
                .filter(item -> item.getNomeEnum() != null && item.getNomeEnum().startsWith(inicio))
                .sorted(java.util.Comparator.comparing(ItemFabrica::getIdObjeto, java.util.Comparator.nullsLast(java.util.Comparator.naturalOrder())))
                .collect(Collectors.toList());
    }

    public static FabTipoItemProjeto getTipoItemPorTexto(String pTexto) {
        // Identificados por prefixo: ACAO (FabAcao), FABRICA_STATUS (FabStatus) e
        // FABRICA_ENTIDADE_GENERICA (Fab + maiúscula). Os demais prefixos de
        // getSlugInicialTipoItem ainda não estão ligados
        if (UtilProjCRCNomeAcao.isTextoAcao(pTexto)) {
            return ACAO;
        }
        // FabStatus antes de Fab; exige maiúscula depois do prefixo (Fabrica continua OBJETO)
        if (UtilProjCRCNomeFabrica.isTextoFabricaStatus(pTexto)) {
            return FABRICA_STATUS;
        }
        if (UtilProjCRCNomeFabrica.isTextoFabrica(pTexto)) {
            return FABRICA_ENTIDADE_GENERICA;
        }

        Optional<FabTipoItemProjeto> tipoDeclarado = Arrays.stream(FabTipoItemProjeto.values())
                .filter(tp -> pTexto.startsWith(tp.getIdentificadorUnico())).findFirst();
        if (tipoDeclarado.isPresent()) {
            return tipoDeclarado.get();
        }
        if (pTexto.contains(".")) {
            return ATRIBUTO_OBJETO;
        }
        return OBJETO;
    }

    public String getSlugInicialTipoItem(String pTexto) {
        if (pTexto == null || pTexto.isEmpty()) {
            return null;
        }
        switch (this) {
            case ACAO:
                return UtilProjCRCNomeAcao.PREFIXO_FABRICA;
            case REQUISITO:
                return "Req";
            case COMPONENTE_VISUAL:
                return "FabComp";
            case FABRICA_STATUS:
                return "FabStatus";
            case FABRICA_GRUPO_USUARIOS:
                return "FabGrupo";
            case FABRICA_MODULOS:
                return "FabModulo";
            case FLUXO_TESTES:
                return "Fluxo";
            case FABRICA_ENTIDADE_GENERICA:
                return "Fab";

            default:
                return "[INDEFINIDO]";
        }

    }

    public ComoItemProjeto getItemByTexto(ProjetoCRC pProjeto, String pTexto) throws ErroPreparandoObjeto {

        if (pTexto == null || pTexto.isEmpty()) {
            return null;
        }
        String texto = UtilProjCRCItemProjetoTexto.getTextoNormatizado(pTexto);
        String primeiraParte = UtilProjCRCItemProjetoTexto.getPrimeiraParte(texto);
        String segundaParte = UtilProjCRCItemProjetoTexto.getSegundaParte(texto);
        ComoItemProjeto item = null;
        switch (this) {

            case OBJETO:
                Optional<ObjetoProjCRC> opcoes = pProjeto.getObjetos().stream().filter(obj -> obj.getNomeEntidade().equals(primeiraParte)).findFirst();
                if (opcoes.isPresent()) {
                    return opcoes.get();
                } else {
                    ObjetoProjCRC objeto = new ObjetoProjCRC();
                    objeto.prepararNovoObjeto(pProjeto, primeiraParte);
                    return objeto;
                }

            case ATRIBUTO_OBJETO:

                break;
            case ACAO: {
                AcaoProjCRC novaAcao = getNovaAcaoPorSigla(UtilProjCRCNomeAcao.getSiglaTipo(texto));
                if (novaAcao == null) {
                    return null;
                }
                novaAcao.prepararNovoObjeto(pProjeto, texto);
                return novaAcao;
            }
            case REQUISITO:

                break;
            case COMPONENTE_VISUAL:

                break;
            case FABRICA_STATUS:
            case FABRICA_ENTIDADE_GENERICA: {
                FabricaEntidadeProjCRC fabrica = getFabricaDoProjeto(pProjeto, primeiraParte);
                if (!UtilProjCRCNomeFabrica.isPossuiItem(texto)) {
                    return fabrica != null ? fabrica : getNovaFabrica(pProjeto, primeiraParte);
                }
                if (fabrica == null) {
                    return null;
                }
                String nomeItem = UtilProjCRCNomeFabrica.getNomeItem(texto);
                if (nomeItem.isEmpty()) {
                    return null;
                }
                ItemFabrica existente = getItemFabricaExistente(fabrica, ItemFabrica.getNomeEnumPorTexto(nomeItem));
                return existente != null ? existente : getNovoItemFabrica(fabrica, nomeItem);
            }
            case FABRICA_GRUPO_USUARIOS:

                break;
            case FABRICA_MODULOS:

                break;
            case FLUXO_TESTES:

                break;
            default:
                throw new AssertionError();
        }
        return item;
    }

    public ComoItemProjeto getItemByJson(JsonObject pItem) {
        switch (this) {
            case OBJETO:

                break;
            case ATRIBUTO_OBJETO:

                break;
            case ACAO:

                break;
            case REQUISITO:

                break;
            case COMPONENTE_VISUAL:

                break;
            case FABRICA_STATUS:

                break;
            case FABRICA_GRUPO_USUARIOS:

                break;
            case FABRICA_MODULOS:

                break;
            case FLUXO_TESTES:

                break;
            case FABRICA_ENTIDADE_GENERICA:

                break;
            default:
                throw new AssertionError();
        }
        return null;
    }

}
