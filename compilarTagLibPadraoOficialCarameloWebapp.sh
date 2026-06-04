#!/bin/bash
cd /home/superBits/projetos/carameloCode/source/projeto/webApp
mvn -Dtest=br.org.carameloCode.erp.projeto.config.compilar.CompilarWebAppTest -DforkMode=once  --no-transfer-progress process-test-classes surefire:test

