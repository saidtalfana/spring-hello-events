//package com.spring.Hello_Events.controller;
//
//import com.spring.Hello_Events.model.Contact;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
// @RestController
// public class ContactService {
//
//    @Autowired
//    private ContactService contactService;
//
//  @PostMapping("/add_contact/{user_id}")
//  public Contact addContact(@RequestBody Contact contact, @PathVariable int user_id) {
//      return contactService.addContact(contact, user_id);
//  }
//
//    @GetMapping("/show_all_contact/{user_id}")
//    public List<Contact> showAllContact(@PathVariable("user_id") int user_id) {
//        return contactService.showAllContact(user_id);
//    }
//}
