#language: pt
@consoleProjCRCObjetoStatus
Funcionalidade: Criacao pelo console de uma entidade de status com a fabrica de status gerada automaticamente

  Contexto: Projeto com a entidade Cliente gerada pelo FluxoConsoleObjetos, sem entidade ou fabrica de status

  Cenario: Criar StatusCliente com a fabrica FabStatusCliente gerada automaticamente e incluir os status pelo console
    Dado um projeto com a entidade Cliente carregado do resultado do FluxoConsoleObjetos
    E o projeto ainda nao possui a entidade StatusCliente
    E o projeto ainda nao possui a fabrica FabStatusCliente
    Quando o usuario digita StatusCliente no console
    Entao o console identifica o texto como entidade de status
    E a opcao principal sugerida e salvar a nova entidade StatusCliente como ObjetoStatusProjCRC
    Quando o usuario executa a criacao da entidade StatusCliente
    Entao a entidade StatusCliente fica salva no projeto como ObjetoStatusProjCRC
    E a fabrica de status FabStatusCliente e criada automaticamente sem nenhum status
    E a entidade StatusCliente e a fabrica FabStatusCliente ficam vinculadas nos dois sentidos
    Quando o usuario digita o nome da fabrica FabStatusCliente
    Entao o console identifica o texto como fabrica de status
    E a opcao principal sugerida e editar a fabrica FabStatusCliente
    E o console nao oferece a opcao de salvar a fabrica FabStatusCliente
    Quando o usuario digita o nome de uma fabrica de status inexistente FabStatusPedido
    Entao o console nao oferece nenhuma opcao de salvar fabrica de status
    E o autocompletar nao sugere o texto FabStatusPedido
    Quando o usuario digita FabStatusCliente seguido de ponto e ativo
    Entao a opcao principal sugerida e salvar o novo status ATIVO
    Quando o usuario executa a criacao do status ATIVO
    Entao o status ATIVO fica salvo em FabStatusCliente como item de status com idObjeto 1
    Quando o usuario digita FabStatusCliente seguido de ponto e inativo
    Entao a opcao principal sugerida e salvar o novo status INATIVO
    Quando o usuario executa a criacao do status INATIVO
    Entao o status INATIVO fica salvo em FabStatusCliente como item de status com idObjeto 2
    Quando o usuario digita FabStatusCliente seguido de ponto e inadimplente
    Entao a opcao principal sugerida e salvar o novo status INADIMPLENTE
    Quando o usuario executa a criacao do status INADIMPLENTE
    Entao o status INADIMPLENTE fica salvo em FabStatusCliente como item de status com idObjeto 3
    Quando o usuario digita FabStatusCliente seguido de ponto e inadimplente novamente
    Entao o console nao oferece a opcao de salvar o status INADIMPLENTE de novo
    E a opcao principal sugerida e editar o status INADIMPLENTE
    Quando o usuario digita FabStatusCliente seguido apenas de ponto
    Entao o autocompletar sugere os status ATIVO INATIVO e INADIMPLENTE
