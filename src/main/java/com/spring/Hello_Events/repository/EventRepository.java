package com.spring.Hello_Events.repository;
import com.spring.Hello_Events.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findByDate(Date date);
    List<Event> findByLocation(String location);
    List<Event> findByCategory(String category);
    List<Event> findByDateAndLocation(Date date, String location);
    List<Event> findByDateAndCategory(Date date, String category);
    List<Event> findByLocationAndCategory(String location, String category);
    List<Event> findByDateAndLocationAndCategory(Date date, String location, String category);
}
