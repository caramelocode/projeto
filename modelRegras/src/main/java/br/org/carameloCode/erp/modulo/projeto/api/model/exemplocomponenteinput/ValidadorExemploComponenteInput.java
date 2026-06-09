package br.org.carameloCode.erp.modulo.projeto.api.model.exemplocomponenteinput;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.ExemploComponenteInput;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;
import br.org.carameloCode.erp.modulo.projeto.api.model.exemplocomponenteinput.ValidadoresExemploComponenteInput;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@InfoReferenciaEntidade(tipoObjeto = ExemploComponenteInput.class)
public @interface ValidadorExemploComponenteInput {

	ValidadoresExemploComponenteInput validador();
}