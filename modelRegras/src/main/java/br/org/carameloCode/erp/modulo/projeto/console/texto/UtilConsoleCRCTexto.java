package br.org.carameloCode.erp.modulo.projeto.console.texto;

import br.org.carameloCode.erp.modulo.projeto.console.ConsoleCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.console.ItemOpcaoConsole;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.ComoItemProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaEntidadeProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.ItemFabrica;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfRespostaAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.acoes.ComoAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.ItfAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Mensagens.ItfMensagem;
import com.super_bits.modulosSB.SBCore.modulos.fabrica.ComoFabricaAcoes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Texto de depuração do console: o que foi pesquisado, as sugestões do
 * autocompletar, as opções disponíveis e o resultado da execução.
 *
 * Exemplo de pesquisa:
 *
 * <pre>
 * ______________________________________________________________________
 *  Pesquisa: FabAcaoGerente_o_CLIENTE_MB_GESTAO   [ACAO]
 *  Dica: Escreva FabAcao[Modulo]...
 *  Sugestões do autocompletar (1):
 *      - FabAcaoGerente_o_CLIENTE_MB_GESTAO
 *  Opções do console (1):
 *  | Ordem | Ação                                    | Formulário de detalhes                  | Item do projeto
 *  | 1 *   | CTR FabAcaoCarameloDevAcaoProjCRC.ACOES_CTR_SALVAR | FRM ...ACOES_FRM_VISAO_GERAL | Ação FabAcaoGerente_o_CLIENTE_MB_GESTAO [nova] ...
 * ______________________________________________________________________
 * </pre>
 *
 * O * marca a opção que será executada (selecionada ou principal).
 *
 * @author salvio
 */
public class UtilConsoleCRCTexto {

    private static final int LARGURA_MINIMA_LINHA = 100;
    private static final String SEPARADOR_COLUNA = " |";
    private static final String MARCA_OPCAO_PRINCIPAL = " *";
    private static final String NENHUM = "(nenhum)";

    private UtilConsoleCRCTexto() {
    }

    /**
     * Imprime a pesquisa (somente em modo desenvolvimento).
     */
    public static void imprimirPesquisa(ConsoleCRCProjeto pConsole, List<String> pSugestoes) {
        if (SBCore.isEmModoDesenvolvimento()) {
            System.out.println(getTextoPesquisa(pConsole, pSugestoes));
        }
    }

    /**
     * Imprime o resultado da execução de uma opção (somente em modo
     * desenvolvimento).
     */
    public static void imprimirExecucao(ItemOpcaoConsole pOpcao, ItfRespostaAcaoDoSistema pResposta, String pObservacao) {
        if (!SBCore.isEmModoProducao()) {
            System.out.println(getTextoExecucao(pOpcao, pResposta, pObservacao));
        }
    }

    public static String getTextoPesquisa(ConsoleCRCProjeto pConsole, List<String> pSugestoes) {
        List<String> linhas = new ArrayList<>();
        linhas.add(" Pesquisa: " + pConsole.getTextoDefinido() + "   [" + pConsole.getTipoPesquisa() + "]");
        if (pConsole.getTextoDica() != null) {
            linhas.add(" Dica: " + pConsole.getTextoDica());
        }

        linhas.add(" Sugestões do autocompletar (" + (pSugestoes == null ? 0 : pSugestoes.size()) + "):");
        if (pSugestoes == null || pSugestoes.isEmpty()) {
            linhas.add("     " + NENHUM);
        } else {
            pSugestoes.forEach(sugestao -> linhas.add("     - " + sugestao));
        }

        List<ItemOpcaoConsole> opcoes = pConsole.getOpcoesDisponiveis();
        linhas.add(" Opções do console (" + opcoes.size() + "):");
        if (opcoes.isEmpty()) {
            linhas.add("     " + NENHUM);
        } else {
            ItemOpcaoConsole principal = pConsole.getOpcaoPrincipalSugerida();
            List<String[]> tabela = new ArrayList<>();
            tabela.add(new String[]{"Ordem", "Ação", "Formulário de detalhes", "Item do projeto"});
            for (ItemOpcaoConsole opcao : opcoes) {
                tabela.add(new String[]{
                    opcao.getOrdem() + (opcao == principal ? MARCA_OPCAO_PRINCIPAL : ""),
                    getDescricaoAcao(opcao.getFabAcaoAssociada()),
                    getDescricaoFormulario(opcao.getAcaoFormularioDetalhes()),
                    getDescricaoItem(opcao.getItemAssociado())});
            }
            linhas.addAll(getLinhasTabela(tabela));
        }
        return emoldurar(linhas);
    }

    public static String getTextoExecucao(ItemOpcaoConsole pOpcao, ItfRespostaAcaoDoSistema pResposta, String pObservacao) {
        List<String> linhas = new ArrayList<>();
        if (pOpcao == null) {
            linhas.add(" Execução: nenhuma opção selecionada");
        } else {
            linhas.add(" Execução: " + getDescricaoAcao(pOpcao.getFabAcaoAssociada()));
            linhas.add("     Item: " + getDescricaoItem(pOpcao.getItemAssociado()));
        }
        if (pResposta != null) {
            linhas.add(" Resultado: " + (pResposta.isSucesso() ? "SUCESSO" : "FALHA"));
            if (pResposta.getMensagens() != null) {
                for (ItfMensagem mensagem : pResposta.getMensagens()) {
                    linhas.add("     - [" + mensagem.getTipoDeMensagem() + "] " + mensagem.getMenssagem());
                }
            }
            if (pResposta.isSucesso() && pResposta.getRetorno() instanceof ComoItemProjeto) {
                linhas.add("     Retorno: " + getDescricaoItem((ComoItemProjeto) pResposta.getRetorno()));
            }
        }
        if (pObservacao != null) {
            linhas.add(" " + pObservacao);
        }
        return emoldurar(linhas);
    }

    /**
     * Ex.: CTR FabAcaoCarameloDevAcaoProjCRC.ACOES_CTR_SALVAR
     */
    public static String getDescricaoAcao(ComoFabricaAcoes pAcao) {
        if (pAcao == null) {
            return NENHUM;
        }
        return getSiglaTipoAcao(pAcao) + " " + pAcao.getClass().getSimpleName() + "." + pAcao;
    }

    public static String getDescricaoFormulario(ItfAcaoFormulario pFormulario) {
        if (pFormulario == null) {
            return NENHUM;
        }
        return "FRM " + pFormulario.getNomeUnico();
    }

    /**
     * Descreve o item com o que importa para cada tipo, e se ele já está salvo
     * (id) ou é novo.
     */
    public static String getDescricaoItem(ComoItemProjeto pItem) {
        if (pItem == null) {
            return NENHUM;
        }
        String situacao = pItem.getId() == null ? " [novo]" : " [id " + pItem.getId() + "]";
        if (pItem instanceof AcaoProjCRC) {
            AcaoProjCRC acao = (AcaoProjCRC) pItem;
            return pItem.getClass().getSimpleName() + " " + acao.getNomeUnico() + situacao
                    + " módulo=" + (acao.getModulo() == null ? NENHUM : acao.getModulo().getNome())
                    + " entidade=" + (acao.getEntidadeDominio() == null ? NENHUM : acao.getEntidadeDominio().getNomeEntidade())
                    + " tipo=" + acao.getTipoAcaoGenerica();
        }
        if (pItem instanceof AtributoDeEntidadeSimples) {
            AtributoDeEntidadeSimples atributo = (AtributoDeEntidadeSimples) pItem;
            String entidade = atributo.getEntidade() == null ? NENHUM : atributo.getEntidade().getNomeEntidade();
            return "Atributo " + entidade + "." + atributo.getNomeDeclarado() + situacao + " tipo=" + atributo.getTipo();
        }
        if (pItem instanceof ObjetoProjCRC) {
            return "Entidade " + ((ObjetoProjCRC) pItem).getNomeEntidade() + situacao;
        }
        if (pItem instanceof FabricaEntidadeProjCRC) {
            FabricaEntidadeProjCRC fabrica = (FabricaEntidadeProjCRC) pItem;
            return pItem.getClass().getSimpleName() + " " + fabrica.getNomeFabrica() + situacao
                    + " tipoObjeto=" + (fabrica.getTipoObjetoPadrao() == null ? NENHUM : fabrica.getTipoObjetoPadrao().getNomeEntidade())
                    + " itens=" + (fabrica.getItens() == null ? 0 : fabrica.getItens().size());
        }
        if (pItem instanceof ItemFabrica) {
            ItemFabrica item = (ItemFabrica) pItem;
            String fabrica = item.getFabrica() == null ? NENHUM : item.getFabrica().getNomeFabrica();
            return pItem.getClass().getSimpleName() + " " + fabrica + "." + item.getNomeEnum() + situacao
                    + " idObjeto=" + item.getIdObjeto() + " nomeObjeto=" + item.getNomeObjeto()
                    + " tipoObjeto=" + (item.getTipoObjeto() == null ? NENHUM : item.getTipoObjeto().getNomeEntidade());
        }
        return pItem.getClass().getSimpleName() + " " + pItem.getNome() + situacao;
    }

    private static String getSiglaTipoAcao(ComoFabricaAcoes pAcao) {
        try {
            ComoAcaoDoSistema registro = pAcao.getRegistro();
            if (registro.isUmaAcaoController()) {
                return "CTR";
            }
            if (registro.isUmaAcaoGestaoDominio()) {
                return "MB ";
            }
            if (registro.isUmaAcaoFormulario()) {
                return "FRM";
            }
            return "   ";
        } catch (RuntimeException e) {
            // a impressão de depuração não pode interromper o console
            return "?  ";
        }
    }

    /**
     * Alinha as colunas pela maior célula de cada uma; a última coluna fica sem
     * preenchimento.
     */
    private static List<String> getLinhasTabela(List<String[]> pTabela) {
        int colunas = pTabela.get(0).length;
        int[] larguras = new int[colunas];
        for (String[] linha : pTabela) {
            for (int c = 0; c < colunas; c++) {
                larguras[c] = Math.max(larguras[c], linha[c].length());
            }
        }
        List<String> linhas = new ArrayList<>();
        for (String[] linha : pTabela) {
            StringBuilder texto = new StringBuilder(" |");
            for (int c = 0; c < colunas; c++) {
                boolean ultima = c == colunas - 1;
                texto.append(' ').append(ultima ? linha[c] : preencher(linha[c], larguras[c]));
                if (!ultima) {
                    texto.append(SEPARADOR_COLUNA);
                }
            }
            linhas.add(texto.toString());
        }
        return linhas;
    }

    private static String preencher(String pTexto, int pLargura) {
        StringBuilder texto = new StringBuilder(pTexto);
        while (texto.length() < pLargura) {
            texto.append(' ');
        }
        return texto.toString();
    }

    private static String emoldurar(List<String> pLinhas) {
        int largura = LARGURA_MINIMA_LINHA;
        for (String linha : pLinhas) {
            largura = Math.max(largura, linha.length());
        }
        char[] traco = new char[largura];
        Arrays.fill(traco, '_');
        String moldura = new String(traco);
        StringBuilder texto = new StringBuilder();
        texto.append(moldura).append('\n');
        pLinhas.forEach(linha -> texto.append(linha).append('\n'));
        texto.append(moldura);
        return texto.toString();
    }

}
