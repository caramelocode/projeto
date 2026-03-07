# Projeto do Caramelo Code

**Projeto** é uma plataforma open source para **criar, gerenciar e publicar sistemas construídos com o Framework CarameloCode**.

A aplicação permite que desenvolvedores construam sistemas empresariais utilizando o modelo de desenvolvimento baseado em **objetos e ações** oferecido pelo **CarameloCode**.

O objetivo do Projeto é facilitar a criação e a publicação de aplicações corporativas completas, com infraestrutura pronta e módulos reutilizáveis.

---

## Framework CarameloCode

O **CarameloCode** é um framework para desenvolvimento de sistemas corporativos, especialmente voltado para **sistemas utilizados no Brasil**.

Ele abstrai o desenvolvimento a partir de um modelo baseado em:

- **Objetos** — entidades do domínio
- **Ações** — operações executadas sobre esses objetos

Essa abordagem permite estruturar fluxos de negócio complexos de forma organizada.

---

## Tecnologias Utilizadas

Os sistemas construídos com o CarameloCode utilizam tecnologias consolidadas do ecossistema Java:

- Java
- Hibernate / JPA
- JSF
- PrimeFaces
- Docker

---

## Módulos Disponíveis:

- CRM
- Controle de Caixa e estoque Simples
- Compartilhamento de Documentos 
- Area do Cliente

## Muitas integrações:
- Celcoin
- Whatsapp
- Matrix.org
- Simple Mail Server
- s3
- SNS

---

## Como Usar

Existem duas formas de utilizar o **Projeto**.

### Plataforma hospedada

Você pode criar uma conta gratuita em:

https://app.caramelocode.com.br

A conta gratuita permite:

- até **10 projetos**
- criação de sistemas utilizando o framework
- gerenciamento centralizado dos projetos
- Marketing place de componentes visuais
- Marketing place de Sistemas
- hospedagem de sistemas

--- e outras funções.

### Executar com Docker, por conta própria.

Também é possível executar sua própria instância do **Projeto** utilizando Docker.

Exemplo:

```bash
docker pull caramelocode/projeto:latest
docker run -p 8080:8080 caramelocode/projeto:latest
