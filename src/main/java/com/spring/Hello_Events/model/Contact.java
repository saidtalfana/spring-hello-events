package com.spring.Hello_Events.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contacts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column()
    private String message;

    @Column()
    private LocalDateTime contactDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
