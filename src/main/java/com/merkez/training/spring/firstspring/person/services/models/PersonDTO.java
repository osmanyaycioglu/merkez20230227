package com.merkez.training.spring.firstspring.person.services.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "person")
public class PersonDTO {
    @Id
    @GeneratedValue
    private Long personId;
    private String firstName;
    private String lastName;
    private int age;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private EPersonStatus personStatus = EPersonStatus.ACTIVE;

}
