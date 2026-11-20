package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.etapas;

import br.org.carameloCode.erp.modulo.projeto.acoes.carameloDev.objeto.FabAcaoCarameloDevEdicaoItemProj;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.projeto.api.cucumber.consoleprojcrcatributosespeciais.EtapasconsoleProjCRCAtributosEspeciais;
import org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.consoleprojcrcatributosespeciais.FluxoConsoleAtributosEspeciais;

public class F_Quando_o_usuario_executa_a_criacao_do_atributo_clienteIndicou {

    @Quando(EtapasconsoleProjCRCAtributosEspeciais.QUANDO_O_USUARIO_EXECUTA_A_CRIACAO_DO_ATRIBUTO_CLIENTEINDICOU)
    public void implementacaoEtapa() {
        FluxoConsoleAtributosEspeciais.executarCriacaoDoAtributo(FluxoConsoleAtributosEspeciais.NOME_ATRIBUTO_CLIENTE_INDICOU,
                FabAcaoCarameloDevEdicaoItemProj.ATRIBUTO_ENTIDADE_CTR_SALVAR_NOVO_TP_ENTIDADE);
    }
}
