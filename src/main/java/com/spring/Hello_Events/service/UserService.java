package com.spring.Hello_Events.service;

import com.spring.Hello_Events.model.User;
import com.spring.Hello_Events.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;



     public User save(User user) {
         user.setPassword(passwordEncoder.encode(user.getPassword()));
         return userRepository.save(user);
     }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(int id) {
        return userRepository.findById(id).orElseThrow();
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public User update(Integer id , User user) {
        User User1 = userRepository.findById(id).orElseThrow();
        user.setId(User1.getId());
        user.setUsername(User1.getUsername());
        user.setPassword(User1.getPassword());
        user.setEmail(User1.getEmail());
        userRepository.save(user);
        return userRepository.save(User1);
    }
}
