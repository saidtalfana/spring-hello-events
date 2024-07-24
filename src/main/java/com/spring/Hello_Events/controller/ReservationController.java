package com.spring.Hello_Events.controller;

import com.spring.Hello_Events.model.Reservations;
import com.spring.Hello_Events.model.User;
import com.spring.Hello_Events.service.ReservationService;
import com.spring.Hello_Events.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Reservations addReservation(@RequestBody Reservations reservation) {
        return reservationService.addReservation(reservation);
    }

    @GetMapping("/get_user_reservation")
    public List<Reservations> getUserReservations() {
        return reservationService.getUserReservations();
    }

    @GetMapping("/get_all")
    public List<Reservations> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable Integer id) {
        reservationService.deleteReservation(id);
    }
}
