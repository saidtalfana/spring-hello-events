package com.spring.Hello_Events.controller;

import com.spring.Hello_Events.model.Reservations;
import com.spring.Hello_Events.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/add_reservation/{event_id}/{user_id}")
    public Reservations addReservation(Reservations reservation, @PathVariable int event_id,@PathVariable int user_id) {
        return reservationService.addReservation(reservation, event_id,user_id);
    }

    @GetMapping("all_reservation")
    public List<Reservations> getAllReservations() {
        return reservationService.getAllReservations();
    }
}
