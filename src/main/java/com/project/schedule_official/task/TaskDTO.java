package com.project.schedule_official.task;

import com.project.schedule_official.task.enums.CategoryEnum;
import com.project.schedule_official.task.event.Event;
import com.project.schedule_official.task.todo.ToDo;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TaskDTO {

    private Integer eventId;

    private String title;

    private CategoryEnum category;

    private boolean priority;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer userId;

    public static TaskDTO ofEvent(Event event) {
        return TaskDTO.builder()
                .title(event.getTitle())
                .category(event.getCategoryEnum())
                .priority(event.isPriority())
                .startDate(event.getStartDate())
                .endDate(event.getEndDate())
                .userId(event.getUser().getUserId())
                .build();
    }

    private Integer toDoId;

    public static TaskDTO ofToDo(ToDo toDo) {
        return TaskDTO.builder()
                .toDoId(toDo.getToDoId())
                .title(toDo.getTitle())
                .category(toDo.getCategoryEnum())
                .priority(toDo.isPriority())
                .userId(toDo.getUser().getUserId())
                .build();
    }

    public static TaskDTO ofBoth(Event event, ToDo toDo) {
        return TaskDTO.builder()
                .title(event.getTitle())
                .category(event.getCategoryEnum())
                .priority(event.isPriority())
                .startDate(event.getStartDate())
                .endDate(event.getEndDate())
                .userId(event.getUser().getUserId())
                .toDoId(toDo.getToDoId())
                .title(toDo.getTitle())
                .category(toDo.getCategoryEnum())
                .priority(toDo.isPriority())
                .userId(toDo.getUser().getUserId())
                .build();
    }

    public static TaskDTO ofBoth(Task task) {
        if (task instanceof Event event) {
            return TaskDTO.builder()
                    .title(event.getTitle())
                    .category(event.getCategoryEnum())
                    .priority(event.isPriority())
                    .startDate(event.getStartDate())
                    .endDate(event.getEndDate())
                    .userId(event.getUser().getUserId())
                    .build();
        } else if (task instanceof ToDo toDo) {
            return TaskDTO.builder()
                    .toDoId(toDo.getToDoId())
                    .title(toDo.getTitle())
                    .category(toDo.getCategoryEnum())
                    .priority(toDo.isPriority())
                    .userId(toDo.getUser().getUserId())
                    .build();
        }
        return null;
    }

}