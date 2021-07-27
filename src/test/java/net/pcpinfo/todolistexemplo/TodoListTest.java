package net.pcpinfo.todolistexemplo;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import net.pcpinfo.todolistexemplo.todo.Todo;
import net.pcpinfo.todolistexemplo.todo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

public class TodoListTest extends SpringIntegrationTest {

    @Autowired
    private TodoRepository todoRepository;

    private List<Todo> todoList;

    @Dado("que não há tarefa salva no sistema")
    public void queNãoHáTarefaSalvaNoSistema() {
        todoRepository.deleteAll();
    }

    @Quando("eu buscar a lista de tarefas")
    public void euBuscarAListaDeTarefas() {
        todoList = todoRepository.findAll();
    }

    @Então("o sistema devolverá uma lista vazia")
    public void oSistemaDevolveráUmaListaVazia() {
        Assert.notNull(todoList, "todo list is null");
        Assert.isTrue(todoList.isEmpty(), "todo list is not empty");
    }
}
