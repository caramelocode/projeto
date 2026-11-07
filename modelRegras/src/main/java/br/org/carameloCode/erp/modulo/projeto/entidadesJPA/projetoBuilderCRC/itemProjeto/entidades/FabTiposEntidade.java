/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.EntidadeORMNormal;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.EntidadeORMStatus;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.EntidadeSimplesORM;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCStringConversores;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCStringFiltros;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCStringGerador;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCStringsCammelCase;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.coletivojava.fw.api.tratamentoErros.ErroPreparandoObjeto;

/**
 *
 * @author salvio
 */
public enum FabTiposEntidade {

    SIMPLES,
    NORMAL,
    COMO_PESSOA,//REFERENCIA: ComoContatoCorporativo
    COMO_USUARIO,
    COMO_STATUS,
    COMO_GRUPO_USUARIO;

    public Class getClasseInterface() {
        return null;
    }

    public Class getClasseExtecao() {
        switch (this) {

            case SIMPLES:
                return EntidadeSimplesORM.class;

            case NORMAL:
                return EntidadeORMNormal.class;

            case COMO_PESSOA:
                return null;

            case COMO_USUARIO:
                return null;
            case COMO_STATUS:
                return EntidadeORMStatus.class;

            case COMO_GRUPO_USUARIO:
                return null;

            default:
                return null;
        }
    }

    /**
     * Atributos criados automaticamente em uma nova entidade deste tipo.
     *
     * @return lista de tipos de atributo obrigatórios do tipo de entidade
     */
    public List<FabTipoAtributoObjeto> getAtributosDoTIpo() {
        switch (this) {

            case SIMPLES:
                return Arrays.asList(FabTipoAtributoObjeto.ID, FabTipoAtributoObjeto.NOME);
            case NORMAL:
                return Arrays.asList(FabTipoAtributoObjeto.ID, FabTipoAtributoObjeto.NOME,
                        FabTipoAtributoObjeto.REG_DATAALTERACAO,
                        FabTipoAtributoObjeto.REG_DATAINSERCAO,
                        FabTipoAtributoObjeto.REG_USUARIO_ALTERACAO,
                        FabTipoAtributoObjeto.REG_USUARIO_INSERCAO,
                        FabTipoAtributoObjeto.REG_ATIVO_INATIVO);
            case COMO_PESSOA:
            case COMO_USUARIO:
            case COMO_STATUS:
            case COMO_GRUPO_USUARIO:
                throw new UnsupportedOperationException("Atributos padrão do tipo de entidade " + this + " ainda não definidos");
            default:
                throw new AssertionError();
        }
    }

    /**
     * Adiciona à entidade os atributos padrão deste tipo (ex.: id e nome), já
     * vinculados à entidade, para serem salvos em cascata com ela.
     *
     * @param pObjeto entidade do projeto
     * @throws ErroPreparandoObjeto falha preparando um dos atributos
     */
    public void aplicarAtributo(ObjetoProjCRC pObjeto) throws ErroPreparandoObjeto {
        if (pObjeto.getAtributos() == null) {
            pObjeto.setAtributos(new ArrayList<>());
        }
        for (FabTipoAtributoObjeto tipo : getAtributosDoTIpo()) {
            AtributoDeEntidadeSimples atributo = getAtributo(pObjeto, tipo, getNomePadraoATributo(pObjeto, tipo));
            pObjeto.getAtributos().add(atributo);
        }
    }

    public static String getNomePadraoATributo(ObjetoProjCRC pObjeto, FabTipoAtributoObjeto pTipoAtributo) {
        switch (pTipoAtributo) {
            case ID:
                return "id";
            case NOME:
                return "nome";
            case NOME_LONGO:
            case NOME_COMPLETO:
                return "nomeCompleto";
            case DESCRITIVO:
                return "descricao";
            case REG_DATAALTERACAO:
                return "dataHoraAlteracao";
            case REG_DATAINSERCAO:
                return "dataHoraInsercao";
            case REG_USUARIO_ALTERACAO:
                return "usuarioAlteracao";
            case REG_USUARIO_INSERCAO:
                return "usuarioInsercao";
            case REG_ATIVO_INATIVO:
                return "ativo";
            default:
                return getNomeCamelCase(pTipoAtributo);
        }
    }

    public static AtributoDeEntidadeSimples getAtributo(ObjetoProjCRC pObjeto, FabTipoAtributoObjeto pTipoAtributo, String pNomeAtributo) throws ErroPreparandoObjeto {
        AtributoDeEntidadeSimples atributo = new AtributoDeEntidadeSimples();
        atributo.prepararNovoObjeto(pObjeto, pTipoAtributo, pNomeAtributo);

        return atributo;
    }

    /**
     * Nome padrão para tipos sem nome definido: o nome do enum em camelCase
     * (ex.: LC_CIDADE → lcCidade).
     */
    private static String getNomeCamelCase(FabTipoAtributoObjeto pTipoAtributo) {
        return UtilCRCStringsCammelCase.getCamelByTextoPrimeiraLetraMaiuscula(pTipoAtributo.name());

    }

}
