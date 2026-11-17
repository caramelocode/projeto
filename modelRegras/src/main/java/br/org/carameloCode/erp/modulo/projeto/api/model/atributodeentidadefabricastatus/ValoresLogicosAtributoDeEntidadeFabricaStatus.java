package br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadefabricastatus;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeFabricaStatus;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = AtributoDeEntidadeFabricaStatus.class)
public enum ValoresLogicosAtributoDeEntidadeFabricaStatus {
	VALORMAXIMO, VALORMINIMO, VALIDACAOREGEX, SEPARADORDECIMAL, SEPARADORMILHAR, NUMERODECASASDECIMAIS, MASCARAJQUERYMODE, SOMENTELEITURA, UMALISTAGEMDINAMICA, UMVALORCAMPOUNICO, ICONEPOSITIVO, TEXTOPOSITIVO, ICONENEGATIVO, TEXTONEGATIVO, ORDEM
}