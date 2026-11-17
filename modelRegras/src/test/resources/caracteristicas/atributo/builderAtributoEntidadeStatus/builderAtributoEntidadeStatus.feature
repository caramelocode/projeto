#language: pt
@builderAtributoEntidadeStatus
Funcionalidade: Instanciacao pelo console e geracao de DadoDinamico de atributo de status de entidade

  Contexto: Projeto com as entidades Cliente e StatusCliente geradas pelo FluxoConsoleObjetoStatus

  Cenario: O console instancia AtributoDeEntidadeStatus a partir do texto Cliente ponto status vinculado a entidade StatusCliente
    Dado um projeto com as entidades Cliente e StatusCliente carregado do resultado do FluxoConsoleObjetoStatus
    Quando o usuario digita Cliente seguido de ponto e status no console
    Entao o console instancia o atributo status como AtributoDeEntidadeStatus
    E o tipo de instancia do atributo status e ATRIBUTO_ENTIDADE_STATUS
    E o atributo status ja vem com o tipo OBJETO_DE_UMA_LISTA
    E o atributo status ja vem vinculado a entidade StatusCliente encontrada pelo nome
    Quando o usuario salva o atributo status pela opcao principal
    Entao o atributo status fica salvo na entidade Cliente
    E o atributo status salvo referencia a entidade StatusCliente
    E o atributo status gera um DadoDinamico com o tipo OBJETO_DE_UMA_LISTA
