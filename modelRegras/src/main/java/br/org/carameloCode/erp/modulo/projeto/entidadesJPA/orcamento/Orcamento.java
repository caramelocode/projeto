/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.orcamento;

import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.cliente.Cliente;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.fabricaSoftware.FabricaSoftware;
import br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.fabricaSoftware.usuario.UsuarioDevProjCRC;
import com.super_bits.modulos.SBAcessosModel.fabricas.ProjetoAtual;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.EntidadeSimples;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = "Orçamento", plural = "Orçamentos", icone = "fa fa-calculator")
public class Orcamento extends EntidadeSimples {

    @Id
    @InfoCampo(tipo = FabTipoAtributoObjeto.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @InfoCampo(tipo = FabTipoAtributoObjeto.HTML, descricao = "Quais são as principais 'coisas' que o sistema precisa cadastrar ou controlar?")
    private String oqueControla;

    private int quantidadeObjetosEstimadas;
    private int quantidadeObjetosComplexos;
    private int quantidadeAcaoGestao;
    private int quantidadeAcaoFormulario;
    private int quantidadeAcaoFormulaoAvancadas;
    private int quantidadeAcaoController;
    private int quantidadeAcaoContrllerAvancadas;
    private int quantidadeIntegracoes;
    private int quantidadeProvaConceito;

    private String observacoesDeEstimativa;

    private Cliente cliente;

    @ManyToOne(targetEntity = FabricaSoftware.class)
    private FabricaSoftware fabrica;

    @ManyToOne(targetEntity = UsuarioDevProjCRC.class)
    private UsuarioDevProjCRC desenvolvedorResponsavel;

    @Transient
    private ProjetoAtual projetoGerado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOqueControla() {
        return oqueControla;
    }

    public void setOqueControla(String oqueControla) {
        this.oqueControla = oqueControla;
    }

    public int getQuantidadeObjetosEstimadas() {
        return quantidadeObjetosEstimadas;
    }

    public void setQuantidadeObjetosEstimadas(int quantidadeObjetosEstimadas) {
        this.quantidadeObjetosEstimadas = quantidadeObjetosEstimadas;
    }

    public int getQuantidadeObjetosComplexos() {
        return quantidadeObjetosComplexos;
    }

    public void setQuantidadeObjetosComplexos(int quantidadeObjetosComplexos) {
        this.quantidadeObjetosComplexos = quantidadeObjetosComplexos;
    }

    public int getQuantidadeAcaoGestao() {
        return quantidadeAcaoGestao;
    }

    public void setQuantidadeAcaoGestao(int quantidadeAcaoGestao) {
        this.quantidadeAcaoGestao = quantidadeAcaoGestao;
    }

    public int getQuantidadeAcaoFormulario() {
        return quantidadeAcaoFormulario;
    }

    public void setQuantidadeAcaoFormulario(int quantidadeAcaoFormulario) {
        this.quantidadeAcaoFormulario = quantidadeAcaoFormulario;
    }

    public int getQuantidadeAcaoFormulaoAvancadas() {
        return quantidadeAcaoFormulaoAvancadas;
    }

    public void setQuantidadeAcaoFormulaoAvancadas(int quantidadeAcaoFormulaoAvancadas) {
        this.quantidadeAcaoFormulaoAvancadas = quantidadeAcaoFormulaoAvancadas;
    }

    public int getQuantidadeAcaoController() {
        return quantidadeAcaoController;
    }

    public void setQuantidadeAcaoController(int quantidadeAcaoController) {
        this.quantidadeAcaoController = quantidadeAcaoController;
    }

    public int getQuantidadeAcaoContrllerAvancadas() {
        return quantidadeAcaoContrllerAvancadas;
    }

    public void setQuantidadeAcaoContrllerAvancadas(int quantidadeAcaoContrllerAvancadas) {
        this.quantidadeAcaoContrllerAvancadas = quantidadeAcaoContrllerAvancadas;
    }

    public int getQuantidadeIntegracoes() {
        return quantidadeIntegracoes;
    }

    public void setQuantidadeIntegracoes(int quantidadeIntegracoes) {
        this.quantidadeIntegracoes = quantidadeIntegracoes;
    }

    public int getQuantidadeProvaConceito() {
        return quantidadeProvaConceito;
    }

    public void setQuantidadeProvaConceito(int quantidadeProvaConceito) {
        this.quantidadeProvaConceito = quantidadeProvaConceito;
    }

    public String getObservacoesDeEstimativa() {
        return observacoesDeEstimativa;
    }

    public void setObservacoesDeEstimativa(String observacoesDeEstimativa) {
        this.observacoesDeEstimativa = observacoesDeEstimativa;
    }

    public FabricaSoftware getFabrica() {
        return fabrica;
    }

    public void setFabrica(FabricaSoftware fabrica) {
        this.fabrica = fabrica;
    }

    public UsuarioDevProjCRC getDesenvolvedorResponsavel() {
        return desenvolvedorResponsavel;
    }

    public void setDesenvolvedorResponsavel(UsuarioDevProjCRC desenvolvedorResponsavel) {
        this.desenvolvedorResponsavel = desenvolvedorResponsavel;
    }

    public ProjetoAtual getProjetoGerado() {
        return projetoGerado;
    }

    public void setProjetoGerado(ProjetoAtual projetoGerado) {
        this.projetoGerado = projetoGerado;
    }

}
