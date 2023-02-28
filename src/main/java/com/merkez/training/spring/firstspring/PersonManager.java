package com.merkez.training.spring.firstspring;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
// @Lazy
public class PersonManager {
    private Map<String,Person> personMap = new HashMap<>();

    public PersonManager(){
        Person person = new Person();
        person.setUsername("user1");
        person.setFirstName("default");
        person.setLastName("default");
        person.setAge(20);
        addPerson(person);
    }

    public Person getPerson(String username){
        return  personMap.get(username);
    }

    public void addPerson(Person personParam){
        personMap.put(personParam.getUsername(), personParam);
    }

    public Map<String, Person> getPersonMap() {
        return personMap;
    }
}
