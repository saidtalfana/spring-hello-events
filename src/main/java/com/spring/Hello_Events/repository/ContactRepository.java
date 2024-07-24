package com.spring.Hello_Events.repository;
import com.spring.Hello_Events.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

@Query(value = "select * from Contact where user_id=?" , nativeQuery = true)
    public List<Contact> findAllContactByUserId(int user_id);
}
