package com.merkez.training.spring.firstspring.person.facades;

import com.merkez.training.spring.firstspring.person.services.models.PersonDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PersonOperationFacade {

    public PersonDetails getPersonDetails(PersonDTO personDTOParam){
        // Rest Web
        // Soap Web
        return new PersonDetails();
    }
}
