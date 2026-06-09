package br.org.carameloCode.erp.modulo.projeto.api.model.cliente;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.cliente.Cliente;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = Cliente.class)
public enum CPCliente {
	_ID, _NOME, _FABRICASOFTWARE, _USUARIOS, _INDICECUSTOPROJETO;

	public static final String id = "id";
	public static final String nome = "nome";
	public static final String fabricasoftware = "fabricaSoftware";
	public static final String usuarios = "usuarios";
	public static final String indicecustoprojeto = "indiceCustoProjeto";
}