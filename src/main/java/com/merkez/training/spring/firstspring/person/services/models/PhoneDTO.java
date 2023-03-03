package com.merkez.training.spring.firstspring.person.services.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Getter
@Setter
@Entity
@SequenceGenerator(name = "phone_seq",sequenceName = "phone_seq",initialValue = 1,allocationSize = 1)
@Table(name = "phone")
public class PhoneDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "phone_seq")
    private Long phoneId;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String number;

    @ManyToOne
    private PersonDTO personDTO;
}
