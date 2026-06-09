package br.org.carameloCode.erp.modulo.projeto.api.model.implantacaoprojeto;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.implantacao.implantacao.ImplantacaoProjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = ImplantacaoProjeto.class)
public enum CPImplantacaoProjeto {
	_ID, _PROJETO;

	public static final String id = "id";
	public static final String projeto = "projeto";
}