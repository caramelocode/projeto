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
| `entidadesJPA/projetoBuilderCRC/itemProjeto/acoes/UtilProjCRCNomeAcao` | Interpretação do texto de ações (`FabAcao..._o_...`), ver `acoesCarameloCode`. |
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

- `getOpcaoPrincipalSugerida()` devolve a primeira opção (menor `ordem`).
- `getOpcaoSelecionada()` devolve a opção principal se nenhuma tiver sido escolhida com `setOpcaoSelecionada`.
- `getTipoPesquisa()` devolve o `FabTipoItemProjeto` da última pesquisa.
- `executarOpcaoSelecionada()` só executa ações de controller (`isUmaAcaoController()`), pelo `CarameloCode.getServicoController().getResposta(acao, item)`. Se der certo, chama `repositorio.recarregarRepositorio()`. Ações de formulário (FRM) não são executadas pelo console; elas abrem o formulário na view.
- O método é `void`. Em caso de falha, ele só dispara as mensagens da resposta ou registra o erro. Para verificar o resultado no teste, confira o efeito no repositório ou no banco. Em modo desenvolvimento, o resultado (sucesso/falha e mensagens) é impresso pelo `UtilConsoleCRCTexto`.

## Identificação do tipo (`getTipoItemPorTexto`)

1. Se o texto começa com `FabAcao` (`UtilProjCRCNomeAcao.PREFIXO_FABRICA`, o mesmo de `getSlugInicialTipoItem(ACAO)`), o tipo é `ACAO`.
2. Se o texto começa com o identificador de algum `FabTipoItemProjeto` (`getIdentificadorUnico()`), o tipo é esse.
3. Se contém `.` (`FabTipoItemProjeto.SEPARADOR_ATRIBUTO`), o tipo é `ATRIBUTO_OBJETO`.
4. Caso contrário, o tipo é `OBJETO`.

Prefixos previstos em `getSlugInicialTipoItem`: `FabAcao` (ACAO), `Req` (REQUISITO), `FabComp` (COMPONENTE_VISUAL), `FabStatus`, `FabGrupo`, `FabModulo`, `Fluxo` (FLUXO_TESTES), `Fab` (FABRICA_ENTIDADE_GENERICA).
- **Só o prefixo de `ACAO` está ligado.** Ligar os demais faria uma entidade chamada `Requisicao`, `Fluxograma` ou `Fabrica` mudar de tipo. Ao implementar outro tipo por prefixo, trate esse conflito (por exemplo, exigindo o prefixo seguido de letra maiúscula) e verifique antes os prefixos mais longos (`FabStatus` antes de `Fab`).

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
  - `Entidade.atributo` para cada atributo que combina.
- **Opções:**
  1. `ATRIBUTO_ENTIDADE_CTR_SALVAR` com um atributo novo (`FabTiposEntidade.getAtributo(entidade, TIPO_PADRAO_NOVO_ATRIBUTO, nome)`), quando o nome não existe. O formulário é `ATRIBUTO_ENTIDADE_FRM_NOVO`.
  2. `ATRIBUTO_ENTIDADE_FRM_EDITAR` para cada atributo existente que combina.
- Um atributo novo **não** é adicionado em `entidade.getAtributos()`, para não alterar o objeto gerenciado pelo repositório. Ele só referencia a entidade.
- `TIPO_PADRAO_NOVO_ATRIBUTO = FabTipoAtributoObjeto.TEXTO_SIMPLES`. O tipo definitivo é escolhido no formulário.

### ACAO (`FabAcao[Modulo][Entidade]_o_[ENTIDADE]_[MB|FRM|CTR]_[DESCRICAO]`)
Formato do nome, tipos, módulo, gestão e regra de negócio estão em `instrucoesIA/acoesCarameloCode`. Aqui fica só o comportamento do console. Exemplos com a entidade `Cliente`:

| Texto digitado | Autocompletar | Opções |
|---|---|---|
| `FabAcao` | nada (falta o módulo) | editar as ações existentes que começam com o texto |
| `FabAcaoGerente` | `FabAcaoGerenteCliente` e `FabAcaoGerente_o_CLIENTE`, pela entidade com `dataHoraInsersao` mais recente | editar as existentes que começam com o texto |
| `FabAcaoGerente_o_` | `FabAcaoGerente_o_CLIENTE` (entidade mais recente) | editar as existentes |
| `FabAcaoGerente_o_CLIENTE` | `..._MB_`, `..._FRM_`, `..._CTR_` e, se a gestão já existe, os **subtipos padrão ainda não criados** (`..._FRM_LISTAR`...) | editar as existentes |
| `FabAcaoGerente_o_CLIENTE_FRM_` | subtipos padrão do tipo que começam com a descrição (`..._FRM_LISTAR`, `..._FRM_EDITAR`...) | editar as existentes (ex.: os formulários já criados) |
| `FabAcaoGerente_o_CLIENTE_CTR_ACAO_X` | o próprio texto (descrição personalizada) | 1: criar (`ACOES_CTR_SALVAR`), se o nome único não existir; depois editar as existentes |

- **Criar** só aparece com o nome completo (módulo, entidade, tipo e descrição) e se o nome único (`FabAcaoGerente.CLIENTE_CTR_ACAO_X`) ainda não existe no repositório. É sempre a ordem 1.
- O item da opção de criar vem de `getItemByTexto`: `AcaoProjCRCGestao`, `AcaoProjCRCFormulario` ou `AcaoProjCRCContoller`, conforme a sigla, preparado com `prepararNovoObjeto(projeto, texto)`.
- **Editar:** para cada ação salva cujo texto no console (`UtilProjCRCNomeAcao.getTextoConsole(nomeUnico)`) começa com o texto digitado (`repositorio.getAcoesIniciandoCom`), as editadas mais recentemente primeiro.
- A ação da opção (e o formulário de detalhes) é: formulário → `ACOES_FRM_EDITAR_ACAO_FORMULARIO`; controller → `ACOES_FRM_EDITAR_ACAO_CONTROLLER`; gestão → `ACOES_FRM_VISAO_GERAL`.
- Os subtipos pendentes são calculados pela gestão do **módulo + domínio**, então `FabAcaoGerente_o_CLIENTE` e `FabAcaoGerenteCliente_o_CLIENTE` listam os mesmos pendentes (cada um no seu formato de fábrica).
- As ações existentes **não** entram no autocompletar, só nas opções. Assim a lista de sugestões de `FabAcaoGerente_o_CLIENTE` mostra só o que falta criar.

### Dicas (`getTextoDica`)
- **OBJETO:** orienta a digitar o nome da entidade, ou `Entidade.nomeAtributo`.
- **ATRIBUTO_OBJETO:** orienta a digitar um atributo existente ou um nome novo.
- **ACAO:** mostra o formato `FabAcao[Modulo][Entidade opcional]_o_[ENTIDADE]_[MB, FRM ou CTR]_[DESCRICAO]` com um exemplo.
- **DESCONHECIDO e demais tipos:** texto geral (FabAcao..., NomeEntidade, FabTipo...).

### Ainda não implementados
REQUISITO, COMPONENTE_VISUAL, FABRICA_STATUS, FABRICA_GRUPO_USUARIOS, FABRICA_MODULOS, FLUXO_TESTES e FABRICA_ENTIDADE_GENERICA. Para todos eles, `getOpcoesConsole` e `textosSugestaoAutocomplete` devolvem listas vazias. `getItemByJson` não está implementado para nenhum tipo.

## RepositorioConsole
- Abre o próprio EntityManager (`UtilSBPersistencia.getEMPadraoNovo()`).
- `recarregarRepositorio()` fecha e reabre o EntityManager e recarrega, **a partir do projeto** (`getProjeto().getObjetos()` e `getProjeto().getAcoes()`), dois mapas que são limpos antes de cada recarga:
  - `OBJETOS`, indexado por **`nomeEntidade`**;
  - `ACOES`, indexado por **`nomeUnico`** (`FabAcaoGerente.CLIENTE_FRM_LISTAR`, com ponto; **não** é o texto digitado com `_o_`).
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

- `getLista3...MaisParecidos` usa `UtilCRCListasObjeto.filtrarOrdenandoMaisParecidos(List<T>, String, int)`:
  - recebe uma `List`, por isso é preciso converter com `new ArrayList<>(MAPA.values())`;
  - indexa por `getId()`: dois itens com id `null` geram `IllegalStateException: Duplicate key`. Só passe itens já salvos;
  - para filtrar por início de nome (prefixo digitado), use `startsWith`, não a busca por semelhança.

## Depuração (`console/texto/UtilConsoleCRCTexto`)
Em modo desenvolvimento (`SBCore.isEmModoDesenvolvimento()`), o console imprime:
- **a cada pesquisa:** texto definido e tipo, dica, sugestões e a tabela de opções (ordem, ação com sigla CTR/FRM/MB, formulário de detalhes e item). O `*` marca a opção principal;
- **a cada execução:** ação, item, SUCESSO/FALHA, mensagens da resposta e o retorno. Também avisa quando nada foi executado (opção de formulário ou nenhuma opção).

Os itens aparecem com `[novo]` ou `[id N]`. Ações mostram módulo, entidade e tipo genérico; atributos mostram `Entidade.atributo` e o tipo. Ao incluir um tipo de item novo, acrescente a descrição dele em `getDescricaoItem`. A impressão nunca pode interromper o console: erros ao ler o registro de uma ação viram `?`.

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

Pasta dos fluxos: `src/test/java/org/coletivoJava/fw/projetos/projeto/implementacao/cucumber/`.

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
- **Para executar uma opção:** confira com assert que `getOpcaoSelecionada()` é a ação esperada, chame `executarOpcaoSelecionada()` e confira o efeito no repositório (`isEntidadeExiste`, `getAcaoExistente`).
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
