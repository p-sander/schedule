package com.project.schedule_official.task;


import com.project.schedule_official.task.event.Event;
import com.project.schedule_official.task.event.EventRepository;
import com.project.schedule_official.task.todo.ToDo;
import com.project.schedule_official.task.todo.ToDoRepository;
import com.project.schedule_official.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private UserRepository userRepository;

    public void createNewTask(TaskDTO taskDTO) {
        createNewEvent(taskDTO);
        createNewToDo(taskDTO);
    }

    public Event createNewEvent(TaskDTO taskDTO) {
        Event event = new Event();
        event.setTitle(taskDTO.getTitle());
        event.setStartDate(taskDTO.getStartDate());
        event.setEndDate(taskDTO.getEndDate());
        event.setCategoryEnum(taskDTO.getCategory());
        event.setPriority(taskDTO.isPriority());
        event.setUser(
                userRepository
                        .findById(taskDTO.getUserId())
                        .orElseThrow(() -> new RuntimeException("User not found in database")));

        return eventRepository.save(event);
    }

    public ToDo createNewToDo(TaskDTO taskDTO) {
        ToDo toDo = new ToDo();
        toDo.setTitle(taskDTO.getTitle());
        toDo.setCategoryEnum(taskDTO.getCategory());
        toDo.setPriority(taskDTO.isPriority());
        toDo.setUser(
                userRepository
                        .findById(taskDTO.getUserId())
                        .orElseThrow(() -> new RuntimeException("User not found in database")));
        return toDoRepository.save(toDo);
    }

    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    public List<ToDo> findAllToDos() {
        return toDoRepository.findAll();
    }
}
