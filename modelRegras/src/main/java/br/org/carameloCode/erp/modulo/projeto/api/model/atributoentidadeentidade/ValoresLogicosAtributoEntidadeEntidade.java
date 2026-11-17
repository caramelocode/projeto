package br.org.carameloCode.erp.modulo.projeto.api.model.atributoentidadeentidade;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.entidades.atributoEntidade.AtributoEntidadeEntidade;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = AtributoEntidadeEntidade.class)
public enum ValoresLogicosAtributoEntidadeEntidade {
	VALORMAXIMO, VALORMINIMO, VALIDACAOREGEX, SEPARADORDECIMAL, SEPARADORMILHAR, NUMERODECASASDECIMAIS, MASCARAJQUERYMODE, SOMENTELEITURA, UMALISTAGEMDINAMICA, UMVALORCAMPOUNICO, ICONEPOSITIVO, TEXTOPOSITIVO, ICONENEGATIVO, TEXTONEGATIVO, ORDEM
}