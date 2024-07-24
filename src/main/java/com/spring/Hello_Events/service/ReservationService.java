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

    public Reservations updateReservation(Integer id, Reservations updatedReservation) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String role = authentication.getAuthorities().stream()
                .map(authority -> authority.getAuthority())
                .findFirst().orElse("");

        Reservations existingReservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found"));

        if (!role.equals("ROLE_ADMIN") && !existingReservation.getUser().getUsername().equals(authentication.getName())) {
            throw new AccessDeniedException("You do not have permission to update this reservation");
        }

        existingReservation.setNumberOfTickets(updatedReservation.getNumberOfTickets());
        existingReservation.setReservationDate(updatedReservation.getReservationDate());
        return reservationRepository.save(existingReservation);
    }
}
