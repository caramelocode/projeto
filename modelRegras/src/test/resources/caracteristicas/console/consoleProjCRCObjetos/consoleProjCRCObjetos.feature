# language: pt
@consoleProjCRCObjetos
Funcionalidade: Console de criacao de projetos com sugestoes conforme o texto digitado

  Contexto: Projeto existente aberto no console sem a entidade Cliente cadastrada

  Cenario: Criar entidade e atributos pelo console a partir das sugestoes
    Dado um projeto aberto no console sem a entidade Cliente
    Quando o usuario digita um texto com espacos e iniciando com letra minuscula
    Entao o texto definido fica sem espacos e com a primeira letra maiuscula
    Quando o usuario digita cliente
    Entao o console sugere Cliente
    E a opcao principal sugerida e criar entidade Cliente
    E a dica exibe orientacao sobre como criar um nome de entidade
    Quando o usuario executa a sugestao principal
    Entao a entidade Cliente passa a ser listada no projeto
    Quando o usuario digita apenas Cli
    Entao as opcoes disponiveis sao criar entidade Cli e editar entidade Cliente
    E o autocompletar sugere Cli com a acao criar entidade Cli
    E o autocompletar sugere Cliente com a acao editar entidade Cliente
    E o autocompletar sugere Cliente seguido de ponto com a acao listar atributos
    Quando o usuario seleciona Cliente seguido de ponto e digita n
    Entao o autocompletar sugere o atributo nome de Cliente com a acao editar
    E o autocompletar sugere o atributo n de Cliente com a acao criar atributo n
    Quando o usuario digita Cliente seguido de ponto e nomeCompleto
    Entao o autocompletar sugere apenas o atributo nomeCompleto com a acao criar atributo nomeCompleto
