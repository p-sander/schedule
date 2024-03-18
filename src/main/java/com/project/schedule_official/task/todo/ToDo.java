package com.project.schedule_official.task.todo;

import com.project.schedule_official.task.Task;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "todos")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@AttributeOverrides({

        @AttributeOverride(name = "title", column = @Column(name = "title")),
        @AttributeOverride(name = "categoryEnum", column = @Column(name = "category")),
        @AttributeOverride(name = "priority", column = @Column(name = "priority")),
        @AttributeOverride(name = "user_id", column = @Column(name = "user_id"))

})
public class ToDo extends Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Id
    private Integer toDoId;


}
