package com.spring.Hello_Events.service;

import com.spring.Hello_Events.model.User;
import com.spring.Hello_Events.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }
    public User updateUser(User user){
        return userRepository.save(user);
    }
}
