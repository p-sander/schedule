package com.project.schedule_official.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping()
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public void addNewTask(@RequestBody TaskDTO taskDTO) {
        taskService.createNewTask(taskDTO);
    }

    @GetMapping("/allToDos")
    public List<TaskDTO> getAllToDos() {
        return taskService.findAllToDos().stream().map(TaskDTO::ofToDo).collect(Collectors.toList());
    }

    @GetMapping("/allEvents")
    public List<TaskDTO> getAllEvents() {
        return taskService.findAllEvents().stream().map(TaskDTO::ofEvent).collect(Collectors.toList());
    }
}
