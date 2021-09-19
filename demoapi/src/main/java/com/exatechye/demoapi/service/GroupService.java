package com.exatechye.demoapi.service;

import com.exatechye.demoapi.model.Group;
import com.exatechye.demoapi.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {


    @Autowired
    private GroupRepository groupRepository;


    public List<Group> findAll(){
        return  this.groupRepository.findAll();
    }

    public Group findOneById(Long id){
        return this.groupRepository.findById(id).orElse(new Group());
    }

    public Group updateGroup(Group group){


        return this.groupRepository.save(group);

    }

    public void deleteGroup(Long id){

        this.groupRepository.deleteById(id);
    }

    public Group createGroup(Group group) {

        return  groupRepository.save(group);
    }
}
