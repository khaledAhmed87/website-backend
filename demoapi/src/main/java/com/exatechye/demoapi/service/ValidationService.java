package com.exatechye.demoapi.service;


import com.exatechye.demoapi.exceptions.ContactException;
import com.exatechye.demoapi.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidationService {

    @Autowired
    private ContactService contactService;

    public void checkContactCreation(Contact contact) throws ContactException {

        if (contact == null)
            throw new ContactException("contact is null");

        if (contact.getName() == null || contact.getName().equals(""))
            throw new ContactException("name must not be empty");

        List<Contact> contactAvalible = this.contactService.findAllByName(contact.getName());


        if (contactAvalible.size() > 0)
            throw new ContactException("this name is already token");

        if (!(isNotYemenProvider(contact, "73") || isNotYemenProvider(contact, "77") || isNotYemenProvider(contact, "71"))) {
            throw new ContactException("The number must start with '73 or 77 or 71' ");

        }



    }

    private boolean isNotYemenProvider(Contact contact, String s) {
        return contact.getPhone().startsWith(s);
    }


}
