package com.exatechye.demoapi.service;

import com.exatechye.demoapi.dto.AddContactToGroupDto;
import com.exatechye.demoapi.model.Contact;
import com.exatechye.demoapi.model.Group;
import com.exatechye.demoapi.model.GroupContact;
import com.exatechye.demoapi.repository.GroupContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupContactService {

    @Autowired
    private GroupContactRepository groupContactRepository;


    public void addListOfContact(AddContactToGroupDto addContactToGroupDto, Long groupId) {

        for (Long contactId:addContactToGroupDto.getIds()){
            GroupContact groupContact=new GroupContact();
            groupContact.setContact(new Contact(contactId));
            groupContact.setGroup(new Group(groupId));

            groupContactRepository.save(groupContact);

        }



    }

    public List<GroupContact> findByGroupId(Long groupId) {

        return this.groupContactRepository.findByGroupId(groupId);
    }
}
