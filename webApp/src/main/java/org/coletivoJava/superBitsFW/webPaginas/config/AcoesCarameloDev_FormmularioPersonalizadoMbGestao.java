package org.coletivoJava.superBitsFW.webPaginas.config;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import com.super_bits.modulosSB.SBCore.UtilGeral.MapaAcoesSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.ItfAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.ItfAcaoFormularioEntidade;

@Named
@ApplicationScoped
public class AcoesCarameloDev_FormmularioPersonalizadoMbGestao
		implements
			Serializable {

	public ItfAcaoFormulario getFormmularioPersonalizadoMbGestao() {
		return (ItfAcaoFormulario) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCCarameloFormulario.FORMMULARIO_PERSONALIZADO_MB_GESTAO");
	}

	public ItfAcaoFormularioEntidade getFormmularioPersonalizadoFrmListar() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCCarameloFormulario.FORMMULARIO_PERSONALIZADO_FRM_LISTAR");
	}

	public ItfAcaoFormularioEntidade getFormmularioPersonalizadoFrmVisualizar() {
		return (ItfAcaoFormularioEntidade) MapaAcoesSistema
				.getAcaoDoSistemaByNomeUnico("FabAcaoProjetoCRCCarameloFormulario.FORMMULARIO_PERSONALIZADO_FRM_VISUALIZAR");
	}
}