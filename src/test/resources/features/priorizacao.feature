# language: pt
Funcionalidade: Priorização de Tarefas
  Permitir que as tarefas sejam devolvidas de forma priorizada

  Delineação do Cenário: Tarefa ordenada com prioridade <prioridade>
    Dado que eu tenho as seguintes tarefas inseridas anteriormente:
      | prioridade | titulo                       | observacao            |
      | BAIXA      | tarefa antiga desnecessaria  | uma tarefa antiga     |
      | MEDIA      | tarefa antiga normal         | uma tarefa normal     |
      | ALTA       | tarefa antiga importante     | uma tarefa importante |
    Quando eu inserir uma tarefa com o título "<titulo>", observação "<observacao>" e prioridade "<prioridade>"
    E eu buscar a lista de tarefas
    Então o sistema devolverá uma lista com 4 itens
    E na posição <posicao> está o item com título "<titulo>" e observação "<observacao>"
    Exemplos:
      | prioridade | titulo                    | observacao         | posicao |
      | BAIXA      | Uma tarefa não importante | Isso é um teste    | 4       |
      | MEDIA      | Uma tarefa mais ou menos  | Isso é outro teste | 3       |
      | ALTA       | Tarefa urgente            | Ainda outro teste  | 2       |