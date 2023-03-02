package com.merkez.training.spring.firstspring.person.services.models;

import lombok.Data;

@Data
public class PersonDTO {
    private Long personId;
    private String firstName;
    private String lastName;
    private int age;
    private String username;
    private String password;
    private EPersonStatus personStatus;

}
