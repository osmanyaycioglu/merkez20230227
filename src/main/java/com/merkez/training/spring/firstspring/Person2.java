package com.merkez.training.spring.firstspring;

public class Person2 {
    private String firstName;
    private String lastName;
    private int age;

    public Person2() {
    }

    public Person2(String firstNameParam,
                   String lastNameParam) {
        firstName = firstNameParam;
        lastName = lastNameParam;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstNameParam) {
        firstName = firstNameParam;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastNameParam) {
        lastName = lastNameParam;
    }

    @Override
    public String toString() {
        return "Person2{" +
               "firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               '}';
    }
}
