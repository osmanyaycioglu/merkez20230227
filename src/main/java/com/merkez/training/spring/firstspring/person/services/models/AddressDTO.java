package com.merkez.training.spring.firstspring.person.services.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "person_address")
public class AddressDTO {
    @Id
    @GeneratedValue
    private Long addId;
    @NotNull
    @NotEmpty
    @Size(min = 2,max = 18)
    private String city;
    @NotNull
    @NotEmpty
    private String street;
}
