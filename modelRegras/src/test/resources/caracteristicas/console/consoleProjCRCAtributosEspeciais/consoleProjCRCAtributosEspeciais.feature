#language: pt
@consoleProjCRCAtributosEspeciais
Funcionalidade: Criacao de atributos especiais de objeto e de lista pelo console

  Contexto: Projeto com a entidade Cliente e seus atributos gerados pelo FluxoConsoleObjetos

  Cenario: Criar os atributos clienteIndicou e clientesRelacionados na entidade Cliente pelo console
    Dado um projeto com a entidade Cliente criada pelo console de objetos
    E a entidade Cliente ainda nao possui os atributos clienteIndicou e clientesRelacionados
    Quando o usuario digita Cliente seguido de ponto e clienteIndicou terminado em ponto
    Entao a opcao principal sugerida e criar o atributo clienteIndicou do tipo objeto
    E o item associado da opcao principal e um AtributoEntidadeEntidade
    Quando o usuario executa a criacao do atributo clienteIndicou
    Entao o atributo clienteIndicou fica salvo em Cliente como AtributoEntidadeEntidade
    E a entidade referenciada por clienteIndicou e Cliente
    Quando o usuario digita Cliente seguido de ponto e clientesRelacionados com apenas o colchete de abertura
    Entao o autocompletar sugere clientesRelacionados com o colchete de fechamento
    E o texto definido fica normatizado com os colchetes de abertura e fechamento
    Quando o usuario digita Cliente seguido de ponto e clientesRelacionados terminado em colchetes
    Entao a opcao principal sugerida e criar o atributo clientesRelacionados do tipo lista
    E o item associado da opcao principal e um AtrubutoEntidadeLista
    Quando o usuario executa a criacao do atributo clientesRelacionados
    Entao o atributo clientesRelacionados fica salvo em Cliente como AtrubutoEntidadeLista
    E a entidade dos itens da lista clientesRelacionados e Cliente
