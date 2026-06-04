package br.org.carameloCode.erp.projeto.paginas;

import br.org.carameloCode.erp.modulo.projeto.acoes.console.CRC_CONSOLE_TIPO_ACESSO;
import br.org.carameloCode.erp.modulo.projeto.acoes.console.CRC_CONSOLE_TIPO_COMANDO;
import com.super_bits.modulos.SBAcessosModel.model.ModuloAcaoSistema;
import com.super_bits.modulosSB.SBCore.UtilGeral.MapaAcoesSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.acoes.ComoAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.geradorCodigo.model.EstruturaDeEntidade;
import com.super_bits.modulosSB.SBCore.modulos.objetos.MapaObjetosProjetoAtual;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoEntidadeSimples;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import javax.inject.Named;

/**
 *
 * @author salvio
 */
@ApplicationScoped
@Named("CRCProj")
public class CRCProj implements Serializable {

    private ComoAcaoDoSistema acaoSelecionada;

    private ComoEntidadeSimples entidadeSelecionada;

    private List<ComoAcaoDoSistema> acoesDoSistema = null;
    private List<EstruturaDeEntidade> entidades = null;

    private String textoDefinido;
    private String textoDica;
    private ModuloAcaoSistema modulo;

    private CRC_CONSOLE_TIPO_COMANDO tipoPesquisa = CRC_CONSOLE_TIPO_COMANDO.INTEDERMINADO;
    private CRC_CONSOLE_TIPO_ACESSO tipoAcesso = CRC_CONSOLE_TIPO_ACESSO.INDETERMINADO;

    @PostConstruct
    public void teste() {
        System.out.println("ok");
        acoesDoSistema = MapaAcoesSistema.getListaTodasAcoes();
        entidades = MapaObjetosProjetoAtual.getListaTodosEstruturaObjeto();
    }

    public List<String> autocompletProjeto(String pValor) {
        List<String> opcoesAutocomplet = new ArrayList<>();
        tipoPesquisa = CRC_CONSOLE_TIPO_COMANDO.getTipoComando(pValor);
        switch (tipoPesquisa) {

            case ACAO:
                tipoAcesso = tipoPesquisa.getTipoAcesso(textoDica);
                acoesDoSistema.stream().map(ac -> ac.getNomeUnicoSlug()).forEach(opcoesAutocomplet::add);

                break;
            case ENTIDADE:
                tipoAcesso = tipoPesquisa.getTipoAcesso(textoDica);
                entidades.stream().map(et -> et.getNomeEntidade()).forEach(opcoesAutocomplet::add);
                switch (tipoAcesso) {

                    case NOVO:
                        break;
                    case EDITAR:
                        break;
                    case INDETERMINADO:

                        break;
                    default:
                        throw new AssertionError();
                }
                break;

            case INTEDERMINADO:
                textoDica = "Para Editar e criar ações, digite FabAcaoNomeAcao, para Criar e editar entidades digite, NomeEntidade, e Para criar dados estáticos, como Status, e Tipo digite FabTipoXNomeTipo";
                return new ArrayList<>();

            case REQUISITO:
                break;
            case MODULO:
                break;
            default:
                throw new AssertionError();
        }

        return opcoesAutocomplet;
    }

    public String getTextoDefinido() {
        return textoDefinido;
    }

    public void setTextoDefinido(String textoDefinido) {
        this.textoDefinido = textoDefinido;
    }

    public String getTextoDica() {
        return textoDica;
    }

}
