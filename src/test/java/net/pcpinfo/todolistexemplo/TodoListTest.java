package net.pcpinfo.todolistexemplo;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import net.pcpinfo.todolistexemplo.todo.PriorityEnum;
import net.pcpinfo.todolistexemplo.todo.Todo;
import net.pcpinfo.todolistexemplo.todo.TodoRepository;
import net.pcpinfo.todolistexemplo.todo.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

public class TodoListTest extends SpringIntegrationTest {

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TodoService todoService;

    private List<Todo.Response.Default> todoList;

    @Dado("que não há tarefa salva no sistema")
    public void queNãoHáTarefaSalvaNoSistema() {
        todoRepository.deleteAll();
    }

    @Quando("eu buscar a lista de tarefas")
    public void euBuscarAListaDeTarefas() {
        todoList = todoService.findAll();
    }

    @Então("o sistema devolverá uma lista vazia")
    public void oSistemaDevolveráUmaListaVazia() {
        Assert.notNull(todoList, "todo list is null");
        Assert.isTrue(todoList.isEmpty(), "todo list is not empty");
    }

    @Quando("eu inserir uma tarefa com o título {string} e observação {string}")
    public void euInserirUmaTarefaComOTítuloEObservação(String titulo, String observacao) {
         euInserirUmaTarefaComOTítuloObservaçãoEPrioridade(titulo, observacao, null);
    }

    @Então("o sistema devolverá uma lista com um item cujo título é {string} e observação {string}")
    public void oSistemaDevolveráUmaListaComUmItemCujoTítuloÉEObservação(String titulo, String observacao) {
        Assert.notNull(todoList, "todo list is null");
        Assert.notEmpty(todoList, "todo list is empty");
        Assert.isTrue(titulo.equals(todoList.get(0).getTitle()), "titulo diferente");
        Assert.isTrue(observacao.equals(todoList.get(0).getObservation()), "observacao diferente");
    }

    @Dado("que eu tenho as seguintes tarefas inseridas anteriormente:")
    public void queEuTenhoAsSeguintesTarefasInseridasAnteriormente(DataTable dataTable) {
        todoRepository.deleteAll();
        var tarefas = dataTable.<String, String>asMaps(String.class, String.class);
        for (var tarefa : tarefas) {
            var priority = PriorityEnum.fromName(tarefa.get("prioridade"));
            var todo = Todo.Request.Create.with()
                    .title(tarefa.get("titulo"))
                    .observation(tarefa.get("observacao"))
                    .priority(priority)
                    .build();
            todoService.create(todo);
        }
    }

    @Quando("eu inserir uma tarefa com o título {string}, observação {string} e prioridade {string}")
    public void euInserirUmaTarefaComOTítuloObservaçãoEPrioridade(String titulo, String observacao, String prioridade) {
        var todo = Todo.Request.Create.with()
                .title(titulo)
                .observation(observacao)
                .priority(PriorityEnum.fromName(prioridade))
                .build();
        todoService.create(todo);
    }

    @Então("o sistema devolverá uma lista com {int} itens")
    public void oSistemaDevolveráUmaListaComItens(int quantidade) {
        Assert.isTrue(quantidade == todoList.size(), "todo list deveria ter a quantidade de " + quantidade + " itens");
    }

    @E("na posição {int} está o item com título {string} e observação {string}")
    public void naPosiçãoPosicaoEstáOItemComTituloEObservacao(int posicao, String titulo, String observacao) {
        posicao--; // A lista começa com posição zero
        var todo = todoList.get(posicao);
        Assert.isTrue(titulo.equals(todo.getTitle()), "titulo");
        Assert.isTrue(observacao.equals(todo.getObservation()), "observacao");
    }
}
