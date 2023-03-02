package com.merkez.training.spring.firstspring.person.services;

import com.merkez.training.spring.firstspring.person.data.PersonDataService;
import com.merkez.training.spring.firstspring.person.services.models.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonQueryService {

    private PersonDataService personDataService;
    @Autowired
    public PersonQueryService(PersonDataService personDataServiceParam) {
        personDataService = personDataServiceParam;
    }

    public PersonDTO findPerson(long personId){
        return personDataService.findPerson(personId);
    }

    public List<PersonDTO> findAllPersons(){
        return personDataService.findAllPersons();
    }

    public List<PersonDTO> findPersonByLastName(String lastName){
        return personDataService.findPersonByLastName(lastName);
    }

}
