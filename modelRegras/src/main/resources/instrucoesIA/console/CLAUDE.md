# Console do Caramelo Projetos

O console é a entrada de texto onde o usuário digita nomes de itens do projeto (entidades, atributos, ações, fábricas...). A cada texto digitado, o console:
1. normaliza o texto;
2. descobre o tipo de item;
3. gera as sugestões de autocompletar (textos);
4. gera as opções disponíveis (ação + item associado);
5. executa a opção selecionada.

Pacote base: `br.org.carameloCode.erp.modulo.projeto` (em `modelRegras/src/main/java`).

Documentos relacionados:
- `instrucoesIA/modelCarameloCode`: entidades (`ObjetoProjCRC`) e atributos, `prepararNovoObjeto`, `FabTiposEntidade`;
- `instrucoesIA/acoesCarameloCode`: ações do projeto (`AcaoProjCRC`) criadas pelo console, formato do nome, tipos e regra de negócio;
- `instrucoesIA/cucumberGeral`: regras dos arquivos `.feature`.

## Classes envolvidas

| Classe | Papel |
|---|---|
| `console/ComoConsoleCRCProjeto` | Contrato do console. |
| `console/ConsoleCRCProjeto` | Implementação. Guarda o estado (texto definido, tipo da pesquisa, dica, opções, opção selecionada, repositório). |
| `console/ItemOpcaoConsole` | Uma opção do console: texto digitado, ação (`ComoFabricaAcoes`), item associado (`ComoItemProjeto`), ordem, formulário de detalhes e include de preview. |
| `console/texto/UtilConsoleCRCTexto` | Texto de depuração: pesquisa, sugestões, opções e resultado da execução. |
| `entidadesJPA/projetoBuilderCRC/itemProjeto/FabTipoItemProjeto` | **Onde fica a regra de cada tipo de item**: dica, sugestões de autocompletar, opções e criação do item a partir do texto. |
| `entidadesJPA/projetoBuilderCRC/itemProjeto/RepositorioConsole` | Cache dos itens do projeto aberto, com um EntityManager próprio. |
| `entidadesJPA/projetoBuilderCRC/itemProjeto/UtilProjCRCItemProjetoTexto` | Normalização e separação do texto (`Entidade.atributo`). |
| `entidadesJPA/projetoBuilderCRC/itemProjeto/acoes/UtilProjCRCNomeAcao` | Interpretação do texto de ações (`FabAcao.......`), ver `acoesCarameloCode`. |
| `entidadesJPA/projetoBuilderCRC/itemProjeto/fabrica/UtilProjCRCNomeFabrica` | Interpretação do texto de fábricas (`FabStatusPedido`, `FabTipoPagamento.cartao`). |
| `entidadesJPA/projetoBuilderCRC/itemProjeto/ComoItemProjeto` | Interface que todo item exibido no console precisa implementar (`getTipoItemProjeto()`). |

## Fluxo do `autocompletProjeto(pValor)`

```java
textoDefinido = UtilProjCRCItemProjetoTexto.getTextoNormatizado(pValor); // sem espaços, 1ª letra maiúscula
opcaoSelecionada = null;                                                  // sempre zera a seleção anterior
tipoPesquisa = FabTipoItemProjeto.getTipoItemPorTexto(textoDefinido);
List<String> sugestoes = tipoPesquisa.textosSugestaoAutocomplete(this, textoDefinido); // sempre o texto NORMALIZADO
textoDica = tipoPesquisa.getTextoDica();
opcoesDisponiveis = tipoPesquisa.getOpcoesConsole(this);
UtilCRCListasObjeto.ordernarPorCampo(opcoesDisponiveis, "ordem");
UtilConsoleCRCTexto.imprimirPesquisa(this, sugestoes);                    // só em modo desenvolvimento
```

### `setTextoDefinido(pValor)` (usado pelos testes)
Faz a mesma pesquisa sem gerar sugestões nem imprimir: normaliza o texto, **zera `opcaoSelecionada`**, descobre o tipo e gera `opcoesDisponiveis`. **Não ordena** a lista; como o `getOpcoesConsole` já monta as opções em ordem crescente, a lista sai na ordem certa, mas não dependa disso (use `getOpcaoPrincipalSugerida()`).

### Opção principal e opção selecionada
- `getOpcaoPrincipalSugerida()` devolve a opção de **menor `ordem`**, mesmo quando há várias opções, sem depender da lista estar ordenada. Devolve `null` só se não houver opções.
- `getOpcaoSelecionada()` devolve a opção principal se nenhuma tiver sido escolhida com `setOpcaoSelecionada`.
- Digitar um texto novo (`autocompletProjeto` ou `setTextoDefinido`) sempre descarta a opção escolhida para o texto anterior.
- `getTipoPesquisa()` devolve o `FabTipoItemProjeto` da última pesquisa.
- `executarOpcaoSelecionada()` sem opção escolhida executa a opção principal. Só executa ações de controller (`isUmaAcaoController()`), pelo `CarameloCode.getServicoController().getResposta(acao, item)`. Se der certo, chama `repositorio.recarregarRepositorio()`. Ações de formulário (FRM) não são executadas pelo console; elas abrem o formulário na view.
- O método é `void`. Em caso de falha, ele só dispara as mensagens da resposta ou registra o erro. Para verificar o resultado no teste, confira o efeito no repositório ou no banco. Em modo desenvolvimento, o resultado (sucesso/falha e mensagens) é impresso pelo `UtilConsoleCRCTexto`.

### Ordem das opções (`getOpcoesConsole`)
Em todos os tipos a ordem começa em 1 e aumenta de 1 em 1, sem repetir. Se o `prepararNovoObjeto` da opção de criar falhar, ela é pulada sem consumir o número.

| Tipo | Ordem |
|---|---|
| `OBJETO` | entidade existe: editar (1), listar atributos (2). Não existe: criar (1), depois o par editar + listar de cada entidade parecida |
| `ATRIBUTO_OBJETO` | criar (1, se o nome não existe), depois editar cada atributo que começa com o texto |
| `ACAO` | criar (1, nome completo e inexistente), depois editar as existentes, as editadas mais recentemente primeiro |
| `FABRICA_STATUS` / `FABRICA_ENTIDADE_GENERICA` | sem ponto: criar a fábrica, ou editar a fábrica + novo item; depois as outras fábricas. Com ponto: criar o item, depois editar os itens na ordem do `idObjeto` |

- Em `ATRIBUTO_OBJETO`, as opções de editar seguem a ordem de `entidade.getAtributos()`, carregada com `@OrderBy("ordem ASC, id ASC")`. A `ordem` do atributo é calculada por `ValorLogicoAtributoDeEntidadeSimplesOrdem` (maior ordem dos outros atributos salvos da entidade + 1, começando em 1; 0 = ainda não definida) e gravada ao salvar. Atributos antigos, com ordem 0, ficam no início, na ordem do id. Mesmo assim, nos testes escolha a opção pelo nome declarado do item associado, não pela posição.

## Identificação do tipo (`getTipoItemPorTexto`)

1. Se o texto começa com `FabAcao` (`UtilProjCRCNomeAcao.PREFIXO_FABRICA`, o mesmo de `getSlugInicialTipoItem(ACAO)`), o tipo é `ACAO`.
2. Se o texto começa com `FabStatus` seguido de letra maiúscula, de ponto ou do fim do texto (`UtilProjCRCNomeFabrica.isTextoFabricaStatus`), o tipo é `FABRICA_STATUS`.
3. Se o texto começa com `Fab` seguido de letra maiúscula (`UtilProjCRCNomeFabrica.isTextoFabrica`), o tipo é `FABRICA_ENTIDADE_GENERICA`. `Fabrica` continua sendo `OBJETO`.
4. Se o texto começa com o identificador de algum `FabTipoItemProjeto` (`getIdentificadorUnico()`), o tipo é esse.
5. Se contém `.` (`FabTipoItemProjeto.SEPARADOR_ATRIBUTO`), o tipo é `ATRIBUTO_OBJETO`. Os textos de fábrica com ponto já foram identificados antes.
6. Caso contrário, o tipo é `OBJETO`.

**Planejado:** `Status` seguido de letra maiúscula (`StatusCliente`, `ObjetoStatusProjCRC.isNomeEntidadeStatus`) passa a criar uma entidade de status. Ver [Regras planejadas](#regras-planejadas-testadas-pelos-fluxos-ainda-não-implementadas).

Prefixos previstos em `getSlugInicialTipoItem`: `FabAcao` (ACAO), `Req` (REQUISITO), `FabComp` (COMPONENTE_VISUAL), `FabStatus`, `FabGrupo`, `FabModulo`, `Fluxo` (FLUXO_TESTES), `Fab` (FABRICA_ENTIDADE_GENERICA).
- **Estão ligados os prefixos de `ACAO`, `FABRICA_STATUS` e `FABRICA_ENTIDADE_GENERICA`.** Ligar os demais faria uma entidade chamada `Requisicao` ou `Fluxograma` mudar de tipo. Ao implementar outro tipo por prefixo, exija o prefixo seguido de letra maiúscula e verifique antes os prefixos mais longos.
- Enquanto `FabComp`, `FabGrupo` e `FabModulo` não forem implementados, esses textos são tratados como `FABRICA_ENTIDADE_GENERICA`. Ao implementá-los, verifique-os **antes** de `Fab`.

## Regras já implementadas

### OBJETO (texto sem ponto, ex.: `Cli`, `Cliente`)
- **Autocompletar:**
  - o próprio texto;
  - para cada entidade parecida (`repositorio.getLista3ObjetosMaisParecidos`), o nome dela e o nome seguido de ponto (`Cliente`, `Cliente.`), sem repetir nomes.
- **Opções quando a entidade existe** (nome exato):
  1. `ENTIDADE_FRM_EDITAR` da entidade;
  2. `ATRIBUTO_ENTIDADE_FRM_LISTAR` da entidade.
- **Opções quando a entidade não existe:**
  1. `ENTIDADE_CTR_SALVAR` com um `ObjetoProjCRC` novo, criado por `getItemByTexto`, que usa `prepararNovoObjeto(projeto, nome)`. O formulário de detalhes é `ENTIDADE_FRM_NOVO`.
  2. Para cada entidade parecida: editar e listar atributos.
- O método privado `adicionarOpcoesEntidadeExistente` gera o par editar + listar atributos e devolve a próxima ordem.

### ATRIBUTO_OBJETO (`Entidade.texto`, ex.: `Cliente.n`, `Cliente.`, `Cliente.nomeCompleto`)
- A entidade é buscada pela parte antes do ponto (`getPrimeiraParte`). Se não existir, não há sugestões nem opções.
- Os atributos são filtrados pelo **início do nome**: o nome declarado começa com o texto depois do ponto. Se o texto depois do ponto for vazio, aparecem todos.
  - Não use `filtrarOrdenandoMaisParecidos` aqui. A busca por semelhança traria "nome" ao digitar "nomeCompleto", e ela indexa por id, que é `null` em atributo novo.
- **Autocompletar:**
  - `Entidade.texto`, se o texto não for vazio e não existir atributo com esse nome exato;
  - `Entidade.atributo` para cada atributo que combina; atributos de listagem (`AtrubutoEntidadeLista`) são sugeridos com o sufixo `[]` (`Cliente.clientesRelacionados[]`), mesmo quando o usuário digita o nome sem os colchetes.
- **Opções:**
  1. Criar o atributo novo, quando o nome não existe. A classe depende do texto (veja a tabela abaixo).
  2. `ATRIBUTO_ENTIDADE_FRM_EDITAR` para cada atributo existente que combina.
- Um atributo novo **não** é adicionado em `entidade.getAtributos()`, para não alterar o objeto gerenciado pelo repositório. Ele só referencia a entidade.
- **Classe e tipo do atributo novo** (regras em `FabTipoInstanciaAtributoProjeto`, nome comparado sem diferenciar maiúsculas):

| Texto digitado | Classe | Tipo | Ação |
|---|---|---|---|
| termina em `[]` (`Cliente.clientesRelacionados[]`) | `AtrubutoEntidadeLista`, `entidadeItemLista` deduzida pelo nome | `ATRIBUTO_LISTAGEM.getTipoPeloNome` (padrão `LISTA_OBJETOS_PUBLICOS`) | `ATRIBUTO_ENTIDADE_CTR_SALVAR_ATRIBUTO_TP_LISTA` |
| termina em `.` (`Cliente.clienteIndicou.`) **ou** nome reservado de entidade (`getTipoInstanciaPeloNome` = `ATRIBUTO_ENTIDADE`) | `AtributoEntidadeEntidade` | `ATRIBUTO_ENTIDADE.getTipoPeloNome` (padrão `OBJETO_DE_UMA_LISTA`) | `ATRIBUTO_ENTIDADE_CTR_SALVAR_ATRIBUTO_TP_ENTIDADE` |
| demais (`Cliente.logo`) | `AtributoDeEntidadeSimples` | `ATRIBUTO_SIMPLES.getTipoPeloNome` (padrão `TEXTO_SIMPLES`) | `ATRIBUTO_ENTIDADE_CTR_SALVAR` |

- **Nomes reservados de entidade** (`TIPOS_POR_NOME_EXATO_ATRIBUTOS_ENTIDADE`): `bairro` → `LC_BAIRRO`, `cidade` → `LC_CIDADE`, `uf` e `unidadeFederativa` → `LC_UNIDADE_FEDERATIVA`, `localizacao` → `LC_LOCALIZACAO`, `usuarioCriacao` → `REG_USUARIO_INSERCAO`, `usuarioEdicao` → `REG_USUARIO_ALTERACAO`. Valem com ou sem o ponto final.
- `entidadeReferenciada` só é preenchida (pelo nome, `getEntidadeReferenciadaPeloNome`) e só é obrigatória ao salvar (`salvarAtributoTipoEntidade`) no tipo `OBJETO_DE_UMA_LISTA`. Nos tipos de localidade e de usuário a entidade é fixa.
- **Tipo pelo nome de atributo simples (`ATRIBUTO_SIMPLES.getTipoPeloNome`)**, na ordem:
  1. nome exato: `dataCriacao` → `REG_DATAINSERCAO`, `dataEdicao` → `REG_DATAALTERACAO`, `nome` → `NOME`, `logo` → `IMG_PEQUENA`, `logoHorizontal` → `IMG_MEDIA`, `descricao` → `DESCRITIVO`, `id` → `ID`, `latitude` → `LATITUDE`, `longitude` → `LONGITUDE`, `cep` → `LCCEP`, `senha` → `SENHA`, `complemento` → `LC_COMPLEMENTO_E_NUMERO`, `telefone` → `TELEFONE_GENERICO`, `cor` → `COR`, `email` → `EMAIL`, `icone` → `ICONE`;
  2. começa com `qtd` → `QUANTIDADE`;
  3. contém `modelo` → `HTML_TEMPLATE`;
  4. contém `dataHora` → `DATAHORA`; senão contém `data` → `DATA`; senão contém `hora` → `HORA`;
  5. nenhum: `getTipoPadrao()` = `FabTiposEntidade.TIPO_PADRAO_ATRIBUTO_SIMPLES` (`TEXTO_SIMPLES`).

  O usuário pode trocar o tipo no formulário. Os mapas `TIPOS_AUTODETECTAVEIS` e `ATRIBUTOS_DETECTADOS_PELO_NOME` do `FluxoBuilderAtributoSimples` e `ATRIBUTOS_DETECTADOS_PELO_NOME` do `FluxoBuilderAtributoEntidade` precisam acompanhar essas regras.
- **Planejado:** status, `fab` e `fabStatus` definindo a classe. Ver [Regras planejadas](#regras-planejadas-testadas-pelos-fluxos-ainda-não-implementadas).

### ACAO (`FabAcao[Modulo][Entidade].[ENTIDADE]_[MB|FRM|CTR]_[DESCRICAO]`)
Formato do nome, tipos, módulo, gestão e regra de negócio estão em `instrucoesIA/acoesCarameloCode`. Aqui fica só o comportamento do console. Exemplos com a entidade `Cliente`:

| Texto digitado | Autocompletar | Opções |
|---|---|---|
| `FabAcao` | nada (falta o módulo) | editar as ações existentes que começam com o texto |
| `FabAcaoGerente` | `FabAcaoGerenteCliente` e `FabAcaoGerente.CLIENTE`, pela entidade com `dataHoraInsersao` mais recente | editar as existentes que começam com o texto |
| `FabAcaoGerente.` | `FabAcaoGerente.CLIENTE` (entidade mais recente) | editar as existentes |
| `FabAcaoGerente.CLIENTE` | `..._MB_`, `..._FRM_`, `..._CTR_` e, se a gestão já existe, os **subtipos padrão ainda não criados** (`..._FRM_LISTAR`...) | editar as existentes |
| `FabAcaoGerente.CLIENTE_FRM_` | subtipos padrão do tipo que começam com a descrição (`..._FRM_LISTAR`, `..._FRM_EDITAR`...) | editar as existentes (ex.: os formulários já criados) |
| `FabAcaoGerente.CLIENTE_CTR_ACAO_X` | o próprio texto (descrição personalizada) | 1: criar (`ACOES_CTR_SALVAR`), se o nome único não existir; depois editar as existentes |

- **Criar** só aparece com o nome completo (módulo, entidade, tipo e descrição) e se o nome único (`FabAcaoGerente.CLIENTE_CTR_ACAO_X`) ainda não existe no repositório. É sempre a ordem 1.
- O item da opção de criar vem de `getItemByTexto`: `AcaoProjCRCGestao`, `AcaoProjCRCFormulario` ou `AcaoProjCRCContoller`, conforme a sigla, preparado com `prepararNovoObjeto(projeto, texto)`.
- **Editar:** para cada ação salva cujo texto no console (`UtilProjCRCNomeAcao.getTextoConsole(nomeUnico)`) começa com o texto digitado (`repositorio.getAcoesIniciandoCom`), as editadas mais recentemente primeiro.
- A ação da opção (e o formulário de detalhes) é: formulário → `ACOES_FRM_EDITAR_ACAO_FORMULARIO`; controller → `ACOES_FRM_EDITAR_ACAO_CONTROLLER`; gestão → `ACOES_FRM_VISAO_GERAL`.
- Os subtipos pendentes são calculados pela gestão do **módulo + domínio**, então `FabAcaoGerente.CLIENTE` e `FabAcaoGerenteCliente.CLIENTE` listam os mesmos pendentes (cada um no seu formato de fábrica).
- As ações existentes **não** entram no autocompletar, só nas opções. Assim a lista de sugestões de `FabAcaoGerente.CLIENTE` mostra só o que falta criar.

### FABRICA_STATUS e FABRICA_ENTIDADE_GENERICA (`FabStatusPedido`, `FabStatusPedido.emAnd`, `FabTipoPagamento.cartao`)
O modelo fica em `entidadesJPA/projetoBuilderCRC/itemProjeto/fabrica`. `FabricaProjCRC` (e a subclasse `FabricaStatusProjCRC`) gera o enum, e cada `ItemFabrica` (e `ItemFabricaStatus`) gera uma constante com `@InfoObjetoDaFabrica(id = idObjeto, nomeObjeto, cor, icone, classeObjeto = tipoObjeto)`. A regra de negócio fica em `regraDeNegocio/fabrica/ExecAcoesFabricasCRC`. Os dois tipos usam a mesma regra (`getOpcoesConsoleFabrica` e `getSugestoesFabrica`), e cada um usa as ações do seu bloco em `FabAcaoCarameloDevComoItemProjeto`:

| | FABRICA_STATUS | FABRICA_ENTIDADE_GENERICA |
|---|---|---|
| salvar fábrica | `FABRICA_STATUS_CTR_SALVAR_MERGE` | `FABRICA_GENERICA_CTR_SALVAR_MERGE` |
| editar fábrica | `FABRICA_STATUS_FRM_EDITAR` | `FABRICA_GENERICA_FRM_EDITAR` |
| salvar item | `ITEM_FABRICA_STATUS_CTR_SALVAR_MERGE` | `ITEM_FABRICA_GENERICA_CTR_SALVAR_MERGE` |
| novo item | `ITEM_FABRICA_STATUS_FRM_NOVO` | `ITEM_FABRICA_GENERICA_FRM_NOVO` |
| editar item | `ITEM_FABRICA_STATUS_FRM_EDITAR` | `ITEM_FABRICA_GENERICA_FRM_EDITAR` |

**Sem ponto (`FabStatusPedido`):**
- **Autocompletar:**
  - o próprio texto, se a fábrica não existir e o nome tiver algo além do prefixo (`isNomeFabricaCompleto`). Só `FabStatus` não sugere criar;
  - para cada fábrica **do mesmo tipo** que começa com o texto (`repositorio.getFabricasIniciandoCom`), o nome e o nome seguido de ponto.
- **Opções:**
  1. Se a fábrica não existe: salvar uma fábrica nova (`FabricaStatusProjCRC` ou `FabricaProjCRC`, com `prepararNovoObjeto(projeto, nome)`). O formulário de detalhes é o de editar fábrica.
     - **Planejado para FABRICA_STATUS:** essa opção deixa de existir, assim como a sugestão do próprio texto no autocompletar. A fábrica de status passa a ser criada automaticamente ao salvar a entidade de status (`StatusCliente` gera `FabStatusCliente`). Pelo console, só é possível editá-la e incluir itens.
  2. Se a fábrica existe (nome exato e mesmo tipo): editar a fábrica e, em seguida, o formulário de novo item com um item sem nome.
  3. Editar as demais fábricas do tipo que começam com o texto.

**Com ponto (`FabStatusPedido.emAnd`):** a fábrica precisa existir e ser do tipo. Se não for, não há sugestões nem opções.
- O nome digitado é convertido com `ItemFabrica.getNomeEnumPorTexto`: `emAnd` e `EM_AND` viram `EM_AND`. Os itens são filtrados pelo **início do `nomeEnum`**, na ordem do `idObjeto`. Se o texto depois do ponto for vazio, aparecem todos.
- **Autocompletar:**
  - o próprio texto, se o nome não for vazio e o item não existir;
  - `Fabrica.NOME_ENUM` para cada item que combina.
- **Opções:**
  1. Se o item não existe: salvar um item novo (`ItemFabricaStatus` para fábrica de status, `ItemFabrica` para a genérica, com `prepararNovoObjeto(fabrica, nome)`). O formulário de detalhes é o de novo item.
  2. Editar cada item existente que combina.
- Fábricas e itens novos **não** são adicionados às listas do projeto ou da fábrica gerenciados pelo repositório. O `idObjeto` do item novo é calculado pelos itens da fábrica (maior + 1).
- `getItemByTexto` devolve a fábrica ou o item existente. Se não existir, devolve um novo. Ele busca a fábrica em `projeto.getFabricas()`. O `getOpcoesConsole` usa a fábrica do repositório.

### Dicas (`getTextoDica`)
- **OBJETO:** orienta a digitar o nome da entidade, ou `Entidade.nomeAtributo`.
- **ATRIBUTO_OBJETO:** orienta a digitar um atributo existente ou um nome novo.
- **ACAO:** mostra o formato `FabAcao[Modulo][Entidade opcional].[ENTIDADE]_[MB, FRM ou CTR]_[DESCRICAO]` com um exemplo.
- **FABRICA_STATUS:** `FabStatus[Nome]` e `FabStatus[Nome].nomeStatus`, ex.: `FabStatusPedido.emAndamento`.
- **FABRICA_ENTIDADE_GENERICA:** `Fab[Nome]` e `Fab[Nome].nomeItem`, ex.: `FabTipoPagamento.cartao`.
- **DESCONHECIDO e demais tipos:** texto geral (FabAcao..., NomeEntidade, FabTipo...).

### Ainda não implementados
REQUISITO, COMPONENTE_VISUAL, FABRICA_GRUPO_USUARIOS, FABRICA_MODULOS e FLUXO_TESTES. Para todos eles, `getOpcoesConsole` e `textosSugestaoAutocomplete` devolvem listas vazias. `getItemByJson` não está implementado para nenhum tipo.

## Regras planejadas (testadas pelos fluxos, ainda não implementadas)
As regras abaixo já estão descritas nos fluxos `FluxoConsoleObjetoStatus` e `FluxoBuilderAtributo*`, mas o console ainda não as implementa. Ao implementá-las, atualize as seções de regras implementadas acima.

### Entidade de status (`StatusCliente`)
- Um texto sem ponto que começa com `Status` seguido de letra maiúscula (`ObjetoStatusProjCRC.isNomeEntidadeStatus`) é identificado como entidade de status. `Statusxyz` continua sendo `OBJETO`.
- A opção principal salva uma `ObjetoStatusProjCRC` nova, uma subclasse de `ObjetoProjCRC`.
- Ao salvar, o controller da `ObjetoStatusProjCRC` cria **automaticamente** a fábrica de status `Fab` + nome da entidade (`getNomeFabricaStatusPadrao()`: `StatusCliente` gera `FabStatusCliente`), **sem nenhum item**. As duas ficam ligadas por `ObjetoStatusProjCRC.fabricaStatus` (`@OneToOne`, dono) e `FabricaStatusProjCRC.entidadeStatus` (`mappedBy`).
- `FabStatusCliente` só oferece editar. Uma fábrica de status inexistente (`FabStatusPedido`) não oferece criar.
- `FabStatusCliente.inadimplente` cria o item `INADIMPLENTE` (`idObjeto` = maior + 1) ou, se ele já existir, oferece editá-lo.

### Classe do atributo pelo texto digitado (`FabTipoInstanciaAtributoProjeto`)
| Texto digitado | Tipo de instância | Classe |
|---|---|---|
| `Cliente.nome` | `ATRIBUTO_SIMPLES` | `AtributoDeEntidadeSimples` |
| `Cliente.clienteIndicou.` (termina em ponto) | `ATRIBUTO_ENTIDADE` | `AtributoEntidadeEntidade` (**implementado**) |
| `Cliente.status` | `ATRIBUTO_ENTIDADE_STATUS` | `AtributoDeEntidadeStatus` |
| `Cliente.clientesRelacionados[]` (termina em `[]`) | `ATRIBUTO_LISTAGEM` | `AtrubutoEntidadeLista` (**implementado**) |
| `Cliente.fabTipoCliente` (começa com `fab`) | `ATRIBUTO_ENUM_FABRICA_GENERICA` | `AtributoDeEntidadeFabrica` |
| `StatusCliente.fabStatus` (começa com `fabStatus`) | `ATRIBUTO_ENUM_STATUS` | `AtributoDeEntidadeFabricaStatus` |

- Verifique `fabStatus` **antes** de `fab`.
- `Cliente.status` usa o tipo `OBJETO_DE_UMA_LISTA` e encontra a entidade de status pelo nome da entidade dona (`Status` + `Cliente`). Ela fica em `AtributoDeEntidadeStatus.entidadeStatus`. A entidade `Cliente` tem só o `.status`; o `fabStatus` fica na `StatusCliente`.
- `Cliente.fabTipoCliente` e `StatusCliente.fabStatus` já vêm ligados à fábrica de mesmo nome (`AtributoDeEntidadeFabrica.fabricaEntidade`), com o tipo `ENUM_FABRICA` ou `STATUS_ENUM`.

**Nomes reservados** (**implementados**, ver "Classe e tipo do atributo novo"): o tipo é definido pelo nome, digitado sem ponto no final.

| Nome | Classe | Tipo |
|---|---|---|
| `dataCriacao` / `dataEdicao` | `AtributoDeEntidadeSimples` | `REG_DATAINSERCAO` / `REG_DATAALTERACAO` |
| `bairro` / `cidade` | `AtributoEntidadeEntidade` | `LC_BAIRRO` / `LC_CIDADE` |
| `uf` ou `unidadeFederativa` | `AtributoEntidadeEntidade` | `LC_UNIDADE_FEDERATIVA` |
| `localizacao` | `AtributoEntidadeEntidade` | `LC_LOCALIZACAO` |
| `usuarioCriacao` / `usuarioEdicao` | `AtributoEntidadeEntidade` | `REG_USUARIO_INSERCAO` / `REG_USUARIO_ALTERACAO` |

`localidade` **não** é reservado. O usuário digita `Cliente.localidade.` e escolhe o tipo `LC_LOCALIDADE`.

**Tipo escolhido pelo usuário em `AtributoEntidadeEntidade`:**
- O campo `tipo` do `itemAssociado` exibe como opções apenas os tipos compatíveis (`ATRIBUTO_ENTIDADE.getListaAtributosDisponiveis()`).
- Ao alterar o tipo, os campos que não se aplicam ficam invisíveis: `valorMaximo`, `valorMinimo`, `validacaoRegex`, `numeroDeCasasDecimais`, `mascaraJqueryMode`, `iconePositivo`, `textoPositivo`, `iconeNegativo` e `textoNegativo` (`FluxoBuilderAtributoEntidade.CAMPOS_INVISIVEIS_ATRIBUTO_ENTIDADE`).
- `fraseValidacao` fica **visível em todos os tipos**, de todas as classes de atributo. Ele não tem `ValorLogico` de visibilidade e não deve ganhar um.

## RepositorioConsole
- Abre o próprio EntityManager (`UtilSBPersistencia.getEMPadraoNovo()`).
- `recarregarRepositorio()` fecha e reabre o EntityManager e recarrega, **a partir do projeto** (`getProjeto().getObjetos()`, `getProjeto().getAcoes()` e `getProjeto().getFabricas()`), três mapas que são limpos antes de cada recarga:
  - `OBJETOS`, indexado por **`nomeEntidade`**;
  - `ACOES`, indexado por **`nomeUnico`** (`FabAcaoGerente.CLIENTE_FRM_LISTAR`, com ponto; **não** é o texto digitado com `.`);
  - `FABRICAS`, indexado por **`nomeFabrica`** e carregado de `getProjeto().getFabricas()`. Inclui as fábricas genéricas e as de status.
- `getProjeto()` recarrega o projeto pelo EntityManager do repositório. Os itens devolvidos pelo repositório pertencem a esse EntityManager.

| Método | Uso |
|---|---|
| `isEntidadeExiste` / `getEntidadeExistente(nomeEntidade)` | entidade pelo nome exato |
| `getEntidadeMaisRecente()` | maior `dataHoraInsersao`; usada na sugestão de `FabAcaoGerente` |
| `getEntidadePorNomeAcao("CLIENTE")` | entidade pelo nome em caixa alta usado nas ações |
| `getLista3ObjetosMaisParecidos` / `getLista3AcoesMaisParecidos` | busca por semelhança |
| `getAcaoExistente(nomeUnico)` | ação pelo nome único |
| `getAcoesDoModuloEDominio(modulo, dominio)` / `getAcaoGestao(modulo, dominio)` | ações e gestão de um módulo para uma entidade (`Gerente`, `CLIENTE`) |
| `getAcoesIniciandoCom(textoConsole)` | ações para edição, as editadas mais recentemente primeiro |
| `getFabricaExistente(nomeFabrica)` | fábrica (genérica ou de status) pelo nome exato |
| `getFabricasIniciandoCom(inicio, tipo)` | fábricas do `FabTipoItemProjeto` informado que começam com o texto, em ordem alfabética |

- `getLista3...MaisParecidos` usa `UtilCRCListasObjeto.filtrarOrdenandoMaisParecidos(List<T>, String, int)`:
  - recebe uma `List`, por isso é preciso converter com `new ArrayList<>(MAPA.values())`;
  - indexa por `getId()`: dois itens com id `null` geram `IllegalStateException: Duplicate key`. Só passe itens já salvos;
  - para filtrar por início de nome (prefixo digitado), use `startsWith`, não a busca por semelhança.

## Depuração (`console/texto/UtilConsoleCRCTexto`)
Em modo desenvolvimento (`SBCore.isEmModoDesenvolvimento()`), o console imprime:
- **a cada pesquisa:** texto definido e tipo, dica, sugestões e a tabela de opções (ordem, ação com sigla CTR/FRM/MB, formulário de detalhes e item). O `*` marca a opção principal;
- **a cada execução:** ação, item, SUCESSO/FALHA, mensagens da resposta e o retorno. Também avisa quando nada foi executado (opção de formulário ou nenhuma opção).

Os itens aparecem com `[novo]` ou `[id N]`. Ações mostram módulo, entidade e tipo genérico; atributos mostram `Entidade.atributo` e o tipo; fábricas mostram o tipo de objeto padrão e a quantidade de itens; itens de fábrica mostram `Fabrica.NOME_ENUM`, `idObjeto`, `nomeObjeto` e o tipo de objeto. Ao incluir um tipo de item novo, acrescente a descrição dele em `getDescricaoItem`. A impressão nunca pode interromper o console: erros ao ler o registro de uma ação viram `?`.

## Como adicionar um novo tipo de item ao console
1. **Entidade JPA:** precisa implementar `ComoItemProjeto` e devolver o `FabTipoItemProjeto` certo em `getTipoItemProjeto()` (se for um campo, preencha no `prepararNovoObjeto`). Ter um `prepararNovoObjeto` anotado com `@InfoPreparacaoObjeto` (ver `instrucoesIA/modelCarameloCode`).
2. **Vínculo com o projeto:** um `@ManyToOne` para `ProjetoCRC` e a lista no projeto com `mappedBy`. Sem o `mappedBy`, o JPA usa uma tabela de junção e o item salvo não aparece na lista do projeto, nem no repositório.
3. **Ações:** gestão, formulários e controller no `FabAcao...` correspondente. Cada ação de controller precisa de um método de regra de negócio, e `ExecAcoesProjetosCRC.salvarItem` deve repassar o novo tipo para ele.
4. **Interpretação do texto:** se o texto tiver estrutura própria, crie um utilitário só para isso (como o `UtilProjCRCNomeAcao`) e deixe a decisão do que sugerir nos `case` do `FabTipoItemProjeto`.
5. **`FabTipoItemProjeto`:** implementar o `case` em `getTextoDica`, `textosSugestaoAutocomplete`, `getOpcoesConsole` e `getItemByTexto`. Se o tipo for identificado por prefixo, ajustar também `getTipoItemPorTexto`.
   - Atenção ao `replace`/edição automática: `getItemByTexto` e `getItemByJson` têm blocos `case` idênticos.
6. **Ordem das opções:** "criar" primeiro (ordem 1) quando o item não existe, depois os itens existentes (editar e ações relacionadas). A ordem é por `ordem`, não pela posição na lista.
7. **Repositório:** se o tipo precisar de cache, carregá-lo em `RepositorioConsole.recarregarRepositorio()` a partir do projeto, limpando o mapa antes.
8. **Depuração:** descrever o item em `UtilConsoleCRCTexto.getDescricaoItem`.

## Testes

### Fluxos
| Fluxo | Tag | Feature | Depende de |
|---|---|---|---|
| `consoleprojcrcobjetos/FluxoConsoleObjetos` | `@consoleProjCRCObjetos` | `caracteristicas/console/consoleProjCRCObjetos` | `FluxoCadastroProjeto` |
| `consoleprojcrcacoes/FluxoConsoleAcoes` | `@consoleProjCRCAcoes` | `caracteristicas/console/consoleProjCRCAcoes` | `FluxoConsoleObjetos` (entidade `Cliente`) |
| `consoleprojcrcatributosespeciais/FluxoConsoleAtributosEspeciais` | `@consoleProjCRCAtributosEspeciais` | `caracteristicas/console/consoleProjCRCAtributosEspeciais` | `FluxoConsoleObjetos` |
| `consoleprojcrcfabentidadeestatica/FluxoConsoleFabEntidadeEstatica` | `@consoleProjCRCFabEntidadeEstatica` | `caracteristicas/console/consoleProjCRCFabEntidadeEstatica` | `FluxoConsoleAcoes` (cria `FabTipoCliente`) |
| `consoleprojcrcobjetostatus/FluxoConsoleObjetoStatus` | `@consoleProjCRCObjetoStatus` | `caracteristicas/console/consoleProjCRCObjetoStatus` | `FluxoConsoleObjetos` (cria `StatusCliente`, `FabStatusCliente` e os status `ATIVO`, `INATIVO` e `INADIMPLENTE`) |
| `builderatributosimples/FluxoBuilderAtributoSimples` | `@builderAtributoSimples` | `caracteristicas/atributo/builderAtributoSimples` | `FluxoConsoleObjetos` |
| `builderatributoentidade/FluxoBuilderAtributoEntidade` | `@builderAtributoEntidade` | `caracteristicas/atributo/builderAtributoEntidade` | `FluxoConsoleObjetos` |
| `builderatributolistagem/FluxoBuilderAtributoListagem` | `@builderAtributoListagem` | `caracteristicas/atributo/builderAtributoListagem` | `FluxoConsoleObjetos` |
| `builderatributoentidadestatus/FluxoBuilderAtributoEntidadeStatus` | `@builderAtributoEntidadeStatus` | `caracteristicas/atributo/builderAtributoEntidadeStatus` | `FluxoConsoleObjetoStatus` |
| `builderatributoenumstatus/FluxoBuilderAtributoEnumStatus` | `@builderAtributoEnumStatus` | `caracteristicas/atributo/builderAtributoEnumStatus` | `FluxoConsoleObjetoStatus` |
| `builderatributoenumfabricagenerica/FluxoBuilderAtributoEnumFabricaGenerica` | `@builderAtributoEnumFabricaGenerica` | `caracteristicas/atributo/builderAtributoEnumFabricaGenerica` | `FluxoConsoleFabEntidadeEstatica` |

Pasta dos fluxos: `src/test/java/org/coletivoJava/fw/projetos/projeto/implementacao/cucumber/`.

- O **primeiro `Dado`** de cada feature informa de qual fluxo vem o banco carregado (`Dado um projeto com ... carregado do resultado do FluxoX`).
- Os fluxos `builderAtributo*` testam um tipo de instância de `FabTipoInstanciaAtributoProjeto` cada. Eles conferem a classe que o console instanciou (`TIPO_INSTANCIA.getClasse()`) e, alguns, o `DadoDinamico` gerado por `UtilProjetoCRCBuliderAtributo`. `ATRIBUTO_DESCONHECIDO` não é testado.
- `FluxoBuilderAtributoSimples` digita um atributo para cada tipo de `NOMES_ATRIBUTO_POR_TIPO`, salva, confere o tipo definido automaticamente (`ATRIBUTOS_DETECTADOS_PELO_NOME` e `TIPOS_AUTODETECTAVEIS`) e a visibilidade dos campos do atributo por tipo (`TIPOS_COM_CAMPO_VISIVEL`, cópia das regras de `ValorLogicoAtributoDeEntidadeSimples*`). `id` e `nome` já existem no Cliente do `FluxoConsoleObjetos` (`ATRIBUTOS_DO_FLUXO_ANTERIOR`): para eles o console oferece editar, não criar. Não confere `DadoDinamico`.
- `ObjetoProjCRC` usa herança `SINGLE_TABLE` (discriminador `tipoObjetoDB`). Por isso os bancos salvos antes da criação da `ObjetoStatusProjCRC` precisam ser gerados de novo.

### Estado compartilhado e padrão das etapas
- O console é a constante `CONSOLE` do fluxo. As sugestões da última digitação ficam em `sugestoesAutocompletar`: as etapas `Quando` gravam esse campo, e as `Entao` só leem, sem chamar o autocompletar de novo.
- **Dados iniciais:** a etapa A carrega o resultado do fluxo anterior (`DevOpsCucumberPersistenciaMysql.carregarResultadoRequisito`), renova o EntityManager, faz login com o admin do fluxo e chama `CONSOLE.carregarProjetos()`. Guarde o projeto selecionado no fluxo e confira com assert o que a etapa espera do fluxo anterior.
- **Textos digitados** são montados pelas constantes do fluxo (`getTextoFabricaAcao(FABRICA_GERENTE, ACAO_CLIENTE_FRM_LISTAR)`), nunca escritos dentro das etapas.
- Verificações repetidas viram métodos estáticos do fluxo. No `FluxoConsoleAcoes`:
  - `getAcaoDaOpcaoPrincipalDeCriacao(fabrica, acao)`: confere a opção "criar" e devolve a ação nova;
  - `criarAcaoPeloConsole(fabrica, acao)`: digita, confere, executa e confere o repositório;
  - `getAcaoSalvaNoProjeto(nomeUnico)`: renova o EntityManager, recarrega o projeto e busca a ação;
  - `verificarAcaoSecundariaClienteRegistrada(acao, classe, comportamento)`;
  - `verificarSubtiposPendentesDaGestaoCliente(fabrica)`;
  - `getNomesUnicosDasOpcoesDeEdicao()` e `getNomesUnicos(fabrica, acoes)`.
- No `FluxoBuilderAtributoSimples`:
  - `digitarAtributo(nome)`: digita, escolhe a opção pelo nome declarado do item, confere classe, ação (criar ou editar) e, ao criar, que é a primeira opção sugerida;
  - `recarregarEntidadeCliente()` e `getAtributoSalvo(nome)`: recarregam o Cliente do banco e buscam o atributo;
  - `verificarVisibilidadeCampos(atributo)`: confere a visibilidade de cada campo pelo tipo atual.
- **Para executar uma opção:** escolha a opção (pelo item associado, quando houver mais de uma parecida) com `setOpcaoSelecionada`, confira com assert que é a ação esperada, chame `executarOpcaoSelecionada()` e confira o efeito no repositório (`isEntidadeExiste`, `getAcaoExistente`). Para conferir que uma opção é a primeira sugerida, compare com `getOpcaoPrincipalSugerida()` ou `getOpcoesDisponiveis().get(0)`.
- **Para verificar persistência:**
  1. `renovarConexaoEntityManagerEscopoTeste()`;
  2. `UtilSBPersistencia.loadEntidade(projeto, getEM())`;
  3. navegar pelas listas com `mappedBy` (`projeto.getObjetos()`, `objeto.getAtributos()`, `projeto.getAcoes()`) e pelos `@ManyToOne` (`acao.getModulo()`, `acaoSecundaria.getAcaoGestao()`). Listas sem `mappedBy` (`ModuloProjCRC.acoes`, `AcaoProjCRCGestao.acoesVinculadas`, `ProjetoCRC.modulos`) não refletem esses vínculos.
- Compare registros pelo id (`acaoGestao.getId()`), não pela instância: o repositório e o teste usam EntityManagers diferentes.
- **Esquema do banco:** mudanças de mapeamento (`mappedBy`, colunas, `@Table(uniqueConstraints)`) podem exigir gerar de novo o resultado salvo dos fluxos anteriores.

### Cuidado com passos que começam igual
No Cucumber 1.2.5 o texto do passo é uma expressão regular sem `^`/`$`, então ela casa em **qualquer trecho** do texto de outro passo (`AmbiguousStepDefinitionsException`). Por exemplo, "o usuario digita Cli" casa com "o usuario digita Cliente seguido de...". Escreva o `.feature` de forma que nenhum passo esteja contido em outro, por exemplo "o usuario digita apenas cli".

Para conferir, teste cada texto do enum de etapas como regex contra todos os outros:
```python
import re
vals = re.findall(r'=\s*"([^"]*)"', open('Etapas<fluxo>.java').read())
print([(a, b) for a in vals for b in vals if a != b and re.search(a, b)])
```
