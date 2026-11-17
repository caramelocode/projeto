# Escopo destas instruções

Estas instruções servem **apenas** para criar ou editar dois arquivos de um teste Cucumber:

1. o arquivo `.feature` (a especificação);
2. a classe `Fluxo...` (o runner e o estado compartilhado entre as etapas).

Não crie nem edite as classes de etapa nem o enum `Etapas...`. Eles são gerados automaticamente pelo runner a partir do `.feature`. Não implemente nenhuma etapa.

# Regras para arquivos .feature (Gherkin em português)

Ao criar ou editar qualquer arquivo `.feature`, siga estritamente as regras abaixo.

## Estrutura obrigatória

Todo arquivo deve seguir exatamente esta ordem:

```gherkin
#language: pt
@NomeDoTeste
Funcionalidade: Descricao da funcionalidade

  Contexto: Descricao do contexto de dados pre estabelecido

  Cenario: Descricao geral do teste
    Dado ...
    E ...
    Quando ...
    Entao ..
    Dado ...
    Quando ..
    Entao ...
    E ...
    Dado ..
    E ...
    Quando ...
    Entao ...
    E ...
```

1. A primeira linha é sempre `#language: pt`.
2. A segunda linha é a tag do teste, no formato `@NomeDoTeste` (PascalCase, sem espaços, sem acentos).
3. `Funcionalidade:` seguida de uma descrição curta do que está sendo testado.
4. `Contexto:` é apenas uma descrição em uma linha dos dados pré-estabelecidos. Ele não tem passos: nada de `Dado`, `Quando`, `Entao` ou `E` abaixo dele.
5. `Cenario:` com uma descrição geral do teste.

## Regras do cenário

- **Apenas um cenário por arquivo.** Nunca crie um segundo `Cenario`.
- O cenário começa com um único `Dado`.
- Depois vêm um ou mais pares `Quando` e `Entao`, ou trios `Dado`, `Quando` e `Entao`, em sequência. Cada um deve ser uma etapa diferente: cada ação do usuário é um `Quando`, uma pré-condição é um `Dado`, e o resultado verificado logo em seguida é um `Entao`.
- Se vários estados precisarem ser validados após a ação do usuário, o `Entao` deve ser seguido de diversos `E`. Se o usuário precisar realizar diversas ações no `Quando`, cada ação deve ser uma etapa `E`. O mesmo vale para as pré-condições do `Dado`.
- O `Dado` não é obrigatório, apenas quando houver uma pré-condição antes do usuário realizar uma ação.
- Não usar `Mas`, `Esquema do Cenario`, `Exemplos`, `Regra` nem `Delineacao do Cenario`.
- Não use comentários (`#`) entre os passos.
- Cada passo gera uma classe de etapa: dois passos com o mesmo texto viram a mesma etapa. Quando o mesmo texto for digitado duas vezes com intenções diferentes, diferencie o passo (ex.: `seguido de ponto e inadimplente` e `seguido de ponto e inadimplente novamente`).

## Regras de texto

- **Sem variáveis:** nada de `<parametro>`, tabelas (`| col |`), doc strings (`"""`), (`.`) ou valores entre aspas.
- **Sem caracteres especiais nos textos:** sem acentos, cedilha, aspas, apóstrofos, barras, símbolos (`$ % & @ # * ( ) [ ] { } / \ - : ;` etc.) e sem pontuação no final das frases. Underline é permitido.
  - Por isso as palavras-chave usadas são as variantes sem acento aceitas pelo Gherkin: `Cenario` e `Entao`.
  - Valores numéricos devem ser escritos de forma simples, por exemplo `cem reais` ou `100 reais`, nunca `R$ 100,00`.
- As exceções são apenas os elementos estruturais: `#language: pt`, a tag `@NomeDoTeste` e os dois pontos após `Funcionalidade`, `Contexto` e `Cenario`.
- Frases curtas, no presente, descrevendo comportamento e não detalhes de implementação.

## Indentação

- `Contexto` e `Cenario` com 2 espaços.
- Passos com 4 espaços.

# O arquivo Fluxo

O Fluxo é o **único lugar compartilhado entre as etapas**, porque cada etapa é uma classe separada. Ele não é uma biblioteca de testes nem um lugar para planejar a implementação: declare só o que mais de uma etapa vai usar. Todo o resto fica dentro da etapa que precisa, escrito de forma explícita, para facilitar o debug.

## Nome, pacote e local

- Classe: `Fluxo` + nome do teste em PascalCase. Ex.: `FluxoConsoleObjetoStatus`.
- **O nome do pacote é todo em minúsculas**, sem underline e sem maiúsculas:
  `org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.<nomedotesteemminusculas>`
  Ex.: tag `@consoleProjCRCObjetoStatus` → pacote `...cucumber.consoleprojcrcobjetostatus`.
- O `glue` é o pacote do fluxo + `.etapas`, também todo em minúsculas.
- O `.feature` fica em `src/test/resources/caracteristicas/<grupo>/<NomeDoTeste>/<NomeDoTeste>.feature`, e o `features` do `@CucumberOptions` aponta para a pasta: `classpath:caracteristicas/<grupo>/<NomeDoTeste>`.

## Modelo

```java
package org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.nomedoteste;

// imports usados, nenhum a mais

/**
 * O que o teste verifica, em poucas linhas.
 *
 * Parte do resultado do FluxoAnterior (o que ele já deixou no banco).
 *
 * @author sfurbino
 */
@RunWith(CucumberSBTestes.class)
@CucumberOptions(features = "classpath:caracteristicas/grupo/NomeDoTeste", tags = "@NomeDoTeste",
        glue = "org.coletivoJava.fw.projetos.projeto.implementacao.cucumber.nomedoteste.etapas",
        monochrome = false, dryRun = false)
public class FluxoNomeDoTeste extends TesteIntegracaoFuncionalidadeCucumber {

    // Sessão
    public static final String EMAIL_USUARIO_ADMIN = "...";
    public static final String SENHA_ADMIN = "...";

    // Entidades de controle (criadas por uma etapa, usadas pelas seguintes)
    public static ProjetoCRC projeto;

    // Dados fixos do feature
    public static final String NOME_ENTIDADE_CLIENTE = "Cliente";

    // Funções estáticas usadas por duas ou mais etapas (se houver)

    @Override
    protected void configAmbienteDesevolvimento() {
        SBCore.configurar(new ConfigCoreProjetoCRC(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        SBPersistencia.configuraJPA(new ConfigPersistenciaProjetoCaramelo(), true, true);
    }
}
```

## O que o Fluxo declara

1. **Configuração do ambiente:** o override de `configAmbienteDesevolvimento()` exatamente como no modelo.
2. **Dados fixos** como `public static final`: e-mail e senha de login, nomes e textos que aparecem no `.feature`, textos digitados e valores esperados (nomes de enum, ids, ações esperadas).
   - **Valores esperados são literais** (`"ATIVO"`, `1L`). Nunca os calcule com o código que está sendo testado (ex.: `getNomeEnumPorTexto("ativo")`), porque o teste passaria mesmo com o sistema errado.
   - Só declare um dado se ele for usado por uma etapa. Se aparece uma vez, numa só etapa, ainda assim pode ser constante (dados fixos não ficam dentro das etapas), mas não crie constantes "para o futuro".
3. **Entidades de controle** como `public static` (sem `final`): só os objetos que uma etapa cria ou carrega e que etapas seguintes precisam usar (ex.: `projeto`, `CONSOLE`, `sugestoesAutocompletar`). Não declare entidades que podem ser recarregadas do banco pelo nome.
4. **Funções estáticas reaproveitáveis**, seguindo a regra abaixo.

## Regra das funções estáticas

Só crie uma função no Fluxo se **duas ou mais etapas** a chamarem. Antes de escrever cada função, liste os passos do `.feature` que vão usá-la. Se for só um, não crie: o código fica na etapa.

Funções que costumam valer a pena (quando usadas em várias etapas):
- executar uma interação repetida, com parâmetro: `digitarNoConsole(String texto)`, `executarOpcaoSelecionada(FabAcao acaoEsperada)`;
- recarregar do banco e localizar uma entidade pelo nome: `getFabricaSalvaNoProjeto(String nome)` retornando `Optional`;
- uma verificação parametrizada repetida em vários `Entao`: `verificarItemSalvo(String nomeEnum, long idObjeto)`;
- montar um texto de entrada a partir de partes: `getTextoItem(String nomeItem)`.

Não crie:
- **uma função por passo** (ex.: `verificarEtapaStatusCriado()`): isso esvazia a etapa e esconde o que ela faz;
- **uma função por item** quando um parâmetro resolve (`getTextoAtivo()`, `getTextoInativo()` → `getTextoStatus(String nome)`);
- **getters que só devolvem uma constante** (`getTextoFabrica()` que retorna `NOME_FABRICA`): use a constante;
- **wrappers de uma linha** sobre uma API do sistema que a etapa pode chamar direto;
- **funções "para o futuro"** que nenhum passo usa hoje;
- **funções privadas auxiliares** de outra função, a não ser que elimine código repetido em duas ou mais funções públicas;
- **constantes que duplicam constantes do sistema** (separadores, prefixos): use a do sistema para montar o texto de entrada.

Cada função deve ser curta, ter um Javadoc de uma ou duas linhas e fazer asserts com mensagem clara quando o resultado for obrigatório (`Assert.assertNotNull("Fábrica X não está no repositório", fabrica)`). Use `assertEquals(mensagem, esperado, atual)` nessa ordem. Nunca capture `Throwable` em volta de asserts.

## O que o Fluxo não contém

- Implementação de etapas, ou métodos com o corpo de uma etapa.
- Imports sem uso.
- Recursos além do Java 8 e dependências novas.

## Checklist antes de entregar o Fluxo

- [ ] Pacote e `glue` todos em minúsculas, e o `glue` termina em `.etapas`.
- [ ] `features` e `tags` batem com a pasta e a tag do `.feature`.
- [ ] Cada função estática tem pelo menos duas etapas que a usam (liste quais).
- [ ] Nenhuma função devolve só uma constante ou embrulha uma única chamada.
- [ ] Valores esperados são literais.
- [ ] Toda entidade `public static` é escrita por uma etapa e lida por outra.
- [ ] Nenhum import sem uso.
