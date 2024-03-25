package com.project.schedule_official.task.todo;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @PostMapping
    public ToDo addNewToDo(@RequestBody ToDoDTO toDoDTO) {
        return toDoService.createNewToDo(toDoDTO);
    }

    @GetMapping("/{userId}")
    public List<ToDoDTO> findByUserId(@PathParam("userId") Integer userId) {
        return toDoService.findByUserId(userId).stream()
                .map(ToDoDTO::ofToDo)
                .collect(Collectors.toList());
    }
}

