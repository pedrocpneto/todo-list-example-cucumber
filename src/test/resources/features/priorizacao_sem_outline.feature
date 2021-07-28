# language: pt
Funcionalidade: Sem Scenário Outline - Priorização de Tarefas
  Permitir que as tarefas sejam devolvidas de forma priorizada

  Cenário: Tarefa ordenada com prioridade BAIXA
    Dado que eu tenho as seguintes tarefas inseridas anteriormente:
      | prioridade | titulo                       | observacao            |
      | BAIXA      | tarefa antiga desnecessaria  | uma tarefa antiga     |
      | MEDIA      | tarefa antiga normal         | uma tarefa normal     |
      | ALTA       | tarefa antiga importante     | uma tarefa importante |
    Quando eu inserir uma tarefa com o título "Uma tarefa não importante", observação "Isso é um teste" e prioridade "BAIXA"
    E eu buscar a lista de tarefas
    Então o sistema devolverá uma lista com 4 itens
    E na posição 4 está o item com título "Uma tarefa não importante" e observação "Isso é um teste"


  Cenário: Tarefa ordenada com prioridade MEDIA
    Dado que eu tenho as seguintes tarefas inseridas anteriormente:
      | prioridade | titulo                       | observacao            |
      | BAIXA      | tarefa antiga desnecessaria  | uma tarefa antiga     |
      | MEDIA      | tarefa antiga normal         | uma tarefa normal     |
      | ALTA       | tarefa antiga importante     | uma tarefa importante |
    Quando eu inserir uma tarefa com o título "Uma tarefa mais ou menos", observação "Isso é outro teste" e prioridade "MEDIA"
    E eu buscar a lista de tarefas
    Então o sistema devolverá uma lista com 4 itens
    E na posição 3 está o item com título "Uma tarefa mais ou menos" e observação "Isso é outro teste"


  Cenário: Tarefa ordenada com prioridade ALTA
    Dado que eu tenho as seguintes tarefas inseridas anteriormente:
      | prioridade | titulo                       | observacao            |
      | BAIXA      | tarefa antiga desnecessaria  | uma tarefa antiga     |
      | MEDIA      | tarefa antiga normal         | uma tarefa normal     |
      | ALTA       | tarefa antiga importante     | uma tarefa importante |
    Quando eu inserir uma tarefa com o título "Tarefa urgente", observação "Ainda outro teste" e prioridade "ALTA"
    E eu buscar a lista de tarefas
    Então o sistema devolverá uma lista com 4 itens
    E na posição 2 está o item com título "Tarefa urgente" e observação "Ainda outro teste"