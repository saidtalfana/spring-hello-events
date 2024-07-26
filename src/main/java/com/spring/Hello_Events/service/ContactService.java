package com.spring.Hello_Events.service;

import com.spring.Hello_Events.model.Contact;
import com.spring.Hello_Events.model.User;
import com.spring.Hello_Events.repository.ContactRepository;
import com.spring.Hello_Events.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserService userService;

    public Contact addContact(Contact contact, Integer user_id) {
        User user1 = userService.findById(user_id);
        contact.setUser(user1);
        return contactRepository.save(contact);
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public List<Contact> getContactByIdUserId(Integer user_id) {
        return contactRepository.findContactsByUserId(user_id);
    }
}
