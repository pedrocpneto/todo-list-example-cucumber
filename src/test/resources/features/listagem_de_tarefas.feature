# language: pt
Funcionalidade: Listagem de Tarefas
  Manipulação da listagem de tarefas

  Cenário: Lista de tarefas vazia
    Dado que não há tarefa salva no sistema
    Quando eu buscar a lista de tarefas
    Então o sistema devolverá uma lista vazia