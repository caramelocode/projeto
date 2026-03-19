/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.projeto.config.compilar;

import br.org.carameloCode.erp.crm.config.InicioFimContextoWebPagina;
import br.org.carameloCode.erp.projeto.config.TesteWPProjetoCarameloCode;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCShellBasico;
import com.super_bits.modulosSB.SBCore.modulos.ManipulaArquivo.UtilCRCArquivos;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author salvio
 */
public class CompilarWebAppTest extends TesteWPProjetoCarameloCode {

    @Test
    public void compilar() {

        InputStream inputStream = InicioFimContextoWebPagina.class.getClassLoader()
                .getResourceAsStream("devOpsTaglib/compilar.sh");
        if (inputStream == null) {

            Assert.fail("Script devOpsTaglib/compilar.shnão encontrado no resources.");

        }

        String diretorioExecuca = SBCore.getCaminhoDesenvolvimento();
        String nomeArquivo = "compilarTaglib.sh";
        File destino = new File(SBCore.getCaminhoDesenvolvimento() + nomeArquivo);
        try {
            Files.copy(inputStream, destino.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(CompilarWebAppTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        UtilCRCArquivos.tornarExecutavel(destino.toString());
        String resposta = UtilCRCShellBasico.executeCommand(destino.toString());
        System.out.println(resposta);
    }

}
