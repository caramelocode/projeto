/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import br.org.carameloCode.erp.modulo.projeto.acoes.componente.formulario.FabAcaoProjetoCRCCarameloFormulario;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.entidadeExemplo.EntdExemplo;
import com.super_bits.modulosSB.Persistencia.fabrica.ComoFabricaComPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.erp.FabTipoAgenteOrganizacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoDaFabrica;

/**
 *
 * @author salvio
 */
public enum FabTipoNotificacaoTeste implements ComoFabricaComPersistencia {

    @InfoObjetoDaFabrica(classeObjeto = TipoNotificacao.class, id = 1, nomeObjeto = "Insercao Entidade Exemplo")
    NOTIFICACAO_INSERSAO_ENTIDADE_EXEMPLO,
    @InfoObjetoDaFabrica(classeObjeto = TipoNotificacao.class, id = 1, nomeObjeto = "Exclusao Entidade Exemplo")
    NOTIFICACAO_EXCLUSAO_ENTIDADE_EXEMPLO;

    @Override
    public Object getRegistro() {
        TipoNotificacao tipo = (TipoNotificacao) ComoFabricaComPersistencia.super.getRegistro(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody

        switch (this) {

            case NOTIFICACAO_INSERSAO_ENTIDADE_EXEMPLO:
                tipo.setNotificarViaMenu(true);
                tipo.setNotificarViaTelaDeBLoqueio(false);
                tipo.setNomeFabricaGatilhoNoticao(FabAcaoProjetoCRCCarameloFormulario.CRUD_EXEMPLO_CTR_SALVAR_MERGE.getNomeUnico());
                tipo.setConteudoHTML("Atenção O [nome] foi atualizado");
                tipo.setNomeEntidadeReferencia(EntdExemplo.class.getSimpleName());
                tipo.setTipoAgente(FabTipoAgenteOrganizacao.FORNECEDOR);
                break;
            case NOTIFICACAO_EXCLUSAO_ENTIDADE_EXEMPLO:
                tipo.setNotificarViaMenu(false);
                tipo.setNotificarViaTelaDeBLoqueio(true);
                tipo.setNomeFabricaGatilhoNoticao(FabAcaoProjetoCRCCarameloFormulario.CRUD_EXEMPLO_CTR_SALVAR_REMOVER.getNomeUnico());
                tipo.setNomeEntidadeReferencia(EntdExemplo.class.getSimpleName());
                tipo.setTipoAgente(FabTipoAgenteOrganizacao.FORNECEDOR);
                tipo.setConteudoHTML("Atenção registroanterior.nome foi excluido");
                break;
            default:
                throw new AssertionError();
        }
        return tipo;
    }
}
