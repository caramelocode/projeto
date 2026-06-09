package br.org.carameloCode.erp.modulo.projeto.api.model.provasdeconceito;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto.requisito.ProvasDeConceito;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = ProvasDeConceito.class)
public enum CPProvasDeConceito {
	_ID, _PERFORMANCE, _CURVADEAPRENDIZAGEM, _MATURIDADETCNOLOGIA, _CUSTOLICENCA, _INTEGRACAOSTACKATUAL, _CUSTOPROVACONCEITO, _HORASESTIMADASPROVACONVEITO, _RETATORIOFINALPROVACONCEITO, _REQUISITO;

	public static final String id = "id";
	public static final String performance = "performance";
	public static final String curvadeaprendizagem = "curvaDeAprendizagem";
	public static final String maturidadetcnologia = "maturidadeTcnologia";
	public static final String custolicenca = "custoLicenca";
	public static final String integracaostackatual = "integracaoStackAtual";
	public static final String custoprovaconceito = "custoProvaConceito";
	public static final String horasestimadasprovaconveito = "horasEstimadasProvaConveito";
	public static final String retatoriofinalprovaconceito = "retatorioFinalProvaConceito";
	public static final String requisito = "requisito";
}