#language: pt
@builderAtributoSimples
Funcionalidade: Instanciacao pelo console e geracao de DadoDinamico de atributos simples de entidade

  Contexto: Projeto com a entidade Cliente e seus atributos gerados pelo FluxoConsoleObjetos

  Cenario: O console instancia AtributoDeEntidadeSimples a partir do texto Entidade ponto nomeAtributo sem nenhuma marcacao especial e cada tipo gera um DadoDinamico do mesmo tipo
    Dado um projeto com a entidade Cliente carregado do resultado do FluxoConsoleObjetos
    Quando o usuario digita um nome pra cada tipo de dado simples
    E e executarOpcaoSelecionada com a primeira opção sugerida
    Entao os campos são peristidos no sistema
    E os tipos que são definidos de forma automatica são definidos de forma automática
    E a visibilidade das propriedades do atributos estão de acordo
    Quando o usuario lista os campos que precisam ter o tipo definido na mão
    E e o usuário define os tipos
    Entao a visibilidade das propriedades destes campo ficam de acordo com o esperado
