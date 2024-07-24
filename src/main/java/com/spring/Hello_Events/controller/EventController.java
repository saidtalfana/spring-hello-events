package com.spring.Hello_Events.controller;

import com.spring.Hello_Events.model.Event;
import com.spring.Hello_Events.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Event createEvent(@RequestBody Event event, @RequestParam int userId) {
        return eventService.save(event, userId);
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable int id) {
        return eventService.getEventById(id);
    }

    @GetMapping("/get_events")
    public List<Event> getEvents() {
        return eventService.getAllEvents();
    }
}

