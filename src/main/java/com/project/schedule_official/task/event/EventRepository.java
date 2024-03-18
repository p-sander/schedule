package com.project.schedule_official.task.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> findByUserId(@Param("userId") Integer userId);

    Optional<Event> findById(Integer id);

}