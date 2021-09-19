package com.exatechye.demoapi.model;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table( name = "tutorials" )
public class Contact {


    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "contact_id" )
    private Long id;

    @Column( name = "ContactName" )
    private String name;

    @NotNull
    @Column( name = "phone_number" )
    private String phone;


    @LastModifiedDate
    @Column( name = "dateTime")
    public LocalDateTime datetime;

    public Contact(Long contactId) {

        this.id=contactId;
    }
}
