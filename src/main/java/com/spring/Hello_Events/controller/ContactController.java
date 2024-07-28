package com.spring.Hello_Events.controller;

import com.spring.Hello_Events.model.Contact;
import com.spring.Hello_Events.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/add/{id}")
    public Contact addContact(@RequestBody Contact contact, @PathVariable int id) {
        return contactService.addContact(contact, id);
    }

    @GetMapping("/get_all")
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/get/{id}")
    public List<Contact> getContact(@PathVariable int id) {
        return contactService.getContactByIdUserId(id);
    }
}
