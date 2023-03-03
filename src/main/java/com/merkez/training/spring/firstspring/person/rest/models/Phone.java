package com.merkez.training.spring.firstspring.person.rest.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Phone {
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String number;
}
