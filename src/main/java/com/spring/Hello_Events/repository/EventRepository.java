package com.spring.Hello_Events.repository;
import com.spring.Hello_Events.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
