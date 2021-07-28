package net.pcpinfo.todolistexemplo.todo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.*;

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

    @Column(name = "priority")
    @Getter(NONE)
    @Setter(NONE)
    int priorityValue;

    @Transient
    PriorityEnum priority;

    @PostLoad
    void fillTransient() {
        priority = PriorityEnum.fromValue(priorityValue);
    }

    @PrePersist
    void fillPersistent() {
        priorityValue = priority.value;
    }
}
