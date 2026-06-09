package br.org.carameloCode.erp.modulo.projeto.api.model.planofabricasoftware;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.fabricaSoftware.plano.PlanoFabricaSoftware;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = PlanoFabricaSoftware.class)
public enum CPPlanoFabricaSoftware {
	_ID, _NOME, _PROJETOSPERMITIDOS, _IMPLANTACAOMENSALPERMITIDOS, _OBJETOSPORPROJETOPERMITIDOS, _ACOESPORPROJETOPERMITIDOS, _REPOSITORIOSPERMITIDOS, _COMPILACAOPERMITIDA;

	public static final String id = "id";
	public static final String nome = "nome";
	public static final String projetospermitidos = "projetosPermitidos";
	public static final String implantacaomensalpermitidos = "implantacaoMensalPermitidos";
	public static final String objetosporprojetopermitidos = "objetosPorProjetoPermitidos";
	public static final String acoesporprojetopermitidos = "acoesPorProjetoPermitidos";
	public static final String repositoriospermitidos = "repositoriosPermitidos";
	public static final String compilacaopermitida = "compilacaoPermitida";
}