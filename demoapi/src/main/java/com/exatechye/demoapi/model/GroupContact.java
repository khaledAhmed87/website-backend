package com.exatechye.demoapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "group_contacts")
public class GroupContact {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "group_contacts_id" )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "group_id")
    private Group group;

}
