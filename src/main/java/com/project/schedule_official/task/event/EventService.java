package com.project.schedule_official.task.event;

import com.project.schedule_official.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    public Event createNewEvent(EventDTO eventDTO) {

        Event event = new Event();
        event.setTitle(eventDTO.getTitle());
        event.setStartDate(eventDTO.getStartDate());
        event.setEndDate(eventDTO.getEndDate());
        event.setCategoryEnum(eventDTO.getCategory());
        event.setPriority(eventDTO.isPriority());

        try {
            event.setUser(userRepository.findByUserId(eventDTO.getUserId()));
        } catch (RuntimeException e) {
            throw new RuntimeException("User not found in database");
        }
        return eventRepository.save(event);
    }

    public List<Event> findByUserId(Integer userId) {
        return eventRepository.findByUserId(userId);
    }

    public Optional<Event> findById(Integer id) {
        return eventRepository.findById(id);
    }

}
