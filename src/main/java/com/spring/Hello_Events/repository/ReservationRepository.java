package com.spring.Hello_Events.repository;
import com.spring.Hello_Events.model.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservations , Integer> {
}
