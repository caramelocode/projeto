package br.org.carameloCode.erp.modulo.projeto.api.model.usuariocliente;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.cliente.UsuarioCliente;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = UsuarioCliente.class)
public enum CPUsuarioCliente {
	_CLIENTE;

	public static final String cliente = "cliente";
}