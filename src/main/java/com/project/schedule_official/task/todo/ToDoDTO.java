package com.project.schedule_official.task.todo;

import com.project.schedule_official.task.enums.CategoryEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ToDoDTO {

    private Integer toDoId;

    @NotBlank(message = "ToDo title can't be empty")
    @NotNull(message = "ToDo title can't be null")
    private String title;

    @NotBlank(message = "ToDo category can't be empty")
    @NotNull(message = "ToDo category can't be null")
    private CategoryEnum category;

    @NotBlank(message = "ToDo priority can't be empty")
    @NotNull(message = "ToDo priority can't be null")
    private boolean priority;

    private Integer userId;

    public static ToDoDTO ofToDo(ToDo toDo) {
        return ToDoDTO.builder()
                .toDoId(toDo.getToDoId())
                .title(toDo.getTitle())
                .category(toDo.getCategoryEnum())
                .priority(toDo.isPriority())
                .userId(toDo.getUser().getUserId())
                .build();
    }

}
