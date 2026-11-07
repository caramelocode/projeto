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
import java.util.logging.Level;
import java.util.logging.Logger;

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
    FABRICA_MODULOS,
    FLUXO_TESTES,
    FABRICA_ENTIDADE_GENERICA,
    DESCONHECIDO;

    public static final String SEPARADOR_ATRIBUTO = ".";

    /**
     * Tipo usado ao criar um atributo novo pelo console, antes do usuário
     * definir o tipo no formulário.
     */
    public static final FabTipoAtributoObjeto TIPO_PADRAO_NOVO_ATRIBUTO = FabTipoAtributoObjeto.TEXTO_SIMPLES;

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
                break;
            case FABRICA_GRUPO_USUARIOS:
                break;
            case FABRICA_MODULOS:
                break;
            case FLUXO_TESTES:
                break;
            case FABRICA_ENTIDADE_GENERICA:
                break;
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
                String nomeAtributo = UtilProjCRCItemProjetoTexto.getSegundaParte(pTextoDefinidoNomrmatizado);
                if (!nomeAtributo.isEmpty() && getAtributoExistente(entidade, nomeAtributo) == null) {
                    opcoesAutocomplet.add(pTextoDefinidoNomrmatizado);
                }
                getAtributosIniciandoCom(entidade, nomeAtributo).stream()
                        .map(at -> entidade.getNomeEntidade() + SEPARADOR_ATRIBUTO + at.getNomeDeclarado())
                        .forEach(opcoesAutocomplet::add);
                return opcoesAutocomplet;
            }
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
                        opcoesConsole.add(new ItemOpcaoConsole(console.getTextoDefinido(), FabAcaoCarameloDevComoItemProjeto.ENTIDADE_CTR_SALVAR, novoItem, i,
                                FabAcaoCarameloDevComoItemProjeto.ENTIDADE_FRM_NOVO.getRegistro().getComoFormulario(), this.getComponentePreview()));
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
                String nomeAtributo = UtilProjCRCItemProjetoTexto.getSegundaParte(console.getTextoDefinido());
                int i = 1;
                if (!nomeAtributo.isEmpty() && getAtributoExistente(entidade, nomeAtributo) == null) {
                    try {
                        AtributoDeEntidadeSimples novoAtributo = FabTiposEntidade.getAtributo(entidade, TIPO_PADRAO_NOVO_ATRIBUTO, nomeAtributo);
                        opcoesConsole.add(new ItemOpcaoConsole(console.getTextoDefinido(), FabAcaoCarameloDevComoItemProjeto.ATRIBUTO_ENTIDADE_CTR_SALVAR, novoAtributo, i,
                                FabAcaoCarameloDevComoItemProjeto.ATRIBUTO_ENTIDADE_FRM_NOVO.getRegistro().getComoFormulario(), this.getComponentePreview()));
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
                break;
            case FABRICA_GRUPO_USUARIOS:
                break;
            case FABRICA_MODULOS:
                break;
            case FLUXO_TESTES:
                break;
            case FABRICA_ENTIDADE_GENERICA:
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
     * Formulário de edição da ação, usado como detalhe da opção de criar e
     * como ação da opção de editar: formulário → EDITAR_ACAO_FORMULARIO,
     * controller → EDITAR_ACAO_CONTROLLER, gestão → VISAO_GERAL.
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

    private static AtributoDeEntidadeSimples getAtributoExistente(ObjetoProjCRC pEntidade, String pNomeAtributo) {
        if (pEntidade.getAtributos() == null) {
            return null;
        }
        return pEntidade.getAtributos().stream()
                .filter(at -> pNomeAtributo.equals(at.getNomeDeclarado()))
                .findFirst().orElse(null);
    }

    public static FabTipoItemProjeto getTipoItemPorTexto(String pTexto) {
        // Por enquanto só ACAO é identificado pelo prefixo (getSlugInicialTipoItem):
        // ligar os demais faria entidades como Requisicao ou Fabrica mudarem de tipo
        if (UtilProjCRCNomeAcao.isTextoAcao(pTexto)) {
            return ACAO;
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
