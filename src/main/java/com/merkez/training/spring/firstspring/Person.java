package com.merkez.training.spring.firstspring;

import com.fasterxml.jackson.annotation.JsonProperty;

// POJO
// DTO
// @Data
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String username;

    public Person(String firstName,
                  String lastName,
                  int age,
                  String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.username = username;
    }

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
}
