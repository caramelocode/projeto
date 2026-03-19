#!/bin/bash

set -euo pipefail
rm -rf /home/superBits/projetos/coletivoJava/source/fw/carameloWebAppTaglib/src/main/resources/META-INF/*
cp -a /home/superBits/projetos/carameloCode/source/projeto/webApp/src/main/webapp/META-INF/.  /home/superBits/projetos/coletivoJava/source/fw/carameloWebAppTaglib/src/main/resources/META-INF/
mkdir /home/superBits/projetos/coletivoJava/source/fw/carameloWebAppTaglib/src/main/resources/META-INF/resources -p
cp -a /home/superBits/projetos/carameloCode/source/projeto/webApp/src/main/webapp/resources/SBComp /home/superBits/projetos/coletivoJava/source/fw/carameloWebAppTaglib/src/main/resources/META-INF/resources/
cd /home/superBits/projetos/coletivoJava/source/fw/carameloWebAppTaglib/
mvn -DskipTests=true  clean install
echo "ok"