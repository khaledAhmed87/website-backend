package com.exatechye.demoapi.controller;

import com.exatechye.demoapi.exceptions.ContactException;
import com.exatechye.demoapi.model.Contact;
import com.exatechye.demoapi.repository.ContactRepository;
import com.exatechye.demoapi.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@CrossOrigin()
@RestController
public class ContactController {


    @Autowired
    ContactService contactService;



    @GetMapping("/contacts")
    public List<Contact> contact() {
        log.info("Show all contacts");

        return contactService.findAll();
    }
    public GetName nameContact(){
        return nameContact();
    }


    @PostMapping("/contacts")
    public ResponseEntity CreateNEwContact(@RequestBody Contact myContact)  {
        log.info("Create new contact");


        try {
            Contact contact=  contactService.createNewContact(myContact);
            return new ResponseEntity(contact, HttpStatus.OK);
        }
        catch (ContactException e) {

            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_GATEWAY);

        }


    }

    @PutMapping("/contacts")

    public ResponseEntity editContact(@RequestBody Contact myContact) {

        return new ResponseEntity(contactService.updateContact(myContact), HttpStatus.OK);

    }

    @DeleteMapping("/contacts")
    public ResponseEntity DeleteContact(@RequestBody Contact myContact) {

        this.contactService.deleteContact(myContact.getName());
        return new ResponseEntity( HttpStatus.OK);
    }
}
