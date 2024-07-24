package com.spring.Hello_Events.service;

import com.spring.Hello_Events.model.Event;
import com.spring.Hello_Events.model.User;
import com.spring.Hello_Events.repository.EventRepository;
import com.spring.Hello_Events.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository UserRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event save(Event event ,int user_id) {
        User user= UserRepository.findById(user_id).get();
        event.setUser(user);
        return eventRepository.save(event);
    }

    public Event getEventById(int id) {
        return eventRepository.findById(id).get();
    }
}
