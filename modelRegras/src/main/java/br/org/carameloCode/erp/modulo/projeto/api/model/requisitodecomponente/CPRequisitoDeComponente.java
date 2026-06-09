package br.org.carameloCode.erp.modulo.projeto.api.model.requisitodecomponente;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.requisito.RequisitoDeComponente;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = RequisitoDeComponente.class)
public enum CPRequisitoDeComponente {
	_IMAGEMREPRESENTATIVA, _COMPORTAMENTOESPERADO;

	public static final String imagemrepresentativa = "imagemRepresentativa";
	public static final String comportamentoesperado = "comportamentoEsperado";
}