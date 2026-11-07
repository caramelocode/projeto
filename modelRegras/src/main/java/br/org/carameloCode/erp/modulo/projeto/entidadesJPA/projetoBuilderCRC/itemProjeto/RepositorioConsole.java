package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.AcaoProjCRCGestao;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.acoes.UtilProjCRCNomeAcao;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCListasObjeto;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;

/**
 *
 * @author salvio
 */
public class RepositorioConsole {

    private final ProjetoCRC projeto;
    private EntityManager gestorDeentidades;

    public RepositorioConsole(ProjetoCRC pProjeto) {
        projeto = pProjeto;
        carregarProjeto();
    }

    public ProjetoCRC getProjeto() {
        return UtilSBPersistencia.loadEntidade(projeto, gestorDeentidades);
    }

    private void carregarProjeto() {
        recarregarRepositorio();
    }

    public void fecharRepositorio() {
        UtilSBPersistencia.fecharEM(gestorDeentidades);
    }

    public void recarregarRepositorio() {

        UtilSBPersistencia.fecharEM(gestorDeentidades);
        gestorDeentidades = UtilSBPersistencia.getEMPadraoNovo();
        List<ObjetoProjCRC> objetos = getProjeto().getObjetos();
        OBJETOS.clear();
        objetos.stream()
                .filter(item -> item.getProjeto() != null && item.getProjeto().getId().equals(projeto.getId()))
                .forEach(item -> {
                    OBJETOS.put(item.getNomeEntidade(), item);
                });
        ACOES.clear();
        List<AcaoProjCRC> ac = getProjeto().getAcoes();
        ac.stream().forEach(acaoProj -> {
            ACOES.put(acaoProj.getNomeUnico(), acaoProj);
        });

    }

    private Map<String, ObjetoProjCRC> OBJETOS = new HashMap<>();
    private Map<String, AcaoProjCRC> ACOES = new HashMap<>();

    public boolean isEntidadeExiste(String pnomeEntidade) {
        return OBJETOS.containsKey(pnomeEntidade);
    }

    public AcaoProjCRC getAcaoExistente(String pNomeUnico) {
        return ACOES.get(pNomeUnico);
    }

    public ObjetoProjCRC getEntidadeExistente(String pNomeEntidade) {
        return OBJETOS.get(pNomeEntidade);
    }

    /**
     * @return a entidade do projeto com a data de inserção mais recente, ou
     * null se o projeto não tiver entidades
     */
    public ObjetoProjCRC getEntidadeMaisRecente() {
        return OBJETOS.values().stream()
                .max(Comparator.comparing(ObjetoProjCRC::getDataHoraInsersao, Comparator.nullsFirst(Comparator.naturalOrder())))
                .orElse(null);
    }

    /**
     * Entidade do projeto pelo nome usado nas ações (ex.: CLIENTE → Cliente).
     */
    public ObjetoProjCRC getEntidadePorNomeAcao(String pEntidadeCaixaAlta) {
        if (pEntidadeCaixaAlta == null) {
            return null;
        }
        return OBJETOS.values().stream()
                .filter(obj -> pEntidadeCaixaAlta.equals(UtilProjCRCNomeAcao.getNomeEntidadeCaixaAlta(obj.getNomeEntidade())))
                .findFirst().orElse(null);
    }

    /**
     * Ações salvas de um módulo para um domínio (nome da entidade na ação, ex.:
     * CLIENTE). Identifica a gestão independente do formato da fábrica
     * (FabAcaoGerente ou FabAcaoGerenteCliente).
     */
    public List<AcaoProjCRC> getAcoesDoModuloEDominio(String pNomeModulo, String pNomeDominio) {
        return ACOES.values().stream()
                .filter(acao -> acao.getModulo() != null && Objects.equals(pNomeModulo, acao.getModulo().getNome()))
                .filter(acao -> Objects.equals(pNomeDominio, acao.getNomeDominio()))
                .collect(Collectors.toList());
    }

    /**
     * @return a ação de gestão (MB) do módulo e domínio, ou null se ainda não
     * foi criada
     */
    public AcaoProjCRCGestao getAcaoGestao(String pNomeModulo, String pNomeDominio) {
        return getAcoesDoModuloEDominio(pNomeModulo, pNomeDominio).stream()
                .filter(AcaoProjCRCGestao.class::isInstance)
                .map(AcaoProjCRCGestao.class::cast)
                .findFirst().orElse(null);
    }

    /**
     * Ações salvas cujo texto no console (FabAcaoX_o_NOME_ACAO) começa com o
     * texto digitado, as alteradas (ou inseridas) mais recentemente primeiro.
     */
    public List<AcaoProjCRC> getAcoesIniciandoCom(String pTextoConsole) {
        if (pTextoConsole == null) {
            return new ArrayList<>();
        }
        return ACOES.values().stream()
                .filter(acao -> acao.getNomeUnico() != null
                && UtilProjCRCNomeAcao.getTextoConsole(acao.getNomeUnico()).startsWith(pTextoConsole))
                .sorted(Comparator.comparing(RepositorioConsole::getDataUltimaEdicao,
                        Comparator.nullsLast(Comparator.<Date>reverseOrder())))
                .collect(Collectors.toList());
    }

    private static Date getDataUltimaEdicao(AcaoProjCRC pAcao) {
        return pAcao.getDataHoraAlteracao() != null ? pAcao.getDataHoraAlteracao() : pAcao.getDataHoraInsersao();
    }

    public List<AcaoProjCRC> getLista3AcoesMaisParecidos(String pNomeEntidade) {
        return UtilCRCListasObjeto.filtrarOrdenandoMaisParecidos(new ArrayList<>(ACOES.values()), pNomeEntidade, 3);
    }

    public List<ObjetoProjCRC> getLista3ObjetosMaisParecidos(String pNomeEntidade) {
        return UtilCRCListasObjeto.filtrarOrdenandoMaisParecidos(new ArrayList<>(OBJETOS.values()), pNomeEntidade, 3);
    }

}
