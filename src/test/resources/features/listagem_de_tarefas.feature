# language: pt
Funcionalidade: Listagem de Tarefas
  Manipulação da listagem de tarefas
  Permite a consulta, inserção, edição e remoção de tarefas para o usuário

  Cenário: Lista de tarefas vazia
    Dado que não há tarefa salva no sistema
    Quando eu buscar a lista de tarefas
    Então o sistema devolverá uma lista vazia

  Cenário: Inserir uma nova tarefa
    Dado que não há tarefa salva no sistema
    Quando eu inserir uma tarefa com o título "Teste 1" e observação "Teste"
    E eu buscar a lista de tarefas
    Então o sistema devolverá uma lista com um item cujo título é "Teste 1" e observação "Teste"
