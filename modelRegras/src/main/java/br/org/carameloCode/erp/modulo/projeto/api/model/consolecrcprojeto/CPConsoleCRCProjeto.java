package br.org.carameloCode.erp.modulo.projeto.api.model.consolecrcprojeto;

import br.org.carameloCode.erp.modulo.projeto.console.ConsoleCRCProjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = ConsoleCRCProjeto.class)
public enum CPConsoleCRCProjeto {
	_REPOSITORIO, _TEXTODEFINIDO, _TEXTODICA, _MODULO, _PROJETOSELECIONADO, _PROJETOS, _OPCOESDISPONIVEIS, _OPCAOSELECIONADA, _TIPOPESQUISA;

	public static final String repositorio = "repositorio";
	public static final String textodefinido = "textoDefinido";
	public static final String textodica = "textoDica";
	public static final String modulo = "modulo";
	public static final String projetoselecionado = "projetoSelecionado";
	public static final String projetos = "projetos";
	public static final String opcoesdisponiveis = "opcoesDisponiveis";
	public static final String opcaoselecionada = "opcaoSelecionada";
	public static final String tipopesquisa = "tipoPesquisa";
}