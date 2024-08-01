package com.spring.Hello_Events.repository;

import com.spring.Hello_Events.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    @Query(value = "SELECT u.id from User u where u.username =:username")
    Integer getUserId(@Param("username") String username);
}
