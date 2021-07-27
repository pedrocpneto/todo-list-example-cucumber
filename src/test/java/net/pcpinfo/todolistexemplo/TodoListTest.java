package net.pcpinfo.todolistexemplo;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.mockito.internal.exceptions.util.ScenarioPrinter;

public class TodoListTest extends ScenarioPrinter {

    @Dado("que não há tarefa salva no sistema")
    public void queNãoHáTarefaSalvaNoSistema() {

    }

    @Quando("eu buscar a lista de tarefas")
    public void euBuscarAListaDeTarefas() {
    }

    @Então("o sistema devolverá uma lista vazia")
    public void oSistemaDevolveráUmaListaVazia() {
    }
}
