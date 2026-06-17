/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadeTransient;

import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulos.SBAcessosModel.model.acoes.AcaoDoSistema;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.EntidadeSimples;
import org.coletivojava.fw.api.tratamentoErros.ErroPreparandoObjeto;

/**
 *
 * @author salvio
 */
@InfoObjetoSB(tags = "Comunicação Transitória", plural = "Comunicações Transitorias")
public class ComunicacaoTransientDev extends EntidadeSimples {

    @InfoCampo(tipo = FabTipoAtributoObjeto.ID)
    private Long id;
    @InfoCampo(valorMaximo = 120, valorMinimo = 3, label = "Assunto")
    private String assunto = "Assunto teste de [remetente.nome]";
    private String mensagem = "Essa é uma menagem teste importante para [destinatario.nome]";

    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA, entidadeOpcoesDisponiveis = UsuarioSB.class)
    private UsuarioSB usuarioDestinatario;

    @Override
    public void prepararNovoObjeto(Object... parametros) throws ErroPreparandoObjeto {
        usuarioDestinatario = (UsuarioSB) CarameloCode.getUsuarioLogado();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public UsuarioSB getUsuarioDestinatario() {
        return usuarioDestinatario;
    }

    public void setUsuarioDestinatario(UsuarioSB usuarioDestinatario) {
        this.usuarioDestinatario = usuarioDestinatario;
    }

}
