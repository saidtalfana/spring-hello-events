package com.spring.Hello_Events.service;

import com.spring.Hello_Events.model.Event;
import com.spring.Hello_Events.model.Reservations;
import com.spring.Hello_Events.model.User;
import com.spring.Hello_Events.repository.EventRepository;
import com.spring.Hello_Events.repository.ReservationRepository;
import com.spring.Hello_Events.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private EventRepository eventRepository;

    public Reservations addReservation(Reservations reservation,int event_id , int user_id) {
        User  user = userRepository.findById(user_id).get();
        reservation.setUser(user);
        Event  event = eventRepository.findById(event_id).get();
        reservation.setEvent(event);
        return reservationRepository.save(reservation);
    }

    public List<Reservations> getAllReservations() {
            return reservationRepository.findAll();
    }
}
