package com.merkez.training.spring.firstspring.person.services.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "person_address")
public class AddressDTO {
    @Id
    @GeneratedValue
    private Long addId;
    private String city;
    private String street;
}
