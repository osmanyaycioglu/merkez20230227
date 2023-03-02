package com.merkez.training.spring.firstspring.person.rest;

import com.merkez.training.spring.firstspring.person.rest.mappers.IPersonMapper;
import com.merkez.training.spring.firstspring.person.rest.models.Person;
import com.merkez.training.spring.firstspring.person.services.PersonQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/api/v1/person/query")
@Validated
public class PersonQueryController {

    private PersonQueryService personQueryService;

    @Autowired
    public PersonQueryController(PersonQueryService personQueryServiceParam) {
        personQueryService = personQueryServiceParam;
    }

    @GetMapping("/get/one")
    public Person getOne(@NotNull @Positive @RequestParam("pid") Long personId){
        return IPersonMapper.mapper.toPerson(personQueryService.findPerson(personId));
    }

    @GetMapping("/get/by/surname")
    public List<Person> getBySurname(@NotNull @NotEmpty @RequestParam("surname") String surname){
        return IPersonMapper.mapper.toPersons(personQueryService.findPersonByLastName(surname));
    }

    @GetMapping("/get/all")
    public List<Person> getAll(){
        return IPersonMapper.mapper.toPersons(personQueryService.findAllPersons());
    }

}
