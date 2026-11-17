package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaStatusProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.projeto.ProjetoCRC;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoPreparacaoObjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import org.coletivojava.fw.api.tratamentoErros.ErroPreparandoObjeto;

/**
 * Entidade de status do projeto (ex.: StatusCliente).
 *
 * Criada pelo console quando o texto digitado começa com
 * {@link #PREFIXO_ENTIDADE_STATUS} seguido de letra maiúscula. Ao salvar, o
 * controller cria automaticamente a fábrica de status vinculada
 * ({@link #getNomeFabricaStatusPadrao()}, ex.: FabStatusCliente), sem nenhum
 * item. A fábrica de status não é criada pelo console: só é possível editá-la e
 * incluir novos itens.
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = {"Entidade de Status do Projeto"}, plural = "Entidades de Status do Projeto", icone = "fa fa-traffic-light")
public class ObjetoStatusProjCRC extends ObjetoProjCRC {

    public static final String PREFIXO_ENTIDADE_STATUS = "Status";
    public static final String PREFIXO_FABRICA = "Fab";

    /**
     * Fábrica de status criada automaticamente pelo controller ao salvar a
     * entidade.
     */
    @OneToOne(targetEntity = FabricaStatusProjCRC.class)
    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA, somenteLeitura = true)
    private FabricaStatusProjCRC fabricaStatus;

    /**
     * Parâmetro principal: o projeto ({@link ProjetoCRC}). Também recebe o
     * nome da entidade (String), ex.: StatusCliente.
     */
    @Override
    @InfoPreparacaoObjeto(classesPrConstructorPrincipal = ProjetoCRC.class)
    public void prepararNovoObjeto(Object... parametros) throws ErroPreparandoObjeto {
        super.prepararNovoObjeto(parametros);
    }

    /**
     * Indica se o texto digitado identifica uma entidade de status: começa com
     * Status seguido de letra maiúscula (StatusCliente; Statusxyz não).
     */
    public static boolean isNomeEntidadeStatus(String pTexto) {
        if (pTexto == null || pTexto.length() <= PREFIXO_ENTIDADE_STATUS.length()) {
            return false;
        }
        return pTexto.startsWith(PREFIXO_ENTIDADE_STATUS)
                && Character.isUpperCase(pTexto.charAt(PREFIXO_ENTIDADE_STATUS.length()));
    }

    /**
     * Nome da fábrica de status vinculada a esta entidade: Fab + nome da
     * entidade (StatusCliente vira FabStatusCliente).
     */
    public String getNomeFabricaStatusPadrao() {
        return PREFIXO_FABRICA + getNomeEntidade();
    }

    public FabricaStatusProjCRC getFabricaStatus() {
        return fabricaStatus;
    }

    public void setFabricaStatus(FabricaStatusProjCRC fabricaStatus) {
        this.fabricaStatus = fabricaStatus;
    }

}
