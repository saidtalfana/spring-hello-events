package com.spring.Hello_Events.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "events")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column()
    private String name;

    @Column()
    private String description;

    @Column()
    private String location;

    @Column()
    private String category;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column()
    private Date date;

    @Column()
    private Double price;

    @OneToMany(mappedBy = "event")
    private Set<Reservations> reservations = new HashSet<>();


//    @ManyToOne
//    @JoinColumn(name="user_id")
//    private User user;
}
