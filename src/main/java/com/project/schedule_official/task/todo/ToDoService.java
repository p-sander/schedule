package com.project.schedule_official.task.todo;

import com.project.schedule_official.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private UserRepository userRepository;

    public ToDo createNewToDo(ToDoDTO toDoDTO) {
        ToDo toDo = new ToDo();
        toDo.setTitle(toDoDTO.getTitle());
        toDo.setCategoryEnum(toDoDTO.getCategory());
        toDo.setPriority(toDoDTO.isPriority());
        try {
            toDo.setUser(userRepository.findByUserId(toDoDTO.getUserId()));
        } catch (RuntimeException e) {
            throw new RuntimeException("User not found in database");
        }
        return toDoRepository.save(toDo);
    }

    public List<ToDo> findByUserId(Integer userId) {
        return toDoRepository.findByUserId(userId);
    }

    public Optional<ToDo> findById(Integer id) {
        return toDoRepository.findById(id);
    }

}
