package com.project.schedule_official.task.event;

import com.project.schedule_official.task.Task;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "events")
@Table(name = "events")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AttributeOverrides(value = {

        @AttributeOverride(name = "title", column = @Column(name = "title")),
        @AttributeOverride(name = "priority", column = @Column(name = "priority")),
        @AttributeOverride(name = "user_id", column = @Column(name = "user_id"))

})
public class Event extends Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @Column(name = "event_id")
    private Integer eventId;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;
}

