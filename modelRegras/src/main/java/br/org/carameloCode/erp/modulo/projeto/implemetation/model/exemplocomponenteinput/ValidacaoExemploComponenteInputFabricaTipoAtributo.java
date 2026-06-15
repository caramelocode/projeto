package br.org.carameloCode.erp.modulo.projeto.implemetation.model.exemplocomponenteinput;

import com.super_bits.modulosSB.SBCore.modulos.objetos.validador.ValidacaoGenerica;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.ExemploComponenteInput;
import br.org.carameloCode.erp.modulo.projeto.api.model.exemplocomponenteinput.ValidadorExemploComponenteInput;
import br.org.carameloCode.erp.modulo.projeto.api.model.exemplocomponenteinput.ValidadoresExemploComponenteInput;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import java.util.ArrayList;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;
import java.util.List;
import com.super_bits.modulosSB.SBCore.modulos.objetos.validador.ErroValidacao;

@ValidadorExemploComponenteInput(validador = ValidadoresExemploComponenteInput.FABRICATIPOATRIBUTO)
public class ValidacaoExemploComponenteInputFabricaTipoAtributo
		extends
			ValidacaoGenerica<ExemploComponenteInput> {

	public ValidacaoExemploComponenteInputFabricaTipoAtributo(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	@Override
	public List validar(java.lang.Object o) throws ErroValidacao {
		CarameloCode.getServicoMensagemFireForget().enviarMsgErroAoUsuario(
				"A Validação do campo  Tipo De Campo não foi implementada");
		return new ArrayList<>();
	}

	public ExemploComponenteInput getExemploComponenteInput() {
		return getObjetoDoAtributo();
	}
}