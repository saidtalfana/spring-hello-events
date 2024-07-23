package com.spring.Hello_Events.repository;
import com.spring.Hello_Events.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
