package com.exatechye.demoapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@Data
@Entity
@Table(name = "sms_groups")
public class Group {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "group_id" )
    private Long id;

    @Column( name = "group_name" )
    private String name;

    @Column(name = "group_number")
    private Integer number;


    @OneToMany(mappedBy = "group")
    List<GroupContact> groupContactList;

    public Group(Long groupId) {

        this.id=groupId;
    }
}
