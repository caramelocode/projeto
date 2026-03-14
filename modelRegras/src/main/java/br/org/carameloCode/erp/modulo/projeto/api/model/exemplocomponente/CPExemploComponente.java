package br.org.carameloCode.erp.modulo.projeto.api.model.exemplocomponente;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.ExemploComponente;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = ExemploComponente.class)
public enum CPExemploComponente {
	_TIPOEXEMPLO;

	public static final String tipoexemplo = "tipoExemplo";
}