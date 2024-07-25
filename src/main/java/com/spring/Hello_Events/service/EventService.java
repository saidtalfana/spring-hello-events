package com.spring.Hello_Events.service;

import com.spring.Hello_Events.model.Event;
import com.spring.Hello_Events.model.User;
import com.spring.Hello_Events.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserService userService;

    public Event save(Event event) {
//        User user = userService.findById(5);
//        event.setUser(user);
        return eventRepository.save(event);
    }

    public Event findById(int id) {
        return eventRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Event not found"));
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public void deleteById(int id) {
        eventRepository.deleteById(id);
    }

    public Event updateEvent(Integer id, Event event) {

        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        existingEvent.setName(event.getName());
        existingEvent.setDescription(event.getDescription());
        existingEvent.setLocation(event.getLocation());
        existingEvent.setStartTime(event.getStartTime());
        existingEvent.setDate(event.getDate());
        existingEvent.setPrice(event.getPrice());


        return eventRepository.save(existingEvent);
    }

    public List<Event> searchEvents(Date date, String location, String category) {
        if (date != null && location != null && category != null) {
            return eventRepository.findByDateAndLocationAndCategory(date, location, category);
        } else if (date != null && location != null) {
            return eventRepository.findByDateAndLocation(date, location);
        } else if (date != null && category != null) {
            return eventRepository.findByDateAndCategory(date, category);
        } else if (location != null && category != null) {
            return eventRepository.findByLocationAndCategory(location, category);
        } else if (date != null) {
            return eventRepository.findByDate(date);
        } else if (location != null) {
            return eventRepository.findByLocation(location);
        } else if (category != null) {
            return eventRepository.findByCategory(category);
        } else {
            return eventRepository.findAll();
        }
    }

}
