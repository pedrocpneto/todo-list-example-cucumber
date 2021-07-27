package net.pcpinfo.todolistexemplo.todo;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Value
public class Todo {
    @Id
    Long id;
    String title;
    String observation;
}
