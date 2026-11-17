#language: pt
@consoleProjCRCFabEntidadeEstatica
Funcionalidade: Criacao de fabrica de entidade estatica e seus itens pelo console

  Contexto: Projeto com a entidade Cliente e as acoes geradas pelo FluxoConsoleAcoes

  Cenario: Criar a fabrica FabTipoCliente com os itens CLIENTE_VIP e CLIENTE_PADRAO pelo console
    Dado um projeto com a entidade Cliente e acoes criadas pelo console de acoes
    E o projeto ainda nao possui a fabrica FabTipoCliente
    Quando o usuario digita o nome da fabrica FabTipoCliente
    Entao o console identifica o texto como fabrica de entidade generica
    E a opcao principal sugerida e salvar a nova fabrica FabTipoCliente
    Quando o usuario executa a criacao da fabrica FabTipoCliente
    Entao a fabrica FabTipoCliente fica salva no projeto como fabrica generica
    Quando o usuario digita FabTipoCliente seguido de ponto e clienteVip
    Entao a opcao principal sugerida e salvar o item CLIENTE_VIP
    Quando o usuario executa a criacao do item CLIENTE_VIP
    Entao o item CLIENTE_VIP fica salvo em FabTipoCliente com idObjeto 1
    Quando o usuario digita FabTipoCliente seguido de ponto e CLIENTE_PADRAO
    Entao a opcao principal sugerida e salvar o item CLIENTE_PADRAO
    Quando o usuario executa a criacao do item CLIENTE_PADRAO
    Entao o item CLIENTE_PADRAO fica salvo em FabTipoCliente com idObjeto 2
    Quando o usuario digita FabTipoCliente seguido apenas de ponto
    Entao o autocompletar sugere os itens CLIENTE_VIP e CLIENTE_PADRAO
