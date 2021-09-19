package com.exatechye.demoapi.repository;

import com.exatechye.demoapi.model.GroupContact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupContactRepository extends CrudRepository<GroupContact,Long> {

    @Query(value = "select * from group_contacts where group_id=:groupId",nativeQuery = true)
    List<GroupContact> findByGroupId(@Param("groupId") Long groupId);

}
