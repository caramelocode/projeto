# Modelo do Caramelo Projetos: Objetos (entidades) e Atributos

No Caramelo Projetos, o usuário modela a aplicação que será gerada. Cada **Objeto** (`ObjetoProjCRC`) representa uma entidade da aplicação gerada, e cada **Atributo** (`AtributoDeEntidadeSimples` e subclasses) representa um campo dela. Os tipos de campo vêm de `FabTipoAtributoObjeto`, do framework (`SBApiCore/.../InfoCampos/campo/FabTipoAtributoObjeto.java`).

Pacote base: `br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC` (em `modelRegras/src/main/java`).

## Entidades

### `projeto/ProjetoCRC`
- `@OneToMany(targetEntity = ObjetoProjCRC.class, mappedBy = "projeto") List<ObjetoProjCRC> objetos`.
- É o `mappedBy` que faz um objeto salvo aparecer em `projeto.getObjetos()`. Sem ele, o JPA usa uma tabela de junção separada e o vínculo `ObjetoProjCRC.projeto` não é refletido.

### `itemProjeto/entidades/ObjetoProjCRC`
- Estende `EntidadeSimplesORM` e implementa `ComoEstruturaEntidadeSimples` e `ComoItemProjeto`.
- **Campos principais:**
  - `nome` (`@InfoCampo NOME`);
  - `nomeEntidade`: **chave usada pelo console e pelo repositório**;
  - `projeto` (`@ManyToOne ProjetoCRC`);
  - `atributos`;
  - `tipoItemProjeto`, `modulo`, `descricao`, `icone`, `plural`, `tags`, `requisito`.
- **Atributos:** `@OneToMany(targetEntity = AtributoDeEntidadeSimples.class, mappedBy = "entidade", cascade = {CascadeType.PERSIST, CascadeType.MERGE})`. Os atributos são salvos **em cascata** ao salvar o objeto.
- `getCampos()` devolve uma lista vazia, porque a lista persistida é `getAtributos()`.

### `itemProjeto/entidades/atributoEntidade/AtributoDeEntidadeSimples`
- Estende `EntidadeSimplesORM` e implementa `ComoItemProjeto` (`getTipoItemProjeto()` devolve `ATRIBUTO_OBJETO`).
- **Campos:**
  - `nomeDeclarado` (`@InfoCampo NOME`): o nome do atributo na entidade gerada, ex.: `id`, `nome`, `nomeCompleto`;
  - `tipo` (`FabTipoAtributoObjeto`, `@Enumerated(STRING)`);
  - `entidade` (`@ManyToOne ObjetoProjCRC`): o dono do atributo e o lado `mappedBy`;
  - `descricao` e `obrigatorio`.
- **Herança:** é a tabela única com `@DiscriminatorColumn(name = "tipoAtributo")`. As subclasses são:
  - `AtributoEntidadeEntidade`: referência a outra entidade (`entidadeReferenciada`);
  - `AtrubutoEntidadeLista`: lista de outra entidade (`entidadeItemLista`, `caminhoLista`).

## Criação de objetos: `prepararNovoObjeto`

Toda entidade criada pelo sistema é preparada por `prepararNovoObjeto(Object... parametros)`:
- o método **precisa** da anotação `@InfoPreparacaoObjeto(classesPrConstructorPrincipal = X.class)`. Sem ela, `getParametroInicialEnviado` lança `UnsupportedOperationException`;
- os parâmetros são lidos por tipo, com `getParametroInicialEnviado(Classe.class, parametros)`;
- para parâmetros opcionais, verifique antes com `isTemParametroDesteTipo(Classe.class, parametros)`;
- `getParametroInicialEnviado` descobre a anotação pelo método em execução, então chame-o **diretamente** dentro do `prepararNovoObjeto` anotado, nunca a partir de um método auxiliar;
- o método lança `ErroPreparandoObjeto`. Quem chama deve tratar ou propagar; no teste, falhe com `Assert.fail`.

### ObjetoProjCRC
```java
@InfoPreparacaoObjeto(classesPrConstructorPrincipal = ProjetoCRC.class)
public void prepararNovoObjeto(Object... parametros) throws ErroPreparandoObjeto {
    super.prepararNovoObjeto(parametros);
    setNome(getParametroInicialEnviado(String.class, parametros));
    setNomeEntidade(getNome());                      // obrigatório: o console indexa por nomeEntidade
    setProjeto(getParametroInicialEnviado(ProjetoCRC.class, parametros));
    FabTiposEntidade.SIMPLES.aplicarAtributo(this);  // cria id e nome automaticamente
}
```
Uso: `objeto.prepararNovoObjeto(projeto, "Cliente")`. No console, isso é feito por `FabTipoItemProjeto.OBJETO.getItemByTexto(projeto, texto)`.

### AtributoDeEntidadeSimples
```java
@InfoPreparacaoObjeto(classesPrConstructorPrincipal = ObjetoProjCRC.class)
public void prepararNovoObjeto(Object... parametros) throws ErroPreparandoObjeto {
    super.prepararNovoObjeto(parametros);
    setEntidade(getParametroInicialEnviado(ObjetoProjCRC.class, parametros));
    if (isTemParametroDesteTipo(FabTipoAtributoObjeto.class, parametros)) {
        setTipo(getParametroInicialEnviado(FabTipoAtributoObjeto.class, parametros));
    }
    if (isTemParametroDesteTipo(String.class, parametros)) {
        setNomeDeclarado(getParametroInicialEnviado(String.class, parametros));
    }
}
```
Uso: `atributo.prepararNovoObjeto(entidade, FabTipoAtributoObjeto.NOME, "nome")`. Prefira `FabTiposEntidade.getAtributo(entidade, tipo, nome)`.

## `FabTiposEntidade`: tipo da entidade gerada e atributos padrão

Arquivo: `itemProjeto/entidades/FabTiposEntidade.java`. Define que classe base a entidade gerada estende e quais atributos ela recebe automaticamente.

| Tipo | `getClasseExtecao()` | `getAtributosDoTIpo()` |
|---|---|---|
| SIMPLES | `EntidadeSimplesORM` | ID, NOME |
| NORMAL | `EntidadeORMNormal` | ID, NOME, REG_DATAALTERACAO, REG_DATAINSERCAO, REG_USUARIO_ALTERACAO, REG_USUARIO_INSERCAO, REG_ATIVO_INATIVO |
| COMO_STATUS | `EntidadeORMStatus` | ainda não definido (lança `UnsupportedOperationException`) |
| COMO_PESSOA, COMO_USUARIO, COMO_GRUPO_USUARIO | `null` | ainda não definido (lança `UnsupportedOperationException`) |

- **`aplicarAtributo(objeto)`:** cria a lista de atributos se ela estiver nula. Para cada tipo de `getAtributosDoTIpo()`, cria o atributo com `getAtributo(objeto, tipo, FabTipoInstanciaAtributoProjeto.getTipoAtributo(tipo).getNomePadraoATributo(objeto, tipo))` e o adiciona em `objeto.getAtributos()`.
- **`FabTipoInstanciaAtributoProjeto.getNomePadraoATributo(objeto, tipo)`:** devolve o nome padrão do campo para cada tipo.
  - Nomes fixos: `ID` → `id`; `NOME` → `nome`; `NOME_LONGO`/`NOME_COMPLETO` → `nomeCompleto`; `DESCRITIVO` → `descricao`; `REG_DATAALTERACAO` → `dataHoraAlteracao`; `REG_DATAINSERCAO` → `dataHoraInsercao`; `REG_USUARIO_ALTERACAO` → `usuarioAlteracao`; `REG_USUARIO_INSERCAO` → `usuarioInsercao`; `REG_ATIVO_INATIVO` → `ativo`.
  - Demais tipos: o nome do enum em camelCase (`LC_CIDADE` → `lcCidade`).
- **`getAtributo(objeto, tipo, nome)`:** cria e prepara um `AtributoDeEntidadeSimples` ligado ao objeto, mas **não** o adiciona à lista do objeto.

### Como adicionar atributos padrão a um tipo de entidade
1. Em `getAtributosDoTIpo()`, devolver a lista de `FabTipoAtributoObjeto` do tipo.
2. Em `FabTipoInstanciaAtributoProjeto.getNomePadraoATributo()`, adicionar um `case` com o nome do campo, se o camelCase automático não servir.
3. Se o tipo de atributo precisar de outra classe, como referência ou lista, ajustar `getAtributo()` para instanciar a subclasse certa (`AtributoEntidadeEntidade`, `AtrubutoEntidadeLista` ou uma nova).

### Como criar um novo tipo de atributo (subclasse)
1. Criar a subclasse de `AtributoDeEntidadeSimples` com `@Entity` e `@InfoObjetoSB(tags = ..., plural = ...)`. Ela fica na mesma tabela, com o discriminador `tipoAtributo`.
2. Se tiver parâmetros próprios, sobrescrever `prepararNovoObjeto`. Chame `super.prepararNovoObjeto(parametros)`, repita a anotação `@InfoPreparacaoObjeto` e leia os parâmetros extras com `isTemParametroDesteTipo`/`getParametroInicialEnviado`.
3. Fazer `FabTiposEntidade.getAtributo()` (ou um método equivalente) criar a subclasse conforme o `FabTipoAtributoObjeto`. Ex.: `OBJETO_DE_UMA_LISTA` → `AtributoEntidadeEntidade`; `LISTA_OBJETOS_PUBLICOS`/`LISTA_OBJETOS_PARTICULARES` → `AtrubutoEntidadeLista`.
4. No console (`FabTipoItemProjeto.ATRIBUTO_OBJETO`), a classe e o tipo do atributo novo vêm do texto e do nome (`FabTipoInstanciaAtributoProjeto.getTipoInstanciaPeloNome` e `getTipoPeloNome` de cada instância; sem correspondência, `getTipoPadrao()`). Para novos nomes com tipo automático, ajuste os mapas `TIPOS_POR_NOME_EXATO_*` desse enum (regras em `instrucoesIA/console`).

## Ações (`acoes/projetoCarameloBuilder/entidade/FabAcaoProjetoCRCEntidade`)

Um mesmo enum pode ter mais de um bloco de gestão. Cada bloco começa com um `@InfoTipoAcaoGestaoEntidade(entidade = ...)`, e as ações seguintes usam o mesmo prefixo. Veja `FabAcaoProjetoCRCCarameloFormulario` como referência.

| Ação | Tipo | Uso |
|---|---|---|
| `ENTIDADE_MB_GESTAO` | gestão de `ObjetoProjCRC` | |
| `ENTIDADE_FRM_LISTAR` / `ENTIDADE_FRM_EDITAR` / `ENTIDADE_FRM_NOVO` | formulário | editar e novo objeto |
| `ENTIDADE_CTR_SALVAR` | controller | salva o objeto (atributos em cascata) |
| `ATRIBUTO_ENTIDADE_MB_GESTAO` | gestão de `AtributoDeEntidadeSimples` | |
| `ATRIBUTO_ENTIDADE_FRM_LISTAR` | formulário | "listar atributos" de uma entidade (`Entidade.`) |
| `ATRIBUTO_ENTIDADE_FRM_NOVO` / `ATRIBUTO_ENTIDADE_FRM_EDITAR` | formulário | novo e editar atributo |
| `ATRIBUTO_ENTIDADE_CTR_SALVAR` | controller | salva um atributo avulso |

- Use prefixos que não comecem iguais aos de outro bloco (`ATRIBUTO_ENTIDADE_`, e não `ENTIDADE_ATRIBUTO_`).
- **Regra de negócio:** `regraDeNegocio/Entidadeobjeto/ExecAcoesObjetosEntidadeCRC` (estende `ControllerAbstratoSBPersistencia`). Cada ação de controller tem um método `public static ItfRespostaAcaoDoSistema`, anotado com `@InfoAcaoEntidadeObjetoCRCProjeto(acao = ...)`, no padrão:
  ```java
  return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(item), item) {
      @Override
      public void regraDeNegocio() throws ErroRegraDeNegocio {
          setRetorno(atualizarEntidade(item));
      }
  }.getResposta();
  ```
  - `salvarObjetoEntidade(ObjetoProjCRC)` corresponde a `ENTIDADE_CTR_SALVAR`.
  - `salvarAtributoEntidade(AtributoDeEntidadeSimples)` corresponde a `ATRIBUTO_ENTIDADE_CTR_SALVAR` e recusa atributo sem entidade.
- `ExecAcoesProjetosCRC.salvarItem(ComoItemProjeto)` (`CONSOLE_ITEM_PROJ_CTR_SALVAR`) repassa para `salvarObjetoEntidade` quando o item é um `ObjetoProjCRC`. Os outros tipos ainda dão "Não implementado".
- Para executar uma ação: `CarameloCode.getServicoController().getResposta(acao, item)`. É preciso haver um usuário logado com permissão.

## Cuidados ao alterar o modelo
- **Mudança de mapeamento muda o esquema** (`mappedBy`, `cascade`, campos novos). Dados salvos por fluxos anteriores, como o resultado do `FluxoCadastroProjeto` carregado pelos testes do console, podem precisar ser gerados de novo.
- **Mantenha `nome` e `nomeEntidade` coerentes** no `ObjetoProjCRC`, porque o console usa `nomeEntidade`.
- **Itens exibidos no console precisam implementar `ComoItemProjeto`**, porque o `ItemOpcaoConsole.itemAssociado` é desse tipo.
- **Item novo não deve entrar na lista do objeto gerenciado pelo repositório** antes de ser salvo, para não alterar o cache do console.
