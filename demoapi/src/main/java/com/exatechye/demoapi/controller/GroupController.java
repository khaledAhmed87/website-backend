package com.exatechye.demoapi.controller;


import com.exatechye.demoapi.dto.AddContactToGroupDto;
import com.exatechye.demoapi.model.Group;
import com.exatechye.demoapi.model.GroupContact;
import com.exatechye.demoapi.service.GroupContactService;
import com.exatechye.demoapi.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin()
@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private GroupContactService groupContactService;

    @GetMapping("/groups")
    public ResponseEntity findAllGroup(){

        return new ResponseEntity(this.groupService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/groups/{id}")
    public ResponseEntity findOneGroup(@PathVariable("id")Long groupId){

        Group group= this.groupService.findOneById(groupId);

        return new ResponseEntity(group,HttpStatus.OK);

    }

    @PostMapping("/groups")
    public ResponseEntity createGroup(@RequestBody Group group){

      Group saveGroup=  this.groupService.createGroup(group);

      return new ResponseEntity(saveGroup,HttpStatus.OK);
    }

    @PostMapping("/groups/{id}")
    public ResponseEntity addContactsToGroup(@PathVariable("id")Long groupId,@RequestBody AddContactToGroupDto addContactToGroupDto){

        groupContactService.addListOfContact(addContactToGroupDto,groupId);




        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/groups/{id}/contacts")
    public ResponseEntity findAllContactGroups(@PathVariable("id")Long groupId){


        List<GroupContact> groupContactList= this.groupContactService.findByGroupId(groupId);

        return new ResponseEntity(groupContactList,HttpStatus.OK);
    }


}
