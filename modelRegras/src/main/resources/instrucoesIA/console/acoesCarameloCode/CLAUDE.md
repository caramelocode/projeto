# Ações de um projeto do Caramelo Projetos

No Caramelo Projetos, o usuário modela as ações da aplicação gerada: telas de gestão, formulários e ações de controller. Cada ação modelada é uma `AcaoProjCRC`, e corresponde a uma constante de um enum `FabAcao...` na aplicação gerada, com a mesma nomenclatura do framework (`UtilFabricaDeAcoesAcessosModel`, em `SBAcessosModel`).

As ações são criadas pelo console, a partir do nome digitado. O comportamento do console (sugestões e opções) está em `instrucoesIA/console`. Entidades e atributos estão em `instrucoesIA/modelCarameloCode`.

Pacote base: `br.org.carameloCode.erp.modulo.projeto` (em `modelRegras/src/main/java`).

## Nome da ação

### Texto digitado no console
```
FabAcao[NomeModulo][NomeEntidade opcional].[NOME_ENTIDADE]_[TIPO]_[DESCRICAO]
```
Ex.: `FabAcaoGerente.CLIENTE_FRM_LISTAR`, `FabAcaoGerenteCliente.CLIENTE_FRM_LISTAR`, `FabAcaoCliente.CLIENTE_MB_GESTAO`.

O `.` separa a fábrica do nome da ação e existe só no texto digitado. No console, o ponto fica reservado para `Entidade.atributo`.

### Nome único (o que é salvo)
```
NomeDaFabrica.NOME_DA_ACAO      ex.: FabAcaoGerente.CLIENTE_FRM_LISTAR
```
- É o nome da classe enum mais o nome da constante, com um ponto no meio, como o `getNomeUnico()` das ações do framework.
- **Único por projeto:** `@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"projeto_id", "nomeUnico"}))`.
- `FabAcaoGerente.CLIENTE_FRM_LISTAR` e `FabAcaoGerenteCliente.CLIENTE_FRM_LISTAR` são ações diferentes (fábricas diferentes).
- Conversão: `UtilProjCRCNomeAcao.getNomeUnico(texto)` e o inverso `getTextoConsole(nomeUnico)`.
- O repositório do console (`RepositorioConsole.ACOES`) é indexado pelo nome único. **Nunca** procure uma ação pelo texto digitado sem converter.

### Partes do nome (`itemProjeto/acoes/UtilProjCRCNomeAcao`)
O utilitário só interpreta o texto; quem decide o que sugerir é o `FabTipoItemProjeto`.

| Texto | `getNomeFabricaSemPrefixo` | `getNomeEntidadeAcao` | `getSiglaTipo` | `getDescricaoAcao` | `isNomeCompleto` | `getNomeModulo(texto, "Cliente")` |
|---|---|---|---|---|---|---|
| `FabAcao` | (vazio) | null | null | null | não | (vazio) |
| `FabAcaoGerente` | Gerente | null | null | null | não | Gerente |
| `FabAcaoGerente.CLIENTE` | Gerente | CLIENTE | null | null | não | Gerente |
| `FabAcaoGerente.CLIENTE_FRM_` | Gerente | CLIENTE | FRM | (vazio) | não | Gerente |
| `FabAcaoGerenteCliente.CLIENTE_FRM_LISTAR` | GerenteCliente | CLIENTE | FRM | LISTAR | sim | **Gerente** |
| `FabAcaoCliente.CLIENTE_FRM_LISTAR` | Cliente | CLIENTE | FRM | LISTAR | sim | **Cliente** |
| `FabAcaoX.PEDIDO_VENDA_MB_GESTAO` | X | PEDIDO_VENDA | MB | GESTAO | sim | X |

- A entidade é o trecho entre `.` e o primeiro marcador `_MB_`, `_FRM_` ou `_CTR_`. Por isso nomes compostos (`PEDIDO_VENDA`) funcionam.
- `getNomeEntidadeCaixaAlta("PedidoVenda")` → `PEDIDO_VENDA`; `getNomeEntidadeCamelCase("PEDIDO_VENDA")` → `PedidoVenda`.
- **Módulo:** a fábrica sem `FabAcao`. Se ela terminar com o nome da entidade e for maior que ele, o nome da entidade sai do fim (`GerenteCliente` → `Gerente`). Se for só o nome da entidade (`FabAcaoCliente`), o módulo é a própria entidade.
- `getTrechoTipoEDescricao` devolve `_FRM_LISTAR`: é o que se passa para identificar a ação genérica, para que o nome da entidade não interfira nas palavras-chave.
- Uma ação só pode ser criada com o nome completo: módulo, entidade, tipo e descrição.

## Tipos de ação

| Sigla | Classe JPA | `FabTipoAcaoSistema` (com entidade / sem entidade) |
|---|---|---|
| `MB` | `AcaoProjCRCGestao` | `ACAO_ENTIDADE_GERENCIAR` |
| `FRM` | `AcaoProjCRCFormulario` | `ACAO_ENTIDADE_FORMULARIO` / `ACAO_FORMULARIO` |
| `CTR` | `AcaoProjCRCContoller` | `ACAO_ENTIDADE_CONTROLLER` / `ACAO_CONTROLLER` |

A classe é escolhida em `FabTipoItemProjeto.getNovaAcaoPorSigla` (usado por `getItemByTexto`).

### Subtipos padrão e comportamento (`tipoAcaoGenerica`)
O comportamento vem de `FabTipoAcaoSistemaGenerica.getAcaoGenericaByNome(getTrechoTipoEDescricao(texto))`, o mesmo usado pelo framework. Ele soma palavras-chave (`_FRM`, `_CTR`, `_MB`, `_LISTAR`, `_MERGE`, `_ALTERAR` + `_STATUS`, `_REMOVER`...). Quando nenhuma palavra específica casa, o resultado é o personalizado do tipo.

| Nome da ação | `tipoAcaoGenerica` |
|---|---|
| `..._MB_GESTAO` | `GERENCIAR_DOMINIO` |
| `..._FRM_LISTAR` | `FORMULARIO_LISTAR` |
| `..._FRM_EDITAR` | `FORMULARIO_EDITAR` |
| `..._FRM_VISUALIZAR` | `FORMULARIO_VISUALIZAR` |
| `..._FRM_NOVO` | `FORMULARIO_NOVO_REGISTRO` |
| `..._CTR_SALVAR_MERGE` | `CONTROLLER_SALVAR_MODO_MERGE` |
| `..._CTR_ALTERAR_STATUS` | `CONTROLLER_ATIVAR_DESATIVAR` |
| `..._CTR_REMOVER` | `CONTROLLER_REMOVER` |
| `..._CTR_<outro>` (ex.: `ACAO_TESTE_PERSONALIZADA`) | `CONTROLLER_PERSONALIZADO` |
| `..._FRM_<outro>` | `FORMULARIO_PERSONALIZADO` |

- Os subtipos que o console sugere estão em `UtilProjCRCNomeAcao.SUBTIPOS_GESTAO`, `SUBTIPOS_FORMULARIO` e `SUBTIPOS_CONTROLLER` (`getSubtiposPadrao(sigla)`, `getSubtiposPadraoComSigla()`).
- Nem toda ação é genérica: uma ação personalizada é válida e recebe `CONTROLLER_PERSONALIZADO`/`FORMULARIO_PERSONALIZADO`. A regra de negócio **não** exige `tipoAcaoGenerica`.
- Para incluir um subtipo padrão novo: adicione-o à lista do tipo em `UtilProjCRCNomeAcao` e confira que `getAcaoGenericaByNome` o reconhece (palavras-chave em `FabTipoAcaoSistemaGenerica.palavrasChaveIdentificadoras`).

## Entidades (`entidadesJPA/projetoBuilderCRC/itemProjeto/acoes`)

```
AcaoProjCRC                (@DiscriminatorColumn tipoAcaoDB, implementa ComoItemProjeto)
├── AcaoProjCRCGestao       (acoesVinculadas)
└── AcaoCRCProjSecundaria   (acaoGestao → AcaoProjCRCGestao)
    ├── AcaoProjCRCFormulario  (grupoCampos)
    └── AcaoProjCRCContoller
```

### Campos de `AcaoProjCRC` preenchidos pelo console
| Campo | Valor (ex.: `FabAcaoGerente.CLIENTE_FRM_LISTAR`) |
|---|---|
| `tipoItemProjeto` | `FabTipoItemProjeto.ACAO` |
| `projeto` | o projeto aberto (`@ManyToOne`; lista `ProjetoCRC.acoes` com `mappedBy = "projeto"`) |
| `nomeUnico` | `FabAcaoGerente.CLIENTE_FRM_LISTAR` |
| `nomeAcao` | `CLIENTE_FRM_LISTAR` (o nome da constante) |
| `nomeDominio` | `CLIENTE` |
| `entidadeDominio` | o `ObjetoProjCRC` cujo nome em caixa alta é `CLIENTE`, ou `null` se a entidade não existir |
| `modulo` | módulo `Gerente` (ver abaixo) |
| `tipoAcaoGenerica` | `FORMULARIO_LISTAR` |
| `tipoAcao` | `ACAO_ENTIDADE_FORMULARIO` |
| `acaoGestao` (secundárias) | a gestão do mesmo módulo e domínio, se já existir |

`iconeAcao`, `cor`, `descricao`, `precisaPermissao`, `requisito` e `tipoAcaoSistema` não são preenchidos pelo console.

### `prepararNovoObjeto(projeto, texto)`
```java
@InfoPreparacaoObjeto(classesPrConstructorPrincipal = ProjetoCRC.class)
public void prepararNovoObjeto(Object... parametros) throws ErroPreparandoObjeto {
    super.prepararNovoObjeto(parametros);
    setTipoItemProjeto(FabTipoItemProjeto.ACAO);
    setProjeto(getParametroInicialEnviado(ProjetoCRC.class, parametros));
    if (isTemParametroDesteTipo(String.class, parametros)) {
        aplicarNomeDigitado(getParametroInicialEnviado(String.class, parametros));
    }
}
```
- Os parâmetros são lidos **direto** no método anotado. O resto da interpretação fica em `aplicarNomeDigitado`.
- No fim, `aplicarNomeDigitado` chama o gancho `aplicarVinculosDoNomeDigitado()`. A `AcaoCRCProjSecundaria` usa esse gancho para vincular a gestão. Para outro vínculo de subclasse, sobrescreva o gancho em vez de sobrescrever `prepararNovoObjeto` (o que exigiria repetir a anotação).
- A subclasse é escolhida por quem instancia: use `FabTipoItemProjeto.ACAO.getItemByTexto(projeto, texto)`.
- A ação nova **não** é adicionada a `projeto.getAcoes()`, para não alterar o objeto gerenciado pelo repositório do console.

### Módulo
- Procurado pelo nome nos módulos do projeto (`projeto.getModulos()`) **e** nos módulos das ações já salvas (`projeto.getAcoes()`). `ProjetoCRC.modulos` não tem `mappedBy`, então um módulo salvo em cascata por uma ação só é encontrado pelas ações.
- Se não existir, é criado um `ModuloProjCRC` com nome e projeto, salvo **em cascata** com a ação (`AcaoProjCRC.modulo` tem `cascade = {PERSIST, MERGE}`).
- Por isso todas as ações de `Gerente` reaproveitam o mesmo módulo depois que a primeira é salva.

### Gestão
- **No framework**, a gestão de uma ação é a ação `_MB` do mesmo enum com o mesmo prefixo (`getAcaoPrincipalDoDominio`), e as sub-ações são as do mesmo domínio (`getSubAcoesDaAcaoPrincipal`).
- **No console**, a gestão é identificada por **módulo + domínio** (`Gerente` + `CLIENTE`): `RepositorioConsole.getAcaoGestao(modulo, dominio)` e, no `prepararNovoObjeto`, `AcaoCRCProjSecundaria.aplicarVinculosDoNomeDigitado()`.
- Assim, `FabAcaoGerente.CLIENTE...` e `FabAcaoGerenteCliente.CLIENTE...` usam a mesma gestão.
- Uma ação secundária pode ser criada antes da gestão; nesse caso ela fica sem `acaoGestao`.

### Relacionamentos sem `mappedBy`
`AcaoProjCRCGestao.acoesVinculadas`, `ModuloProjCRC.acoes` e `ProjetoCRC.modulos` usam tabela de junção própria e **não** são preenchidos pelo console. Para navegar, use os `@ManyToOne` (`acaoSecundaria.getAcaoGestao()`, `acao.getModulo()`, `acao.getProjeto()`) ou `projeto.getAcoes()`.

## Ações do Caramelo sobre as ações (`acoes/carameloDev/acao/FabAcaoCarameloDevAcaoProjCRC`)

| Ação | Uso no console |
|---|---|
| `ACOES_MB_GESTAO` | gestão de `AcaoProjCRC` |
| `ACOES_CTR_SALVAR` | **criar/salvar** a ação (opção "criar") |
| `ACOES_FRM_EDITAR_ACAO_FORMULARIO` | editar uma ação de formulário |
| `ACOES_FRM_EDITAR_ACAO_CONTROLLER` | editar uma ação de controller |
| `ACOES_FRM_VISAO_GERAL` | editar/visualizar uma gestão (não há um "editar gestão" específico) |
| `ACOES_FRM_LISTAR_GESTAO`, `ACOES_FRM_LISTAR_SUBACAO` | ainda não usados pelo console |

A anotação dos métodos de regra de negócio é `@InfoAcaoCarameloDevAcaoProjCRC(acao = ...)`.

### Regra de negócio: `regraDeNegocio/projeto/ExecAcoesProjetosCRC`
```java
@InfoAcaoCarameloDevAcaoProjCRC(acao = FabAcaoCarameloDevAcaoProjCRC.ACOES_CTR_SALVAR)
public static ItfRespostaAcaoDoSistema salvarAcao(AcaoProjCRC pAcao) {
    return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pAcao), pAcao) {
        @Override
        public void regraDeNegocio() throws ErroRegraDeNegocio {
            // valida projeto, nomeUnico e módulo
            setRetorno(atualizarEntidade(pAcao));
        }
    }.getResposta();
}
```
- **Validações** (cada uma com um `ErroRegraDeNegocio` próprio): a ação precisa de projeto, nome único e módulo.
- **Duplicidade:** hoje é impedida pela restrição única (`projeto_id`, `nomeUnico`), que gera erro de persistência, e pelo console, que não oferece "criar" para um nome único existente. Uma validação com mensagem amigável no `salvarAcao` ainda não foi feita.
- O `atualizarEntidade` grava com um EntityManager diferente do repositório do console. Projeto, módulo e entidade de domínio chegam carregados pelo repositório e são resolvidos pelo `merge`.
- `ExecAcoesProjetosCRC.salvarItem` (`CONSOLE_ITEM_PROJ_CTR_SALVAR`) repassa para `salvarAcao` quando o item é uma `AcaoProjCRC`.

## Ordenação
- As opções de edição são ordenadas pela ação editada mais recentemente (`dataHoraAlteracao`, ou `dataHoraInsersao` se não houver alteração), em `RepositorioConsole.getAcoesIniciandoCom`.
- A ordenação das **fábricas** pelas ações editadas mais recentemente ainda não é verificada pelos testes: com uma única gestão no projeto, não há o que ordenar.

## Testes (`FluxoConsoleAcoes`, tag `@consoleProjCRCAcoes`)
- Feature: `src/test/resources/caracteristicas/console/consoleProjCRCAcoes/consoleProjCRCAcoes.feature`.
- Parte da entidade `Cliente` gerada pelo `FluxoConsoleObjetos`.
- Cobre:
  - reconhecimento de `FabAcao`, sugestão da fábrica pela entidade mais recente, tipos e subtipos;
  - opção de criar com módulo e entidade nos três formatos de fábrica (`FabAcaoCliente`, `FabAcaoGerente`, `FabAcaoGerenteCliente`), inclusive com entidade inexistente;
  - criação da gestão e das 8 ações secundárias, com classe, comportamento, módulo, entidade e gestão vinculada;
  - subtipos pendentes nos dois formatos de fábrica;
  - opções de edição (todas as 9, só os formulários com `_FRM_`) e ausência de pendentes no fim.
- Constantes: `FABRICA_GERENTE`, `FABRICA_GERENTE_CLIENTE`, `FABRICA_CLIENTE`, `ACAO_CLIENTE_*` (nome da ação sem a fábrica), `ACOES_CLIENTE`, `FORMULARIOS_CLIENTE`, `ACOES_PENDENTES_APOS_GESTAO`, `ACOES_DE_EDICAO`.
- Métodos do fluxo: ver `instrucoesIA/console`, seção Testes.
