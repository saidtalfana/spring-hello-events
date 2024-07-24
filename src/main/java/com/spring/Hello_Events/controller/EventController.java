package com.spring.Hello_Events.controller;

import com.spring.Hello_Events.model.Event;
import com.spring.Hello_Events.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping("/add_event/{user_id}")
    public Event addEvent(@RequestBody Event event, @PathVariable int user_id) {
        return eventService.save(event,user_id);
    }

    @GetMapping("/get_events")
    public List<Event> getEvents() {
        return eventService.getAllEvents();
    }

}
