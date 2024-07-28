package com.spring.Hello_Events.controller;

import com.spring.Hello_Events.config.JwtAuth;
import com.spring.Hello_Events.dto.JwtDto;
import com.spring.Hello_Events.model.User;
import com.spring.Hello_Events.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;


    @PostMapping("/signup")
    public String addUser(@RequestBody User user) {
        userService.save(user);
        return "The account has been successfully created";
    }


    @PostMapping("/login")
    public JwtDto login(@RequestBody User requestLogin) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestLogin.getUsername(), requestLogin.getPassword())
        );
        User user = userService.findByUsername(requestLogin.getUsername());
        Set<String> roles = user.getRoles().stream()
                .map(role -> role.name())
                .collect(Collectors.toSet());

        String token = JwtAuth.generateToken(requestLogin.getUsername(), roles);
        return new JwtDto(token);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        userService.deleteById(id);
        return "The account has been deleted :";
    }

}
