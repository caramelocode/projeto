# CLAUDE.md — Criação de Ações no Caramelo Code

Este arquivo ensina como criar **Fábricas de Ações**, declarar as **páginas vinculadas** e escrever a **implementação básica** da regra de negócio num sistema Caramelo Code (SBCore / SBAcessosModel).

Um sistema Caramelo Code é descrito por **Objetos** (entidades JPA anotadas com `@InfoObjetoSB`) e **Ações** (constantes de um enum de fábrica). Quase tudo é resolvido por **convenção de nome + anotação**: o nome da constante define o tipo da ação, a ação de gestão a que ela pertence e o XHTML padrão. Errar o nome quebra a ação em tempo de inicialização.

---

## 1. Os três tipos de ação

| Slug no nome | Tipo base (`FabTipoAcaoBase`) | Anotação obrigatória | O que é |
|---|---|---|---|
| `_MB` | `GESTAO` | `@InfoTipoAcaoGestaoEntidade` | Página de gestão. Corresponde a uma página (managed bean `@ViewScoped`) que agrupa e gerencia todas as ações do mesmo domínio. |
| `_FRM_` | `FORMULARIO` | `@InfoTipoAcaoFormulario` | Um formulário (XHTML) exibido dentro da página de gestão. Tem subtipos. |
| `_CTR_` | `CONTROLLER` | `@InfoTipoAcaoController` | Executa regra de negócio. Vinculada a um método `static` numa classe que estende `ControllerAbstratoSBPersistencia`. |

**A anotação precisa bater com o slug.** Se uma constante `_FRM_` receber `@InfoTipoAcaoController` (ou qualquer outra anotação que não a do seu tipo), `UtilFabricaDeAcoesAcessosModel.configurarAnotacoesAcao` lança `"Erro anotação ou nome de ação incompatível"`.

---

## 2. Convenção de nomes (a parte mais importante)

```
<DOMINIO>_MB[_<QUALQUER_COISA>]        → ação de gestão do domínio
<DOMINIO>_FRM_<SUBTIPO_OU_NOME>        → formulário do domínio
<DOMINIO>_CTR_<SUBTIPO_OU_NOME>        → controller do domínio
```

Exemplos reais:

```
PROJETO_MB_GESTAO          EXECUCAO_ATIVIDADE_MB        MEU_PERFIL_MB
PROJETO_FRM_LISTAR         EXECUCAO_ATIVIDADE_FRM_...   MEU_PERFIL_FRM_EDITAR
PROJETO_CTR_SALVAR_MERGE   EXECUCAO_ATIVIDADE_CTR_...   MEU_PERFIL_CTR_SALVAR_MERGE
```

### Regras

1. **`<DOMINIO>` idêntico** em todas as ações do grupo. A ação principal é encontrada por `getAcaoPrincipalDoDominio`:
   - método 1: mesma classe de enum + mesmo nome de domínio (`UtilFabricaDeAcoesBasico.getNomeDominio`) + contém `_MB`;
   - método 2: o nome da ação começa com o texto que vem antes de `_MB` em alguma constante.
2. **Toda ação `_FRM_`/`_CTR_` precisa de uma `_MB` do mesmo domínio no mesmo enum.** Sem ela: `"A ação X deveria ter uma ação principal vinculada"`.
3. **Declare a `_MB` primeiro** e as secundárias logo abaixo, agrupadas por domínio.
4. **Nunca use o texto `_MB` dentro de uma ação que não é de gestão.** A verificação é `toString().contains("_MB")`, então `PROSPECTO_CTR_SALVAR_MBOX` seria tratado como gestão.
5. **Evite domínios em que um é prefixo do outro no mesmo enum** (ex.: `PEDIDO` e `PEDIDO_ITEM`). O método 2 usa `startsWith` sobre um `HashMap`, e com isso a ação pode cair na gestão errada. Prefira `PEDIDO` + `ITEM_PEDIDO`.
6. Nomes em `CAIXA_ALTA_COM_UNDERLINE`, sem acentos.

7. **Não use palavras-chave de subtipo no `<DOMINIO>`** (lista na seção 2.2). Exemplo: `CLIENTE_NOVO_FRM_LISTAR` é detectado como `FORMULARIO_PERSONALIZADO`, e não como `LISTAR`.

### 2.1 Como o subtipo é detectado

O subtipo é o `FabTipoAcaoSistemaGenerica`, resolvido por `getAcaoGenericaByNome(nomeDaConstante)` nesta ordem:

1. Contém `_MB` → `GERENCIAR_DOMINIO`.
2. Contém `CTR_EXCLUIR` → `CONTROLLER_REMOVER`.
3. Contém `CTR_SALVAR_MERGE` → `CONTROLLER_SALVAR_MODO_MERGE`.
4. Contém `CTR_SALVAR_NOVO` → `CONTROLLER_SALVAR_NOVO`.
5. Senão, **pontuação por palavras-chave**. Para cada tipo, conta quantas das suas palavras-chave aparecem no nome como `_<PALAVRA>`, **em qualquer posição** (inclusive no domínio). Vence o tipo com **mais palavras encontradas**. O personalizado (`FRM` ou `CTR` sozinho) só vence quando nenhum subtipo encontra mais de uma palavra.
6. **Validação final dos formulários:** `NOVO`, `EDITAR`, `VISUALIZAR`, `LISTAR` e `MODAL` só valem se o nome contiver literalmente `FRM_NOVO`, `FRM_EDITAR`, `FRM_VISUALIZAR`, `FRM_LISTAR` ou `FRM_MODAL`. Caso contrário, viram `FORMULARIO_PERSONALIZADO`. **Controllers não têm essa validação.**
7. Nenhum tipo encontrado → `"Não foi possível encontar o Tipo da ação para: ..."`.

Convenções usadas abaixo (inferidas de `UtilFabricaDeAcoesBasico`):
- `dominio` = `getNomeDominio`, a parte antes de `_MB`/`_FRM_`/`_CTR_`, em minúsculas no XHTML;
- `pos` = `getNomeAcaoPosSlugTipoAcao`, a parte depois do slug do tipo (ex.: em `PROSPECTO_FRM_NOVO_CADASTRO_RAPIDO`, `pos` = `NOVO_CADASTRO_RAPIDO`).

### 2.2 Subtipos de formulário (`_FRM_`)

| Subtipo | Como nomear | Palavras-chave | Classe criada | XHTML padrão | Estado padrão | Ícone padrão | Nome gerado |
|---|---|---|---|---|---|---|---|
| `FORMULARIO_NOVO_REGISTRO` | `X_FRM_NOVO[_SUFIXO]` | FRM, NOVO | `AcaoFormEntidadeSec` | `x_novo.xhtml`; com sufixo: `x_novo_sufixo.xhtml`; com `utilizarMesmoFormEdicao`: `x_editar.xhtml` | `NOVO` | `fa fa-plus` | "Novo/Nova \<obj\>" |
| `FORMULARIO_EDITAR` | `X_FRM_EDITAR[_SUFIXO]` | FRM, EDITAR | `AcaoFormEntidadeSec` | `x_editar.xhtml`; com sufixo: `x_editar_sufixo.xhtml` | `EDITAR` | `fa fa-edit` | "Editar \<obj\>" |
| `FORMULARIO_VISUALIZAR` | `X_FRM_VISUALIZAR` | FRM, VISUALIZAR | `AcaoFormEntidadeSec` | **sempre** `x_visualizar.xhtml` (sufixo ignorado); com `utilizarMesmoFormEdicao`: `x_editar.xhtml` | `VISUALIZAR` | `fa fa-eye` | "Visualizar \<obj\>" |
| `FORMULARIO_LISTAR` | `X_FRM_LISTAR` | FRM, LISTAR | `AcaoFormEntidadeSec` | **sempre** `x_listar.xhtml` (sufixo ignorado) | `VISUALIZAR` | `fa fa-list-alt` | "Listar \<obj\>" |
| `FORMULARIO_MODAL` | `X_FRM_MODAL[_SUFIXO]` | FRM, MODAL | `AcaoFormModalEntidade` | `x_modal` + `pos` em minúsculas (sem `_`): **defina `xhtmlDaAcao`** | `EDITAR` | `fa fa-gear` | da anotação |
| `SELECAO_DE_ACAO` | `X_FRM_SELECAO_DE_ACAO` | FRM, SELECAO_DE_ACAO | `AcaoSelecionarAcao` | `x_selecao` + `pos` (sem `_`): **defina `xhtmlDaAcao`** | `EDITAR` | `fa fa-map-signs` | "Para onde você deseja ir?" |
| `FORMULARIO_PERSONALIZADO` | `X_FRM_<QUALQUER>` | FRM | `AcaoFormEntidadeSec` | `x_<pos>.xhtml` (ex.: `PROJETO_FRM_PUBLICAR` → `projeto_publicar.xhtml`) | `EDITAR` | nenhum: **defina na anotação** | "\<Última parte\> \<obj\>" |

Componente visual padrão: `LISTAR` usa `ACAO_LISTAGEM_RESPONSIVA`; NOVO, EDITAR, VISUALIZAR, PERSONALIZADO e MODAL usam `ACAO_REGISTRO_RESPONSIVO`.

**Variações de LISTAR/VISUALIZAR.** `X_FRM_LISTAR_ATIVOS` continua sendo `LISTAR` e aponta para o **mesmo** `x_listar.xhtml` de `X_FRM_LISTAR`. Para ter tela própria, informe `xhtmlDaAcao`, como o CRM faz em `EMAILS_FRM_LISTAR_ENVIADOS` → `emails_listarEnviados.xhtml`.

### 2.3 Subtipos de controller (`_CTR_`)

Todos criam `AcaoDeEntidadeController`, exceto `AUTO_EXECUCAO`, que cria `AcaoControllerAutoExecucao`.

| Subtipo | Como nomear | Palavras-chave | Ícone padrão | Nome gerado | Descrição padrão |
|---|---|---|---|---|---|
| `CONTROLLER_SALVAR_MODO_MERGE` | `X_CTR_SALVAR_MERGE[_SUFIXO]` (regra direta) | CTR, MERGE | `fa fa-save` | "Salvar \<obj\>" | Salva ou cria um registro caso não exista um com este id |
| `CONTROLLER_SALVAR_NOVO` | `X_CTR_SALVAR_NOVO` (regra direta) ou **qualquer** CTR com `_NOVO` | CTR, NOVO | `fa fa-save` | "Salvar \<obj\>" | Criar Registro |
| `CONTROLLER_SALVAR_EDICAO` | `X_CTR_SALVAR_EDICAO`, e também **`X_CTR_SALVAR` ou `X_CTR_SALVAR_<qualquer>`** | CTR, SALVAR, EDICAO | `fa fa-save` | "Salvar \<obj\>" | Salvar Alterações |
| `CONTROLLER_ATIVAR_DESATIVAR` | `X_CTR_ALTERAR_STATUS` (precisa das três palavras) | CTR, ALTERAR, STATUS | `fa fa-retweet` | "Alterar status \<obj\>" | Alterar Status entre Ativo e Inativo |
| `CONTROLLER_ATIVAR` | `X_CTR_ATIVAR` | CTR, ATIVAR | `fa fa-check` | "Ativar \<obj\>" | Marca o registro como ativo |
| `CONTROLLER_DESATIVAR` | `X_CTR_DESATIVAR` | CTR, DESATIVAR | `fa fa-close` | "Desativar \<obj\>" | Marca o registro como desativado |
| `CONTROLLER_REMOVER` | `X_CTR_REMOVER` ou `X_CTR_EXCLUIR` (regra direta) | CTR, REMOVER | `fa fa-minus` | "Excluir \<obj\>" | Remove o registro de maneira irreversível |
| `CONTROLLER_AUTO_EXECUCAO` | `X_CTR_<NOME>_AUTO_EXEC` | CTR, AUTO_EXEC | `fa fa-android` | "\<Última parte\> \<obj\>" | Ações pré agendadas executadas pelo sistema |
| `CONTROLLER_PERSONALIZADO` | `X_CTR_<QUALQUER>` | CTR | `fa fa-gear` | "\<Última parte\> \<obj\>" | — |

Estado padrão de todos os controllers: `VISUALIZAR`.

### 2.4 Gestão (`_MB`)

| Subtipo | Como nomear | Classe criada | XHTML padrão | Ícone padrão |
|---|---|---|---|---|
| `GERENCIAR_DOMINIO` | `X_MB` ou `X_MB_<SUFIXO>` | `AcaoGestaoEntidade` (recebe todas as subações do domínio) | `x_<sufixo>.xhtml` (ex.: `PROJETO_MB_GESTAO` → `projeto_gestao.xhtml`); sem sufixo: `x_gerenciar.xhtml` | ícone da entidade (`@InfoObjetoSB`) |

### 2.5 Armadilhas da detecção (casos reais)

- **Palavras reservadas:** `NOVO`, `EDITAR`, `VISUALIZAR`, `LISTAR`, `MODAL`, `SELECAO_DE_ACAO`, `SALVAR`, `EDICAO`, `MERGE`, `ALTERAR`, `STATUS`, `ATIVAR`, `DESATIVAR`, `REMOVER`, `EXCLUIR`, `AUTO_EXEC`. Só use quando quiser o subtipo correspondente.
- `PROSPECTO_CTR_ALTERAR_STATUS_PRIVADO` é detectado como `CONTROLLER_ATIVAR_DESATIVAR` (tem CTR, ALTERAR e STATUS).
- `REQUISITO_CTR_SALVAR`, `PROSPECTO_CTR_SALVAR_SERVICOS` e `PROSPECTO_CTR_SALVAR_E_EXECUTAR_ATIVIDADE` são detectados como `CONTROLLER_SALVAR_EDICAO`.
- Qualquer controller com `_NOVO` vira `CONTROLLER_SALVAR_NOVO` (ex.: `X_CTR_GERAR_NOVO_CODIGO`).
- `X_CTR_DESATIVAR` **não** casa com `ATIVAR`: a busca é por `_ATIVAR`, e o `S` vem antes. Também não há conflito com `_ATIVIDADE`.
- `nomeAcao`/`descricao` da anotação sobrescrevem os textos gerados, mas **não** o subtipo. Se a ação não é de fato um salvar/remover/ativar, evite as palavras-chave para não herdar o comportamento padrão do subtipo.

O **nome do objeto** nos textos padrão vem de `@InfoObjetoSB(tags = {...})` da entidade (`tags()[0]`), e o gênero de `generoFeminino`. **Toda entidade usada numa gestão precisa de `@InfoObjetoSB` com `tags`.**

---

## 3. Estrutura da Fábrica de Ações

```java
package br.org.carameloCode.erp.modulo.<modulo>.acoes.<area>;

@InfoModulo<Modulo>(modulo = FabModulos<Modulo>.<MODULO>)          // obrigatório: define o módulo
public enum FabAcao<Area><Contexto> implements ComoFabricaDeAcoesPersistencia {

    @InfoTipoAcaoGestaoEntidade(entidade = Pedido.class, icone = "fa-solid fa-cart-shopping",
            nomeAcao = "Pedidos", precisaPermissao = true)
    PEDIDO_MB_GESTAO,
    @InfoTipoAcaoFormulario(icone = "fa-solid fa-list", campos = {"id", "cliente", "dataHoraCriacao", "status"})
    PEDIDO_FRM_LISTAR,
    @InfoTipoAcaoFormulario(icone = "fa-solid fa-plus", estadoFormulario = FabEstadoFormulario.NOVO,
            campos = {"[separador: Dados do pedido]", "cliente", "observacao"})
    PEDIDO_FRM_NOVO,
    @InfoTipoAcaoFormulario(icone = "fa-solid fa-pen-to-square",
            campos = {"[separador: Dados do pedido]", "id", "cliente", "observacao",
                      "[separador: Itens]", "itens[].produto", "itens[].quantidade"})
    PEDIDO_FRM_EDITAR,
    @InfoTipoAcaoController(iconeFonteAnsowame = FabIconeFontAwesome.REG_SALVAR, nomeAcao = "Salvar")
    PEDIDO_CTR_SALVAR_MERGE,
    @InfoTipoAcaoController(nomeAcao = "Cancelar pedido", icone = "fa-solid fa-ban",
            comunicacao = FabTipoComunicacao.PERGUNTAR_SIM_OU_NAO,
            fraseComunicação = "Você tem certeza? Esta ação é definitiva.")
    PEDIDO_CTR_CANCELAR;
}
```

- `getModuloByFabrica` lê a anotação de módulo do enum pelo atributo `modulo`. Sem ela: `"você anotou o nome do modulo na fabrica de ações?"`.
- Cada módulo tem sua anotação (`@InfoModulosCRM`, `@InfoModuloProjetoCaraelo`, ...). Use a do módulo onde a fábrica vive.
- Imports: `ComoFabricaDeAcoesPersistencia` (`com.super_bits.modulos.SBAcessosModel.fabricas`), anotações em `com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes`.

### 3.1 Atributos das anotações

**Comuns às três:** `nomeAcao`, `descricao` (se vazia, usa `nomeAcao`), `icone` (classes Font Awesome 6, ver 3.2), `iconeFonteAnsowame` (`FabIconeFontAwesome.*`), `precisaPermissao`, `entidade` (sobrescreve a entidade do domínio), `xhtmlDaAcao` (sobrescreve o XHTML padrão), `codigoJira` (deprecated, não use).

Prioridade do ícone: `icone` (string com mais de 2 caracteres) → `iconeFonteAnsowame` (se ≠ `ICONE_PERSONALIZADO`) → ícone da entidade (só em gestão) → ícone padrão do subtipo (seção 2). Use **um** dos dois atributos, nunca ambos.

**`@InfoTipoAcaoGestaoEntidade`**
- `entidade`: **sempre informe**. É a entidade do domínio, herdada por todas as subações.
- `utilizarMesmoFormEdicao`: quando verdadeiro, `FRM_NOVO` e `FRM_VISUALIZAR` reutilizam o XHTML do `FRM_EDITAR`. Use `false` quando novo/visualizar tiverem telas próprias.

**`@InfoTipoAcaoFormulario`**
- `campos`: lista de caminhos relativos à entidade da ação:
  - `"nome"`: atributo simples;
  - `"localizacao.bairro.cidade"`: navegação por objeto;
  - `"servicoOferecido[].valorMensal"`: atributo de item de lista;
  - `"[separador: Título]"`: cria um grupo de campos;
  - constantes `CP<Entidade>.<campo>` (ex. `CPPessoaFisica.cpf`), **preferíveis** a strings soltas.
  - Nunca use `""`: gera erro. Um campo inexistente gera `"Campo declarado em ação não existe"`.
  - Sem `campos`, o formulário usa o grupo padrão da entidade (`GRUPO_PADRAO_ITEM_NORMAL` / `GRUPO_PADRAO_ITEM_SIMPLES`).
- `estadoFormulario`: `FabEstadoFormulario.NOVO`, `EDITAR`, ... (o padrão vem do subtipo).
- `valoresParametroEstatico`: parâmetros fixos da URL.
- Anotações extras na mesma constante, para comportamento por grupo de campos: `@InfoTipoAcaoFormCamposAtualizaForm`, `@InfoTipoAcaoFormCamposAtualizaGrupoDoCampo`, `@InfoTipoAcaoFormCamposAtualizaComponentePeloId`, `@InfoTipoAcaoFormCamposLabelAlternativo` e `@InfoTipoAcaoFormCamposSomenteLeitura`.

**`@InfoTipoAcaoController`**
- `comunicacao` + `fraseComunicação` (**com ç**): confirmação antes de executar (ex. `FabTipoComunicacao.PERGUNTAR_SIM_OU_NAO`).
- `precisaJustificativa` + `campoJustificativa`: pede uma justificativa.
- `xhtmlModalConfirmacaoPersonalizado`: modal de confirmação próprio.
- `autoExecucao` (`FabTipoAutoExecucaoAcao`): exige `AUTO_EXEC` no nome da ação.

### 3.2 Ícones: Font Awesome 6

O sistema usa **Font Awesome 6 carregado como CSS (web fonts)**, com os `v4-shims` para compatibilidade.

- **Em código novo, use sempre a sintaxe FA6:** `"fa-solid fa-<nome>"`, `"fa-regular fa-<nome>"` ou `"fa-brands fa-<nome>"`.
  - Ex.: `"fa-solid fa-floppy-disk"`, `"fa-solid fa-pen-to-square"`, `"fa-solid fa-trash-can"`, `"fa-regular fa-star"`, `"fa-solid fa-file-invoice-dollar"`.
  - Use os nomes de ícone do FA6. Vários nomes do FA4 mudaram: `fa-save` → `fa-floppy-disk`, `fa-edit`/`fa-pencil` → `fa-pen-to-square`/`fa-pen`, `fa-close`/`fa-remove` → `fa-xmark`, `fa-shopping-cart` → `fa-cart-shopping`, `fa-list-alt` → `fa-rectangle-list`, `fa-envelope-o` → `fa-regular fa-envelope`.
- `"fa fa-<nome>"` (FA4) aparece nos ícones padrão do framework e em fábricas antigas. Ele ainda funciona pelos shims, mas **não use em ações novas**.
- `iconeFonteAnsowame = FabIconeFontAwesome.*` continua válido para ícones semânticos do framework (`REG_SALVAR`, `REG_EDITAR`, `REG_REMOVER`, `COMUNICACAO_AVIAO_DE_PAPEL`, ...).
- Como o FA6 é carregado como CSS, `fa-layers` e `data-fa-transform` **não funcionam**. Sobreposição de ícones exige posicionamento absoluto em CSS.

### 3.3 Quando criar cada ação

- **Uma `_MB` por página.** Se duas telas de menu diferentes gerenciam a mesma entidade (ex. `PROSPECTO_MB_GERENCIAR` e `MEUS_PROSPECTOS_MB_GERENCIAR`), são dois domínios.
- **Um `_FRM_` por tela/aba/modal** dentro da página.
- **Um `_CTR_` por botão que altera estado.** Leitura pura (listar, filtrar) não precisa de controller.
- CRUD mínimo: `_MB_GESTAO`, `_FRM_LISTAR`, `_FRM_NOVO`, `_FRM_EDITAR` e `_CTR_SALVAR_MERGE` (mais `_CTR_REMOVER` se houver exclusão).

---

## 4. Anotação de vínculo (método ↔ ação)

Cada fábrica tem uma anotação própria que liga o método de regra de negócio à constante do enum, com atributo `acao`:

```java
@InfoAcaoCRMAtendimento(acao = FabAcaoCRMAtendimento.PROSPECTO_CTR_SALVAR_MERGE)
@InfoAcaoEntidadeObjetoCRCProjeto(acao = FabAcaoCarameloDevEdicaoItemProj.ENTIDADE_CTR_SALVAR_NOVO)
```

A mesma anotação é usada em **dois lugares**:
- no **método** de regra de negócio (ações `_CTR_`);
- na **classe da página** (ações `_MB`, ver seção 7).

Ao criar uma fábrica nova, crie a anotação `InfoAcao<NomeDaFabrica>` **no mesmo pacote do enum**, com este formato exato:

```java
/*
 *  Desenvolvido pela equipe Super-Bits.com CNPJ 20.019.971/0001-90

 */
package br.org.carameloCode.erp.modulo.<modulo>.acoes.<area>;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 *
 * Esta anotação faz parate do conjutnos de soluções da camada controller do
 * sistema
 *
 * Deve ser utilizado para nomear as fabricas de ações do sistema
 *
 * @author <a href="mailto:salviof@gmail.com">Salvio Furbino</a>
 * @since 16/12/2015
 * @version 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface InfoAcaoPedido {

    public FabAcaoPedido acao();

}
```

- **Sem `@Target`**: é o que permite usar a mesma anotação em método e em classe. Não adicione.
- `@Retention(RetentionPolicy.RUNTIME)` é obrigatório (a leitura é por reflexão).
- Um único atributo, `acao()`, tipado com o enum da fábrica.
- Nome: `InfoAcao<Contexto>` (ex.: `InfoAcaoCRMAplicacao` ↔ `FabAcaoCrmAplicacao`, `InfoAcaoProjetoCRCConsole` ↔ `FabAcaoCarameloDevConsoleCRCProjeto`).

---

## 5. Implementação da regra de negócio (ações `_CTR_`)

### 5.1 Classe de regra de negócio

```java
public class ModuloPedido extends ControllerAbstratoSBPersistencia {   // ou ExecAcoes<Contexto>
    ...
}
```

- Siga a convenção de nome do módulo: o CRM usa `Modulo<Area>`, o módulo Projeto usa `ExecAcoes<Contexto>`.
- **Registre a classe** no construtor do `ConfigPermissao<Sistema>` (que estende `ConfigPermissoesAcessoModelAbstrato`). Sem isso, os métodos não são encontrados:

```java
public ConfigPermissaoProjetoCRC() {
    super(new Class[]{ExecAcoesProjetosCRC.class, ..., ModuloPedido.class});
}
```

### 5.2 Método: esqueleto padrão

```java
@InfoAcaoPedido(acao = FabAcaoPedido.PEDIDO_CTR_SALVAR_MERGE)
public static ItfRespostaAcaoDoSistema pedidoSalvar(final Pedido pPedido) {

    return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pPedido), pPedido) {
        @Override
        public void regraDeNegocio() throws ErroRegraDeNegocio {
            if (pPedido.getCliente() == null) {
                throw new ErroRegraDeNegocio("Informe o cliente do pedido");
            }
            setRetorno(atualizarEntidade(pPedido));
        }
    }.dispararMensagens();
}
```

Esqueleto para ação **ainda não implementada** (gerado junto com a fábrica):

```java
@InfoAcaoPedido(acao = FabAcaoPedido.PEDIDO_CTR_CANCELAR)
public static ItfRespostaAcaoDoSistema pedidoCancelar(final Pedido pPedido) {

    return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pPedido), pPedido) {
        @Override
        public void regraDeNegocio() throws ErroRegraDeNegocio {
            // Regra de negócio aqui
            throw new ErroRegraDeNegocio("ainda não implementado");
        }
    }.getResposta();
}
```

**Regras do método**
- `public static`, retorna `ItfRespostaAcaoDoSistema`, um método por ação `_CTR_`.
- O parâmetro é a entidade da ação (a do domínio ou a do `entidade=` da anotação). Parâmetros extras são permitidos (ex. `(Pessoa prosp, List<ArquivoAnexado> pArquivos)`).
- Nome do método: `<objeto><Verbo>` em camelCase (`prospectoSalvar`, `orcamentoSalvar`, `atividadeConcluir`).
- Métodos auxiliares sem anotação: `private static`.

### 5.3 Escolhendo a resposta

| Construção | Quando usar |
|---|---|
| `getNovaRespostaAutorizaChecaNulo(obj)` | Padrão: verifica permissão e se o objeto é nulo |
| `getNovaRespostaComAutorizacao(Entidade.class)` | Quando o objeto pode chegar nulo |
| `getNovaResposta(Entidade.class)` | Sem verificação de permissão (uso interno) |
| `RespostaComGestaoEMRegraDeNegocioPadrao(resp, entidade)` | Padrão: gerencia EntityManager e transação |
| `RespostaComGestaoEntityManager(resp)` | Sem entidade principal (lotes, integrações) |
| `.getResposta()` | Retorna sem exibir mensagens (o chamador decide) |
| `.dispararMensagens()` | Retorna e já exibe as mensagens ao usuário |

### 5.4 API disponível dentro de `regraDeNegocio()`

- **Erros e mensagens:** `throw new ErroRegraDeNegocio("msg ao usuário")` (interrompe e faz rollback), `addErro`, `addAviso`, `addAlerta`, `isSucesso()`.
- **Persistência:** `atualizarEntidade(e)` / `atualizarEntidade(e, false)`, `loadEntidade(e)` (recarrega no EM da resposta), `removerEntidade(e)`, `getEm()` / `getEmResposta()`, `ConsultaDinamicaDeEntidade(Entidade.class, getEm())`.
- **Retorno e navegação:** `setRetorno(obj)`, `setProximoFormulario(FabAcaoX.Y.getRegistro().getComoFormulario())`, `setUrlDestinoSucesso(SBCore.getServicoVisualizacao().getEndrRemotoFormulario(FabAcaoX.Y, obj...))`.
- **Encadeamento:** `adicionarGatilhoExecucaoFinalComSucesso(FabAcaoX.Y_CTR_Z, entidade)`.
- **Contexto:** `SBCore.getUsuarioLogado()`, `SBCore.getServicoPermissao().isObjetoPermitidoUsuario(usr, obj)`.
- **Valores calculados:** `entidade.getCPinst(CPEntidade.campo).getValor()`.

Ganchos opcionais (sempre chame `super` primeiro):

```java
@Override
public void executarAcoesFinais() throws ErroEmBancoDeDados {
    super.executarAcoesFinais();
    if (isSucesso()) {
        // notificações, integrações externas (Mautic, Matrix, e-mail): fora da transação principal
    }
}
```

**Boas práticas observadas no código:**
- Recarregue a entidade antes de alterar estado (`loadEntidade(pX)`) e altere a cópia carregada.
- Validações primeiro, com `ErroRegraDeNegocio`; persistência depois.
- Integrações externas e envios ficam em `executarAcoesFinais`, com `EntityManager` próprio fechado em `finally` (`UtilSBPersistencia.getEMPadraoNovo()` / `fecharEM`).
- Não coloque chaves de API no código: use parâmetros de configuração (`FabConfig...getValorParametroSistema()`).

---

## 6. Permissões

- `precisaPermissao = true` faz a ação entrar no controle de acesso.
- Conceda por grupo em `persistirPermissoesNoBanco()` do `ConfigPermissao<Sistema>`, filtrando pela gestão:

```java
if (acP.getAcaoDeGestaoEntidade().equals(FabAcaoPedido.PEDIDO_MB_GESTAO.getRegistro())) {
    UtilSBControllerAcessosModel.adicionarPermissao(FabGrupos<Sistema>.<GRUPO>.getRegistro(), acP);
}
```

- Para excluir uma ação específica do grupo, compare com `acP.equals(FabAcaoX.Y.getRegistro())` (veja `PROSPECTO_CTR_REMOVER` em `ConfigPermissaoCRMCarameloCodePadrao`).
- Ações de gestão novas aparecem no menu via `definirMenu` / `FabMenu<Sistema>`.

---

## 7. Página vinculada (ação `_MB` + formulários `_FRM_`)

Cada ação `_MB` tem **uma classe de página** (managed bean). Os `_FRM_` do domínio são XHTML renderizados dentro dela; **não** têm bean próprio.

### 7.1 Bean da página: modelo mínimo

```java
package br.org.carameloCode.erp.projeto.paginas.<area>;

import br.org.carameloCode.erp.modulo.<modulo>.acoes.<area>.FabAcaoPedido;
import br.org.carameloCode.erp.modulo.<modulo>.acoes.<area>.InfoAcaoPedido;
import br.org.carameloCode.erp.modulo.<modulo>.entidadesJPA.pedido.Pedido;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.MB_paginaCadastroEntidades;
import com.super_bits.modulosSB.webPaginas.JSFManagedBeans.formularios.reflexao.anotacoes.InfoPagina;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author salvio
 */
@Named
@ViewScoped
@InfoAcaoPedido(acao = FabAcaoPedido.PEDIDO_MB_GESTAO)
@InfoPagina(nomeCurto = "ped", tags = "Pedidos")
public class PgPedido extends MB_paginaCadastroEntidades<Pedido> {

}
```

Na maioria dos casos o bean é **vazio**: `MB_paginaCadastroEntidades` resolve listagem, seleção, navegação entre os `_FRM_` e execução dos `_CTR_` a partir das anotações.

**Regras**
- Nome da classe: `Pg<Nome>`. Pacote: `br.org.carameloCode.erp.projeto.paginas.<area>`.
- `@Named` + `@ViewScoped` de **`javax.faces.view.ViewScoped`** (CDI). Não use `javax.faces.bean.*` nem misture anotações JSF e CDI.
  - `@SessionScoped` (`javax.enterprise.context`) só para páginas que precisam manter estado entre navegações (ex.: `PgConsoleProjetoCRC`). Exceção, não padrão.
- `@InfoAcao<Fabrica>(acao = ..._MB_...)`: **sempre** uma ação `_MB` do enum. É o vínculo página ↔ gestão.
- `@InfoPagina(nomeCurto = "...", tags = "...")`:
  - `nomeCurto`: identificador curto e **único** no sistema (usado na URL), sem espaços nem acentos;
  - `tags`: título legível da página.
- Genérico `MB_paginaCadastroEntidades<Entidade>`: a entidade editada na página, normalmente a mesma `entidade` da `@InfoTipoAcaoGestaoEntidade`.

### 7.2 Parâmetros de URL

Quando a página recebe uma entidade pela URL:

```java
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.TIPO_PARTE_URL;
import com.super_bits.modulosSB.webPaginas.controller.servletes.urls.parametrosURL.InfoParametroURL;
import com.super_bits.modulosSB.webPaginas.controller.servletes.urls.parametrosURL.ParametroURL;

@InfoParametroURL(nome = "Pedido", tipoParametro = TIPO_PARTE_URL.ENTIDADE,
        tipoEntidade = Pedido.class, obrigatorio = false)
private ParametroURL prPedido;
```

- Campo `private ParametroURL pr<Nome>`, um por parâmetro.
- `nome` descreve o parâmetro (não copie o `nome` de outra página).
- `tipoEntidade` é a classe que a URL carrega; pode ser diferente do genérico da página.

### 7.3 Inicialização com `@PostConstruct`

Só quando a entidade selecionada precisa ser montada a partir do parâmetro:

```java
@PostConstruct()
public void inicio() {
    if (getParametroInstanciado(prPedido).isValorDoParametroFoiConfigurado()) {
        Pedido pedido = (Pedido) getParametroInstanciado(prPedido).getValor();
        setEntidadeSelecionada(pedido);
    }
}
```

API usada: `getParametroInstanciado(pr).isValorDoParametroFoiConfigurado()`, `.getValor()`, `setEntidadeSelecionada(obj)` e `getEntidadeSelecionada()`. Não coloque regra de negócio no bean: chame a ação `_CTR_`.

### 7.4 XHTML dos formulários

- O nome padrão vem de `FabTipoAcaoSistemaGenerica.<TIPO>.getnomeXHTMLPadrao(acao)`. A tabela completa por subtipo está nas seções 2.2 e 2.4. Resumo:
  - `X_MB_GESTAO` → `x_gestao.xhtml`; `X_MB` → `x_gerenciar.xhtml`;
  - `X_FRM_NOVO` → `x_novo.xhtml`; `X_FRM_EDITAR` → `x_editar.xhtml`; `X_FRM_LISTAR` → `x_listar.xhtml`; `X_FRM_VISUALIZAR` → `x_visualizar.xhtml`;
  - `X_FRM_<NOME>` → `x_<nome>.xhtml` (tudo em minúsculas, com `_`).
- **Gere o XHTML com o nome padrão sempre que possível.** Use `xhtmlDaAcao = "arquivo.xhtml"` só em três casos: variações de LISTAR/VISUALIZAR, MODAL/SELECAO_DE_ACAO, ou dois formulários que precisam compartilhar o mesmo arquivo.
- Nomes personalizados seguem o padrão `<dominio_em_minusculo>_<acao>.xhtml` (ex. `emails_listarEnviados.xhtml`, `meus_chamados_todos_status.xhtml`).
- Classes CSS novas seguem o manual de componentes (prefixo `crc-`). Use `.size()` em vez de `fn:length()` em EL.

> ⚠ PREENCHER: pasta dos XHTML e um XHTML de formulário real (um padrão e um personalizado) para servir de modelo.

---

## 8. Checklist para criar uma funcionalidade nova

1. **Objeto**: a entidade existe e tem `@InfoObjetoSB(tags = {"Nome"}, generoFeminino = ...)` e constantes `CP<Entidade>`.
2. **Fábrica**: enum `FabAcao<...>` com a anotação de módulo, `implements ComoFabricaDeAcoesPersistencia`; `_MB` primeiro, depois `_FRM_` e `_CTR_` com o **mesmo prefixo de domínio**.
3. **Anotações**: cada constante com a anotação do seu tipo; `entidade` informada na `_MB`; `campos` com `CP*`.
4. **Anotação de vínculo**: `InfoAcao<Fabrica>` criada no pacote do enum (`@Documented` + `@Retention(RUNTIME)`, sem `@Target`, atributo `acao()`), se a fábrica for nova.
5. **Regra de negócio**: um método `public static` anotado por ação `_CTR_`, na classe `extends ControllerAbstratoSBPersistencia`. Ações ainda não implementadas lançam `ErroRegraDeNegocio("ainda não implementado")`.
6. **Registro**: classe de regra de negócio adicionada ao `super(new Class[]{...})` do `ConfigPermissao<Sistema>`. A fábrica precisa estar no config do core (senão: `"O Mapa de ações foi criado, mas a ação procurada não foi encontrada"`).
7. **Permissões**: grupos configurados em `persistirPermissoesNoBanco()`.
8. **Página**: uma classe `Pg<Nome>` por `_MB` (`@Named @ViewScoped @InfoAcao<Fabrica>(acao = ..._MB_...) @InfoPagina(...) extends MB_paginaCadastroEntidades<Entidade>`) + um XHTML por `_FRM_`.
9. **Validação**: subir a aplicação e conferir no log que não houve `SOLICITAR_REPARO` para as novas ações (campo inexistente, ação principal ausente, anotação incompatível).

## 9. Erros comuns → causa

| Mensagem | Causa |
|---|---|
| `deveria ter uma ação principal vinculada` | Falta a `_MB` do domínio ou o prefixo difere |
| `anotação ou nome de ação incompatível` | Anotação não corresponde ao slug `_MB`/`_FRM_`/`_CTR_` |
| `Campo declarado em ação não existe` | Caminho errado em `campos` (use `CP*`) |
| `Existe um campo em branco` | `""` dentro de `campos` |
| `deve conter o SLUG: AUTO_EXEC` | `autoExecucao` sem `AUTO_EXEC` no nome |
| `você anotou o nome do modulo na fabrica de ações?` | Enum sem a anotação de módulo |
| `O Mapa de ações foi criado, mas a ação ... não foi encontrada` | Fábrica não registrada no config do core |
| `Não foi possível encontar o Tipo da ação para` | Nome sem `_MB`, `_FRM` ou `_CTR` |
| `Não foi possível determinar um constructor para a acao` | Sufixo não reconhecido / nome fora da convenção |
| Formulário abre a tela de outro | Variação `_FRM_LISTAR_X`/`_FRM_VISUALIZAR_X` sem `xhtmlDaAcao` (usa o mesmo `x_listar.xhtml`) |
| Ação virou PERSONALIZADO ou outro subtipo inesperado | Palavra reservada no domínio ou no sufixo (seção 2.5) |
| Página não abre / bean não encontrado | Falta `@Named`, `@ViewScoped` importado de `javax.faces.bean`, `nomeCurto` duplicado, ou `@InfoAcao*` apontando para ação que não é `_MB` |
