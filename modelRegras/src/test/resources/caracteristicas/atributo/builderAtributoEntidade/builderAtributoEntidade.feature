#language: pt
@builderAtributoEntidade
Funcionalidade: Instanciacao pelo console de atributos de entidade que referenciam outra entidade

  Contexto: Projeto com a entidade Cliente e seus atributos gerados pelo FluxoConsoleObjetos

  Cenario: O console instancia AtributoEntidadeEntidade pelo nome reservado ou pelo texto terminado em ponto e a visibilidade das propriedades acompanha o tipo
    Dado um projeto com a entidade Cliente carregado do resultado do FluxoConsoleObjetos
    Quando o usuario digita um nome para cada tipo de atributo de entidade
    E o usuario executa a primeira opcao sugerida de cada atributo
    Entao os atributos sao persistidos como AtributoEntidadeEntidade
    E os tipos dos nomes reservados sao definidos de forma automatica
    E o atributo clienteIndicou referencia a entidade Cliente
    E a visibilidade das propriedades dos atributos esta de acordo
    Quando o usuario lista os atributos que precisam ter o tipo definido na mao
    E o usuario define os tipos
    Entao o campo tipo exibe apenas os tipos compativeis com AtributoEntidadeEntidade
    E a visibilidade das propriedades destes atributos fica de acordo com o esperado
