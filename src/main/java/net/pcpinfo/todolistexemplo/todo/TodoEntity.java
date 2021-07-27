package net.pcpinfo.todolistexemplo.todo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "todo")
@Getter
@Setter
@ToString
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;
    String title;
    String observation;
}
