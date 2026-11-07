# language: pt
@CadastroProjetoCRC
Funcionalidade: Cadastro de projeto no sistema

  Contexto: Usuario existente e autenticado com permissao para cadastrar projetos

  Cenario: Criar um novo projeto com dados validos
    Dado um novo projeto com nome informado
    E com descricao informada
    Quando o usuario solicita a criacao do projeto
    Entao o projeto e salvo com sucesso
    E o projeto fica disponivel na consulta de projetos
