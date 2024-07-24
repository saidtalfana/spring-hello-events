package com.spring.Hello_Events.controller;

import com.spring.Hello_Events.model.User;
import com.spring.Hello_Events.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

//    @PostMapping("/adduser")
//    public User addUser(@RequestBody User user){
//      return   userService.addUser(user);
//    }
//    @PutMapping("/updateu_ser/{id}")
//    public User updateUser(@RequestBody User user,@PathVariable int id){
//        user.setId(id);
//        return userService.updateUser(user);
//    }
}
