package br.org.carameloCode.erp.modulo.projeto.api.model.exemplocomponente;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.componentes.ExemploComponente;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;
import br.org.carameloCode.erp.modulo.projeto.api.model.exemplocomponente.ValidadoresExemploComponente;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@InfoReferenciaEntidade(tipoObjeto = ExemploComponente.class)
public @interface ValidadorExemploComponente {

	ValidadoresExemploComponente validador();
}