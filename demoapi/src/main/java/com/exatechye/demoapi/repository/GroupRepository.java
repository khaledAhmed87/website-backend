package com.exatechye.demoapi.repository;

import com.exatechye.demoapi.model.Group;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends CrudRepository<Group,Long> {

  @Query(value = "select * from sms_groups ",nativeQuery = true)
  List<Group>  findAll();

}
