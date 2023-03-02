package com.merkez.training.spring.firstspring.person.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.merkez.training.spring.firstspring.validation.ContainsStr;
import com.merkez.training.spring.firstspring.validation.StartWith;

import javax.validation.constraints.*;

// POJO
// DTO
// @Data
@ContainsStr({"deneme","ali","joe"})
public class Person {
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 3,max = 20,message = "firstName {min} ile {max} arasında olmalı")
    @ContainsStr({"abc","qwe","asd"})
    private String firstName;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 2,max = 25)
    private String lastName;
    @Min(10)
    @Max(100)
    private int age;
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 6,max = 20)
    @ContainsStr({"abc","qwe","asd"})
    @StartWith(xyz = {"us","ku"},count = 2)
    private String username;
    @NotNull
    @NotEmpty
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",message = "En az 8 karakter ve bir rakam olmalı")
    @ContainsStr(value = {"abc","123","1234","12345","qwerty"})
    private String password;

    public Person() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public String getUsername() {
        return this.username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String toString() {
        return "Person(firstName="
               + this.getFirstName()
               + ", lastName="
               + this.getLastName()
               + ", age="
               + this.getAge()
               + ", username="
               + this.getUsername()
               + ")";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwordParam) {
        password = passwordParam;
    }
}
