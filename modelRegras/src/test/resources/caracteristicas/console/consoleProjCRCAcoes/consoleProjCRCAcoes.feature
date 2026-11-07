#language: pt
@consoleProjCRCAcoes
Funcionalidade: Console de criacao de acoes a partir do nome da fabrica e do nome da acao
  Formato do nome FabAcao[NomeModulo][NomeEntidade opcional]_o_[NOME_ENTIDADE]_[TIPO_ACAO]_[DESCRICAO]
  Quando a fabrica informa so a entidade o modulo recebe o mesmo nome da entidade
  Quando a entidade nao existe a acao e criada sem entidade de dominio
  Ao reconhecer uma entidade o autocompletar inclui o texto seguido de _MB_ _FRM_ e _CTR_
  Depois do tipo o autocompletar mostra os subtipos possiveis como LISTAR EDITAR e SALVAR_MERGE
  A criacao de uma acao so e sugerida depois que o tipo e a descricao da acao sao digitados
  Com uma gestao criada os subtipos que ainda faltam sao listados nos dois formatos de fabrica
  Para edicao o console sugere as acoes existentes que comecam com o texto digitado
  As fabricas sao ordenadas pelas acoes editadas mais recentemente
  Com uma unica gestao no projeto a ordenacao das fabricas ainda nao e verificada

  Contexto: Projeto com a entidade Cliente e seus atributos gerados pelo FluxoConsoleObjetos

  Cenario: Criar as acoes de gestao da entidade Cliente pelo console
    Dado um projeto com a entidade Cliente criada pelo console de objetos
    E o projeto ainda nao possui nenhuma acao
    Quando o usuario digita somente FabAcao no projeto sem acoes
    Entao o console nao sugere nenhum ItemOpcaoConsole
    Quando o usuario digita FabAcaoGerente sem o nome da entidade
    Entao o autocompletar sugere FabAcaoGerenteCliente e FabAcaoGerente_o_CLIENTE pela entidade cadastrada mais recentemente
    Quando o usuario digita FabAcaoGerente_o_CLIENTE sem o tipo da acao
    Entao o autocompletar sugere FabAcaoGerente_o_CLIENTE_MB_ FabAcaoGerente_o_CLIENTE_FRM_ e FabAcaoGerente_o_CLIENTE_CTR_
    E o console nao sugere criar uma acao sem tipo e descricao
    Quando o usuario digita FabAcaoGerente_o_CLIENTE_FRM_ sem o subtipo
    Entao o autocompletar inclui os subtipos de formulario LISTAR EDITAR VISUALIZAR e NOVO
    Quando o usuario digita FabAcaoGerente_o_CLIENTE_CTR_ sem o subtipo
    Entao o autocompletar inclui os subtipos de controller SALVAR_MERGE ALTERAR_STATUS e REMOVER
    Quando o usuario digita FabAcaoCliente_o_CLIENTE_FRM_LISTAR antes de criar a gestao
    Entao o ItemOpcaoConsole de criacao usa Cliente como nome do modulo e como entidade de dominio
    Quando o usuario digita FabAcaoGerente_o_FORNECEDOR_FRM_LISTAR com entidade inexistente
    Entao o ItemOpcaoConsole de criacao nao possui entidade de dominio
    Quando o usuario digita FabAcaoGerenteCliente_o_CLIENTE_FRM_LISTAR antes de criar a gestao
    Entao o ItemOpcaoConsole de criacao usa Gerente como nome do modulo e Cliente como entidade de dominio
    Quando o usuario digita FabAcaoGerente_o_CLIENTE_MB_GESTAO para criar a gestao
    Entao a opcao principal sugerida e criar FabAcaoGerente_o_CLIENTE_MB_GESTAO no modulo Gerente com a entidade Cliente
    Quando o usuario executa a criacao de FabAcaoGerente_o_CLIENTE_MB_GESTAO
    Entao FabAcaoGerente_o_CLIENTE_MB_GESTAO fica registrada com o tipo gerenciar entidade
    Quando o usuario digita FabAcaoGerente_o_CLIENTE depois de criar a gestao
    Entao o autocompletar lista os subtipos ainda nao criados da gestao de Cliente
    Quando o usuario digita FabAcaoGerenteCliente_o_CLIENTE depois de criar a gestao
    Entao o autocompletar no outro formato de fabrica tambem lista os subtipos ainda nao criados
    Quando o usuario cria FabAcaoGerente_o_CLIENTE_FRM_LISTAR
    Entao FabAcaoGerente_o_CLIENTE_FRM_LISTAR fica registrada com o comportamento listar
    Quando o usuario cria FabAcaoGerente_o_CLIENTE_FRM_EDITAR
    Entao FabAcaoGerente_o_CLIENTE_FRM_EDITAR fica registrada com o comportamento editar
    Quando o usuario cria FabAcaoGerente_o_CLIENTE_FRM_VISUALIZAR
    Entao FabAcaoGerente_o_CLIENTE_FRM_VISUALIZAR fica registrada com o comportamento visualizar
    Quando o usuario cria FabAcaoGerente_o_CLIENTE_FRM_NOVO
    Entao FabAcaoGerente_o_CLIENTE_FRM_NOVO fica registrada com o comportamento novo registro
    Quando o usuario cria FabAcaoGerente_o_CLIENTE_CTR_SALVAR_MERGE
    Entao FabAcaoGerente_o_CLIENTE_CTR_SALVAR_MERGE fica registrada com o comportamento salvar em modo merge
    Quando o usuario cria FabAcaoGerente_o_CLIENTE_CTR_ALTERAR_STATUS
    Entao FabAcaoGerente_o_CLIENTE_CTR_ALTERAR_STATUS fica registrada com o comportamento ativar e desativar
    Quando o usuario cria FabAcaoGerente_o_CLIENTE_CTR_REMOVER
    Entao FabAcaoGerente_o_CLIENTE_CTR_REMOVER fica registrada com o comportamento remover
    Quando o usuario cria FabAcaoGerente_o_CLIENTE_CTR_ACAO_TESTE_PERSONALIZADA
    Entao FabAcaoGerente_o_CLIENTE_CTR_ACAO_TESTE_PERSONALIZADA fica registrada com o comportamento personalizado
    Quando o usuario digita FabAcaoGerente depois de criar as acoes de Cliente
    Entao as nove acoes de Cliente sao sugeridas como ItemOpcaoConsole de edicao
    E todas as acoes de Cliente pertencem a FabAcaoGerente_o_CLIENTE_MB_GESTAO
    Quando o usuario digita FabAcaoGerente_o_CLIENTE_FRM_ depois de criar as acoes
    Entao apenas os quatro formularios de Cliente sao sugeridos para edicao
    Quando o usuario digita FabAcaoGerente_o_CLIENTE com todos os subtipos criados
    Entao o autocompletar nao lista subtipos pendentes da gestao de Cliente
