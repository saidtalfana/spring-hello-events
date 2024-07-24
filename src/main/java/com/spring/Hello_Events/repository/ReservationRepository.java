package com.spring.Hello_Events.repository;
import com.spring.Hello_Events.model.Contact;
import com.spring.Hello_Events.model.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservations , Integer> {

}
