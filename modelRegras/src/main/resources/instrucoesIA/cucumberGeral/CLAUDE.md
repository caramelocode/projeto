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
    E ...
    Entao ...
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
- Depois vêm um ou mais pares `Quando` e `Entao`, em sequência: cada ação do usuário é um `Quando` e o resultado verificado logo em seguida é um `Entao`.
- `E` complementa o passo anterior (mais uma condição no `Dado` ou mais uma verificação no `Entao`). Uma nova ação do usuário nunca é um `E`: ela abre um novo `Quando`.
- Não usar `Mas`, `Esquema do Cenario`, `Exemplos`, `Regra` nem `Delineacao do Cenario`.

## Regras de texto

- **Sem variáveis:** nada de `<parametro>`, tabelas (`| col |`), doc strings (`"""`) ou valores entre aspas.
- **Sem caracteres especiais nos textos:** sem acentos, cedilha, aspas, apóstrofos, barras, símbolos (`$ % & @ # * ( ) [ ] { } / \ - _ : ;` etc.) e sem pontuação no final das frases.
  - Por isso as palavras-chave usadas são as variantes sem acento aceitas pelo Gherkin: `Cenario` e `Entao`.
  - Valores numéricos devem ser escritos de forma simples, por exemplo `cem reais` ou `100 reais`, nunca `R$ 100,00`.
- As exceções são apenas os elementos estruturais: `#language: pt`, a tag `@NomeDoTeste` e os dois pontos após `Funcionalidade`, `Contexto` e `Cenario`.
- Frases curtas, no presente, descrevendo comportamento e não detalhes de implementação.

## Indentação

- `Contexto` e `Cenario` com 2 espaços.
- Passos com 4 espaços.