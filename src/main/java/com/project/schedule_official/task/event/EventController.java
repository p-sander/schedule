package com.project.schedule_official.task.event;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public Event addEvent(@RequestBody EventDTO eventDTO) {
        return eventService.createNewEvent(eventDTO);
    }

    @GetMapping("/all")
    public List<Event> getAllEvents(@PathParam("userId") Integer userId) {
        return eventService.findByUserId(userId);
    }
}