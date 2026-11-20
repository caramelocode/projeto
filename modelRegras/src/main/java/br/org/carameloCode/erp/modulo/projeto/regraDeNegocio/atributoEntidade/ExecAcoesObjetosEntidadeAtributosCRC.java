/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.regraDeNegocio.atributoEntidade;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.objeto.FabAcaoCarameloDevEdicaoItemProj;
import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.objeto.InfoAcaoEntidadeObjetoCRCProjeto;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.ObjetoProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeEntidade;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeLista;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaEntidadeProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.FabricaStatusProjCRC;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.ItemFabrica;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.fabrica.ItemFabricaStatus;
import com.super_bits.modulos.SBAcessosModel.controller.resposta.RespostaComGestaoEMRegraDeNegocioPadrao;
import com.super_bits.modulosSB.Persistencia.dao.ControllerAbstratoSBPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfRespostaAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.TratamentoDeErros.ErroRegraDeNegocio;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;

/**
 * Controllers dos itens do projeto exibidos no console (entidades, atributos,
 * fábricas e itens de fábrica). Cada item tem as ações SALVAR_NOVO,
 * SALVAR_MERGE, VALIDAR e REMOVER.
 *
 * @author salvio
 */
public class ExecAcoesObjetosEntidadeAtributosCRC extends ControllerAbstratoSBPersistencia {

    // ===================================================================
    // Entidade (ObjetoProjCRC)
    // ===================================================================
    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ENTIDADE_CTR_SALVAR_NOVO)
    public static ItfRespostaAcaoDoSistema salvarObjetoEntidade(ObjetoProjCRC pItemDeProjeto) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pItemDeProjeto), pItemDeProjeto) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                setRetorno(atualizarEntidade(pItemDeProjeto));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ENTIDADE_CTR_SALVAR_MERGE)
    public static ItfRespostaAcaoDoSistema salvarMergeObjetoEntidade(ObjetoProjCRC pItemDeProjeto) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pItemDeProjeto), pItemDeProjeto) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                setRetorno(atualizarEntidade(pItemDeProjeto));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ENTIDADE_CTR_VALIDAR)
    public static ItfRespostaAcaoDoSistema validarObjetoEntidade(ObjetoProjCRC pItemDeProjeto) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pItemDeProjeto), pItemDeProjeto) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                setRetorno(atualizarEntidade(pItemDeProjeto));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ENTIDADE_CTR_REMOVER)
    public static ItfRespostaAcaoDoSistema removerObjetoEntidade(ObjetoProjCRC pItemDeProjeto) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pItemDeProjeto), pItemDeProjeto) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                removerEntidade(pItemDeProjeto);
            }
        }.getResposta();

    }

    // ===================================================================
    // Atributo simples (AtributoDeEntidadeSimples)
    // ===================================================================
    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_SALVAR_NOVO)
    public static ItfRespostaAcaoDoSistema salvarAtributoEntidade(AtributoDeEntidadeSimples pAtributo) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pAtributo), pAtributo) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                if (pAtributo.getEntidade() == null) {
                    throw new ErroRegraDeNegocio("O atributo precisa estar vinculado a uma entidade");
                }
                setRetorno(atualizarEntidade(pAtributo));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_SALVAR_MERGE)
    public static ItfRespostaAcaoDoSistema salvarMergeAtributoEntidade(AtributoDeEntidadeSimples pAtributo) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pAtributo), pAtributo) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                if (pAtributo.getEntidade() == null) {
                    throw new ErroRegraDeNegocio("O atributo precisa estar vinculado a uma entidade");
                }
                setRetorno(atualizarEntidade(pAtributo));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_VALIDAR)
    public static ItfRespostaAcaoDoSistema validarAtributoEntidade(AtributoDeEntidadeSimples pAtributo) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pAtributo), pAtributo) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                if (pAtributo.getEntidade() == null) {
                    throw new ErroRegraDeNegocio("O atributo precisa estar vinculado a uma entidade");
                }
                setRetorno(atualizarEntidade(pAtributo));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_REMOVER)
    public static ItfRespostaAcaoDoSistema removerAtributoEntidade(AtributoDeEntidadeSimples pAtributo) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pAtributo), pAtributo) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                removerEntidade(pAtributo);
            }
        }.getResposta();

    }

    // ===================================================================
    // Atributo objeto (Entidade.atributo.), que referencia outra entidade
    // ===================================================================
    /**
     * Salva um atributo do tipo objeto (Entidade.atributo.), que referencia
     * outra entidade do projeto.
     */
    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_SALVAR_NOVO_TP_ENTIDADE)
    public static ItfRespostaAcaoDoSistema salvarAtributoTipoEntidade(AtributoEntidadeEntidade pAtributo) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pAtributo), pAtributo) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                if (pAtributo.getEntidade() == null) {
                    throw new ErroRegraDeNegocio("O atributo precisa estar vinculado a uma entidade");
                }
                // Só OBJETO_DE_UMA_LISTA referencia uma entidade do projeto; localidade e usuário têm entidade fixa
                if (pAtributo.getTipo() == FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA && pAtributo.getEntidadeReferenciada() == null) {
                    throw new ErroRegraDeNegocio("Informe a entidade referenciada pelo atributo " + pAtributo.getNomeDeclarado());
                }
                setRetorno(atualizarEntidade(pAtributo));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_SALVAR_MERGE_TP_ENTIDADE)
    public static ItfRespostaAcaoDoSistema salvarMergeAtributoTipoEntidade(AtributoEntidadeEntidade pAtributo) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pAtributo), pAtributo) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                if (pAtributo.getEntidade() == null) {
                    throw new ErroRegraDeNegocio("O atributo precisa estar vinculado a uma entidade");
                }
                // Só OBJETO_DE_UMA_LISTA referencia uma entidade do projeto; localidade e usuário têm entidade fixa
                if (pAtributo.getTipo() == FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA && pAtributo.getEntidadeReferenciada() == null) {
                    throw new ErroRegraDeNegocio("Informe a entidade referenciada pelo atributo " + pAtributo.getNomeDeclarado());
                }
                setRetorno(atualizarEntidade(pAtributo));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_VALIDAR_TP_ENTIDADE)
    public static ItfRespostaAcaoDoSistema validarAtributoTipoEntidade(AtributoEntidadeEntidade pAtributo) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pAtributo), pAtributo) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                if (pAtributo.getEntidade() == null) {
                    throw new ErroRegraDeNegocio("O atributo precisa estar vinculado a uma entidade");
                }
                // Só OBJETO_DE_UMA_LISTA referencia uma entidade do projeto; localidade e usuário têm entidade fixa
                if (pAtributo.getTipo() == FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA && pAtributo.getEntidadeReferenciada() == null) {
                    throw new ErroRegraDeNegocio("Informe a entidade referenciada pelo atributo " + pAtributo.getNomeDeclarado());
                }
                setRetorno(atualizarEntidade(pAtributo));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_REMOVER_TP_ENTIDADE)
    public static ItfRespostaAcaoDoSistema removerAtributoTipoEntidade(AtributoEntidadeEntidade pAtributo) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pAtributo), pAtributo) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                removerEntidade(pAtributo);
            }
        }.getResposta();

    }

    // ===================================================================
    // Atributo lista (Entidade.atributo[]), com itens de uma entidade
    // ===================================================================
    /**
     * Salva um atributo do tipo lista (Entidade.atributo[]), cujos itens são de
     * uma entidade do projeto.
     */
    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_SALVAR_NOVO_TP_LISTA)
    public static ItfRespostaAcaoDoSistema salvarAtributoTipoLista(AtributoEntidadeLista pAtributo) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pAtributo), pAtributo) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                if (pAtributo.getEntidade() == null) {
                    throw new ErroRegraDeNegocio("O atributo precisa estar vinculado a uma entidade");
                }
                if (pAtributo.getEntidadeItemLista() == null) {
                    throw new ErroRegraDeNegocio("Informe a entidade dos itens da lista " + pAtributo.getNomeDeclarado());
                }

                setRetorno(atualizarEntidade(pAtributo));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_SALVAR_MERGE_TP_LISTA)
    public static ItfRespostaAcaoDoSistema salvarMergeAtributoTipoLista(AtributoEntidadeLista pAtributo) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pAtributo), pAtributo) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                if (pAtributo.getEntidade() == null) {
                    throw new ErroRegraDeNegocio("O atributo precisa estar vinculado a uma entidade");
                }
                if (pAtributo.getEntidadeItemLista() == null) {
                    throw new ErroRegraDeNegocio("Informe a entidade dos itens da lista " + pAtributo.getNomeDeclarado());
                }

                setRetorno(atualizarEntidade(pAtributo));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_VALIDAR_TP_LISTA)
    public static ItfRespostaAcaoDoSistema validarAtributoTipoLista(AtributoEntidadeLista pAtributo) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pAtributo), pAtributo) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                if (pAtributo.getEntidade() == null) {
                    throw new ErroRegraDeNegocio("O atributo precisa estar vinculado a uma entidade");
                }
                if (pAtributo.getEntidadeItemLista() == null) {
                    throw new ErroRegraDeNegocio("Informe a entidade dos itens da lista " + pAtributo.getNomeDeclarado());
                }

                setRetorno(atualizarEntidade(pAtributo));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_REMOVER_TP_LISTA)
    public static ItfRespostaAcaoDoSistema removerAtributoTipoLista(AtributoEntidadeLista pAtributo) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pAtributo), pAtributo) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                removerEntidade(pAtributo);
            }
        }.getResposta();

    }

    // ===================================================================
    // Fábrica genérica (FabricaEntidadeProjCRC)
    // ===================================================================
    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.FABRICA_GENERICA_CTR_SALVAR_NOVO)
    public static ItfRespostaAcaoDoSistema salvarFabrica(FabricaEntidadeProjCRC pFabrica) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pFabrica), pFabrica) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                validarFabrica(pFabrica);
                setRetorno(atualizarEntidade(pFabrica));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.FABRICA_GENERICA_CTR_SALVAR_MERGE)
    public static ItfRespostaAcaoDoSistema salvarMergeFabrica(FabricaEntidadeProjCRC pFabrica) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pFabrica), pFabrica) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                validarFabrica(pFabrica);
                setRetorno(atualizarEntidade(pFabrica));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.FABRICA_GENERICA_CTR_VALIDAR)
    public static ItfRespostaAcaoDoSistema validarFabricaGenerica(FabricaEntidadeProjCRC pFabrica) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pFabrica), pFabrica) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                validarFabrica(pFabrica);
                setRetorno(atualizarEntidade(pFabrica));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.FABRICA_GENERICA_CTR_REMOVER)
    public static ItfRespostaAcaoDoSistema removerFabrica(FabricaEntidadeProjCRC pFabrica) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pFabrica), pFabrica) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                removerEntidade(pFabrica);
            }
        }.getResposta();

    }

    // ===================================================================
    // Fábrica de status (FabricaStatusProjCRC)
    // ===================================================================
    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.FABRICA_STATUS_CTR_SALVAR_NOVO)
    public static ItfRespostaAcaoDoSistema salvarFabricaStatus(FabricaStatusProjCRC pFabrica) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pFabrica), pFabrica) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                validarFabrica(pFabrica);
                setRetorno(atualizarEntidade(pFabrica));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.FABRICA_STATUS_CTR_SALVAR_MERGE)
    public static ItfRespostaAcaoDoSistema salvarMergeFabricaStatus(FabricaStatusProjCRC pFabrica) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pFabrica), pFabrica) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                validarFabrica(pFabrica);
                setRetorno(atualizarEntidade(pFabrica));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.FABRICA_STATUS_CTR_VALIDAR)
    public static ItfRespostaAcaoDoSistema validarFabricaStatus(FabricaStatusProjCRC pFabrica) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pFabrica), pFabrica) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                validarFabrica(pFabrica);
                setRetorno(atualizarEntidade(pFabrica));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.FABRICA_STATUS_CTR_REMOVER)
    public static ItfRespostaAcaoDoSistema removerFabricaStatus(FabricaStatusProjCRC pFabrica) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pFabrica), pFabrica) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                removerEntidade(pFabrica);
            }
        }.getResposta();

    }

    // ===================================================================
    // Item de fábrica genérica (ItemFabrica)
    // ===================================================================
    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ITEM_FABRICA_GENERICA_CTR_SALVAR_NOVO)
    public static ItfRespostaAcaoDoSistema salvarItemFabrica(ItemFabrica pItem) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pItem), pItem) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                validarItem(pItem);
                setRetorno(atualizarEntidade(pItem));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ITEM_FABRICA_GENERICA_CTR_SALVAR_MERGE)
    public static ItfRespostaAcaoDoSistema salvarMergeItemFabrica(ItemFabrica pItem) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pItem), pItem) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                validarItem(pItem);
                setRetorno(atualizarEntidade(pItem));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ITEM_FABRICA_GENERICA_CTR_VALIDAR)
    public static ItfRespostaAcaoDoSistema validarItemFabrica(ItemFabrica pItem) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pItem), pItem) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                validarItem(pItem);
                setRetorno(atualizarEntidade(pItem));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ITEM_FABRICA_GENERICA_CTR_REMOVER)
    public static ItfRespostaAcaoDoSistema removerItemFabrica(ItemFabrica pItem) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pItem), pItem) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                removerEntidade(pItem);
            }
        }.getResposta();

    }

    // ===================================================================
    // Item de fábrica de status (ItemFabricaStatus)
    // ===================================================================
    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ITEM_FABRICA_STATUS_CTR_SALVAR_NOVO)
    public static ItfRespostaAcaoDoSistema salvarItemFabricaStatus(ItemFabricaStatus pItem) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pItem), pItem) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                validarItem(pItem);
                if (!(pItem.getFabrica() instanceof FabricaStatusProjCRC)) {
                    throw new ErroRegraDeNegocio("O status " + pItem.getNomeEnum() + " precisa estar vinculado a uma fábrica de status");
                }
                setRetorno(atualizarEntidade(pItem));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ITEM_FABRICA_STATUS_CTR_SALVAR_MERGE)
    public static ItfRespostaAcaoDoSistema salvarMergeItemFabricaStatus(ItemFabricaStatus pItem) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pItem), pItem) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                validarItem(pItem);
                if (!(pItem.getFabrica() instanceof FabricaStatusProjCRC)) {
                    throw new ErroRegraDeNegocio("O status " + pItem.getNomeEnum() + " precisa estar vinculado a uma fábrica de status");
                }
                setRetorno(atualizarEntidade(pItem));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ITEM_FABRICA_STATUS_CTR_VALIDAR)
    public static ItfRespostaAcaoDoSistema validarItemFabricaStatus(ItemFabricaStatus pItem) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pItem), pItem) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                validarItem(pItem);
                if (!(pItem.getFabrica() instanceof FabricaStatusProjCRC)) {
                    throw new ErroRegraDeNegocio("O status " + pItem.getNomeEnum() + " precisa estar vinculado a uma fábrica de status");
                }
                setRetorno(atualizarEntidade(pItem));
            }
        }.getResposta();

    }

    @InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ITEM_FABRICA_STATUS_CTR_REMOVER)
    public static ItfRespostaAcaoDoSistema removerItemFabricaStatus(ItemFabricaStatus pItem) {

        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pItem), pItem) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                removerEntidade(pItem);
            }
        }.getResposta();

    }

    // ===================================================================
    // Validações compartilhadas de fábricas e itens
    // ===================================================================
    private static void validarFabrica(FabricaEntidadeProjCRC pFabrica) throws ErroRegraDeNegocio {
        if (pFabrica.getProjeto() == null) {
            throw new ErroRegraDeNegocio("A fábrica precisa estar vinculada a um projeto");
        }
        if (pFabrica.getNomeFabrica() == null || pFabrica.getNomeFabrica().trim().isEmpty()) {
            throw new ErroRegraDeNegocio("Informe o nome da fábrica");
        }
    }

    private static void validarItem(ItemFabrica pItem) throws ErroRegraDeNegocio {
        if (pItem.getFabrica() == null) {
            throw new ErroRegraDeNegocio("O item precisa estar vinculado a uma fábrica");
        }
        if (pItem.getNomeEnum() == null || pItem.getNomeEnum().trim().isEmpty()) {
            throw new ErroRegraDeNegocio("Informe o nome do item da fábrica " + pItem.getFabrica().getNomeFabrica());
        }
        if (pItem.getIdObjeto() == null) {
            throw new ErroRegraDeNegocio("Informe o id do objeto do item " + pItem.getNomeEnum());
        }
    }

}
