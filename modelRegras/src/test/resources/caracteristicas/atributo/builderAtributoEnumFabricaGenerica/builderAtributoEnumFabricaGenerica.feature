#language: pt
@builderAtributoEnumFabricaGenerica
Funcionalidade: Instanciacao pelo console e geracao de DadoDinamico de atributo de fabrica generica de entidade

  Contexto: Projeto com a entidade Cliente e a fabrica FabTipoCliente geradas pelo FluxoConsoleFabEntidadeEstatica

  Cenario: O console instancia AtributoDeEntidadeFabrica a partir do texto Cliente ponto nomeAtributo iniciando com fab e gera um DadoDinamico do tipo ENUM_FABRICA
    Dado um projeto com a entidade Cliente e a fabrica FabTipoCliente carregado do resultado do FluxoConsoleFabEntidadeEstatica
    Quando o usuario digita Cliente seguido de ponto e fabTipoCliente no console
    Entao o console instancia o atributo fabTipoCliente como AtributoDeEntidadeFabrica
    E o tipo de instancia do atributo fabTipoCliente e ATRIBUTO_ENUM_FABRICA_GENERICA
    E o atributo fabTipoCliente ja vem com o tipo ENUM_FABRICA
    E o atributo fabTipoCliente ja vem vinculado a fabrica FabTipoCliente
    Quando o usuario salva o atributo fabTipoCliente pela opcao principal
    Entao o atributo fabTipoCliente fica salvo na entidade Cliente
    E o atributo fabTipoCliente gera um DadoDinamico com o tipo ENUM_FABRICA
