package com.spring.Hello_Events.repository;
import com.spring.Hello_Events.model.Contact;
import com.spring.Hello_Events.model.Reservations;
import com.spring.Hello_Events.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservations , Integer> {
    List<Reservations> findByUser(User user);
}
