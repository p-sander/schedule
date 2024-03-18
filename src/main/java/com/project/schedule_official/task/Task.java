package com.project.schedule_official.task;

import com.project.schedule_official.task.enums.CategoryEnum;
import com.project.schedule_official.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Task {

    private String title;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private CategoryEnum categoryEnum;

    private boolean priority;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

}