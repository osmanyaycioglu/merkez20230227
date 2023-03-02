package com.merkez.training.spring.firstspring;

import com.merkez.training.spring.firstspring.person.rest.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Map;

@Component
public class UsePersonManagerWithFieldInjection  {

    @Autowired
    private PersonManager personManager;

    private PersonManager personManager2;

    @Autowired
    public void methodInjectionExample(PersonManager personManagerParam){
        personManager2 = personManagerParam;
    }

    @PostConstruct
    public void init(){
        Person person = new Person();
        person.setUsername("user4");
        person.setFirstName("ayşe");
        person.setLastName("alaz");
        person.setAge(30);
        personManager.addPerson(person);
    }

    @PreDestroy
    public void destroy(){
        System.out.println("UsePersonManagerWithFieldInjection öldürülüyor");
    }

    public void sayHelloToAll(){
        Map<String, Person> personMap = personManager.getPersonMap();
        for (Person value : personMap.values()) {
            System.out.println("Hello " + value.getFirstName() + " " + value.getLastName());
        }
    }

}
