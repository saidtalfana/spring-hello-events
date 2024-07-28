package com.spring.Hello_Events.service;

import com.spring.Hello_Events.model.Event;
import com.spring.Hello_Events.model.Reservations;
import com.spring.Hello_Events.model.User;
import com.spring.Hello_Events.repository.EventRepository;
import com.spring.Hello_Events.repository.ReservationRepository;
import com.spring.Hello_Events.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private EventRepository eventRepository;

    public Reservations addReservation(Reservations reservation) {

        Event event = eventRepository.findById(reservation.getEvent().getId()).orElseThrow();
        reservation.setEvent(event);

        User user = userRepository.findById(reservation.getUser().getId()).orElseThrow();
        reservation.setUser(user);

        reservation.setReservationDate(new Date());
        return reservationRepository.save(reservation);
    }

    public List<Reservations> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservations> getUserReservations() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);

        return reservationRepository.findByUser(user);
    }

    public void deleteReservation(Integer id) {
        reservationRepository.deleteById(id);
    }

}
