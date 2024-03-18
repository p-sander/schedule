package com.project.schedule_official.task.event;

import com.project.schedule_official.task.enums.CategoryEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EventDTO {

    private Integer eventId;

    @NotBlank(message = "Event title can't be empty")
    @NotNull(message = "Event title can't be null")
    private String title;

    @NotBlank(message = "Event category can't be empty")
    @NotNull(message = "Event category can't be null")
    private CategoryEnum category;

    @NotBlank(message = "Event priority can't be empty")
    @NotNull(message = "Event priority can't be null")
    private boolean priority;

    @NotNull(message = "Start date can't be null")
    private LocalDateTime startDate;

    @NotNull(message = "End date can't be null")
    private LocalDateTime endDate;

    private Integer userId;

    public static EventDTO ofEvent(Event event) {
        return EventDTO.builder()
                .title(event.getTitle())
                .category(event.getCategoryEnum())
                .priority(event.isPriority())
                .startDate(event.getStartDate())
                .endDate(event.getEndDate())
                .userId(event.getUser().getUserId())
                .build();
    }
}