package com.exatechye.demoapi.service;


import com.exatechye.demoapi.exceptions.ContactException;
import com.exatechye.demoapi.model.Contact;
import com.exatechye.demoapi.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class ContactService {


    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ValidationService validationService;

    private LocalDate dateTime;

    public List<Contact> findAll() {

        return contactRepository.findAll();
    }

    public Contact findById(Long id) {
        return contactRepository.findById(id).orElse(new Contact());
    }

    public List<Contact> findAllByName(String name) {

        return contactRepository.findAllByName(name);
    }
    public Contact findByName(String name) {

        return contactRepository.findByName(name);
    }

    public Contact createNewContact(Contact contact) throws ContactException {
        contact.datetime = LocalDateTime.now();


        this.validationService.checkContactCreation(contact);

        contact.setId(null);


        return contactRepository.save(contact);
    }

    public Contact updateContact(Contact contact) {
        contact.datetime = LocalDateTime.now();

        if (contact.getId() == null)
            return new Contact();


        return contactRepository.save(contact);
    }

    public void deleteContact(String name) {

        Contact contact = findByName(name);

        if (contact.getName() == null)
            return;

        contactRepository.delete(contact);
    }



}
