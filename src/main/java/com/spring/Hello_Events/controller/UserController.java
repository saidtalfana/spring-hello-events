package com.spring.Hello_Events.controller;

import com.spring.Hello_Events.Config.JwtAuth;
import com.spring.Hello_Events.model.User;
import com.spring.Hello_Events.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/singup")
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }

}
