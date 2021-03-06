package net.pcpinfo.todolistexemplo.todo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TodoMapper {

    Todo.Response.Default toDefaultResponse(TodoEntity todo);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "priority", defaultValue = "MEDIUM")
    TodoEntity toEntity(Todo.Request.Create todoCreate);
}
