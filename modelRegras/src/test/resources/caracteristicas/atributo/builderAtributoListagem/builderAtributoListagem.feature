#language: pt
@builderAtributoListagem
Funcionalidade: Instanciacao pelo console e geracao de DadoDinamico de atributos de listagem de entidade

  Contexto: Projeto com a entidade Cliente e seus atributos gerados pelo FluxoConsoleObjetos

  Cenario: O console instancia AtrubutoEntidadeLista a partir do texto Entidade ponto nomeAtributo terminado em colchetes e cada tipo gera um DadoDinamico do mesmo tipo
    Dado um projeto com a entidade Cliente carregado do resultado do FluxoConsoleObjetos
    Quando o usuario digita Cliente seguido de ponto e clientesRelacionados terminado em colchetes no console
    Entao o console instancia o atributo clientesRelacionados como AtrubutoEntidadeLista
    E o tipo de instancia do atributo clientesRelacionados e ATRIBUTO_LISTAGEM
    Quando o usuario define o tipo LISTA_OBJETOS_PUBLICOS no atributo clientesRelacionados
    E define a entidadeItemLista como Cliente
    E o usuario salva o atributo clientesRelacionados usando o console
    Entao o atributo clientesRelacionados fica disponivel no console
    E o autocomplete apresenta a sugestão com colchete ao digitar somente o nome do atributo
    E o atributo clientesRelacionados gera um AtrubutoEntidadeLista com  com id diferente de nulo
    E tipo LISTA_OBJETOS_PUBLICOS
    Quando o usuario digita Cliente seguido de ponto e clientesParticulares terminado em colchetes no console
    Entao o console instancia o atributo clientesParticulares como AtrubutoEntidadeLista
    E o tipo de instancia do atributo clientesParticulares e ATRIBUTO_LISTAGEM
    E o atributo clientesParticulares lista itens da entidade Cliente
    Quando o usuario define o tipo LISTA_OBJETOS_PARTICULARES no atributo clientesParticulares
    E define a entidadeItemLista como Cliente
    E o usuario salva o atributo clientesParticulares com o console
    Entao o atributo clientesParticulares fica diponivel no console
    E o atributo clientesParticulares gera um AtrubutoEntidadeLista com id diferente de nulo
    E tipo LISTA_OBJETOS_PARTICULARES
