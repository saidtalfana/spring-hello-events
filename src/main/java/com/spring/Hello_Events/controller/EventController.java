package com.spring.Hello_Events.controller;

import com.spring.Hello_Events.model.Event;
import com.spring.Hello_Events.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/get_all")
    public List<Event> getAllEvents() {
        return eventService.findAll();
    }

    @GetMapping("/get/{id}")
    public Event getEventById(@PathVariable int id) {
        return eventService.findById(id);
    }

    @PostMapping("/add")
    public Event createEvent(@RequestBody Event event) {
        return eventService.save(event);
    }

    @PutMapping("/update/{id}")
    public Event updateEvent(@PathVariable int id, @RequestBody Event event) {
        return eventService.updateEvent(id, event);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEvent(@PathVariable int id) {
        eventService.deleteById(id);
    }

    @GetMapping("/search")
    public List<Event> searchEvents(
            @RequestParam(required = false) Date date,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String category) {
        return eventService.searchEvents(date, location, category);
    }
}
