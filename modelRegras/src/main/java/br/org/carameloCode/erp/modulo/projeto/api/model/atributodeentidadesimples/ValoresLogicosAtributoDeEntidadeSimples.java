package br.org.carameloCode.erp.modulo.projeto.api.model.atributodeentidadesimples;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoDeEntidadeSimples;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = AtributoDeEntidadeSimples.class)
public enum ValoresLogicosAtributoDeEntidadeSimples {
	VALORMAXIMO, VALORMINIMO, VALIDACAOREGEX, SEPARADORDECIMAL, SEPARADORMILHAR, NUMERODECASASDECIMAIS, MASCARAJQUERYMODE, SOMENTELEITURA, UMALISTAGEMDINAMICA, UMVALORCAMPOUNICO, ICONEPOSITIVO, TEXTOPOSITIVO, ICONENEGATIVO, TEXTONEGATIVO, ORDEM
}