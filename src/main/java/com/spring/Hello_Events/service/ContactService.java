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
    private UserRepository userRepository;

    public Contact saveContact(Contact contact,int user_id) {
       User user1 = userRepository.findById(user_id).get();
       contact.setUser(user1);
        return contactRepository.save(contact);
    }


    public List<Contact> getAllContacts(int user_id) {
        return contactRepository.findAllContact(user_id);
    }
}
