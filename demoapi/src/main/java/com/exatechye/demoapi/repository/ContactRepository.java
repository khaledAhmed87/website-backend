package com.exatechye.demoapi.repository;

import com.exatechye.demoapi.model.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {

    @Query( value = "select * from tutorials", nativeQuery = true )
    List<Contact> findAll();


    @Query( value = "select * from tutorials where contact_name =:name", nativeQuery = true )
    List<Contact> findAllByName(@Param( "name" ) String name);

    @Query( value = "select * from tutorials where contact_name =:name", nativeQuery = true )
    Contact findByName(@Param( "name" ) String name);
}
