package br.org.carameloCode.erp.modulo.projeto.api.model.orcamento;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.orcamento.Orcamento;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = Orcamento.class)
public enum CPOrcamento {
	_ID, _OQUECONTROLA, _QUANTIDADEOBJETOSESTIMADAS, _QUANTIDADEOBJETOSCOMPLEXOS, _QUANTIDADEACAOGESTAO, _QUANTIDADEACAOFORMULARIO, _QUANTIDADEACAOFORMULAOAVANCADAS, _QUANTIDADEACAOCONTROLLER, _QUANTIDADEACAOCONTRLLERAVANCADAS, _QUANTIDADEINTEGRACOES, _QUANTIDADEPROVACONCEITO, _OBSERVACOESDEESTIMATIVA, _CLIENTE, _FABRICA, _DESENVOLVEDORRESPONSAVEL, _PROJETOGERADO;

	public static final String id = "id";
	public static final String oquecontrola = "oqueControla";
	public static final String quantidadeobjetosestimadas = "quantidadeObjetosEstimadas";
	public static final String quantidadeobjetoscomplexos = "quantidadeObjetosComplexos";
	public static final String quantidadeacaogestao = "quantidadeAcaoGestao";
	public static final String quantidadeacaoformulario = "quantidadeAcaoFormulario";
	public static final String quantidadeacaoformulaoavancadas = "quantidadeAcaoFormulaoAvancadas";
	public static final String quantidadeacaocontroller = "quantidadeAcaoController";
	public static final String quantidadeacaocontrlleravancadas = "quantidadeAcaoContrllerAvancadas";
	public static final String quantidadeintegracoes = "quantidadeIntegracoes";
	public static final String quantidadeprovaconceito = "quantidadeProvaConceito";
	public static final String observacoesdeestimativa = "observacoesDeEstimativa";
	public static final String cliente = "cliente";
	public static final String fabrica = "fabrica";
	public static final String desenvolvedorresponsavel = "desenvolvedorResponsavel";
	public static final String projetogerado = "projetoGerado";
}