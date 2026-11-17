#language: pt
@builderAtributoEnumStatus
Funcionalidade: Instanciacao pelo console e geracao de DadoDinamico de atributo de fabrica de status de entidade

  Contexto: Projeto com a entidade StatusCliente e a fabrica FabStatusCliente geradas pelo FluxoConsoleObjetoStatus

  Cenario: O console instancia AtributoDeEntidadeFabricaStatus a partir do texto StatusCliente ponto nomeAtributo iniciando com fabStatus e gera um DadoDinamico do tipo STATUS_ENUM
    Dado um projeto com a entidade StatusCliente e a fabrica FabStatusCliente carregado do resultado do FluxoConsoleObjetoStatus
    Quando o usuario digita StatusCliente seguido de ponto e fabStatus no console
    Entao o console instancia o atributo fabStatus como AtributoDeEntidadeFabricaStatus
    E o tipo de instancia do atributo fabStatus e ATRIBUTO_ENUM_STATUS
    E o atributo fabStatus ja vem com o tipo STATUS_ENUM
    E o atributo fabStatus ja vem vinculado a fabrica FabStatusCliente
    Quando o usuario salva o atributo fabStatus pela opcao principal
    Entao o atributo fabStatus fica salvo na entidade StatusCliente
    E o atributo fabStatus gera um DadoDinamico com o tipo STATUS_ENUM
