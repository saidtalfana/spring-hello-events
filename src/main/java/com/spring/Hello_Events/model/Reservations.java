package com.spring.Hello_Events.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "reservations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date reservationDate;

    @Column(nullable = false)
    private Integer numberOfTickets;

    public Reservations(Event event, User user, Date reservationDate, Integer numberOfTickets) {
        this.event = event;
        this.user = user;
        this.reservationDate = reservationDate;
        this.numberOfTickets = numberOfTickets;
    }
}
