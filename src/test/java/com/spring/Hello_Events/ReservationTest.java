package com.spring.Hello_Events;

import com.spring.Hello_Events.model.Event;
import com.spring.Hello_Events.model.Reservations;
import com.spring.Hello_Events.model.User;
import com.spring.Hello_Events.service.EventService;
import com.spring.Hello_Events.service.ReservationService;
import com.spring.Hello_Events.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ReservationTest {
//    @Autowired
//    private ReservationService reservationService;
//    @Autowired
//    private EventService eventService;
//    @Autowired
//    private UserService userService;
//  @Test
//  public void reserveTest() throws ParseException {
//      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//      Date reservationDate = dateFormat.parse("22/06/2024");
//      Event event=eventService.findById(1);
//      User user=userService.findById(1);
//      Reservations reservation=new Reservations(event,user,reservationDate,2);
//      Reservations reservations=reservationService.addReservation(reservation);
//     assertNotNull(reservations.getId());
//      assertEquals(1,reservations.getEvent().getId());
//      assertEquals(1,reservations.getUser().getId());
//      assertEquals(2,reservations.getNumberOfTickets());
//
//    }
//
//    @Test
//    public void getReservationTest() {
//        List<Reservations> listR = reservationService.getAllReservations();
//        assertEquals(1, listR.get(0).getId());
//        assertEquals(2, listR.get(1).getId());
//        assertEquals(3, listR.get(2).getId());
//        assertEquals(4, listR.get(3).getId());
//        assertEquals(6, listR.get(4).getId());
//        assertEquals(7, listR.get(5).getId());
//    }
}
