package br.org.carameloCode.erp.modulo.projeto.api.model.entdparticularexemplo;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.entidadeExemplo.EntdParticularExemplo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = EntdParticularExemplo.class)
public enum CPEntdParticularExemplo {
	_ENTIDADEPAI;

	public static final String entidadepai = "entidadePai";
}