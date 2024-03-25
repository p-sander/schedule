package com.project.schedule_official.task.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

    List<ToDo> findByUserId(@Param("userId") Integer userId);

    Optional<ToDo> findById(Integer id);

}