//package com.spring.Hello_Events;
//
//import com.spring.Hello_Events.enums.Role;
//import com.spring.Hello_Events.model.User;
//import com.spring.Hello_Events.repository.UserRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.Collections;
//
//@DataJpaTest
//public class UserRepositoryTest {
//    @Autowired
//    private UserRepository userRepository;
//    @Test
//    public void addUser() {
//  User user = User.builder()
//          .username("said")
//          .password("132435")
//          .email("saidtalfana@gmail")
//          .phoneNumber("0643667687")
//          .roles(Collections.singleton(Role.ROLE_USER))
//          .build();
//
//  userRepository.save(user);
//    }
//
//    @Test
//    public void getUserById() {
//        User user = userRepository.findByUsername("saidalafana");
//        Assertions.assertNotNull(user);
//    }
//
//
//}
