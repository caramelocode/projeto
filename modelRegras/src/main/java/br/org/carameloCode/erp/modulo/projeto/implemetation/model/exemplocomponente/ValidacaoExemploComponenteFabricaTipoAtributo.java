package br.org.carameloCode.erp.modulo.projeto.implemetation.model.exemplocomponente;

import com.super_bits.modulosSB.SBCore.modulos.objetos.validador.ValidacaoGenerica;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.ExemploComponente;
import br.org.carameloCode.erp.modulo.projeto.api.model.exemplocomponente.ValidadorExemploComponente;
import br.org.carameloCode.erp.modulo.projeto.api.model.exemplocomponente.ValidadoresExemploComponente;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import java.util.ArrayList;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;
import java.util.List;
import com.super_bits.modulosSB.SBCore.modulos.objetos.validador.ErroValidacao;

@ValidadorExemploComponente(validador = ValidadoresExemploComponente.FABRICATIPOATRIBUTO)
public class ValidacaoExemploComponenteFabricaTipoAtributo
		extends
			ValidacaoGenerica<ExemploComponente> {

	public ValidacaoExemploComponenteFabricaTipoAtributo(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	@Override
	public List validar(java.lang.Object o) throws ErroValidacao {
		CarameloCode.getServicoMensagemFireForget().enviarMsgErroAoUsuario(
				"A Validação do campo  Tipo De Campo não foi implementada");
		return new ArrayList<>();
	}

	public ExemploComponente getExemploComponente() {
		return getObjetoDoAtributo();
	}
}