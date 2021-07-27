package net.pcpinfo.todolistexemplo.todo;

import lombok.Value;

@Value
public class Todo {
    Long id;
    String title;
    String observation;
}
