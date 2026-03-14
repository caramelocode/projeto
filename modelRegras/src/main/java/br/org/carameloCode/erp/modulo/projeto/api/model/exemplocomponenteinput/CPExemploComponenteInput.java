package br.org.carameloCode.erp.modulo.projeto.api.model.exemplocomponenteinput;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.ExemploComponenteInput;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = ExemploComponenteInput.class)
public enum CPExemploComponenteInput {
	_DADODINAMICO;

	public static final String dadodinamico = "dadoDinamico";
}