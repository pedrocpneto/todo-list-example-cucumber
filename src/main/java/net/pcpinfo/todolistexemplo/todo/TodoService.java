package net.pcpinfo.todolistexemplo.todo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TodoService {

    TodoRepository repository;
    TodoMapper mapper;

    public List<Todo.Response.Default> findAll() {
        return repository.findAllByOrderByPriorityValueDesc().stream().map(mapper::toDefaultResponse).collect(toList());
    }

    public void create(Todo.Request.Create todoCreate) {
        repository.save(mapper.toEntity(todoCreate));
    }

}
